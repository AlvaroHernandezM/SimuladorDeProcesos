package gui;

import edu.controller.ControllerListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Ventana principal de la aplicacion.
 *
 * @author SO.
 */
public class VentanaPrincipal extends JFrame {

    private ControllerListener controllerListener;
    private DefaultTableModel defaultTableModel;
    private Eventos eventos;

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
        this.eventos.abrirCrearProceso(jButtonAnadirProceso);
        this.eventos.opcionCrearProceso(jMInuevoProceso);
        this.eventos.pausarEjecucion(jButtonPausar);
        this.eventos.reanudarEjecucion(jButtonReanudar);
        this.eventos.anadirMemoria(botonAsignarM);
        this.eventos.botonCompactar(botonCompactar);
        this.eventos.reiniciarAplicacion(jMenuItemReiniciar);
        this.jMenuItemReiniciar.setEnabled(false);

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

    public JButton getjButtonPausar() {
        return jButtonPausar;
    }

    public JButton getjButtonReanudar() {
        return jButtonReanudar;
    }

    public JSlider getSliderTamano() {
        return SliderTamano;
    }

    public JPanel getPanelMemoria() {
        return panelMemoria;
    }

    public JTextField getCampoMemoria() {
        return this.campoMemoria;
    }

    public JPanel panelEtiquetas() {
        return this.panelEtiquetas;
    }

    public JPanel panelTiempo() {
        return this.panelTiempo;
    }

    public JButton getjButton1() {
        return jButton1;
    }
    
    public JPanel getPanelLista (){
        return panelLista;
    }
    
    

