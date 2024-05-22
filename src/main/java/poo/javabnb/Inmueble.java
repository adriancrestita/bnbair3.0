package poo.javabnb;

import java.io.*;
import java.io.Serializable;
import java.util.*;

public class Inmueble implements Serializable{
    
    //Atributos
    private static final long serialVersionUID = 1L;
    private String correoAnfitrion;
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

    private int numCalif;
    private Anfitrion anfi;
    
    // Constructor
    public Inmueble(String correoAnfitrion, String titulo, ArrayList<String> direccion, String maxHuespedes, String numHabitaciones, String numCamas, String numBaños, String tipoPropiedad, String precioNoche, ArrayList<String> servicios, ArrayList<String> imagePaths) {
        this.correoAnfitrion = correoAnfitrion;
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
        this.numCalif=0;
        //Separar la información de la dirección
        this.calle=direccion.get(0);
        this.numero=direccion.get(1);
        this.ciudad=direccion.get(2);
        this.CP=direccion.get(3);
        
    }
    
    

    // Getters y Setters
    public String getCorreoAnfitrion() {    
        return correoAnfitrion;
    }
//    
//    public void setAnfitrion(Anfitrion anfitrion){
//        this.CorreoAnfitrion =  anfitrion.getCorreoElectronico();
//        Anfitrion = anfitrion;
//    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCalle() {
        if (calle==null){
            this.calle=direccion.get(0);
        }
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    public String getNumero(){
        if (numero==null){
            this.numero=direccion.get(1);
        }
        return numero;
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public String getCP(){
        if (CP==null){
            this.CP=direccion.get(3);
        }
        return CP;
    }
    
    public void setCP(String CP){
        this.CP = CP;
    }
    
    public String getCiudad(){
        if (ciudad==null){
            this.ciudad=direccion.get(2);
        }
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
        this.calificacion=calificacion;
    }
    
    public int getNumCalif(){
        return numCalif;
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
    
    public Anfitrion getAnfi(){
        return anfi;
    }
    
    //Otros métodos de utilidad
    private void verificarDireccion(){
        this.calle=direccion.get(0);
        this.numero=direccion.get(1);
        this.ciudad=direccion.get(2);
        this.CP=direccion.get(3);
    }
    
    public String direccionToString(){
        if((calle==null)||(numero==null)||(CP==null)||(ciudad==null)){
            verificarDireccion();
        }
        return calle+" "+numero+", "+ciudad+" "+CP;
    }
    
    // Método para mostrar información del inmueble
    public String mostrarInformacion() {
        
        if((calle==null)||(numero==null)||(CP==null)||(ciudad==null)){
            verificarDireccion();
        }
        
        return "\nInmueble: " + titulo +
        "\nDirección: " + calle + " " + numero + ", " + CP + ", " + ciudad +
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
    public void actualizarCalificacion(double calificacionNew) {
        this.calificacion = ((calificacion*numCalif)+calificacionNew)/(numCalif++); //hace la media aritmética de todas las calificaciones
        numCalif ++;
    }
}
