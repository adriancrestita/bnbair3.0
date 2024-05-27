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
            guardarReservas(obtenerReservas());
        }
    }

    public List<Reservas> obtenerReservas() {
        return reservas;
    }

    private static void guardarReservas(List<Reservas> array) {
       try{
           FileOutputStream fos = new FileOutputStream("reservas.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(array);
           oos.close();
       }catch(Exception e){
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
    
    public static List<Reservas> deserializarReservas() throws IOException, ClassNotFoundException {
        File file = new File("reservas.dat");
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("reservas.dat"))) {
            return (List<Reservas>) ois.readObject();
        }
    }
    
    public Reservas obtenerReserva(String correoCliente, String correoAnfitrion) {
        cargarReservas(); // Se asegura de cargar los datos más recientes
        for (Reservas reserva : reservas) {
            if (reserva.getCorreoCliente().equals(correoCliente) && reserva.getCorreoAnfitrion().equals(correoAnfitrion)) {
                return reserva;
            }
        }
        return null; // Retornar null si no se encuentra el cliente
    }    
    
    public static List<Reservas> eliminarReserva(String correoCliente, String correoAnfitrion) {
        List<Reservas> reservasMod = new ArrayList<>();
        try {
            reservasMod = deserializarReservas();

            for (int i = 0; i < reservasMod.size(); i++) {
                Reservas reserva = reservasMod.get(i);
                if (reserva.getCorreoCliente().equals(correoCliente) && reserva.getCorreoAnfitrion().equals(correoAnfitrion)) {
                    reservasMod.remove(i);
                    guardarReservas(reservasMod);
                    break;
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar el usuario: " + ex.getMessage());
        }
        return reservasMod;
    }
}