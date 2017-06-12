package logic;

import java.awt.Color;

/**
 * @author - SO2017
 * Clase proceso
 */
public class Proceso {

    private String nombre;
    private int tiempoEjecucionR, tiempoEjecucionT; //R = Restante, T = Total 
    private Estado estado;
    private int tamano; 
    private Color color;

    /**
     * COSNTRUCTUR CON TAMANO
     * @param nombre
     * @param tiempoEjecucionT
     * @param tamano
     */
    public Proceso(String nombre, int tiempoEjecucionT, int tamano,Color c) {
		super();
		this.nombre = nombre;
		this.tiempoEjecucionT = tiempoEjecucionT;
		this.tamano = tamano;
                this.color = c;
		this.tiempoEjecucionR = this.tiempoEjecucionT;
        this.estado = Estado.NUEVO;
	}

    public Color getColor() {
        return color;
    }
    /**
     * constructor
     * @param nombre 
     * @param tiempoEjecucionT
     */
    public Proceso(String nombre, int tiempoEjecucionT) {
        super();
        this.nombre = nombre;
        this.tiempoEjecucionT = tiempoEjecucionT;
        this.tiempoEjecucionR = this.tiempoEjecucionT;
        this.estado = Estado.NUEVO;
        this.tamano = 0;
    }
	/**
     * constructor sin parametros 
     */
    public Proceso() {
        super();
    }
    /**
     * trancici�n de adminito en el cual
     * cambia su estado a LISTO 
     */
    public void admitir() {
        this.estado = Estado.LISTO;
    }
    
    /**
     *ejecutar proceso cambiando su estado
     *a e EJECUCION 
     */
    public void ejecutar() {
        this.estado = Estado.EJECUCION;
    }

    /**
     * Restar tiempo a ejecucio mientras sea
     * posible, cuando ya no cambia su estado 
     * a TERMINADO 
     */
    public void disminuirTiempoEjecucion() {
        if (this.tiempoEjecucionR != 0) {
            this.tiempoEjecucionR--;
        } else {
            this.estado = Estado.TERMINADO;
        }
    }
    /**
     * Liberando un proceso al cambiar su estado
     * a terminado 
     */
    public void liberar() {
        if (this.tiempoEjecucionR == 0) {
            this.estado = Estado.TERMINADO;
        } else {
            System.err.println("NO DEBE LIBERAR EL PROCESO AUN");
        }
    }
    /**
     * verificar si esta terminado
     * @return true o false
     */
    public boolean isTerminado() {
        return this.estado.compareTo(Estado.TERMINADO) == 0;
    }
    /**
     * verificar si esta desbloqueado
     * @return true o false
     */
    public boolean isDesbloqueado() {
        return this.estado.compareTo(Estado.LISTO) == 0;
    }

    /**
     * obtener nombre
     * @return nombre proceso
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * obteniendo tiempo ejecucion restante
     * @return numero en segundos
     */
    public int getTiempoEjecucionR() {
        return tiempoEjecucionR;
    }
    /**
     * obteniendo tiempo ejecucion total
     * @return numero en segundos
     */
    public int getTiempoEjecucionT() {
        return tiempoEjecucionT;
    }
    /**
     * Obteniendo estado del proceso
     * @return NUEVO,LISTO,EJECUCION,BLOQUEADO,TERMINADO
     */
    public Estado getEstado() {
        return estado;
    }
	/**
	 * @return the tamano
	 */
	public int getTamano() {
		return tamano;
	}
    
}
