/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ManejoDatos;

/**
 *
 * @author hugos
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import poo.javabnb.Sesion;
import poo.javabnb.ValoracionClienteInmueble;

public class GestorValoraciones {
    private static List<ValoracionClienteInmueble> valoraciones;
    private final String FILENAME = "valoraciones.dat";
    
    public GestorValoraciones() {
        valoraciones = new ArrayList<>();
        cargarValoraciones();
    }
    
    public static void cargarValoraciones() {
        try{
            FileInputStream fis = new FileInputStream("clientes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();

            if(obj instanceof List) {
                List tempList = (List) obj;
                tempList.stream().forEach(object -> {
                    if(object instanceof ValoracionClienteInmueble) {
                        valoraciones.add((ValoracionClienteInmueble) object);
                    }
                });
            }
        }catch(Exception e){
            System.out.println(e);
        }    
    }
    
    public static void guardarValoraciones(){
        try{
           FileOutputStream fos = new FileOutputStream("valoraciones.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(valoraciones);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }
    }
    
    public static void agregarValoracion(ValoracionClienteInmueble valoracion) {
        if (valoracion.getReseña().isEmpty()){
            System.out.println("Reseña inválida");
        }
        else{
            valoraciones.add(valoracion);
            guardarValoraciones();
        }
    }
    
    public List<ValoracionClienteInmueble> getValoraciones(){
        return valoraciones;
    }
}
