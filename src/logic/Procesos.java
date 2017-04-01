package logic;

import gui.VentantaPrincipal;

public class Procesos implements Runnable {

	private ColaProcesos procesosListo, procesosTerminado;
	private Ejecucion ejecucion; // ejecucion de proceso
	private Proceso auxiliar; // proceso para el bloqueoo terminado
	private boolean pausado;
	private Thread thread;
	private int numProcesos; // numero de procesos ingresados
	// private int quantum; //tiempo de CPU dedicado para cada proceso
	private Bloqueo bloqueo;
	
	public String noticia;
	public VentantaPrincipal ventantaPrincipal;
	
	public boolean refrescar;

	public Procesos(ColaProcesos procesosListo) {
		super();
		this.procesosListo = procesosListo;
		this.numProcesos = this.procesosListo.getTamano(); // se obtiene el
															// numero de
															// procesos
		this.noticia = "";
		this.refrescar = false;

		this.ejecucion = new Ejecucion();
		this.bloqueo = new Bloqueo();
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
		return this.procesosListo.isVacia() && this.bloqueo.isVaciaBloqueados()
				&& (this.procesosTerminado.getTamano() == numProcesos);
	}

	private void verificarDesbloqueados() {

		ColaProcesos aux = this.bloqueo.getDesbloqueados();
		this.noticia = "TAMANoOOOO2:" + aux.getTamano();
		for (int i = 0; i < aux.getTamano(); i++) {
			this.procesosListo.agregar(aux.getProceso(i));
			this.noticia = "Se ha desbloqueado y agregado a listos " + (i + 1);
		}
		this.bloqueo.borrarDesbloqueados();
	}
	
	public ColaProcesos getBloqueados(){
		return this.bloqueo.getBloqueados();
	}

	@Override
	public void run() {

		while (!isFinalizado()) {

			if (!pausado) {
				if (!this.procesosListo.isVacia()) {
					this.ejecucion.agregarProceso(this.procesosListo.getProceso());
					this.noticia = "Extraccion proceso listo";
					
					this.refrescar = true;
					
					while (!this.ejecucion.algunaNovedad()) {
						this.verificarDesbloqueados();
						this.noticia = "Sigue en ejecucion - Esperando novedad";
						// if (this.ejecucion.getNombre().equals("p2")){
						// this.ejecucion.bloquear(3);
						// }
						// if (this.ejecucion.getNombre().equals("p4")){
						// this.ejecucion.bloquear(10);
						// }
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							this.noticia = e.getMessage();
						}
					}

					this.auxiliar = this.ejecucion.getProceso();
					this.noticia = "Obteniendo proceso al recibir novedad" + this.auxiliar.getNombre() + " "
							+ this.auxiliar.getEstado();

					if (this.auxiliar.isBloqueado()) {
						this.noticia = "BLOQUEADOO  " + this.auxiliar.getNombre();
						this.bloqueo.anadirBloqueo(this.auxiliar);

					} else if (this.auxiliar.isTerminado()) {
						this.noticia = "Ha terminado";
						this.procesosTerminado.agregar(this.auxiliar);
					}
					this.verificarDesbloqueados();
				} else {
					this.verificarDesbloqueados();
					try {
						Thread.sleep(400);
					} catch (Exception e) {
						this.noticia = e.getMessage();
					}

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
	
	public Bloqueo getBloqueo() {
		return this.bloqueo;
	}

	public void setBloqueo(Bloqueo bloqueo) {
		this.bloqueo = bloqueo;
	}
}