    public void cuadrarColumnas() {
        TableColumnModel columnModel = this.jTableDatos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(60);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(70);
        columnModel.getColumn(4).setPreferredWidth(50);
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
        jLabel4 = new javax.swing.JLabel();
        SliderTamano = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        etiquetaTamño = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanelProcesos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jButtonEjecutar = new javax.swing.JButton();
        jButtonAnadirProceso = new javax.swing.JButton();
        jButtonAcercaDe = new javax.swing.JButton();
        jButtonPausar = new javax.swing.JButton();
        jButtonReanudar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        campoMemoria = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        botonAsignarM = new javax.swing.JButton();
        panelMemoria = new javax.swing.JPanel();
        panelLista = new javax.swing.JPanel();
        botonCompactar = new javax.swing.JButton();
        panelTiempo = new javax.swing.JPanel();
        panelEtiquetas = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMIsalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMInuevoProceso = new javax.swing.JMenuItem();
        jMenuItemReiniciar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMIcreditos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        jPanelCrearProceso.setBackground(new java.awt.Color(153, 153, 153));

        jTFnombreProceso.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTFnombreProceso.setForeground(new java.awt.Color(255, 255, 255));
        jTFnombreProceso.setOpaque(false);

        jTFtiempoProceso.setBackground(new java.awt.Color(102, 102, 102));
        jTFtiempoProceso.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTFtiempoProceso.setForeground(new java.awt.Color(255, 255, 255));
        jTFtiempoProceso.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTFtiempoProceso.setOpaque(false);
        jTFtiempoProceso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFtiempoProcesoKeyTyped(evt);
            }
        });

        jButtonCrearProceso.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCrearProceso.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jButtonCrearProceso.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCrearProceso.setText("Crear");

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel2.setText("Tiempo Ejecucion  (s)");

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 16)); // NOI18N
        jLabel3.setText("Nuevo Proceso");

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel4.setText("Tamaño");

        SliderTamano.setMaximum(1000);
        SliderTamano.setMinimum(1);
        SliderTamano.setPaintTicks(true);
        SliderTamano.setValue(1);
        SliderTamano.setOpaque(false);
        SliderTamano.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderTamanoStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel5.setText("1 MB");

        jLabel7.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel7.setText("MAX (MB)");

        etiquetaTamño.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel9.setText("(MB)");

        jButton1.setText("Color");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCrearProcesoLayout = new javax.swing.GroupLayout(jPanelCrearProceso);
        jPanelCrearProceso.setLayout(jPanelCrearProcesoLayout);
        jPanelCrearProcesoLayout.setHorizontalGroup(
            jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel3))
                    .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SliderTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCrearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelCrearProcesoLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(etiquetaTamño, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addGap(11, 11, 11)))))
                .addContainerGap(14, Short.MAX_VALUE))
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
                    .addComponent(jTFtiempoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFnombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SliderTamano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaTamño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCrearProcesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrearProceso)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanelProcesos.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Book Antiqua", 1, 16)); // NOI18N
        jLabel6.setText("Lista Procesos");

        jTableDatos.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Estado", "TiempoEj.Restante", "TiempoEj.Total", "Tamaño (MB)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jButtonEjecutar.setBackground(new java.awt.Color(255, 51, 51));
        jButtonEjecutar.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jButtonEjecutar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEjecutar.setText("Ejecutar");

        javax.swing.GroupLayout jPanelProcesosLayout = new javax.swing.GroupLayout(jPanelProcesos);
        jPanelProcesos.setLayout(jPanelProcesosLayout);
        jPanelProcesosLayout.setHorizontalGroup(
            jPanelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProcesosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(jPanelProcesosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProcesosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        jPanelProcesosLayout.setVerticalGroup(
            jPanelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProcesosLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jButtonEjecutar)
                .addContainerGap())
        );

        jButtonAnadirProceso.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAnadirProceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton_proceso.png"))); // NOI18N
        jButtonAnadirProceso.setToolTipText("crear Proceso");

        jButtonAcercaDe.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/acerca.png"))); // NOI18N
        jButtonAcercaDe.setToolTipText("Créditos");

        jButtonPausar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton_pausa.png"))); // NOI18N
        jButtonPausar.setToolTipText("Pausar Ejecución");

        jButtonReanudar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonReanudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton_play.png"))); // NOI18N
        jButtonReanudar.setToolTipText("Reanudar Ejecución");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel11.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel11.setText("Espacio De Memoria Asignado A Usuario:");

        campoMemoria.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        campoMemoria.setForeground(new java.awt.Color(255, 255, 255));
        campoMemoria.setOpaque(false);
        campoMemoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoMemoriaKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel12.setText("(MB)");

        botonAsignarM.setBackground(new java.awt.Color(255, 51, 51));
        botonAsignarM.setForeground(new java.awt.Color(255, 255, 255));
        botonAsignarM.setText("Asignar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(campoMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(botonAsignarM, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(campoMemoria)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAsignarM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMemoria.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelMemoriaLayout = new javax.swing.GroupLayout(panelMemoria);
        panelMemoria.setLayout(panelMemoriaLayout);
        panelMemoriaLayout.setHorizontalGroup(
            panelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelMemoriaLayout.setVerticalGroup(
            panelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        panelLista.setBackground(new java.awt.Color(255, 255, 255));

        botonCompactar.setBackground(new java.awt.Color(255, 51, 51));
        botonCompactar.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        botonCompactar.setForeground(new java.awt.Color(255, 255, 255));
        botonCompactar.setText("Compactar");

        javax.swing.GroupLayout panelListaLayout = new javax.swing.GroupLayout(panelLista);
        panelLista.setLayout(panelListaLayout);
        panelListaLayout.setHorizontalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaLayout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addComponent(botonCompactar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelListaLayout.setVerticalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCompactar)
                .addContainerGap())
        );

        panelTiempo.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelTiempoLayout = new javax.swing.GroupLayout(panelTiempo);
        panelTiempo.setLayout(panelTiempoLayout);
        panelTiempoLayout.setHorizontalGroup(
            panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panelTiempoLayout.setVerticalGroup(
            panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        panelEtiquetas.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelEtiquetasLayout = new javax.swing.GroupLayout(panelEtiquetas);
        panelEtiquetas.setLayout(panelEtiquetasLayout);
        panelEtiquetasLayout.setHorizontalGroup(
            panelEtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelEtiquetasLayout.setVerticalGroup(
            panelEtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel10.setText("Espacio (MB)");

        jLabel8.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel8.setText("t (seg)");

        jMenu3.setText("Archivo");

        jMIsalir.setText("Salir");
        jMenu3.add(jMIsalir);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Opciones");

        jMInuevoProceso.setText("Nuevo Proceso");
        jMenu1.add(jMInuevoProceso);

        jMenuItemReiniciar.setText("Reiniciar_Aplicacion");
        jMenu1.add(jMenuItemReiniciar);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panelMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelEtiquetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(178, 178, 178)))
                        .addComponent(panelLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAnadirProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPausar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonReanudar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelCrearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAnadirProceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAcercaDe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonReanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCrearProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel10)
                                .addGap(11, 11, 11)
                                .addComponent(panelEtiquetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTiempo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelMemoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void SliderTamanoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderTamanoStateChanged
        this.etiquetaTamño.setText(String.valueOf(this.SliderTamano.getValue()));
    }//GEN-LAST:event_SliderTamanoStateChanged

    private void campoMemoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMemoriaKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_campoMemoriaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jButton1.setBackground(JColorChooser.showDialog(this, "Seleccion color", Color.white));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider SliderTamano;
    private javax.swing.JButton botonAsignarM;
    private javax.swing.JButton botonCompactar;
    private javax.swing.JTextField campoMemoria;
    private javax.swing.JLabel etiquetaTamño;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAcercaDe;
    private javax.swing.JButton jButtonAnadirProceso;
    private javax.swing.JButton jButtonCrearProceso;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonPausar;
    private javax.swing.JButton jButtonReanudar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemReiniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCrearProceso;
    private javax.swing.JPanel jPanelProcesos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFnombreProceso;
    private javax.swing.JTextField jTFtiempoProceso;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JPanel panelLista;
    private javax.swing.JPanel panelMemoria;
    private javax.swing.JPanel panelTiempo;
    // End of variables declaration//GEN-END:variables
}
