package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import poo.javabnb.ClienteParticular;

public class GestorClientes {

    /**
     * Guarda una lista de clientes en un archivo .dat.
     *
     * @param clientes Lista de clientes a guardar.
     * @param archivo El nombre del archivo donde se guardarán los clientes.
     */
    public static void guardarClientes(ArrayList<ClienteParticular> clientes) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            oos.writeObject(clientes);
        }
    }

    /**
     * Lee los clientes desde un archivo .dat.
     *
     * @param archivo El nombre del archivo de donde leer los clientes.
     * @return Lista de clientes leída del archivo.
     */
    public static ArrayList<ClienteParticular> leerClientes() throws IOException, ClassNotFoundException {
        ArrayList<ClienteParticular> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            clientes = (ArrayList<ClienteParticular>) ois.readObject();
        } catch (EOFException e) {
            // Manejar la excepción si el archivo está vacío
        }
        return clientes;
    }

    /**
     * Añade un nuevo cliente a la lista y guarda el cambio.
     *
     * @param cliente El nuevo cliente a añadir.
     * @param archivo El nombre del archivo donde se guardarán los clientes.
     */
    public static void añadirYGuardarCliente(ClienteParticular cliente) throws IOException, ClassNotFoundException {
        ArrayList<ClienteParticular> clientes = leerClientes();
        clientes.add(cliente);
        guardarClientes(clientes);
    }
}
