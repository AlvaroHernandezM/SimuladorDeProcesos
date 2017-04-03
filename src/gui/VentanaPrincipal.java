package gui;

import edu.controller.ControllerListener;
import edu.controller.Cronometro;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Ventana principal de la aplicacion.
 *
 * @author ffg
 */
public class VentanaPrincipal extends JFrame {

    private ControllerListener controllerListener;
    private DefaultTableModel defaultTableModel;
    private Eventos eventos;
    private Timer timer;

    public VentanaPrincipal(ControllerListener listener) {
        //Graficos
        initComponents();
        this.cuadrarColumnas();
        this.controllerListener = listener;
        this.setTitle("Simulador De Procesos");
        this.setLocationRelativeTo(null);
        this.setVisible(true);

//Variables
        this.defaultTableModel = (DefaultTableModel) this.jTableDatos.getModel();

        //EVENTOS
        this.eventos = new Eventos(listener);
        this.eventos.itemSalir(jMIsalir);
        this.eventos.itemAcercaDe(jMIcreditos, jButtonAcercaDe);
        this.eventos.crearProceso(jButtonCrearProceso);
        this.eventos.ejecutarProceso(jButtonEjecutar);
        this.eventos.bloquearProceso(jButtonBloquear);
        this.eventos.abrirCrearProceso(jButtonAnadirProceso);
        this.eventos.opcionCrearProceso(jMInuevoProceso);
        this.eventos.pausarEjecucion(jButtonPausar);
        this.eventos.reanudarEjecucion(jButtonReanudar);

    }

    //GETTERS
    public DefaultTableModel getModeloTabla() {
        return defaultTableModel;
    }

    public JTextField getCampoNombreProceso() {
        return jTFnombreProceso;
    }

    public JTextField getCampoTiempoProceso() {
        return jTFtiempoProceso;
    }

    public JButton getBotonEjecutar() {
        return jButtonEjecutar;
    }

    public JTextField getCampoNombreEjecucion() {
        return jTFnombreEjecucion;
    }

    public JTextField getCampoTiempoRestante() {
        return jTFtiempoRestante;
    }

    public JTextField getCampoBloqueo() {
        return jTFtiempoBloqueo;
    }

    public JButton getjButtonPausar() {
        return jButtonPausar;
    }

    public JButton getjButtonReanudar() {
        return jButtonReanudar;
    }

