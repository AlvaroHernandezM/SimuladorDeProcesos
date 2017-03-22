package logic;



public class Procesos implements Runnable{
	
	private ColaProcesos procesosListo;
	private boolean pausado, finalizado;
	private int quantum; //tiempo de CPU dedicado para cada proceso
	
	public Procesos(ColaProcesos procesosListo, int quantum) {
		super();
		this.procesosListo = procesosListo;
		this.quantum = quantum;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
