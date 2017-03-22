package test;

import logic.Estado;
import logic.Proceso;

public class TestProceso {

	
	public static void main(String[] args) {
		
		Proceso p1,p2;
		
		p1= new Proceso("P1", 10);
		p2 = new Proceso("P2", 5);
		
		System.out.println(p1.getEstado().compareTo(Estado.NUEVO));
		
	}
}
