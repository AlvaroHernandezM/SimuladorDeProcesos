package logic;

import com.sun.istack.internal.logging.Logger;

/**
 * Clase encargada de mantener un solo proceso en ejecucion con sus distintas
 * operaciones
 * 
 * @author - SO2017
 */
public class Ejecucion implements Runnable {

	private int idProcesador;

	private Proceso proceso;

	private boolean pausado, finalizado;

	private int quantum;

	private int quantumActual;

	private Thread thread;

	// public String noticia, restante;

	private final static Logger LOGGER = Logger.getLogger(Ejecucion.class);

	/**
	 * Constructor sin parametros
	 */
	@SuppressWarnings("static-access")
	public Ejecucion(int numeroProcesador, int quantum) {
		super();

		this.idProcesador = numeroProcesador;

		this.quantum = quantum;

		this.proceso = null;

		this.pausado = true;
		this.finalizado = false;

		this.ejecutarHilo();

		this.LOGGER.info("Procesador " + this.idProcesador + " funcionando.");
	}

	/**
	 * Constructor recibiendo el proceso a ejecutar
	 * 
	 * @param proceso
	 */
	public Ejecucion(Proceso proceso) {
		super();
		this.proceso = proceso;
		this.pausado = false;
		this.finalizado = false;

		this.ejecutarHilo();
	}

	/**
	 * Obtener el proceso en ejecucion y deteniendo el hilo
	 * 
	 * @return proceso actual
	 */
	public Proceso getProceso() {
		this.pausado = true;
		return proceso;
	}

	/**
	 * Obtener la informacion del proceso en ejecucion
	 * 
	 * @return string con nombre y tiempo restante
	 */
	public String getInfoProceso() {
		return this.proceso.getNombre() + "-" + this.proceso.getTiempoEjecucionR();
	}

	/**
	 * Agregar proceso a ejecutar
	 * 
	 * @param proceso
	 */
	@SuppressWarnings("static-access")
	public void agregarProceso(Proceso proceso) {
		this.proceso = proceso;
		this.pausado = false;
		this.LOGGER.info("Procesador " + this.idProcesador + ": agregado el proceso: " + this.getNombre());
	}

	/**
	 * Metodo para avisar de un bloque, pero se limita a solo cambiar el estado
	 * del proceso.
	 *
	 * @param tiempo
	 */
	public void bloquear(int tiempo) {
		this.proceso.esperarSuceso(tiempo);
		this.pausado = true;
	}

	/**
	 * @return retorna true cuando el proceso ha sido bloqueado externamente o
	 *         termino su tiepo de ejecucion
	 */
	public boolean algunaNovedad() {
		if (this.proceso.isBloqueado() == true || this.proceso.isTerminado() == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Pausar hilo
	 */
	public void pausar() {
		this.pausado = true;
	}

	/**
	 * Terminar hilo
	 */
	public void terminar() {
		this.finalizado = true;
	}

	/**
	 * Obtener nombre
	 * 
	 * @return nombre del proceso
	 */
	public String getNombre() {
		return this.proceso.getNombre();
	}

	/**
	 * Disminuye en un segundo el valor del quantum actual.
	 * 
	 * @return true si aun queda tiempo de quantum, false si ya no queda tiempo.
	 */
	public boolean disminuirQuantumActual() {
		if (this.quantumActual != 0) {
			this.quantumActual--;
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {

		while (!this.finalizado) {
			if (!this.pausado) {

				this.proceso.admitir();

				while ((this.proceso != null) && (!this.proceso.isBloqueado()) && (!this.proceso.isTerminado())) {
					this.proceso.disminuirTiempoEjecucion();
					if (this.proceso.getEstado().equals(Estado.TERMINADO)) {
						this.pausado = true;
					}
					String restante = "Tiempo restante: " + this.proceso.getTiempoEjecucionR();
					System.out.println(
							"Procesador " + this.idProcesador + " " + this.proceso.getEstado() + " " + restante);
					this.delay(1000);
				}
			} else {

				System.out.println("Procesador " + this.idProcesador + " en ocioso.");

			}
			this.delay(400);
		}
	}

	/**
	 * Tiempo de espera entre cada ciclo.
	 */
	private void delay(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Ejecutar hilo
	 */
	private void ejecutarHilo() {
		this.thread = new Thread(this);
		this.thread.start();
	}

	/**
	 * Obtener hilo
	 * 
	 * @return hilo
	 */
	public Thread getThread() {
		return thread;
	}

	/**
	 * Verificar si esta finalizado
	 * 
	 * @return boolean
	 */
	public boolean isFinalizado() {
		return finalizado;
	}

	/**
	 * Asignar valor a finalizado
	 * 
	 * @param finalizado
	 *            true o false
	 */
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	/**
	 * Verificar si esta pausado
	 * 
	 * @return true o false
	 */
	public boolean isPausado() {
		return pausado;
	}

	/**
	 * Asignar pausa
	 * 
	 * @param pausado
	 *            true o false
	 */
	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}
}
