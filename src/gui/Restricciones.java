package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logic.ColaProcesos;

/**
 * Restricciones campos de texto y demas.
 *
 * @author 
 */
public class Restricciones {

    public boolean RestriccionCrearProceso(JFrame frame, JTextField nombre, JTextField tiempo) {
        if (nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "debe_rellenar_nombre_Proceso");
            return false;
        } else if (tiempo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "debe_rellenar_tiempo_Proceso");
            return false;
        }

        return true;
    }

    public boolean llenarTiempoBloqueo(JFrame frame, JTextField textField) {
        if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "debe_establecer_tiempo_bloqueo");
            return false;
        }
        return true;
    }

    public boolean verEstadoCola(JFrame frame, ColaProcesos cp) {
        if (cp.isVacia()) {
            JOptionPane.showMessageDialog(frame, "No_Hay_Procesos_en_Nuevos");
            return false;
        }
        return true;
    }

    public boolean verEstadoColaBloqueado(JFrame frame, ColaProcesos cp, JTextField jTextField) {
        if (cp.isVacia()) {
            JOptionPane.showMessageDialog(frame, "No_Hay_Procesos_en_Ejecucion");
            jTextField.setText(null);
            return false;
        }
        return true;
    }

    public boolean pausarEjecucion(JFrame frame, ColaProcesos cp) {
        if (!(cp.getTamano() > 0)) {
            JOptionPane.showMessageDialog(frame, "Para_pausar_debe_haber_mas_de_un_proceso");
            return false;
        }

        return true;
    }

    public boolean reanudarEjecucion(JFrame frame, JButton jButton) {
        if (jButton.isEnabled()) {
            return false;
        }
        return true;
    }

}
