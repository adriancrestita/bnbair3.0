package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import poo.javabnb.ClienteParticular;

public class GestorClientes {
    private List<ClienteParticular> clientes;
    private final String FILENAME = "clientes.dat";

    public GestorClientes() {
        clientes = new ArrayList<>();
        cargarClientes();
    }

    public void agregarCliente(ClienteParticular cliente) {
        clientes.add(cliente);
        guardarClientes();
    }

    public List<ClienteParticular> obtenerClientes() {
        return clientes;
    }

    private void guardarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                List<?> tempList = (List<?>) obj;
                for (Object item : tempList) {
                    if (item instanceof ClienteParticular) {
                        clientes.add((ClienteParticular) item);
                    } else {
                        throw new ClassCastException("Invalid object type in clientes.dat");
                    }
                }
            } else {
                throw new ClassCastException("Invalid data format in clientes.dat");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de clientes. Por favor, contacte al soporte.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de clientes. Por favor, contacte al soporte.");
        } catch (ClassCastException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Formato de datos inválido en " + FILENAME + ". Por favor, contacte al soporte.");
        }
    }
}