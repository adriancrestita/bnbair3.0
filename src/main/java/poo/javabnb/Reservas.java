package poo.javabnb;

import ManejoDatos.GestorAnfitrion;
import ManejoDatos.GestorClientes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.List;

public class Reservas implements Serializable{
    
    private static final long serialVersionUID = 1L;

    
    public String fechaEntrada;
    public String fechaSalida;
    
    
    public Anfitrion anfitrion;
    public GestorAnfitrion gestorAnfitrion;
    public GestorClientes gestorCliente;
    public ClienteParticular particular;
    public Inmueble inmueble;
    public TarjetaCredito tj;
    public int precioTotal;
    private String fechaReserva;
    
    
    
    public Reservas(String fechaReserva, int precioTotal, Inmueble inmueble, ClienteParticular cliente, String fechaEntrada, String fechaSalida){
        this.anfitrion=anfitrion;
        gestorCliente = new GestorClientes();
        this.particular = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioTotal = precioTotal;  
        this.inmueble = inmueble;
        this.fechaReserva = fechaReserva;
    }
    
    
    public String getCorreoCliente(){
        return particular.getCorreoElectronico();
    }
    public String getCorreoAnfitrion(){
        return anfitrion.getCorreoElectronico();
    }
    
    public String getTituloInmueble(){
        return inmueble.getTitulo();
    }
    public Inmueble getInmueble(){
        return inmueble;
    }
    
    public String getFechaReserva(){
        return fechaReserva;
    }
    
    public String getPrecioTotal(){
        return String.valueOf(precioTotal);
    }
    
    public String getFechaEntrada(){
        return fechaEntrada;
    }
    public String getFechaSalida(){
        return fechaSalida;
    }
    
    private String ocultarTarjeta(String numeroTarjeta) {
        if (numeroTarjeta.length() != 16) {
            throw new IllegalArgumentException("El número de tarjeta debe tener exactamente 16 dígitos.");
        }
        String asteriscos = "************";
        String ultimosCuatroDigitos = numeroTarjeta.substring(12);
        return asteriscos + ultimosCuatroDigitos;
    }
}
