package poo.javabnb;

import java.io.*;

public class ClienteParticular extends Usuario {
    
    //Atributos
    private boolean esVIP;
    
    //Constructor
    public ClienteParticular(String dni, String nombre, String correoElectronico, String clave, String telefono, boolean esVIP) {
        super(dni, nombre, correoElectronico, clave, telefono);
        this.esVIP = esVIP;
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
    public void guardarParticular() {
        String linea = getNombre() + "," + getDni() + "," + getCorreoElectronico() + "," + getClave() + "," + getTelefono() + "," + getesVIP() + "\n";
        try {
            FileWriter myWriter = new FileWriter("datos_users.txt", true); //el true activa el append
            myWriter.write(linea/*.getBytes(), StandardOpenOption.APPEND*/);
            myWriter.close();
          } 
        catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
          }
    }
    
    

    public boolean cmpVIP(){
        return esVIP;   
    }
}
