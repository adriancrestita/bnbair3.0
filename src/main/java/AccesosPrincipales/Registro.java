package AccesosPrincipales;

import ManejoDatos.GestorAnfitrion;
import ManejoDatos.GestorClientes;
import ManejoDatos.GestorTarjetas;
import ManejoDatos.VerificarDatos;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import poo.javabnb.*;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author crestas
 */
public class Registro extends javax.swing.JFrame {

    
    
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
    private GestorClientes gestorClientes;
    private GestorTarjetas gestorTarjetas;
    private GestorAnfitrion gestorAnfitrion;

    /**
     * Creates new form FrameRegistro
     */
    public Registro() {
        initComponents();
        setResizable(false);
        
        gestorClientes = new GestorClientes();
        gestorTarjetas = new GestorTarjetas();
        gestorAnfitrion = new GestorAnfitrion();

        
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
            
            campo.putClientProperty("JTextField.placeholderText", mensajeOriginal);
            campo.putClientProperty("JComponent.roundRect", true);
            campo.setForeground(UIManager.getColor("TextField.foreground"));

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
        jPanel2 = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jdni = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jesVIP = new javax.swing.JCheckBox();
        jTipoCliente = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtelefono.setBackground(new java.awt.Color(220, 154, 98));
        jtelefono.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jnombre.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jnombre.setForeground(new java.awt.Color(204, 204, 204));
        jnombre.setText("Ingrese el nombre");
        jnombre.setActionCommand("<Not Set>");
        jnombre.setAutoscrolls(false);
        jnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnombreActionPerformed(evt);
            }
        });
        jtelefono.add(jnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 178, -1));

        jphonenumber.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jphonenumber.setForeground(new java.awt.Color(204, 204, 204));
        jphonenumber.setText("Ingrese el teléfono");
        jphonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jphonenumberActionPerformed(evt);
            }
        });
        jtelefono.add(jphonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 178, -1));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel11.setText("TITULAR DE LA TARJETA");
        jtelefono.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 170, -1));

        jmailsign.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jmailsign.setForeground(new java.awt.Color(204, 204, 204));
        jmailsign.setText("Ingrese el correo");
        jmailsign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmailsignActionPerformed(evt);
            }
        });
        jtelefono.add(jmailsign, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 180, -1));

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setText("NUMERO DE TARJETA");
        jtelefono.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, -1, -1));

        jpasswordsign.setForeground(new java.awt.Color(204, 204, 204));
        jpasswordsign.setText("Ingrese la contraseña");
        jtelefono.add(jpasswordsign, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 180, -1));

        jnumtarj.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jnumtarj.setForeground(new java.awt.Color(204, 204, 204));
        jnumtarj.setText("Ingrese el numero de tarjeta");
        jnumtarj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnumtarjActionPerformed(evt);
            }
        });
        jtelefono.add(jnumtarj, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 178, -1));

        bregistrarse.setText("Registrarse");
        bregistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bregistrarseActionPerformed(evt);
            }
        });
        jtelefono.add(bregistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, -1, -1));

        jtitular.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jtitular.setForeground(new java.awt.Color(204, 204, 204));
        jtitular.setText("Ingrese el nombre del titular");
        jtitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtitularActionPerformed(evt);
            }
        });
        jtelefono.add(jtitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 178, -1));

        jLabel6.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel6.setText("REGISTRARSE");
        jtelefono.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setText("FECHA DE CADUCIDAD");
        jtelefono.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 180, -1));

        jfcaducidad.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jfcaducidad.setForeground(new java.awt.Color(204, 204, 204));
        jfcaducidad.setText("Ingrese la fecha de caducidad");
        jfcaducidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfcaducidadActionPerformed(evt);
            }
        });
        jtelefono.add(jfcaducidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 178, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setText("CONTRASEÑA");
        jtelefono.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));
        jtelefono.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jPanel2.setBackground(new java.awt.Color(169, 116, 81));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageIcon d = new ImageIcon("src/main/java/com/images/logo2rec.png");
        Image img = d.getImage();
        Image scaledImg = img.getScaledInstance(125, 127, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        LabelLogo.setIcon(scaledIcon);
        jPanel2.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 125, 127));

        jLabel1.setBackground(new java.awt.Color(80, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 0, 0));
        jLabel1.setText("JAVABNB");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, -1));

        jtelefono.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 510));

        jdni.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jdni.setForeground(new java.awt.Color(204, 204, 204));
        jdni.setText("Ingrese el DNI");
        jdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdniActionPerformed(evt);
            }
        });
        jtelefono.add(jdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 178, -1));

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel15.setText("CORREO");
        jtelefono.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 100, -1));

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel16.setText("NOMBRE");
        jtelefono.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 100, -1));

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel17.setText("TELEFONO");
        jtelefono.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 100, -1));

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel18.setText("DNI");
        jtelefono.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 100, -1));

        jesVIP.setText("Contratar servicio VIP");
        jesVIP.setActionCommand("VipJCheckBox");
        jesVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jesVIPActionPerformed(evt);
            }
        });
        jtelefono.add(jesVIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, -1, -1));

        jTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Anfitrión" }));
        jTipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTipoClienteActionPerformed(evt);
            }
        });
        jtelefono.add(jTipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        ImageIcon s = new ImageIcon("src/main/java/com/images/ojoTachado.png");
        Image image = s.getImage();
        Image scaledImage = image.getScaledInstance(30, 23, Image.SCALE_SMOOTH);
        ImageIcon scaledIcono = new ImageIcon(scaledImage);
        jToggleButton1.setIcon(scaledIcono);
        jToggleButton1.setBackground(new java.awt.Color(220, 154, 98));
        jToggleButton1.setBorder(null);
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.setFocusable(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jtelefono.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 30, 30));

        jButton1.setText("Iniciar sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jtelefono.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmailsignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmailsignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmailsignActionPerformed
    private ClienteParticular particular;
    private TarjetaCredito tj;
    private Anfitrion anf;
    private void bregistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bregistrarseActionPerformed
        MetodosAuxiliares ma = new MetodosAuxiliares();
        VerificarDatos vd = new VerificarDatos();
        String selectedItem = (String) jTipoCliente.getSelectedItem();

        try{
            if ("Cliente".equals(selectedItem)) {
                if((vd.validarRegistro(jmailsign.getText().trim(),jnombre.getText().trim(),jpasswordsign.getText().trim(),jphonenumber.getText().trim(),jdni.getText().trim(), jTipoCliente.getSelectedItem().toString()) == true) && (vd.validarTarjeta(jtitular.getText().trim(),jnumtarj.getText().trim(),jfcaducidad.getText().trim()) == true)){
                   
                    // Crear instancia de ClienteParticular          
                    ClienteParticular nuevoCliente = new ClienteParticular(jdni.getText().trim(), jnombre.getText().trim(), jmailsign.getText().trim(), jpasswordsign.getText().trim(), jphonenumber.getText().trim(), jesVIP.isSelected());
            
                    // Crear instancia de TarjetaCredito
                    TarjetaCredito nuevaTarjeta = new TarjetaCredito(jmailsign.getText().trim(),jtitular.getText().trim(),jnumtarj.getText().trim(), jfcaducidad.getText().trim());

                    // Agregar cliente y tarjeta a los gestores
                    gestorClientes.agregarCliente(nuevoCliente);
                    gestorTarjetas.agregarTarjeta(nuevaTarjeta);
                    JOptionPane.showMessageDialog(this, "Registrado correctamente");
                    Login fLog = new Login();
                    fLog.setVisible(true);
                    dispose();
                } 
                else{
                    JOptionPane.showMessageDialog(this, "Datos inválidos. Por favor, verifique los campos e intente nuevamente.");
                }
            } 
            
            if ("Anfitrión".equals(selectedItem)) {
                if((vd.validarRegistro(jmailsign.getText().trim(),jnombre.getText().trim(),jpasswordsign.getText().trim(),jphonenumber.getText().trim(),jdni.getText().trim(), jTipoCliente.getSelectedItem().toString()) == true) && (vd.validarTarjeta(jtitular.getText().trim(),jnumtarj.getText().trim(),jfcaducidad.getText().trim()) == true)){
                    
                    //Crear instancia de Anfitrion
                    Anfitrion nuevoAnfitrion = new Anfitrion(jdni.getText().trim(), jnombre.getText().trim(), jmailsign.getText().trim(), jpasswordsign.getText().trim(), jphonenumber.getText().trim(), ma.fechaActual(), false);
                    
                    // Crear instancia de TarjetaCredito                  
                    TarjetaCredito nuevaTarjeta = new TarjetaCredito(jmailsign.getText().trim(),jtitular.getText().trim(),jnumtarj.getText().trim(), jfcaducidad.getText().trim());

                    // Agregar anfitrion y tarjeta a los gestores
                    gestorAnfitrion.agregarAnfitrion(nuevoAnfitrion);
                    gestorTarjetas.agregarTarjeta(nuevaTarjeta);
                    JOptionPane.showMessageDialog(this, "Registrado correctamente");
                    Login fl = new Login();
                    fl.setVisible(true);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Datos inválidos. Por favor, verifique los campos e intente nuevamente.");
                }
            }  
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al validar el registro: " + e.getMessage());
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

    private void jesVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jesVIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jesVIPActionPerformed

    private void jTipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTipoClienteActionPerformed
     
        String selectedItem = (String) jTipoCliente.getSelectedItem();
         if ("Cliente".equals(selectedItem)) {
                // Mostrar el botón si se selecciona "Cliente"
                jesVIP.setVisible(true);
                System.out.println("Seleccionaste Cliente.");
            } else if ("Anfitrión".equals(selectedItem)) {
                // Ocultar el botón si se selecciona "Anfitrión"
                jesVIP.setVisible(false);
                System.out.println("Seleccionaste Anfitrión.");
            }
    }//GEN-LAST:event_jTipoClienteActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        
        if (jToggleButton1.isSelected()){
            //Cambiar la imagen
            ImageIcon ojoAbierto = new ImageIcon("src/main/java/com/images/ojoAbierto.png");
            Image img = ojoAbierto.getImage();
            Image scaledImg = img.getScaledInstance(30, 23, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            jToggleButton1.setIcon(scaledIcon);
            jToggleButton1.setText("");
            
            jpasswordsign.setEchoChar((char)0); // Mostrar texto plano
        }
        else{
            //Cambiar la imagen
            ImageIcon ojoAbierto = new ImageIcon("src/main/java/com/images/ojoTachado.png");
            Image img = ojoAbierto.getImage();
            Image scaledImg = img.getScaledInstance(30, 23, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            jToggleButton1.setIcon(scaledIcon);
            jToggleButton1.setText("");
                        
            jpasswordsign.setEchoChar('•'); // Ocultar la contraseña
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JButton bregistrarse;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jTipoCliente;
    private javax.swing.JToggleButton jToggleButton1;
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
