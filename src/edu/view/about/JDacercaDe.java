package edu.view.about;

import edu.controller.Constants;
import edu.controller.ControllerListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Créditos.
 * @author 
 */
public class JDacercaDe extends JDialog {

    private ControllerListener listener;

    public JDacercaDe(JFrame parent, ControllerListener ln) {
        super(parent, true);
        this.setSize(400, 430);
        this.setLocationRelativeTo(parent);
        initComponents();
        this.listener = ln;
        this.botonSalir();
    }

    public void botonSalir() {
        this.jButton2.addActionListener(listener);
        this.jButton2.setActionCommand(Constants.CERRAR_ACERCA_DE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTFUPTC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTFName = new javax.swing.JTextField();
        jTFIS = new javax.swing.JTextField();
        jTFNameProfessor = new javax.swing.JTextField();
        jTFName1 = new javax.swing.JTextField();
        jTFName2 = new javax.swing.JTextField();
        jTFName3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jTFUPTC.setBackground(new java.awt.Color(0, 0, 0));
        jTFUPTC.setForeground(new java.awt.Color(255, 255, 255));
        jTFUPTC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFUPTC.setText("          UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA");
        jTFUPTC.setEnabled(false);
        jTFUPTC.setFocusable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/uptc.jpg"))); // NOI18N

        jTFName.setBackground(new java.awt.Color(0, 0, 0));
        jTFName.setForeground(new java.awt.Color(255, 255, 255));
        jTFName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFName.setText("Realizado por: FRANCISCO JAVIER BARRERA");
        jTFName.setEnabled(false);

        jTFIS.setBackground(new java.awt.Color(0, 0, 0));
        jTFIS.setForeground(new java.awt.Color(255, 255, 255));
        jTFIS.setText("INGENIERIA SISTEMAS Y COMPUTACIÓN");
        jTFIS.setEnabled(false);

        jTFNameProfessor.setBackground(new java.awt.Color(0, 0, 0));
        jTFNameProfessor.setForeground(new java.awt.Color(255, 255, 255));
        jTFNameProfessor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFNameProfessor.setText("Presentado al ING.  ANDRES ALEJANDRO MORA");
        jTFNameProfessor.setEnabled(false);

        jTFName1.setBackground(new java.awt.Color(0, 0, 0));
        jTFName1.setForeground(new java.awt.Color(255, 255, 255));
        jTFName1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFName1.setText("ALVARO RAMIRO HERNANDEZ");
        jTFName1.setEnabled(false);

        jTFName2.setBackground(new java.awt.Color(0, 0, 0));
        jTFName2.setForeground(new java.awt.Color(255, 255, 255));
        jTFName2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFName2.setText(" FRANCISCO DAVID PARRA");
        jTFName2.setEnabled(false);

        jTFName3.setBackground(new java.awt.Color(0, 0, 0));
        jTFName3.setForeground(new java.awt.Color(255, 255, 255));
        jTFName3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFName3.setText("ANDREA KATHERINE VELANDIA");
        jTFName3.setEnabled(false);

        jButton2.setText("Atrás");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 125, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTFName3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFName1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFUPTC, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFName2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFNameProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTFUPTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFNameProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFIS;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTextField jTFName1;
    private javax.swing.JTextField jTFName2;
    private javax.swing.JTextField jTFName3;
    private javax.swing.JTextField jTFNameProfessor;
    private javax.swing.JTextField jTFUPTC;
    // End of variables declaration//GEN-END:variables
}
