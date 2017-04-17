package pruebas;

import logic.ColaProcesos;
import logic.Proceso;
import logic.Procesos;

/**
 * Clase de pruebas de bloqueo.
 * @author 
 */
public class TestBloqueo {

	/**
         * Pruebas de bloqueo
         * @param args 
         */
	public static void main(String[] args) {
		
		//CASO DE PRUEBA 1 - INICIA EN 10, EJECUTA 5 s Y LO BLOQUEAN 3, LUEGO TERMINA DE EJECUTAR Y MUESTRA TOTAL ** OK (FUNCIONANDO)
		
		
		Proceso p1 = new Proceso("P1", 2);
		Proceso p2 = new Proceso("p2", 4);
		p2.esperarSuceso(4);
		Proceso p3 = new Proceso("p3", 6);
//		Proceso p4 = new Proceso ("p4",6 );
//		Proceso p5 = new Proceso ("p5", 5);
		
		ColaProcesos cp = new ColaProcesos();
		
		
		
		
		cp.agregar(p1);
		cp.agregar(p2);
		cp.agregar(p3);
//		cp.agregar(p4);
//		cp.agregar(p5);
		
		int quantumCPU = 5;
		
		Procesos ps = new Procesos(cp, quantumCPU);
		
	}
}
