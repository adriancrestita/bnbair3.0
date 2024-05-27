/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.javabnb;

import ManejoDatos.GestorValoraciones;
import java.io.Serializable;

/**
 *
 * @author hugos
 */
public class Valoracion implements Serializable{

    private static final long serialVersionUID = 1L;

    // Atributos de la clase
    public ClienteParticular cliente;
    public Inmueble inmueble;
    public int nota;
    public String reseña;
    public GestorValoraciones gestorValoraciones;
    
    public Valoracion(ClienteParticular cliente, Inmueble inmueble, int nota, String reseña){
        this.cliente=cliente;
        this.inmueble=inmueble;
        this.nota=nota;
        this.reseña=reseña;
    }
    
    //getters y setters
    public ClienteParticular getCliente(){
        return cliente;
    }
    public Inmueble getInmueble(){
        return inmueble;
    }
    public int getNota(){
        return nota;
    }
    public String getReseña(){
        return reseña;
    }
    public String getCorreoCliente(){
        return cliente.getCorreoElectronico();
    }
    public String getCorreoAnfitrion(){
        return inmueble.getCorreoAnfitrion();
    }
}
