    
package AccesosPrincipales;

import ManejoDatos.GestorAnfitrion;
import ManejoDatos.GestorClientes;
import ManejoDatos.GestorInmuebles;
import ManejoDatos.GestorReservas;
import ManejoDatos.GestorTarjetas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import ManejoDatos.GestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import poo.javabnb.Anfitrion;
import poo.javabnb.ClienteParticular;
import poo.javabnb.Inmueble;
import poo.javabnb.Reservas;



/**
 *
 * @author Usuario
 */
public class MenuAdmin extends javax.swing.JFrame {

    
    private DefaultTableModel tableModel1;
    private DefaultTableModel tableModel2;
    private DefaultTableModel tableModel3;
    
    //DEclaramos y creamos los 
    private JPopupMenu menuContextual;
    private JPopupMenu popupMenu1;
    private JMenuItem deleteMenuItem1;
    private JPopupMenu popupMenu2;
    private JMenuItem deleteMenuItem2;
    private JPopupMenu popupMenu3;
    private JMenuItem deleteMenuItem3;
    
    //Declaramos las listas a utilizar para las tablas
    private List<ClienteParticular> clien;
    private List<Anfitrion> anf;
    private List<Reservas> reserv;
    private List<Inmueble> inm;

    //Declaramos los gestores para acceder a ellos
    private GestorInmuebles gestorInmuebles;
    private GestorClientes gestorClientes;
    private GestorAnfitrion gestorAnfitrion;
    private GestorClientes gClientes;
    private GestorAnfitrion gAnfitriones;
    private GestorTarjetas gestorTarjetas;
    private GestorReservas gestorReservas;

    
    public MenuAdmin() {
        super();
        initComponents();
        setTitle("JavaBnB");
        setResizable(false);

        /*--------------------------------------------------------------------------------*/        
        //TABLA USUARIOS
        String[] columnNames = {"Tipo de Usuario", "Nombre", "Correo", "Telefono", "DNI", "Numero Tarjeta", "Estatus", "Fecha Registro"};
        
        //Fija un modo no editable del contenido de las celdas de la tabla
        tableModel1 = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace todas las celdas no editables
            }     
        };
        
        gestorClientes = new GestorClientes();
        gestorAnfitrion = new GestorAnfitrion();
        gestorTarjetas = new GestorTarjetas();
        gestorReservas = new GestorReservas();
        tablaUsuarios.setModel(tableModel1);
        tablaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        //Cargamos los clientes y los usuarios
        vaciarTabla(tableModel1);
        clien = gestorClientes.obtenerClientes();
        anf = gestorAnfitrion.obtenerAnfitriones();
        reserv = gestorReservas.obtenerReservas();
        inm = GestorInmuebles.obtenerInmuebles();
        
        cargarListaClientes(clien);
        cargarListaAnfitriones(anf);
        
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
                gClientes = new GestorClientes();
                gAnfitriones = new GestorAnfitrion();
                int selectedRow = tablaUsuarios.getSelectedRow();
                String tipoClienteSeleccionado = (String) tablaUsuarios.getValueAt(selectedRow, 0);
                String correoClienteSeleccionado = (String) tablaUsuarios.getValueAt(selectedRow, 2);
                
                //Si es un cliente 
                if("Cliente".equals(tipoClienteSeleccionado)){
                    clien = GestorClientes.eliminarCliente(correoClienteSeleccionado);
                    GestorTarjetas.eliminarTarjeta(correoClienteSeleccionado);
                    vaciarTabla(tableModel1);
                    cargarListaClientes(clien);
                    cargarListaAnfitriones(anf);
                }
                
                //Si es un anfitrion elimina anfitrion
                if("Anfitrion".equals(tipoClienteSeleccionado)){
                    anf =GestorAnfitrion.eliminarAnfitrion(correoClienteSeleccionado);
                    GestorTarjetas.eliminarTarjeta(correoClienteSeleccionado);
                    vaciarTabla(tableModel1);
                    cargarListaClientes(clien);
                    cargarListaAnfitriones(anf);
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
        
        //Setea el model de la tabla y hacemos que no se pueda hacer resize
        tablaInmuebles.setModel(tableModel2);
        tablaInmuebles.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        //Carga el .dat a la tabla por primera vez
        vaciarTabla(tableModel2);
        cargarListaInmuebles(inm);
   
        
        // Hacer las barras de scroll invisibles pero funcionales
        jScrollPane2.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
        jScrollPane2.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
       
        // Configurar el Popup Menu
        popupMenu2 = new JPopupMenu();
        deleteMenuItem2 = new JMenuItem("Eliminar Inmueble");
        popupMenu2.add(deleteMenuItem2);
        
        // Asignar el Popup Menu a la tabla
        tablaInmuebles.setComponentPopupMenu(popupMenu2);
        
        //Asignamos el metodo de eliminar cuando se pulse el boton
        deleteMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaInmuebles.getSelectedRow();
                String correoInmuebleSeleccionado = (String) tablaInmuebles.getValueAt(selectedRow, 2);
                String tituloInmuebleSeleccionado = (String) tablaInmuebles.getValueAt(selectedRow, 1);
                
                //Vaciamos inmuebles y reservas
                vaciarTabla(tableModel2);
                vaciarTabla(tableModel3);
                
                inm = gestorInmuebles.eliminarInmueble(correoInmuebleSeleccionado, tituloInmuebleSeleccionado);
                reserv = gestorReservas.eliminarReservasInmueble(tituloInmuebleSeleccionado, correoInmuebleSeleccionado);
                
                cargarListaInmuebles(inm);          
                cargarListaReservas(reserv);
                
            }
        });
        
        // Ajuste de tamaño de las columnas para que se vea todo al complet
        TableColumnModel columnModel2 = tablaInmuebles.getColumnModel();
        for (int column = 0; column < tablaInmuebles.getColumnCount(); column++) {
            int width = 15; // Mínimo ancho
            
            // Obtener el ancho del encabezado
            TableColumn tableColumn = columnModel2.getColumn(column);
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
            columnModel2.getColumn(column).setPreferredWidth(width);
        }
        
        /*--------------------------------------------------------------------------------*/        
        // TABLA RESERVAS
        gestorReservas = new GestorReservas();
        String[] columnNames3 = {"Correo Cliente", "Numero de Tarjeta Cliente", "Titulo Inmueble", "Correo Anfitrion", "Precio Noche", "Precio Total"};
        
        //Fija un modo no editable del contenido de las celdas de la tabla 
        tableModel3 = new DefaultTableModel(columnNames3,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace todas las celdas no editables
            }     
        };
        
        //Setea el model de la tabla y hacemos que no se pueda hacer resize
        tablaReservas.setModel(tableModel3);
        tablaReservas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        //Carga el .dat a la tabla por primera vez
        vaciarTabla(tableModel3);
        cargarListaReservas(gestorReservas.obtenerReservas());
   
        // Hacer las barras de scroll invisibles pero funcionales
        jScrollPane3.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
        jScrollPane3.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
       
        // Configurar el Popup Menu
        popupMenu3 = new JPopupMenu();
        deleteMenuItem3 = new JMenuItem("Eliminar Resrverva");
        popupMenu3.add(deleteMenuItem3);
        
        // Asignar el Popup Menu a la tabla
        tablaReservas.setComponentPopupMenu(popupMenu3);
        
        //Asignamos el metodo de eliminar cuando se pulse el boton
        deleteMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaReservas.getSelectedRow();
                String correoAnfitrion = (String) tablaReservas.getValueAt(selectedRow, 3);
                String correoCliente = (String) tablaReservas.getValueAt(selectedRow, 0);
                String tituloInmueble = (String) tablaReservas.getValueAt(selectedRow, 2);
                
                //Elimina la reserva de la lista y recargue los datos de la tabla
                vaciarTabla(tableModel3);
                reserv = gestorReservas.eliminarReserva(correoCliente, correoAnfitrion, tituloInmueble);
                cargarListaReservas(reserv);          
            }
        });
        
        // Ajuste de tamaño de las columnas para que se vea todo al completo
        TableColumnModel columnModel3 = tablaReservas.getColumnModel();
        for (int column = 0; column < tablaReservas.getColumnCount(); column++) {
            int width = 15; // Mínimo ancho
            
            // Obtener el ancho del encabezado
            TableColumn tableColumn = columnModel3.getColumn(column);
            TableCellRenderer headerRenderer = tableColumn.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = tablaReservas.getTableHeader().getDefaultRenderer();
            }
            Component headerComp = headerRenderer.getTableCellRendererComponent(
                tablaReservas, tableColumn.getHeaderValue(), false, false, 0, 0);
            width = headerComp.getPreferredSize().width;

            // Obtener el ancho máximo de la columna (datos)
            for (int row = 0; row < tablaReservas.getRowCount(); row++) {
                TableCellRenderer renderer = tablaReservas.getCellRenderer(row, column);
                Component comp = tablaReservas.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel3.getColumn(column).setPreferredWidth(width);
        }
        
        /*--------------------------------------------------------------------------------*/   
       
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInmuebles = new javax.swing.JTable();
        consultaReservas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        consultaUsuarios = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
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
        jScrollPane2.setViewportView(tablaInmuebles);

        consultaInmuebles.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 570, 390));

        jTabbedPane1.addTab("tab1", consultaInmuebles);

        consultaReservas.setBackground(new java.awt.Color(255, 255, 255));
        consultaReservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Consulta de Reservas");
        consultaReservas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 39, -1, -1));

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
        jScrollPane3.setViewportView(tablaReservas);

        consultaReservas.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 570, 390));

        jTabbedPane1.addTab("tab2", consultaReservas);

        consultaUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        consultaUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Consulta de Usuarios");
        consultaUsuarios.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 39, -1, -1));

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
    /**
     * Vacia el contenido de la tabla introducida en el método
     * @param modeloTabla 
     */
    private static void vaciarTabla(DefaultTableModel modeloTabla) {
        while(modeloTabla.getRowCount() > 0){
            modeloTabla.removeRow(0);
        }
    }
    
    /**
     * Método que carga los cilentes en una lista
     * @param clientes 
     */
    private void cargarListaClientes(List<ClienteParticular> clientes){
        
        //Cargamos los clientes en una lista
        for (ClienteParticular cliente : clientes) {
            String numeroTarjeta = gestorTarjetas.obtenerNumeroTarjeta(cliente.getCorreoElectronico());
            Object[] fila = {"Cliente", cliente.getNombre(), cliente.getCorreoElectronico(),
                cliente.getTelefono(), cliente.getDni(), numeroTarjeta, cliente.cmpVIP() ? "VIP" : "No VIP", ""};
            tableModel1.addRow(fila);
            
        }
    }
    
    /**
     * Método que carga los anfitriones en una lista
     * @param anfitriones 
     */
    private void cargarListaAnfitriones(List<Anfitrion> anfitriones){
        for (Anfitrion anfitrion : anfitriones) {
            String numeroTarjeta = gestorTarjetas.obtenerNumeroTarjeta(anfitrion.getCorreoElectronico());
            Object[] fila = {"Anfitrion", anfitrion.getNombre(), anfitrion.getCorreoElectronico(),
                anfitrion.getTelefono(), anfitrion.getDni(), numeroTarjeta, anfitrion.cmpSuperAnfitrion(), anfitrion.getFechaRegistro()};
            tableModel1.addRow(fila);
        }
    }
    
    /**
     * Método que carga los inmuebles en la lista
     * @param inmuebles 
     */
    private void cargarListaInmuebles(List<Inmueble> inmuebles){
        vaciarTabla(tableModel2);
        for (Inmueble inmueble : inmuebles) {
            Object [] fila = {inmueble.getCorreoAnfitrion(), inmueble.getTitulo(), inmueble.getDireccion(), inmueble.getTipoPropiedad(), inmueble.getMaxHuespedes(), inmueble.getPrecioNoche(), inmueble.getServicios()};
            tableModel2.addRow(fila);
        }            
    }
    
    /**
     *  Método que carga las reservas en la lista
     * @param reservas 
     */
    private void cargarListaReservas(List<Reservas> reservas){
        vaciarTabla(tableModel3);
        for (Reservas reserva : reservas) {
            Object [] fila = {reserva.getCorreoCliente(), gestorTarjetas.obtenerNumeroTarjeta(reserva.getCorreoCliente()), reserva.getCorreoAnfitrion(), 
                reserva.getTituloInmueble(), reserva.inmueble.getPrecioNoche(),  reserva.getPrecioTotal()};
            tableModel3.addRow(fila);
        }            
    }

    private void buttonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUserActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        //DialogCrearInmuebles dci = new DialogCrearInmuebles();

    }//GEN-LAST:event_buttonUserActionPerformed

    private void buttonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarSesionActionPerformed
        // TODO add your handling code here:
        Inicio inicio = new Inicio();
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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuAdmin dialog = new MenuAdmin();
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaInmuebles;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