    public void cuadrarColumnas() {
        TableColumnModel columnModel = this.jTableDatos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(90);
        columnModel.getColumn(2).setPreferredWidth(90);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(110);
        columnModel.getColumn(6).setPreferredWidth(40);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCrearProceso = new javax.swing.JPanel();
        jTFnombreProceso = new javax.swing.JTextField();
        jTFtiempoProceso = new javax.swing.JTextField();
        jButtonCrearProceso = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelCuantum = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTFQuantumCPU = new javax.swing.JTextField();
        jTFQuantumActual = new javax.swing.JTextField();
        jPanelProcesos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jButtonEjecutar = new javax.swing.JButton();
        jPanelEjecucion = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTFnombreEjecucion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTFtiempoRestante = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanelBloqueo = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTFtiempoBloqueo = new javax.swing.JTextField();
        jButtonBloquear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jlsegungos = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlabelMinutos = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButtonAnadirProceso = new javax.swing.JButton();
        jButtonAcercaDe = new javax.swing.JButton();
        jButtonPausar = new javax.swing.JButton();
        jButtonReanudar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMInuevoProceso = new javax.swing.JMenuItem();
        jMIsalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMIcreditos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelCrearProceso.setBackground(new java.awt.Color(0, 153, 153));

        jTFnombreProceso.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTFnombreProceso.setForeground(new java.awt.Color(255, 255, 255));
        jTFnombreProceso.setOpaque(false);

        jTFtiempoProceso.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTFtiempoProceso.setForeground(new java.awt.Color(255, 255, 255));
        jTFtiempoProceso.setOpaque(false);
        jTFtiempoProceso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFtiempoProcesoKeyTyped(evt);
            }
        });

        jButtonCrearProceso.setBackground(new java.awt.Color(255, 255, 102));
        jButtonCrearProceso.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jButtonCrearProceso.setText("Crear");

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel2.setText("Tiempo Ejecucion  (s)");

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 16)); // NOI18N
        jLabel3.setText("Nuevo Proceso");

        javax.swing.GroupLayout jPanelCrearProcesoLayout = new javax.swing.GroupLayout(jPanelCrearProceso);
        jPanelCrearProceso.setLayout(jPanelCrearProcesoLayout);
        jPanelCrearProcesoLayout.setHorizontalGroup(
            jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                        .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTFnombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFtiempoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCrearProcesoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(11, 11, 11))))
                    .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel3))
                    .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jButtonCrearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCrearProcesoLayout.setVerticalGroup(
            jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCrearProcesoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFtiempoProceso)
                    .addComponent(jTFnombreProceso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCrearProceso)
                .addGap(10, 10, 10))
        );

        jPanelCuantum.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 16)); // NOI18N
        jLabel4.setText("Configuracion");

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 1, 13)); // NOI18N
        jLabel5.setText("Quantum Actual (s):");

        jLabel7.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel7.setText("Quantum CPU (s)");

        jTFQuantumCPU.setEditable(false);
        jTFQuantumCPU.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTFQuantumCPU.setForeground(new java.awt.Color(255, 255, 255));
        jTFQuantumCPU.setOpaque(false);
        jTFQuantumCPU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFQuantumCPUKeyTyped(evt);
            }
        });

        jTFQuantumActual.setEditable(false);

        javax.swing.GroupLayout jPanelCuantumLayout = new javax.swing.GroupLayout(jPanelCuantum);
        jPanelCuantum.setLayout(jPanelCuantumLayout);
        jPanelCuantumLayout.setHorizontalGroup(
            jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuantumLayout.createSequentialGroup()
                .addGroup(jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCuantumLayout.createSequentialGroup()
                        .addContainerGap(127, Short.MAX_VALUE)
                        .addGroup(jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFQuantumActual, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCuantumLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFQuantumCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanelCuantumLayout.setVerticalGroup(
            jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuantumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFQuantumActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTFQuantumCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        jPanelProcesos.setBackground(new java.awt.Color(0, 102, 102));

        jLabel6.setFont(new java.awt.Font("Book Antiqua", 1, 16)); // NOI18N
        jLabel6.setText("Lista Procesos");

        jTableDatos.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Estado", "TiempoBloqueoTotal", "TiempoBloqueo Restante", "TiempoEjecucionTotal", "TiempoEjecucionRestante", "TiempoTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDatos.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTableDatos);

        jButtonEjecutar.setBackground(new java.awt.Color(255, 255, 102));
        jButtonEjecutar.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jButtonEjecutar.setText("Ejecutar");

        javax.swing.GroupLayout jPanelProcesosLayout = new javax.swing.GroupLayout(jPanelProcesos);
        jPanelProcesos.setLayout(jPanelProcesosLayout);
        jPanelProcesosLayout.setHorizontalGroup(
            jPanelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProcesosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(334, 334, 334))
            .addGroup(jPanelProcesosLayout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jButtonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProcesosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelProcesosLayout.setVerticalGroup(
            jPanelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProcesosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEjecutar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEjecucion.setBackground(new java.awt.Color(0, 153, 153));

        jLabel8.setFont(new java.awt.Font("Book Antiqua", 1, 16)); // NOI18N
        jLabel8.setText("En ejecucion");

        jTFnombreEjecucion.setEditable(false);
        jTFnombreEjecucion.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel10.setText("Nombre");

        jTFtiempoRestante.setEditable(false);
        jTFtiempoRestante.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel11.setText("- Tiempo - ");

        jLabel12.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel12.setText("ejcucion-restante (s)");

        jLabel13.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel13.setText("Quantum");

        javax.swing.GroupLayout jPanelEjecucionLayout = new javax.swing.GroupLayout(jPanelEjecucion);
        jPanelEjecucion.setLayout(jPanelEjecucionLayout);
        jPanelEjecucionLayout.setHorizontalGroup(
            jPanelEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEjecucionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTFnombreEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jTFtiempoRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(jPanelEjecucionLayout.createSequentialGroup()
                .addGroup(jPanelEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelEjecucionLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(jPanelEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelEjecucionLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel10)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel12)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel13)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanelEjecucionLayout.setVerticalGroup(
            jPanelEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEjecucionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelEjecucionLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFnombreEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEjecucionLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFtiempoRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanelBloqueo.setBackground(new java.awt.Color(0, 153, 153));

        jLabel14.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel14.setText("Tiempo Bloqueo (s)");

        jTFtiempoBloqueo.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTFtiempoBloqueo.setForeground(new java.awt.Color(255, 255, 255));
        jTFtiempoBloqueo.setOpaque(false);
        jTFtiempoBloqueo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFtiempoBloqueoKeyTyped(evt);
            }
        });

        jButtonBloquear.setBackground(new java.awt.Color(255, 255, 102));
        jButtonBloquear.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jButtonBloquear.setText("Bloquear");

        javax.swing.GroupLayout jPanelBloqueoLayout = new javax.swing.GroupLayout(jPanelBloqueo);
        jPanelBloqueo.setLayout(jPanelBloqueoLayout);
        jPanelBloqueoLayout.setHorizontalGroup(
            jPanelBloqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBloqueoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFtiempoBloqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBloqueoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanelBloqueoLayout.setVerticalGroup(
            jPanelBloqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBloqueoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanelBloqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTFtiempoBloqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonBloquear)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel15.setText("Segundos");

        jlsegungos.setForeground(new java.awt.Color(255, 255, 255));
        jlsegungos.setText("00:00");

        jLabel19.setText(":");

        jLabel16.setText("Minutos");

        jlabelMinutos.setForeground(new java.awt.Color(255, 255, 255));
        jlabelMinutos.setText("00:00");

        jLabel17.setText("Horas");

        jLabel20.setText(":");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("00:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlsegungos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jlabelMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlsegungos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jlabelMinutos)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18)))
        );

        jButtonAnadirProceso.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAnadirProceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus (3).png"))); // NOI18N
        jButtonAnadirProceso.setToolTipText("crear Proceso");

        jButtonAcercaDe.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
        jButtonAcercaDe.setToolTipText("Créditos");

        jButtonPausar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause-button.png"))); // NOI18N
        jButtonPausar.setToolTipText("Pausar Ejecución");

        jButtonReanudar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonReanudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play-button.png"))); // NOI18N
        jButtonReanudar.setToolTipText("Reanudar Ejecución");

        jMenu1.setText("Opciones");

        jMInuevoProceso.setText("Nuevo Proceso");
        jMenu1.add(jMInuevoProceso);

        jMIsalir.setText("Salir");
        jMenu1.add(jMIsalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acerca De");

        jMIcreditos.setText("Créditos");
        jMenu2.add(jMIcreditos);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAnadirProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonReanudar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelCrearProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelCuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelBloqueo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonReanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButtonAnadirProceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAcercaDe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelCrearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelCuantum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBloqueo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFtiempoProcesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFtiempoProcesoKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTFtiempoProcesoKeyTyped

    private void jTFQuantumCPUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFQuantumCPUKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTFQuantumCPUKeyTyped

    private void jTFtiempoBloqueoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFtiempoBloqueoKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTFtiempoBloqueoKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        timer = new Timer(1000, new Cronometro(jlsegungos, jlabelMinutos));
        timer.start();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcercaDe;
    private javax.swing.JButton jButtonAnadirProceso;
    private javax.swing.JButton jButtonBloquear;
    private javax.swing.JButton jButtonCrearProceso;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonPausar;
    private javax.swing.JButton jButtonReanudar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMIcreditos;
    private javax.swing.JMenuItem jMInuevoProceso;
    private javax.swing.JMenuItem jMIsalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBloqueo;
    private javax.swing.JPanel jPanelCrearProceso;
    private javax.swing.JPanel jPanelCuantum;
    private javax.swing.JPanel jPanelEjecucion;
    private javax.swing.JPanel jPanelProcesos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFQuantumActual;
    private javax.swing.JTextField jTFQuantumCPU;
    private javax.swing.JTextField jTFnombreEjecucion;
    private javax.swing.JTextField jTFnombreProceso;
    private javax.swing.JTextField jTFtiempoBloqueo;
    private javax.swing.JTextField jTFtiempoProceso;
    private javax.swing.JTextField jTFtiempoRestante;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel jlabelMinutos;
    private javax.swing.JLabel jlsegungos;
    // End of variables declaration//GEN-END:variables
}
