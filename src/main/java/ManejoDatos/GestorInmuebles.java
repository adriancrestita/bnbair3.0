package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import poo.javabnb.Anfitrion;
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

    public static void guardarInmuebles() {
        try{
           FileOutputStream fos = new FileOutputStream("inmuebles.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(inmuebles);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }        
    }
    
    private static void guardarInmuebles(List<Inmueble> array) {
       try{
           FileOutputStream fos = new FileOutputStream("inmuebles.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(array);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }        
    }

    public static void cargarInmuebles() {
        try{
            FileInputStream fis = new FileInputStream("inmuebles.dat");
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
    
    public static List<Object[]> obtenerTodosLosInmuebles() {
        List<Object[]> listainmuebles = new ArrayList<>();
        
        for (Inmueble inmueble : inmuebles) {
            listainmuebles.add(new Object[]{
                inmueble.getCorreoAnfitrion(), inmueble.getTitulo(), inmueble.getDireccionAsString(), inmueble.getTipoPropiedad(), inmueble.getMaxHuespedes(),
                inmueble.getPrecioNoche() + "€", inmueble.getServiciosAsString() 
            });
        }
        return listainmuebles;
    }
    
    public static List<Inmueble> eliminarInmueble(String correo) {
        List<Inmueble> inmueblesMod = new ArrayList<>();
        try {
            inmueblesMod = deserializarInmuebles();

            for (int i = 0; i < inmueblesMod.size(); i++) {
                Inmueble inm = inmueblesMod.get(i);
                if (inm.getCorreoAnfitrion().equals(correo)) {
                    inmueblesMod.remove(i);
                    guardarInmuebles(inmueblesMod);
                    break;
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar el usuario: " + ex.getMessage());
        }
        return inmueblesMod;
    }
    
    public static List<Inmueble> deserializarInmuebles() throws IOException, ClassNotFoundException {
        File file = new File("inmuebles.dat");
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("inmuebles.dat"))) {
            return (List<Inmueble>) ois.readObject();
        }
    }
}