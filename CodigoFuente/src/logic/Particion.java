package logic;

/**
 * CLASE ENCARGADA DE MANEJAR CADA PARTICIÒN DE LA MEMORIA
 *
 */
public class Particion {
	
	private int posInicial, posFinal, tamano;
	private Ejecucion ejecucion;
	private boolean restriccion; //restriccion de recibir un proceso (true - particion ociossa)
	
	/**
	 * @param posInicial
	 * @param posFinal
	 * @param tamano
	 */
	public Particion(int posInicial, int posFinal, int tamano, boolean restriccion) {
		super();
		this.posInicial = posInicial;
		this.posFinal = posFinal;
		this.tamano = tamano;
		this.restriccion = restriccion;
	}
	
	public void agregarProceso(Proceso proceso){
		if(!this.restriccion) {
			this.ejecucion = new Ejecucion(proceso);
		} else {
			System.out.println("No se puede agregar a esta particion");
		}
	}
	
	public boolean algunaNovedad(){
		return this.ejecucion.algunaNovedad();
	}
	
	public Particion obtener(){
		return this;
	}

	/**
	 * @return the posInicial
	 */
	public int getPosInicial() {
		return posInicial;
	}

	/**
	 * @return the posFinal
	 */
	public int getPosFinal() {
		return posFinal;
	}

	/**
	 * @return the tamano
	 */
	public int getTamano() {
		return tamano;
	}
	
	
}
