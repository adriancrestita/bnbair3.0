/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AccesosPrincipales;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author adria
 */
public class FrameConsultaReservas extends javax.swing.JFrame {

    /**
     * Creates new form FrameConsultaReservas
     */
    
    //Declaración de atributos
    public static List<String> reservas; // Lista de inmuebles disponibles
    public static int currentPage; // Página actual de resultados
    public static final String IMAGENES_DESTINO_PATH = "src/main/java/ImagenesDestino/";
    
    public FrameConsultaReservas() {
        initComponents();
        setTitle("JavaBnB");
        jLabel1.requestFocus(true);
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jPanel1.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 530, 350));
        reservas = new ArrayList<>();
        
        cargarReservas("inmuebles.txt");
        loadReservas();
        
        Buscador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto del campo de búsqueda
                String filtro = Buscador.getText();
                // Cargar los inmuebles que coinciden con el filtro
                loadReservas(filtro);
            }
        });
    }
    private void cargarReservas(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Agregar el destino al ArrayList de destinos
                reservas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Método para cargar los destinos de viaje en el panel
    private void loadReservas() {
        panel.removeAll(); // Limpiar el panel

        // Cambiar el layout manager del panel a GridLayout con una sola columna
        panel.setLayout(new GridLayout(0, 1));

        // Agregar ActionListener a cada JLabel que representa un destino
        for (String destino : reservas) {
            JLabel label = new JLabel(destino);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            // Agregar ActionListener
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Crear una instancia del nuevo JFrame con información sobre el destino seleccionado
                    FrameDestinoSeleccionado infoInmueble = new FrameDestinoSeleccionado(destino);
                    // Hacer visible el nuevo JFrame
                    infoInmueble.setVisible(true);
                    // Opcional: ocultar el JFrame actual
                    dispose();
                }
            });
            panel.add(label);
        }

        // Actualizar el panel
        panel.revalidate();
        panel.repaint();
    }
    private void loadReservas(String filtro) {
        panel.removeAll(); // Limpiar el panel

        // Cambiar el layout manager del panel a GridLayout con una sola columna
        panel.setLayout(new GridLayout(0, 1));

        // Filtrar los inmuebles según el texto de búsqueda
        for (String destino : reservas) {
            if (filtro.isEmpty()){loadReservas();}
            else{
                if (destino.toLowerCase().contains(filtro.toLowerCase())) {
                    JLabel label = new JLabel(destino);
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    // Agregar ActionListener
                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // Crear una instancia del nuevo JFrame con información sobre el destino seleccionado
                            FrameDestinoSeleccionado infoInmueble = new FrameDestinoSeleccionado(destino);
                            // Hacer visible el nuevo JFrame
                            infoInmueble.setVisible(true);
                            // Opcional: ocultar el JFrame actual
                            dispose();
                        }
                    });
                    panel.add(label);
                }
            }
        }

        // Actualizar el panel
        panel.revalidate();
        panel.repaint();
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
        Buscador = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        panel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        PantallaAdmin = new javax.swing.JMenuItem();
        ConsultaInmueble = new javax.swing.JMenuItem();
        ConsultaUser = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenuItem();
        Quit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(220, 154, 98));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA DE RESERVAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

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

        Buscador.setBackground(new java.awt.Color(220, 154, 98));
        Buscador.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        Buscador.setForeground(new java.awt.Color(204, 204, 204));
        Buscador.setText(" 🔍 Buscador de reservas");
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
        jPanel1.add(Buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 520, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 520, 20));

        panel.setBackground(new java.awt.Color(220, 154, 98));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 530, 370));

        jMenu1.setText("Inicio");

        ImageIcon admin = new ImageIcon("src/main/java/com/images/admin.png");
        PantallaAdmin.setIcon(admin);
        PantallaAdmin.setText("Panel Admin");
        PantallaAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PantallaAdminActionPerformed(evt);
            }
        });
        jMenu1.add(PantallaAdmin);

        ImageIcon casa = new ImageIcon("src/main/java/com/images/CasaEmoji.png");
        ConsultaInmueble.setIcon(casa);
        ConsultaInmueble.setText("Consulta Inmuebles");
        ConsultaInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaInmuebleActionPerformed(evt);
            }
        });
        jMenu1.add(ConsultaInmueble);

        ImageIcon users = new ImageIcon("src/main/java/com/images/PersonaEmoji.png");
        ConsultaUser.setIcon(users);
        ConsultaUser.setText("Consulta Usuarios");
        ConsultaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaUserActionPerformed(evt);
            }
        });
        jMenu1.add(ConsultaUser);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");

        ImageIcon cSesion = new ImageIcon("src/main/java/com/images/Puerta.png");
        CerrarSesion.setIcon(cSesion);
        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        jMenu2.add(CerrarSesion);

        ImageIcon apagar = new ImageIcon("src/main/java/com/images/shootDown.png");
        Quit.setIcon(apagar);
        Quit.setText("Cerrar App");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PantallaAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PantallaAdminActionPerformed
        // TODO add your handling code here:
        FrameAdmin admin = new FrameAdmin();
        admin.setVisible(true);
        dispose();
    }//GEN-LAST:event_PantallaAdminActionPerformed

    private void ConsultaInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaInmuebleActionPerformed
        // TODO add your handling code here:
        FrameConsultaInmuebles inmueble= new FrameConsultaInmuebles();
        inmueble.setVisible(true);
        dispose();
    }//GEN-LAST:event_ConsultaInmuebleActionPerformed

    private void ConsultaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaUserActionPerformed
        // TODO add your handling code here:
        FrameConsultaUsers user = new FrameConsultaUsers();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_ConsultaUserActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // TODO add your handling code here:
        FrameInicio inicio = new FrameInicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

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
        // Obtener el texto del campo de búsqueda
        String filtro = Buscador.getText();
        // Cargar los inmuebles que coinciden con el filtro
        loadReservas(filtro);
    }//GEN-LAST:event_BuscadorFocusLost

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
        if (Buscador.getText().equals(" 🔍 Buscador de destinos")){
            Buscador.setText("");
        }
    }//GEN-LAST:event_BuscadorActionPerformed

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
            java.util.logging.Logger.getLogger(FrameConsultaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameConsultaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameConsultaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameConsultaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameConsultaReservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscador;
    private javax.swing.JMenuItem CerrarSesion;
    private javax.swing.JMenuItem ConsultaInmueble;
    private javax.swing.JMenuItem ConsultaUser;
    private javax.swing.JMenuItem PantallaAdmin;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
