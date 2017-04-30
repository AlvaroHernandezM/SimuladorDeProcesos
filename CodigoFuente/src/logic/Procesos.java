package logic;

import java.util.ArrayList;
import java.util.logging.Level;

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

	private int numProcesos; // numero de procesos ingresados
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
		
		// Si esta sin parametros solo existe un procesador osea 1
		this.ejecucion = new Ejecucion(1);
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
	public Procesos(ColaProcesos procesosListo, int numeroProcesadores) {
		super();

		this.LOGGER.setLevel(Level.INFO);

		this.procesosListo = procesosListo;
		this.numeroProcesadores = numeroProcesadores;

		if (this.numeroProcesadores == 1) {
			this.ejecucion = new Ejecucion(this.numeroProcesadores);
		} else {
			this.procesadores = new ArrayList<Ejecucion>();
			for (int i = 0; i < this.numeroProcesadores; i++) {
				this.procesadores.add(new Ejecucion(i));
			}
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
	private void verificarDesbloqueados() {

		ColaProcesos aux = this.bloqueo.getDesbloqueados();

		if (aux != null) {

			this.noticia = "TAMANoOOOO2:" + aux.getTamano();
			for (int i = 0; i < aux.getTamano(); i++) {
				this.procesosListo.agregar(aux.getProceso(i));
				this.noticia = "Se ha desbloqueado y agregado a listos " + (i + 1);
			}
			this.bloqueo.borrarDesbloqueados();
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

	@Override
	public void run() {
		while (!this.isFinalizado()) {
			if (!this.pausado) {
				if (!this.procesosListo.isVacia()) {
					this.ejecucion.agregarProceso(this.procesosListo.getProceso());
					this.noticia = "Extraccion proceso listo";
					this.refrescar = true;
					while (!this.ejecucion.algunaNovedad()) {
						this.verificarDesbloqueados();
						this.noticia = "Sigue en ejecucion - Esperando novedad";
						this.refrescar = true;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							this.noticia = e.getMessage();
						}
					}
					this.refrescar = true;
					this.auxiliar = this.ejecucion.getProceso();
					this.noticia = "Obteniendo proceso al recibir novedad" + this.auxiliar.getNombre() + " "
							+ this.auxiliar.getEstado();
					if (this.auxiliar.isBloqueado()) {
						this.noticia = "BLOQUEADOO  " + this.auxiliar.getNombre();
						this.bloqueo.anadirBloqueo(this.auxiliar);
						this.refrescar = true;
					} else if (this.auxiliar.isTerminado()) {
						this.noticia = "Ha terminado";
						this.procesosTerminado.agregar(this.auxiliar);
						this.refrescar = true;
					}
					this.verificarDesbloqueados();
					this.refrescar = true;
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
		this.bloqueo.terminar();
		System.out.println("ha terminadooooooo");
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
}
