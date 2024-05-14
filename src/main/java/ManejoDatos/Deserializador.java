package ManejoDatos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poo.javabnb.Anfitrion;
import poo.javabnb.ClienteParticular;
import poo.javabnb.Inmueble;
import poo.javabnb.TarjetaCredito;

public class Deserializador {
    
    public static ArrayList<ClienteParticular> leerClientes() throws IOException, ClassNotFoundException {
        ArrayList<ClienteParticular> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            clientes = (ArrayList<ClienteParticular>) ois.readObject();
        } catch (EOFException e) {
            // Manejar la excepción si el archivo está vacío
        }
        return clientes;
    }

    public TarjetaCredito leerDatosBancarios(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (TarjetaCredito) ois.readObject();
        }
    }
    
    public Anfitrion leerAnfitrion(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Anfitrion) ois.readObject();
        }
    }

    public Inmueble leerInmueble(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Inmueble) ois.readObject();
        }
    }
    //a
    
    
}