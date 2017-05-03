package edu.controller;

import edu.view.about.JDacercaDe;
import gui.Acciones;
import gui.JDcrearProceso;
import gui.Restricciones;
import gui.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logic.ColaProcesos;
import logic.Ejecucion;
import logic.Proceso;
import logic.Procesos;

/**
 * Clase encargada de controlar y unir la parte grafica con la logica
 *
 * @author - SO2017
 */
public class ControllerListener implements ActionListener, Runnable {

    private VentanaPrincipal ventanaPrincipal = null;
    private JDcrearProceso jDcrearProceso = null;
    private JDacercaDe jDacercaDe = null;
    private ColaProcesos colaProcesos;
    private Restricciones restricciones;
    private Acciones acciones;
    private Procesos procesos;
    private Thread thread;
    private boolean estado, terminados;

    /**
     * Constructor
     */
    public ControllerListener() {
        this.restricciones = new Restricciones();
        this.colaProcesos = new ColaProcesos();
        this.acciones = new Acciones(colaProcesos);
        this.thread = new Thread(this);
        this.estado = false;
        this.terminados = false;
    }

    /**
     * Abrir la ventana principal de la aplicacion.
     */
    public void abrirVentanaPrincipal() {
        if (this.ventanaPrincipal == null) {
            this.ventanaPrincipal = new VentanaPrincipal(this);
        } else {
            ventanaPrincipal.setVisible(true);
        }
    }

    /**
     * Abrir dialogo para crear un nuevo proceso.
     */
    public void abrirVentanaProceso() {
        this.jDcrearProceso = new JDcrearProceso(ventanaPrincipal, this);
        this.jDcrearProceso.setVisible(true);
    }

    /**
     * Abrir ventana de los creditos de la aplicacion.
     */
    public void abrirVentanaAcercaDe() {
        this.jDacercaDe = new JDacercaDe(ventanaPrincipal, this);
        this.jDacercaDe.setVisible(true);
    }

    /**
     * Crear dialogo desde ventana
     */
    public void crearProcesoDialogo() {
        JTextField nombre = this.jDcrearProceso.getFieldNombre();
        JTextField tiempo = this.jDcrearProceso.getTiempo();
        if (this.restricciones.RestriccionCrearProceso(this.ventanaPrincipal, nombre, tiempo)) {
            this.colaProcesos.agregar(new Proceso(nombre.getText(), Integer.parseInt(tiempo.getText())));
            this.acciones.actualizarTabla(this.ventanaPrincipal.getModeloTabla());
            nombre.setText("");
            tiempo.setText("");
        }
    }

    /**
     * Crear un proceso desde la ventana principal haciendo uso de las
     * restricciones correspondientes.
     */
    public void crearProceso() {
        JTextField nombre = this.ventanaPrincipal.getCampoNombreProceso();
        JTextField tiempo = this.ventanaPrincipal.getCampoTiempoProceso();
        if (this.restricciones.RestriccionCrearProceso(this.ventanaPrincipal, nombre, tiempo)) {
            this.colaProcesos.agregar(new Proceso(nombre.getText(), Integer.parseInt(tiempo.getText())));
            this.acciones.actualizarTabla(this.ventanaPrincipal.getModeloTabla());
            nombre.setText("");
            tiempo.setText("");
        }
    }

    /**
     * ejecuta un proceso y lo coloca en funcionamiento (de listo pasa a
     * ejecucion).
     */
    public void ejecutarProceso() {
        JTextField quantum = this.ventanaPrincipal.getjTFQuantumCPU();
        JTextField quantumActual = this.ventanaPrincipal.getjTFQuantumActual();
        if ((this.restricciones.verEstadoCola(this.ventanaPrincipal, colaProcesos))
                && (this.restricciones.restriccionesQuantum(this.ventanaPrincipal, quantum))) {

            this.procesos = new Procesos(this.colaProcesos,
                    this.acciones.obtenerArrayProcesadores(this.ventanaPrincipal.getjCBnumPros()),
                    Integer.parseInt(quantum.getText()));

            anadirFilasProcesadores(this.procesos.getProcesadores());

            quantumActual.setText(quantum.getText());
            quantum.setText("");
            quantum.setEnabled(false);
            this.ventanaPrincipal.getBotonEjecutar().setEnabled(false);
            this.estado = true;
            this.terminados = true;
            this.thread.start();
        }

    }

