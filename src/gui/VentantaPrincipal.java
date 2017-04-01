package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import logic.ColaProcesos;
import logic.Procesos;

public class VentantaPrincipal extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextField jTextFieldNombre, jTextFieldTiempoDeEjecucion;

	public JButton jButtonCrear, jButtonEjecutar;

	public JLabel jLabelNoticia, jLabelNoticia2;

	private EventosVentantaPrincipal eventosVentantaPrincipal;

	private JTable jTableDatos;

	private DefaultTableModel defaultTableModel;

	private Thread thread;

	public boolean estado;

	private ColaProcesos colaProcesos;

	private Procesos procesos;

	public VentantaPrincipal() {

		this.colaProcesos = new ColaProcesos();

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
		jPanelNorth.add(this.jTextFieldTiempoDeEjecucion = new JTextField());
		jPanelNorth.add(this.jButtonCrear = new JButton("Crear"));
		this.jButtonCrear.addActionListener(this.eventosVentantaPrincipal);

		this.add(jPanelNorth, BorderLayout.NORTH);

		JPanel jPanelLeft = new JPanel(new BorderLayout());
		jPanelLeft.setBorder(BorderFactory.createTitledBorder("Lista de procesos"));

		this.jTableDatos = new JTable();

		this.defaultTableModel = (DefaultTableModel) this.jTableDatos.getModel();
		this.defaultTableModel.addColumn("Id");
		this.defaultTableModel.addColumn("Nombre");
		this.defaultTableModel.addColumn("t restante");
		this.defaultTableModel.addColumn("Estado");
		this.defaultTableModel.addColumn("t bloqueado restante");
		this.defaultTableModel.addColumn("t total");

		JScrollPane jScrollPaneLeft = new JScrollPane(this.jTableDatos);
		jPanelLeft.add(jScrollPaneLeft, BorderLayout.CENTER);

		jPanelLeft.add(this.jButtonEjecutar = new JButton("Ejecutar"), BorderLayout.SOUTH);
		this.jButtonEjecutar.addActionListener(this.eventosVentantaPrincipal);

		JPanel jPanelRight = new JPanel(new BorderLayout());
		jPanelRight.setBorder(BorderFactory.createTitledBorder("Actual"));

		JPanel jPanelCenter = new JPanel(new GridLayout(1, 2));
		jPanelCenter.add(jPanelLeft);
		jPanelCenter.add(jPanelRight);

		this.add(jPanelCenter, BorderLayout.CENTER);

		this.jLabelNoticia = new JLabel(" Listo", JLabel.LEFT);
		this.jLabelNoticia2 = new JLabel("Listo ", JLabel.RIGHT);

		JPanel jPanelSouth = new JPanel(new GridLayout(1, 2));
		jPanelSouth.add(this.jLabelNoticia);
		jPanelSouth.add(this.jLabelNoticia2);
		this.add(jPanelSouth, BorderLayout.SOUTH);

		this.thread = new Thread(this);

		this.estado = false;
	}

	public void refrescarLista() {

		for (int i = 0; i < this.defaultTableModel.getRowCount(); i++) {
			this.defaultTableModel.removeRow(i);
		}

		this.repaint();

		for (int i = 0; i < this.colaProcesos.getDeque().size(); i++) {

			Object[] fila = new Object[6];

			fila[0] = String.valueOf(i);
			fila[1] = this.colaProcesos.getDeque().get(i).getNombre();
			fila[2] = this.colaProcesos.getDeque().get(i).getTiempoEjecucionR();
			fila[3] = this.colaProcesos.getDeque().get(i).getEstado();
			fila[4] = this.colaProcesos.getDeque().get(i).getTiempoBloqueoT();
			fila[5] = this.colaProcesos.getDeque().get(i).getTiempoEjecucionT();

			this.defaultTableModel.addRow(fila);
		}

		this.jTextFieldNombre.setText("");
		this.jTextFieldTiempoDeEjecucion.setText("");

		this.repaint();
	}

	@Override
	public void run() {
		while (this.estado) {
			this.jLabelNoticia.setText(" " + this.procesos.noticia);
			this.jLabelNoticia2.setText(this.procesos.getEjecucion().noticia + " ");
		}
	}

	public JTextField getjTextFieldNombre() {
		return jTextFieldNombre;
	}

	public void setjTextFieldNombre(JTextField jTextFieldNombre) {
		this.jTextFieldNombre = jTextFieldNombre;
	}

	public JTextField getjTextFieldTiempoDeEjecucion() {
		return jTextFieldTiempoDeEjecucion;
	}

	public void setjTextFieldTiempoDeEjecucion(JTextField jTextFieldTiempoDeEjecucion) {
		this.jTextFieldTiempoDeEjecucion = jTextFieldTiempoDeEjecucion;
	}

	public EventosVentantaPrincipal getEventosVentantaPrincipal() {
		return eventosVentantaPrincipal;
	}

	public void setEventosVentantaPrincipal(EventosVentantaPrincipal eventosVentantaPrincipal) {
		this.eventosVentantaPrincipal = eventosVentantaPrincipal;
	}

	public ColaProcesos getColaProcesos() {
		return colaProcesos;
	}

	public void setColaProcesos(ColaProcesos colaProcesos) {
		this.colaProcesos = colaProcesos;
	}

	public Procesos getProcesos() {
		return procesos;
	}

	public void setProcesos(Procesos procesos) {
		this.procesos = procesos;
	}

	public static void main(String[] args) {
		VentantaPrincipal principal = new VentantaPrincipal();
		principal.setVisible(true);
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

}
