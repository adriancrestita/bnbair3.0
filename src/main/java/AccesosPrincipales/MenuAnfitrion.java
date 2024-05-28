/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package AccesosPrincipales;


import ManejoDatos.GestorAnfitrion;
import ManejoDatos.GestorInmuebles;
import ManejoDatos.GestorTarjetas;
import ManejoDatos.GestorValoraciones;
import ManejoDatos.VerificarDatos;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import poo.javabnb.Anfitrion;

import poo.javabnb.Inmueble;
import poo.javabnb.Sesion;
import poo.javabnb.TarjetaCredito;

/**
 *
 * @author adria
 */
public class MenuAnfitrion extends javax.swing.JFrame {
    private GestorInmuebles gestorInmuebles = new GestorInmuebles();
    private List<Inmueble> listaInmuebles = gestorInmuebles.obtenerInmuebles();
    private Anfitrion anfitrion;
    private TarjetaCredito tj;
    private GestorAnfitrion gestorAnfitrion;
    private GestorValoraciones gestorValoraciones;
    private GestorTarjetas gestorTarjetas;
    private String PATH_IMAGENES="src/main/java/ImagenesDestino/";
    
    private String[] nombresVariables = {
        "tituloInmueble",
        "calleInmueble",
        "numeroInmueble",
        "cpInmueble",
        "ciudadInmueble",
    };

    private String[] mensajesOriginales = {
        "Ingrese el titulo",
        "Ingrese la calle",
        "Ingrese el número",
        "Ingrese el CP",
        "Ingrese la ciudad",
    };

