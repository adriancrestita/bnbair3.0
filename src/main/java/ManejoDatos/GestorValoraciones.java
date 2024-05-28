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
    
    /**
     * añade una nueva valoracion al archivo valoraciones.dat
     * @param valoracion 
     */
    public void agregarValoracion(Valoracion valoracion) {
        if (String.valueOf(valoracion.getNota()) == null || String.valueOf(valoracion.getNota()).isEmpty()) {
            throw new IllegalArgumentException("La nota no puede ser nula o vacía");
        }
        else{
            valoraciones.add(valoracion);
            guardarValoraciones(obtenerValoraciones());  
        }  
    }
    
    /**
     * devuelve la lista con todas las valoraciones
     * @return 
     */
    public List<Valoracion> obtenerValoraciones() {
        return valoraciones;
    }
    
    /**
     * Guarda las valoraciones en el archivo valoraciones.dat
     * @param array 
     */
    private static void guardarValoraciones(List<Valoracion> array) {
       try{
           FileOutputStream fos = new FileOutputStream("valoraciones.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(array);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }        
    }
    
    /**
     * Lee el archivo valoraciones.dat y los incluye todos en una lista
     */
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
    
    /**
     * mediante el correo del cliente y el titulo del inmueble, obtiene una valoracion en concreto
     * @param correo
     * @param titulo
     * @return Valoracion del inmueble en concreto
     */
    public Valoracion obtenerValoracion(String correo, String titulo) {
        cargarValoraciones(); // Se asegura de cargar los datos más recientes
        for (Valoracion valoracion : valoraciones) {
            if (valoracion.getCorreoCliente().equals(correo) && valoracion.getInmueble().getTitulo().equals(titulo)) {
                return valoracion;
            }
        }
        return null; // Retornar null si no se encuentra la valoracion
    }
    
    /**
     * Devuelve la lista de valoraciones de un inmueble
     * @param correo
     * @param titulo
     * @return Lista de valoraciones
     */
    public List<Valoracion> obtenerValoracionesInmueble(String correo, String titulo){
        cargarValoraciones(); // Se asegura de cargar los datos más recientes
        List<Valoracion> valoracionesInmueble = new ArrayList<>();
        for (Valoracion valoracion : valoraciones) {
            if (valoracion.getCorreoAnfitrion().equals(correo) && valoracion.getInmueble().getTitulo().equals(titulo)) {
                valoracionesInmueble.add(valoracion);
            }
        }
        return valoracionesInmueble; 
    }
    
    /**
     * Comprueba que un cliente no pueda valorar un mismo inmueble varias veces
     * @param correo
     * @param titulo
     * @param correoAnfitrion
     * @return boolean
     */
    public boolean existeValoracionCliente(String correo, String titulo, String correoAnfitrion){
        cargarValoraciones(); // Se asegura de cargar los datos más recientes
        for (Valoracion valoracion : valoraciones) {
            if (valoracion.getCorreoCliente().equals(correo) && valoracion.getInmueble().getTitulo().equals(titulo) && valoracion.getInmueble().getCorreoAnfitrion().equals(correoAnfitrion)) {
                return true;
            }
        }
        return false; // Retornar false si no se existe la valoracion
    }
    
    /**
     * Retorna el numero de valoraciones totales de un anfitrión
     * @param correo
     * @return 
     */
    public int obtenerNumeroValoracionesAnfitrion(String correo){
        int num = 0;
        for (Valoracion valoracion : valoraciones){
            if (valoracion.getInmueble().getCorreoAnfitrion().equals(correo)){
                num++;
            }
        }
        return num;
    }
    
    /**
     * obtiene la media de valoraciones de todos los inmuebles del administrador
     * @param correo
     * @return 
     */
    public double obtenerMediaValoracionesAnfitrion(String correo){
        int suma = 0;
        for (Valoracion valoracion : valoraciones){
            if (valoracion.getInmueble().getCorreoAnfitrion().equals(correo)){
                suma+=valoracion.getNota();
            }
        }
        
        if(obtenerNumeroValoracionesAnfitrion(correo) != 0){
            double media = (double) (suma/obtenerNumeroValoracionesAnfitrion(correo));
            return media;
        }
        else{
            return 0;
        }
    }
    
    /**
     * elimina una valoración de un inmueble en concreto
     * @param correo
     * @param titulo
     * @return 
     */
    public static List<Valoracion> eliminarValoracion(String correo, String titulo) {
        List<Valoracion> valoracionesMod = new ArrayList<>();
        try {
            valoracionesMod = deserializarValoraciones();

            for (int i = 0; i < valoracionesMod.size(); i++) {
                Valoracion val = valoracionesMod.get(i);
                if (val.getCorreoCliente().equals(correo) && val.getInmueble().getTitulo().equals(titulo)) {
                    valoracionesMod.remove(i);
                    guardarValoraciones(valoracionesMod);
                    break;
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar la valoración: " + ex.getMessage());
        }
        return valoracionesMod;
    }
    
}
