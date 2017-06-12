package logic;

import java.util.ArrayList;

/**
 * @author SO - 2017
 *	Clase memoria encargada de administrar particiones, ejecuciones de procesos y particiones ociosas 
 */
public class Memoria implements Runnable{
	
	private int cantidadTotal;
	private ArrayList<Unidad> unidades;
	private ArrayList<Particion> ejecuciones;
	private ArrayList<Particion> ociosos; 
	private Thread thread;
	private boolean pausado, terminado;
	private ArrayList<Particion> novedades;
	private ColaProcesos procesosTerminados;
	
	public Memoria(int cantidadTotal) {
		super();
		this.cantidadTotal = cantidadTotal;
		
		this.unidades = new ArrayList<>();
		this.ejecuciones = new ArrayList<>();
		this.ociosos = new ArrayList<>();
		this.novedades = new ArrayList<>();
		this.procesosTerminados = new ColaProcesos();
		
		this.terminado = false;
		this.pausado = false;
		
		this.crearUnidades();
		this.ejecutar();
	}
	
	/**
	 * metodo para agregar  proceso debiendo el booleano correspondientes si existe
	 * espacio o no
	 * @param proceso
	 * @return
	 */
	public boolean agregarProceso(Proceso proceso){		
		if (!isMayorAMemoria(proceso.getTamano())){
			Particion particionOciosa = this.particionOciosaDisponible(proceso.getTamano()); 
			if(particionOciosa != null){
				int posInicialLibre = particionOciosa.getPosInicial();
				int posFinal = particionOciosa.getPosFinal();
				if(particionOciosa.getTamano() > proceso.getTamano()){
					posFinal = ( (posInicialLibre+proceso.getTamano()) - 1 );			
				}
				this.agregarOcupado(posInicialLibre, posFinal);					
				Particion particion = new Particion(posInicialLibre, posFinal, proceso.getTamano(), false);
				particion.agregarProceso(proceso);
				this.ejecuciones.add(particion);
				return true;
			} else {
				System.out.println("En el momento no se ecneuntra un espacio ocioso disponible");				
			}
		} else {
			System.out.println("El proceso tiene m�s tama�o que la memoria total permitida");			
		}
		return false;
	}
	/**
	 *compactar memroia 
	 */
	public void compactar() {
		for (int i = 0; i < this.ejecuciones.size(); i++) {
			if (i==0){
				this.quitarOcupado(this.ejecuciones.get(i).getPosInicial(),this.ejecuciones.get(i).getPosFinal());
				this.ejecuciones.get(i).setPosInicial(0);
				this.ejecuciones.get(i).setPosFinal(this.ejecuciones.get(i).getTamano());
				this.agregarOcupado(this.ejecuciones.get(i).getPosInicial(), this.ejecuciones.get(i).getPosFinal());
			} else {
				this.quitarOcupado(this.ejecuciones.get(i).getPosInicial(),this.ejecuciones.get(i).getPosFinal());
				int posInicial = this.ejecuciones.get(i-1).getPosFinal() + 1;
				this.ejecuciones.get(i).setPosInicial(posInicial);
				this.ejecuciones.get(i).setPosFinal(this.ejecuciones.get(i).getTamano() + posInicial);
				this.agregarOcupado(this.ejecuciones.get(i).getPosInicial(), this.ejecuciones.get(i).getPosFinal());
			}
		}
	}
    	
	/**
	 *crea particiones de 1MB a partir del tama�o total (MB)  
	 */
	private void crearUnidades(){
		for (int i = 0; i < this.cantidadTotal; i++) {
			this.unidades.add(new Unidad(i));
		}
	}
	
	/**
	 * verifica que si hay memoria para un proceso en un espacio ocisos y retorna su posicion inicial
	 * @return
	 */
	private Particion particionOciosaDisponible(int tamano){
		for (int i = 0; i < this.ociosos.size(); i++) {
			if(this.ociosos.get(i).getTamano() >= tamano){
				return this.ociosos.get(i);				
			}
		}
		return null;
	}
	
	/**
	 * @param tamano
	 * @return
	 */
	private boolean isMayorAMemoria(int tamano){
		return tamano>this.cantidadTotal ? true : false;
	}

	
	
	/**
	 *
	 * metodo se actualiza la lisata de ocsios, revisada unidad por unidad 
	 */
	private void actualizarOciosos(){
		ArrayList<Particion> ociososRecientes = new ArrayList<>();
		for (int i = 0; i < this.unidades.size(); i++) {
			if(!this.unidades.get(i).isOcupado()){
				if(!this.isUltimaPosicion(i)){
					int espacioDisponible = this.contarEspacioDisponible(i+1)+1; //+1 hace referencia al que ya se encontro desoucpado
					int posicionFinal = (i + espacioDisponible) - 1; 
					ociososRecientes.add(new Particion(i, posicionFinal, espacioDisponible, true));
					i = posicionFinal; // debido que al empezar el for vuelve a sumar uno					
				} else {
					ociososRecientes.add(new Particion(i, i, 1, true));
				}
			}
		}
		this.ociosos = ociososRecientes;
	}
	
