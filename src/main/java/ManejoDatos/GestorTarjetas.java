package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import poo.javabnb.TarjetaCredito;

public class GestorTarjetas {
    private List<TarjetaCredito> tarjetas;
    private final String FILENAME = "tarjetas.dat";

    public GestorTarjetas() {
        tarjetas = new ArrayList<>();
        cargarTarjetas();
    }

    public void agregarTarjeta(TarjetaCredito tarjeta) {
        tarjetas.add(tarjeta);
        guardarTarjetas();
    }

    public List<TarjetaCredito> obtenerTarjetas() {
        return tarjetas;
    }

    private void guardarTarjetas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(tarjetas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarTarjetas() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
        Object obj = ois.readObject();
        if (obj instanceof List) {
            List<?> tempList = (List<?>) obj;
            for (Object item : tempList) {
                if (item instanceof TarjetaCredito) {
                    tarjetas.add((TarjetaCredito) item);
                } else {
                    throw new ClassCastException("Invalid object type in tarjetas.dat");
                }
            }
        } else {
            throw new ClassCastException("Invalid data format in tarjetas.dat");
        }
    } catch (FileNotFoundException e) {
        // File not found, no problem as it will be created when saving
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
}
