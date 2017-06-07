package logic;

/**
 * @author - SO2017
 *	Clase encargada de estar actualizando las respectivas listas
 *para los procesos listos, blosqueados y terminados
 */
public class Gestion implements Runnable {

    private ColaProcesos procesosListo, procesosTerminado;
    private boolean pausado;
    private Thread thread;
    private int numProcesos;
    private Memoria memoria;
    /**
     * constuctor
     * @param procesosListo para entrar a realizar las operaciones
     */
    public Gestion(Memoria memoria) {
        super();        
        this.memoria = memoria;
    }
    public void agregarColaProcesos(ColaProcesos procesosListo){
    	this.procesosListo = procesosListo;
        this.procesosTerminado = new ColaProcesos();

        this.numProcesos = this.procesosListo.getTamano(); 
        this.pausado = false;
        this.ejecutar();
    }
    /**
     * el hilo debe acabarse cuando el numero de procesos terminado sea igual al numero de procesos
     *
     * @return
     */
    public boolean isFinalizado() {
        return this.procesosTerminado.getTamano() == this.numProcesos;
    }
    /**
     * obtiene terminados
     * @return lista de terminados
     */
    public ColaProcesos getTerminados() {
        return this.procesosTerminado;
    }
    /**
     *compactar la memoria 
     */
    public void compactar(){
    	
    }
    @Override
    public void run() {
        while (!isFinalizado()) {
            if (!pausado) {
                if (!this.procesosListo.isVacia()) {                	
                	Proceso proceso = this.procesosListo.getProcesoAux();
                	if(this.memoria.agregarProceso(proceso)){
                		System.out.println("Se ha ACEPTADO siguiente proceso de gestion de memoria: "+proceso.getNombre()+" - "+proceso.getTamano());
                	} else {
                		System.out.println("Se ha RECHAZADO siguiente proceso de gestion de memoria: "+proceso.getNombre()+" - "+proceso.getTamano());
                	}
                	//this.procesosTerminado.agregar(proceso);
                } else {
                	System.out.println("La cola de procesos se vacio-- se debe esperar a que se llenen la cola de temrinandos");
                	this.pausado = true;
                }
                //sleep
                this.sleep2s();
            }else {
            	System.out.println("Pausada la gestion");
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
        System.out.println("ha terminadooooooo la gesiton");
    }
    /**
     *Ejecutar hilo 
     */
    private void ejecutar() {
        thread = new Thread(this);
        thread.start();
    }
 
    /**
     * asignar pausa
     * @param pausa true o false
     */
    public void setPausa (boolean pausa){
        this.pausado = pausa;
    }   
    /**
     * obtener valor de pausa
     * @return true o false
     */
    public boolean getPausa (){
        return this.pausado;
    }
    /**
     * retorn hilo
     * @return Thread
     */
    public Thread getThread() {
        return thread;
    }
	/**
	 * @return the memoria
	 */
	public Memoria getMemoria() {
		return memoria;
	}  
    /**
     *sleep para pausar dos segundos 
     */
    private void sleep2s(){
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
