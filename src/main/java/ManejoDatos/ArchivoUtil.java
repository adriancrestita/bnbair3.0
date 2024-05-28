package ManejoDatos;

import java.io.File;
import java.io.IOException;

public class ArchivoUtil {
    
    /**
     * Método que se encarga de que si un archivo no existe, lo cree
     * 
     * @param nombreArchivo 
     */
    public static void asegurarArchivoExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            try {
                boolean creado = archivo.createNewFile();
                if (creado) {
                    System.out.println("Archivo creado: " + nombreArchivo);
                } else {
                    System.out.println("No se pudo crear el archivo: " + nombreArchivo);
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo " + nombreArchivo);
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo ya existe: " + nombreArchivo);
        }
    }
    
    /**
     * inicializa todos los archivos de la aplicacion
     */
    public static void inicializarArchivos() {
        asegurarArchivoExiste("clientes.dat");
        asegurarArchivoExiste("tarjetas.dat");
        asegurarArchivoExiste("anfitriones.dat");
        asegurarArchivoExiste("inmuebles.dat");
        asegurarArchivoExiste("reservas.dat");
        asegurarArchivoExiste("valoraciones.dat");
    }
    
    /**
     * Método que resetea los archivos utilizados a lo largo del programa
     */
    public static void resetFiles() {
        String[] archivos = {"clientes.dat", "tarjetas.dat", "anfitriones.dat", "inmuebles.dat", "reservas.dat", "valoraciones.dat"};
        for (String archivo : archivos) {
            File file = new File(archivo);
            if (file.exists()) {
                file.delete();
            } else {
                System.out.println("El archivo no existe: " + archivo);
            }
        }
        asegurarArchivoExiste("clientes.dat");
        asegurarArchivoExiste("tarjetas.dat");
        asegurarArchivoExiste("anfitriones.dat");
        asegurarArchivoExiste("inmuebles.dat");
        asegurarArchivoExiste("reservas.dat");
        asegurarArchivoExiste("valoraciones.dat");

    }
}