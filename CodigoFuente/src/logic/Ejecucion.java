package logic;

/**
 * @author - SO2017
 * Clase encargada de mantener un solo
 * proceso en ejecución con sus 
 * distintas operaciones
 */
public class Ejecucion implements Runnable {

    private Proceso proceso;
    private boolean pausado, finalizado;
    private Thread thread;
    /**
     * constructor sin aprametros
     */
    public Ejecucion() {
        super();
        this.pausado = true;
        this.finalizado = false;
        this.ejecutarHilo();
    }
    /**
     * Constructor recibiendo el proceso a ejecutar
     * @param proceso
     */
    public Ejecucion(Proceso proceso) {
        super();
        this.proceso = proceso;
        this.pausado = false;
        this.finalizado = false;

        this.ejecutarHilo();
    }
    /**
     * Obtener el proceso en ejecucion
     * y deteniendo el hilo
     * @return proceso actual
     */
    public Proceso getProceso() {
        //this.pausado = true;
        return proceso;
    }
    /**
     * Obtener la informacion del proceso en ejecucion 
     * @return string con nombre y tiempo restante
     */
    public String getInfoProceso() {
        return this.proceso.getNombre() + "-" + this.proceso.getTiempoEjecucionR();
    }
    /**
     * Agregar proceso a ejecutar
     * @param proceso
     */
    public void agregarProceso(Proceso proceso) {
        this.proceso = proceso;
        if(this.pausado)
        	this.pausado = false;
       System.out.println("agregado el proceso: " + this.getNombre());
    }
    /**
     * @return retorna true cuando el proceso ha sido bloqueado externamente o
     * termino su tiepo de ejecucion
     */
    public boolean algunaNovedad() {
        return this.proceso.isTerminado();
    }
    /**
     *pausar hilo 
     */
    public void pausar() {
        this.pausado = true;
    }
    /**
     *terminar hilo 
     */
    public void terminar() {
        this.finalizado = true;
    }
    /**
     * Obtener nombre
     * @return nombre del proceso
     */
    public String getNombre() {
        return this.proceso.getNombre();
    }
    @Override
    public void run() {
    	System.out.println("Inicio hilo Ejecucion");
        
        while (!this.finalizado) {
        	System.out.println("Esperando");

            if (!this.pausado) {                
                System.out.println("Sin pausa");

                this.proceso.admitir();
                System.out.println("Proceso adminitido: " + this.proceso.getNombre() + " - "
                        + this.proceso.getTiempoEjecucionR());                
                if (this.proceso.getTiempoEjecucionR() == 0){
                	this.pausado = true;
                } else {
                	while (!this.proceso.isTerminado()) {
                		this.proceso.disminuirTiempoEjecucion();
                		System.out.println("Tiempo restante: " + this.proceso.getTiempoEjecucionR());               		
                		try {
                			Thread.sleep(1000); // 1 segundo
                		} catch (InterruptedException e) {
                			e.printStackTrace();
                		}
                	}
                	
                }
            } else {
                System.out.println("Pausado");
            }
            try {
                Thread.sleep(400); //1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     *ejecutar hilo 
     */
    private void ejecutarHilo() {
        this.thread = new Thread(this);
        this.thread.start();
    }
    /**
     * Obtener hilo
     * @return hilo
     */
    public Thread getThread() {
        return thread;
    }
    /**
     * Verificar si  esta finalizado
     * @return boolean 
     */
    public boolean isFinalizado() {
        return finalizado;
    }
    /**
     * Asignar valor a finalizado
     * @param finalizado true o false
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    /**
     * Verificar si esta pausado
     * @return true o false
     */
    public boolean isPausado() {
        return pausado;
    }
    /**
     * asignar pausa
     * @param pausado true o false
     */
    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }
}
