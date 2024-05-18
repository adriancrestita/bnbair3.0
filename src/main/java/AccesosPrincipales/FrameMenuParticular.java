/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AccesosPrincipales;

import AccesosAuxiliares.FrameDatosPersonales;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author adria
 */
public class FrameMenuParticular extends javax.swing.JFrame {

    /**
     * Creates new form FrameMenuParticular
     */
    
    //declaración de variables                                      
    private List<String> inmuebles; // Lista de inmuebles disponibles
    private final String IMAGENES_DESTINO_PATH = "src/main/java/ImagenesDestino/";
    private int currentPage; // Página actual de resultados

    public FrameMenuParticular() {
        initComponents();
        jLabel1.requestFocus(true);
        this.inmuebles = new ArrayList<>();
        cargarInmueblesDesdeArchivo("inmuebles.txt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("JavaBnB");
        this.currentPage = 0;

        Buscador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchInmuebles(Buscador.getText());
            }
        });

        initInmueblesPanels();
        loadInmuebles();
    }

    private void initInmueblesPanels() {
        panel.setLayout(new GridLayout(0, 2, 10, 10));
    }

    private void loadInmuebles() {
        panel.removeAll();

        int startIndex = currentPage * 4;
        int endIndex = Math.min(startIndex + 4, inmuebles.size());

        for (int i = startIndex; i < endIndex; i++) {
            String nombreDestino = inmuebles.get(i);
            ImageIcon imagen = obtenerImagenPrincipal(nombreDestino);
            String descripcion = "Descripción breve de " + nombreDestino;

            JPanel destinoPanel = createDestinoPanel(imagen, descripcion, nombreDestino);
            panel.add(destinoPanel);
        }

        if (currentPage == 0) {
            PrevPg.setVisible(false);
            NextPg.setVisible(true);
        } else if (endIndex >= inmuebles.size()) {
            PrevPg.setVisible(true);
            NextPg.setVisible(false);
        } else {
            PrevPg.setVisible(true);
            NextPg.setVisible(true);
        }

        revalidate();
        repaint();
    }

    private ImageIcon obtenerImagenPrincipal(String nombreDestino) {
        String rutaImagen = IMAGENES_DESTINO_PATH + nombreDestino.replaceAll(" ", "") + ".JPG";
        ImageIcon imagen = new ImageIcon(rutaImagen);
        if (imagen != null) {
            return imagen;
        } else {
            return null;
        }
    }

    private void mostrarPopup(String nombreDestino) {
        FrameDestinoSeleccionado destino = new FrameDestinoSeleccionado(nombreDestino);
        destino.setVisible(true);
        dispose();
    }
    
    private void searchInmuebles(String searchText) {
        panel.removeAll();

        if (searchText.isEmpty()) {
            loadInmuebles();
            return;
        }

        boolean encontrado = false;
        String searchTextNormalized = Normalizer.normalize(searchText, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();

        for (String inmueble : inmuebles) {
            String inmuebleNormalized = Normalizer.normalize(inmueble, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();

            if (inmuebleNormalized.contains(searchTextNormalized)) {
                ImageIcon imagen = obtenerImagenPrincipal(inmueble);
                String descripcion = "Descripción breve de " + inmueble;

                JPanel destinoPanel = createDestinoPanel(imagen, descripcion, inmueble);
                panel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(10, 10, 10, 10);
                panel.add(destinoPanel, gbc);

                encontrado = true;
            }
        }

        if (!encontrado) {
            JLabel noResultsLabel = new JLabel("No se encontraron resultados para: " + searchText);
            noResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            noResultsLabel.setVerticalAlignment(SwingConstants.CENTER);
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 10, 10, 10);
            panel.add(noResultsLabel, gbc);
        }

        revalidate();
        repaint();
        Buscador.setText(" 🔍 Buscador de destinos");
    }

    private JPanel createDestinoPanel(ImageIcon imagen, String descripcion, String nombreDestino) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(new Color(220, 154, 98));

        JLabel imagenLabel = new JLabel();
        if (imagen != null) {
            // Escalando la imagen para que sea más pequeña
            Image scaledImage = imagen.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);
            imagenLabel.setIcon(new ImageIcon(scaledImage));
            imagenLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(imagenLabel, BorderLayout.NORTH);
        } else {
            imagenLabel.setText("<html><center>" + nombreDestino + "<br>(img)</center></html>");
            imagenLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(imagenLabel, BorderLayout.NORTH);
        }

        JLabel descripcionLabel = new JLabel(descripcion);
        descripcionLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(descripcionLabel, BorderLayout.CENTER);

        // Agregando el ActionListener para mostrar una ventana emergente al hacer clic en el panel
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarPopup(nombreDestino);
            }
        });

        return panel;
    }
    
    //Lee el archivo donde se encuentran todos los destinos disponibles y los carga en el arraylist
    private void cargarInmueblesDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Agregar cada línea (nombre del inmueble) a la lista de inmuebles
                inmuebles.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   //MÉTODO PARA LEER EL ARCHIVO CON INMUEBLES REGISTRADOS Y CARGARLOS AL ARRAYLIST
    
    // Método para ir a la siguiente página de resultados
    private void nextPage() {
        int startIndex = (currentPage + 1) * 2; // (2 para 2 filas y 1 columna)
        if (startIndex < inmuebles.size()) {
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jFrame1 = new javax.swing.JFrame();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jDialog1 = new javax.swing.JDialog();
        jFrame2 = new javax.swing.JFrame();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Buscador = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        PrevPg = new javax.swing.JButton();
        NextPg = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenuItem();
        Quit = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ConsultarReservas = new javax.swing.JMenuItem();
        CambiarDatos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(220, 154, 98));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

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
        jPanel1.add(Buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 520, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 520, 20));

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

        panel.setBackground(new java.awt.Color(220, 154, 98));
        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 530, 340));

        jMenu2.setText("Inicio");

        CerrarSesion.setText("Cerrar sesión");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        jMenu2.add(CerrarSesion);

        Quit.setText("Salir");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        jMenu2.add(Quit);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Herramientas");

        ConsultarReservas.setText("Consultar Reservas");
        ConsultarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarReservasActionPerformed(evt);
            }
        });
        jMenu3.add(ConsultarReservas);

        CambiarDatos.setText("Cambiar Datos Personales");
        CambiarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarDatosActionPerformed(evt);
            }
        });
        jMenu3.add(CambiarDatos);

        jMenuItem2.setText("Cambiar Datos Bancarios");
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CambiarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarDatosActionPerformed
        // TODO add your handling code here:
        FrameDatosPersonales fdp = new FrameDatosPersonales();
        fdp.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_CambiarDatosActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // TODO add your handling code here:
        FrameInicio inicio = new FrameInicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void ConsultarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarReservasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultarReservasActionPerformed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
        if (Buscador.getText().equals("🔍 Buscador de destinos")){
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
            java.util.logging.Logger.getLogger(FrameMenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMenuParticular().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscador;
    private javax.swing.JMenuItem CambiarDatos;
    private javax.swing.JMenuItem CerrarSesion;
    private javax.swing.JMenuItem ConsultarReservas;
    private javax.swing.JButton NextPg;
    private javax.swing.JButton PrevPg;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
