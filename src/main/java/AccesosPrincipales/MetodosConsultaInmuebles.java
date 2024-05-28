/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesosPrincipales;

import ManejoDatos.GestorInmuebles;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


/**
 *
 * @author crestas
 */
public class MetodosConsultaInmuebles {
    private GestorInmuebles gestorInmuebles;
    public MetodosConsultaInmuebles(){
        
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
    
    
    
}
