    
package AccesosPrincipales;

import ManejoDatos.GestorAnfitrion;
import ManejoDatos.GestorClientes;
import ManejoDatos.GestorInmuebles;
import ManejoDatos.GestorTarjetas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import ManejoDatos.GestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import poo.javabnb.Inmueble;



/**
 *
 * @author Usuario
 */
public class DialogMenuAdmin extends javax.swing.JDialog {

    private GestorUsuarios gestorUsuarios;
    private GestorInmuebles gestorInmuebles;
    private DefaultTableModel tableModel1;
    private DefaultTableModel tableModel2;
    private DefaultTableModel tableModel3;
    private JPopupMenu menuContextual;
    private List<Inmueble> listaInmuebles;
    private JPopupMenu popupMenu1;
    private JMenuItem deleteMenuItem1;
    private JPopupMenu popupMenu2;
    private JMenuItem deleteMenuItem2;

    private String[] nombresVariables = {
        "Buscador",
        "Buscador1",
        "Buscador2"
    };

    private String[] mensajesOriginales = {
        " 🔍 Buscador de Inmuebles",
        " 🔍 Buscador de Reservas",
        " 🔍 Buscador de Usuarios",
    };
    
    private HashMap<String, JTextField> camposDeTexto = new HashMap<>();


    
    public DialogMenuAdmin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("JavaBnB");
        
        
        listaInmuebles = gestorInmuebles.obtenerInmuebles();

        
        // Agregamos los campos de texto al HashMap
        camposDeTexto.put("Buscador", Buscador);
        camposDeTexto.put("Buscador1", Buscador1);
        camposDeTexto.put("Buscador2", Buscador2);     
        
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
                    JTextField previousFocusOwner = campo;

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (campo.getText().isEmpty()) {
                        campo.setText(mensajeOriginal);
                    }
                    Component previousFocusOwner = e.getOppositeComponent();

                }
                
                
            });
        }

        /*--------------------------------------------------------------------------------*/        
        //TABLA USUARIOS
        gestorUsuarios = new GestorUsuarios();
        String[] columnNames = {"Tipo de Usuario", "Nombre", "Correo", "Telefono", "DNI", "Numero Tarjeta", "Estatus", "Fecha Registro"};
        
        //Fija un modo no editable del contenido de las celdas de la tabla
        tableModel1 = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace todas las celdas no editables
            }     
        };
        
        tablaUsuarios.setModel(tableModel1);
        tablaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        //Carga los .dat a la tabla        
        List<Object[]> usuarios = GestorUsuarios.obtenerTodosLosUsuarios();
        for (Object[] usuario : usuarios) {
            tableModel1.addRow(usuario);
        }
        
        // Hacer las barras de scroll invisibles pero funcionales
        jScrollPane1.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        
        // Configurar el Popup Menu
        popupMenu1 = new JPopupMenu();
        deleteMenuItem1 = new JMenuItem("Eliminar usuario");
        popupMenu1.add(deleteMenuItem1);
        
        // Asignar el Popup Menu a la tabla
        tablaUsuarios.setComponentPopupMenu(popupMenu1);
        
        //Asignamos el metodo de eliminar cuando se pulse el boton
        deleteMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaUsuarios.getSelectedRow();
                String tipoClienteSeleccionado = (String) tablaUsuarios.getValueAt(selectedRow, 0);
                String correoClienteSeleccionado = (String) tablaUsuarios.getValueAt(selectedRow, 2);
                if("Cliente".equals(tipoClienteSeleccionado)){
                    GestorClientes.eliminarCliente(correoClienteSeleccionado);
                    GestorTarjetas.eliminarTarjeta(correoClienteSeleccionado);
                }
                if("Anfitrion".equals(tipoClienteSeleccionado)){
                    GestorAnfitrion.eliminarAnfitrion(correoClienteSeleccionado);
                    GestorTarjetas.eliminarTarjeta(correoClienteSeleccionado);               
                }
                vaciarTabla(tableModel1);
