package poo.javabnb;

import AccesosPrincipales.Inicio;
import AccesosPrincipales.Registro;
import ManejoDatos.ArchivoUtil;
import ManejoDatos.GestorAnfitrion;
import ManejoDatos.GestorClientes;
import ManejoDatos.GestorInmuebles;
import ManejoDatos.GestorTarjetas;
import ManejoDatos.GestorValoraciones;
import java.io.*; 
import java.util.*;
 
public class Javabnb {
    
    private Administrador administrador;
    
    public Javabnb() {
        this.administrador = new Administrador("admin@javabnb.com", "admin");
    }
    
    public static void main(String[] args) throws IOException {      
        //Creamos los .dat si todavia no existen
        
        ArchivoUtil.inicializarArchivos();
        
        
        // Inicializamos los gestores
        GestorClientes gestorClientes = new GestorClientes();
        GestorTarjetas gestorTarjetas = new GestorTarjetas();
        GestorInmuebles gestorInmuebles = new GestorInmuebles();
        GestorAnfitrion gestorAnfitrion = new GestorAnfitrion();
        GestorValoraciones gestorValoraciones = new GestorValoraciones();

        // Cargar los datos desde los archivos .dat
        System.out.println("Cargando datos de clientes...");
        //gestorClientes.obtenerValoraciones().forEach(cliente -> System.out.println(cliente.getCorreoElectronico()));

        System.out.println("Cargando datos de tarjetas...");
        //gestorTarjetas.obtenerTarjetas().forEach(tarjeta -> System.out.println(tarjeta.getNumeroTarjeta()));

        System.out.println("Cargando datos de inmuebles...");
        //gestorInmuebles.obtenerInmuebles().forEach(inmueble -> System.out.println(inmueble.getTitulo()));

        System.out.println("Cargando datos de anfitriones...");
        //gestorAnfitrion.obtenerAnfitriones().forEach(anfitrion -> System.out.println(anfitrion.getCorreoElectronico()));

        System.out.println("Cargando datos de valoraciones...");
        
        Inicio fi = new Inicio();
        fi.setVisible(true);
    }

    public boolean autenticarAdmin(String correo, String clave) {
        return administrador.getCorreoElectronico().equals(correo) && administrador.getClave().equals(clave);
    }
    
   
}
