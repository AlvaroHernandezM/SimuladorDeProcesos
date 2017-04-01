package logic;

public class Ejecucion implements Runnable {

	private Proceso proceso;
	private boolean pausado, finalizado;
	private Thread thread;

	public String noticia;

	public Ejecucion() {
		super();
		this.pausado = true;
		this.finalizado = false;

		this.noticia = "";

		this.ejecutarHilo();
	}

	public Ejecucion(Proceso proceso) {
		super();
		this.proceso = proceso;
		this.pausado = false;
		this.finalizado = false;

		this.ejecutarHilo();
	}

	public Proceso getProceso() {
		this.pausado = true;
		return proceso;
	}

	public void agregarProceso(Proceso proceso) {
		this.proceso = proceso;
		this.pausado = false;
		this.noticia = "agregado el proceso: " + this.pausado;
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

	public void pausar() {
		this.pausado = true;
	}

	public void terminar() {
		this.finalizado = true;
	}

	@Override
	public void run() {
		this.noticia = "Inicio hilo Ejecucion";
		while (!this.finalizado) {
			this.noticia = "Esperando";
			if (!this.pausado) {
				this.noticia = "Sin pausa";
				this.proceso.admitir();
				this.noticia = "Proceso adminitido: " + this.proceso.getNombre() + " - "
						+ this.proceso.getTiempoEjecucionR();
				while (!this.proceso.isBloqueado() && !this.proceso.isTerminado()) {
					this.proceso.disminuirTiempoEjecucion();
					this.noticia = "Tiempo restante: " + this.proceso.getTiempoEjecucionR();
					try {
						Thread.sleep(1000); // 1 segundo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				this.noticia = "Pausado";
			}
		}
	}

	private void ejecutarHilo() {
		this.thread = new Thread(this);
		this.thread.start();
	}
}
