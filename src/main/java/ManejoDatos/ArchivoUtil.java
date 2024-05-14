package ManejoDatos;

import java.io.File;
import java.io.IOException;

public class ArchivoUtil {

    /**
     * Asegura que un archivo exista. Si no existe, lo crea.
     *
     * @param nombreArchivo El nombre del archivo a verificar y crear si no existe.
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
     * Método para inicializar los archivos necesarios para la aplicación.
     */
    public static void inicializarArchivos() {
        asegurarArchivoExiste("clientes.dat");
        asegurarArchivoExiste("tarjetas.dat");
    }
}