package ManejoDatos;

import java.util.ArrayList;
import java.util.List;
import poo.javabnb.ClienteParticular;
import poo.javabnb.Anfitrion;

public class GestorUsuarios {
    private static List<ClienteParticular> clientes;
    private static List<Anfitrion> anfitriones;
    private static GestorTarjetas gestorTarjetas;

    public GestorUsuarios() {
        clientes = new ArrayList<>();
        anfitriones = new ArrayList<>();
        gestorTarjetas = new GestorTarjetas();

        cargarDatos();
    }

    public List<ClienteParticular> getClientes() {
        return clientes;
    }

    public List<Anfitrion> getAnfitriones() {
        return anfitriones;
    }

    private void cargarDatos() {
        GestorClientes gestorClientes = new GestorClientes();
        GestorAnfitrion gestorAnfitrion = new GestorAnfitrion();

        clientes.addAll(gestorClientes.obtenerClientes());
        anfitriones.addAll(gestorAnfitrion.obtenerAnfitriones());
    }

    public static List<Object[]> obtenerTodosLosUsuarios() {
        List<Object[]> usuarios = new ArrayList<>();

        for (ClienteParticular cliente : clientes) {
            String numeroTarjeta = gestorTarjetas.obtenerNumeroTarjeta(cliente.getCorreoElectronico());
            usuarios.add(new Object[]{
                "Cliente", cliente.getNombre(), cliente.getCorreoElectronico(),
                cliente.getTelefono(), cliente.getDni(), numeroTarjeta, cliente.cmpVIP() ? "VIP" : "No VIP", ""
            });
        }

        for (Anfitrion anfitrion : anfitriones) {
            String numeroTarjeta = gestorTarjetas.obtenerNumeroTarjeta(anfitrion.getCorreoElectronico());
            usuarios.add(new Object[]{
                "Anfitrion", anfitrion.getNombre(), anfitrion.getCorreoElectronico(),
                anfitrion.getTelefono(), anfitrion.getDni(), numeroTarjeta,anfitrion.cmpSuperAnfitrion(), anfitrion.getFechaRegistro()
            });
        }

        return usuarios;
    }
}
