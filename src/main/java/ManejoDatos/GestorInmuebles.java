package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import poo.javabnb.Inmueble;

public class GestorInmuebles {
    private List<Inmueble> inmuebles;
    private final String FILENAME = "inmuebles.dat";

    public GestorInmuebles() {
        inmuebles = new ArrayList<>();
        cargarInmuebles();
    }

    public void agregarInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
        guardarInmuebles();
    }

    public List<Inmueble> obtenerInmuebles() {
        return inmuebles;
    }

    private void guardarInmuebles() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(inmuebles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarInmuebles() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            inmuebles = (List<Inmueble>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, no problem as it will be created when saving
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}