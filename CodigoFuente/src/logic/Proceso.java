package logic;

/**
 *
 * Clase proceso
 *
 * @author - SO2017
 */
public class Proceso {

	private String nombre;
	private int tiempoTotal, tiempoEjecucionR, tiempoEjecucionT, tiempoBloqueoR, tiempoBloqueoT, tiempoQuantum;
	// R = Restante,
	// T = Total
	private Estado estado;

	/**
	 * constructor
	 *
	 * @param nombre
	 * @param tiempoEjecucionT
	 */
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

	/**
	 * constructor sin parametros
	 */
	public Proceso() {
		super();
	}

	/**
	 * trancicion de adminito en el cual cambia su estado a LISTO
	 */
	public void admitir() {
		this.estado = Estado.LISTO;
	}

	/**
	 * ejecutar proceso cambiando su estado a e EJECUCION
	 */
	public void ejecutar() {
		this.estado = Estado.EJECUCION;
	}

	/**
	 * Restar tiempo a ejecucio mientras sea posible, cuando ya no cambia su
	 * estado a TERMINADO
	 */
	public void disminuirTiempoEjecucion() {
		if (this.tiempoEjecucionR != 0) {
			this.tiempoEjecucionR--;
		} else {
			this.estado = Estado.TERMINADO;
		}
	}

	/**
	 * Esperar suceso de bloque el cual cambia su estado y asigna el tiempo
	 * correspondiente
	 *
	 * @param tiempoBloqueo
	 *            en segundos para mantenerse en bloqueo
	 */
	public void esperarSuceso(int tiempoBloqueo) {
		this.actualizarTiempoBloqueo(tiempoBloqueo);
		this.actualizarTiempoTotal();
		this.estado = Estado.BLOQUEADO;
	}

	/**
	 * Restar tiempo a bloqueo restante mientras sea posible, cuando ya no
	 * cambia su estado a LISTO
	 */
	public void dimisnutirTiempoBloqueo() {
		if (this.tiempoBloqueoR != 0) {
			this.tiempoBloqueoR--;
		} else {
			this.estado = Estado.LISTO;
		}
	}

	/**
	 * Disminuye el tiempo de quantum en 1 si es igual a 0 cambia su estado a
	 * LISTO.
	 */
	public boolean disminuirTiempoQuantum() {
		if (this.tiempoQuantum != 0) {
			this.tiempoQuantum--;
			return true;
		} else {
			this.estado = Estado.BLOQUEADO;
			return false;
		}
	}

	/**
	 * Cuando se acaba el tiempo de bloqueo cambia su estado a LISTO
	 */
	public void ocurreSuceso() {
		this.tiempoBloqueoR = 0;
		this.estado = Estado.LISTO;
	}

	/**
	 * Liberando un proceso al cambiar su estado a terminado
	 */
	public void liberar() {
		if (this.tiempoBloqueoR == 0 && this.tiempoEjecucionR == 0) {
			this.estado = Estado.TERMINADO;
		} else {
			System.err.println("NO DEBE LIBERAR EL PROCESO AUN");
		}
	}

	/**
	 * verificar si esta bloqueado
	 *
	 * @return true o false
	 */
	public boolean isBloqueado() {
		return this.estado.compareTo(Estado.BLOQUEADO) == 0;
	}

	/**
	 * verificar si esta terminado
	 *
	 * @return true o false
	 */
	public boolean isTerminado() {
		return this.estado.compareTo(Estado.TERMINADO) == 0;
	}

	/**
	 * verificar si esta desbloqueado
	 *
	 * @return true o false
	 */
	public boolean isDesbloqueado() {
		return this.estado.compareTo(Estado.LISTO) == 0;
	}

	/**
	 * Actualizacion de tiempo total, sumando tiempo bloque total y tiempo
	 * ejecucion total
	 */
	private void actualizarTiempoTotal() {
		this.tiempoTotal = this.tiempoBloqueoT + this.tiempoEjecucionT;
	}

	/**
	 * Actualizando tiempo de bloqueo nuevo
	 *
	 * @param tiempoBloqueo
	 *            en segundos
	 */
	private void actualizarTiempoBloqueo(int tiempoBloqueo) {
		this.tiempoBloqueoT += tiempoBloqueo;
		this.tiempoBloqueoR += tiempoBloqueo;
	}

	/**
	 * obtener nombre
	 *
	 * @return nombre proceso
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * obteniendo tiempo total
	 *
	 * @return numero en segundos
	 */
	public int getTiempoTotal() {
		return tiempoTotal;
	}

	/**
	 * obteniendo tiempo ejecucion restante
	 *
	 * @return numero en segundos
	 */
	public int getTiempoEjecucionR() {
		return tiempoEjecucionR;
	}

	/**
	 * obteniendo tiempo ejecucion total
	 *
	 * @return numero en segundos
	 */
	public int getTiempoEjecucionT() {
		return tiempoEjecucionT;
	}

	/**
	 * obteniendo tiempo bloqueo restante
	 *
	 * @return numero en segundos
	 */
	public int getTiempoBloqueoR() {
		return tiempoBloqueoR;
	}

	/**
	 * obteniendo tiempo bloqueo total
	 *
	 * @return numero en segundos
	 */
	public int getTiempoBloqueoT() {
		return tiempoBloqueoT;
	}

	/**
	 * Obteniendo estado del proceso
	 *
	 * @return NUEVO,LISTO,EJECUCION,BLOQUEADO,TERMINADO
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * Obtiene el tiempo de quantum restante.
	 * 
	 * @return tiempo en segundos
	 */
	public int getTiempoQuantum() {
		return tiempoQuantum;
	}

	/**
	 * Define el tiempo del quantum para el proceso.
	 * 
	 * @param tiempoQuantum
	 */
	public void setTiempoQuantum(int tiempoQuantum) {
		this.tiempoQuantum = tiempoQuantum;
	}
}