//                try {
//                    GestorAnfitrion.deserializarUsuarios();
//                } catch (IOException ex) {
//                    Logger.getLogger(DialogMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(DialogMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                try {
//                    GestorClientes.deserializarUsuarios();
//                } catch (IOException ex) {
//                    Logger.getLogger(DialogMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(DialogMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                try {
//                    GestorTarjetas.deserializarTarjetas();
//                } catch (IOException ex) {
//                    Logger.getLogger(DialogMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(DialogMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                List<Object[]> usuarios = GestorUsuarios.obtenerTodosLosUsuarios();
                    for (Object[] usuario : usuarios) {
                        tableModel1.addRow(usuario);
                        
                    }
            }
        });
        
        
        
        // Ajuste de tamaño de las columnas
        TableColumnModel columnModel1 = tablaUsuarios.getColumnModel();
        for (int column = 0; column < tablaUsuarios.getColumnCount(); column++) {
            int width = 15; // Mínimo ancho
            // Obtener el ancho del encabezado
            TableColumn tableColumn = columnModel1.getColumn(column);
            TableCellRenderer headerRenderer = tableColumn.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = tablaUsuarios.getTableHeader().getDefaultRenderer();
            }
            Component headerComp = headerRenderer.getTableCellRendererComponent(
                tablaUsuarios, tableColumn.getHeaderValue(), false, false, 0, 0);
            width = headerComp.getPreferredSize().width;

            // Obtener el ancho máximo de la columna (datos)
            for (int row = 0; row < tablaUsuarios.getRowCount(); row++) {
                TableCellRenderer renderer = tablaUsuarios.getCellRenderer(row, column);
                Component comp = tablaUsuarios.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel1.getColumn(column).setPreferredWidth(width);
        }
        /*--------------------------------------------------------------------------------*/
        // TABLA INMUEBLES
        gestorInmuebles = new GestorInmuebles();
        String[] columnNames2 = {"Correo Anfitrion", "Titulo", "Dirección", "Tipo Propiedad", "Máximo Huéspedes", "Precio Noche", "Servicios"};
        
        //Fija un modo no editable del contenido de las celdas de la tabla 
        tableModel2 = new DefaultTableModel(columnNames2,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace todas las celdas no editables
            }     
        };
        
        tablaInmuebles.setModel(tableModel2);
        tablaInmuebles.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        //Carga el .dat a la tabla
        List<Object[]> inmuebles = GestorInmuebles.obtenerTodosLosInmuebles();
        for (Object[] inmueble : inmuebles) {
            tableModel2.addRow(inmueble);
        }      
        
        // Hacer las barras de scroll invisibles pero funcionales
        jScrollPane3.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
        jScrollPane3.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
       
        // Configurar el Popup Menu
        popupMenu2 = new JPopupMenu();
        deleteMenuItem2 = new JMenuItem("Eliminar Inmueble");
        popupMenu2.add(deleteMenuItem2);
        
        // Asignar el Popup Menu a la tabla
        tablaInmuebles.setComponentPopupMenu(popupMenu2);
        
        // Ajuste de tamaño de las columnas
        TableColumnModel columnModel3 = tablaInmuebles.getColumnModel();
        for (int column = 0; column < tablaInmuebles.getColumnCount(); column++) {
            int width = 15; // Mínimo ancho
            // Obtener el ancho del encabezado
            TableColumn tableColumn = columnModel3.getColumn(column);
            TableCellRenderer headerRenderer = tableColumn.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = tablaInmuebles.getTableHeader().getDefaultRenderer();
            }
            Component headerComp = headerRenderer.getTableCellRendererComponent(
                tablaInmuebles, tableColumn.getHeaderValue(), false, false, 0, 0);
            width = headerComp.getPreferredSize().width;

            // Obtener el ancho máximo de la columna (datos)
            for (int row = 0; row < tablaInmuebles.getRowCount(); row++) {
                TableCellRenderer renderer = tablaInmuebles.getCellRenderer(row, column);
                Component comp = tablaInmuebles.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel3.getColumn(column).setPreferredWidth(width);
        }
        

        
        /*--------------------------------------------------------------------------------*/        
        // TABLA RESERVAS
        /*gestorInmuebles = new GestorInmuebles();
        
        tableModel2 = new DefaultTableModel(new Object[][]{}, new String[]{
            "Correo Anfitrion", "Titulo", "Dirección", "Tipo Propiedad", "Máximo Huéspedes", "Precio Noche", 
            "Servicios"
        });
        
        tablaInmuebles.setModel(tableModel2);
                
        List<Object[]> inmuebles = GestorInmuebles.obtenerTodosLosInmuebles();
        for (Object[] inmueble : inmuebles) {
            tableModel2.addRow(inmueble);
        }
        */
        
        /*--------------------------------------------------------------------------------*/   
        //CODIGO BUSCADOR INMUEBLES
        Buscador2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable(Buscador.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable(Buscador.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable(Buscador.getText());
            }
        });
    
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
        consultaInmuebles = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Buscador = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaInmuebles = new javax.swing.JTable();
        consultaReservas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Buscador1 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        consultaUsuarios = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Buscador2 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();

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

        consultaInmuebles.setBackground(new java.awt.Color(255, 255, 255));
        consultaInmuebles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Consulta de Inmuebles");
        consultaInmuebles.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 39, -1, -1));

        Buscador.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        Buscador.setText(" 🔍 Buscador de Inmuebles");
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
        consultaInmuebles.add(Buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 550, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        consultaInmuebles.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 550, 20));

        tablaInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Correo Anfitrion", "Titulo", "Dirección", "Tipo", "Nº Camas", "Nº Habitaciones", "Nº Baños", "Máx Huéspedes", "Precio Noche", "Servicios"
            }
        ));
        jScrollPane3.setViewportView(tablaInmuebles);

        consultaInmuebles.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 570, 390));

        jTabbedPane1.addTab("tab1", consultaInmuebles);

        consultaReservas.setBackground(new java.awt.Color(255, 255, 255));
        consultaReservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Consulta de Reservas");
        consultaReservas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 39, -1, -1));

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
        consultaReservas.add(Buscador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 550, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        consultaReservas.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 550, 20));

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Anfitrion", "Nombre Cliente", "Correo Cliente", "Teléfono Cliente", "DNI Cliente", "Estatus Cliente"
            }
        ));
        jScrollPane2.setViewportView(tablaReservas);

        consultaReservas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 570, 390));

        jTabbedPane1.addTab("tab2", consultaReservas);

        consultaUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        consultaUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Consulta de Usuarios");
        consultaUsuarios.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 39, -1, -1));

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
        consultaUsuarios.add(Buscador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 550, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        consultaUsuarios.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 550, 20));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tipo Usuario", "Nombre", "Correo Electrónico", "Teléfono", "DNI", "Numero Tarjeta", "Estatus", "Fecha Registro"
            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        consultaUsuarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 570, 390));

        jTabbedPane1.addTab("tab3", consultaUsuarios);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, -50, 590, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private static void vaciarTabla(DefaultTableModel modeloTabla) {
        while(modeloTabla.getRowCount() > 0){
            modeloTabla.removeRow(0);
        }
    }
    private void filterTable(String query) {
        List<Object[]> inmuebles = gestorInmuebles.obtenerTodosLosInmuebles();
        List<Object[]> filteredInmuebles = inmuebles.stream()
                .filter(inmueble -> {
                    for (Object field : inmueble) {
                        if (field.toString().toLowerCase().contains(query.toLowerCase())) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());

        tableModel2.setRowCount(0); // Limpia la tabla
        for (Object[] inmueble : filteredInmuebles) {
            tableModel2.addRow(inmueble);
        }
    }
    /*
    private void eliminarClienteSeleccionado() {
        int selectedRow = tablaUsuarios.getSelectedRow();
        if (selectedRow != -1) {
            String tipoUsuario = (String) tablaUsuarios.getValueAt(selectedRow, 0);
            String correo = (String) tablaUsuarios.getValueAt(selectedRow, 2);
            if(("Cliente").equals(tipoUsuario)){
                GestorClientes.eliminarCliente(correo);
                ((DefaultTableModel) tablaUsuarios.getModel()).removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito.");
            }
            if(("Anfitrión").equals(tipoUsuario)){
                GestorAnfitrion.eliminarAnfitrion(correo);
                ((DefaultTableModel) tablaUsuarios.getModel()).removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente para eliminar.");
        }
    }
    */

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
            Buscador.setText(" 🔍 Buscador de Reservas");
        }
    }//GEN-LAST:event_BuscadorFocusLost

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
        if (Buscador.getText().equals(" 🔍 Buscador de Usuarios")){
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
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JPanel consultaInmuebles;
    private javax.swing.JPanel consultaReservas;
    private javax.swing.JPanel consultaUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaInmuebles;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
