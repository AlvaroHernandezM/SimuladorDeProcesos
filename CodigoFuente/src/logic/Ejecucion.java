package logic;

import com.sun.istack.internal.logging.Logger;

/**
 * Clase encargada de mantener un solo proceso en ejecucion con sus distintas
 * operaciones
 * 
 * @author - SO2017
 */
public class Ejecucion implements Runnable {
	
	private int numeroProcesador;

	private Proceso proceso;

	private boolean pausado, finalizado;

	private Thread thread;

	public String noticia, restante;
	
	private final static Logger LOGGER = Logger.getLogger(Procesos.class);

	/**
	 * Constructor sin aprametros
	 */
	public Ejecucion(int numeroProcesador) {
		super();
		
		this.numeroProcesador = numeroProcesador;
		
		this.proceso = null;
		
		this.pausado = true;
		this.finalizado = false;

		this.ejecutarHilo();
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
	public void agregarProceso(Proceso proceso) {
		this.proceso = proceso;
		if (this.pausado)
			this.pausado = false;
		this.LOGGER.info("Procesador " + this.numeroProcesador + ": agregado el proceso: " + this.getNombre());
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
		return this.proceso.isBloqueado() || this.proceso.isTerminado();
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

	@Override
	public void run() {
		this.noticia = "Inicio hilo Ejecucion";
		while (!this.finalizado) {
			this.noticia = "SSsperando";
			if (!this.pausado) {
				this.noticia = "Sin pausa";
				System.err.println(noticia);
				this.proceso.admitir();
				this.noticia = "Proceso adminitido: " + this.proceso.getNombre() + " - "
						+ this.proceso.getTiempoEjecucionR();
				while (!this.proceso.isBloqueado() && !this.proceso.isTerminado()) {
					this.proceso.disminuirTiempoEjecucion();
					this.restante = "Tiempo restante: " + this.proceso.getTiempoEjecucionR();
					try {
						Thread.sleep(1000); // 1 segundo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				System.err.println("pausa");
				this.noticia = "Pausado";
			}
			try {
				Thread.sleep(400); // 1 segundo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
}
