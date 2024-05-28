package ManejoDatos;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                    if (object instanceof Reservas) {
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
    
    public static List<Reservas> eliminarReserva(String correoCliente, String correoAnfitrion, String titulo) {
        List<Reservas> reservasMod = new ArrayList<>();
        try {
            reservasMod = deserializarReservas();

            for (int i = 0; i < reservasMod.size(); i++) {
                Reservas reserva = reservasMod.get(i);
                if (reserva.getCorreoCliente().equals(correoCliente) && reserva.getCorreoAnfitrion().equals(correoAnfitrion) && reserva.getTituloInmueble().equals(titulo)) {
                    reservasMod.remove(i);
                    guardarReservas(reservasMod);
                    break;
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar la reserva: " + ex.getMessage());
        }
        return reservasMod;
    }
    
    public static List<Reservas> eliminarReservasInmueble(String titulo, String correoAnfitrion) {
        List<Reservas> reservasMod = new ArrayList<>();
        try {
            reservasMod = deserializarReservas();

            for (int i = 0; i < reservasMod.size(); i++) {
                Reservas reserva = reservasMod.get(i);
                if (reserva.inmueble.getTitulo().equals(titulo) && reserva.getCorreoAnfitrion().equals(correoAnfitrion)) {
                    reservasMod.remove(i);
                }
            }
            guardarReservas(reservasMod);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar las reservas: " + ex.getMessage());
        }
        return reservasMod;
    }
    
    public static List<Reservas> eliminarReservasCliente(String correo) {
        List<Reservas> reservasMod = new ArrayList<>();
        try {
            reservasMod = deserializarReservas();

            for (int i = 0; i < reservasMod.size(); i++) {
                Reservas reserva = reservasMod.get(i);
                if (reserva.getCorreoCliente().equals(correo)) {
                    reservasMod.remove(i);
                }
            }
            guardarReservas(reservasMod);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar las reservas: " + ex.getMessage());
        }
        return reservasMod;
    }
    
    public boolean reservaDisponible(String titulo, Date fechaEntrada, Date fechaSalida) throws ParseException{
        cargarReservas(); // Se asegura de cargar los datos más recientes
        for (Reservas reserva : reservas) {
            if(fechasSinSolapamiento(fechaEntrada, fechaSalida, reserva.getFechaEntrada(), reserva.getFechaSalida()) && titulo.equals(reserva.getTituloInmueble())){
                return true;
            }
        }
        return false; // Retornar true si está disponible la reserva
    }
    
    public static boolean fechasSinSolapamiento(Date fechaEntrada1, Date fechaSalida1,
                                                   String fechaEntradaStr, String fechaSalidaStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date fechaEntrada = dateFormat.parse(fechaEntradaStr);
        Date fechaSalida= dateFormat.parse(fechaSalidaStr);

        // Si fechaEntrada1 es después de fechaSalida o fechaSalida1 es antes de fechaEntrada, no hay solapamiento
        if (fechaEntrada1.after(fechaSalida) || fechaSalida1.before(fechaEntrada)) {
            return true; // No hay solapamiento
        } else {
            return false; // Hay solapamiento
        }
    }
}
