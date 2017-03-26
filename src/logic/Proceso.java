package logic;

public class Proceso {

	private String nombre;
	private int tiempoTotal, 
				tiempoEjecucionR, tiempoEjecucionT, //R = Restante, T = Total 
				tiempoBloqueoR, tiempoBloqueoT; 
	private Estado estado;
	
	public Proceso(String nombre, int tiempoEjecucionT) {
		super();
		this.nombre = nombre;
		this.tiempoEjecucionT = tiempoEjecucionT;
		
		this.tiempoTotal = this.tiempoEjecucionT;
		this.tiempoEjecucionR = this.tiempoEjecucionT;
		this.tiempoBloqueoR = 0;
		this.tiempoBloqueoT = 0;
		this.estado = Estado.NUEVO;
	}
	
	public Proceso(){
		super();
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
	
	public void disminuirTiempoEjecucion(){
		if (this.tiempoEjecucionR!=0)
			this.tiempoEjecucionR--;
		else
			this.estado = Estado.TERMINADO;
	}
	
//	public void tiempoNoCompletado(){
//		this.estado = Estado.LISTO;
//	}
	
	public void esperarSuceso(int tiempoBloqueo){
		this.actualizarTiempoBloqueo(tiempoBloqueo);
		this.actualizarTiempoTotal();
		this.estado = Estado.BLOQUEADO;
	}
	
	public void dimisnutirTiempoBloqueo(){
		this.tiempoBloqueoR--;
	}
	
	public void ocurreSuceso(){
		this.tiempoBloqueoR = 0;
		this.estado = Estado.LISTO;
	}
	
	public void liberar(){
		if(this.tiempoBloqueoR == 0 && this.tiempoEjecucionR == 0)
			this.estado = Estado.TERMINADO;					
		else 
			System.err.println("NO DEBE LIBERAR EL PROCESO AUN");
	}
	
	public boolean isBloqueado(){
		return this.estado.compareTo(Estado.BLOQUEADO) == 0;
	}
	
	public boolean isTerminado(){
		return this.estado.compareTo(Estado.TERMINADO) == 0;
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
