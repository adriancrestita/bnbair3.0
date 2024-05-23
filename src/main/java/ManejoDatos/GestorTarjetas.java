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
        
    private static void guardarTarjetas(List<TarjetaCredito> array) {
       try{
           FileOutputStream fos = new FileOutputStream("tarjetas.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(array);
           oos.close();
       }catch(Exception e){
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
    
    public String obtenerNumeroTarjeta(String correo) {
        for (TarjetaCredito tarjeta : tarjetas) {
            if (tarjeta.getCorreo().equals(correo)) {
                return tarjeta.getNumeroTarjeta();
            }
        }
        return "No disponible";
    }
    
    public TarjetaCredito obtenerTarjeta(String correo) {
        cargarTarjetas(); // Asegúrate de cargar los datos más recientes
        for (TarjetaCredito tj : tarjetas) {
            if (tj.getCorreo().equals(correo)) {
                return tj;
            }
        }
        return null; // Retornar null si no se encuentra el cliente
    }
    
    public static List<TarjetaCredito> deserializarTarjetas() throws IOException, ClassNotFoundException {
        File file = new File("tarjetas.dat");
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tarjetas.dat"))) {
            return (List<TarjetaCredito>) ois.readObject();
        }
    }
    
    
    public static boolean modificarTarjeta(String correoOriginal, TarjetaCredito tj) {
        try {
            List<TarjetaCredito> tarjetasMod = deserializarTarjetas();

            for (int i = 0; i < tarjetasMod.size(); i++) {
                TarjetaCredito tarj = tarjetasMod.get(i);
                if (tarj.getCorreo().equals(correoOriginal)) {
                    tarjetasMod.set(i, tj);
                    guardarTarjetas(tarjetasMod);
                    return true; //cliente actualizado
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al modificar el usuario: " + ex.getMessage());
        }
        return false;
    }
    
    public static void eliminarTarjeta(String correo) {
        try {
            List<TarjetaCredito> tarjetasMod = deserializarTarjetas();

            for (int i = 0; i < tarjetasMod.size(); i++) {
                TarjetaCredito cp = tarjetasMod.get(i);
                if (cp.getCorreo().equals(correo)) {
                    tarjetasMod.remove(i);
                    guardarTarjetas(tarjetasMod);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar el usuario: " + ex.getMessage());
        }
    }
}