package poo.javabnb;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import java.util.List;
import static poo.javabnb.MetodosAuxiliares.elementosPorDato;

public class Inmueble implements Serializable{
    
    //Atributos
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String calle;
    private int numero;
    private int CP;
    private String ciudad;
    private int maxHuespedes;
    private int numHabitaciones;
    private int numCamas;
    private int numBaños;
    private String tipoPropiedad;
    private double precioNoche;
    private String servicios;
    private static StringBuilder foto;
    private double calificacion;
    private Anfitrion anfi;
    // Constructor
    public Inmueble(String titulo, String calle, int numero, int CP, String ciudad, int maxHuéspedes, int numHabitaciones, int numCamas, int numBaños, String tipoPropiedad, double precioNoche, String servicios, StringBuilder foto, double calificacion) {
        this.titulo = titulo;
        this.calle = calle;
        this.numero = numero;
        this.CP = CP;
        this.ciudad = ciudad;
        this.maxHuespedes = maxHuespedes;
        this.numHabitaciones = numHabitaciones;
        this.numCamas = numCamas;
        this.numBaños = numBaños;
        this.tipoPropiedad = tipoPropiedad;
        this.precioNoche = precioNoche;
        this.servicios = servicios;
        this.foto = foto;
        this.calificacion = calificacion;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public int getCP(){
        return CP;
    }
    
    public void setCP(int CP){
        this.CP = CP;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public void setNumero(String ciudad){
        this.ciudad = ciudad;
    }

    public int getMaxHuespedes() {
        return maxHuespedes;
    }

    public void setMaxHuéspedes(int maxHuéspedes) {
        this.maxHuespedes = maxHuéspedes;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public int getNumBaños() {
        return numBaños;
    }

    public void setNumBaños(int numBaños) {
        this.numBaños = numBaños;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public static StringBuilder getFoto() {
        return foto;
    }

    public static void setFoto(StringBuilder foto) {
        setFoto(foto);
    }

    /*public void setFoto(StringBuilder foto) {
        this.foto = foto;
    }*/

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    // Método para mostrar información del inmueble
    public String mostrarInformacion() {
        return "\nInmueble: " + titulo +
        "\nDirección: " + calle + "," + numero + "," + CP + "," + ciudad +
        "\nMáximo de huéspedes: " + maxHuespedes +
        "\nNúmero de habitaciones: " + numHabitaciones +
        "\nNúmero de camas: " + numCamas +
        "\nNúmero de baños: " + numBaños +
        "\nTipo de propiedad: " + tipoPropiedad +
        "\nPrecio por noche: $" + precioNoche +
        "\nServicios: " + servicios +
        "\nCalificación: " + calificacion + "/5";
    }
    
    public static void busquedaInmueble(String correo){
        try {
            String archivo = "datos_inmuebles.txt";
            String[] elementos = elementosPorDato(archivo, correo, 0);

            if (elementos != null) {
                for (String elemento : elementos) {
                    System.out.println(elemento);
                }
            } else {
                System.out.println("No se encontró ningun cliente con ese nombre.");
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void guardarInmueble() {
        String linea = anfi.getCorreoElectronico() + "," + getTitulo() + "," + getCalle() + "," + String.valueOf(numero) + "," + String.valueOf(CP) + "," + getCiudad() + "," + String.valueOf(maxHuespedes) + "," + String.valueOf(numHabitaciones) + "," + String.valueOf(numCamas) + "," + String.valueOf(numBaños) + "," + getTipoPropiedad() + "," + String.valueOf(precioNoche) + "," + getServicios() + "," + String.valueOf(calificacion) + "\n";
        try {
            FileWriter myWriter = new FileWriter("datos_inmuebles.txt", true); //el true activa el append
            myWriter.write(linea/*.getBytes(), StandardOpenOption.APPEND*/);
            myWriter.close();
          } 
        catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
          }
    }
    
    // Método para actualizar la calificación basado en una nueva revisión
    public void actualizarCalificacion(double nuevaCalificacion) {
        this.calificacion = (this.calificacion + nuevaCalificacion) / 2; // Puede variar según cómo quieras calcular la media
    }
}
