package logic;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ColaProcesos {

	private ArrayList<Proceso> deque;

	public ColaProcesos() {
		super();
		this.deque = new ArrayList<>();
	}
	
	public boolean agregar(Proceso proceso){
		System.out.println(proceso.getNombre()+" - "+proceso.getTiempoEjecucionR());
		return this.deque.add(proceso);
	}
	
	public Proceso getProceso(int pos){
		Proceso proceso = this.deque.get(pos); 
		this.deque.remove(pos);
		return proceso;
	}
	
	public void clearAll(){
		this.deque.clear();
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
