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

    public Eventos(ControllerListener ln) {
        this.listener = ln;
    }

    public void itemSalir(JMenuItem jmSalir) {
        jmSalir.addActionListener(listener);
        jmSalir.setActionCommand(Constants.OP_SALIR);

    }

    public void itemAcercaDe(JMenuItem jm, JButton button) {
        jm.addActionListener(listener);
        button.addActionListener(listener);
        jm.setActionCommand(Constants.OP_ACERCADE);
        button.setActionCommand(Constants.OP_ACERCADE);
    }

    public void crearProceso(JButton jbutton) {
        jbutton.addActionListener(listener);
        jbutton.setActionCommand(Constants.CLICK_CREAR);
    }
    
    public void ejecutarProceso (JButton jbutton){
        jbutton.addActionListener(listener);
        jbutton.setActionCommand(Constants.CLICK_EJECUTAR);
    }
    
    public void bloquearProceso (JButton jButton){
        jButton.addActionListener(listener);
        jButton.setActionCommand(Constants.CLICK_BLOQUEAER);
    }
    
    public void abrirCrearProceso (JButton jButton){
        jButton.addActionListener(listener);
        jButton.setActionCommand(Constants.CLICK_CREAR_PROCESO);
    }
    
    public void opcionCrearProceso (JMenuItem jm){
        jm.addActionListener(listener);
        jm.setActionCommand(Constants.CLICK_CREAR_PROCESO);
    }
    
    public void pausarEjecucion (JButton jButton){
        jButton.addActionListener(listener);
        jButton.setActionCommand(Constants.CLICK_PAUSAR_EJECUCION);
    }
    
    public void reanudarEjecucion (JButton jButton){
        jButton.addActionListener(listener);
        jButton.setActionCommand(Constants.CLICK_REANUDAR);
    }

}
