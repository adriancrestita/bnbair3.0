/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDatos;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author crestas
 */
public class BorrarDatos {
    
    BorrarDatos(){
        
    }
    
    public boolean deleteFile(String filePath) {
        // Crear un objeto File con la ruta especificada
        File file = new File(filePath);

        // Intentar borrar el archivo
        boolean isDeleted = file.delete();

        // Retornar el resultado de la operación de borrado
        return isDeleted;
    }
    
    public static void borrarUsers(){
        BorrarDatos fileManager = new BorrarDatos();
        
        // Ruta del archivo a borrar
        String filePath = "datos_users.txt";

        // Llamar al método deleteFile y capturar el resultado
        boolean result = fileManager.deleteFile(filePath);

        // Imprimir resultado de la operación
        if (result) {
            JOptionPane.showMessageDialog(null, "Los datos fueron borrados exitosamente");
            
            CrearDatos.crearTxtUsers();
        } else {
            System.out.println("El archivo no pudo ser borrado o no existe.");
        }
    }
    
    public static void borrarAnfitriones(){
        BorrarDatos fileManager = new BorrarDatos();
        
        // Ruta del archivo a borrar
        String filePath = "datos_anfitrion.txt";

        // Llamar al método deleteFile y capturar el resultado
        boolean result = fileManager.deleteFile(filePath);

        // Imprimir resultado de la operación
        if (result) {
            JOptionPane.showMessageDialog(null, "Los datos fueron borrados exitosamente");
            
            CrearDatos.crearTxtAnfitrion();
        } else {
            System.out.println("El archivo no pudo ser borrado o no existe.");
        }
    }
    
    public static void borrarInmuebles(){
        BorrarDatos fileManager = new BorrarDatos();
        
        // Ruta del archivo a borrar
        String filePath = "datos_inmuebles.txt";

        // Llamar al método deleteFile y capturar el resultado
        boolean result = fileManager.deleteFile(filePath);

        // Imprimir resultado de la operación
        if (result) {
            JOptionPane.showMessageDialog(null, "Los datos fueron borrados exitosamente");
            
            CrearDatos.crearTxtInmuebles();
        } else {
            System.out.println("El archivo no pudo ser borrado o no existe.");
        }
    }
    
    public static void borrarImagenes(){
        BorrarDatos fileManager = new BorrarDatos();
        
        // Ruta del archivo a borrar
        String filePath = "image_paths.txt";

        // Llamar al método deleteFile y capturar el resultado
        boolean result = fileManager.deleteFile(filePath);

        // Imprimir resultado de la operación
        if (result) {
            JOptionPane.showMessageDialog(null, "Los datos fueron borrados exitosamente");
            
            CrearDatos.crearTxtImagenesInmueble();
        } else {
            System.out.println("El archivo no pudo ser borrado o no existe.");
        }
    }
    
    public static void borrarTarjetas(){
        BorrarDatos fileManager = new BorrarDatos();
        
        // Ruta del archivo a borrar
        String filePath = "datos_tarjeta.txt";

        // Llamar al método deleteFile y capturar el resultado
        boolean result = fileManager.deleteFile(filePath);

        // Imprimir resultado de la operación
        if (result) {
            JOptionPane.showMessageDialog(null, "Los datos fueron borrados exitosamente");
            
            CrearDatos.crearTxtTarjeta();
        } else {
            System.out.println("El archivo no pudo ser borrado o no existe.");
        }
    }
    
    public static void borrarDatosCompleto(){
        borrarTarjetas();
        borrarUsers();
        borrarImagenes();
        borrarAnfitriones();
        borrarInmuebles();
    }
    
}
