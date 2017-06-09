package logic;

import java.util.ArrayList;

/**
 * @author SO - 2017
 *	Clase memoria encargada de administrar particiones, ejecucionesde procesos y particiones ociosas 
 */
public class Memoria implements Runnable{
	
	private int cantidadTotal;
	private ArrayList<Unidad> unidades;
	private ArrayList<Particion> ejecuciones;
	private ArrayList<Particion> ociosos; 
	private Thread thread;
	private boolean pausado, terminado;
	private ArrayList<Particion> novedades;
	
	public Memoria(int cantidadTotal) {
		super();
		this.cantidadTotal = cantidadTotal;
		
		this.unidades = new ArrayList<>();
		this.ejecuciones = new ArrayList<>();
		this.ociosos = new ArrayList<>();
		this.novedades = new ArrayList<>();
		
		this.terminado = false;
		this.pausado = true;
		
		this.crearUnidades();
		this.ejecutar();
	}
	
	public boolean agregarProceso(Proceso proceso){		
		if (!isMayorAMemoria(proceso.getTamano())){
			int posicionLibre = isEspacioLibre(proceso.getTamano()); 
			if(posicionLibre != -1){				
				this.agregarParticion(proceso, posicionLibre);
				
			} else {
				System.out.println("No se encontro espacio para el proceso ");
				return false;
			}
		} else {
			System.out.println("El proceso tiene más tamaño que la memoria total permitida");			
		}
		return false;
	}
	
	private void agregarParticion(Proceso proceso, int posicionLibre){
		
		if(this.isUltimaPosicion(posicionLibre)){
			
			
		} else {
			//no es la ultima posicion de la memoria
			
		}
		
	}
	
	/**
	 * @param posicion
	 * @return
	 */
	private boolean isUltimaPosicion(int posicion){
		return this.unidades.size()-1 == posicion ? true : false;
	}
	
	/**
	 *crea particiones de 1MB a partir del tamaño total (MB)  
	 */
	private void crearUnidades(){
		for (int i = 0; i < this.cantidadTotal; i++) {
			this.unidades.add(new Unidad(i));
		}
	}
	
	/**
	 * verifica que si hay memoria para un proceso en un espacio y retorna su posicion
	 * @return
	 */
	private int isEspacioLibre(int tamano){
		for (int i = 0; i < this.unidades.size(); i++) {
			
		}			
		return -1;
	}
	
	/**
	 * @param tamano
	 * @return
	 */
	private boolean isMayorAMemoria(int tamano){
		return tamano>this.cantidadTotal ? true : false;
	}


	
	private void actualizarOciosos(){
		ArrayList<Particion> ociososRecientes = new ArrayList<>();
		for (int i = 0; i < this.unidades.size(); i++) {
			if(!this.unidades.get(i).isOcupado()){
				int espacioDisponible = this.contarEspacioDisponible(i)+i;
				ociososRecientes.add(new Particion(i, espacioDisponible, espacioDisponible - i, true));
				i += espacioDisponible;
			}
		}
		
	}
	
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
	
	private void actualizarNovedadEjecuciones(){
		for (int i = 0; i < this.ejecuciones.size(); i++) {
			if(this.ejecuciones.get(i).algunaNovedad()){
				this.novedades.add(this.ejecuciones.get(i).obtener());				
			}
		}
	}
	
	private void borrarTerminado(Particion particion){
		for (int i = particion.getPosInicial(); i <= particion.getPosFinal(); i++) {
			this.unidades.get(i).desocupar();
		}
	}
	
	private Particion obtenerNovedad(){
		Particion aux = this.novedades.get(0);
		this.novedades.remove(0);
		return aux;
	}

	@Override
	public void run() {
		while(!this.terminado){
			if(!this.pausado){
				this.actualizarOciosos();
				//existe alfuna novedad de la lista de ejecucones para ntoificarle a gestion... si exiswte es porque ha terminado
				//entonces se debe borrar esos espacios de la lista de unidad
				this.actualizarNovedadEjecuciones();
				if(!this.novedades.isEmpty()){					
					this.borrarTerminado(this.obtenerNovedad());
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Pausado la memoria");
			}
		}
		
	}
	
	/**
     *Ejecutar hilo 
     */
    private void ejecutar() {
        thread = new Thread(this);
        thread.start();
    }
		
}
