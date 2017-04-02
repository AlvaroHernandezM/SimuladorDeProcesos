package pruebas;

import logic.Proceso;

public class TestProceso {

	
	public static void main(String[] args) {
		
		//CASO DE PRUEBA 1 - INICIA EN 10, EJECUTA 5 s Y LO BLOQUEAN 3, LUEGO TERMINA DE EJECUTAR Y MUESTRA TOTAL ** OK (FUNCIONANDO)
		Proceso p1 = new Proceso("P1", 10);
		System.out.println("Estado inicial: "+p1.getEstado());
		p1.admitir();
		System.out.println("Agregado a cola: "+p1.getEstado());
		p1.ejecutar();
		for (int i = 0; i < 5; i++) {
			p1.disminuirTiempoEjecucion();
		}
		System.out.println("Estado: "+p1.getEstado());
		System.out.println("TE restante: "+p1.getTiempoEjecucionR());;
		System.out.println("isBloqueado: " +p1.isBloqueado());
		p1.esperarSuceso(3);
		System.out.println("isBloqueado: " +p1.isBloqueado());
		for (int j = 0; j < 3; j++) {
			p1.dimisnutirTiempoBloqueo();
		}
		System.out.println("Estado: "+p1.getEstado());
		p1.ocurreSuceso();
		System.out.println("Estado: "+p1.getEstado());
		System.out.println("TB restante: "+p1.getTiempoBloqueoR());;
		p1.ejecutar();
		for (int i = 0; i < 5; i++) {
			p1.disminuirTiempoEjecucion();
		}
		System.out.println("Estado: "+p1.getEstado());
		System.out.println("TTotal: "+p1.getTiempoTotal());;
	}
}
