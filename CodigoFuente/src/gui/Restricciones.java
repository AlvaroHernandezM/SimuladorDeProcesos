package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logic.ColaProcesos;

/**
 * Clase encargada de manejar las restricciones de los campos graficos de la
 * aplicacion.
 *
 * @author
 */
public class Restricciones {

	

	/**
	 * Permite restringir que tanto el nombre, como el tiempo no esten vacios a
	 * la hora de crear un proceso.
	 *
	 * @param frame
	 * @param nombre
	 * @param tiempo
	 * @return
	 */
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

	/**
	 * Permite restringir que el campo correspondiente al tiempo de bloqueo no
	 * se encuentre vacio.
	 *
	 * @param frame
	 * @param textField
	 * @return
	 */
	public boolean llenarTiempoBloqueo(JFrame frame, JTextField textField) {
		if (textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "debe_establecer_tiempo_bloqueo");
			return false;
		}
		return true;
	}

	/**
	 * Permite verificar si la cola de los procesos se encuentra o no vacia.
	 *
	 * @param frame
	 * @param cp
	 * @return
	 */
	public boolean verEstadoCola(JFrame frame, ColaProcesos cp) {
		if (cp.isVacia()) {
			JOptionPane.showMessageDialog(frame, "No_Hay_Procesos_en_Nuevos");
			return false;
		}
		return true;
	}

	/**
	 * Permite verificar si la cola de los bloqueos se encuentra o no vacia.
	 *
	 * @param frame
	 * @param cp
	 * @param jTextField
	 * @return
	 */
	public boolean verEstadoColaBloqueado(JFrame frame, ColaProcesos cp, JTextField jTextField) {
		if (cp.isVacia()) {
			JOptionPane.showMessageDialog(frame, "No_Hay_Procesos_en_Ejecucion");
			jTextField.setText(null);
			return false;
		}
		return true;
	}

	/**
	 * Permite verificar si la cola de procesos no se encuentra vacia, para
	 * poder pausar la ejecucion de la aplicacion.
	 *
	 * @param frame
	 * @param cp
	 * @return
	 */
	public boolean pausarEjecucion(JFrame frame, ColaProcesos cp) {
		if (!(cp.getTamano() > 0)) {
			JOptionPane.showMessageDialog(frame, "Para_pausar_debe_haber_mas_de_un_proceso");
			return false;
		}

		return true;
	}

	/**
	 * Permite verificar si el boton de pausa de la aplicacion esta bloqueado
	 * para poder reanudar la ejecucion, de modo contrario no se podra reanudar.
	 *
	 * @param frame
	 * @param jButton
	 * @return
	 */
	public boolean reanudarEjecucion(JFrame frame, JButton jButton) {
		if (jButton.isEnabled()) {
			return false;
		}
		return true;
	}

}
