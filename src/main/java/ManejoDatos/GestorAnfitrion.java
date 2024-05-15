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

    public void agregarAnfitrion(Anfitrion anfitrion) {
        anfitriones.add(anfitrion);
        guardarAnfitriones();
    }

    public List<Anfitrion> obtenerAnfitriones() {
        return anfitriones;
    }

    private void guardarAnfitriones() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(anfitriones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarAnfitriones() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            anfitriones = (List<Anfitrion>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, no problem as it will be created when saving
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}