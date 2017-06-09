package logic;

/**
 * CLASE ENCARGADA DE MANEJAR CADA UNIDAD DE 1MB  DE LA MEMORIA
 *
 */
public class Unidad {
	
	private int direccion;
	private boolean ocupado;
	
	public Unidad(int direccion){
		this.ocupado = false;
		this.direccion = direccion;
		
	}

	public void agregarProceso(){
		this.ocupado = true;
	}
	
	public void desocupar(){
		this.ocupado = false;
	}
	
	/**
	 * @param ocupado the ocupado to set
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	/**
	 * @return ocupado
	 */
	public boolean isOcupado() {
		return ocupado;
	}

	/**
	 * @return the direccion
	 */
	public int getDireccion() {
		return direccion;
	}
	
}
