package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosVentantaPrincipal implements ActionListener{
	
	private VentantaPrincipal ventantaPrincipal;
	
	public EventosVentantaPrincipal(VentantaPrincipal ventantaPrincipal) {
this.ventantaPrincipal = ventantaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.ventantaPrincipal.jButtonCrear)) {
			System.out.println("crear");
		}
		
	}

}
