package AccesosAuxiliares;

import AccesosPrincipales.FrameInicio;
import AccesosPrincipales.FrameLogin;
import ManejoDatos.VerificarDatos;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import poo.javabnb.*;
import java.lang.*;

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
public class FrameDatosBancarios extends javax.swing.JFrame {
    ClienteParticular particular;
    /**
     * Creates new form FrameRegistro
     */
    
    private String[] nombresVariables = {
        
        "jtitular",
        "jnumtarj",
        "jfcaducidad"
    };

    private String[] mensajesOriginales = {
        
        "Ingrese el nombre del titular",
        "Ingrese el numero de tarjeta",
        "Ingrese la fecha de caducidad"
    };
    
    private HashMap<String, JTextField> camposDeTexto = new HashMap<>();

    
    public FrameDatosBancarios() {
        initComponents();
        setTitle("JavaBnB");
        
        // Agregamos los campos de texto al HashMap
       
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jnumtarj = new javax.swing.JTextField();
        bregistrarse = new javax.swing.JButton();
        jtitular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jfcaducidad = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Inicio = new javax.swing.JMenuItem();
        InicioSesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Quit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtelefono.setBackground(new java.awt.Color(220, 154, 98));
        jtelefono.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel11.setText("TITULAR DE LA TARJETA");
        jtelefono.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 170, -1));

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setText("NUMERO DE TARJETA");
        jtelefono.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

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
        jtelefono.add(jnumtarj, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 178, -1));

        bregistrarse.setText("Cambiar Datos");
        bregistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bregistrarseActionPerformed(evt);
            }
        });
        jtelefono.add(bregistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

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
        jtelefono.add(jtitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 178, -1));

        jLabel6.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel6.setText("CAMBIO DATOS BANCARIOS");
        jtelefono.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setText("FECHA DE CADUCIDAD");
        jtelefono.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 180, -1));

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
        jtelefono.add(jfcaducidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 178, -1));
        jtelefono.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        jtelefono.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 180, 20));
        jtelefono.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 180, 20));
        jtelefono.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 180, 20));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jfcaducidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfcaducidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfcaducidadActionPerformed

    private void jtitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtitularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtitularActionPerformed

    private void bregistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bregistrarseActionPerformed
        MetodosAuxiliares ma = new MetodosAuxiliares();
        //TarjetaCredito tj = new TarjetaCredito();
        VerificarDatos vd = new VerificarDatos();
        try{
            if((vd.validarTarjeta(jtitular.getText().trim(),jnumtarj.getText().trim(),jfcaducidad.getText().trim())) == true){

                //Añadir metodo para modificar los datos
                JOptionPane.showMessageDialog(null, "Cambios guardados correctamente");

                FrameLogin fLog = new FrameLogin();
                fLog.setVisible(true);
                dispose();
            }
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al validar el registro: " + e.getMessage());
        }
        
    }//GEN-LAST:event_bregistrarseActionPerformed

    private void jnumtarjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnumtarjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnumtarjActionPerformed

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
            java.util.logging.Logger.getLogger(FrameDatosBancarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameDatosBancarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameDatosBancarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameDatosBancarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameDatosBancarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Inicio;
    private javax.swing.JMenuItem InicioSesion;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JButton bregistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jfcaducidad;
    private javax.swing.JTextField jnumtarj;
    private javax.swing.JPanel jtelefono;
    private javax.swing.JTextField jtitular;
    // End of variables declaration//GEN-END:variables
}
