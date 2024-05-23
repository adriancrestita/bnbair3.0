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
    
    public void eliminarAnfitrion(String correo) {
        if (correo == null || correo.isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede ser nulo o vacío");
        } else {
            boolean removed = anfitriones.removeIf(cliente -> cliente.getCorreoElectronico().equals(correo));
            if (removed) {
                guardarAnfitriones();
                cargarAnfitriones();
                System.out.println("Cliente eliminado con éxito.");
            } else {
                System.out.println("No se encontró un cliente con el correo especificado.");
            }
        }
    }
    public void modificarAnfitrion(String correo, Anfitrion nuevoAnfitrion) {
        boolean encontrado = false;
        for (int i = 0; i < anfitriones.size(); i++) {
            if (anfitriones.get(i).getCorreoElectronico().equals(correo)) {
                anfitriones.set(i, nuevoAnfitrion);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            guardarAnfitriones();
            cargarAnfitriones();
            System.out.println("Cliente modificado con éxito.");
        } else {
            System.out.println("No se encontró un cliente con el correo especificado.");
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
}