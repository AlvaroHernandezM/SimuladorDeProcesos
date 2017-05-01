package logic;

import java.util.ArrayList;

/**
 * Clase encarga de contener una lista de procesos y los metodos que se pueden
 * ejecutar
 *
 * @author - SO2017
 */
public class ColaProcesos {

	/**
	 * lista
	 */
	private ArrayList<Proceso> deque;

	/**
	 * constructor que inicializa la lista
	 */
	public ColaProcesos() {
		super();
		this.deque = new ArrayList<>();
	}

	/**
	 * Metodo agregar proceso a la lista
	 *
	 * @param proceso
	 *            que se desea agregar
	 */
	public void agregar(Proceso proceso) {
		this.deque.add(proceso);
	}

	/**
	 * Obtener el proceso que se encuentra de primero y eliminando dicha
	 * posicion (COLA)
	 *
	 * @return el proceso primero en la cola
	 */
	public Proceso getProceso() {
		Proceso aux = this.deque.get(0);
		this.deque.remove(0);
		return aux;
	}

	/**
	 * Obtener un proceso en especifico de la lista sin eliminarlo
	 *
	 * @param pos
	 *            Posicion en la que se encuentra el proceso
	 * @return prooceso seleccionado
	 */
	public Proceso getProceso(int pos) {
		return this.deque.get(pos);
	}

	/**
	 * Borrar un proceos de la lista
	 *
	 * @param pos
	 *            posicion la cual se desea elimianr
	 */
	public void borrar(int pos) {
		this.deque.remove(pos);
	}

	/**
	 * Eliminar todos los procesos de la lista
	 */
	public void clearAll() {
		this.deque.clear();
	}

	/**
	 * Obtener tamano de la cola
	 *
	 * @return tamano de la cola
	 */
	public int getTamano() {
		return this.deque.size();
	}

	/**
	 * Conocer si se encuentra vacia la lista
	 *
	 * @return true o false
	 */
	public boolean isVacia() {
		return this.deque.isEmpty();
	}

	/**
	 * Obtener toda la lista
	 *
	 * @return lista
	 */
	public ArrayList<Proceso> getDeque() {
		return deque;
	}

	/**
	 * Asginar nueva lista
	 *
	 * @param deque
	 *            lista para asignar
	 */
	public void setDeque(ArrayList<Proceso> deque) {
		this.deque = deque;
	}
}
