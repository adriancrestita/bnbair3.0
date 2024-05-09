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
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
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
    
    public static void saveImages(File[] files) {
        String destinationDirectory = "src/main/java/ImagenesDestino";  // Ruta del directorio de destino
        File dir = new File(destinationDirectory);
        if (!dir.exists()) {
            dir.mkdirs();  // Crear el directorio si no existe
        }

        for (File file : files) {
            File destFile = new File(dir, file.getName());
            try {
                Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Imagen copiada: " + destFile.getPath());
            } catch (IOException e) {
                System.out.println("Error al copiar la imagen: " + file.getName());
                e.printStackTrace();
            }
        }
    }
    public String nombreTitulo(ArrayList<String> list, int i){
            String elemento;

        if (!list.isEmpty()) {
            // Imprimir el primer elemento de la lista (posición 0)
            elemento = list.get(i);
        } else {
            System.out.println("La lista está vacía.");
        }
        return elemento;
    }
}
