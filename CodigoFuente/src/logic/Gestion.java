package logic;

/**
 * @author - SO2017 Clase encargada de estar actualizando las respectivas listas
 * para los procesos listos, blosqueados y terminados
 */
public class Gestion implements Runnable {

    private ColaProcesos procesosListo, procesosTerminado;
    private boolean pausado;
    private Thread thread;
    private int numProcesos;
    private Memoria memoria;

    /**
     * constuctor
     *
     * @param procesosListo para entrar a realizar las operaciones
     */
    public Gestion(Memoria memoria) {
        super();
        this.memoria = memoria;
    }
    

    public void agregarColaProcesos(ColaProcesos procesosListo) {
        this.procesosListo = procesosListo;
        this.procesosTerminado = new ColaProcesos();

        this.numProcesos = this.procesosListo.getTamano();
        this.pausado = false;
        this.ejecutar();
    }

    /**
     * el hilo debe acabarse cuando el numero de procesos terminado sea igual al
     * numero de procesos
     *
     * @return
     */
    public boolean isFinalizado() {
        return this.procesosTerminado.getTamano() == this.numProcesos;
    }

    /**
     * obtiene terminados
     *
     * @return lista de terminados
     */
    public ColaProcesos getTerminados() {
        return this.procesosTerminado;
    }

    /**
     * compactar la memoria
     */
    public void compactar() {
    	this.memoria.compactar();
    }

    @Override
    public void run() {
        while (!isFinalizado()) {
            if (!pausado) {
                if (!this.procesosListo.isVacia()) {
                    Proceso proceso = this.procesosListo.getProcesoAux();
                    if (this.memoria.agregarProceso(proceso)) {
                        System.out.println("Se ha ACEPTADO siguiente proceso de gestion de memoria: " + proceso.getNombre() + " - " + proceso.getTamano());
                        //por lo cual se debe sacar de la lista 
                        Proceso procesoEx = this.procesosListo.getProceso();
                        System.out.println("por lo tanto se extrae el proceso de gestion: " + procesoEx.getNombre() + " - " + procesoEx.getTamano());

                    } else {
                        System.out.println("Se ha RECHAZADO siguiente proceso de gestion de memoria: " + proceso.getNombre() + " - " + proceso.getTamano());
                    }
                    //se debe estar atento para verificar cuando existe una novedad
                    //o sea cuando empiecen a acabar los procesos
                    if (!this.memoria.getProcesosTerminados().isVacia()) {
                        this.procesosTerminado.agregar(this.memoria.getProcesosTerminados().getProceso());
//                        System.err.println(this.procesosTerminado.getTamano() + " " +this.procesosTerminado.getProceso().getNombre());
                    }
                } else {
                    System.out.println("GESTION: La cola de procesos se vacio-- se debe esperar a que se llenen la cola de temrinandos");
                    this.pausado = true;
                }
                //sleep
                this.sleepMe(1000);
            } else {
                System.out.println("Pausada la gestion");
                //se debe estar atento para verificar cuando existe una novedad
                //o sea cuando empiecen a acabar los procesos
                if (!this.memoria.getProcesosTerminados().isVacia()) {
                    this.procesosTerminado.agregar(this.memoria.getProcesosTerminados().getProceso());
//                     System.err.println(this.procesosTerminado.getTamano() + " " +this.procesosTerminado.getProceso().getNombre());
                }
                this.sleepMe(1000);
            }
        }
        System.out.println("ha terminadooooooo la gesiton");
        this.memoria.terminar();
    }

    /**
     * Ejecutar hilo
     */
    private void ejecutar() {
        thread = new Thread(this);
        thread.start();
    }

    /**
     * asignar pausa
     *
     * @param pausa true o false
     */
    public void setPausa(boolean pausa) {
        this.pausado = pausa;
    }

    /**
     * obtener valor de pausa
     *
     * @return true o false
     */
    public boolean getPausa() {
        return this.pausado;
    }

    /**
     * retorn hilo
     *
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
     * sleep para pausar dos segundos
     */
    private void sleepMe(int tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
    
}
