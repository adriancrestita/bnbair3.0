package poo.javabnb;

import AccesosPrincipales.FrameInicio;
import AccesosPrincipales.FrameRegistro;
import java.io.*; 
import java.util.*;
 
public class Javabnb {
    
    private Administrador administrador;
    
    public Javabnb() {
        this.administrador = new Administrador("admin@javabnb.com", "admin");
    }
    
    public static void main(String[] args) throws IOException {      
        FrameInicio fi = new FrameInicio();
        fi.setVisible(true);
    }

    public boolean autenticarAdmin(String correo, String clave) {
        return administrador.getCorreoElectronico().equals(correo) && administrador.getClave().equals(clave);
    }
    
   
}
