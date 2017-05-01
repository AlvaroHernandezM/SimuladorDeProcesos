package logic;

import java.util.ArrayList;

import com.sun.istack.internal.logging.Logger;

/**
 * Clase encargada de estar actualizando las respectivas listas para los
 * procesos listos, blosqueados y terminados
 *
 * @author - SO2017
 */
public class Procesos implements Runnable {

	private ColaProcesos procesosListo;
	private ColaProcesos procesosBloqueado;
	private ColaProcesos procesosTerminado;

	private Proceso auxiliar; // Proceso para el bloqueo

	private boolean pausado;
	public boolean refrescar;

	private Thread thread;

	private int numProcesos; // Numero de procesos ingresados
	private int numeroProcesadores;// Numero de procesadores
	private int quantum; // Tiempo de CPU dedicado para cada proceso

	private Bloqueo bloqueo;

	public String noticia;

	private Ejecucion ejecucion; // Ejecucion de proceso
	private ArrayList<Ejecucion> procesadores;

	private final static Logger LOGGER = Logger.getLogger(Procesos.class);

	/**
	 * Constuctor
	 *
	 * @param procesosListo
	 *            para entrar a realizar las operaciones
	 */
	public Procesos(ColaProcesos procesosListo) {
		super();

		this.procesosListo = procesosListo;
		this.numProcesos = this.procesosListo.getTamano();

		this.noticia = "";
		this.refrescar = false;

		this.quantum = 20; // Default quantum 20 segundos

		// Si esta sin parametros solo existe un procesador osea 1
		this.procesadores = new ArrayList<Ejecucion>();
		this.procesadores.add(this.ejecucion = new Ejecucion(1, this.quantum));

		this.bloqueo = new Bloqueo();

		this.procesosBloqueado = new ColaProcesos();
		this.procesosTerminado = new ColaProcesos();

		this.pausado = false;

		this.auxiliar = new Proceso();

		this.ejecutar();
	}

	/**
	 * Constructor, si el numero de procesarodes es igual a 1 el comportamiento
	 * es igual al del simulador 1.
	 * 
	 * @param procesosListo
	 *            para entrar a realizar las operaciones.
	 * @param numeroProcesadores
	 *            con el que se va a realizar la simulacion.
	 */
	public Procesos(ColaProcesos procesosListo, int numeroProcesadores, int quantum) {
		super();

		this.procesosListo = procesosListo;

		this.numeroProcesadores = numeroProcesadores;

		this.quantum = quantum;

		this.procesadores = new ArrayList<Ejecucion>();

		// Crea el numero de procesadores para la ejecuccion.
		for (int i = 0; i < this.numeroProcesadores; i++) {
			this.procesadores.add(new Ejecucion((i + 1), this.quantum));
		}

		this.numProcesos = this.procesosListo.getTamano();

		this.refrescar = false;
		this.pausado = false;

		this.bloqueo = new Bloqueo();

		this.procesosBloqueado = new ColaProcesos();
		this.procesosTerminado = new ColaProcesos();

		this.auxiliar = new Proceso();

		this.ejecutar();
	}

	/**
	 * Bloquea el proceso que se encuentra en ejecucion, asignandole el tiempo
	 *
	 * @param tiempo
	 */
	public void bloquear(int tiempo) {
		this.ejecucion.bloquear(tiempo);
		this.refrescar = true;
	}

	/**
	 * El hilo debe acabarse cuando la cola procesos de listos y bloqueados este
	 * vacia, y el numero de procesos terminado sea igual al numero de procesos
	 *
	 * @return
	 */
	public boolean isFinalizado() {
		return this.procesosListo.isVacia() && this.procesosBloqueado.isVacia()
				&& (this.procesosTerminado.getTamano() == numProcesos);
	}

	/**
	 * Verifica que ya hayan desbloqueados desde la Clase Bloqueo
	 */
	@SuppressWarnings("static-access")
	private void verificarDesbloqueados() {
		ColaProcesos aux = this.bloqueo.getDesbloqueados();
		if (aux != null) {
			for (int i = 0; i < aux.getTamano(); i++) {
				this.procesosListo.agregar(aux.getProceso(i));
				this.LOGGER.info(
						"El proceso " + aux.getProceso(i).getNombre() + "Se ha desbloqueado y se a agregado a listos");
			}
			this.bloqueo.borrarDesbloqueados();
		}
	}

	/**
	 * Verifica que no hayan procesos terminados en los procesadores.
	 */
	private void verificarProcesadores() {
		for (int i = 0; i < this.numeroProcesadores; i++) {
			if (this.procesadores.get(i).getProceso().getEstado().equals(Estado.TERMINADO)) {
				Proceso procesoAuxiliar = this.procesadores.get(i).getProceso();
				if (procesoAuxiliar != null) {
					this.procesosTerminado.agregar(procesoAuxiliar);
					this.procesadores.get(i).setProceso(null);
				}
			}
		}
	}

