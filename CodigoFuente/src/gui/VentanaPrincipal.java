package gui;

import edu.controller.ControllerListener;
import edu.controller.Cronometro;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Clase que maneja la ventana Principal de la aplicacion con todos los
 * componentes graficos.
 *
 * @author
 */
public class VentanaPrincipal extends JFrame {

    private ControllerListener controllerListener;
    private DefaultTableModel defaultTableModel;
    private DefaultTableModel defaultTableModelEjecucion;
    private Eventos eventos;
    private Timer timer;

    /**
     * Constructor con parametro la clase controladora.
     *
     * @param listener
     */
    public VentanaPrincipal(ControllerListener listener) {
        // Graficos
        initComponents();
        this.cuadrarColumnas();
        this.controllerListener = listener;
        this.setTitle("Simulador De Procesos");
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Variables
        this.defaultTableModel = (DefaultTableModel) this.jTableDatos.getModel();
        this.defaultTableModelEjecucion = (DefaultTableModel) this.jTableEjecucion.getModel();

        // EVENTOS
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

    /**
     * retorna el modelo de la tabla de procesos.
     *
     * @return
     */
    public DefaultTableModel getModeloTabla() {
        return defaultTableModel;
    }

    /**
     * Retorna el modelo de la tabla de ejecucion.
     *
     * @return
     */
    public DefaultTableModel getModeloTablaEjecucion() {
        return defaultTableModelEjecucion;
    }

    /**
     * Retorna el campo de nombre de proceso.
     *
     * @return
     */
    public JTextField getCampoNombreProceso() {
        return jTFnombreProceso;
    }

    /**
     * retorna el campo de tiempo de proceso.
     *
     * @return
     */
    public JTextField getCampoTiempoProceso() {
        return jTFtiempoProceso;
    }

    /**
     * Retorna el boton de ejecutar procesos.
     *
     * @return
     */
    public JButton getBotonEjecutar() {
        return jButtonEjecutar;
    }

    /**
     * Retorna el campo correspondiente al tiempo de bloqueo.
     *
     * @return
     */
    public JTextField getCampoBloqueo() {
        return jTFtiempoBloqueo;
    }

    /**
     * retorna el boton de pausar aplicacion.
     *
     * @return
     */
    public JButton getjButtonPausar() {
        return jButtonPausar;
    }

    /**
     * Retorna el boton correspondiente a reanudar aplicacion.
     *
     * @return
     */
    public JButton getjButtonReanudar() {
        return jButtonReanudar;
    }

    /**
     * Retorna el campo de texto correspondiente al Quantum del cpu.
     *
     * @return {@link JTextField}
     */
    public javax.swing.JTextField getjTFQuantumCPU() {
        return jTFQuantumCPU;
    }

    /**
     * Retorna el campo de texto correspondiente al Quantum actual.
     *
     * @return
     */
    public javax.swing.JTextField getjTFQuantumActual() {
        return jTFQuantumActual;
    }

    /**
     * Retorna el Combobox correspondiente al numero de procesadores a manejar.
     *
     * @return
     */
    public JComboBox<String> getjCBnumPros() {
        return jCBnumPros;
    }
    
    
    public JTextField getFieldBloqueoPID (){
        return this.jTextFieldBloquearPID;
    }

    /**
     * Permite establecer el ancho de las columnas de la tabla de procesos.
     */
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
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        jPanel2 = new javax.swing.JPanel();
        jCBnumPros = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jPanelProcesos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jButtonEjecutar = new javax.swing.JButton();
        jPanelEjecucion = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEjecucion = new javax.swing.JTable();
        jPanelBloqueo = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTFtiempoBloqueo = new javax.swing.JTextField();
        jButtonBloquear = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldBloquearPID = new javax.swing.JTextField();
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
        jLabel1.setText("Nombre - (PID) ");

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

        jTFQuantumCPU.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTFQuantumCPU.setForeground(new java.awt.Color(255, 255, 255));
        jTFQuantumCPU.setOpaque(false);
        jTFQuantumCPU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFQuantumCPUKeyTyped(evt);
            }
        });

        jTFQuantumActual.setEditable(false);
        jTFQuantumActual.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTFQuantumActual.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jCBnumPros.setBackground(new java.awt.Color(204, 204, 255));
        jCBnumPros.setMaximumRowCount(7);
        jCBnumPros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jCBnumPros.setPreferredSize(new java.awt.Dimension(35, 18));

        jLabel21.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Num. Procesadores:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCBnumPros, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBnumPros, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelCuantumLayout = new javax.swing.GroupLayout(jPanelCuantum);
        jPanelCuantum.setLayout(jPanelCuantumLayout);
        jPanelCuantumLayout.setHorizontalGroup(
            jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuantumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCuantumLayout.createSequentialGroup()
                        .addGroup(jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFQuantumActual, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jTFQuantumCPU)))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCuantumLayout.setVerticalGroup(
            jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuantumLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addGroup(jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFQuantumActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFQuantumCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCuantumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelProcesos.setBackground(new java.awt.Color(0, 102, 102));

        jLabel6.setFont(new java.awt.Font("Book Antiqua", 1, 16)); // NOI18N
        jLabel6.setText("Lista Procesos");

        jTableDatos.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre (PID)", "Estado", "TiempoBloqueoTotal", "TiempoBloqueo Restante", "TiempoEjecucionTotal", "TiempoEjecucionRestante", "TiempoTotal"
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
            .addGroup(jPanelProcesosLayout.createSequentialGroup()
                .addGroup(jPanelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProcesosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE))
                    .addGroup(jPanelProcesosLayout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProcesosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(405, 405, 405))
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

        jTableEjecucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Procesador", "Nombre (PID)", "Tiempo Restante (s)", "Quantum"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableEjecucion);

        javax.swing.GroupLayout jPanelEjecucionLayout = new javax.swing.GroupLayout(jPanelEjecucion);
        jPanelEjecucion.setLayout(jPanelEjecucionLayout);
        jPanelEjecucionLayout.setHorizontalGroup(
            jPanelEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEjecucionLayout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelEjecucionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanelEjecucionLayout.setVerticalGroup(
            jPanelEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEjecucionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelBloqueo.setBackground(new java.awt.Color(0, 102, 102));

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

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel9.setText("PID:");

        jTextFieldBloquearPID.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTextFieldBloquearPID.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldBloquearPID.setOpaque(false);

        javax.swing.GroupLayout jPanelBloqueoLayout = new javax.swing.GroupLayout(jPanelBloqueo);
        jPanelBloqueo.setLayout(jPanelBloqueoLayout);
        jPanelBloqueoLayout.setHorizontalGroup(
            jPanelBloqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBloqueoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBloqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBloqueoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldBloquearPID))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBloqueoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelBloqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBloqueoLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFtiempoBloqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonBloquear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelBloqueoLayout.setVerticalGroup(
            jPanelBloqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBloqueoLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanelBloqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldBloquearPID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBloqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFtiempoBloqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jButtonBloquear)
                .addContainerGap())
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
                        .addGap(0, 8, Short.MAX_VALUE))))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelBloqueo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelProcesos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAnadirProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonReanudar, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(jButtonPausar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelCrearProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelCuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
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

    private void jTFQuantumCPUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFQuantumCPUKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFQuantumCPUKeyTyped

    /**
     * Permite aceptar solo digitos en el campo de tiempo de proceso.
     *
     * @param evt
     */
    private void jTFtiempoProcesoKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTFtiempoProcesoKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
            evt.consume(); // ignorar el evento de teclado
        }
    }// GEN-LAST:event_jTFtiempoProcesoKeyTyped

    /**
     * Permite aceptar solo digitos en el campo de quantum de proceso.
     *
     * @param evt
     */
    /**
     * Permite aceptar solo digitos en el campo de bloqueo de proceso en
     * ejecucion.
     *
     * @param evt
     */
    private void jTFtiempoBloqueoKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTFtiempoBloqueoKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
            evt.consume(); // ignorar el evento de teclado
        }
    }// GEN-LAST:event_jTFtiempoBloqueoKeyTyped

    /**
     * Permite establecer el nuevo cronometro de la aplicacion.
     *
     * @param evt
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        timer = new Timer(1000, new Cronometro(jlsegungos, jlabelMinutos));
        timer.start();
    }// GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcercaDe;
    private javax.swing.JButton jButtonAnadirProceso;
    private javax.swing.JButton jButtonBloquear;
    private javax.swing.JButton jButtonCrearProceso;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonPausar;
    private javax.swing.JButton jButtonReanudar;
    private javax.swing.JComboBox<String> jCBnumPros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMIcreditos;
    private javax.swing.JMenuItem jMInuevoProceso;
    private javax.swing.JMenuItem jMIsalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBloqueo;
    private javax.swing.JPanel jPanelCrearProceso;
    private javax.swing.JPanel jPanelCuantum;
    private javax.swing.JPanel jPanelEjecucion;
    private javax.swing.JPanel jPanelProcesos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFQuantumActual;
    private javax.swing.JTextField jTFQuantumCPU;
    private javax.swing.JTextField jTFnombreProceso;
    private javax.swing.JTextField jTFtiempoBloqueo;
    private javax.swing.JTextField jTFtiempoProceso;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JTable jTableEjecucion;
    private javax.swing.JTextField jTextFieldBloquearPID;
    private javax.swing.JLabel jlabelMinutos;
    private javax.swing.JLabel jlsegungos;
    // End of variables declaration//GEN-END:variables
}
