/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package AccesosPrincipales;

import java.awt.Image;
import javax.swing.ImageIcon;
import ManejoDatos.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import poo.javabnb.*;

/**
 *
 * @author Usuario
 */
public class MenuParticular extends javax.swing.JFrame {

    /**
     * Creates new form DialogMenuParticular
     */
    private GestorInmuebles gestorInmuebles = new GestorInmuebles();
    private List<Inmueble> listaInmuebles = gestorInmuebles.obtenerInmuebles();
    private final String PATH_IMAGENES="src/main/java/ImagenesDestino/";
    
    private ClienteParticular cliente;
    private GestorClientes gestorClientes = new GestorClientes();
    private GestorTarjetas gestorTarjetas;
    private TarjetaCredito tj;
   
    
    
    /**
     * Constructor del jFrame
     */
    public MenuParticular() {
        super();
        initComponents();
        setTitle("JavaBnB");
        setResizable(false);
        
        gestorTarjetas = new GestorTarjetas();  
        
        
        //Seteamos el objeto cliente y tarjeta del usuario que está utilizado la aplicación
        cliente = gestorClientes.obtenerCliente(Sesion.obtenerCorreoUsuario());
        tj = gestorTarjetas.obtenerTarjeta(Sesion.obtenerCorreoUsuario());

        
        agregarInmueblesAlScrollPane(listaInmuebles, scrollPaneReservas);
        
        //SET DE LOS TEXTFIELD CON LOS DATOS DEL CLIENTE
        nombre.setText(cliente.getNombre());
        correo.setText(cliente.getCorreoElectronico());
        contraseña.setText(cliente.getClave());
        telefono.setText(cliente.getTelefono());
        dni.setText(cliente.getDni());
        vip.setSelected(cliente.cmpVIP());
        titular.setText(tj.getNombreTitular());
        numtarj.setText(tj.getNumeroTarjeta());
        fcad.setText(tj.getFechaCaducidad());
        
        comboBoxOrdenar.addItem("Precio Ascendente");
        comboBoxOrdenar.addItem("Precio Descendente");
        comboBoxOrdenar.addItem("Relevancia");

        comboBoxFiltrar.addItem("Todos");
        comboBoxFiltrar.addItem("Casas");
        comboBoxFiltrar.addItem("Apartamentos");

    }
    
    /**
     * Agrega los inmuebles disponibles al scroll panel
     * @param listaInmuebles
     * @param scrollPane 
     */
    private void agregarInmueblesAlScrollPane(List<Inmueble> listaInmuebles, JScrollPane scrollPane) {
        // Crear el panel principal que contendrá todos los inmuebles
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE); // Establecer el color de fondo del panel principal

        // Configurar los GridBagConstraints para el panel principal
        GridBagConstraints mainGbc = new GridBagConstraints();
        mainGbc.fill = GridBagConstraints.HORIZONTAL;
        mainGbc.insets = new Insets(10, 10, 10, 10);

        int row = 0;
        int col = 0;

        // Iterar sobre la lista de inmuebles para crear un JPanel para cada uno
        for (Inmueble inmueble : listaInmuebles) {
            // Crear un JPanel para el inmueble actual
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new GridBagLayout());
            itemPanel.setBackground(Color.WHITE); // Establecer el color de fondo del panel del inmueble
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre componentes

            // Cargar y reescalar la imagen
            ImageIcon originalIcon = new ImageIcon(PATH_IMAGENES + inmueble.getImages().get(0));
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(125, 127, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledIcon); // Añadir la imagen reescalada

            JLabel titleLabel = new JLabel(inmueble.getTitulo());
            JLabel priceLabel = new JLabel(inmueble.getPrecioNoche() + "€");
            JLabel addressLabel = new JLabel("C/" + inmueble.getCalle() + ", " + inmueble.getCiudad());

            gbc.gridx = 0;
            gbc.gridy = 0;
            itemPanel.add(imageLabel, gbc);

            gbc.gridy = 1;
            itemPanel.add(titleLabel, gbc);

            gbc.gridy = 2;
            itemPanel.add(addressLabel, gbc);

            gbc.gridy = 3;
            itemPanel.add(priceLabel, gbc);

