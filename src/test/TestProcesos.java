package test;

import logic.Bloqueo;
import logic.ColaProcesos;
import logic.Proceso;
import logic.Procesos;

public class TestProcesos {
	
	public static void main(String[] args) {
		
		ColaProcesos colaProcesos = new ColaProcesos();
//		for (int i = 0; i < 5; i++) {
//			System.out.println(colaProcesos.agregar(new Proceso("P"+(i+1),(int)(Math.random() * 7))));
//		}
		Proceso p1 = new Proceso("p1",1);
		Proceso p2 = new Proceso("p2",2);
		Proceso p3 = new Proceso("p3",3);
		Proceso p4 = new Proceso("p4",4);
		Proceso p5 = new Proceso("p5",2);
		
		
		
		colaProcesos.agregar(p1);
		colaProcesos.agregar(p2);
		colaProcesos.agregar(p3);
		colaProcesos.agregar(p4);
		colaProcesos.agregar(p5);
		Procesos procesos = new Procesos(colaProcesos);
		

	}

}
