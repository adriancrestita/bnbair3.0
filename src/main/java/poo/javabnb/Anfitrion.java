package poo.javabnb;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Anfitrion extends Usuario {

    
    
    //Atributos
    private String fechaRegistro; //LocalDate para el registro en hora actual
    private boolean esSuperAnfitrion;
    
    //Constructor
    public Anfitrion(String dni, String nombre, String correoElectronico, String clave, String telefono) {
        super(dni, nombre, correoElectronico, clave, telefono);
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
    
    public boolean getesSuperAnfitrion(){
        return esSuperAnfitrion;
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
    
    public void setFechaRegistro(){
        Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaActual = sdf.format(todayDate);
        this.fechaRegistro = fechaActual;
    }

    // Métodos específicos para Anfitrion
    
    public String cmpSuperAnfitrion(){
        if(esSuperAnfitrion == true){
            return "Es Super Anfitrion";
        }
        else{
            return "No es Super Anfitrion";
        }
    }
    public void guardarAnfitrion() {
        setFechaRegistro();
  
        String linea = getNombre() + "," + getDni() + "," + getCorreoElectronico() + "," + getClave() + "," + getTelefono() + "," + getFechaRegistro() + "," + cmpSuperAnfitrion() + "\n";
        try {
            FileWriter myWriter = new FileWriter("datos_anfitrion.txt", true); //el true activa el append
            myWriter.write(linea/*.getBytes(), StandardOpenOption.APPEND*/);
            myWriter.close();
          } 
        catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
          }
    }
}
