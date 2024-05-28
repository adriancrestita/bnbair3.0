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

    /**
     * Dado un objeto de inmueble, añade el mismo a inmuebles.dat y lo guarda
     * @param inmueble 
     */
    public static void agregarInmueble(Inmueble inmueble) {
        if (inmueble.getTitulo() == null || inmueble.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacío");
        }
        else{
            inmuebles.add(inmueble);
            guardarInmuebles(obtenerInmuebles());  
        }  
    }
    
    
    public static List<Inmueble> obtenerInmuebles() {
        return inmuebles;
    }
    
    /**
     * Guarda los inmuebles en inmuebles.dat una vez proporcionada una List de inmuebles
     * @param array 
     */
    
    
    public static void guardarInmuebles(List<Inmueble> array) {
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
    
    public static List<Inmueble> eliminarInmueble(String correo, String titulo) {
        List<Inmueble> inmueblesMod = new ArrayList<>();
        try {
            inmueblesMod = deserializarInmuebles();

            for (int i = 0; i < inmueblesMod.size(); i++) {
                Inmueble inm = inmueblesMod.get(i);
                if (inm.getCorreoAnfitrion().equals(correo) && inm.getTitulo().equals(titulo)) {
                    inmueblesMod.remove(i);
                    guardarInmuebles(inmueblesMod);
                    break;
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar el inmueble: " + ex.getMessage());
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
    
    public static boolean modificarInmueble(String correoAnfitrion, String tituloOriginal, Inmueble inmueble) {
        try {
            List<Inmueble> inmueblesMod = deserializarInmuebles();

            for (int i = 0; i < inmueblesMod.size(); i++) {
                Inmueble inm = inmueblesMod.get(i);
                if (inm.getCorreoAnfitrion().equals(correoAnfitrion) && inm.getTitulo().equals(tituloOriginal)) {
                    inmueblesMod.set(i, inm);
                    guardarInmuebles(inmueblesMod);
                    return true; //cliente actualizado
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al modificar el inmueble: " + ex.getMessage());
        }
        return false;
    }
}