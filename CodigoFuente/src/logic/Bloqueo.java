package logic;

import com.sun.istack.internal.logging.Logger;

/**
 * Clase encargada del bloqueo el cual sera un hilo que estara pendiente de los
 * procesos que entre a bloqueo y los desbloqueados
 * 
 * @author - SO2017
 */
public class Bloqueo implements Runnable {

	private Thread thread;
	private ColaProcesos lista, desbloqueados;
	private boolean pausado, terminado;
	
	private final static Logger LOGGER = Logger.getLogger(Ejecucion.class);

	/**
	 * constructor
	 */
	public Bloqueo() {
		
		super();

		this.pausado = true;
		this.terminado = false;
		this.lista = new ColaProcesos();
		this.desbloqueados = new ColaProcesos();

		this.ejecutarHilo();
	}

	/**
	 * Agregar proceso en la lista de bloqueo y despausar en caso de lo que
	 * estuviera
	 * 
	 * @param proceso
	 *            que entrara ser bloqueado
	 */
	public void anadirBloqueo(Proceso proceso) {
		this.lista.agregar(proceso);
		this.LOGGER.info("Proceso " + proceso.getNombre() + " bloqueado por " + proceso.getTiempoBloqueoT());
		if (this.pausado)
			this.pausado = false;
	}

	/**
	 * Asigna valor verdadero a variable terminado
	 */
	public void terminar() {
		this.terminado = true;
	}

	/**
	 * Recorre la lista actual y retorna aquellos procesos que se encuentra en
	 * estado bloqueado
	 * 
	 * @return Lista de proceso bloqueados
	 */
	public ColaProcesos getBloqueados() {
		ColaProcesos aux = new ColaProcesos();
		for (int i = 0; i < this.lista.getTamano(); i++) {
			if (this.lista.getProceso(i).isBloqueado()) {
				aux.agregar(this.lista.getProceso(i));
			}
		}
		return aux;
	}

	/**
	 * Recorre la lista actual y retorna aquellos procesos que se encuentra en
	 * estado desbloqueado
	 * 
	 * @return Lista de proceso desbloqueados o null
	 */
	public ColaProcesos getDesbloqueados() {
		for (int i = 0; i < this.lista.getTamano(); i++) {
			if (this.lista.getProceso(i).isDesbloqueado()) {
				Proceso aux = this.lista.getProceso(i);
				this.lista.borrar(i);
				this.desbloqueados.agregar(aux);
			}
		}
		if (!this.desbloqueados.isVacia()) {
			ColaProcesos aux = this.desbloqueados;
			return aux;
		} else {
			return null;
		}
	}

	/**
	 * elimina la lista de desbloqueados
	 */
	public void borrarDesbloqueados() {
		this.desbloqueados.clearAll();
	}

	@Override
	public void run() {
		while (!terminado) {
			if (!pausado) {
				if (!this.lista.isVacia()) {
					for (int i = 0; i < lista.getTamano(); i++) {
						this.lista.getProceso(i).dimisnutirTiempoBloqueo();
						System.err.println("tiempo bloqueo " + this.lista.getProceso(i).getTiempoBloqueoR());
					}
					try {
						Thread.sleep(700); // 1 segundo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
//				System.out.println("esperando");
			}
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Ejecutar el hilo
	 */
	private void ejecutarHilo() {
		this.thread = new Thread(this);
		this.thread.start();
	}

	/**
	 * @return el hilo en ejecucion
	 */
	public Thread getThread() {
		return thread;
	}
}
