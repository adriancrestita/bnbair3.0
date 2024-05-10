/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AccesosPrincipales;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author hugos
 */
public class FrameConsultaInmuebles extends javax.swing.JFrame {

    /**
     * Creates new form FrameConsultaInmuebles
     */
    
    //Declaracion de atributos
    public static List<String> titulosInmuebles; // Lista de inmuebles disponibles
    public static int currentPage; // Página actual de resultados
    public static final String IMAGENES_DESTINO_PATH = "src/main/java/ImagenesDestino/";
    
    
    public FrameConsultaInmuebles() {
        initComponents();
        jLabel1.requestFocus(true);
        setTitle("JavaBnB"); // cambia el titulo de la pestaña a JavaBnB
        
        
        titulosInmuebles = new ArrayList<>(); //genero arraylist de los titulos de los inmuebles para utizarlo en el buscador
        MetodosConsultaInmuebles.arrayInmuebles(); //añade los titulso de los inmuebles a la arraylist
        
        System.out.println(titulosInmuebles);
        this.currentPage = 0;
        
        Buscador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchInmuebles(Buscador.getText());
            }
        });
        //Cargar los inmuebles disponibles
        loadInmuebles();
    }
    // Método para ir a la siguiente página de resultados
    private void nextPage() {
        int startIndex = (FrameConsultaInmuebles.currentPage + 1) * 6; // (6 para 2 filas y 3 columnas)
        if (startIndex >= titulosInmuebles.size()) {
            // Mostrar ventana emergente si no hay más páginas disponibles
            JOptionPane.showMessageDialog(this, "No hay más páginas disponibles.", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            currentPage++;
            loadInmuebles(); // Cargar la siguiente página de resultados
        }
    }
    
    // Método para ir a la página anterior de resultados
    private void previousPage() {
        if (currentPage > 0) {
            currentPage--;
            loadInmuebles(); // Cargar la página anterior de resultados
        }
    }
    
    private void loadInmuebles() {
        panel.removeAll();

        int startIndex = currentPage * 6; // Índice de inicio en la lista de inmuebles (6 para 2 filas y 3 columnas)
        int endIndex = Math.min(startIndex + 6, titulosInmuebles.size()); // Índice de fin en la lista de inmuebles

        // Panel para mostrar los inmuebles en una cuadrícula de 2x3
        JPanel gridPanel = new JPanel(new GridLayout(2, 3));
        gridPanel.setBackground(new Color(220, 154, 98)); // Establecer el color de fondo

        // Agregar etiquetas con las imágenes o nombres de los inmuebles al panel
        for (int i = startIndex; i < endIndex; i++) {
            String nombreDestino = titulosInmuebles.get(i);
            //String nombreDestino = MetodosAuxiliares.elementosPorDatos
            ImageIcon imagen = MetodosConsultaInmuebles.obtenerImagenPrincipal(MetodosConsultaInmuebles.primeraImagenInmueble(nombreDestino));

            // Si no se encuentra la imagen, mostrar el nombre del destino
            JLabel label;
            if (imagen != null) {
                label = new JLabel(imagen);
            } else {
                label = new JLabel(nombreDestino);
                label.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente
            }
            label.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente
            gridPanel.add(label);
        }
        // Establecer el tamaño del gridPanel igual al del panel principal
        gridPanel.setPreferredSize(panel.getSize());

        // Agregar el panel de cuadrícula al panel principal
        panel.add(gridPanel);

        // Actualizar la ventana
        revalidate();
        repaint();
    }
    private void searchInmuebles(String searchText) {
        panel.removeAll();

        if (searchText.isEmpty()) {
            // Si la búsqueda está vacía, mostrar todos los inmuebles en una cuadrícula de 2x3
            loadInmuebles();
            return;
        }

        boolean encontrado = false;

        // Normalizar el texto de búsqueda
        String searchTextNormalized = Normalizer.normalize(searchText, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();

        // Buscar el inmueble por nombre
        for (String inmueble : titulosInmuebles) {
            // Normalizar el nombre del inmueble para comparar
            String inmuebleNormalized = Normalizer.normalize(inmueble, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();

            if (inmuebleNormalized.contains(searchTextNormalized)) {
                // Mostrar el inmueble encontrado en el centro del panel
                JLabel resultLabel = new JLabel(inmueble);
                resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
                resultLabel.setVerticalAlignment(SwingConstants.CENTER);
                panel.add(resultLabel);
                encontrado = true;
            }
        }

        // Si no se encuentra ningún inmueble, mostrar un mensaje
        if (!encontrado) {
            JLabel noResultsLabel = new JLabel("No se encontraron resultados para: " + searchText);
            noResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            noResultsLabel.setVerticalAlignment(SwingConstants.CENTER);
            panel.add(noResultsLabel);
        }

        // Actualizar la ventana
        revalidate();
        repaint();
        Buscador.setText(" 🔍 Buscador de destinos");
    }
    
    //Lee el archivo donde se encuentran todos los destinos disponibles y los carga en el arraylist
    private void cargarInmueblesDesdeArchivo(String nombreArchivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            // Dividir la línea en partes usando la coma como separador
            String[] partes = linea.split(",");
            // Verificar que la línea contiene al menos dos elementos
            if (partes.length > 1) {
                // Agregar el segundo elemento (primera dirección de imagen) a la lista de inmuebles
                titulosInmuebles.add(partes[1].trim()); // Usamos trim() para eliminar espacios en blanco alrededor
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}   //MÉTODO PARA LEER EL ARCHIVO CON INMUEBLES REGISTRADOS Y CARGARLOS AL ARRAYLIST

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
        PrevPg = new javax.swing.JButton();
        NextPg = new javax.swing.JButton();
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
        jPanel1.add(Buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 520, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 520, 20));

        panel.setBackground(new java.awt.Color(220, 154, 98));
        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 530, 350));

        PrevPg.setText("Página anterior");
        PrevPg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevPgActionPerformed(evt);
            }
        });
        jPanel1.add(PrevPg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        NextPg.setText("Página siguiente");
        NextPg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextPgActionPerformed(evt);
            }
        });
        jPanel1.add(NextPg, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, -1, -1));

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

    private void PrevPgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevPgActionPerformed
        // TODO add your handling code here:
        previousPage();
    }//GEN-LAST:event_PrevPgActionPerformed

    private void NextPgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextPgActionPerformed
        // TODO add your handling code here:
        nextPage();
    }//GEN-LAST:event_NextPgActionPerformed

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
    private javax.swing.JTextField Buscador;
    private javax.swing.JMenuItem CerrarSesion;
    private javax.swing.JMenuItem ConsultaReservas;
    private javax.swing.JMenuItem ConsultaUser;
    private javax.swing.JMenu Menu;
    private javax.swing.JButton NextPg;
    private javax.swing.JButton PrevPg;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JMenu Salir;
    private javax.swing.JMenuItem VueltaAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
