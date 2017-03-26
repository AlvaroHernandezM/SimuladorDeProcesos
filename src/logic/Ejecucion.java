package logic;

public class Ejecucion implements Runnable{
	
	private Proceso proceso;
	private boolean pausado, finalizado;
	private Thread thread;
	
	public Ejecucion(){
		super();
		this.pausado = true;
		this.finalizado = false;
		
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
		System.out.println("agregado el proceso: "+this.pausado);
	}
	
	/**
	 * metodo para avisar de un bloque, pero se limita a solo
	 * cambiar el estado del proceso.
	 * @param tiempo
	 */
	public void bloquear(int tiempo){
		this.proceso.esperarSuceso(tiempo);
		this.pausado = true;
	}
	
	/**
	 * @return retorna true cuando el proceso ha sido bloqueado externamente
	 * o termino su tiepo de ejecucion
	 */
	public boolean algunaNovedad(){
		return this.proceso.isBloqueado() ||
				this.proceso.isTerminado();
	}
	
	public void pausar(){
		this.pausado = true;
	}
	
	public void terminar(){
		this.finalizado =  true;
	}

	@Override
	public void run() {
		System.out.println("Inicio hilo Ejecucionn");
		while(!this.finalizado){
			System.out.println("esperando");
			if(!this.pausado){
				System.out.println("sin pausa");
				this.proceso.admitir();
				System.out.println("proceso adminitido: "+this.proceso.getNombre()+" - "+this.proceso.getTiempoEjecucionR());
				while( !this.proceso.isBloqueado() && 
						!this.proceso.isTerminado() ){
					this.proceso.disminuirTiempoEjecucion();
					System.out.println("tiempo restante: "+this.proceso.getTiempoEjecucionR());
					try {
						Thread.sleep(1000); //1 segundo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("pausado");
			}
		}
	}
	
	private void ejecutarHilo(){
		this.thread = new Thread(this);
		this.thread.start();
	}
}
