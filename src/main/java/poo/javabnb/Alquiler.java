package poo.javabnb;

import java.time.*;
import java.io.*;
import java.time.format.*;
        
public class Alquiler {
    private ClienteParticular cliente;
    private Inmueble inmueble;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double costoTotal;
    private boolean esVIP;

    public Alquiler(ClienteParticular cliente, Inmueble inmueble, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.cliente = cliente;
        this.inmueble = inmueble;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.esVIP = cliente.cmpVIP();
        calcularCostoTotal();
    }
    
    /**
     * Calcula el costo total de la estancia y aplica un descuento si el cliente es vip
     */
    private void calcularCostoTotal() {
        int diasEstancia = fechaEntrada.until(fechaSalida).getDays();
        costoTotal = diasEstancia * Integer.parseInt(inmueble.getPrecioNoche());
        if (esVIP) {
            costoTotal *= 0.9; // Descuento del 10% para clientes VIP
        }
    }
    
    /**
     * Genera una factura con los datos acerca del alquiler
     * @return String con la información del alquiler
     */
    public String generarFactura() {
        return "Fecha de Reserva: " + LocalDate.now() +
                "\nCliente: " + cliente.getNombre() +
                "\nInmueble: " + inmueble.mostrarInformacion() +
                "\nFecha de Entrada: " + fechaEntrada +
                "\nFecha de Salida: " + fechaSalida +
                "\nCosto Total: $" + costoTotal;
    }
    
    /**
     * crea el archivo de la factura
     */
    public void archivoFactura(){
        String nombreArchivo = "factura_reserva_"+cliente.getNombre()+"_"+LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + ".txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(generarFactura());
            System.out.println("Factura guardada en: " + nombreArchivo);
        } 
        
        catch (IOException e) {
            System.out.println("Error al escribir la factura en el archivo.");
            e.printStackTrace();
        }
    }
    
    // Getters para acceso a los campos si se necesitan en otras partes del sistema
    public ClienteParticular getCliente() {
        return cliente;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public double getCostoTotal() {
        return costoTotal;
    }
}