	/**
	 * verifica si la posicion dada es la ultimaposicion
	 * @param posicion
	 * @return
	 */
	private boolean isUltimaPosicion(int posicion){
		return this.unidades.size()-1 == posicion;
	}
	
	/**
	 * cuenta el espacio disponible desde una posicion inicial
	 * @param posicionInicial
	 * @return
	 */
	private int contarEspacioDisponible(int posicionInicial){
		int contador = 0;
		for (int i = posicionInicial; i < this.unidades.size(); i++) {
			if(this.unidades.get(i).isOcupado()){
				return contador;
			}
			contador++;
		}
		return contador;
	}
	
	/**
	 *actualiza la lista de novedades desde la ejecuciones 
	 */
	private void actualizarNovedadEjecuciones(){
		for (int i = 0; i < this.ejecuciones.size(); i++) {
			if(this.ejecuciones.get(i).algunaNovedad()){
				this.novedades.add(this.ejecuciones.get(i).obtener());
				this.ejecuciones.get(i).terminarEjecucion();
				this.ejecuciones.remove(i);
			}
		}
	}
	
	/**
	 * agrega espacio ocupado desde una posicion incial a una final
	 * @param posInicial
	 * @param posFinal
	 */
	private void agregarOcupado(int posInicial, int posFinal){
		for (int i = posInicial; i <= posFinal; i++) {
			this.unidades.get(i).ocupar();
		}
	}
	
	/**
	 * quita espacio ocupado esde una posicion inicial a una final
	 * @param posInicial
	 * @param posFinal
	 */
	private void quitarOcupado(int posInicial, int posFinal){
		for (int i = posInicial; i <= posFinal; i++) {
			this.unidades.get(i).desocupar();;
		}
	}
	
	/**
	 * borra una particion terminada en la unidades
	 * @param particion
	 */
	private void borrarTerminado(Particion particion){
		for (int i = particion.getPosInicial(); i <= particion.getPosFinal(); i++) {
			this.unidades.get(i).desocupar();
		}
		this.procesosTerminados.agregar(particion.obtenerProceso());
	}
	
	/**
	 * obtiene una noveda de la particion
	 * @return
	 */
	private Particion obtenerNovedad(){
		Particion aux = this.novedades.get(0);
		this.novedades.remove(0);
		return aux;
	}
	
	/**
	 *metodo para imrpirmi ociosos 
	 */
	private void imprimirOciosos(){
		System.out.println("OCIOSOS");
		for (int i = 0; i < this.ociosos.size(); i++) {
			System.out.println("id "+(i+1)+" - pI: "+this.ociosos.get(i).getPosInicial()+" - pF: "+this.ociosos.get(i).getPosFinal()+" - tam: "+this.ociosos.get(i).getTamano());
		}
	}

	@Override
	public void run() {
		while(!this.terminado){
			if(!this.pausado){
				this.actualizarOciosos();
				this.imprimirOciosos();
				//existe alfuna novedad de la lista de ejecucones para ntoificarle a gestion... si exiswte es porque ha terminado
				//entonces se debe borrar esos espacios de la lista de unidad
				this.actualizarNovedadEjecuciones();
				if(!this.novedades.isEmpty()){					
					this.borrarTerminado(this.obtenerNovedad());
				}
				this.sleepMe(500);
			} else {
				System.out.println("Pausado la memoria");
				this.sleepMe(500);
			}
		}
		System.out.println("Terminada la memoria");
		
	}
	
	/**
	 * metodo sleep crecibiendo parametro ded  tiempo
	 * @param tiempo
	 */
	private void sleepMe(int tiempo){
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     *Ejecutar hilo 
     */
    private void ejecutar() {
        thread = new Thread(this);
        thread.start();
    }

	/**
	 * @return the procesosTerminados
	 */
	public ColaProcesos getProcesosTerminados() {
		return procesosTerminados;
	}
	  /**
     *pausar hilo 
     */
    public void pausar() {
        this.pausado = true;
    }
    /**
     *terminar hilo 
     */
    public void terminar() {
        this.terminado = true;
    }

    public ArrayList<Particion> getEjecuciones() {
        return ejecuciones;
    }

    public ArrayList<Particion> getOciosos() {
        return ociosos;
    }

	
    
    
		
}