	/**
	 * Obtiene bloqueados
	 *
	 * @return lista de bloqueados
	 */
	public ColaProcesos getBloqueados() {
		return this.bloqueo.getBloqueados();
	}

	/**
	 * Obtiene terminados
	 *
	 * @return lista de terminados
	 */
	public ColaProcesos getTerminados() {
		return this.procesosTerminado;
	}

	/**
	 * Pausa la ejecuccion en todos los procesadores.
	 */
	@SuppressWarnings("static-access")
	public void pausarEjecucion() {
		for (int i = 0; i < this.procesadores.size(); i++) {
			this.procesadores.get(i).pausar();
		}
		this.LOGGER.info("Toda la ejecuccion pausada");
	}

	/**
	 * Termina la ejecuccion en todos los procesadores
	 */
	@SuppressWarnings("static-access")
	public void terminarEjecuccion() {
		for (int i = 0; i < this.procesadores.size(); i++) {
			this.procesadores.get(i).terminar();
		}
		this.bloqueo.terminar();
		this.LOGGER.info("Ejecuccion terminada");
	}

	/**
	 * Administra la ejecuccion de los procesos en los procesadores que estan
	 * ociosos y les asigna un proceso para cada uno en caso de no tener uno.
	 * 
	 */
	private void administrarProcesadores() {

		for (int i = 0; i < this.numeroProcesadores; i++) {
			if ((this.procesadores.get(i).getProceso() == null) && (this.procesosListo.getTamano() > 0)) {
				this.procesadores.get(i).agregarProceso(this.procesosListo.getProceso());
			}
		}

		for (int i = 0; i < this.numeroProcesadores; i++) {
			this.verificarDesbloqueados();
			if ((this.procesadores.get(i).algunaNovedad())) {

				this.auxiliar = this.procesadores.get(i).getProceso();

				if (this.auxiliar.isTerminado()) {

					this.procesosTerminado.agregar(this.auxiliar);
					this.procesadores.get(i).setProceso(null);

				} else if (this.auxiliar.isBloqueado()) {

					this.bloqueo.anadirBloqueo(this.auxiliar);
					this.procesadores.get(i).setProceso(null);
				}
			}
		}

	}

	@Override
	public void run() {

		while (!this.isFinalizado()) {
			System.out.println(this.procesosTerminado.getTamano());

			if (!this.pausado) {
				if (!this.procesosListo.isVacia()) {

					this.verificarDesbloqueados();

					this.administrarProcesadores();

					this.verificarDesbloqueados();

					this.delay(400);

				} else {

					this.verificarDesbloqueados();

					this.verificarProcesadores();

					this.delay(400);
				}
			} else {

				this.pausarEjecucion();
			}
		}

		this.terminarEjecuccion();
	}

	/**
	 * Tiempo de espera entre revisiones.
	 */
	@SuppressWarnings("static-access")
	private void delay(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (Exception e) {
			this.LOGGER.warning(e.getMessage());
		}
	}

	/**
	 * Ejecutar hilo
	 */
	private void ejecutar() {
		this.thread = new Thread(this);
		this.thread.start();
	}

	/**
	 * Obtiendo ejecucion
	 *
	 * @return
	 */
	public Ejecucion getEjecucion() {
		return ejecucion;
	}

	/**
	 * Asignar ejecucion
	 *
	 * @param ejecucion
	 */
	public void setEjecucion(Ejecucion ejecucion) {
		this.ejecucion = ejecucion;
	}

	/**
	 * Asignar pausa
	 *
	 * @param pausa
	 *            true o false
	 */
	public void setPausa(boolean pausa) {
		this.pausado = pausa;
	}

	/**
	 * Obtener valor de pausa
	 *
	 * @return true o false
	 */
	public boolean getPausa() {
		return this.pausado;
	}

	/**
	 * Conocer clase bloqueo
	 *
	 * @return Bloqueo
	 */
	public Bloqueo getBloqueo() {
		return bloqueo;
	}

	/**
	 * Return hilo
	 *
	 * @return Thread
	 */
	public Thread getThread() {
		return thread;
	}

	/**
	 * Obtiene el valor del quantum.
	 * 
	 * @return valor entero que representa el quantum de procesador en segundos.
	 */
	public int getQuantum() {
		return quantum;
	}

	/**
	 * Asigna un valor al quantum
	 * 
	 * @param quantum
	 */
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
}
