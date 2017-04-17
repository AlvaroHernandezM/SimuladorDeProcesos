package logic;

/**
 * Clase encargada de mantener un solo proceso en ejecucion con sus distintas
 * operaciones
 * 
 * @author - SO2017
 */
public class Ejecucion implements Runnable {

	private Proceso proceso;
	private int quantum;
	private boolean pausado, finalizado;
	private Thread thread;
	public String noticia, restante;

	/**
	 * constructor sin aprametros
	 */
	public Ejecucion(int quantum) {
		super();
		this.quantum = quantum;
		this.pausado = true;
		this.finalizado = false;
		this.noticia = "";
		this.ejecutarHilo();
	}

	/**
	 * Constructor recibiendo el proceso a ejecutar
	 * 
	 * @param proceso
	 */
	public Ejecucion(Proceso proceso, int quantum) {
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
		return this.proceso.getNombre() + "-" + this.proceso.getTiempoEjecucionR() + "-"
				+ this.proceso.getTiempoQuantum();
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
		this.noticia = "agregado el proceso: " + this.getNombre();
	}

	/**
	 * metodo para avisar de un bloque, pero se limita a solo cambiar el estado
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
	 * pausar hilo
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

	@Override
	public void run() {
		this.noticia = "Inicio hilo Ejecucion";
		while (!this.finalizado) {
			this.noticia = "SSsperando";
			if (!this.pausado) {
				this.noticia = "Sin pausa";
				System.err.println(noticia);
				this.proceso.admitir();

				this.proceso.setTiempoQuantum(this.quantum);

				this.noticia = "Proceso adminitido: " + this.proceso.getNombre() + " - "
						+ this.proceso.getTiempoEjecucionR();
				while (!this.proceso.isBloqueado() && !this.proceso.isTerminado()) {
					this.proceso.disminuirTiempoEjecucion();
					if (!this.proceso.disminuirTiempoQuantum()) {
						System.out.println("reinicia quantum" + this.proceso.getTiempoQuantum());
						this.proceso.setTiempoQuantum(this.quantum);
					}

					System.out.println("q:" + this.proceso.getTiempoQuantum());
					System.out.println("qEjec" + this.quantum);

					this.restante = "Tiempo restante: " + this.proceso.getTiempoEjecucionR();
					try {
						Thread.sleep(1000); // 1 segundo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				this.proceso.setTiempoQuantum(this.quantum);
				System.out.println("qFueraWhile:" + this.proceso.getTiempoQuantum());

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
	 * ejecutar hilo
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
	 * asignar pausa
	 * 
	 * @param pausado
	 *            true o false
	 */
	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}
}
