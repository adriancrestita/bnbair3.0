package poo.javabnb;

import Access.FrameInicio;
import Access.FrameRegistro;
import java.io.*; 
import java.util.*;
 
public class Javabnb {
    
    private Administrador administrador;
    
    public Javabnb() {
        this.administrador = new Administrador("admin@javabnb.com", "admin");
    }
    
    public static void main(String[] args) throws IOException {
        crearTxtUsers();
        crearTxtTarjeta();
        crearTxtInmueble();
        crearTxtAnfitrion();
        
        FrameInicio fi = new FrameInicio();
        fi.setVisible(true);
    }

    public boolean autenticarAdmin(String correo, String clave) {
        return administrador.getCorreoElectronico().equals(correo) && administrador.getClave().equals(clave);
    }
    
    public static void crearTxtUsers(){
        try {
            File myObj = new File("datos_users.txt");        
            if (myObj.createNewFile()) {
              System.out.println("Archivo creado: " + myObj.getName());
            } 
            else {
              System.out.println("El fichero ya existe");
            }
          } 
        catch (IOException e) {
            System.out.println("Ha ocurrido un errror");
            e.printStackTrace();
        }
    }
    public static void crearTxtTarjeta(){
        try {
            File myObj = new File("datos_tarjeta.txt");        
            if (myObj.createNewFile()) {
              System.out.println("Archivo creado: " + myObj.getName());
            } 
            else {
              System.out.println("El fichero ya existe");
            }
          } 
        catch (IOException e) {
            System.out.println("Ha ocurrido un errror");
            e.printStackTrace();
        }
    }
    
    public static void crearTxtInmueble(){
        try {
            File myObj = new File("datos_inmuebles.txt");        
            if (myObj.createNewFile()) {
              System.out.println("Archivo creado: " + myObj.getName());
            } 
            else {
              System.out.println("El fichero ya existe");
            }
          } 
        catch (IOException e) {
            System.out.println("Ha ocurrido un errror");
            e.printStackTrace();
        }
    }
    
    public static void crearTxtAnfitrion(){
        try {
            File myObj = new File("datos_anfitrion.txt");        
            if (myObj.createNewFile()) {
              System.out.println("Archivo creado: " + myObj.getName());
            } 
            else {
              System.out.println("El fichero ya existe");
            }
          } 
        catch (IOException e) {
            System.out.println("Ha ocurrido un errror");
            e.printStackTrace();
        }
    }
}
