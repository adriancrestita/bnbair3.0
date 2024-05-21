package poo.javabnb;

import java.io.*;
import java.io.Serializable;
import java.util.*;

public class Inmueble implements Serializable{
    
    //Atributos
    private static final long serialVersionUID = 1L;
    private transient Anfitrion Anfitrion;
    private String CorreoAnfitrion;
    private String titulo;
    private ArrayList<String> direccion;
    private String calle;
    private String numero;
    private String CP;
    private String ciudad;
    private String maxHuespedes;
    private String numHabitaciones;
    private String numCamas;
    private String numBaños;
    private String tipoPropiedad;
    private String precioNoche;
    private ArrayList<String> servicios;
    private ArrayList<String> imagePaths;
    private double calificacion;
    
    // Constructor
    public Inmueble(Anfitrion anfitrion, String titulo, ArrayList<String> direccion, String maxHuespedes, String numHabitaciones, String numCamas, String numBaños, String tipoPropiedad, String precioNoche, ArrayList<String> servicios, ArrayList<String> imagePaths) {
        this.Anfitrion = anfitrion;
        this.titulo = titulo;
        this.direccion = direccion;
        this.maxHuespedes = maxHuespedes;
        this.numHabitaciones = numHabitaciones;
        this.numCamas = numCamas;
        this.numBaños = numBaños;
        this.tipoPropiedad = tipoPropiedad;
        this.precioNoche = precioNoche;
        this.servicios = servicios;
        this.imagePaths = imagePaths;
    }
    
    public Inmueble(Anfitrion anfitrion, String titulo, String calle, String numero, String ciudad, String CP, String maxHuespedes, String numHabitaciones, String numCamas, String numBaños, String tipoPropiedad, String precioNoche, ArrayList<String> servicios) {
        this.Anfitrion = anfitrion;
        this.titulo = titulo;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.CP = CP;
        this.maxHuespedes = maxHuespedes;
        this.numHabitaciones = numHabitaciones;
        this.numCamas = numCamas;
        this.numBaños = numBaños;
        this.tipoPropiedad = tipoPropiedad;
        this.precioNoche = precioNoche;
        this.servicios = servicios;
    }

    // Getters y Setters
    public String getCorreoAnfitrion() {    
        return CorreoAnfitrion;
    }
    
    public void setAnfitrion(Anfitrion anfitrion){
        this.CorreoAnfitrion =  anfitrion.getCorreoElectronico();
        Anfitrion = anfitrion;
    }
    
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
    
    public String getNumero(){
        return numero;
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public String getCP(){
        return CP;
    }
    
    public void setCP(String CP){
        this.CP = CP;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getMaxHuespedes() {
        return maxHuespedes;
    }

    public void setMaxHuéspedes(String maxHuéspedes) {
        this.maxHuespedes = maxHuéspedes;
    }

    public String getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(String numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public String getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(String numCamas) {
        this.numCamas = numCamas;
    }

    public String getNumBaños() {
        return numBaños;
    }

    public void setNumBaños(String numBaños) {
        this.numBaños = numBaños;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public String getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(String precioNoche) {
        this.precioNoche = precioNoche;
    }

    public ArrayList<String> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<String> servicios) {
        this.servicios = servicios;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
    public ArrayList<String> getDireccion() {
        return direccion;
    }
    
    public String getDireccionAsString() {
        return String.join(", ", direccion);
    }

    public String getServiciosAsString() {
        return String.join(", ", servicios);
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
    
    // Método para actualizar la calificación basado en una nueva revisión
    public void actualizarCalificacion(double nuevaCalificacion) {
        this.calificacion = (this.calificacion + nuevaCalificacion) / 2; // Puede variar según cómo quieras calcular la media
    }
}
