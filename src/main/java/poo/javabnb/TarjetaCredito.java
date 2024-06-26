package poo.javabnb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;


public class TarjetaCredito implements Serializable{
    
    //Atributos
    private static final long serialVersionUID = 1L;
    private String nombreTitular;
    private String numeroTarjeta;
    private String fechaCaducidad;
    private String correo;
    
    //Constructor
    public TarjetaCredito(String correo, String nombreTitular, String numeroTarjeta, String fechaCaducidad) {
        this.correo = correo;
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
    }
    
    // Getters y setters
    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }  
}
