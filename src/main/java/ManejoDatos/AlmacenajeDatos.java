package ManejoDatos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import poo.javabnb.ClienteParticular;
import poo.javabnb.TarjetaCredito;

public class AlmacenajeDatos {
    
    public static void guardarParticular(String dni, String nombre, String correo, String contraseña, String telefono, boolean VIP, String titular, String numtarj, String fcad) { //este metodo de guardado es utilizando la serialización de objetos
        ClienteParticular cliente = new ClienteParticular(dni, nombre, correo, contraseña, telefono, VIP);
        TarjetaCredito datosBancarios = new TarjetaCredito(correo, titular, numtarj, fcad);

        
        Serializador serializador = new Serializador();

        try {
            serializador.guardarCliente(cliente, "cliente.dat");
            serializador.guardarDatosBancarios(datosBancarios, "datosBancarios.dat");
            
            // Utilizar clienteLeido y datosBancariosLeidos como necesites
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    
    public static void imprimirClientes(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            while (true) {
                ClienteParticular cliente = (ClienteParticular) ois.readObject();
                System.out.println("Cliente: " + cliente.getNombre() + ", Email: " + cliente.getCorreoElectronico() +
                                   ", DNI: " + cliente.getDni() + ", Teléfono: " + cliente.getTelefono() +
                                   ", VIP: " + (cliente.cmpVIP() ? "Sí" : "No"));
            }
        } catch (EOFException e) {
            // Esta excepción se lanza cuando se alcanza el final del archivo.
            System.out.println("Fin de la lista de clientes.");
        } catch (Exception e) {
            // Maneja otras posibles excepciones como ClassNotFoundException o IOException.
            e.printStackTrace();
        }
    }
    
    /*
                    particular.setDni(jdni.getText().trim());
                    particular.setNombre(jnombre.getText().trim());
                    particular.setCorreoElectronico(jmailsign.getText().trim());
                    particular.setClave(String.valueOf(jpasswordsign.getText().trim()));
                    particular.setTelefono(jphonenumber.getText().trim());
                    particular.setesVIP(jAnfitrion.isSelected());

                    tj.setFechaCaducidad(jfcaducidad.getText().trim());
                    tj.setNombreTitular(jtitular.getText().trim());
                    tj.setNumeroTarjeta(jnumtarj.getText().trim());

    */
}
