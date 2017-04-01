package logic;



public class Procesos implements Runnable{
	
	private ColaProcesos procesosListo, procesosBloqueado, procesosTerminado;
	private Ejecucion ejecucion; //ejecucion de proceso
	private Proceso auxiliar; //proceso para el bloqueo
	private boolean pausado;
	private Thread thread;
	private int numProcesos; //numero de procesos ingresados
	private Bloqueo bloqueo;
	//private int quantum; //tiempo de CPU dedicado para cada proceso
	
	public Procesos(ColaProcesos procesosListo) {
		super();
		this.procesosListo = procesosListo;
		this.numProcesos = this.procesosListo.getTamano(); //se obtiene el numero de procesos
		
		this.ejecucion = new Ejecucion();
		this.bloqueo = new Bloqueo();
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
	
	private void verificarDesbloqueados (){

		ColaProcesos aux = this.bloqueo.getDesbloqueados();
		System.out.println("TAMANoOOOO2:"+aux.getTamano());
		for (int i = 0; i < aux.getTamano(); i++) {
			this.procesosListo.agregar(aux.getProceso(i));
			System.out.println("Se ha desbloqueado y agregado a listos "+(i+1));
		}
		this.bloqueo.borrarDesbloqueados();
	}

	@Override
	public void run() {
		
		
		
		while(!isFinalizado()){
			
			if(!pausado){
				if (!this.procesosListo.isVacia()){
					this.ejecucion.agregarProceso(this.procesosListo.getProceso());
					System.out.println("extraccion proceso listo");
					while(!this.ejecucion.algunaNovedad()){
						this.verificarDesbloqueados();
						System.out.println("sigue en ejecucion -esperando novedad");
//						if (this.ejecucion.getNombre().equals("p2")){
//							this.ejecucion.bloquear(3);
//						}
//						if (this.ejecucion.getNombre().equals("p4")){
//							this.ejecucion.bloquear(10);
//						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
						}
					}
					
					this.auxiliar = this.ejecucion.getProceso();
					System.err.println("obteniendo proceso al recibir novedad" + this.auxiliar.getNombre() +" "  + this.auxiliar.getEstado());
					
					if (this.auxiliar.isBloqueado()){				
						System.err.println("BLOQUEADOO  " + this.auxiliar.getNombre() ); // aca va la parte de bloquear que falta
						
						this.bloqueo.añadirBloqueo(this.auxiliar);


		
					} else if(this.auxiliar.isTerminado()) {
						System.out.println("ha terminado");
						this.procesosTerminado.agregar(this.auxiliar);	
					}
					this.verificarDesbloqueados();
				}else{
					this.verificarDesbloqueados();
					try{
						Thread.sleep(400);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				
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
