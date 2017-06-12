package edu.controller;

import edu.view.about.JDacercaDe;
import gui.Acciones;
import gui.GestionMemoriaGrafica;
import gui.JDcrearProceso;
import gui.PintarLista;
import gui.Restricciones;
import gui.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logic.ColaProcesos;
import logic.Gestion;
import logic.Memoria;
import logic.Proceso;

/**
 * Clase que permite controlar y unificar la parte logica con la parte grafica.
 *
 * @author SO
 */
public class ControllerListener implements ActionListener, Runnable {

    //GUI
    private VentanaPrincipal ventanaPrincipal = null;
    private JDcrearProceso jDcrearProceso = null;
    private JDacercaDe jDacercaDe = null;
    private GestionMemoriaGrafica gestionMemoriaGrafica;
    private Restricciones restricciones;
    private Acciones acciones;
    private PintarLista pintarLista;

    //LOGICA
    private ColaProcesos colaProcesos;
    private Memoria memoria;
    private Gestion gestionMemoria;

    private Thread thread;
    private boolean estado, terminados;
    private int espacio;
    private int cont;
    private boolean actualizar;

    /**
     * Constructor de la clase controladora.
     */
    public ControllerListener() {
        this.restricciones = new Restricciones();
        this.colaProcesos = new ColaProcesos();
        this.acciones = new Acciones(colaProcesos);
        this.thread = new Thread(this);
        this.estado = false;
        this.terminados = false;
        this.actualizar = true;
        this.espacio = 0;
        this.cont = 3;
//        this.pintarLista = new PintarLista();<
    }

    /**
     * Permite correr la ventana principal de la aplicacion.
     */
    public void abrirVentanaPrincipal() {
        if (this.ventanaPrincipal == null) {
            this.ventanaPrincipal = new VentanaPrincipal(this);
        } else {
            ventanaPrincipal.setVisible(true);
        }
    }

    /**
     * Permite abrir el dialogo al proceso.
     */
    public void abrirVentanaProceso() {
        this.jDcrearProceso = new JDcrearProceso(ventanaPrincipal, this);
        this.jDcrearProceso.setVisible(true);
    }

    /**
     * Permite abrir dialogo correspondiente a los creditos.
     */
    public void abrirVentanaAcercaDe() {
        this.jDacercaDe = new JDacercaDe(ventanaPrincipal, this);
        this.jDacercaDe.setVisible(true);
    }

    /**
     * Permite crear un proceso desde una ventana dialogo.
     */
    public void crearProcesoDialogo() {
        JTextField nombre = this.jDcrearProceso.getFieldNombre();
        JTextField tiempo = this.jDcrearProceso.getTiempo();
        JTextField tamano = this.jDcrearProceso.getTamano();
        if (this.restricciones.RestriccionCrearProceso(this.ventanaPrincipal, nombre, tiempo)) {
            this.colaProcesos.agregar(new Proceso(nombre.getText(), Integer.parseInt(tiempo.getText()),
                    Integer.parseInt(tamano.getText()), this.jDcrearProceso.getjButton1().getBackground()));
            this.acciones.actualizarTabla(this.ventanaPrincipal.getModeloTabla());
            nombre.setText("");
            tiempo.setText("");
            tamano.setText("");
        }
    }

    /**
     * Permite crear un procesos desde la ventana principal.
     */
    public void crearProceso() {
        JTextField nombre = this.ventanaPrincipal.getCampoNombreProceso();
        JTextField tiempo = this.ventanaPrincipal.getCampoTiempoProceso();
        int Tamano = this.ventanaPrincipal.getSliderTamano().getValue();
        if (this.restricciones.RestriccionCrearProceso(this.ventanaPrincipal, nombre, tiempo)) {
            this.colaProcesos.agregar(new Proceso(nombre.getText(), Integer.parseInt(tiempo.getText()), Tamano,
                    this.ventanaPrincipal.getjButton1().getBackground()));
            this.acciones.actualizarTabla(this.ventanaPrincipal.getModeloTabla());
            nombre.setText("");
            tiempo.setText("");
            this.ventanaPrincipal.getSliderTamano().setValue(1);
        }
    }

    /**
     * Metodo que permite ejecutar los procesos creados y realizar su gestion en
     * la memoria.
     */
    public void ejecutarProceso() {

        if (this.restricciones.verEstadoCola(this.ventanaPrincipal, colaProcesos)) {
            if (espacio != 0) {
                this.memoria = new Memoria(espacio);
                this.gestionMemoria = new Gestion(memoria);
                this.gestionMemoria.agregarColaProcesos(colaProcesos);
                this.ventanaPrincipal.getBotonEjecutar().setEnabled(false);
                this.estado = true;
                this.terminados = true;
                this.thread.start();

            } else {
                JOptionPane.showMessageDialog(ventanaPrincipal, "No_ha_asignado_memoria");
            }

        }

    }

    /**
     * Metodo que permite actualizar los parametros de proceso en la tabla.
     */
    public void actualizarTabla() {
        if (this.gestionMemoria.getMemoria().getEjecuciones()!=null
                && this.gestionMemoria.getTerminados()!=null){
            this.acciones.actu(this.ventanaPrincipal.getModeloTabla(), this.gestionMemoria.getMemoria().getEjecuciones());
        this.acciones.procesosTerminados(this.ventanaPrincipal.getModeloTabla(), this.gestionMemoria.getTerminados());
        }
        
    }

