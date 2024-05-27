/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDatos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import poo.javabnb.Anfitrion;

public class GestorAnfitrion implements Serializable{
    private List<Anfitrion> anfitriones;
    private static final long serialVersionUID = 1L;
    private final String FILENAME = "anfitriones.dat";

    public GestorAnfitrion() {
        anfitriones = new ArrayList<>();
        cargarAnfitriones();
    }
    
    /**
     * Dado un objeto de anfitrion, añade el mismo a anfitriones.dat y lo guarda
     * @param anfi 
     */
    public void agregarAnfitrion(Anfitrion anfi) {
        if (anfi.getCorreoElectronico() == null || anfi.getCorreoElectronico().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede ser nulo o vacío");
        }
        else{
            anfitriones.add(anfi);
            guardarAnfitriones(obtenerAnfitriones());  
        }  
    }
    
    /**
     * 
     * @return de la lista de todos los objetos de anfitriones 
     */
    public List<Anfitrion> obtenerAnfitriones() {
        return anfitriones;
    }
    
    
    /**
     * Guarda los anfitriones en anfitriones.dat una vez proporcionada una List de anfitriones
     * @param array 
     */
    private static void guardarAnfitriones(List<Anfitrion> array) {
       try{
           FileOutputStream fos = new FileOutputStream("anfitriones.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(array);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }        
    }
    
    /**
     * Carga todos los anfitriones en el programa obteniendo los archivos desde anfitriones.dat
     */
    public void cargarAnfitriones() {
        try{
            FileInputStream fis = new FileInputStream("anfitriones.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();

            if(obj instanceof List) {
                List tempList = (List) obj;
                tempList.stream().forEach(object -> {
                    if(object instanceof Anfitrion) {
                        anfitriones.add((Anfitrion) object);
                    }
                });
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * Dado un correo, busca entre todos los anfitriones hasta encontrar el deseado
     * @param correo
     * @return el objeto del Anfitrion buscado
     */
    public Anfitrion obtenerAnfitrion(String correo) {
        cargarAnfitriones(); // Asegúrate de cargar los datos más recientes
        for (Anfitrion anfitrion : anfitriones) {
            if (anfitrion.getCorreoElectronico().equals(correo)) {
                return anfitrion;
            }
        }
        return null; // Retornar null si no se encuentra el cliente
    }
    
    /**
     * Deserializa el .dat de anfitriones para poder trabajar con él directamente desde el .dat
     * @return la lista de Anfitriones
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static List<Anfitrion> deserializarAnfitriones() throws IOException, ClassNotFoundException {
        File file = new File("anfitriones.dat");
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("anfitriones.dat"))) {
            return (List<Anfitrion>) ois.readObject();
        }
    }
    
    /**
     * Método encargado de modificar un objeto de Anfitrion ya existente en el .dat dado el objeto modificado y carga la lista modificada
     * @param correoOriginal
     * @param anfitrion
     * @return true/false para saber si se ha cumplido el proceso
     */
    public static boolean modificarAnfitrion(String correoOriginal, Anfitrion anfitrion) {
        try {
            List<Anfitrion> anfitrionesMod = deserializarAnfitriones();

            for (int i = 0; i < anfitrionesMod.size(); i++) {
                Anfitrion cp = anfitrionesMod.get(i);
                if (cp.getCorreoElectronico().equals(correoOriginal)) {
                    anfitrionesMod.set(i, anfitrion);
                    guardarAnfitriones(anfitrionesMod);
                    return true; //cliente actualizado
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al modificar el usuario: " + ex.getMessage());
        }
        return false;
    }
    
    /**
     * Método similar a modificar, pero que elimina directamente el objeto 
     * @param correo
     * @return lista de anfitriones actualizada para poder guardarlo posteriormente
     */
    public static List<Anfitrion> eliminarAnfitrion(String correo) {
        List<Anfitrion> anfitrionesMod = new ArrayList<>();
        try {
            anfitrionesMod = deserializarAnfitriones();

            for (int i = 0; i < anfitrionesMod.size(); i++) {
                Anfitrion cp = anfitrionesMod.get(i);
                if (cp.getCorreoElectronico().equals(correo)) {
                    anfitrionesMod.remove(i);
                    guardarAnfitriones(anfitrionesMod);
                    break;
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar el usuario: " + ex.getMessage());
        }
        return anfitrionesMod;
    }
}
