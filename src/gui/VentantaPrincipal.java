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

import logic.Bloqueo;
import logic.ColaProcesos;
import logic.Proceso;
import logic.Procesos;

public class VentantaPrincipal extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextField jTextFieldNombre, jTextFieldTiempoDeEjecucion, jTextFieldTiempoBloqueo;

	public JButton jButtonCrear, jButtonEjecutar, jButtonBloquear;

	public JLabel jLabelNoticia, jLabelNoticia2, jLabelIdActual, jLabelNombreActual, jLabelTiempoRestante,
			jLabelTiempoBloqueo;

	private EventosVentantaPrincipal eventosVentantaPrincipal;

	private JTable jTableDatos;

	private DefaultTableModel defaultTableModel;

	private Thread thread;

	public boolean estado,terminados;

	//private ColaProcesos colaProcesos;
	
	private ColaProcesos colaAgregada;

	private Procesos procesos;
	
	//private Bloqueo bloqueo;

	public VentantaPrincipal() {

		this.colaAgregada = new ColaProcesos();
		this.terminados = false;
//		this.colaProcesos = new ColaProcesos();		
//		this.bloqueo = new Bloqueo();

		this.setTitle("Simulador de procesos");
		this.setSize(900, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		this.eventosVentantaPrincipal = new EventosVentantaPrincipal(this);

		JPanel jPanelNorthLeft = new JPanel(new GridLayout(1, 5));
		jPanelNorthLeft.setBorder(BorderFactory.createTitledBorder("Nuevo proceso"));
		jPanelNorthLeft.add(new JLabel("Nombre:", JLabel.CENTER));
		jPanelNorthLeft.add(this.jTextFieldNombre = new JTextField());
		jPanelNorthLeft.add(new JLabel("Tiempo de ejecuccion:", JLabel.CENTER));
		jPanelNorthLeft.add(this.jTextFieldTiempoDeEjecucion = new JTextField());
		jPanelNorthLeft.add(this.jButtonCrear = new JButton("Crear"));
		this.jButtonCrear.addActionListener(this.eventosVentantaPrincipal);

		this.add(jPanelNorthLeft, BorderLayout.NORTH);

		JPanel jPanelLeft = new JPanel(new BorderLayout());
		jPanelLeft.setBorder(BorderFactory.createTitledBorder("Lista de procesos"));

		this.jTableDatos = new JTable();

		this.defaultTableModel = (DefaultTableModel) this.jTableDatos.getModel();
		this.defaultTableModel.addColumn("Id");
		this.defaultTableModel.addColumn("Nombre");
		this.defaultTableModel.addColumn("t restante");
		this.defaultTableModel.addColumn("Estado");
		this.defaultTableModel.addColumn("tB restante");
		this.defaultTableModel.addColumn("t total");

		JScrollPane jScrollPaneLeft = new JScrollPane(this.jTableDatos);
		jPanelLeft.add(jScrollPaneLeft, BorderLayout.CENTER);

		jPanelLeft.add(this.jButtonEjecutar = new JButton("Ejecutar"), BorderLayout.SOUTH);
		this.jButtonEjecutar.addActionListener(this.eventosVentantaPrincipal);

		JPanel jPanelRight = new JPanel(new BorderLayout());
		jPanelRight.setBorder(BorderFactory.createTitledBorder("Actual"));

		JPanel jPanelRightNorth = new JPanel(new GridLayout(3, 2));
		// jPanelRightNorth.add(new JLabel("Id", JLabel.CENTER));
		// jPanelRightNorth.add(this.jLabelIdActual = new JLabel("",
		// JLabel.CENTER));
		jPanelRightNorth.add(new JLabel("Nombre", JLabel.CENTER));
		jPanelRightNorth.add(this.jLabelNombreActual = new JLabel("", JLabel.CENTER));
		jPanelRightNorth.add(new JLabel("Tiempo de ejecuccion restante (s)", JLabel.CENTER));
		jPanelRightNorth.add(this.jLabelTiempoRestante = new JLabel("", JLabel.CENTER));
		jPanelRightNorth.add(new JLabel("Tiempo de bloqueo", JLabel.CENTER));
		jPanelRightNorth.add(this.jTextFieldTiempoBloqueo = new JTextField());

		jPanelRight.add(jPanelRightNorth, BorderLayout.NORTH);

		jPanelRight.add(this.jButtonBloquear = new JButton("Bloquear"), BorderLayout.SOUTH);
		this.jButtonBloquear.addActionListener(this.eventosVentantaPrincipal);

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
	
	public void agregarProceso(Proceso proceso){
		this.colaAgregada.agregar(proceso);
	}

	public void refrescarLista() {
		for (int i = this.defaultTableModel.getRowCount() - 1; i >= 0; i--) {
			this.defaultTableModel.removeRow(i);
		}

		for (int i = 0; i < this.colaAgregada.getTamano(); i++) {

			Object[] fila = new Object[6];

			fila[0] = String.valueOf(i);
			fila[1] = this.colaAgregada.getProceso(i).getNombre();
			fila[2] = this.colaAgregada.getProceso(i).getTiempoEjecucionR();
			fila[3] = this.colaAgregada.getProceso(i).getEstado();
			fila[4] = this.colaAgregada.getProceso(i).getTiempoBloqueoR();
			fila[5] = this.colaAgregada.getProceso(i).getTiempoEjecucionT();

			this.defaultTableModel.addRow(fila);
		}
		
		if(this.terminados){
			for (int i = 0; i < this.procesos.getBloqueados().getTamano(); i++) {
				Object[] fila = new Object[6];
				
				fila[0] = String.valueOf(i);
				fila[1] = this.procesos.getTerminados().getProceso(i).getNombre();
				fila[2] = this.procesos.getTerminados().getProceso(i).getTiempoEjecucionR();
				fila[3] = this.procesos.getTerminados().getProceso(i).getEstado();
				fila[4] = this.procesos.getTerminados().getProceso(i).getTiempoBloqueoR();
				fila[5] = this.procesos.getTerminados().getProceso(i).getTiempoEjecucionT();
				
				this.defaultTableModel.addRow(fila);
			}
			
			for (int i = 0; i < this.procesos.getTerminados().getTamano(); i++) {
				Object[] fila = new Object[6];
				
				fila[0] = String.valueOf(i);
				fila[1] = this.procesos.getTerminados().getProceso(i).getNombre();
				fila[2] = this.procesos.getTerminados().getProceso(i).getTiempoEjecucionR();
				fila[3] = this.procesos.getTerminados().getProceso(i).getEstado();
				fila[4] = this.procesos.getTerminados().getProceso(i).getTiempoBloqueoR();
				fila[5] = this.procesos.getTerminados().getProceso(i).getTiempoEjecucionT();
				
				this.defaultTableModel.addRow(fila);
			}
		}	

		this.jTextFieldNombre.setText("");
		this.jTextFieldTiempoDeEjecucion.setText("");

		this.repaint();
	}

	public void refrescarActual() {
		String[] infoProceso = this.procesos.getEjecucion().getInfoProceso().split("-");
		this.jLabelNombreActual.setText(infoProceso[0]);
		this.jLabelTiempoRestante.setText(infoProceso[1]);	
	}

	@Override
	public void run() {
		while (this.estado) {
			this.jLabelNoticia.setText(" " + this.procesos.noticia);
			this.jLabelNoticia2.setText(
					this.procesos.getEjecucion().noticia + " // " + this.procesos.getEjecucion().restante + " ");
			if (this.procesos.refrescar) {
				this.refrescarLista();
				this.procesos.refrescar = false;
				this.refrescarActual();//Aui se refresca el proceso actual
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
	
	

	public int getTiempoBloqueo() {
		return Integer.parseInt(jTextFieldTiempoBloqueo.getText());	
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
	
	
	

//	public ColaProcesos getColaProcesos() {
//		return colaProcesos;
//	}
//
//	public void setColaProcesos(ColaProcesos colaProcesos) {
//		this.colaProcesos = colaProcesos;
//	}

	public void setTerminados(boolean terminados) {
		this.terminados = terminados;
	}

	public ColaProcesos getColaAgregada() {
		return colaAgregada;
	}

	public Procesos getProcesos() {
		return procesos;
	}

	public void setProcesos(Procesos procesos) {
		this.procesos = procesos;
	}


	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

//	public Bloqueo getBloqueo() {
//		return bloqueo;
//	}
//
//	public void setBloqueo(Bloqueo bloqueo) {
//		this.bloqueo = bloqueo;
//	}

}
