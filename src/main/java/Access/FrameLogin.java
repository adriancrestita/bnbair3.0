package Access;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author crestas
 */
public class FrameLogin extends javax.swing.JFrame {
    
    private String mensajeOriginalCorreo = "Introduzca el correo";
    private String mensajeOriginalContraseña = "Introduzca la contraseña";


    /**
     * Creates new form NewJFrame
     */
    public FrameLogin() {
        initComponents();
        jmaillog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Borrar el texto cuando se hace clic en el campo de texto
                if (jmaillog.getText().equals(mensajeOriginalCorreo)) {
                    jmaillog.setText("");
                }
            }
        });

        jpasswordlog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Borrar el texto cuando se hace clic en el campo de texto
                if (jpasswordlog.getText().equals(mensajeOriginalContraseña)) {
                    jpasswordlog.setText("");
                }
            }
        });

        jmaillog.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                // Restaurar el mensaje original si el campo está vacío
                if (jmaillog.getText().isEmpty()) {
                    jmaillog.setText(mensajeOriginalCorreo);
                }
            }
        });

        jpasswordlog.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                // Restaurar el mensaje original si el campo está vacío
                if (jpasswordlog.getText().equals("")) {
                    jpasswordlog.setText(mensajeOriginalContraseña);
                }
            }
        });
        
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jmaillog = new javax.swing.JTextField();
        blogin = new javax.swing.JButton();
        bsignin = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jpasswordlog = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        MostrarContraseña = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MenuInicio = new javax.swing.JMenu();
        PaginaInicial = new javax.swing.JMenuItem();
        Register = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenu();
        Quit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(220, 154, 98));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(204, 204, 255));
        jLabel4.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel4.setText("INICIAR SESIÓN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("CORREO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 70, 20));

        jmaillog.setBackground(new java.awt.Color(220, 154, 98));
        jmaillog.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jmaillog.setForeground(new java.awt.Color(204, 204, 204));
        jmaillog.setText("Introduzca el correo");
        jmaillog.setBorder(null);
        jmaillog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmaillogActionPerformed(evt);
            }
        });
        jPanel1.add(jmaillog, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 178, -1));

        blogin.setText("ENTRAR");
        blogin.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                bloginComponentHidden(evt);
            }
        });
        blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloginActionPerformed(evt);
            }
        });
        jPanel1.add(blogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, -1));

        bsignin.setText("REGISTRARSE");
        bsignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsigninActionPerformed(evt);
            }
        });
        jPanel1.add(bsignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("CONTRASEÑA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 210, -1));

        jpasswordlog.setBackground(new java.awt.Color(220, 154, 98));
        jpasswordlog.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jpasswordlog.setForeground(new java.awt.Color(204, 204, 204));
        jpasswordlog.setText("Introduzca la contraseña");
        jpasswordlog.setBorder(null);
        jPanel1.add(jpasswordlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 210, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 210, -1));

        MostrarContraseña.setText("Mostrar contraseña");
        MostrarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(MostrarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        jPanel2.setBackground(new java.awt.Color(169, 116, 81));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageIcon a = new ImageIcon("src/main/java/com/images/logo2rec.png");
        jLabel9.setIcon(a);
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 106, 125));

        jLabel1.setBackground(new java.awt.Color(80, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 0, 0));
        jLabel1.setText("JAVABNB");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 240, 500));

        MenuInicio.setText("Inicio");

        ImageIcon inicio = new ImageIcon("src/main/java/com/images/logo2icon.png");
        PaginaInicial.setIcon(inicio);
        PaginaInicial.setText("Página inicial");
        PaginaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaginaInicialActionPerformed(evt);
            }
        });
        MenuInicio.add(PaginaInicial);

        Register.setText("Registrarse");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        MenuInicio.add(Register);

        MenuBar.add(MenuInicio);

        MenuSalir.setText("Salir");

        ImageIcon apagar = new ImageIcon("src/main/java/com/images/shootDown.png");
        Quit.setIcon(apagar);
        Quit.setText("Cerrar aplicación");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        MenuSalir.add(Quit);

        MenuBar.add(MenuSalir);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmaillogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmaillogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmaillogActionPerformed

    private void bloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloginActionPerformed
        // TODO add your handling code here:
        if(jmaillog.getText().equals("")||jmaillog.getText().equals(mensajeOriginalCorreo)){
            if(jpasswordlog.getText().equals("")||jpasswordlog.getText().equals(mensajeOriginalContraseña)){
                JOptionPane.showMessageDialog(null, "Rellene el correo y la contraseña");
            }
            else{
                JOptionPane.showMessageDialog(null, "Rellene el correo");
            }
        }
        else if(jpasswordlog.getText().equals("")||jpasswordlog.getText().equals(mensajeOriginalContraseña)){
            JOptionPane.showMessageDialog(null, "Rellene la contraseña");
        }
        else {
            if (jmaillog.getText().equals("admin@javabnb.com")&&(jpasswordlog.getText().equals("admin"))){
                FrameAdmin pantallaAdmin= new FrameAdmin();
                pantallaAdmin.setVisible(true);
                dispose();
            }
            else{
                // codigo para verificar que el correo es válido y acceder como particular o anfitrión
                FrameMenuParticular menuParticular = new FrameMenuParticular();
                menuParticular.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_bloginActionPerformed

    private void bsigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsigninActionPerformed
        // TODO add your handling code here:
        dispose();
        FrameRegistro fsign = new FrameRegistro();
        fsign.setVisible(true);
        
    }//GEN-LAST:event_bsigninActionPerformed

    private void bloginComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_bloginComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_bloginComponentHidden

    private void MostrarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarContraseñaActionPerformed
        // TODO add your handling code here:
        
        if (MostrarContraseña.isSelected()) {
            jpasswordlog.setEchoChar((char)0); // Mostrar texto plano
        }
        else {
            jpasswordlog.setEchoChar('•'); // Ocultar la contraseña
        }
        
    }//GEN-LAST:event_MostrarContraseñaActionPerformed

    private void PaginaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaginaInicialActionPerformed
        // TODO add your handling code here:
        FrameInicio inicio = new FrameInicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_PaginaInicialActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        // TODO add your handling code here:
        FrameRegistro register=new FrameRegistro();
        register.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegisterActionPerformed

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
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLogin().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuInicio;
    private javax.swing.JMenu MenuSalir;
    private javax.swing.JCheckBox MostrarContraseña;
    private javax.swing.JMenuItem PaginaInicial;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JMenuItem Register;
    private javax.swing.JButton blogin;
    private javax.swing.JButton bsignin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jmaillog;
    private javax.swing.JPasswordField jpasswordlog;
    // End of variables declaration//GEN-END:variables
}
