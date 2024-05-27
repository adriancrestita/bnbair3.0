package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import poo.javabnb.Valoracion;
import poo.javabnb.Sesion;

public class GestorValoraciones {
    private static List<Valoracion> valoraciones;
    private final String FILENAME = "valoraciones.dat";
    
    public GestorValoraciones() {
        valoraciones = new ArrayList<>();
        cargarValoraciones();
    }

    public void agregarValoracion(Valoracion valoracion) {
        if (String.valueOf(valoracion.getNota()) == null || String.valueOf(valoracion.getNota()).isEmpty()) {
            throw new IllegalArgumentException("La nota no puede ser nula o vacía");
        }
        else{
            valoraciones.add(valoracion);
            guargarValoraciones(obtenerValoraciones());  
        }  
    }
    
    public List<Valoracion> obtenerValoraciones() {
        return valoraciones;
    }
      
    private static void guargarValoraciones(List<Valoracion> array) {
       try{
           FileOutputStream fos = new FileOutputStream("valoraciones.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(array);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }        
    }

    public static void cargarValoraciones() {
        try{
            FileInputStream fis = new FileInputStream("valoraciones.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();

            if(obj instanceof List) {
                List tempList = (List) obj;
                tempList.stream().forEach(object -> {
                    if(object instanceof Valoracion) {
                        valoraciones.add((Valoracion) object);
                    }
                });
                
            }
        }catch(Exception e){
            System.out.println(e);
        }    
    }
    
    public static List<Valoracion> deserializarValoraciones() throws IOException, ClassNotFoundException {
        File file = new File("valoraciones.dat");
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            return (List<Valoracion>) ois.readObject();
        }
    }
    
    public Valoracion obtenerValoracion(String correo, String titulo) {
        cargarValoraciones(); // Se asegura de cargar los datos más recientes
        for (Valoracion valoracion : valoraciones) {
            if (valoracion.getCorreoCliente().equals(correo) && valoracion.getInmueble().getTitulo().equals(titulo)) {
                return valoracion;
            }
        }
        return null; // Retornar null si no se encuentra la valoracion
    }
    
    public boolean existeValoracionCliente(String correo, String titulo){
        cargarValoraciones(); // Se asegura de cargar los datos más recientes
        for (Valoracion valoracion : valoraciones) {
            if (valoracion.getCorreoCliente().equals(correo) && valoracion.getInmueble().getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false; // Retornar false si no se existe la valoracion
    }
    
    public static List<Valoracion> eliminarValoracion(String correo, String titulo) {
        List<Valoracion> valoracionesMod = new ArrayList<>();
        try {
            valoracionesMod = deserializarValoraciones();

            for (int i = 0; i < valoracionesMod.size(); i++) {
                Valoracion val = valoracionesMod.get(i);
                if (val.getCorreoCliente().equals(correo) && val.getInmueble().getTitulo().equals(titulo)) {
                    valoracionesMod.remove(i);
                    guargarValoraciones(valoracionesMod);
                    break;
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar la valoración: " + ex.getMessage());
        }
        return valoracionesMod;
    }
    
}
