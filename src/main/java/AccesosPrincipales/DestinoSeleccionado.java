/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AccesosPrincipales;

import ManejoDatos.GestorAnfitrion;
import ManejoDatos.GestorValoraciones;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.util.List;
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
import poo.javabnb.ValoracionClienteInmueble;

/**
 *
 * @author hugos
 */
public class DestinoSeleccionado extends javax.swing.JFrame {

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
    private Inmueble inmueble;
    
    public DestinoSeleccionado(){
        initComponents();
    }
    
    // Constructor con destino seleccionado
    public DestinoSeleccionado(Inmueble inmueble) {
        initComponents(); // Llama a la función initComponents para inicializar los componentes
        setTitle("JavaBnB"); // Establece el título de la ventana
        gestorAnfitrion = new GestorAnfitrion(); // Accedemos al gestor de anfitriones
        anfiInmueble = gestorAnfitrion.obtenerAnfitrion(inmueble.getCorreoAnfitrion());// Retorna el objeto del Anfitrión del inmueble para acceder a sus datos
        imagePaths = inmueble.getImages();
        System.out.println(imagePaths);
        this.inmueble=inmueble;
        GestorValoraciones gestorValoraciones = new GestorValoraciones();
        java.util.List<ValoracionClienteInmueble> valoraciones = gestorValoraciones.getValoraciones(inmueble);
        
        //establecer la información acerca del destino y anfitrión seleccionado
        jLabel24.setText("Anfitrion: "+anfiInmueble.getNombre());
        jLabel34.setText("Valoración: "+anfiInmueble.getMediaValoraciones()+"/5");
        jLabel40.setText(anfiInmueble.getNombre());
        jLabel41.setText(anfiInmueble.getCorreoElectronico());
        jLabel42.setText(anfiInmueble.getTelefono());
        jLabel13.setText(inmueble.getTitulo());
        jLabel19.setText(inmueble.direccionToString());
        jLabel20.setText("Huéspedes máximos "+inmueble.getMaxHuespedes());
        jLabel21.setText("Número de habitaciones: "+inmueble.getNumHabitaciones());
        jLabel22.setText("Número de camas: "+inmueble.getNumCamas()); 
        jLabel23.setText("Número de baños: "+inmueble.getNumBaños());
        jLabel27.setText("Valoración: "+inmueble.getCalificacion()+"/5");
        jLabel29.setText(inmueble.getNumCalif()+" valoraciones");
        jLabel26.setText("Precio por noche: "+inmueble.getPrecioNoche()+"€");
        costeNoche=Integer.parseInt(inmueble.getPrecioNoche());
        
        updateImagePanel(imagePaths);
        mostrarReseñas(inmueble);
        
        dateChooser1 = new JDateChooser();
        dateChooser2 = new JDateChooser();
        
        // Configurar rango de fechas seleccionables para el segundo JDateChooser
        dateChooser2.setSelectableDateRange(null, null);

        // Configurar el primer JDateChooser para que no se puedan seleccionar fechas anteriores a hoy
        dateChooser1.setSelectableDateRange(new Date(), null);
        
        JCalendar calendar1 = dateChooser1.getJCalendar();
        JCalendar calendar2 = dateChooser2.getJCalendar();
        
        calendar1.setWeekOfYearVisible(false);
        calendar2.setWeekOfYearVisible(false);
        
        ArrayList <String> servicios = inmueble.getServicios();
        
        setServicios(servicios);
        
        
        int numMaxHuespedes = Integer.parseInt(inmueble.getMaxHuespedes());
        
        numHuespedes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                checkSpinnerValue(numHuespedes , numMaxHuespedes);
            }
        });
        
        stars = new JLabel[5];

        for (int i = 0; i < stars.length; i++) {
            final int rating = i + 1;
            stars[i] = new JLabel("\u2605");
            stars[i].setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
            stars[i].setForeground(Color.GRAY);

            stars[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setRating(rating);
                }
            });
            
            jPanel4.add(stars[i]);   
        }
    }
    /**
     * Analiza las estrellas selecionadas por el usuario
     * @param rating
     * @return devuelve el numero de estrellas seleccionadas
     */
    private int setRating(int rating) {
        for (int i = 0; i < stars.length; i++) {
            if (i < rating) {
                stars[i].setForeground(Color.DARK_GRAY);
            } else {
                stars[i].setForeground(Color.LIGHT_GRAY);
            }
        }
        return calificacion = rating;
    }
    
    /**
     * Método para añadir las imágenes al jpanel
     * @param imagePaths 
     */
    private void updateImagePanel(ArrayList<String> imagePaths) {
        jPanel2.removeAll();

        int size = imagePaths.size();
        if (size == 0) {
            JLabel noImagesLabel = new JLabel("Imagenes no disponibles");
            jPanel2.add(noImagesLabel);
        } else {
                ImageIcon originalIcon = new ImageIcon(rutaImgs+imagePaths.get(imagen));
                Image originalImage = originalIcon.getImage();
                Image scaledImage = originalImage.getScaledInstance(637, 358, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                
                JLabel imageLabel = new JLabel(scaledIcon);
                jPanel2.add(imageLabel);
        }

        jPanel2.revalidate();
        jPanel2.repaint();
    }
    
    /**
     * Método para identificar los servicios del inmueble
     * @param servicios 
     */
    private void setServicios(ArrayList<String> servicios){
        for (int i=0; i<servicios.size();i++){
            
            String servicio= servicios.get(i);
            
            switch (servicio){
                case "Aire Acondicionado" -> {
                    servicioAC.setSelected(true);
                }
                case "Aparcamiento" -> {
                    servicioAparcamiento.setSelected(true);
                }
                case "Calefacción" -> {
                    servicioCalefaccion.setSelected(true);
                }
                case "Cocina" -> {
                    servicioCocina.setSelected(true);
                }
                case "Lavadora" -> {
                    servicioLavadora.setSelected(true);
                }
                case "Piscina" -> {
                    servicioPiscina.setSelected(true);
                }
                case "Wifi" -> {
                    servicioWifi.setSelected(true);
                }
                case "Zona de trabajo" -> {
                    servicioZonaTrabajo.setSelected(true);
                } 
            }
        }
        
    }
    
    /**
     * Método para calcular los días entre 2 fechas, y multiplicarlo por el precio por noche
     */
    private void updateDaysLabel() {
        Date date1 = dateChooser1.getDate();
        Date date2 = dateChooser2.getDate();
        if (date1 != null && date2 != null) {
            long diff = Math.abs(date2.getTime() - date1.getTime());
            long diffDays = diff / (24 * 60 * 60 * 1000);
            jLabel32.setText(String.valueOf(diffDays*costeNoche)+"€");
        }
    }
    
    private double getPrecioDias(){
        Date date1 = dateChooser1.getDate();
        Date date2 = dateChooser2.getDate();
        if (date1 != null && date2 != null) {
            long diff = Math.abs(date2.getTime() - date1.getTime());
            long diffDays = diff / (24 * 60 * 60 * 1000);
            return diffDays*costeNoche;
        }
        else{
            return 0;
        }
    }
    
    /**
     * Método para verificar el valor del spinner con un máximo, dado por el numero de huespedes máximo
     * @param spinner
     * @param maxValue 
     */
    private void checkSpinnerValue(JSpinner spinner, int maxValue) {
        int value = (int) spinner.getValue();
        if (value > maxValue) {
            spinner.setValue(maxValue);
        }
        else if (value < 1) {
            spinner.setValue(1);
        }
    }
    
    private void mostrarReseñas(Inmueble inmueble) {
        GestorValoraciones gestorValoraciones = new GestorValoraciones();
        List<ValoracionClienteInmueble> valoraciones = gestorValoraciones.getValoraciones(inmueble);

        JPanel jPanelResenas = new JPanel();
        jPanelResenas.setLayout(new BoxLayout(jPanelResenas, BoxLayout.Y_AXIS));  // Configurar layout para apilar JLabels

        if (valoraciones.isEmpty()) {
            JLabel noResenasLabel = new JLabel("no hay reseñas disponibles");
            jPanelResenas.add(noResenasLabel);
        } else {
            for (ValoracionClienteInmueble valoracion : valoraciones) {
                String clienteNombre = valoracion.getCliente().getNombre();
                String resenaTexto = valoracion.getReseña();
                // Usar HTML para formatear el texto con un salto de línea
                String resenaHtml = "<html>" + clienteNombre + "<br/>" + resenaTexto + "</html>";
                JLabel resenaLabel = new JLabel(resenaHtml);
                resenaLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Añadir padding para mejor visualización
                jPanelResenas.add(resenaLabel);
            }
        }

        // Agregar el jPanelResenas al jScrollPane1
        jScrollPane1.setViewportView(jPanelResenas);

        // Refrescar el JScrollPane para asegurar que se muestran los nuevos componentes
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        numHuespedes = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        servicioWifi = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        servicioLavadora = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        servicioAC = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        servicioAparcamiento = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        servicioCalefaccion = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        servicioPiscina = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        servicioCocina = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        servicioZonaTrabajo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonFechaInicial = new javax.swing.JButton();
        botonFechaFinal = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        valorarButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel13.setText("TITULO INMUEBLE");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 180, 60));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("JAVABNB");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

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
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel17.setText("<3");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 124, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 166, 637, 358));

        jLabel19.setText("Localidad, Pais");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 557, -1, -1));

        jLabel24.setText("Anfitrion: ________");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 727, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 812, 567, 13));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 708, 567, 13));

        jLabel25.setText("Descripcion alojamiento");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 831, 432, 92));

        jLabel26.setText("Precio noche");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1615, -1, -1));

        jLabel30.setText("Huespedes");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1654, -1, -1));

        numHuespedes.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        numHuespedes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        numHuespedes.setValue(1);
        numHuespedes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                numHuespedesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(numHuespedes, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 1649, 84, -1));

        jLabel31.setText("TOTAL");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1694, -1, -1));

        jLabel32.setText("precio total");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 1694, -1, -1));

        jButton6.setText("Mostrar más >");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 929, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1497, 567, 13));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        servicioWifi.setEnabled(false);
        servicioWifi.setFocusCycleRoot(true);
        servicioWifi.setFocusable(false);
        servicioWifi.setMaximumSize(new java.awt.Dimension(5, 20));
        servicioWifi.setMinimumSize(new java.awt.Dimension(5, 20));
        servicioWifi.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel7.add(servicioWifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 102, -1));

        jLabel11.setText("Wifi");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 102, 20));

        servicioLavadora.setEnabled(false);
        servicioLavadora.setFocusable(false);
        servicioLavadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicioLavadoraActionPerformed(evt);
            }
        });
        jPanel7.add(servicioLavadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 102, -1));

        jLabel6.setText("Lavadora");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 102, 20));

        servicioAC.setEnabled(false);
        servicioAC.setFocusable(false);
        servicioAC.setMaximumSize(new java.awt.Dimension(5, 20));
        servicioAC.setMinimumSize(new java.awt.Dimension(5, 20));
        servicioAC.setPreferredSize(new java.awt.Dimension(5, 20));
        servicioAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicioACActionPerformed(evt);
            }
        });
        jPanel7.add(servicioAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 102, -1));

        jLabel10.setText("Aire acondicionado");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));

        servicioAparcamiento.setEnabled(false);
        servicioAparcamiento.setFocusable(false);
        jPanel7.add(servicioAparcamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 102, -1));

        jLabel5.setText("Aparcamiento");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 102, 20));

        servicioCalefaccion.setEnabled(false);
        servicioCalefaccion.setFocusable(false);
        servicioCalefaccion.setMaximumSize(new java.awt.Dimension(5, 20));
        servicioCalefaccion.setMinimumSize(new java.awt.Dimension(5, 20));
        servicioCalefaccion.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel7.add(servicioCalefaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 102, -1));

        jLabel4.setText("Calefaccion");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 102, 20));

        servicioPiscina.setEnabled(false);
        servicioPiscina.setFocusable(false);
        jPanel7.add(servicioPiscina, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 102, -1));

        jLabel8.setText("Pisicina");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 102, 20));

        servicioCocina.setEnabled(false);
        servicioCocina.setFocusable(false);
        servicioCocina.setMaximumSize(new java.awt.Dimension(5, 20));
        servicioCocina.setMinimumSize(new java.awt.Dimension(5, 20));
        servicioCocina.setPreferredSize(new java.awt.Dimension(5, 20));
        servicioCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicioCocinaActionPerformed(evt);
            }
        });
        jPanel7.add(servicioCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 102, -1));

        jLabel7.setText("Cocina");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 102, 20));

        servicioZonaTrabajo.setEnabled(false);
        servicioZonaTrabajo.setFocusable(false);
        jPanel7.add(servicioZonaTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 102, -1));

        jLabel9.setText("Zona de trabajo");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 102, 20));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1033, -1, -1));

        jLabel33.setText("Servicios del alojamiento:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 999, -1, -1));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 974, 567, 13));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1716, 567, 13));

        jLabel36.setText("Contactame");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1741, -1, -1));

        jLabel37.setText("Nombre anfitrion");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1775, -1, -1));

        jLabel38.setText("Correo Electronico");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1803, -1, -1));

        jLabel39.setText("Telefono");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1831, -1, -1));

        jLabel40.setText("jLabel30");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 1775, -1, -1));

        jLabel41.setText("jLabel31");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 1803, -1, -1));

        jLabel42.setText("jLabel32");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 1831, -1, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2000, 822, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 85, 15));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fecha Inicial");
        jPanel3.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fecha Final");
        jPanel3.add(jLabel3);

        botonFechaInicial.setText("LLegada");
        botonFechaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFechaInicialActionPerformed(evt);
            }
        });
        jPanel3.add(botonFechaInicial);

        botonFechaFinal.setText("Salida");
        botonFechaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFechaFinalActionPerformed(evt);
            }
        });
        jPanel3.add(botonFechaFinal);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1516, 432, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1593, 432, 10));

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 330, -1, -1));

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 328, -1, -1));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 542, 637, 13));

        jLabel34.setText("Total valoraciones Anfitrión");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 727, -1, -1));

        valorarButton.setText("Valorar Inmueble");
        valorarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(valorarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 557, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 557, 138, 27));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(3, 2, 20, 20));

        jLabel22.setText("Camas");
        jPanel5.add(jLabel22);

        jLabel23.setText("Baños");
        jPanel5.add(jLabel23);

        jLabel20.setText("Huespedes");
        jPanel5.add(jLabel20);

        jLabel27.setText("Valoracion ");
        jPanel5.add(jLabel27);

        jLabel21.setText("Habitaciones");
        jPanel5.add(jLabel21);

        jLabel29.setText("número de valoraciones");
        jPanel5.add(jLabel29);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 602, -1, -1));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1191, 567, 10));
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1207, 567, 272));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 1305, -1, -1));

        jButton4.setText("Reservar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1690, -1, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 2056, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void valorarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorarButtonActionPerformed
        // TODO add your handling code here:
        ValorarInmueble valorarInmueble = new ValorarInmueble(DestinoSeleccionado.this, true);
        valorarInmueble.setVisible(true);
    }//GEN-LAST:event_valorarButtonActionPerformed

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

    private void botonFechaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFechaFinalActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, dateChooser2, "Seleccione una fecha", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Date selectedDate = dateChooser2.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            jLabel3.setText(sdf.format(selectedDate));
            updateDaysLabel();
        }
    }//GEN-LAST:event_botonFechaFinalActionPerformed

    private void botonFechaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFechaInicialActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, dateChooser1, "Seleccione una fecha", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Date selectedDate = dateChooser1.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            jLabel2.setText(sdf.format(selectedDate));
            dateChooser2.setMinSelectableDate(selectedDate);
            updateDaysLabel();
        }
    }//GEN-LAST:event_botonFechaInicialActionPerformed

    private void servicioCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicioCocinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicioCocinaActionPerformed

    private void servicioACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicioACActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicioACActionPerformed

    private void servicioLavadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicioLavadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicioLavadoraActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void numHuespedesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_numHuespedesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_numHuespedesAncestorAdded

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        mostrarReseñas(inmueble);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int precio = (int) getPrecioDias();
        if (precio >0){
        FlotanteReservar reservar = new FlotanteReservar(DestinoSeleccionado.this, true, inmueble, precio);
        reservar.setVisible(true);}
        else{
            JOptionPane.showMessageDialog(this, "Introduzca fecha de entrada y salida");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(DestinoSeleccionado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DestinoSeleccionado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DestinoSeleccionado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DestinoSeleccionado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DestinoSeleccionado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonFechaFinal;
    private javax.swing.JButton botonFechaInicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSpinner numHuespedes;
    private javax.swing.JRadioButton servicioAC;
    private javax.swing.JRadioButton servicioAparcamiento;
    private javax.swing.JRadioButton servicioCalefaccion;
    private javax.swing.JRadioButton servicioCocina;
    private javax.swing.JRadioButton servicioLavadora;
    private javax.swing.JRadioButton servicioPiscina;
    private javax.swing.JRadioButton servicioWifi;
    private javax.swing.JRadioButton servicioZonaTrabajo;
    private javax.swing.JButton valorarButton;
    // End of variables declaration//GEN-END:variables
}
