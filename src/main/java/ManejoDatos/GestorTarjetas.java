package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import poo.javabnb.TarjetaCredito;

public class GestorTarjetas {

    /**
     * Guarda una lista de tarjetas de crédito en un archivo .dat.
     *
     * @param tarjetas Lista de tarjetas de crédito a guardar.
     * @param archivo El nombre del archivo donde se guardarán las tarjetas.
     */
    public static void guardarTarjetas(ArrayList<TarjetaCredito> tarjetas) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            oos.writeObject(tarjetas);
        }
    }

    /**
     * Lee las tarjetas de crédito desde un archivo .dat.
     *
     * @param archivo El nombre del archivo de donde leer las tarjetas.
     * @return Lista de tarjetas de crédito leída del archivo.
     */
    public static ArrayList<TarjetaCredito> leerTarjetas() throws IOException, ClassNotFoundException {
        ArrayList<TarjetaCredito> tarjetas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tarjetas.dat"))) {
            tarjetas = (ArrayList<TarjetaCredito>) ois.readObject();
        } catch (EOFException e) {
            // Manejar la excepción si el archivo está vacío
        }
        return tarjetas;
    }

    /**
     * Añade una nueva tarjeta a la lista y guarda el cambio.
     *
     * @param tarjeta La nueva tarjeta a añadir.
     * @param archivo El nombre del archivo donde se guardarán las tarjetas.
     */
    public static void añadirYGuardarTarjeta(TarjetaCredito tarjeta) throws IOException, ClassNotFoundException {
        ArrayList<TarjetaCredito> tarjetas = leerTarjetas();
        tarjetas.add(tarjeta);
        guardarTarjetas(tarjetas);
        cargarTarjetas();
    }
    
    public static ArrayList<TarjetaCredito> cargarTarjetas() throws IOException, ClassNotFoundException {
        ArrayList<TarjetaCredito> tarjetas = new ArrayList<>();
        File archivoTarjetas = new File("tarjetas.dat");
        if (archivoTarjetas.exists() && archivoTarjetas.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tarjetas.dat"))) {
                tarjetas = (ArrayList<TarjetaCredito>) ois.readObject();
            } catch (EOFException e) {
                // Archivo puede estar vacío, manejar apropiadamente
            }
        } else {
            System.out.println("El archivo no existe o está vacío. Se inicializará una lista nueva.");
        }
        return tarjetas;
    }
    
    public static void guardarDatos(String fcad, String titular, String numtarj) throws IOException, ClassNotFoundException{
        TarjetaCredito tj = new TarjetaCredito(fcad, titular, numtarj);
        /*tj.setFechaCaducidad(fcad);
        tj.setNombreTitular(titular);
        tj.setNumeroTarjeta(numtarj);*/
        
        añadirYGuardarTarjeta(tj);
    }
}
