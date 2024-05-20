/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package AccesosPrincipales;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author Usuario
 */
public class DialogMenuAdmin extends javax.swing.JDialog {

    /**
     * Creates new form DialogMenuAdmin
     */
    private ArrayList<String> titulosInmuebles; // Variable para almacenar los destinos
    private ArrayList<String> titulosReservas; // Variable para almacenar los destinos
    private ArrayList<String> titulosUsuarios; // Variable para almacenar los destinos
    
    
    public DialogMenuAdmin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("JavaBnB");
        titulosInmuebles = new ArrayList<>(); // Inicializa la lista de destinos
        cargarInmueblesDesdeArchivo("inmuebles.txt");
        cargarReservasDesdeArchivo("reservas.txt");
        cargarUsuariosDesdeArchivo("Users.txt");
        mostrarInmuebles();
        mostrarReservas();
        mostrarUsuarios();
        
        //Buscador de Inmuebles
        // Crea un nuevo JScrollPane y agrega el panel de inmuebles
        JScrollPane panelInmuebles = new JScrollPane(panelDeInmuebles);
        // Establece la política de desplazamiento vertical
        panelInmuebles.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // Agrega el JScrollPane al panel jPanel2
        jPanel2.add(panelInmuebles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 400));
        
        // Agrega un ActionListener al buscador
        Buscador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarDestinos();
                jLabel29.requestFocus(true);
                Buscador.setText(" 🔍 Buscador de destinos");
            }
        });
        
        //Buscador de reservas
        // Crea un nuevo JScrollPane y agrega el panel de inmuebles
        JScrollPane panelReservas = new JScrollPane(panelDeReservas);
        // Establece la política de desplazamiento vertical
        panelReservas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // Agrega el JScrollPane al panel jPanel2
        jPanel3.add(panelReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 400));
        
        // Agrega un ActionListener al buscador
        Buscador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuarios();
                jLabel29.requestFocus(true);
                Buscador1.setText(" 🔍 Buscador de destinos");
            }
        });
        
        //Buscador de Usuarios
        // Crea un nuevo JScrollPane y agrega el panel de usuarios
        JScrollPane panelUser = new JScrollPane(panelDeUsuarios);
        // Establece la política de desplazamiento vertical
        panelUser.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // Agrega el JScrollPane al panel jPanel4
        jPanel4.add(panelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 400));

        // Agrega un ActionListener al buscador
        Buscador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuarios();
                jLabel29.requestFocus(true);
                Buscador2.setText(" 🔍 Buscador de Usuarios");
            }
        });
    
    }  
    
    private void cargarInmueblesDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Agregar el destino al ArrayList de destinos
                titulosInmuebles.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarInmuebles() {
        panelDeInmuebles.removeAll(); // Limpiar el panel
        panelDeInmuebles.setLayout(new GridLayout(0, 1)); // Establecer GridLayout

        // Agregar un JLabel para cada destino
        for (String destino : titulosInmuebles) {
            JLabel label = new JLabel(destino);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            panelDeInmuebles.add(label);
        }

        // Actualizar el panel
        panelDeInmuebles.revalidate();
        panelDeInmuebles.repaint();
    }
    
    private void buscarDestinos() {
        String filtro = Buscador.getText().trim().toLowerCase();
        panelDeInmuebles.removeAll(); // Limpiar el panel

        // Filtrar los destinos según el texto de búsqueda
        for (String destino : titulosInmuebles) {
            if (destino.toLowerCase().contains(filtro)) {
                JLabel label = new JLabel(destino);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                panelDeInmuebles.add(label);
            }
        }

        // Actualizar el panel
        panelDeInmuebles.revalidate();
        panelDeInmuebles.repaint();
    }
    
    private void cargarReservasDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            titulosReservas = new ArrayList<>(); // Inicializa la lista de reservas
            while ((linea = br.readLine()) != null) {
                titulosReservas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarReservas() {
        panelDeReservas.removeAll(); // Limpiar el panel
        panelDeReservas.setLayout(new GridLayout(0, 1)); // Establecer GridLayout

        // Agregar un JLabel para cada reserva
        for (String reserva : titulosReservas) {
            JLabel label = new JLabel(reserva);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            panelDeReservas.add(label);
        }

        // Actualizar el panel
        panelDeReservas.revalidate();
        panelDeReservas.repaint();
    }

    private void buscarReservas() {
        String filtro = Buscador1.getText().trim().toLowerCase();
        panelDeReservas.removeAll(); // Limpiar el panel

        // Filtrar las reservas según el texto de búsqueda
        for (String reserva : titulosReservas) {
            if (reserva.toLowerCase().contains(filtro)) {
                JLabel label = new JLabel(reserva);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                panelDeReservas.add(label);
            }
        }

        // Actualizar el panel
        panelDeReservas.revalidate();
        panelDeReservas.repaint();
    }
    
    private void cargarUsuariosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            titulosUsuarios = new ArrayList<>(); // Inicializa la lista de usuarios
            while ((linea = br.readLine()) != null) {
                titulosUsuarios.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarUsuarios() {
        panelDeUsuarios.removeAll(); // Limpiar el panel
        panelDeUsuarios.setLayout(new GridLayout(0, 1)); // Establecer GridLayout

        // Agregar un JLabel para cada usuario
        for (String usuario : titulosUsuarios) {
            JLabel label = new JLabel(usuario);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            panelDeUsuarios.add(label);
        }

        // Actualizar el panel
        panelDeUsuarios.revalidate();
        panelDeUsuarios.repaint();
    }

    private void buscarUsuarios() {
        String filtro = Buscador2.getText().trim().toLowerCase();
        panelDeUsuarios.removeAll(); // Limpiar el panel

        // Filtrar los usuarios según el texto de búsqueda
        for (String usuario : titulosUsuarios) {
            if (usuario.toLowerCase().contains(filtro)) {
                JLabel label = new JLabel(usuario);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                panelDeUsuarios.add(label);
            }
        }

        // Actualizar el panel
        panelDeUsuarios.revalidate();
        panelDeUsuarios.repaint();
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
        buttonUser = new javax.swing.JButton();
        buttonCerrarSesion = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        buttonReservas = new javax.swing.JButton();
        buttonInmuebles = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Buscador = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        panelDeInmuebles = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Buscador1 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        panelDeReservas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Buscador2 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        panelDeUsuarios = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(169, 116, 81));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonUser.setText("Consulta de Usuarios");
        buttonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserActionPerformed(evt);
            }
        });
        jPanel1.add(buttonUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 160, -1));

        buttonCerrarSesion.setText("Cerrar Sesion");
        buttonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 160, -1));

        ImageIcon d = new ImageIcon("src/main/java/com/images/logo2rec.png");
        Image img = d.getImage();
        Image scaledImg = img.getScaledInstance(125, 127, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        jLabel29.setIcon(scaledIcon);
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 125, 127));

        jLabel30.setBackground(new java.awt.Color(80, 0, 0));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel30.setText("JAVABNB");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 90, -1));

        buttonReservas.setText("Consulta de Reservas");
        buttonReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReservasActionPerformed(evt);
            }
        });
        jPanel1.add(buttonReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 160, -1));

        buttonInmuebles.setText("Consulta de Inmuebles");
        buttonInmuebles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInmueblesActionPerformed(evt);
            }
        });
        jPanel1.add(buttonInmuebles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Consulta de Inmuebles");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 39, -1, -1));

        Buscador.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        Buscador.setText(" 🔍 Buscador de destinos");
        Buscador.setBorder(null);
        Buscador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscadorFocusLost(evt);
            }
        });
        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });
        jPanel2.add(Buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 550, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 550, 20));

        panelDeInmuebles.setBackground(new java.awt.Color(255, 255, 255));
        panelDeInmuebles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(panelDeInmuebles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 400));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Consulta de Reservas");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 39, -1, -1));

        Buscador1.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        Buscador1.setText(" 🔍 Buscador de Reservas");
        Buscador1.setBorder(null);
        Buscador1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Buscador1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Buscador1FocusLost(evt);
            }
        });
        Buscador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscador1ActionPerformed(evt);
            }
        });
        jPanel3.add(Buscador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 550, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 550, 20));

        panelDeReservas.setBackground(new java.awt.Color(255, 255, 255));
        panelDeReservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(panelDeReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 400));

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Consulta de Usuarios");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 39, -1, -1));

        Buscador2.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        Buscador2.setText(" 🔍 Buscador de Usuarios");
        Buscador2.setBorder(null);
        Buscador2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Buscador2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Buscador2FocusLost(evt);
            }
        });
        Buscador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscador2ActionPerformed(evt);
            }
        });
        jPanel4.add(Buscador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 550, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 550, 20));

        panelDeUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        panelDeUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(panelDeUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 400));

        jTabbedPane1.addTab("tab3", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, -50, 590, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUserActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        //DialogCrearInmuebles dci = new DialogCrearInmuebles();

    }//GEN-LAST:event_buttonUserActionPerformed

    private void buttonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarSesionActionPerformed
        // TODO add your handling code here:
        FrameInicio inicio = new FrameInicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonCerrarSesionActionPerformed

    private void buttonReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReservasActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_buttonReservasActionPerformed

    private void buttonInmueblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInmueblesActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_buttonInmueblesActionPerformed

    private void BuscadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscadorFocusGained
        // TODO add your handling code here:
        if (Buscador.getText().equals(" 🔍 Buscador de destinos")){
            Buscador.setText("");
        }
    }//GEN-LAST:event_BuscadorFocusGained

    private void BuscadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscadorFocusLost
        // TODO add your handling code here:
        if (Buscador.getText().equals("")){
            Buscador.setText(" 🔍 Buscador de destinos");
        }
    }//GEN-LAST:event_BuscadorFocusLost

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
        if (Buscador.getText().equals(" 🔍 Buscador de destinos")){
            Buscador.setText("");
        }
    }//GEN-LAST:event_BuscadorActionPerformed

    private void Buscador1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Buscador1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador1FocusGained

    private void Buscador1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Buscador1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador1FocusLost

    private void Buscador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador1ActionPerformed

    private void Buscador2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Buscador2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador2FocusGained

    private void Buscador2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Buscador2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador2FocusLost

    private void Buscador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscador2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador2ActionPerformed

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
            java.util.logging.Logger.getLogger(DialogMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogMenuAdmin dialog = new DialogMenuAdmin(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField Buscador;
    private javax.swing.JTextField Buscador1;
    private javax.swing.JTextField Buscador2;
    private javax.swing.JButton buttonCerrarSesion;
    private javax.swing.JButton buttonInmuebles;
    private javax.swing.JButton buttonReservas;
    private javax.swing.JButton buttonUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelDeInmuebles;
    private javax.swing.JPanel panelDeReservas;
    private javax.swing.JPanel panelDeUsuarios;
    // End of variables declaration//GEN-END:variables
}
