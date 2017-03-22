package logic;

public class Proceso {

	private String nombre;
	private int tiempoTotal, tiempoActual, 
				tiempoEjecucionR, tiempoEjecucionT, //R = Restante, T = Total 
				tiempoBloqueoR, tiempoBloqueoT; 
	private Estado estado;
	
	public Proceso(String nombre, int tiempoEjecucionT) {
		super();
		this.nombre = nombre;
		this.tiempoEjecucionT = tiempoEjecucionT;
		
		this.tiempoTotal = this.tiempoEjecucionT;
		this.tiempoActual = 0;
		this.tiempoEjecucionR = this.tiempoEjecucionT;
		this.tiempoBloqueoR = 0;
		this.tiempoBloqueoT = 0;
		this.estado = Estado.NUEVO;
	}
	
	public void admitir(){
		this.estado = Estado.LISTO;
	}
	
	/**
	 * @param quatum - cantidad de tiempo en segundos
	 * 					que la CPU le dedica a cada proceso
	 * @return - (cantidad CPU - cantidad Proceso) 
	 * 			con el fin de ifnromar la antidad de tiempo 
	 * 			que le sobrarìa al procesador o le faltaria
	 * 			 para ejecutar ese metodo
	 */
	public void ejecutar(){
		this.estado = Estado.EJECUCION;	
	}
	
	public void tiempoNoCompletado(){
		this.estado = Estado.LISTO;
	}
	
	public void esperarSuceso(int tiempoBloqueo){
		this.estado = Estado.BLOQUEADO;
		this.actualizarTiempoBloqueo(tiempoBloqueo);
		this.actualizarTiempoTotal();
	}
	
	public void ocurreSuceso(){
		this.estado = Estado.LISTO;
	}
	
	public void liberar(){
		this.estado = Estado.TERMINADO;
	}
	
	private void actualizarTiempoTotal(){
		this.tiempoTotal = this.tiempoBloqueoT + this.tiempoEjecucionT;
	}
	
	private void actualizarTiempoBloqueo(int tiempoBloqueo){
		this.tiempoBloqueoT += tiempoBloqueo;
		this.tiempoBloqueoR += tiempoBloqueo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTiempoTotal() {
		return tiempoTotal;
	}

	public int getTiempoActual() {
		return tiempoActual;
	}

	public int getTiempoEjecucionR() {
		return tiempoEjecucionR;
	}

	public int getTiempoEjecucionT() {
		return tiempoEjecucionT;
	}

	public int getTiempoBloqueoR() {
		return tiempoBloqueoR;
	}

	public int getTiempoBloqueoT() {
		return tiempoBloqueoT;
	}

	public Estado getEstado() {
		return estado;
	}
	
}
