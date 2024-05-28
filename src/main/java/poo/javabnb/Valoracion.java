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
    private ClienteParticular cliente;
    private Inmueble inmueble;
    private int nota;
    private GestorValoraciones gestorValoraciones;
    
    public Valoracion(ClienteParticular cliente, Inmueble inmueble, int nota){
        this.cliente=cliente;
        this.inmueble=inmueble;
        this.nota=nota;
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
    
    public String getCorreoCliente(){
        return cliente.getCorreoElectronico();
    }
    public String getCorreoAnfitrion(){
        return inmueble.getCorreoAnfitrion();
    }
}
