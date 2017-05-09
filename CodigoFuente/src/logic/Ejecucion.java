package logic;

import com.sun.istack.internal.logging.Logger;

/**
 * Clase encargada de mantener un solo proceso en ejecucion con sus distintas
 * operaciones
 *
 * @author - SO2017
 */
public class Ejecucion implements Runnable {

	private String idProcesador;

	private Proceso proceso;

	private boolean pausado, finalizado;

	private int quantum;

	private int quantumActual;

	private Thread thread;

	private final static Logger LOGGER = Logger.getLogger(Ejecucion.class);

	/**
	 * Constructor sin parametros
	 */

	public Ejecucion(String numeroProcesador, int quantum) {
		super();

		this.idProcesador = numeroProcesador;

		this.quantum = quantum;

		this.proceso = null;

		this.pausado = true;
		this.finalizado = false;

		this.ejecutarHilo();

		this.LOGGER.info(this.idProcesador + " funcionando.");
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
		if (this.proceso != null) {
			return this.proceso.getNombre() + "-" + this.proceso.getTiempoEjecucionR() + "-" + this.quantumActual;
		} else {
			return "Ocioso" + "-" + "0" + "-" + "0";
		}
	}

	/**
	 * Agregar proceso a ejecutar
	 *
	 * @param proceso
	 */

	public void agregarProceso(Proceso proceso) {
		this.proceso = proceso;
		this.quantumActual = this.quantum;
		this.pausado = false;
		this.LOGGER.info(this.idProcesador + ": agregado el proceso: " + this.getNombre() + " tiempo de ejecuccion: "
				+ this.proceso.getTiempoEjecucionT());
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
	 *         termino su tiempo de ejecucion o su quantum a terminado
	 */
	public boolean algunaNovedad() {
		if (this.proceso != null) {
			if ((this.proceso.isBloqueado() == true) || (this.proceso.isTerminado() == true)
					|| (this.quantumAgotado() == true)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Pausar hilo
	 */
	public void pausar() {
		this.pausado = true;
	}

	/**
	 * terminar hilo
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

	/**
	 * 
	 * @return true si el quantum esta agotado, false si no lo esta.
	 */
	public boolean quantumAgotado() {
		if (this.quantumActual == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void run() {
		while (!this.finalizado) {
			if (!this.pausado) {
				this.proceso.admitir();
				while ((this.proceso != null) && (this.disminuirQuantumActual()) && (!this.proceso.isTerminado())
						&& (!this.proceso.isBloqueado())) {

					this.proceso.disminuirTiempoEjecucion();

					if (this.proceso.getTiempoEjecucionR() == 0) {
						this.proceso.setEstado(Estado.TERMINADO);
					} else if ((this.quantumAgotado()) && (this.proceso.getTiempoEjecucionR() > 0)) {
						this.proceso.setEstado(Estado.BLOQUEADO);
					} else if (this.quantumAgotado()) {
						this.proceso.setEstado(Estado.BLOQUEADO);
					}

					// System.out.println("Q: " + this.quantumActual + "
					// Proceso: " + this.proceso.getNombre()
					// + " no esta pausado y su estado es: " +
					// this.proceso.getEstado() + ", tiempo restante: "
					// + this.proceso.getTiempoEjecucionR());

					this.delay(1000);

				}

				this.pausado = true;
			}
			// this.delay(50);
			else {

				if (this.proceso != null) {
					System.out.println("pausado estado proceso " + this.proceso.getNombre() + ": " + this.isPausado());
				}
				this.delay(1000);

			}
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

	public int getQuantumActual() {
		return quantumActual;
	}

	public void setQuantumActual(int quantumActual) {
		this.quantumActual = quantumActual;
	}

	public String getIdProcesador() {
		return idProcesador;
	}

	public Proceso getProceso_2() {
		return this.proceso;
	}

}
