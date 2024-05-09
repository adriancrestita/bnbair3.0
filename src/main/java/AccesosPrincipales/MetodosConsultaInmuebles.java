/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesosPrincipales;

import static AccesosPrincipales.FrameConsultaInmuebles.currentPage;
import static AccesosPrincipales.FrameConsultaInmuebles.titulosInmuebles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author crestas
 */
public class MetodosConsultaInmuebles {
    public MetodosConsultaInmuebles(){
        
    }
    
    public static void arrayInmuebles(){
        String nombreArchivo = "image_paths.txt";  // Asegúrate de que el archivo está en el directorio correcto
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            FrameConsultaInmuebles.titulosInmuebles = new ArrayList<>();  // Inicializa la lista de inmuebles
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");  // Divide la línea en partes separadas por comas
                if (partes.length > 0) {
                    FrameConsultaInmuebles.titulosInmuebles.add(partes[0].trim());  // Añade el primer elemento de la línea a la lista de inmuebles
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Método para cargar la imagen en el jlabel correspondiente
    public static ImageIcon obtenerImagen(String nombreDestino) {
        String rutaImagen = FrameConsultaInmuebles.IMAGENES_DESTINO_PATH.trim() + nombreDestino.replaceAll(" ", "") + ".png";
        File imagenFile = new File(rutaImagen);
        if (imagenFile.exists()) {
            return new ImageIcon(rutaImagen);
        } 
        else {
            return null;
        }
    }
    
    
}
