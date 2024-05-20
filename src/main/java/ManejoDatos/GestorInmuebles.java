package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import poo.javabnb.Inmueble;

public class GestorInmuebles {
    private static List<Inmueble> inmuebles;
    private static final String FILENAME = "inmuebles.dat";

    public GestorInmuebles() {
        inmuebles = new ArrayList<>();
        cargarInmuebles();
    }

    public static void agregarInmueble(Inmueble inmueble) {
        if (inmueble.getTitulo() == null || inmueble.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacío");
        }
        else{
            inmuebles.add(inmueble);
            guardarInmuebles();  
        }  
    }
    
    public static List<Inmueble> obtenerInmuebles() {
        return inmuebles;
    }

    private static void guardarInmuebles() {
        try{
           FileOutputStream fos = new FileOutputStream("inmuebles.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(inmuebles);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }        
    }

    private static void cargarInmuebles() {
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
            System.out.println(e);

        }    
    }
}