    private HashMap<String, JTextField> camposDeTexto = new HashMap<>();
    /**
     * Creates new form DialogMenuAnfitrion
     */
    public MenuAnfitrion() {
        super();
        initComponents();
        gestorInmuebles = new GestorInmuebles();
        gestorAnfitrion = new GestorAnfitrion();
        gestorTarjetas = new GestorTarjetas();
        gestorValoraciones = new GestorValoraciones();
        
        //Seteamos el objeto cliente y tarjeta del usuario que está utilizado la aplicación
        anfitrion = gestorAnfitrion.obtenerAnfitrion(Sesion.obtenerCorreoUsuario());
        tj = gestorTarjetas.obtenerTarjeta(Sesion.obtenerCorreoUsuario());
        
        setResizable(false);
        setTitle("JavaBnB");
        
        // Agregamos los campos de texto al HashMap
        camposDeTexto.put("tituloInmueble", tituloInmueble);
        camposDeTexto.put("calleInmueble", calleInmueble);
        camposDeTexto.put("numeroInmueble", numeroInmueble);
        camposDeTexto.put("cpInmueble", cpInmueble);
        camposDeTexto.put("ciudadInmueble", ciudadInmueble);
        
        //SET DE LOS TEXTFIELD CON LOS DATOS DEL CLIENTE
        nombre.setText(anfitrion.getNombre());
        correo.setText(anfitrion.getCorreoElectronico());
        contraseña.setText(anfitrion.getClave());
        telefono.setText(anfitrion.getTelefono());
        dni.setText(anfitrion.getDni());
        superAnfitrion.setSelected(anfitrion.getEsSuperAnfitrion());
        titular.setText(tj.getNombreTitular());
        numtarj.setText(tj.getNumeroTarjeta());
        fcad.setText(tj.getFechaCaducidad());
        if(gestorValoraciones.obtenerMediaValoracionesAnfitrion(anfitrion.getCorreoElectronico())>=4){
            superAnfitrion.setSelected(true);
        }
        System.out.print(anfitrion.cmpSuperAnfitrion());
        System.out.println("numero valoraciones" + gestorValoraciones.obtenerNumeroValoracionesAnfitrion(anfitrion.getCorreoElectronico()));
        System.out.println("MediaValoraciones" + gestorValoraciones.obtenerMediaValoracionesAnfitrion(anfitrion.getCorreoElectronico()));
        
        agregarInmueblesAlScrollPane(listaInmuebles, inmueblesScrollPane);
        
        
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
     * Añade los inmuebles propios del anfitrionm al  scroll panel principal
     * @param listaInmuebles
     * @param scrollPane 
     */
    private void agregarInmueblesAlScrollPane(List<Inmueble> listaInmuebles, JScrollPane scrollPane) {
        // Crear el panel principal que contendrá todos los inmuebles
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE); // Establecer el color de fondo del panel principal

        // Obtener el correo del usuario logueado
        String correoUsuario = Sesion.obtenerCorreoUsuario();

        // Iterar sobre la lista de inmuebles para crear un JPanel para cada uno
        for (Inmueble inmueble : listaInmuebles) {
            // Filtrar los inmuebles por el correo del anfitrión
            if (!inmueble.getCorreoAnfitrion().equals(correoUsuario)) {
                continue; // Saltar los inmuebles que no pertenecen al usuario logueado
            }

            // Crear un JPanel para el inmueble actual con FlowLayout
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.setBackground(Color.WHITE); // Establecer el color de fondo del panel del inmueble
            itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir margen

            // Cargar y reescalar la imagen
            ImageIcon originalIcon = new ImageIcon(PATH_IMAGENES + inmueble.getImages().get(0));
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(125, 127, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledIcon); // Añadir la imagen reescalada

            // Crear un panel para la información del inmueble
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setBackground(Color.WHITE);

            JLabel titleLabel = new JLabel(inmueble.getTitulo());
            JLabel priceLabel = new JLabel(inmueble.getPrecioNoche() + "€");
            JLabel addressLabel = new JLabel("C/" + inmueble.getCalle() + ", " + inmueble.getCiudad());

            infoPanel.add(titleLabel);
            infoPanel.add(addressLabel);
            infoPanel.add(priceLabel);

            // Añadir la imagen y la información al panel del inmueble
            itemPanel.add(imageLabel);
            itemPanel.add(infoPanel);

            // Añadir MouseListener para capturar clics en el JPanel
            itemPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Acción al hacer clic en el JPanel
                    DestinoModificacion destino = new DestinoModificacion(inmueble);
                    destino.setVisible(true);
                    dispose();
                }
            });

            // Agregar el JPanel del inmueble al panel principal
            mainPanel.add(itemPanel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre los paneles de inmuebles
        }

        // Configurar el JScrollPane con el panel principal
        scrollPane.setViewportView(mainPanel);

        // Refrescar el JScrollPane para asegurar que se muestran los nuevos componentes
        scrollPane.revalidate();
        scrollPane.repaint();
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
        buttonInmuebles = new javax.swing.JButton();
        buttonCrear = new javax.swing.JButton();
        buttonPerfil = new javax.swing.JButton();
        buttonCerrarSesion = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelMisInmuebles = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inmueblesScrollPane = new javax.swing.JScrollPane();
        PanelCrearInmueble = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tituloInmueble = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        calleInmueble = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        numeroInmueble = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cpInmueble = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        ciudadInmueble = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        imagenesInmueble = new javax.swing.JButton();
        siguiente1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tipoInmueble = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        maxHuespedes = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        numCamas = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        numHabitaciones = new javax.swing.JSpinner();
        numBaños = new javax.swing.JSpinner();
        atras2 = new javax.swing.JButton();
        siguiente2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        precioNoche = new javax.swing.JSlider();
        precioEtiqueta = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        servicioWifi = new javax.swing.JRadioButton();
        servicioAC = new javax.swing.JRadioButton();
        servicioCalefacción = new javax.swing.JRadioButton();
        servicioCocina = new javax.swing.JRadioButton();
        servicioLavadora = new javax.swing.JRadioButton();
        servicioAparcamiento = new javax.swing.JRadioButton();
        servicioPiscina = new javax.swing.JRadioButton();
        servicioZonaTrabajo = new javax.swing.JRadioButton();
        atras3 = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        panelMiPerfil = new javax.swing.JPanel();
        PanelPerfil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        superAnfitrion = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        cambioDatos = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        contraseña = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        titular = new javax.swing.JTextField();
        numtarj = new javax.swing.JTextField();
        fcad = new javax.swing.JTextField();
        editButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(169, 116, 81));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonInmuebles.setText("Mis Inmuebles");
        buttonInmuebles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInmueblesActionPerformed(evt);
            }
        });
        jPanel1.add(buttonInmuebles, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 311, 120, -1));

        buttonCrear.setText("Crear Inmueble");
        buttonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 352, 120, -1));

        buttonPerfil.setText("Mi Perfil");
        buttonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(buttonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 393, 120, -1));

        buttonCerrarSesion.setText("Cerrar Sesión");
        buttonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 434, 120, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 500));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        PanelMisInmuebles.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("MIS INMUEBLES");

        inmueblesScrollPane.getVerticalScrollBar().setUnitIncrement(20);

        javax.swing.GroupLayout PanelMisInmueblesLayout = new javax.swing.GroupLayout(PanelMisInmuebles);
        PanelMisInmuebles.setLayout(PanelMisInmueblesLayout);
        PanelMisInmueblesLayout.setHorizontalGroup(
            PanelMisInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMisInmueblesLayout.createSequentialGroup()
                .addGroup(PanelMisInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMisInmueblesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(inmueblesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelMisInmueblesLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        PanelMisInmueblesLayout.setVerticalGroup(
            PanelMisInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMisInmueblesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inmueblesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", PanelMisInmuebles);

        PanelCrearInmueble.setBackground(new java.awt.Color(255, 255, 255));
        PanelCrearInmueble.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("NUEVO INMUEBLE");

        jLabel8.setText("Titulo");

        tituloInmueble.setForeground(new java.awt.Color(204, 204, 204));
        tituloInmueble.setText("Ingrese el titulo");
        tituloInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloInmuebleActionPerformed(evt);
            }
        });

        jLabel3.setText("Calle");

        calleInmueble.setForeground(new java.awt.Color(204, 204, 204));
        calleInmueble.setText("Ingrese la calle");
        calleInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calleInmuebleActionPerformed(evt);
            }
        });

        jLabel10.setText("Numero");

        numeroInmueble.setForeground(new java.awt.Color(204, 204, 204));
        numeroInmueble.setText("Ingrese el número");

        jLabel14.setText("C.P.");

        cpInmueble.setForeground(new java.awt.Color(204, 204, 204));
        cpInmueble.setText("Ingrese el CP");

        jLabel15.setText("Ciudad");

        ciudadInmueble.setForeground(new java.awt.Color(204, 204, 204));
        ciudadInmueble.setText("Ingrese la ciudad");

        jLabel16.setText("Introduzca imagenes del inmueble");

        imagenesInmueble.setText("Examinar archivos locales");
        imagenesInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenesInmuebleActionPerformed(evt);
            }
        });

        siguiente1.setText("Siguiente");
        siguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguiente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cpInmueble, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calleInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(407, 407, 407))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(186, 186, 186)
                                .addComponent(jLabel10))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imagenesInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(tituloInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15)
                                    .addComponent(numeroInmueble)
                                    .addComponent(ciudadInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(siguiente1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel6)
                .addGap(76, 76, 76)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calleInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ciudadInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenesInmueble)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(siguiente1)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setText("NUEVO INMUEBLE");

        jLabel21.setText("Tipo de propiedad");

        tipoInmueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casa", "Apartamento" }));
        tipoInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoInmuebleActionPerformed(evt);
            }
        });

        jLabel22.setText("Máximo de huespedes");

        maxHuespedes.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        maxHuespedes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        maxHuespedes.setValue(1);
        maxHuespedes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                maxHuespedesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel23.setText("Número de habitaciones");

        numCamas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        numCamas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        numCamas.setValue(1);
        numCamas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                numCamasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel24.setText("Número de camas");

        jLabel25.setText("Número de baños");

        numHabitaciones.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        numHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        numHabitaciones.setValue(1);
        numHabitaciones.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                numHabitacionesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        numBaños.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        numBaños.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        numBaños.setValue(1);
        numBaños.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                numBañosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        atras2.setText("Atras");
        atras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atras2ActionPerformed(evt);
            }
        });

        siguiente2.setText("Siguiente");
        siguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguiente2ActionPerformed(evt);
            }
        });

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        jLabel2.setText("Breve descripcion:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(atras2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(siguiente2)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(224, 224, 224))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addComponent(maxHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel24)
                                        .addComponent(numCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(77, 77, 77)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numBaños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel23)
                                        .addComponent(numHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                        .addGap(126, 126, 126))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel20)
                .addGap(37, 37, 37)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numBaños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atras2)
                    .addComponent(siguiente2))
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setText("NUEVO INMUEBLE");

        jLabel27.setText("Precio por noche");

        precioNoche.setMajorTickSpacing(1);
        precioNoche.setMaximum(1000);
        precioNoche.setMinimum(1);
        precioNoche.setMinorTickSpacing(1);
        precioNoche.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jLabel28.setText("Servicios");

        servicioWifi.setText("Wifi");

        servicioAC.setText("Aire Acondicionado");

        servicioCalefacción.setText("Calefacción");

        servicioCocina.setText("Cocina");

        servicioLavadora.setText("Lavadora");

        servicioAparcamiento.setText("Aparcamiento");

        servicioPiscina.setText("Piscina");

        servicioZonaTrabajo.setText("Zona de trabajo");

        atras3.setText("Atras");
        atras3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atras3ActionPerformed(evt);
            }
        });

        finalizar.setText("Finalizar");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(precioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(59, 59, 59)
                                .addComponent(precioEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 305, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servicioWifi)
                            .addComponent(servicioAC)
                            .addComponent(servicioCocina)
                            .addComponent(servicioCalefacción))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servicioPiscina)
                            .addComponent(servicioZonaTrabajo)
                            .addComponent(servicioAparcamiento)
                            .addComponent(servicioLavadora))
                        .addGap(208, 208, 208))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(224, 224, 224))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(atras3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finalizar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel26)
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(precioEtiqueta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicioWifi)
                    .addComponent(servicioLavadora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicioAC)
                    .addComponent(servicioAparcamiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicioCalefacción)
                    .addComponent(servicioPiscina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicioCocina)
                    .addComponent(servicioZonaTrabajo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atras3)
                    .addComponent(finalizar))
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab3", jPanel4);

        PanelCrearInmueble.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -35, 610, 540));

        jTabbedPane1.addTab("tab2", PanelCrearInmueble);

        panelMiPerfil.setBackground(new java.awt.Color(255, 255, 255));

        PanelPerfil.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("MI PERFIL");

        jLabel5.setText("Nombre:");

        jLabel7.setText("Correo Electronico:");

        jLabel9.setText("Contraseña:");

        jLabel11.setText("DNI:");

        jLabel13.setText("Titular Tarjeta:");

        jLabel17.setText("Numero Tarjeta:");

        jLabel18.setText("Fecha Caducidad:");

        jLabel19.setText("Super Anfitrión");

        superAnfitrion.setEnabled(false);
        superAnfitrion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                superAnfitrionActionPerformed(evt);
            }
        });

        jLabel12.setText("Telefono:");

        cambioDatos.setText("Cambiar Datos");
        cambioDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioDatosActionPerformed(evt);
            }
        });

        nombre.setFocusable(false);

        correo.setFocusable(false);

        contraseña.setFocusable(false);

        dni.setFocusable(false);

        telefono.setFocusable(false);

        titular.setFocusable(false);

        numtarj.setFocusable(false);

        fcad.setFocusable(false);

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

        javax.swing.GroupLayout PanelPerfilLayout = new javax.swing.GroupLayout(PanelPerfil);
        PanelPerfil.setLayout(PanelPerfilLayout);
        PanelPerfilLayout.setHorizontalGroup(
            PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPerfilLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPerfilLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cambioDatos))
                            .addGroup(PanelPerfilLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(superAnfitrion)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel13)
                                    .addComponent(titular, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numtarj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fcad, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(140, 140, 140)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        PanelPerfilLayout.setVerticalGroup(
            PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPerfilLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel4)
                .addGap(19, 19, 19)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numtarj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(superAnfitrion))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cambioDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        panelMiPerfil.add(PanelPerfil);

        jTabbedPane1.addTab("tab3", panelMiPerfil);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, -40, 600, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInmueblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInmueblesActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        //DialogCrearInmuebles dci = new DialogCrearInmuebles();
    }//GEN-LAST:event_buttonInmueblesActionPerformed

    private void buttonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_buttonCrearActionPerformed

    private void buttonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPerfilActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_buttonPerfilActionPerformed
    private List<String> paths;
    private File[] files;
    private int result;
    private ArrayList<String> imagePaths;
    private void imagenesInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenesInmuebleActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true); // Permite seleccionar múltiples archivos
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Solo archivos, no directorios
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "png", "gif", "bmp")); // Filtra solo archivos de imagen

        result = fileChooser.showOpenDialog(null); // Muestra el diálogo del selector de archivos
        paths = new ArrayList<>();
        if (result == JFileChooser.APPROVE_OPTION) {
            files = fileChooser.getSelectedFiles(); // Obtiene los archivos seleccionados
            for (File file : files) {
                paths.add(file.getName());
            }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún archivo");
        }
        
        imagePaths = (ArrayList<String>) paths;
        
    }//GEN-LAST:event_imagenesInmuebleActionPerformed

    private void siguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguiente1ActionPerformed
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_siguiente1ActionPerformed

    private void tipoInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoInmuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoInmuebleActionPerformed

    private void maxHuespedesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_maxHuespedesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_maxHuespedesAncestorAdded

    private void numCamasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_numCamasAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_numCamasAncestorAdded

    private void numHabitacionesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_numHabitacionesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_numHabitacionesAncestorAdded

    private void numBañosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_numBañosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_numBañosAncestorAdded

    private void atras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atras2ActionPerformed
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_atras2ActionPerformed

    private void siguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguiente2ActionPerformed
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_siguiente2ActionPerformed

    private void precioNocheAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_precioNocheAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_precioNocheAncestorAdded
    private void precioNocheStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_precioNocheStateChanged
        // TODO add your handling code here:
        int price = precioNoche.getValue();
        precioEtiqueta.setText(String.valueOf(price));
    }//GEN-LAST:event_precioNocheStateChanged

    private void atras3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atras3ActionPerformed
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_atras3ActionPerformed
    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        // TODO add your handling code here:
        String titulo = tituloInmueble.getText().trim();
        String calle = calleInmueble.getText().trim();
        String ciudad = ciudadInmueble.getText().trim();
        String CP = cpInmueble.getText().trim();
        String huespedes = String.valueOf(maxHuespedes.getValue());
        String tipo = (String) tipoInmueble.getSelectedItem();
        String baños = String.valueOf(numBaños.getValue());
        String camas = String.valueOf(numCamas.getValue());
        String habitaciones = String.valueOf(numHabitaciones.getValue());
        String numero = numeroInmueble.getText().trim();
        String precio = String.valueOf(precioNoche.getValue());
        ArrayList servicios = new ArrayList<String>();
        
        if(servicioAC.isSelected()){
            servicios.add("Aire Acondicionado");
        } 
        if(servicioAparcamiento.isSelected()){
            servicios.add("Aparcamiento");
        }
        if(servicioCalefacción.isSelected()){
            servicios.add("Calefacción");
        } 
        if(servicioCocina.isSelected()){
            servicios.add("Cocina");
        }
        if(servicioLavadora.isSelected()){
            servicios.add("Lavadora");
        } 
        if(servicioPiscina.isSelected()){
            servicios.add("Piscina");
        }
        if(servicioWifi.isSelected()){
            servicios.add("Wifi");
        } 
        if(servicioZonaTrabajo.isSelected()){
            servicios.add("Zona de trabajo");
        }
        if(VerificarDatos.validarInmueble(titulo, calle, numero, CP, ciudad, precio)){
            List<String> initialElements = Arrays.asList(calle, numero, ciudad, CP);       
            ArrayList<String> direccion = new ArrayList<>(initialElements);        
            
            
            Inmueble nuevoInmueble = new Inmueble(Sesion.obtenerCorreoUsuario(), titulo, direccion, huespedes, habitaciones, camas, baños, tipo, precio, servicios, imagePaths, descripcion.getText());
            //nuevoInmueble.setAnfitrion(anfitrion);
            gestorInmuebles.agregarInmueble(nuevoInmueble);  
            MetodosConsultaInmuebles.saveImages(files);
            JOptionPane.showMessageDialog(this, "Creado correctamente");
            jTabbedPane1.setSelectedIndex(0);

        }
        else{
            JOptionPane.showMessageDialog(this, "Los datos introducidos no son validos");
        }
        listaInmuebles = gestorInmuebles.obtenerInmuebles();
        agregarInmueblesAlScrollPane(listaInmuebles, inmueblesScrollPane);
    }//GEN-LAST:event_finalizarActionPerformed

    private void buttonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarSesionActionPerformed
        // TODO add your handling code here:
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonCerrarSesionActionPerformed

    private void tituloInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloInmuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloInmuebleActionPerformed

    private void calleInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calleInmuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calleInmuebleActionPerformed

    private void superAnfitrionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_superAnfitrionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_superAnfitrionActionPerformed

    private void cambioDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioDatosActionPerformed
        // TODO add your handling code here:
        if (editButton.isSelected()){
            JFrame frame = new JFrame("Confirm Dialog Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            int response = JOptionPane.showConfirmDialog(frame,
                "¿Desea guardar los cambios establecidos?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                // Acción cuando se pulsa "Aceptar"

                //Modifico los cambios del anfitrion
                Anfitrion cambioAnfitrion = new Anfitrion(dni.getText().trim(), nombre.getText().trim(), correo.getText().trim(), contraseña.getText().trim(), telefono.getText().trim(), anfitrion.getFechaRegistro(), superAnfitrion.isSelected());
                gestorAnfitrion.modificarAnfitrion(Sesion.obtenerCorreoUsuario(), cambioAnfitrion);

                //Modifico los cambios de las tarjetas
                TarjetaCredito tj = new TarjetaCredito(dni.getText().trim(), titular.getText().trim(), numtarj.getText().trim(), fcad.getText().trim());
                gestorTarjetas.modificarTarjeta(Sesion.obtenerCorreoUsuario(), tj);

                //Si se cambia el correo cambia el usuario Registrado
                Sesion.iniciarSesion(dni.getText());

                JOptionPane.showMessageDialog(frame, "Los cambios se han guardado.");
            } else if (response == JOptionPane.NO_OPTION) {
                // Acción cuando se pulsa "Cancelar"
                JOptionPane.showMessageDialog(frame, "Los cambios no se han guardado.");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Cierre el candado para guardar los datos");
        }

    }//GEN-LAST:event_cambioDatosActionPerformed

    private void editButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editButtonStateChanged

    }//GEN-LAST:event_editButtonStateChanged

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if(editButton.isSelected()){
            editButton.setBackground(Color.white);
            editButton.setText("🔒");

            //Hacemos que los text field sean editables desactivado el modo editable
            nombre.setEditable(false);
            correo.setEditable(false);
            contraseña.setEditable(false);
            telefono.setEditable(false);
            dni.setEditable(false);
            titular.setEditable(false);
            numtarj.setEditable(false);
            fcad.setEditable(false);
            
            //Desactivamos el enabled de los textField
            nombre.setEnabled(false);
            correo.setEnabled(false);
            contraseña.setEnabled(false);
            telefono.setEnabled(false);
            dni.setEnabled(false);
            titular.setEnabled(false);
            numtarj.setEnabled(false);
            fcad.setEnabled(false);

            //Hacemos que no se pueda hacer focus al text field
            nombre.setFocusable(false);
            correo.setFocusable(false);
            contraseña.setFocusable(false);
            telefono.setFocusable(false);
            dni.setFocusable(false);
            titular.setFocusable(false);
            numtarj.setFocusable(false);
            fcad.setFocusable(false);
            
            
        }
        else{
            editButton.setBackground(Color.white);
            editButton.setText("🔓");

            //Hacemos que los text field sean editables activado el modo editable
            nombre.setEditable(true);
            correo.setEditable(true);
            contraseña.setEditable(true);
            telefono.setEditable(true);
            dni.setEditable(true);
            titular.setEditable(true);
            numtarj.setEditable(true);
            fcad.setEditable(true);
            
            //Hacemos que los textField estén enabled ya que se están desactivador por defecto
            nombre.setEnabled(true);
            correo.setEnabled(true);
            contraseña.setEnabled(true);
            telefono.setEnabled(true);
            dni.setEnabled(true);
            titular.setEnabled(true);
            numtarj.setEnabled(true);
            fcad.setEnabled(true);

            //Hacemos que no se pueda hacer focus al text field
            nombre.setFocusable(true);
            correo.setFocusable(true);
            contraseña.setFocusable(true);
            telefono.setFocusable(true);
            dni.setFocusable(true);
            titular.setFocusable(true);
            numtarj.setFocusable(true);
            fcad.setFocusable(true);
            
        }
    }//GEN-LAST:event_editButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAnfitrion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAnfitrion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAnfitrion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAnfitrion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuAnfitrion dialog = new MenuAnfitrion();
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
    private javax.swing.JPanel PanelCrearInmueble;
    private javax.swing.JPanel PanelMisInmuebles;
    private javax.swing.JPanel PanelPerfil;
    private javax.swing.JButton atras2;
    private javax.swing.JButton atras3;
    private javax.swing.JButton buttonCerrarSesion;
    private javax.swing.JButton buttonCrear;
    private javax.swing.JButton buttonInmuebles;
    private javax.swing.JButton buttonPerfil;
    private javax.swing.JTextField calleInmueble;
    private javax.swing.JButton cambioDatos;
    private javax.swing.JTextField ciudadInmueble;
    private javax.swing.JTextField contraseña;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField cpInmueble;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JTextField dni;
    private javax.swing.JToggleButton editButton;
    private javax.swing.JTextField fcad;
    private javax.swing.JButton finalizar;
    private javax.swing.JButton imagenesInmueble;
    private javax.swing.JScrollPane inmueblesScrollPane;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JSpinner maxHuespedes;
    private javax.swing.JTextField nombre;
    private javax.swing.JSpinner numBaños;
    private javax.swing.JSpinner numCamas;
    private javax.swing.JSpinner numHabitaciones;
    private javax.swing.JTextField numeroInmueble;
    private javax.swing.JTextField numtarj;
    private javax.swing.JPanel panelMiPerfil;
    private javax.swing.JLabel precioEtiqueta;
    private javax.swing.JSlider precioNoche;
    private javax.swing.JRadioButton servicioAC;
    private javax.swing.JRadioButton servicioAparcamiento;
    private javax.swing.JRadioButton servicioCalefacción;
    private javax.swing.JRadioButton servicioCocina;
    private javax.swing.JRadioButton servicioLavadora;
    private javax.swing.JRadioButton servicioPiscina;
    private javax.swing.JRadioButton servicioWifi;
    private javax.swing.JRadioButton servicioZonaTrabajo;
    private javax.swing.JButton siguiente1;
    private javax.swing.JButton siguiente2;
    private javax.swing.JCheckBox superAnfitrion;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<String> tipoInmueble;
    private javax.swing.JTextField titular;
    private javax.swing.JTextField tituloInmueble;
    // End of variables declaration//GEN-END:variables
}