            // Añadir MouseListener para capturar clics en el JPanel
            itemPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Acción al hacer clic en el JPanel
                    DestinoSeleccionado destino = new DestinoSeleccionado(inmueble);
                    destino.setVisible(true);
                }
            });

            // Agregar el JPanel del inmueble al panel principal
            mainGbc.gridx = col;
            mainGbc.gridy = row;
            mainPanel.add(itemPanel, mainGbc);

            // Actualizar las coordenadas para la siguiente iteración
            col++;
            if (col == 3) { // Si se alcanza la tercera columna, saltar a la siguiente fila
                col = 0;
                row++;
            }
        }

        // Agregar un panel vacío para empujar los elementos a la esquina superior izquierda
        mainGbc.gridx = 0;
        mainGbc.gridy = row + 1;
        mainGbc.weightx = 1;
        mainGbc.weighty = 1;
        mainPanel.add(new JPanel(), mainGbc);

        // Configurar el JScrollPane con el panel principal
        scrollPane.setViewportView(mainPanel);
    }
    
    /**
     * Método para filtrar inmuebles por ciudad
     * @param listaInmuebles
     * @param query
     * @return devuelve la lista de inmuebles filtrados
     */
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
        comboBoxOrdenar = new javax.swing.JComboBox<>();
        comboBoxFiltrar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelMisReservas = new javax.swing.JPanel();
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
        vip = new javax.swing.JCheckBox();
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
        panelExplorarReservas.add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, -1));

        scrollPaneReservas.getVerticalScrollBar().setUnitIncrement(20);
        panelExplorarReservas.add(scrollPaneReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 550, 420));

        comboBoxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxOrdenarActionPerformed(evt);
            }
        });
        panelExplorarReservas.add(comboBoxOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        comboBoxFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFiltrarActionPerformed(evt);
            }
        });
        panelExplorarReservas.add(comboBoxFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        jLabel1.setText("Ordenar por:");
        panelExplorarReservas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel2.setText("Filtrar por:");
        panelExplorarReservas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jTabbedPane1.addTab("tab1", panelExplorarReservas);

        panelMisReservas.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addTab("tab2", panelMisReservas);

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

        jLabel19.setText("VIP");

        vip.setEnabled(false);
        vip.setFocusable(false);
        vip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vipActionPerformed(evt);
            }
        });

        jLabel12.setText("Telefono:");

        cambioDatos.setText("Cambiar Datos");
        cambioDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioDatosActionPerformed(evt);
            }
        });

        nombre.setEnabled(false);
        nombre.setFocusable(false);

        correo.setEnabled(false);
        correo.setFocusable(false);

        contraseña.setEnabled(false);
        contraseña.setFocusable(false);

        dni.setEnabled(false);
        dni.setFocusable(false);

        telefono.setEnabled(false);
        telefono.setFocusable(false);

        titular.setEnabled(false);
        titular.setFocusable(false);

        numtarj.setEnabled(false);
        numtarj.setFocusable(false);

        fcad.setEnabled(false);
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
                            .addComponent(nombre)
                            .addComponent(correo)
                            .addComponent(contraseña)
                            .addComponent(dni)
                            .addComponent(telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPerfilLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cambioDatos))
                            .addGroup(PanelPerfilLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vip)
                                    .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel13)
                                        .addComponent(titular)
                                        .addComponent(numtarj)
                                        .addComponent(fcad, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))))
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(140, 140, 140)))
                .addContainerGap(119, Short.MAX_VALUE))
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
                    .addComponent(vip))
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
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        
    }//GEN-LAST:event_buttonCerrarSesionActionPerformed

    private void vipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vipActionPerformed

    private void cambioDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioDatosActionPerformed
        // TODO add your handling code here:
        if (editButton.isEnabled()){
            JOptionPane.showMessageDialog(this, "Cierre el candado para guardar los datos");
        }
        else{
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

                //Modifico los datos del cliente
                ClienteParticular cambioCliente = new ClienteParticular(dni.getText().trim(), nombre.getText().trim(), correo.getText().trim(), contraseña.getText().trim(), telefono.getText().trim(), vip.isSelected());
                gestorClientes.modificarCliente(Sesion.obtenerCorreoUsuario(), cambioCliente);

                //Modifico los cambios de las tarjetas
                TarjetaCredito tj = new TarjetaCredito(dni.getText().trim(), titular.getText().trim(), numtarj.getText().trim(), fcad.getText().trim());
                gestorTarjetas.modificarTarjeta(Sesion.obtenerCorreoUsuario(), tj);

                Sesion.iniciarSesion(dni.getText());
                JOptionPane.showMessageDialog(frame, "Los cambios se han guardado.");
            } else if (response == JOptionPane.NO_OPTION) {
                // Acción cuando se pulsa "Cancelar"
                JOptionPane.showMessageDialog(frame, "Los cambios no se han guardado.");
            }
        }
    
    }//GEN-LAST:event_cambioDatosActionPerformed

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
            vip.setEnabled(false);
            
            //Hacemos que no se pueda hacer focus al text field
            nombre.setFocusable(false);
            correo.setFocusable(false);
            contraseña.setFocusable(false);
            telefono.setFocusable(false);
            dni.setFocusable(false);
            titular.setFocusable(false);
            numtarj.setFocusable(false);
            fcad.setFocusable(false);
            
            //Desactivamos el enabled
            nombre.setEnabled(false);
            correo.setEnabled(false);
            contraseña.setEnabled(false);
            telefono.setEnabled(false);
            dni.setEnabled(false);
            titular.setEnabled(false);
            numtarj.setEnabled(false);
            fcad.setEnabled(false);
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
            vip.setEnabled(true);
            titular.setEditable(true);
            numtarj.setEditable(true);
            fcad.setEditable(true);
            
            //Hacemos que no se pueda hacer focus al text field
            nombre.setFocusable(true);
            correo.setFocusable(true);
            contraseña.setFocusable(true);
            telefono.setFocusable(true);
            dni.setFocusable(true);
            titular.setFocusable(true);
            numtarj.setFocusable(true);
            fcad.setFocusable(true);
            
            //Activamos el enabled
            nombre.setEnabled(true);
            correo.setEnabled(true);
            contraseña.setEnabled(true);
            telefono.setEnabled(true);
            dni.setEnabled(true);
            titular.setEnabled(true);
            numtarj.setEnabled(true);
            fcad.setEnabled(true);
            

        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void editButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editButtonStateChanged
        
    }//GEN-LAST:event_editButtonStateChanged

    private void buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorActionPerformed
        // TODO add your handling code here:
        String query = buscador.getText();
        List<Inmueble> listaFiltrada = filtrarInmuebles(listaInmuebles, query);
        agregarInmueblesAlScrollPane(listaFiltrada, scrollPaneReservas);
        jLabel30.requestFocus(true);
        buscador.setText("🔍 Buscador de destinos");
    }//GEN-LAST:event_buscadorActionPerformed

    private void buscadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorFocusLost
        // TODO add your handling code here:
        if (buscador.getText().equals("")){
            buscador.setText("🔍 Buscador de destinos");
        }
    }//GEN-LAST:event_buscadorFocusLost

    private void buscadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorFocusGained
        // TODO add your handling code here:
        if (buscador.getText().equals("🔍 Buscador de destinos")){
            buscador.setText("");
        }
    }//GEN-LAST:event_buscadorFocusGained

    private void comboBoxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxOrdenarActionPerformed
        // TODO add your handling code here:
        String selectedOrder = (String) comboBoxOrdenar.getSelectedItem();
        switch (selectedOrder) {
            case "Precio Ascendente":
                listaInmuebles.sort(Comparator.comparing(Inmueble::getPrecioNoche));
                break;
            case "Precio Descendente":
                listaInmuebles.sort(Comparator.comparing(Inmueble::getPrecioNoche).reversed());
                break;
            case "Valoración":
                listaInmuebles.sort(Comparator.comparing(Inmueble::getCalificacion).reversed());
                break;
        }
        agregarInmueblesAlScrollPane(listaInmuebles, scrollPaneReservas);
    }//GEN-LAST:event_comboBoxOrdenarActionPerformed

    private void comboBoxFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFiltrarActionPerformed
        // TODO add your handling code here:
        String selectedFilter = (String) comboBoxFiltrar.getSelectedItem();
        List<Inmueble> filteredList;
        switch (selectedFilter) {
            case "Casas":
                filteredList = listaInmuebles.stream()
                                             .filter(inmueble -> "Casa".equals(inmueble.getTipoPropiedad()))
                                             .collect(Collectors.toList());
                break;
            case "Apartamentos":
                filteredList = listaInmuebles.stream()
                                             .filter(inmueble -> "Apartamento".equals(inmueble.getTipoPropiedad()))
                                             .collect(Collectors.toList());
                break;
            default:
                filteredList = listaInmuebles;
                break;
        }
        agregarInmueblesAlScrollPane(filteredList, scrollPaneReservas);
    }//GEN-LAST:event_comboBoxFiltrarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuParticular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuParticular dialog = new MenuParticular();
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
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buttonCerrarSesion;
    private javax.swing.JButton buttonInmuebleDispo;
    private javax.swing.JButton buttonMisReservas;
    private javax.swing.JButton buttonPerfil;
    private javax.swing.JButton cambioDatos;
    private javax.swing.JComboBox<String> comboBoxFiltrar;
    private javax.swing.JComboBox<String> comboBoxOrdenar;
    private javax.swing.JTextField contraseña;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField dni;
    private javax.swing.JToggleButton editButton;
    private javax.swing.JTextField fcad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField numtarj;
    private javax.swing.JPanel panelExplorarReservas;
    private javax.swing.JPanel panelMiPerfil;
    private javax.swing.JPanel panelMisReservas;
    private javax.swing.JScrollPane scrollPaneReservas;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField titular;
    private javax.swing.JCheckBox vip;
    // End of variables declaration//GEN-END:variables
}
