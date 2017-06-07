package logic;

import java.util.ArrayList;

public class Memoria {
	
	private int cantidadTotal;
	private ArrayList<Particion> particiones;
	
	public Memoria(int cantidadTotal) {
		super();
		this.cantidadTotal = cantidadTotal;
		this.particiones = new ArrayList<>();
		
		this.crearParticiones();
	}
	
	public boolean agregarProceso(Proceso proceso){		
		if (!isMayorAMemoria(proceso.getTamano())){
			int posicionLibre = isEspacioLibre(proceso.getTamano()); 
			if(posicionLibre != -1){				
				this.agregarParticion(proceso, posicionLibre);
				
			} else {
				System.out.println("No se encontro espacio para el proceso ");
				return false;
			}
		} else {
			System.out.println("El proceso tiene más tamaño que la memoria");			
		}
		return false;
	}
	
	private void agregarParticion(Proceso proceso, int posicionLibre){
		
		if(this.isUltimaPosicion(posicionLibre)){
			this.particiones.add(new Particion(this.particiones.get(posicionLibre).getTamano()-proceso.getTamano()));
			this.particiones.get(posicionLibre).agregarProceso(proceso);
			
		} else {
			//no es la ultima posicion de la memoria
			
		}
		
	}
	
	/**
	 * @param posicion
	 * @return
	 */
	private boolean isUltimaPosicion(int posicion){
		return this.particiones.size()-1 == posicion ? true : false;
	}
	
	private void crearParticiones(){
		for (int i = 0; i < this.cantidadTotal; i++) {
			this.particiones.add(new Particion(1));
		}
	}
	
	/**
	 * verifica que si hay memoria para un proceso en un espacio y retorna su posicion
	 * @return
	 */
	private int isEspacioLibre(int tamano){
		for (int i = 0; i < this.particiones.size(); i++) {
			if ((this.particiones.get(i).getTamano() > tamano) && 
					(!this.particiones.get(i).isOcupado())){
					return i;
			}
		}			
		return -1;
	}
	
	/**
	 * @param tamano
	 * @return
	 */
	private boolean isMayorAMemoria(int tamano){
		return tamano>this.cantidadTotal ? true : false;
	}

	/**
	 * @return the particiones
	 */
	public ArrayList<Particion> getParticiones() {
		return particiones;
	}

		
}
