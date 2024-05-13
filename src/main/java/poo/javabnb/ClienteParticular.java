package poo.javabnb;

import ManejoDatos.Deserializador;
import ManejoDatos.Serializador;
import java.io.*;
import static poo.javabnb.MetodosAuxiliares.elementosPorDato;

public class ClienteParticular extends Usuario implements Serializable{
    
    //Atributos
    private static final long serialVersionUID = 1L;
    private boolean esVIP;
    
    //Constructor
     
    //Constructor por defecto para poder deserializar 
    public ClienteParticular() {
        // Llamar al constructor de Usuario con valores por defecto
        super();
        this.esVIP = false;  // Valor por defecto, asumir no VIP
    }
    
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
            myWriter.write(linea);
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
    
    public static void busquedaDatosCliente(String correo){
        try {
            String archivo = "datos_users.txt";
            String[] elementos = elementosPorDato(archivo, correo, 2);

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
}
