package ManejoDatos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import poo.javabnb.Anfitrion;
import poo.javabnb.ClienteParticular;
import poo.javabnb.Inmueble;
import poo.javabnb.TarjetaCredito;

public class Serializador {
    
    public void guardarCliente(ClienteParticular cliente, String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(cliente);
        }
    }

    public void guardarDatosBancarios(TarjetaCredito tarjeta, String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(tarjeta);
        }
    }
    
    public void guardarAnfitrion(Anfitrion anf, String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(anf);
        }
    }

    public void guardarInmuebles(Inmueble inmueble, String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(inmueble);
        }
    }
    
    
}
