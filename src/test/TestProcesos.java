package test;

import logic.ColaProcesos;
import logic.Proceso;
import logic.Procesos;

public class TestProcesos {
	
	public static void main(String[] args) {
		
		ColaProcesos colaProcesos = new ColaProcesos();
//		for (int i = 0; i < 5; i++) {
//			System.out.println(colaProcesos.agregar(new Proceso("P"+(i+1),(int)(Math.random() * 7))));
//		}
		colaProcesos.agregar(new Proceso("P1", 5));
		colaProcesos.agregar(new Proceso("P2", 4));
		colaProcesos.agregar(new Proceso("P3", 4));
		colaProcesos.agregar(new Proceso("P4", 4));
		Procesos procesos = new Procesos(colaProcesos);
		// pruebas para bloqueo
	}

}
