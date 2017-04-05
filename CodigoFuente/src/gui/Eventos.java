package gui;

import edu.controller.Constants;
import edu.controller.ControllerListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;

/**
 * Clase encargada de manejar los eventos de los componentes graficos.
 *
 * @author
 */
public final class Eventos {

    private ControllerListener listener;

    /**
     * Constructor con la clase controladora como parametro.
     *
     * @param ln
     */
    public Eventos(ControllerListener ln) {
        this.listener = ln;
    }

    /**
     * Operacion de un jmenuItem para salir de la aplicacion.
     *
     * @param jmSalir
     */
    public void itemSalir(JMenuItem jmSalir) {
        jmSalir.addActionListener(listener);
        jmSalir.setActionCommand(Constants.OP_SALIR);

    }

    /**
     * Operacion de un jmenuItem o un boton para abrir ventana de creditos.
     *
     * @param jm
     * @param button
     */
    public void itemAcercaDe(JMenuItem jm, JButton button) {
        jm.addActionListener(listener);
        button.addActionListener(listener);
        jm.setActionCommand(Constants.OP_ACERCADE);
        button.setActionCommand(Constants.OP_ACERCADE);
    }

    /**
     * Operacion de un boton para crear un nuevo proceso.
     *
     * @param jbutton
     */
    public void crearProceso(JButton jbutton) {
        jbutton.addActionListener(listener);
        jbutton.setActionCommand(Constants.CLICK_CREAR);
    }

    /**
     * Operacion de un boton para ejecutar un proceso.
     *
     * @param jbutton
     */
    public void ejecutarProceso(JButton jbutton) {
        jbutton.addActionListener(listener);
        jbutton.setActionCommand(Constants.CLICK_EJECUTAR);
    }

    /**
     * Operacion de un boton para bloquear un proceso.
     *
     * @param jButton
     */
    public void bloquearProceso(JButton jButton) {
        jButton.addActionListener(listener);
        jButton.setActionCommand(Constants.CLICK_BLOQUEAER);
    }

    /**
     * Operacion de un boton para abrir el dialogo de crear nuevo proceso.
     *
     * @param jButton
     */
    public void abrirCrearProceso(JButton jButton) {
        jButton.addActionListener(listener);
        jButton.setActionCommand(Constants.CLICK_CREAR_PROCESO);
    }

    /**
     * Operacion de un jmenuItem para crear un nuevo proceso.
     *
     * @param jm
     */
    public void opcionCrearProceso(JMenuItem jm) {
        jm.addActionListener(listener);
        jm.setActionCommand(Constants.CLICK_CREAR_PROCESO);
    }

    /**
     * Operacion de un boton para pausar la ejecucion de la aplicacion.
     *
     * @param jButton
     */
    public void pausarEjecucion(JButton jButton) {
        jButton.addActionListener(listener);
        jButton.setActionCommand(Constants.CLICK_PAUSAR_EJECUCION);
    }

    /**
     * Operacion de un boton para reanudar la ejecucion de la aplicacion.
     *
     * @param jButton
     */
    public void reanudarEjecucion(JButton jButton) {
        jButton.addActionListener(listener);
        jButton.setActionCommand(Constants.CLICK_REANUDAR);
    }

}
