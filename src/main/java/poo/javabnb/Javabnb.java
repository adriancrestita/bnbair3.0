package poo.javabnb;

import AccesosPrincipales.FrameInicio;
import AccesosPrincipales.FrameRegistro;
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
        crearTxtInmuebles();
        crearTxtAnfitrion();
        crearTxtImagenesInmueble();
        
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
                try {
                    String header ="NOMBRE,DNI,CORREO,CONTRASEÑA,TELEFONO,VIP\n";
                    FileWriter myWriter = new FileWriter("datos_users.txt", true); //el true activa el append
                    myWriter.write(header/*.getBytes(), StandardOpenOption.APPEND*/);
                    myWriter.close();
                } 
                catch (IOException e) {
                    System.out.println("Ha ocurrido un error");
                    e.printStackTrace();
                }
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
    
    public static void crearTxtInmuebles(){
        try {
            File myObj = new File("datos_inmuebles.txt");        
            if (myObj.createNewFile()) {
              System.out.println("Archivo creado: " + myObj.getName());
                try {
                    String header ="CORREO ANFITRION,TITULO,CALLE,NUMERO,C.P.,CIUDAD,MAXIMO HUESPEDES,HABITACIONES,CAMAS,BAÑOS,TIPO PROPIEDAD,PRECIO NOCHE,SERVICIOS,CALIFICACIÓN\n";
                    FileWriter myWriter = new FileWriter("datos_inmuebles.txt", true); //el true activa el append
                    myWriter.write(header/*.getBytes(), StandardOpenOption.APPEND*/);
                    myWriter.close();
                } 
                catch (IOException e) {
                    System.out.println("Ha ocurrido un error");
                    e.printStackTrace();
                }
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
    
    public static void crearTxtImagenesInmueble(){
        try {
            File myObj = new File("imagenes_inmuebles.txt");        
            if (myObj.createNewFile()) {
              System.out.println("Archivo creado: " + myObj.getName());
                try {
                    FileWriter myWriter = new FileWriter("imagenes_inmuebles.txt", true); //el true activa el append
                    myWriter.close();
                } 
                catch (IOException e) {
                    System.out.println("Ha ocurrido un error");
                    e.printStackTrace();
                }
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
                try {
                    String header ="CORREO USUARIO,NOMBRE TITULAR,NUMERO TARJETA,FECHA CADUCIDAD\n";
                    FileWriter myWriter = new FileWriter("datos_tarjeta.txt", true); //el true activa el append
                    myWriter.write(header/*.getBytes(), StandardOpenOption.APPEND*/);
                    myWriter.close();
                } 
                catch (IOException e) {
                    System.out.println("Ha ocurrido un error");
                    e.printStackTrace();
                }
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
                try {
                    String header ="NOMBRE,DNI,CORREO,CONTRASEÑA,TELEFONO,FECHA REGISTRO,SUPER ANFITRION\n";
                    FileWriter myWriter = new FileWriter("datos_anfitrion.txt", true); //el true activa el append
                    myWriter.write(header/*.getBytes(), StandardOpenOption.APPEND*/);
                    myWriter.close();
                } 
                catch (IOException e) {
                    System.out.println("Ha ocurrido un error");
                    e.printStackTrace();
                }
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
