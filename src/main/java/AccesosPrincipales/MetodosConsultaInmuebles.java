/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesosPrincipales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author crestas
 */
public class MetodosConsultaInmuebles {
    public MetodosConsultaInmuebles(){
        
    }
    
    public void arrayInmuebles(){
        String nombreArchivo = "imagenes_paths.txt";  // Asegúrate de que el archivo está en el directorio correcto
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            inmuebles = new ArrayList<>();  // Inicializa la lista de inmuebles
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");  // Divide la línea en partes separadas por comas
                if (partes.length > 0) {
                    inmuebles.add(partes[0].trim());  // Añade el primer elemento de la línea a la lista de inmuebles
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
