package ManejoDatos;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import poo.javabnb.Anfitrion;
import poo.javabnb.ClienteParticular;
import poo.javabnb.Inmueble;
import poo.javabnb.TarjetaCredito;

public class Deserializador {

    public ClienteParticular leerCliente(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ClienteParticular) ois.readObject();
        }
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