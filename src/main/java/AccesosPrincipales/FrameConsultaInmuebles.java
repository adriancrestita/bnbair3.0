/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AccesosPrincipales;

import javax.swing.ImageIcon;

/**
 *
 * @author hugos
 */
public class FrameConsultaInmuebles extends javax.swing.JFrame {

    /**
     * Creates new form FrameConsultaInmuebles
     */
    public FrameConsultaInmuebles() {
        initComponents();
        setTitle("JavaBnB");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        VueltaAdmin = new javax.swing.JMenuItem();
        ConsultaReservas = new javax.swing.JMenuItem();
        ConsultaUser = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenuItem();
        Quit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(220, 154, 98));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA DE INMUEBLES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(169, 116, 81));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageIcon d = new ImageIcon("src/main/java/com/images/logo2rec.png");
        jLabel9.setIcon(d);
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 106, 125));

        jLabel11.setBackground(new java.awt.Color(80, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(80, 0, 0));
        jLabel11.setText("JAVABNB");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 240, 500));

        Menu.setText("Menu");

        ImageIcon admin = new ImageIcon("src/main/java/com/images/admin.png");
        VueltaAdmin.setIcon(admin);
        VueltaAdmin.setText("Panel Admin");
        VueltaAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VueltaAdminActionPerformed(evt);
            }
        });
        Menu.add(VueltaAdmin);

        ImageIcon libro = new ImageIcon("src/main/java/com/images/LibroEmoji.png");
        ConsultaReservas.setIcon(libro);
        ConsultaReservas.setText("Consulta de reservas");
        ConsultaReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaReservasActionPerformed(evt);
            }
        });
        Menu.add(ConsultaReservas);

        ImageIcon persona = new ImageIcon("src/main/java/com/images/PersonaEmoji.png");
        ConsultaUser.setIcon(persona);
        ConsultaUser.setText("Consulta de usuarios");
        ConsultaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaUserActionPerformed(evt);
            }
        });
        Menu.add(ConsultaUser);

        jMenuBar2.add(Menu);

        Salir.setText("Salir");

        ImageIcon cSesion = new ImageIcon("src/main/java/com/images/Puerta.png");
        CerrarSesion.setIcon(cSesion);
        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        Salir.add(CerrarSesion);

        ImageIcon apagar = new ImageIcon("src/main/java/com/images/shootDown.png");
        Quit.setIcon(apagar);
        Quit.setText("Cerrar App");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        Salir.add(Quit);

        jMenuBar2.add(Salir);

        setJMenuBar(jMenuBar2);

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

    private void VueltaAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VueltaAdminActionPerformed
        // TODO add your handling code here:
        FrameAdmin admin= new FrameAdmin();
        admin.setVisible(true);
        dispose();
    }//GEN-LAST:event_VueltaAdminActionPerformed

    private void ConsultaReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaReservasActionPerformed
        // TODO add your handling code here:
        FrameConsultaReservas reservas= new FrameConsultaReservas();
        reservas.setVisible(true);
        dispose();
    }//GEN-LAST:event_ConsultaReservasActionPerformed

    private void ConsultaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaUserActionPerformed
        // TODO add your handling code here:
        FrameConsultaUsers usuarios= new FrameConsultaUsers();
        usuarios.setVisible(true);
        dispose();
    }//GEN-LAST:event_ConsultaUserActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // TODO add your handling code here:
        FrameInicio inicio= new FrameInicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameConsultaInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameConsultaInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameConsultaInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameConsultaInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameConsultaInmuebles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CerrarSesion;
    private javax.swing.JMenuItem ConsultaReservas;
    private javax.swing.JMenuItem ConsultaUser;
    private javax.swing.JMenu Menu;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JMenu Salir;
    private javax.swing.JMenuItem VueltaAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}