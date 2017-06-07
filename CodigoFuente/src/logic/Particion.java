package logic;

/**
 * CLASE ENCARGADA DE MANEJAR CADA PARTICIÒN DE LA MEMORIA
 *
 */
public class Particion {
	
	private int tamano;
	private boolean ocupado;
	private Ejecucion ejecucion;
	
	
	public Particion(Proceso proceso){
		this.ocupado = true;
		this.tamano = proceso.getTamano();
		this.ejecucion = new Ejecucion();
		this.ejecucion.agregarProceso(proceso);		
	}
	
	public Particion(int tamano){
		this.ocupado = false;
		this.tamano = tamano;		
		this.ejecucion = new Ejecucion();
	}
	
	public void agregarProceso(Proceso proceso){
		this.ocupado = true;
		this.tamano = proceso.getTamano();
		this.ejecucion.agregarProceso(proceso);		
	}
	
	

	/**
	 * @param ocupado the ocupado to set
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public boolean isOcupado() {
		return ocupado;
	}


}
