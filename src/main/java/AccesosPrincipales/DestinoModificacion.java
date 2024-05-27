/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AccesosPrincipales;

import ManejoDatos.GestorAnfitrion;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.util.ArrayList;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author hugos
 */
public class DestinoModificacion extends javax.swing.JFrame {

    /**
     * Creates new form FrameDestinoSeleccionado
     */
    
    private double costeNoche;
    private JDateChooser dateChooser1, dateChooser2;
    private Anfitrion anfiInmueble;
    private GestorAnfitrion gestorAnfitrion;
    private ArrayList<String> imagePaths;
    private String rutaImgs="src/main/java/ImagenesDestino/";
    private int imagen=0;
    private int rating = 0;
    private JLabel[] stars;
    private int calificacion;
    
    public DestinoModificacion(){
        initComponents();
    }
    
    // Constructor con destino seleccionado
    public DestinoModificacion(Inmueble inmueble) {
        initComponents(); // Llama a la función initComponents para inicializar los componentes
        setTitle("JavaBnB"); // Establece el título de la ventana
        jLabel15.requestFocus(true);
        gestorAnfitrion = new GestorAnfitrion(); // Accedemos al gestor de anfitriones
        imagePaths = inmueble.getImages();
        
        
        //Establecer la información acerca del destino a modificar
        titulo.setText(inmueble.getTitulo());
        calle.setText(inmueble.getCalle());
        numero.setText(inmueble.getNumero());
        ciudad.setText(inmueble.getCiudad());
        cp.setText(inmueble.getCP());
        camas.setValue(Integer.valueOf(inmueble.getNumCamas()));
        baños.setValue(Integer.valueOf(inmueble.getNumBaños()));
        habitaciones.setValue(Integer.valueOf(inmueble.getNumHabitaciones()));
        huespedes.setValue(Integer.valueOf(inmueble.getMaxHuespedes()));
        precioNoche.setValue(Integer.parseInt(inmueble.getPrecioNoche())); 
        
        //Se hace update del panel de las imagenes con las imagense del destino
        updateImagePanel(imagePaths);
        
        //Se obtienen los servicios del inmueble
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
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelImagenes = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        imagenes = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        titulo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        calle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ciudad = new javax.swing.JTextField();
        cp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        huespedes = new javax.swing.JSpinner();
        habitaciones = new javax.swing.JSpinner();
        baños = new javax.swing.JSpinner();
        camas = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        precioNoche = new javax.swing.JSlider();
        precioEtiqueta = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        editButton = new javax.swing.JToggleButton();
        guardar = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        volverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("JAVABNB");

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

        panelImagenes.setBackground(new java.awt.Color(255, 255, 255));
        panelImagenes.setLayout(new java.awt.GridLayout(1, 0));

        jLabel26.setText("Precio noche");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wifi.setEnabled(false);
        wifi.setFocusCycleRoot(true);
        wifi.setFocusable(false);
        wifi.setMaximumSize(new java.awt.Dimension(5, 20));
        wifi.setMinimumSize(new java.awt.Dimension(5, 20));
        wifi.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel7.add(wifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 102, -1));

