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
    
    public static ArrayList<ClienteParticular> leerClientes() {
        ArrayList<ClienteParticular> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.dat"))) {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof ClienteParticular) {
                    clientes.add((ClienteParticular) obj);
                }
            }
        } catch (EOFException e) {
            // Fin del archivo alcanzado
            JOptionPane.showMessageDialog(null, "Usuario no registrado");
        } catch (Exception e) {
            e.printStackTrace();
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