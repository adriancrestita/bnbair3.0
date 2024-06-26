package poo.javabnb;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Anfitrion implements Serializable{


    //Atributos
    protected String dni;
    protected String nombre;
    protected String correoElectronico;
    protected String clave;
    protected String telefono;
    private static final long serialVersionUID = 1L;
    private String fechaRegistro; //LocalDate para el registro en hora actual
    private boolean esSuperAnfitrion = false;
    
    //Constructor
    public Anfitrion(String dni, String nombre, String correoElectronico, String clave, String telefono, String fechaRegistro, boolean esSuperAnfitrion) {
        this.dni=dni;
        this.nombre=nombre;
        this.correoElectronico=correoElectronico;
        this.clave=clave;
        this.telefono=telefono;
        this.fechaRegistro = fechaRegistro;
        this.esSuperAnfitrion=esSuperAnfitrion;
    }
    
    
    
    //Getters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String getFechaRegistro(){
        return fechaRegistro;
    }
    
    public boolean getEsSuperAnfitrion(){
        return esSuperAnfitrion;
    }
    public void setEsSuperAnfitrion(){
         this.esSuperAnfitrion = true;
    }
    
    
    // Setters
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setFechaRegistro(String fechaActual){
        
        this.fechaRegistro = fechaActual;
    }
    // Métodos específicos para Anfitrion
    
    /**
     * comprueba si es superAnfitrion o no
     * @return String mostrando si es super anfitrion o no
     */
    public String cmpSuperAnfitrion(){
        if(esSuperAnfitrion == true){
            return "Super Anfitrion";
        }
        else{
            return "No Super Anfitrion";
        }
    }
}
