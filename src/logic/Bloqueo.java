package logic;

public class Bloqueo implements Runnable {

	private Thread thread;
	private ColaProcesos lista, desbloqueados;
	private boolean pausado, terminado;

	public Bloqueo() {
		super();
		this.pausado = true;
		this.terminado = false;
		this.lista = new ColaProcesos();
		this.desbloqueados = new ColaProcesos();

		this.ejecutarHilo();
	}

	public void anadirBloqueo(Proceso proceso) {

		this.lista.agregar(proceso);
		this.pausado = false;
	}
	
	public ColaProcesos getBloqueados(){
		ColaProcesos aux = new ColaProcesos();
		for (int i = 0; i < this.lista.getTamano(); i++) {

			if (this.lista.getProceso(i).isBloqueado()) {
				aux.agregar(this.lista.getProceso(i));
			}
		}
		return aux;
	}

	public boolean isVaciaBloqueados(){
		ColaProcesos aux = new ColaProcesos();
		for (int i = 0; i < this.lista.getTamano(); i++) {

			if (this.lista.getProceso(i).isBloqueado()) {
				aux.agregar(this.lista.getProceso(i));
			}
		}
		return aux.isVacia();
	}
	
	public ColaProcesos getDesbloqueados() {

		for (int i = 0; i < this.lista.getTamano(); i++) {

			if (this.lista.getProceso(i).isDesbloqueado()) {
				Proceso aux = this.lista.getProceso(i);
				this.lista.borrar(i);
				this.desbloqueados.agregar(aux);

			}
		}
		System.out.println("desbloqueados vacia: " + this.desbloqueados.isVacia());
		if (!this.desbloqueados.isVacia()) {
			ColaProcesos aux = this.desbloqueados;
			System.out.println("TAMANO: " + aux.getTamano());

			return aux;
		} else {
			return new ColaProcesos();
		}
	}

	public void borrarDesbloqueados() {
		this.desbloqueados.clearAll();
	}

	@Override
	public void run() {

		while (!terminado) {
			if (!pausado) {
				if (!this.lista.isVacia()) {
					for (int i = 0; i < lista.getTamano(); i++) {
						this.lista.getProceso(i).dimisnutirTiempoBloqueo();
						System.err.println("tiempo bloqueo " + this.lista.getProceso(i).getTiempoBloqueoR());
					}
				}
			} else {
				System.out.println("esperando");
			}

			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private void ejecutarHilo() {
		this.thread = new Thread(this);
		this.thread.start();
	}
}
