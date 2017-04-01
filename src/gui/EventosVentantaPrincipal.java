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
			Procesos procesos = new Procesos(this.ventantaPrincipal.getColaProcesos());
			procesos.ventantaPrincipal= this.ventantaPrincipal;
			this.ventantaPrincipal.setProcesos(procesos);
			
			this.ventantaPrincipal.estado = true;
			this.ventantaPrincipal.jButtonEjecutar.setEnabled(false);
			this.ventantaPrincipal.getThread().start();
		}
		if (e.getSource().equals(this.ventantaPrincipal.jButtonBloquear)) {
			this.ventantaPrincipal.getProcesos().getBloqueo().anadirBloqueo(this.ventantaPrincipal.getProcesos().getEjecucion().getProceso());		}
	}

}
