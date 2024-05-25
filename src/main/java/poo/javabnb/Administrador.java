package poo.javabnb;

import java.util.*;
import java.io.*;

 public class Administrador {
    
    //Atributos
    private String correoElectronico;
    private String clave;
    
    //Constructor
    public Administrador(String correoElectronico, String clave) {
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }

    // Métodos getters y setters
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
