package ManejoDatos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import poo.javabnb.ClienteParticular;
import poo.javabnb.Inmueble;


public class GestorFacturas {
    
    public GestorFacturas(){
    
    }  
    
    public void generarFactura(String fechaReserva, int importe, Inmueble inmueble, ClienteParticular cliente, String fechaEntrada, String fechaSalida){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/Facturas/factura_" + cliente.getNombre() + "_" + inmueble.getTitulo() + ".txt"))) {
            writer.write("Factura\n");
            writer.write("========\n");
            writer.write("Fecha de Reserva: " + fechaReserva + "\n");
            writer.write("Fecha de Entrada: " + fechaEntrada + "\n");
            writer.write("Fecha de Salida: " + fechaSalida + "\n");
            writer.write("Importe: " + importe + " €\n");
            writer.write("========\n");
            writer.write("\nDatos del Cliente:\n");
            writer.write("DNI: " + cliente.getDni() + "\n");
            writer.write("Nombre: " + cliente.getNombre() + "\n");
            writer.write("Correo Electrónico: " + cliente.getCorreoElectronico() + "\n");
            writer.write("Teléfono: " + cliente.getTelefono() + "\n");
            writer.write("VIP: " + (cliente.cmpVIP() ? "Sí" : "No") + "\n");
            writer.write("========\n");  
            writer.write("\nDatos del Inmueble:\n");
            writer.write("Correo del Anfitrión: " + inmueble.getCorreoAnfitrion() + "\n");
            writer.write("Título: " + inmueble.getTitulo() + "\n");
            writer.write("Dirección: " + String.join(", ", inmueble.getDireccion()) + "\n");
            writer.write("Máximo de Huéspedes: " + inmueble.getMaxHuespedes() + "\n");
            writer.write("Número de Habitaciones: " + inmueble.getNumHabitaciones() + "\n");
            writer.write("Número de Camas: " + inmueble.getNumCamas() + "\n");
            writer.write("Número de Baños: " + inmueble.getNumBaños() + "\n");
            writer.write("Tipo de Propiedad: " + inmueble.getTipoPropiedad() + "\n");
            writer.write("Precio por Noche: " + inmueble.getPrecioNoche() + " EUR\n");
            writer.write("Servicios: " + String.join(", ", inmueble.getServicios()) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}
