/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AccesosPrincipales;

import ManejoDatos.GestorAnfitrion;
import ManejoDatos.GestorInmuebles;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import poo.javabnb.Anfitrion;
import poo.javabnb.Inmueble;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 *
 * @author hugos
 */
public class ModificacionDestino extends javax.swing.JFrame {

    /**
     * Creates new form FrameDestinoSeleccionado
     */
    
    private double costeNoche;
    private Anfitrion anfitrionInmueble;
    private GestorAnfitrion gestorAnfitrion;
    private ArrayList<String> imagePaths;
    private String rutaImgs="src/main/java/ImagenesDestino/";
    private int imagen=0;
    
    public ModificacionDestino(){
        initComponents();
    }
    
    // Constructor con destino seleccionado
    public ModificacionDestino(Inmueble inmueble) {
        initComponents(); // Llama a la función initComponents para inicializar los componentes
        setTitle("JavaBnB"); // Establece el título de la ventana
        gestorAnfitrion = new GestorAnfitrion(); // Accedemos al gestor de anfitriones
        anfitrionInmueble = gestorAnfitrion.obtenerAnfitrion(inmueble.getCorreoAnfitrion());// Retorna el objeto del Anfitrión del inmueble para acceder a sus datos
        imagePaths = inmueble.getImages();
        
        //establecer la información acerca del destino y anfitrión seleccionado
        titulo.setText(inmueble.getTitulo());
        calle.setText(inmueble.getCalle());
        numero.setText(inmueble.getNumero());
        ciudad.setText(inmueble.getCiudad());
        cp.setText(inmueble.getCP());
//        camas.setText(inmueble.getTitulo());
//        baños.setText(inmueble.direccionToString());
//        habitaciones.setText("Huéspedes máximos "+inmueble.getMaxHuespedes());
//        jLabel21.setText("Número de habitaciones: "+inmueble.getNumHabitaciones());
//        jLabel22.setText("Número de camas: "+inmueble.getNumCamas()); 
//        jLabel23.setText("Número de baños: "+inmueble.getNumBaños());
//        jLabel27.setText("Valoración: "+inmueble.getCalificacion()+"/5");
//        jLabel29.setText(inmueble.getNumCalif()+" valoraciones");
//        jLabel26.setText("Precio por noche: "+inmueble.getPrecioNoche()+"€");
//        costeNoche=Integer.parseInt(inmueble.getPrecioNoche());
        
        updateImagePanel(imagePaths);
        
        // Configurar rango de fechas seleccionables para el segundo JDateChooser

        // Configurar el primer JDateChooser para que no se puedan seleccionar fechas anteriores a hoy
        
        ArrayList <String> servicios = inmueble.getServicios();
        
        setServicios(servicios);
        
        
        
        
    }
    
