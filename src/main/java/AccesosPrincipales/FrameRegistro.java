package AccesosPrincipales;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import poo.javabnb.*;
import java.lang.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import java.util.Collections;
import poo.javabnb.*;
import java.lang.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author crestas
 */
public class FrameRegistro extends javax.swing.JFrame {

    /**
     * Creates new form FrameRegistro
     */
    
    private String[] nombresVariables = {
        "jmailsign",
        "jpasswordsign",
        "jphonenumber",
        "jdni",
        "jnombre",
        "jtitular",
        "jnumtarj",
        "jfcaducidad"
    };

    private String[] mensajesOriginales = {
        "Ingrese el correo",
        "Ingrese la contraseña",
        "Ingrese el teléfono",
        "Ingrese el DNI",
        "Ingrese el nombre",
        "Ingrese el nombre del titular",
        "Ingrese el numero de tarjeta",
        "Ingrese la fecha de caducidad"
    };
    
    private HashMap<String, JTextField> camposDeTexto = new HashMap<>();

    
    public FrameRegistro() {
        initComponents();
        jLabel6.requestFocus(true);
        setTitle("JavaBnB");
        
        // Agregamos los campos de texto al HashMap
        camposDeTexto.put("jmailsign", jmailsign);
        camposDeTexto.put("jpasswordsign", jpasswordsign);
        camposDeTexto.put("jphonenumber", jphonenumber);
        camposDeTexto.put("jdni", jdni);
        camposDeTexto.put("jnombre", jnombre);
        camposDeTexto.put("jtitular", jtitular);
        camposDeTexto.put("jnumtarj", jnumtarj);
        camposDeTexto.put("jfcaducidad", jfcaducidad);

        for (int i = 0; i < nombresVariables.length; i++) {
            JTextField campo = camposDeTexto.get(nombresVariables[i]);
            final String mensajeOriginal = mensajesOriginales[i];

            campo.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (campo.getText().equals(mensajeOriginal)) {
                        campo.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (campo.getText().isEmpty()) {
                        campo.setText(mensajeOriginal);
                    }
                }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtelefono = new javax.swing.JPanel();
        jnombre = new javax.swing.JTextField();
        jphonenumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jmailsign = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jpasswordsign = new javax.swing.JPasswordField();
        jnumtarj = new javax.swing.JTextField();
        bregistrarse = new javax.swing.JButton();
        jtitular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jfcaducidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jAnfitrion = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jdni = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jesVIP = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Inicio = new javax.swing.JMenuItem();
        InicioSesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Quit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtelefono.setBackground(new java.awt.Color(220, 154, 98));
        jtelefono.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jnombre.setBackground(new java.awt.Color(220, 154, 98));
        jnombre.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jnombre.setForeground(new java.awt.Color(204, 204, 204));
        jnombre.setText("Ingrese el nombre");
        jnombre.setBorder(null);
        jnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnombreActionPerformed(evt);
            }
        });
        jtelefono.add(jnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 178, -1));

        jphonenumber.setBackground(new java.awt.Color(220, 154, 98));
        jphonenumber.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jphonenumber.setForeground(new java.awt.Color(204, 204, 204));
        jphonenumber.setText("Ingrese el teléfono");
        jphonenumber.setBorder(null);
        jphonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jphonenumberActionPerformed(evt);
            }
        });
        jtelefono.add(jphonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 178, -1));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel11.setText("TITULAR DE LA TARJETA");
        jtelefono.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 170, -1));

        jmailsign.setBackground(new java.awt.Color(220, 154, 98));
        jmailsign.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jmailsign.setForeground(new java.awt.Color(204, 204, 204));
        jmailsign.setText("Ingrese el correo");
        jmailsign.setBorder(null);
        jmailsign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmailsignActionPerformed(evt);
            }
        });
        jtelefono.add(jmailsign, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 180, -1));

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setText("NUMERO DE TARJETA");
        jtelefono.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        jpasswordsign.setBackground(new java.awt.Color(220, 154, 98));
        jpasswordsign.setForeground(new java.awt.Color(204, 204, 204));
        jpasswordsign.setText("Ingrese la contraseña");
        jpasswordsign.setBorder(null);
        jtelefono.add(jpasswordsign, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 180, -1));

        jnumtarj.setBackground(new java.awt.Color(220, 154, 98));
        jnumtarj.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jnumtarj.setForeground(new java.awt.Color(204, 204, 204));
        jnumtarj.setText("Ingrese el numero de tarjeta");
        jnumtarj.setBorder(null);
        jnumtarj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnumtarjActionPerformed(evt);
            }
        });
        jtelefono.add(jnumtarj, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 178, -1));

        bregistrarse.setText("Registrarse");
        bregistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bregistrarseActionPerformed(evt);
            }
        });
        jtelefono.add(bregistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, -1, -1));

        jtitular.setBackground(new java.awt.Color(220, 154, 98));
        jtitular.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jtitular.setForeground(new java.awt.Color(204, 204, 204));
        jtitular.setText("Ingrese el nombre del titular");
        jtitular.setBorder(null);
        jtitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtitularActionPerformed(evt);
            }
        });
        jtelefono.add(jtitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 178, -1));

        jLabel6.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel6.setText("REGISTRARSE");
        jtelefono.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setText("FECHA DE CADUCIDAD");
        jtelefono.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 180, -1));

        jfcaducidad.setBackground(new java.awt.Color(220, 154, 98));
        jfcaducidad.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jfcaducidad.setForeground(new java.awt.Color(204, 204, 204));
        jfcaducidad.setText("Ingrese la fecha de caducidad");
        jfcaducidad.setBorder(null);
        jfcaducidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfcaducidadActionPerformed(evt);
            }
        });
        jtelefono.add(jfcaducidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 178, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setText("CONTRASEÑA");
        jtelefono.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jtelefono.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        jtelefono.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 180, 20));
        jtelefono.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 180, 20));
        jtelefono.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 180, 20));
        jtelefono.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 180, 20));
        jtelefono.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 180, 20));
        jtelefono.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 180, 20));
        jtelefono.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 180, 20));

        jAnfitrion.setText("Registrarse como anfitrión");
        jAnfitrion.setActionCommand("VipJCheckBox");
        jtelefono.add(jAnfitrion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        jPanel2.setBackground(new java.awt.Color(169, 116, 81));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageIcon a = new ImageIcon("src/main/java/com/images/logo2rec.png");
        LabelLogo.setIcon(a);
        jPanel2.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 106, 125));

        jLabel1.setBackground(new java.awt.Color(80, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 0, 0));
        jLabel1.setText("JAVABNB");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, -1));

        jtelefono.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 240, 510));
        jtelefono.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 180, 20));

        jdni.setBackground(new java.awt.Color(220, 154, 98));
        jdni.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jdni.setForeground(new java.awt.Color(204, 204, 204));
        jdni.setText("Ingrese el DNI");
        jdni.setBorder(null);
        jdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdniActionPerformed(evt);
            }
        });
        jtelefono.add(jdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 178, -1));

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel15.setText("CORREO");
        jtelefono.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 100, -1));

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel16.setText("NOMBRE");
        jtelefono.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 100, -1));

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel17.setText("TELEFONO");
        jtelefono.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 100, -1));

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel18.setText("DNI");
        jtelefono.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 100, -1));

        jesVIP.setText("Contratar servicio VIP");
        jesVIP.setActionCommand("VipJCheckBox");
        jtelefono.add(jesVIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jMenu1.setText("Inicio");

        Inicio.setText("Página inicial");
        Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioActionPerformed(evt);
            }
        });
        jMenu1.add(Inicio);

        InicioSesion.setText("Iniciar sesión");
        InicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioSesionActionPerformed(evt);
            }
        });
        jMenu1.add(InicioSesion);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");

        Quit.setText("Cerrar aplicación");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        jMenu2.add(Quit);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmailsignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmailsignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmailsignActionPerformed

    private void bregistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bregistrarseActionPerformed
        MetodosAuxiliares ma = new MetodosAuxiliares();
        ClienteParticular particular = new ClienteParticular(jnombre.getText(), jnombre.getText(), jmailsign.getText(), jpasswordsign.getText(), jphonenumber.getText(), jAnfitrion.isEnabled());
        TarjetaCredito tj = new TarjetaCredito(jtitular.getText().trim(),jnumtarj.getText().trim(),jfcaducidad.getText().trim(),jnombre.getText(), jnombre.getText(), jmailsign.getText(), jpasswordsign.getText(), jphonenumber.getText(), jAnfitrion.isEnabled());
        try{
            if(jAnfitrion.isSelected()){
                if((ma.validarFormulario(jmailsign.getText().trim(),jnombre.getText().trim(),jpasswordsign.getText().trim(),jphonenumber.getText().trim(),jdni.getText().trim(),jtitular.getText().trim(),jnumtarj.getText().trim(),jfcaducidad.getText().trim(),jesVIP.isSelected())) == true){
                   //Asignamos valores a los atributos con los SET de Cliente Particular
                   particular.setDni(jdni.getText().trim());
                   particular.setNombre(jnombre.getText().trim());
                   particular.setCorreoElectronico(jmailsign.getText().trim());
                   particular.setClave(String.valueOf(jpasswordsign.getText().trim()));
                   particular.setTelefono(jphonenumber.getText().trim());
                   particular.setesVIP(jAnfitrion.isSelected());

                   tj.setFechaCaducidad(jfcaducidad.getText().trim());
                   tj.setNombreTitular(jtitular.getText().trim());
                   tj.setNumeroTarjeta(jnumtarj.getText().trim());

                   particular.guardarParticular();
                   tj.guardarTarjeta();

                   FrameLogin fLog = new FrameLogin();
                   fLog.setVisible(true);
                   dispose();
               }   
            }
            if(!jAnfitrion.isSelected()){
                if((ma.validarFormulario(jmailsign.getText().trim(),jnombre.getText().trim(),jpasswordsign.getText().trim(),jphonenumber.getText().trim(),jdni.getText().trim(),jtitular.getText().trim(),jnumtarj.getText().trim(),jfcaducidad.getText().trim(),jAnfitrion.isSelected())) == true ){
                    //Asignamos valores a los atributos con los SET de Cliente Particular
                    particular.setDni(jdni.getText().trim());
                    particular.setNombre(jnombre.getText().trim());
                    particular.setCorreoElectronico(jmailsign.getText().trim());
                    particular.setClave(String.valueOf(jpasswordsign.getText().trim()));
                    particular.setTelefono(jphonenumber.getText().trim());
                    particular.setesVIP(jAnfitrion.isSelected());

                    tj.setFechaCaducidad(jfcaducidad.getText().trim());
                    tj.setNombreTitular(jtitular.getText().trim());
                    tj.setNumeroTarjeta(jnumtarj.getText().trim());

                    particular.guardarParticular();
                    tj.guardarTarjeta();

                    FrameLogin fLog = new FrameLogin();
                    fLog.setVisible(true);
                    dispose();
                }
            }
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al validar el registro: " + e.getMessage());
        }
        
       
    }//GEN-LAST:event_bregistrarseActionPerformed

    private void jnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnombreActionPerformed

    private void jphonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jphonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jphonenumberActionPerformed

    private void jnumtarjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnumtarjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnumtarjActionPerformed

    private void jtitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtitularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtitularActionPerformed

    private void jfcaducidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfcaducidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfcaducidadActionPerformed

    private void jdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdniActionPerformed

    private void InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioActionPerformed
        // TODO add your handling code here:
        FrameInicio inicio = new FrameInicio();
        inicio.setVisible(true);
    }//GEN-LAST:event_InicioActionPerformed

    private void InicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioSesionActionPerformed
        // TODO add your handling code here:
        FrameLogin login = new FrameLogin();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_InicioSesionActionPerformed

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
            java.util.logging.Logger.getLogger(FrameRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Inicio;
    private javax.swing.JMenuItem InicioSesion;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JButton bregistrarse;
    private javax.swing.JCheckBox jAnfitrion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jdni;
    private javax.swing.JCheckBox jesVIP;
    private javax.swing.JTextField jfcaducidad;
    private javax.swing.JTextField jmailsign;
    private javax.swing.JTextField jnombre;
    private javax.swing.JTextField jnumtarj;
    private javax.swing.JPasswordField jpasswordsign;
    private javax.swing.JTextField jphonenumber;
    private javax.swing.JPanel jtelefono;
    private javax.swing.JTextField jtitular;
    // End of variables declaration//GEN-END:variables
}
