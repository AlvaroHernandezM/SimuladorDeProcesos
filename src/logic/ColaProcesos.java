package logic;

import java.util.ArrayDeque;

public class ColaProcesos {

	private ArrayDeque<Proceso> deque;

	public ColaProcesos() {
		super();
		this.deque = new ArrayDeque<>();
	}
	
	public boolean agregar(Proceso proceso){
		return this.deque.add(proceso);
	}
	
	public Proceso getProceso(){
		return this.deque.remove();
	}
	
	public void clearAll(){
		this.deque.clear();
	}
	
	public int getTama�o(){
		return this.deque.size();
	}
	
	public boolean isVacia(){
		return this.deque.isEmpty();
	}
}