    /**
     * 
     * Método para hacer update en el panel de imagenes con las imagenes actualizadas
     * 
     * @param imagePaths es una array con los nombres de archivo de imagenes
     */
    private void updateImagePanel(ArrayList<String> imagePaths) {
        panelImagenes.removeAll();

        int size = imagePaths.size();
        if (size == 0) {
            JLabel noImagesLabel = new JLabel("Imagenes no disponibles");
            panelImagenes.add(noImagesLabel);
        } else {
                ImageIcon originalIcon = new ImageIcon(rutaImgs+imagePaths.get(imagen));
                Image originalImage = originalIcon.getImage();
                Image scaledImage = originalImage.getScaledInstance(637, 358, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                
                JLabel imageLabel = new JLabel(scaledIcon);
                panelImagenes.add(imageLabel);
        }

        panelImagenes.revalidate();
        panelImagenes.repaint();
    }
    
    /**
     * Método para identificar los servicios del inmueble y que se seleccionen al iniciar
     * @param servicios 
     */
    private void setServicios(ArrayList<String> servicios){
        for (int i=0; i<servicios.size();i++){
            
            String servicio= servicios.get(i);
            
            switch (servicio){
                case "Aire Acondicionado" -> {
                    ac.setSelected(true);
                }
                case "Aparcamiento" -> {
                    aparcamiento.setSelected(true);
                }
                case "Calefacción" -> {
                    calefaccion.setSelected(true);
                }
                case "Cocina" -> {
                    cocina.setSelected(true);
                }
                case "Lavadora" -> {
                    lavadora.setSelected(true);
                }
                case "Piscina" -> {
                    piscina.setSelected(true);
                }
                case "Wifi" -> {
                    wifi.setSelected(true);
                }
                case "Zona de trabajo" -> {
                    trabajo.setSelected(true);
                } 
            }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelImagenes = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        panelServicios = new javax.swing.JPanel();
        wifi = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        lavadora = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        ac = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        aparcamiento = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        calefaccion = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        piscina = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        cocina = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        trabajo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        editButton = new javax.swing.JToggleButton();
        jSeparator7 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        titulo = new javax.swing.JTextField();
        calle = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();
        ciudad = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        huespedes = new javax.swing.JSpinner();
        camas = new javax.swing.JSpinner();
        habitaciones = new javax.swing.JSpinner();
        baños = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        precioNoche = new javax.swing.JSlider();
        precioEtiqueta = new javax.swing.JLabel();
        cp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("JAVABNB");
        panelPrincipal.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 54, -1, -1));

        ImageIcon d = new ImageIcon("src/main/java/com/images/logo2rec.png");
        Image img = d.getImage();
        Image scaledImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        jLabel15.setIcon(scaledIcon);
        jLabel15.setText("");
        jLabel15.setText("LOGO");
        jLabel15.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel15.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel15.setPreferredSize(new java.awt.Dimension(50, 50));
        panelPrincipal.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 40, -1, -1));

        panelImagenes.setBackground(new java.awt.Color(255, 255, 255));
        panelImagenes.setLayout(new java.awt.GridLayout(1, 0));
        panelPrincipal.add(panelImagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 158, 637, 358));
        panelPrincipal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 634, 666, 13));

        jLabel26.setText("Precio Noche:");
        panelPrincipal.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 1199, -1, -1));
        panelPrincipal.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 1179, 666, 13));

        panelServicios.setBackground(new java.awt.Color(255, 255, 255));
        panelServicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wifi.setEnabled(false);
        wifi.setFocusCycleRoot(true);
        wifi.setFocusable(false);
        wifi.setMaximumSize(new java.awt.Dimension(5, 20));
        wifi.setMinimumSize(new java.awt.Dimension(5, 20));
        wifi.setPreferredSize(new java.awt.Dimension(5, 20));
        panelServicios.add(wifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 102, -1));

        jLabel11.setText("Wifi");
        panelServicios.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 102, 20));

        lavadora.setEnabled(false);
        lavadora.setFocusable(false);
        lavadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lavadoraActionPerformed(evt);
            }
        });
        panelServicios.add(lavadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 102, -1));

        jLabel6.setText("Lavadora");
        panelServicios.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 102, 20));

        ac.setEnabled(false);
        ac.setFocusable(false);
        ac.setMaximumSize(new java.awt.Dimension(5, 20));
        ac.setMinimumSize(new java.awt.Dimension(5, 20));
        ac.setPreferredSize(new java.awt.Dimension(5, 20));
        ac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acActionPerformed(evt);
            }
        });
        panelServicios.add(ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 102, -1));

        jLabel10.setText("Aire acondicionado");
        panelServicios.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));

        aparcamiento.setEnabled(false);
        aparcamiento.setFocusable(false);
        panelServicios.add(aparcamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 102, -1));

        jLabel5.setText("Aparcamiento");
        panelServicios.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 102, 20));

        calefaccion.setEnabled(false);
        calefaccion.setFocusable(false);
        calefaccion.setMaximumSize(new java.awt.Dimension(5, 20));
        calefaccion.setMinimumSize(new java.awt.Dimension(5, 20));
        calefaccion.setPreferredSize(new java.awt.Dimension(5, 20));
        panelServicios.add(calefaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 102, -1));

        jLabel4.setText("Calefaccion");
        panelServicios.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 102, 20));

        piscina.setEnabled(false);
        piscina.setFocusable(false);
        panelServicios.add(piscina, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 102, -1));

        jLabel8.setText("Pisicina");
        panelServicios.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 102, 20));

        cocina.setEnabled(false);
        cocina.setFocusable(false);
        cocina.setMaximumSize(new java.awt.Dimension(5, 20));
        cocina.setMinimumSize(new java.awt.Dimension(5, 20));
        cocina.setPreferredSize(new java.awt.Dimension(5, 20));
        cocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cocinaActionPerformed(evt);
            }
        });
        panelServicios.add(cocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 102, -1));

        jLabel7.setText("Cocina");
        panelServicios.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 102, 20));

        trabajo.setEnabled(false);
        trabajo.setFocusable(false);
        panelServicios.add(trabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 102, -1));

        jLabel9.setText("Zona de trabajo");
        panelServicios.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 102, 20));

        panelPrincipal.add(panelServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 1021, -1, -1));

        jLabel33.setText("Servicios del alojamiento:");
        panelPrincipal.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 987, -1, -1));
        panelPrincipal.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 962, 666, 13));
        panelPrincipal.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 1247, 666, 13));

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelPrincipal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 322, -1, -1));

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelPrincipal.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 328, -1, -1));

        editButton.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        editButton.setSelected(true);
        editButton.setText("🔒");
        editButton.setBorder(null);
        editButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editButtonStateChanged(evt);
            }
        });
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        panelPrincipal.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 1297, -1, -1));
        panelPrincipal.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 534, 637, 13));

        jButton3.setBackground(java.awt.Color.red);
        jButton3.setText("Eliminar Inmueble");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelPrincipal.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 1300, -1, -1));

        jButton4.setText("Guardar Cambios");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelPrincipal.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 1300, -1, -1));

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setText("titulo");
        titulo.setEnabled(false);
        titulo.setFocusable(false);
        panelPrincipal.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 121, 349, -1));

        calle.setEnabled(false);
        calle.setFocusable(false);
        panelPrincipal.add(calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 587, 100, -1));

        numero.setEnabled(false);
        numero.setFocusable(false);
        panelPrincipal.add(numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, -1, -1));

        ciudad.setEnabled(false);
        ciudad.setFocusable(false);
        panelPrincipal.add(ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 100, -1));
        panelPrincipal.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 795, 666, 13));

        jLabel3.setText("Numero de Camas:");
        panelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 690, -1, -1));

        jLabel12.setText("Número Máximo de Huéspedes:");
        panelPrincipal.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 656, -1, -1));

        jLabel13.setText("Numero de Habitaciones:");
        panelPrincipal.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 724, -1, -1));

        jLabel16.setText("Numero de Baños:");
        panelPrincipal.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 758, -1, -1));

        huespedes.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        huespedes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        huespedes.setEnabled(false);
        huespedes.setFocusable(false);
        huespedes.setValue(1);
        panelPrincipal.add(huespedes, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 653, -1, -1));

        camas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        camas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        camas.setEnabled(false);
        camas.setFocusable(false);
        camas.setValue(1);
        panelPrincipal.add(camas, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 687, -1, -1));

        habitaciones.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        habitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        habitaciones.setEnabled(false);
        habitaciones.setFocusable(false);
        habitaciones.setValue(1);
        panelPrincipal.add(habitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 721, -1, -1));

        baños.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        baños.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        baños.setEnabled(false);
        baños.setFocusable(false);
        baños.setValue(1);
        panelPrincipal.add(baños, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 755, -1, -1));

        jLabel17.setText("Calle");
        panelPrincipal.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 553, -1, -1));

        jLabel18.setText("Número");
        panelPrincipal.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 553, -1, -1));

        jLabel19.setText("Ciudad");
        panelPrincipal.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 553, -1, -1));

        jLabel20.setText("C.P.");
        panelPrincipal.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 553, -1, -1));

        descripcion.setColumns(20);
        descripcion.setRows(5);
        descripcion.setFocusable(false);
        jScrollPane1.setViewportView(descripcion);

        panelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 814, 666, 136));

        precioNoche.setMajorTickSpacing(1);
        precioNoche.setMaximum(1000);
        precioNoche.setMinimum(1);
        precioNoche.setMinorTickSpacing(1);
        precioNoche.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        precioNoche.setEnabled(false);
        precioNoche.setFocusable(false);
        precioNoche.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                precioNocheAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        precioNoche.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                precioNocheStateChanged(evt);
            }
        });
        panelPrincipal.add(precioNoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 1198, -1, -1));

        precioEtiqueta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        precioEtiqueta.setEnabled(false);
        panelPrincipal.add(precioEtiqueta, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 1198, 41, 21));

        cp.setEnabled(false);
        cp.setFocusable(false);
        panelPrincipal.add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 590, 72, -1));

        jScrollPane2.setViewportView(panelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1613, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String correoInmuebleSeleccionado = "";
        String titulo = "";
        List<Inmueble> inm = GestorInmuebles.eliminarInmueble(correoInmuebleSeleccionado, titulo);
        GestorInmuebles.guardarInmuebles(inm);
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (imagen>0){
            imagen--;
        }
        else{
            System.out.println("Imagen inicial");
            imagen=imagePaths.size()-1;
        }
        updateImagePanel(imagePaths);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (imagen<imagePaths.size()-1){
            imagen++;
        }
        else{
            System.out.println("no hay más imagenes");
            imagen=0;
        }
        updateImagePanel(imagePaths);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cocinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cocinaActionPerformed

    private void acActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acActionPerformed

    private void lavadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lavadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lavadoraActionPerformed

    private void editButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editButtonStateChanged

    }//GEN-LAST:event_editButtonStateChanged

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if(editButton.isSelected()){
            editButton.setBackground(Color.white);
            editButton.setText("🔒");

            //Hacemos que los text field no sean editables desactivado el modo editable
            titulo.setEditable(false);
            calle.setEditable(false);
            numero.setEditable(false);
            ciudad.setEditable(false);
            cp.setEditable(false);
            camas.setEnabled(false);
            huespedes.setEnabled(false);
            baños.setEnabled(false);
            habitaciones.setEnabled(false);
            descripcion.setEditable(false);
            wifi.setEnabled(false);
            ac.setEnabled(false);
            aparcamiento.setEnabled(false);
            calefaccion.setEnabled(false);
            piscina.setEnabled(false);
            cocina.setEnabled(false);
            lavadora.setEnabled(false);
            trabajo.setEnabled(false);
            precioNoche.setEnabled(false);

            //Hacemos que no se pueda hacer focus al text field
            titulo.setFocusable(false);
            calle.setFocusable(false);
            numero.setFocusable(false);
            ciudad.setFocusable(false);
            cp.setFocusable(false);
            camas.setFocusable(false);
            huespedes.setFocusable(false);
            baños.setFocusable(false);
            habitaciones.setFocusable(false);
            descripcion.setFocusable(false);
            wifi.setFocusable(false);
            ac.setFocusable(false);
            aparcamiento.setFocusable(false);
            calefaccion.setFocusable(false);
            piscina.setFocusable(false);
            cocina.setFocusable(false);
            lavadora.setFocusable(false);
            trabajo.setFocusable(false);
            precioNoche.setFocusable(false);
        }
        else{
            editButton.setBackground(Color.white);
            editButton.setText("🔓");

            //Hacemos que los text field sean editables desactivado el modo editable
            titulo.setEditable(true);
            calle.setEditable(true);
            numero.setEditable(true);
            ciudad.setEditable(true);
            cp.setEditable(true);
            camas.setEnabled(true);
            huespedes.setEnabled(true);
            baños.setEnabled(true);
            habitaciones.setEnabled(true);
            descripcion.setEditable(true);
            wifi.setEnabled(true);
            ac.setEnabled(true);
            aparcamiento.setEnabled(true);
            calefaccion.setEnabled(true);
            piscina.setEnabled(true);
            cocina.setEnabled(true);
            lavadora.setEnabled(true);
            trabajo.setEnabled(true);
            precioNoche.setEnabled(true);
            
            //Hacemos que no se pueda hacer focus al text field
            titulo.setFocusable(true);
            calle.setFocusable(true);
            numero.setFocusable(true);
            ciudad.setFocusable(true);
            cp.setFocusable(true);
            camas.setFocusable(true);
            huespedes.setFocusable(true);
            baños.setFocusable(true);
            habitaciones.setFocusable(true);
            descripcion.setFocusable(true);
            wifi.setFocusable(true);
            ac.setFocusable(true);
            aparcamiento.setFocusable(true);
            calefaccion.setFocusable(true);
            piscina.setFocusable(true);
            cocina.setFocusable(true);
            lavadora.setFocusable(true);
            trabajo.setFocusable(true);
            precioNoche.setFocusable(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void precioNocheAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_precioNocheAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_precioNocheAncestorAdded

    private void precioNocheStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_precioNocheStateChanged
        // TODO add your handling code here:
    }                                                

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void numHuespedesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_numHuespedesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_numHuespedesAncestorAdded

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String correoInmuebleSeleccionado = "";
        String titulo = "";
        //List<Inmueble> inm = GestorInmuebles.eliminarInmueble(correoInmuebleSeleccionado, titulo);

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ModificacionDestino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificacionDestino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificacionDestino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificacionDestino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificacionDestino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ac;
    private javax.swing.JRadioButton aparcamiento;
    private javax.swing.JSpinner baños;
    private javax.swing.JRadioButton calefaccion;
    private javax.swing.JTextField calle;
    private javax.swing.JSpinner camas;
    private javax.swing.JTextField ciudad;
    private javax.swing.JRadioButton cocina;
    private javax.swing.JTextField cp;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JToggleButton editButton;
    private javax.swing.JSpinner habitaciones;
    private javax.swing.JSpinner huespedes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JRadioButton lavadora;
    private javax.swing.JTextField numero;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelServicios;
    private javax.swing.JRadioButton piscina;
    private javax.swing.JLabel precioEtiqueta;
    private javax.swing.JSlider precioNoche;
    private javax.swing.JTextField titulo;
    private javax.swing.JRadioButton trabajo;
    private javax.swing.JRadioButton wifi;
    // End of variables declaration//GEN-END:variables
}
