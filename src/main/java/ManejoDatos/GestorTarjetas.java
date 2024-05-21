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
        if (tarjeta.getCorreo() == null || tarjeta.getCorreo().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede ser nulo o vacío");
        } else {
            tarjetas.add(tarjeta);
            guardarTarjetas();
        }
    }

    public List<TarjetaCredito> obtenerTarjetas() {
        return tarjetas;
    }

    private void guardarTarjetas() {
        try {
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tarjetas);
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarTarjetas() {
        try {
            FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();

            if (obj instanceof List) {
                List tempList = (List) obj;
                tempList.stream().forEach(object -> {
                    if (object instanceof TarjetaCredito) {
                        tarjetas.add((TarjetaCredito) object);
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}