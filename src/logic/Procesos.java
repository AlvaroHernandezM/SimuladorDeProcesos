package logic;

public class Procesos implements Runnable {

	private ColaProcesos procesosListo, procesosBloqueado, procesosTerminado;
	private Ejecucion ejecucion;
	private Proceso auxiliar;
	private boolean pausado;
	private Thread thread;
	private int numProcesos; // numero de procesos ingresados
	// private int quantum; //tiempo de CPU dedicado para cada proceso
	public String noticia;

	public Procesos(ColaProcesos procesosListo) {
		super();
		this.procesosListo = procesosListo;
		this.numProcesos = this.procesosListo.getTamano(); // se obtiene el
															// numero de
															// procesos
		this.noticia = "";

		this.ejecucion = new Ejecucion();
		this.procesosBloqueado = new ColaProcesos();
		this.procesosTerminado = new ColaProcesos();
		this.pausado = false;
		this.auxiliar = new Proceso();
		this.ejecutar();
	}

	private void ejecutar() {
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * bloquea el proceso que se encuentra en ejecucion, asignandole el tiempo
	 * 
	 * @param tiempo
	 */
	public void bloquear(int tiempo) {
		this.ejecucion.bloquear(tiempo);
	}

	/**
	 * el hilo debe acabarse cuando la proceso de listos y bloqueados este
	 * vacia, y el numero de procesos terminado sea igual al numero de procesos
	 * 
	 * @return
	 */
	private boolean isFinalizado() {
		return this.procesosListo.isVacia() && this.procesosBloqueado.isVacia()
				&& (this.procesosTerminado.getTamano() == numProcesos);
	}

	@Override
	public void run() {
		while (!isFinalizado()) {
			if (!pausado) {
				this.ejecucion.agregarProceso(this.procesosListo.getProceso(0));
				this.noticia = "Extraccion proceso listo";
				while (!this.ejecucion.algunaNovedad()) {
					this.noticia = "Sigue en ejecucion - Esperando novedad";
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				this.auxiliar = this.ejecucion.getProceso();
				this.noticia = "Obteniendo proceso al recibir novedad";
				if (this.auxiliar.isBloqueado()) {
					this.noticia = "BLOQUEAR"; // aca va la parte de bloquear
												// que falta
				} else if (this.auxiliar.isTerminado()) {
					this.noticia = "A terminado";
					this.procesosTerminado.agregar(this.auxiliar);
				}
			} else {
				this.ejecucion.pausar();
				this.noticia = "Pausado ejecucion";
			}
		}
		this.noticia = "Terminado ejecucion";
		this.ejecucion.terminar();
	}

	public Ejecucion getEjecucion() {
		return ejecucion;
	}

	public void setEjecucion(Ejecucion ejecucion) {
		this.ejecucion = ejecucion;
	}

}
