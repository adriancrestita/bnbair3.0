package poo.javabnb;

import AccesosPrincipales.FrameInicio;
import AccesosPrincipales.FrameRegistro;
import ManejoDatos.ArchivoUtil;
import ManejoDatos.GestorClientes;
import ManejoDatos.GestorTarjetas;
import java.io.*; 
import java.util.*;
 
public class Javabnb {
    
    private Administrador administrador;
    
    public Javabnb() {
        this.administrador = new Administrador("admin@javabnb.com", "admin");
    }
    
    public static void main(String[] args) throws IOException {      
        ArchivoUtil.inicializarArchivos();
        
        GestorClientes gestorClientes = new GestorClientes();
        GestorTarjetas gestorTarjetas = new GestorTarjetas();
       

        try {
            ArrayList<ClienteParticular> clientes = gestorClientes.cargarClientes();
            ArrayList<TarjetaCredito> tarjetas = gestorTarjetas.cargarTarjetas();
            System.out.println("Clientes y tarjetas cargados exitosamente.");
            // Aquí puedes seguir con la inicialización de tu aplicación usando las listas cargadas
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos.");
            e.printStackTrace();
        }

        FrameInicio fi = new FrameInicio();
        fi.setVisible(true);
    }

    public boolean autenticarAdmin(String correo, String clave) {
        return administrador.getCorreoElectronico().equals(correo) && administrador.getClave().equals(clave);
    }
    
   
}
