/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package AccesosPrincipales;

import java.awt.Image;
import javax.swing.ImageIcon;
import ManejoDatos.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import poo.javabnb.*;

/**
 *
 * @author Usuario
 */
public class DialogMenuParticular extends javax.swing.JDialog {

    /**
     * Creates new form DialogMenuParticular
     */
    private GestorInmuebles gestorInmuebles = new GestorInmuebles();
    private List<Inmueble> listaInmuebles = gestorInmuebles.obtenerInmuebles();
    private String PATH_IMAGENES="src/main/java/ImagenesDestino/";
    
    
    public DialogMenuParticular(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("JavaBnB");
        
        
        
        agregarInmueblesAlScrollPane(listaInmuebles, scrollPaneReservas);
    }
    
    private void agregarInmueblesAlScrollPane(List<Inmueble> listaInmuebles, JScrollPane scrollPane) {
        JPanel panel = new JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
        
        for (Inmueble inmueble : listaInmuebles) {
            
            //crea un jlabel en el scrollpane con información acerca del inmueble
            String textoInmueble = inmueble.getTitulo()+" C/"+inmueble.getCalle()+", "+inmueble.getCiudad()+" "+inmueble.getCP()+" "+inmueble.getPrecioNoche()+"€/noche Valoración: "+inmueble.getCalificacion()+"/5";
            JLabel label = new JLabel(textoInmueble);
            
            // Añadir MouseListener para capturar clics en el JLabel
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Acción al hacer clic en el JLabel
                    FrameDestinoSeleccionado destino = new FrameDestinoSeleccionado(inmueble);
                    destino.setVisible(true);
                    setVisible(false);
                }
            });
            
            panel.add(label);
            
        }

        scrollPane.setViewportView(panel);
    }
    
    // Método para filtrar inmuebles por ciudad
    private List<Inmueble> filtrarInmuebles(List<Inmueble> listaInmuebles, String query) {
        return listaInmuebles.stream()
                .filter(inmueble -> inmueble.getCiudad().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
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
        buttonInmuebleDispo = new javax.swing.JButton();
        buttonMisReservas = new javax.swing.JButton();
        buttonPerfil = new javax.swing.JButton();
        buttonCerrarSesion = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelExplorarReservas = new javax.swing.JPanel();
        buscador = new javax.swing.JTextField();
        scrollPaneReservas = new javax.swing.JScrollPane();
        panelMisReservas = new javax.swing.JPanel();
        panelMiPerfil = new javax.swing.JPanel();
        PanelPerfil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelDNI = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelTitular = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelCaducidad = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        VIPSuperAnfitrion = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        labelDNI1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(169, 116, 81));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonInmuebleDispo.setText("Explorar Reservas");
        buttonInmuebleDispo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInmuebleDispoActionPerformed(evt);
            }
        });
        jPanel1.add(buttonInmuebleDispo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 130, -1));

        buttonMisReservas.setText("Mis Reservas");
        buttonMisReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMisReservasActionPerformed(evt);
            }
        });
        jPanel1.add(buttonMisReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 130, -1));

        buttonPerfil.setText("Mi Perfil");
        buttonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(buttonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 130, -1));

        buttonCerrarSesion.setText("Cerrar Sesion");
        buttonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 130, -1));

        ImageIcon d = new ImageIcon("src/main/java/com/images/logo2rec.png");
        Image img = d.getImage();
        Image scaledImg = img.getScaledInstance(125, 127, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        jLabel29.setIcon(scaledIcon);
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 125, 127));

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel30.setText("JAVABNB");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 500));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        panelExplorarReservas.setBackground(new java.awt.Color(255, 255, 255));
        panelExplorarReservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscador.setText("🔍 Buscador de destinos");
        buscador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscadorFocusLost(evt);
            }
        });
        buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorActionPerformed(evt);
            }
        });
        panelExplorarReservas.add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 570, -1));
        panelExplorarReservas.add(scrollPaneReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 550, 430));

        jTabbedPane1.addTab("tab1", panelExplorarReservas);

        panelMisReservas.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addTab("tab2", panelMisReservas);

        panelMiPerfil.setBackground(new java.awt.Color(255, 255, 255));

        PanelPerfil.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("MI PERFIL");

        jLabel5.setText("Nombre:");

        labelNombre.setText("______________");

        jLabel7.setText("Correo Electronico:");

        labelCorreo.setText("______________");

        jLabel9.setText("Contraseña:");

        labelContraseña.setText("_____________");

        jLabel11.setText("DNI:");

        labelDNI.setText("_____________");

        jLabel13.setText("Titular Tarjeta");

        labelTitular.setText("______________");

        labelNumero.setText("______________");

        labelCaducidad.setText("______________");

        jLabel17.setText("Numero Tarjeta:");

        jLabel18.setText("Fecha Caducidad:");

        jLabel19.setText("VIP/SuperAnfitrion");

        VIPSuperAnfitrion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIPSuperAnfitrionActionPerformed(evt);
            }
        });

        jLabel12.setText("Telefono:");

        labelDNI1.setText("_____________");

        jButton1.setText("Modificar Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPerfilLayout = new javax.swing.GroupLayout(PanelPerfil);
        PanelPerfil.setLayout(PanelPerfilLayout);
        PanelPerfilLayout.setHorizontalGroup(
            PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPerfilLayout.createSequentialGroup()
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel4))
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(labelNombre)
                            .addComponent(labelCorreo)
                            .addComponent(labelContraseña)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(labelDNI)
                            .addComponent(jLabel12)
                            .addComponent(labelDNI1))
                        .addGap(108, 108, 108)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(labelCaducidad)
                            .addComponent(labelNumero)
                            .addComponent(labelTitular)
                            .addComponent(jLabel13)
                            .addGroup(PanelPerfilLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(VIPSuperAnfitrion))
                            .addComponent(jButton1))))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        PanelPerfilLayout.setVerticalGroup(
            PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPerfilLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VIPSuperAnfitrion)
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(60, 60, 60)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre)
                            .addComponent(labelTitular))
                        .addGap(18, 18, 18)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCorreo)
                            .addComponent(labelNumero))
                        .addGap(18, 18, 18)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelContraseña)
                            .addComponent(labelCaducidad))
                        .addGap(18, 18, 18)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDNI)))
                .addGap(18, 18, 18)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDNI1))
                    .addComponent(jButton1))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        panelMiPerfil.add(PanelPerfil);

        jTabbedPane1.addTab("tab3", panelMiPerfil);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, -40, 590, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInmuebleDispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInmuebleDispoActionPerformed
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_buttonInmuebleDispoActionPerformed

    private void buttonMisReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMisReservasActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_buttonMisReservasActionPerformed

    private void buttonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPerfilActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_buttonPerfilActionPerformed

    private void buttonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarSesionActionPerformed
        // TODO add your handling code here:
        dispose();
        FrameInicio inicio = new FrameInicio();
        inicio.setVisible(true);
        
    }//GEN-LAST:event_buttonCerrarSesionActionPerformed

    private void VIPSuperAnfitrionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIPSuperAnfitrionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VIPSuperAnfitrionActionPerformed

    private void buscadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorFocusGained
        // TODO add your handling code here:
        if (buscador.getText().equals("🔍 Buscador de destinos")){
            buscador.setText("");
        }
    }//GEN-LAST:event_buscadorFocusGained

    private void buscadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorFocusLost
        // TODO add your handling code here:
        if (buscador.getText().equals("")){
            buscador.setText("🔍 Buscador de destinos");
        }
    }//GEN-LAST:event_buscadorFocusLost

    private void buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorActionPerformed
        // TODO add your handling code here:
        String query = buscador.getText();
        List<Inmueble> listaFiltrada = filtrarInmuebles(listaInmuebles, query);
        agregarInmueblesAlScrollPane(listaFiltrada, scrollPaneReservas);
        jLabel30.requestFocus(true);
        buscador.setText("🔍 Buscador de destinos");
    }//GEN-LAST:event_buscadorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FrameDatos md = new FrameDatos();
        md.setVisible(true);
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
            java.util.logging.Logger.getLogger(DialogMenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogMenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogMenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogMenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogMenuParticular dialog = new DialogMenuParticular(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPerfil;
    private javax.swing.JCheckBox VIPSuperAnfitrion;
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buttonCerrarSesion;
    private javax.swing.JButton buttonInmuebleDispo;
    private javax.swing.JButton buttonMisReservas;
    private javax.swing.JButton buttonPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelCaducidad;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelDNI1;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelTitular;
    private javax.swing.JPanel panelExplorarReservas;
    private javax.swing.JPanel panelMiPerfil;
    private javax.swing.JPanel panelMisReservas;
    private javax.swing.JScrollPane scrollPaneReservas;
    // End of variables declaration//GEN-END:variables
}
