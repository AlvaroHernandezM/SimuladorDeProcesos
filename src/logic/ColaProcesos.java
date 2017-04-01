package logic;

import java.util.ArrayList;

public class ColaProcesos {

	private ArrayList<Proceso> deque;

	public ColaProcesos() {
		super();
		this.deque = new ArrayList<>();
	}
	
	public void  agregar(Proceso proceso){
//		System.out.println(proceso.getNombre()+" - "+proceso.getTiempoEjecucionR());
		 this.deque.add(proceso);
	}
	
	
	public Proceso getProceso(){
		Proceso aux = this.deque.get(0);
		this.deque.remove(0);
		return aux;
	}
	
	public Proceso getProceso(int pos){
		return this.deque.get(pos);
	}
	
	public void borrar (int pos){
		this.deque.remove(pos);
	}
	
	
	public void clearAll(){
		this.deque.clear();
		System.out.println("Borrados: "+this.deque.size());
	}
	
	public int getTamano(){
		return this.deque.size();
	}
	
	public boolean isVacia(){
		return this.deque.isEmpty();
	}

	public ArrayList<Proceso> getDeque() {
		return deque;
	}

	public void setDeque(ArrayList<Proceso> deque) {
		this.deque = deque;
	}

	
}