        jLabel11.setText("Wifi");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 102, 20));

        lavadora.setEnabled(false);
        lavadora.setFocusable(false);
        lavadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lavadoraActionPerformed(evt);
            }
        });
        jPanel7.add(lavadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 102, -1));

        jLabel6.setText("Lavadora");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 102, 20));

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
        jPanel7.add(ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 102, -1));

        jLabel10.setText("Aire acondicionado");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));

        aparcamiento.setEnabled(false);
        aparcamiento.setFocusable(false);
        jPanel7.add(aparcamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 102, -1));

        jLabel5.setText("Aparcamiento");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 102, 20));

        calefaccion.setEnabled(false);
        calefaccion.setFocusable(false);
        calefaccion.setMaximumSize(new java.awt.Dimension(5, 20));
        calefaccion.setMinimumSize(new java.awt.Dimension(5, 20));
        calefaccion.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel7.add(calefaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 102, -1));

        jLabel4.setText("Calefaccion");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 102, 20));

        piscina.setEnabled(false);
        piscina.setFocusable(false);
        jPanel7.add(piscina, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 102, -1));

        jLabel8.setText("Pisicina");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 102, 20));

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
        jPanel7.add(cocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 102, -1));

        jLabel7.setText("Cocina");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 102, 20));

        trabajo.setEnabled(false);
        trabajo.setFocusable(false);
        jPanel7.add(trabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 102, -1));

        jLabel9.setText("Zona de trabajo");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 102, 20));

        jLabel33.setText("Servicios del alojamiento:");

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        imagenes.setText("Examinar archivos");
        imagenes.setEnabled(false);
        imagenes.setFocusable(false);
        imagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenesActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setEnabled(false);
        titulo.setFocusable(false);
        titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloActionPerformed(evt);
            }
        });

        jLabel12.setText("Calle");

        calle.setEnabled(false);
        calle.setFocusable(false);
        calle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calleActionPerformed(evt);
            }
        });

        jLabel2.setText("Número");

        numero.setEnabled(false);
        numero.setFocusable(false);

        jLabel3.setText("Ciudad");

        ciudad.setEnabled(false);
        ciudad.setFocusable(false);
        ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudadActionPerformed(evt);
            }
        });

        cp.setEnabled(false);
        cp.setFocusable(false);

        jLabel13.setText("C.P.");

        jLabel16.setText("Número de Huéspedes");

        jLabel17.setText("Número de Habitaciones");

        jLabel18.setText("Número de Camas");

        jLabel19.setText("Número de Baños");

        huespedes.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        huespedes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        huespedes.setEnabled(false);
        huespedes.setFocusable(false);
        huespedes.setValue(1);
        huespedes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                huespedesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        habitaciones.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        habitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        habitaciones.setEnabled(false);
        habitaciones.setFocusable(false);
        habitaciones.setValue(1);
        habitaciones.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                habitacionesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        baños.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        baños.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        baños.setEnabled(false);
        baños.setFocusable(false);
        baños.setValue(1);
        baños.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                bañosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        camas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        camas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        camas.setEnabled(false);
        camas.setFocusable(false);
        camas.setValue(1);
        camas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                camasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        descripcion.setColumns(20);
        descripcion.setRows(5);
        descripcion.setEnabled(false);
        descripcion.setFocusable(false);
        jScrollPane1.setViewportView(descripcion);

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

        precioEtiqueta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        precioEtiqueta.setEnabled(false);
        precioEtiqueta.setFocusable(false);

        jLabel20.setText("€");

        eliminar.setBackground(java.awt.Color.red);
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

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

        guardar.setText("Guardar Cambios");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        volverButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        volverButton.setText("←");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(calle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(80, 80, 80)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(imagenes))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jSeparator8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(huespedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(baños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(camas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(habitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(editButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(guardar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eliminar))
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addContainerGap(134, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(58, 58, 58)
                                .addComponent(precioEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel33))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(volverButton))
                        .addGap(19, 19, 19)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imagenes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(huespedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(habitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(camas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(baños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(precioEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardar))
                .addGap(184, 184, 184)
                .addComponent(jLabel21)
                .addGap(78, 78, 78)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1566, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void precioNocheStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_precioNocheStateChanged
        // TODO add your handling code here:
        int price = precioNoche.getValue();
        precioEtiqueta.setText(String.valueOf(price));
    }//GEN-LAST:event_precioNocheStateChanged

    private void precioNocheAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_precioNocheAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_precioNocheAncestorAdded

    private void camasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_camasAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_camasAncestorAdded

    private void bañosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_bañosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_bañosAncestorAdded

    private void habitacionesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_habitacionesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_habitacionesAncestorAdded

    private void huespedesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_huespedesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_huespedesAncestorAdded

    private void ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadActionPerformed

    private void calleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calleActionPerformed

    private void tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloActionPerformed

    private void imagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenesActionPerformed

    }//GEN-LAST:event_imagenesActionPerformed

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

            //Hacemos que los text field sean editables desactivando el modo editable
            titulo.setEditable(true);
            calle.setEditable(true);
            numero.setEditable(true);
            ciudad.setEditable(true);
            cp.setEditable(true);
            descripcion.setEditable(true);
            titulo.setEnabled(true);
            calle.setEnabled(true);
            numero.setEnabled(true);
            ciudad.setEnabled(true);
            cp.setEnabled(true);
            descripcion.setEnabled(true);
            camas.setEnabled(true);
            huespedes.setEnabled(true);
            baños.setEnabled(true);
            habitaciones.setEnabled(true);
            wifi.setEnabled(true);
            ac.setEnabled(true);
            aparcamiento.setEnabled(true);
            calefaccion.setEnabled(true);
            piscina.setEnabled(true);
            cocina.setEnabled(true);
            lavadora.setEnabled(true);
            trabajo.setEnabled(true);
            precioNoche.setEnabled(true);
            
            //Hacemos que se pueda hacer focus al text field
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

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        if (editButton.isSelected()){
            //guardar los cambios
        }else{
            JOptionPane.showMessageDialog(this, "Cierre el candado para guardar");
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        //eliminar el inmueble
    }//GEN-LAST:event_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(DestinoModificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DestinoModificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DestinoModificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DestinoModificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DestinoModificacion().setVisible(true);
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
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JSpinner habitaciones;
    private javax.swing.JSpinner huespedes;
    private javax.swing.JButton imagenes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JRadioButton lavadora;
    private javax.swing.JTextField numero;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JRadioButton piscina;
    private javax.swing.JLabel precioEtiqueta;
    private javax.swing.JSlider precioNoche;
    private javax.swing.JTextField titulo;
    private javax.swing.JRadioButton trabajo;
    private javax.swing.JButton volverButton;
    private javax.swing.JRadioButton wifi;
    // End of variables declaration//GEN-END:variables
}