    /**
     * Metodo que permite pausar la ejecucion de la aplicacion.
     */
    public void pausarEjecucion() {
        if (this.restricciones.pausarEjecucion(this.ventanaPrincipal, colaProcesos)) {
            try {
                this.thread.suspend();
//                this.procesos.getThread().suspend();
//                this.procesos.getEjecucion().getThread().suspend();
//                this.procesos.getBloqueo().getThread().suspend();
                this.ventanaPrincipal.getjButtonPausar().setEnabled(false);
            } catch (Exception e) {
            }

        }

    }

    /**
     * Metodo que permite reanudar la ejecucion de la aplicacion.
     */
    public void reanudarEjecucion() {
        if (restricciones.reanudarEjecucion(ventanaPrincipal, this.ventanaPrincipal.getjButtonPausar())) {

            try {
                this.thread.resume();
//                this.procesos.getThread().resume();
//                this.procesos.getEjecucion().getThread().resume();
//                this.procesos.getBloqueo().getThread().resume();
                this.ventanaPrincipal.getjButtonPausar().setEnabled(true);
            } catch (Exception e) {
            }

        }

    }

    /**
     * Metodo que permite ver graficamente la memoria asignada por el usuario.
     */
    public void asignarMemoria() {
        JTextField campoMemoria = this.ventanaPrincipal.getCampoMemoria();
        if (restricciones.asignarMemoria(ventanaPrincipal, campoMemoria)) {

            //Se asigna el tamano a memoria que digito el usuario.
            this.espacio = Integer.parseInt(campoMemoria.getText());

            this.gestionMemoriaGrafica = new GestionMemoriaGrafica(this.ventanaPrincipal.getPanelMemoria(),
                    this.ventanaPrincipal.panelEtiquetas(), this.ventanaPrincipal.panelTiempo(),
                    Integer.parseInt(campoMemoria.getText()));
            this.ventanaPrincipal.getCampoMemoria().setText("");

        }

    }

    /**
     * Metodo que permite compactar la memoria.
     */
    public void compactarMemoria() {
        System.err.println("soy_metodo_para_compactar_memoria");
    }

    /**
     * Metodo que permite reiniciar la Aplicacion con sus valores por defecto.
     */
    public void reiniciarAplicacion() {
        try {

            this.espacio = 0;
            this.memoria = new Memoria(espacio);
            this.gestionMemoria = new Gestion(memoria);
            this.colaProcesos = new ColaProcesos();

            if (this.gestionMemoria.getTerminados() != null && this.gestionMemoria.getMemoria().getEjecuciones() != null
                    && this.gestionMemoria.getMemoria().getOciosos() != null) {
                this.gestionMemoria.getTerminados().clearAll();
                this.gestionMemoria.getMemoria().getEjecuciones().clear();
                this.colaProcesos.clearAll();
                this.gestionMemoria.getMemoria().getOciosos().clear();
            }
            this.acciones.removerTabla(this.ventanaPrincipal.getModeloTabla());
            this.ventanaPrincipal.getPanelMemoria().repaint();
            this.ventanaPrincipal.getCampoMemoria().setText("");
            this.ventanaPrincipal.getCampoNombreProceso().setText("");
            this.ventanaPrincipal.getCampoTiempoProceso().setText("");
            this.ventanaPrincipal.getSliderTamano().setValue(1);
            this.ventanaPrincipal.getBotonEjecutar().setEnabled(true);
//            this.thread.stop();

        } catch (ExceptionInInitializerError e) {
            System.err.println("ee" + e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case Constants.OP_SALIR:
                System.exit(0);
                break;
            case Constants.OP_ACERCADE:
                abrirVentanaAcercaDe();
                break;
            case Constants.CLICK_CREAR:
                crearProceso();
                break;
            case Constants.CLICK_EJECUTAR:
                ejecutarProceso();
                break;
            case Constants.CLICK_CREAR_PROCESO:
                abrirVentanaProceso();
                break;
            case Constants.CERRAR_ACERCA_DE:
                this.jDacercaDe.setVisible(false);
                break;
            case Constants.CLICK_CREAR_DIALOGO:
                this.crearProcesoDialogo();
                this.jDcrearProceso.setVisible(false);
                break;
            case Constants.CERRAR_DIALOGO_CREAR:
                this.jDcrearProceso.setVisible(false);
                break;
            case Constants.CLICK_PAUSAR_EJECUCION:
                pausarEjecucion();
                break;
            case Constants.CLICK_REANUDAR:
                reanudarEjecucion();
                break;
            case Constants.CLICK_MEMORIA:
                asignarMemoria();
                break;
            case Constants.CLICK_COMPACTAR:
                compactarMemoria();
                break;
            case Constants.OP_REINICIAR:
                reiniciarAplicacion();
                break;
            default:
                break;

        }
    }

    /**
     * Hijo general de la interfaz para las actualizaciones correspondientes en
     * los componentes graficos.
     */
    @Override
    public void run() {

        while (this.estado) {
            try {
                Thread.sleep(550);
                this.actualizarTabla();
                this.gestionMemoriaGrafica.pintarProcesos(this.gestionMemoria.getMemoria().getEjecuciones(),
                        this.ventanaPrincipal.getPanelMemoria());
//                if (this.gestionMemoria.isFinalizado()){
//                    JOptionPane.showConfirmDialog(null, 
//                            "¿Desea_Reiniciar_Aplicacion?","?Confirmar Reinicio", JOptionPane.YES_NO_OPTION,
//                            JOptionPane.QUESTION_MESSAGE);
//                    if (JOptionPane.YES_NO_OPTION==1){
//                        System.err.println("dijo si");
//                    }
//                }

            } catch (InterruptedException e) {
                System.err.println("ee " + e);
            }

        }
    }
}
