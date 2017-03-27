package logic;



public class Procesos implements Runnable{
	
	private ColaProcesos procesosListo, procesosBloqueado, procesosTerminado;
	private Ejecucion ejecucion;
	private Proceso auxiliar;
	private boolean pausado;
	private Thread thread;
	private int numProcesos; //numero de procesos ingresados
	//private int quantum; //tiempo de CPU dedicado para cada proceso
	
	public Procesos(ColaProcesos procesosListo) {
		super();
		this.procesosListo = procesosListo;
		this.numProcesos = this.procesosListo.getTamano(); //se obtiene el numero de procesos
		
		this.ejecucion = new Ejecucion();
		this.procesosBloqueado = new ColaProcesos();
		this.procesosTerminado = new ColaProcesos();
		this.pausado = false;
		this.auxiliar = new Proceso();
		this.ejecutar();
	}
	
	private void ejecutar(){
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * bloquea el proceso que se encuentra en ejecucion, asignandole el tiempo
	 * @param tiempo
	 */
	public void bloquear(int tiempo){
		this.ejecucion.bloquear(tiempo);
	}
	
	/**
	 * el hilo debe acabarse cuando la proceso de listos y bloqueados este vacia, y  
	 * el numero de procesos terminado sea igual al numero de procesos
	 * @return
	 */
	private boolean isFinalizado(){
		return this.procesosListo.isVacia() && this.procesosBloqueado.isVacia() && (this.procesosTerminado.getTamano() == numProcesos);
	}

	@Override
	public void run() {
		while(!isFinalizado()){
			if(!pausado){
				this.ejecucion.agregarProceso(this.procesosListo.getProceso());
				System.out.println("extraccion proceso listo");
				while(!this.ejecucion.algunaNovedad()){
					System.out.println("sigue en ejecucion -esperando novedad");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				this.auxiliar = this.ejecucion.getProceso();
				System.out.println("obteniendo proceso al recibir novedad");
				if (this.auxiliar.isBloqueado()){				
					System.out.println("BLOQUEAR"); // aca va la parte de bloquear que falta
				} else if(this.auxiliar.isTerminado()) {
					System.out.println("ha terminado");
					this.procesosTerminado.agregar(this.auxiliar);					
				}
			} else {
				this.ejecucion.pausar();
				System.out.println("Pausado ejecucion");
			}
		}
		System.out.println("Terminado ejecucion");
		this.ejecucion.terminar();
	}

	
}
