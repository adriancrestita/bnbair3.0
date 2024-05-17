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
        try{
           FileOutputStream fos = new FileOutputStream("tarjetas.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(tarjetas);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }
    }

    private void cargarTarjetas() {
        try{
            FileInputStream fis = new FileInputStream("clientes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();

            if(obj instanceof List) {
                List tempList = (List) obj;
                tempList.stream().forEach(object -> {
                    if(object instanceof TarjetaCredito) {
                        tarjetas.add((TarjetaCredito) object);
                    }
                });
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
