package logic;



public class Procesos implements Runnable{
	
	private ColaProcesos procesosListo, procesosBloqueado, procesosTerminado;
	private Proceso procesoEjecucion;
	private boolean pausado, finalizado;
	private Thread thread;
	//private int quantum; //tiempo de CPU dedicado para cada proceso
	
	public Procesos(ColaProcesos procesosListo) {
		super();
		this.procesosListo = procesosListo;
		
		this.procesosBloqueado = new ColaProcesos();
		this.procesosTerminado = new ColaProcesos();
		this.finalizado = false;
		this.pausado = false;
		this.ejecutar();
	}
	
	private void ejecutar(){
		thread = new Thread(this);
		thread.start();
	}
	
	public void bloquear(int tiempo){
		this.procesoEjecucion.esperarSuceso(tiempo);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!finalizado){
			if(!pausado){
				this.procesoEjecucion = this.procesosListo.getProceso();
				this.procesoEjecucion.admitir();
				while(procesoEjecucion.getEstado().compareTo(Estado.BLOQUEADO)!=0){
					//continuar codigo aca
					this.procesoEjecucion.disminuirTiempoEjecucion();
				}
			} else {
				
			}
		}
	}

	
}
