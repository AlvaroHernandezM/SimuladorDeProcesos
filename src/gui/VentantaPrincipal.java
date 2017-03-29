package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentantaPrincipal extends JFrame{
	
	private JTextField jTextFieldNombre, jTextFieldTiempoDeEjecucion;
	
	public JButton jButtonCrear;
	
	private EventosVentantaPrincipal eventosVentantaPrincipal;

	public VentantaPrincipal() {
	
		this.setTitle("Simulador de procesos");
		this.setSize(900, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		this.eventosVentantaPrincipal = new EventosVentantaPrincipal(this);
		
		JPanel jPanelNorth = new JPanel(new GridLayout(1, 5));
		jPanelNorth.setBorder(BorderFactory.createTitledBorder("Nuevo proceso"));
		jPanelNorth.add(new JLabel("Nombre:", JLabel.CENTER));
		jPanelNorth.add(this.jTextFieldNombre = new JTextField());
		jPanelNorth.add(new JLabel("Tiempo de ejecuccion:", JLabel.CENTER));
		jPanelNorth.add(this.jTextFieldTiempoDeEjecucion =  new JTextField());
		jPanelNorth.add(this.jButtonCrear = new JButton("Crear"));
		this.jButtonCrear.addActionListener(this.eventosVentantaPrincipal);
		
		this.add(jPanelNorth, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		VentantaPrincipal principal = new VentantaPrincipal();
		principal.setVisible(true);
	}
}
