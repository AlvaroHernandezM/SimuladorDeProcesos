package logic;

public class Procesos implements Runnable {

    private ColaProcesos procesosListo, procesosBloqueado, procesosTerminado;
    private Ejecucion ejecucion; // ejecucion de proceso
    private Proceso auxiliar; // proceso para el bloqueo
    private boolean pausado;
    private Thread thread;
    private int numProcesos; // numero de procesos ingresados
    // private int quantum; //tiempo de CPU dedicado para cada proceso
    private Bloqueo bloqueo;

    public String noticia;
//	public VentantaPrincipal ventantaPrincipal;

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
        this.refrescar = true;
    }

    /**
     * el hilo debe acabarse cuando la proceso de listos y bloqueados este
     * vacia, y el numero de procesos terminado sea igual al numero de procesos
     *
     * @return
     */
    public boolean isFinalizado() {
        return this.procesosListo.isVacia() && this.procesosBloqueado.isVacia()
                && (this.procesosTerminado.getTamano() == numProcesos);
    }

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

    public ColaProcesos getBloqueados() {
        return this.bloqueo.getBloqueados();
    }

    public ColaProcesos getTerminados() {
        return this.procesosTerminado;
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
                System.err.println("´ppaaaaaaaaaaaaaaaausaaaaaa");
                this.noticia = "Pausado ejecucion";
            }
        }
        this.noticia = "Terminado ejecucion";
        this.ejecucion.terminar();
        this.bloqueo.terminar();
        System.out.println("ha terminadooooooo");

    }

    public Ejecucion getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(Ejecucion ejecucion) {
        this.ejecucion = ejecucion;
    }
    
    public void setPausa (boolean pausa){
        this.pausado = pausa;
    }
    
    public boolean getPausa (){
        return this.pausado;
    }

    public Bloqueo getBloqueo() {
        return bloqueo;
    }

    public Thread getThread() {
        return thread;
    }
    
    
}
