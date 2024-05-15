/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDatos;

import java.io.*;
import java.util.List;

public class InspectClientesDat {
    public static void main(String[] args) {
        String filename = "clientes.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                List<?> list = (List<?>) obj;
                for (Object item : list) {
                    System.out.println(item.getClass().getName() + ": " + item);
                }
            } else {
                System.out.println("Invalid data format in " + filename);
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename + " not found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}