/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDatos;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import poo.javabnb.Anfitrion;

public class GestorAnfitrion {
    private List<Anfitrion> anfitriones;
    private final String FILENAME = "anfitriones.dat";

    public GestorAnfitrion() {
        anfitriones = new ArrayList<>();
        cargarAnfitriones();
    }

    public void agregarAnfitrion(Anfitrion anfi) {
        if (anfi.getCorreoElectronico() == null || anfi.getCorreoElectronico().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede ser nulo o vacío");
        }
        else{
            anfitriones.add(anfi);
            guardarAnfitriones();  
        }  
    }

    public List<Anfitrion> obtenerAnfitriones() {
        return anfitriones;
    }

    private void guardarAnfitriones() {
        try{
           FileOutputStream fos = new FileOutputStream("anfitriones.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(anfitriones);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }
    }
    
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

    private void cargarAnfitriones() {
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
    
    public Anfitrion obtenerAnfitrion(String correo) {
        cargarAnfitriones(); // Asegúrate de cargar los datos más recientes
        for (Anfitrion anfitrion : anfitriones) {
            if (anfitrion.getCorreoElectronico().equals(correo)) {
                return anfitrion;
            }
        }
        return null; // Retornar null si no se encuentra el cliente
    }
    
    public static List<Anfitrion> deserializarUsuarios() throws IOException, ClassNotFoundException {
        File file = new File("anfitriones.dat");
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("anfitriones.dat"))) {
            return (List<Anfitrion>) ois.readObject();
        }
    }
    
    
    public static boolean modificarAnfitrion(String correoOriginal, Anfitrion anfitrion) {
        try {
            List<Anfitrion> anfitrionesMod = deserializarUsuarios();

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
    
    public static void eliminarAnfitrion(String correo) {
        boolean eliminado = false;
        try {
            List<Anfitrion> anfitrionesMod = deserializarUsuarios();
            for (int i = 0; i < anfitrionesMod.size(); i++) {
                Anfitrion anfitrion = anfitrionesMod.get(i);
                if (anfitrion.getCorreoElectronico().equals(correo)) {
                    anfitrionesMod.remove(i);
                    eliminado = true;
                    break;
                }
            }
            if (eliminado) {
                guardarAnfitriones(anfitrionesMod);
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar el usuario: " + ex.getMessage());
        }
        //return eliminado;
    }
}