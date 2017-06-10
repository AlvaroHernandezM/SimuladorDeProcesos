package pruebas;

import logic.ColaProcesos;
import logic.Ejecucion;
import logic.Gestion;
import logic.Memoria;
import logic.Proceso;

public class TestMemoria {

	public static void main(String[] args) {
		
		Memoria memoria = new Memoria(220); //asignacion inicial
		//creacion de procesos
		Proceso p1 = new Proceso("P1", 3, 20);
		Proceso p2 = new Proceso("P2", 10, 100);
		//	Proceso p3 = new Proceso("P3", 10, 100);
		
		//	Proceso p4 = new Proceso("P4", 5, 30);
		
		//agregando a la cola
		ColaProcesos colaProcesos = new ColaProcesos();
		colaProcesos.agregar(p1);
		colaProcesos.agregar(p2);
		//	colaProcesos.agregar(p3);
		//	colaProcesos.agregar(p4);
		
		Gestion gestion = new Gestion(memoria);
		gestion.agregarColaProcesos(colaProcesos);
		
		
		//Ejecucion ejecucion = new Ejecucion(p1);
		
//		while (true){
//			if(ejecucion.getProceso().getTiempoEjecucionR() == 0){
//				ejecucion.agregarProceso(new Proceso("P2", 5));
//			}
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	
	
}
