package poo.javabnb;

import ManejoDatos.Deserializador;
import ManejoDatos.Serializador;
import java.io.*;

public class ClienteParticular extends Usuario implements Serializable{
    
    //Atributos
    private static final long serialVersionUID = 1L;
    private boolean esVIP;
    
    
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
