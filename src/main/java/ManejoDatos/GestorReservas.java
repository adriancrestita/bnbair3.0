package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import poo.javabnb.Reservas;
import poo.javabnb.TarjetaCredito;

public class GestorReservas {
    private List<Reservas> reservas;
    private final String FILENAME = "reservas.dat";

    public GestorReservas() {
        reservas = new ArrayList<>();
        cargarReservas();
    }

    public void agregarReserva(Reservas reserva) {
        if (reserva.getCorreoCliente() == null || reserva.getCorreoCliente().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede ser nulo o vacío");
        } else {
            reservas.add(reserva);
            guardarReservas();
        }
    }

    public List<Reservas> obtenerReservas() {
        return reservas;
    }

    private void guardarReservas() {
        try {
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(reservas);
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarReservas() {
        try {
            FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();

            if (obj instanceof List) {
                List tempList = (List) obj;
                tempList.stream().forEach(object -> {
                    if (object instanceof TarjetaCredito) {
                        reservas.add((Reservas) object);
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}