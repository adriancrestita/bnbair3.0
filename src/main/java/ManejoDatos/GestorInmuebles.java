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
        try{
            FileInputStream fis = new FileInputStream("clientes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();

            if(obj instanceof List) {
                List tempList = (List) obj;
                tempList.stream().forEach(object -> {
                    if(object instanceof Inmueble) {
                        inmuebles.add((Inmueble) object);
                    }
                });
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}