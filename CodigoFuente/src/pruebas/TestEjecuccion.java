package pruebas;

import java.util.Random;

import logic.Ejecucion;
import logic.Proceso;

public class TestEjecuccion {

	public static void main(String[] args) {
		
		Random random = new Random();

		int quantum = (int) ((random.nextDouble() * 15 - 1) - 1);;
		Ejecucion ejecucion = new Ejecucion("1", quantum);

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 2;
				while (true) {
					if (ejecucion.algunaNovedad()) {
						System.out.println("Novedad");
						ejecucion.agregarProceso(new Proceso("p_" + i, (int) ((random.nextDouble() * 20 - 1) - 1)));
						ejecucion.getProceso().admitir();
						i++;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();

		try {
			Thread.sleep(4000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Proceso p_1 = new Proceso("p_1", 10);
		ejecucion.agregarProceso(p_1);

	}
}