    public void anadirFilasProcesadores(ArrayList lista) {
        this.acciones.añadirFilasTabla(this.ventanaPrincipal.getModeloTablaEjecucion(),
                this.ventanaPrincipal.getjCBnumPros(), lista);
    }

    /**
     * Bloquea un proceso si este se encuentra en ejecucion haciendo uso de las
     * restricciones.
     */
    public void bloquearProceso() {
        JTextField campoBloqueo = this.ventanaPrincipal.getCampoBloqueo();
        if (this.restricciones.llenarTiempoBloqueo(this.ventanaPrincipal, campoBloqueo) && this.restricciones
                .verEstadoColaBloqueado(this.ventanaPrincipal, colaProcesos, this.ventanaPrincipal.getCampoBloqueo())) {
            Ejecucion eje = this.procesos.bloquear(this.ventanaPrincipal.getFieldBloqueoPID().getText());
            if (eje != null) {
                eje.bloquear(Integer.parseInt(this.ventanaPrincipal.getCampoBloqueo().getText()));
                this.ventanaPrincipal.getFieldBloqueoPID().setText(null);
                this.ventanaPrincipal.getCampoBloqueo().setText(null);
            }else{
                JOptionPane.showMessageDialog(this.ventanaPrincipal,"Proceso_No_Encontrado");
            }

        }

    }

    /**
     * Permite actualizar la tabla de los procesos creados.
     */
    public void actualizarTabla() {
        this.acciones.actualizarTabla(this.ventanaPrincipal.getModeloTabla());
        this.acciones.procesosBloqueados(this.ventanaPrincipal.getModeloTabla(), this.terminados, procesos);
        this.acciones.procesosTerminados(this.ventanaPrincipal.getModeloTabla(), this.terminados, procesos);
    }

    /**
     *
     * "AQUIIIIIIIIIIIIII TOCA CAMBIAR PROCESOS POR UNA LISTA D EPROCESOS"
     * Permite actualizar el proceso que esta en ejecucion en el panel
     * correspondiente a el panel de ejecucion.
     */
    public void refrescarActual() {
        if (!this.procesos.isFinalizado()) {
            this.acciones.procesosEjecucion(this.ventanaPrincipal.getModeloTablaEjecucion(), this.procesos.getProcesadores());

        } else {
            this.acciones.removerTabla(this.ventanaPrincipal.getModeloTablaEjecucion());
        }

    }

    /**
     * Permite pausar la ejecucion de los procesos llevados acabo. en general
     * pausar la aplicacion.
     */
    public void pausarEjecucion() {
        if (this.restricciones.pausarEjecucion(this.ventanaPrincipal, colaProcesos)) {
            try {
                this.thread.suspend();
                this.procesos.getThread().suspend();
//                this.procesos.getEjecucion().getThread().suspend();
                this.procesos.getBloqueo().getThread().suspend();
                this.ventanaPrincipal.getjButtonPausar().setEnabled(false);
            } catch (Exception e) {
            }

        }

    }

    /**
     * Permite reanudar la aplicacion si se encuentra pausada.
     */
    public void reanudarEjecucion() {
        if (restricciones.reanudarEjecucion(ventanaPrincipal, this.ventanaPrincipal.getjButtonPausar())) {

            try {
                this.thread.resume();
                this.procesos.getThread().resume();
//                this.procesos.getEjecucion().getThread().resume();
                this.procesos.getBloqueo().getThread().resume();
                this.ventanaPrincipal.getjButtonPausar().setEnabled(true);
            } catch (Exception e) {
            }

        }

    }

    /**
     * manejo de las acciones que deben seguir los componentes graficos frente a
     * una eventualidad.
     *
     * @param e
     */
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
            case Constants.CLICK_BLOQUEAER:
                bloquearProceso();
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
            default:
                break;

        }
    }

    /**
     * Hilo general de ejecucion de la aplicacion.
     */
    @Override
    public void run() {
        while (this.estado) {
            if (this.procesos.refrescar) {
                this.procesos.refrescar = false;
                this.refrescarActual();
            }
            try {
                Thread.sleep(250);
                this.actualizarTabla();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                System.err.println("ee " + e);
                e.printStackTrace();
            }

        }

    }
}
