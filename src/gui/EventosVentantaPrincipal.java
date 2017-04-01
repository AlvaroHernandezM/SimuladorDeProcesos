package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.Proceso;
import logic.Procesos;

public class EventosVentantaPrincipal implements ActionListener {

	private VentantaPrincipal ventantaPrincipal;

	public EventosVentantaPrincipal(VentantaPrincipal ventantaPrincipal) {
		this.ventantaPrincipal = ventantaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.ventantaPrincipal.jButtonCrear)) {
			this.ventantaPrincipal.getColaProcesos()
					.agregar(new Proceso(this.ventantaPrincipal.jTextFieldNombre.getText(),
							Integer.parseInt(this.ventantaPrincipal.jTextFieldTiempoDeEjecucion.getText())));
			this.ventantaPrincipal.refrescarLista();
		}
		if (e.getSource().equals(this.ventantaPrincipal.jButtonEjecutar)) {
			this.ventantaPrincipal.setProcesos(new Procesos(this.ventantaPrincipal.getColaProcesos()));
			this.ventantaPrincipal.estado = true;
			this.ventantaPrincipal.jButtonEjecutar.setEnabled(false);
			this.ventantaPrincipal.getThread().start();
		}
	}

}
