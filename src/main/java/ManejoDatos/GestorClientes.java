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
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                System.out.println("Objeto leído: " + obj.getClass().getName());  // Agregar depuración
                if (obj instanceof ClienteParticular) {
                    clientes.add((ClienteParticular) obj);
                } else {
                    System.out.println("Objeto ignorado: " + obj.getClass().getName());  // Agregar depuración
                }
            }
        } catch (EOFException eof) {
            // Fin del archivo
        }
        return clientes;
    }
    
    
    public static ArrayList<Object> leerItems() throws IOException, ClassNotFoundException {
        ArrayList<Object> items = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            while (true) {
                Object item = ois.readObject();
                items.add(item);
            }
        } catch (EOFException e) {
            // Fin del archivo alcanzado
        }
        return items;
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
        cargarClientes();
    }
    
    
    public static void imprimirTodosLosClientes() {
        try {
            ArrayList<Object> items = leerItems(); // Cambio a Object para generalización
            if (items.isEmpty()) {
                System.out.println("No hay datos guardados en el archivo.");
            } else {
                for (Object item : items) {
                    if (item instanceof ClienteParticular) {
                        ClienteParticular cliente = (ClienteParticular) item;
                        System.out.println("DNI: " + cliente.getDni() + ", Nombre: " + cliente.getNombre() +
                                           ", Correo Electrónico: " + cliente.getCorreoElectronico() +
                                           ", Teléfono: " + cliente.getTelefono() + ", Es VIP: " + cliente.getesVIP());
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer los datos desde el archivo.");
            e.printStackTrace();
        }
    }
    
    public static ArrayList<ClienteParticular> cargarClientes() throws IOException, ClassNotFoundException {
        ArrayList<ClienteParticular> clientes = new ArrayList<>();
        File archivoClientes = new File("clientes.dat");
        if (archivoClientes.exists() && archivoClientes.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
                clientes = (ArrayList<ClienteParticular>) ois.readObject();
            } catch (EOFException e) {
                // Archivo puede estar vacío, manejar apropiadamente
            }
        } else {
            System.out.println("El archivo no existe o está vacío. Se inicializará una lista nueva.");
        }
        return clientes;
    }
    
    public static void guardarDatos(String dni, String nombre, String correo, String password, String telefono, boolean esVIP) throws IOException, ClassNotFoundException{
        ClienteParticular particular = new ClienteParticular(dni,nombre,correo,password,telefono,esVIP);
        /*particular.setDni(dni);
        particular.setNombre(nombre);
        particular.setCorreoElectronico(correo);
        particular.setClave(String.valueOf(password));
        particular.setTelefono(telefono);
        particular.setesVIP(esVIP);*/
        
        GestorClientes.añadirYGuardarCliente(particular);

        
    }
}
