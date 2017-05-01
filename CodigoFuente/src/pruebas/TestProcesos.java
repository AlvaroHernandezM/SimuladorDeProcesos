package pruebas;

import logic.ColaProcesos;
import logic.Proceso;
import logic.Procesos;

/**
 * Clase de prueba de procesos2.
 * 
 * @author
 */
public class TestProcesos {

	public static void main(String[] args) {

		ColaProcesos colaProcesos = new ColaProcesos();
		
		Proceso p1 = new Proceso("p_1", 10);
		Proceso p2 = new Proceso("p_2", 15);
		Proceso p3 = new Proceso("p_3", 20);
		Proceso p4 = new Proceso("p_4", 10);
		Proceso p5 = new Proceso("p_5", 15);
		Proceso p6 = new Proceso("p_6", 20);

//		p2.esperarSuceso(4);
//		p3.esperarSuceso(30);
		
		colaProcesos.agregar(p1);
		colaProcesos.agregar(p2);
		colaProcesos.agregar(p3);
		colaProcesos.agregar(p4);
		colaProcesos.agregar(p5);
		colaProcesos.agregar(p6);
		
		int numeroProcesadores = 4;
		
		Procesos procesos = new Procesos(colaProcesos, numeroProcesadores);
	}

}
