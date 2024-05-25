/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.javabnb;

import ManejoDatos.GestorValoraciones;

/**
 *
 * @author hugos
 */
public class ValoracionClienteInmueble {
    
    // Atributos de la clase
    public ClienteParticular cliente;
    public Inmueble inmueble;
    public int notaDada;
    public String reseña;
    
    public ValoracionClienteInmueble(ClienteParticular cliente, Inmueble inmueble, int notaDada, String reseña){
        this.cliente=cliente;
        this.inmueble=inmueble;
        this.notaDada=notaDada;
        this.reseña=reseña;
        
        GestorValoraciones.guardarValoraciones();
    }
    
}
