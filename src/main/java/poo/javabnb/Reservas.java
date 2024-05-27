package poo.javabnb;

import ManejoDatos.GestorAnfitrion;
import ManejoDatos.GestorClientes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Reservas {
    
    public String fechaEntrada;
    public String fechaSalida;
    
    
    public Anfitrion anfitrion;
    public GestorAnfitrion gestorAnfitrion;
    public GestorClientes gestorCliente;
    public ClienteParticular particular;
    public Inmueble inmueble;
    public TarjetaCredito tj;
    public int precioTotal;
    
    
    public Reservas(String correoAnfitrion, String correoCliente, Inmueble inmueble, String fechaEntrada, String fechaSalida, int precioTotal){
        gestorAnfitrion = new GestorAnfitrion();
        this.anfitrion=gestorAnfitrion.obtenerAnfitrion(correoAnfitrion);
        gestorCliente = new GestorClientes();
        this.particular = gestorCliente.obtenerCliente(correoCliente);
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioTotal = precioTotal;    
    }
    
    /**
     * Crea un archivo en descargas del usuario y en una carpeta interna en el programa con los datos de la reserva
     */
    public void generarFactura(){
        String informacionReserva = String.format(
            "Anfitrión: %s\nCliente: %s\nInmueble: %s\nFecha de Entrada: %s\nFecha de Salida: %s\nPrecio Total: %d\nTarjeta: %s",
            anfitrion.getNombre(), // Asumiendo que Anfitrion tiene un método getNombre()
            particular.getNombre(), // Asumiendo que ClienteParticular tiene un método getNombre()
            inmueble.mostrarInformacion(), // Asumiendo que Inmueble tiene un método getDescripcion()
            fechaEntrada,
            fechaSalida,
            precioTotal,
            ocultarTarjeta(tj.getNumeroTarjeta()) // Asumiendo que TarjetaCredito tiene un método getNumeroTarjeta()
        );

       // Crear la carpeta "reservas"
        File reservasDir = new File("reservas");
        if (!reservasDir.exists()) {
            reservasDir.mkdirs();
        }

        // Crear el archivo de reserva
        File reservaFile = new File(reservasDir, "reserva.txt");
        try (FileWriter writer = new FileWriter(reservaFile)) {
            writer.write(informacionReserva);
            System.out.println("Reserva guardada en: " + reservaFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getCorreoCliente(){
        return particular.getCorreoElectronico();
    }
    public String getCorreoAnfitrion(){
        return anfitrion.getCorreoElectronico();
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
