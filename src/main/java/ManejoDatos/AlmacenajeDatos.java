package ManejoDatos;

import java.io.IOException;
import poo.javabnb.ClienteParticular;
import poo.javabnb.TarjetaCredito;

public class AlmacenajeDatos {
    
    public static void guardarParticular(String dni, String nombre, String correo, String contraseña, String telefono, boolean VIP, String titular, String numtarj, String fcad) { //este metodo de guardado es utilizando la serialización de objetos
        ClienteParticular cliente = new ClienteParticular(dni, nombre, correo, contraseña, telefono, VIP);
        TarjetaCredito datosBancarios = new TarjetaCredito(titular, numtarj, fcad);

        
        Serializador serializador = new Serializador();
        Deserializador deserializador = new Deserializador();

        try {
            serializador.guardarCliente(cliente, "cliente.dat");
            serializador.guardarDatosBancarios(datosBancarios, "datosBancarios.dat");

            ClienteParticular clienteLeido = (ClienteParticular) deserializador.leerCliente("cliente.dat");
            TarjetaCredito datosBancariosLeidos = (TarjetaCredito) deserializador.leerDatosBancarios    ("datosBancarios.dat");

            // Utilizar clienteLeido y datosBancariosLeidos como necesites
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
