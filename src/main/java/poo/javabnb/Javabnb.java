package poo.javabnb;

import java.io.*; 
import java.util.*;
 
public class Javabnb {
    
    private Administrador administrador;
    
    public Javabnb() {
        this.administrador = new Administrador("admin@javabnb.com", "admin");
    }
    
    public static void main(String[] args) throws IOException {
        crearTxt();
    }

    public boolean autenticarAdmin(String correo, String clave) {
        return administrador.getCorreoElectronico().equals(correo) && administrador.getClave().equals(clave);
    }
    
    public static void crearTxt(){
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
    public static String[] elementosPorDato(String archivo, String correo) throws IOException{
        BufferedReader reader = null;
            String[] elementos = null;

            try {
                reader = new BufferedReader(new FileReader(archivo));
                String lineaActual;

                while ((lineaActual = reader.readLine()) != null) {
                    elementos = lineaActual.split(","); // Dividir la línea por comas
                    if (elementos.length > 0 && elementos[2].equals(correo)) {
                        return elementos; // Retorna los elementos si el primer dato coincide
                    }
                }
            } 
            finally {
                if (reader != null) {
                    reader.close();
                }
            }
            return null; // Retorna null si no se encuentra ninguna línea que coincida
    }
    public static void busquedaDatosCliente(String correo){
        try {
            String archivo = "datos_users.txt";
            String[] elementos = elementosPorDato(archivo, correo);

            if (elementos != null) {
                for (String elemento : elementos) {
                    System.out.println(elemento);
                }
            } else {
                System.out.println("No se encontró ningun cliente con ese nombre.");
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean existeCliente(String nombreBuscado) throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        String[] elementos = null;
        try {
            reader = new BufferedReader(new FileReader("datos_users.txt"));
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                elementos = lineaActual.split(","); // Dividir la línea por comas
                if (elementos.length > 0 && elementos[2].equals(nombreBuscado)) {
                    return true; // Retorna true si coincide
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return false; // Retorna false si no se encuentra cliente que coincida
    }
}
