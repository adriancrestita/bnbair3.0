/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDatos;


import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

import java.io.IOException;

import java.io.IOException;
import poo.javabnb.Anfitrion;

public class GestorAnfitriones {

    /**
     * Guarda una lista de anfitriones en un archivo .dat.
     * 
     * @param anfitriones Lista de anfitriones a guardar.
     * @param archivo El nombre del archivo donde se guardarán los anfitriones.
     */
    public static void guardarAnfitriones(ArrayList<Anfitrion> anfitriones) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("anfitriones.dat"))) {
            oos.writeObject(anfitriones);
        }
    }

    /**
     * Lee los anfitriones desde un archivo .dat.
     * 
     * @param archivo El nombre del archivo de donde leer los anfitriones.
     * @return Lista de anfitriones leída del archivo.
     */
    public static ArrayList<Anfitrion> leerAnfitriones() throws IOException, ClassNotFoundException {
        ArrayList<Anfitrion> anfitriones = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("anfitriones.dat"))) {
            anfitriones = (ArrayList<Anfitrion>) ois.readObject();
        } catch (EOFException e) {
            // Manejar la excepción si el archivo está vacío
        }
        return anfitriones;
    }

    /**
     * Añade un nuevo anfitrión a la lista y guarda el cambio.
     * 
     * @param anfitrion El nuevo anfitrión a añadir.
     * @param archivo El nombre del archivo donde se guardarán los anfitriones.
     */
    public static void añadirYGuardarAnfitrion(Anfitrion anfitrion) throws IOException, ClassNotFoundException {
        ArrayList<Anfitrion> anfitriones = leerAnfitriones();
        anfitriones.add(anfitrion);
        guardarAnfitriones(anfitriones);
    }
}