package poo.javabnb;

import java.io.*;

public class ClienteParticular implements Serializable{
    
    //Atributos
    protected String dni;
    protected String nombre;
    protected String correoElectronico;
    protected String clave;
    protected String telefono;
    private static final long serialVersionUID = 1L;
    private boolean esVIP;
    
    public ClienteParticular(String dni, String nombre, String correo, String clave, String telefono, boolean esVIP){
        this.dni=dni;
        this.nombre=nombre;
        this.correoElectronico=correo;
        this.clave=clave;
        this.telefono=telefono;
        this.esVIP=esVIP;
    }
    
    //Métodos getters y setters
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
    
    public String getesVIP(){
        if(esVIP==true){
            return "Es VIP";
        }
        else{
            return "No es VIP";
        }
    }
    
    public boolean getVip(){
        return esVIP;
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
   
    public void setesVIP(boolean vip){
        this.esVIP = esVIP;
    }
    
    // Métodos específicos para ClienteParticular 
    public boolean cmpVIP(){
        return esVIP;   
    }
}
