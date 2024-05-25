package ManejoDatos;

import java.util.ArrayList;
import java.util.List;
import poo.javabnb.ClienteParticular;
import poo.javabnb.Anfitrion;
import poo.javabnb.TarjetaCredito;

public class GestorUsuarios {
    private  List<ClienteParticular> clientes;
    private  List<Anfitrion> anfitriones;
    private  List<TarjetaCredito> tarjetas;
    private static GestorTarjetas gestorTarjetas;

    public GestorUsuarios() {
        clientes = new ArrayList<>();
        anfitriones = new ArrayList<>();
        tarjetas = new ArrayList<>();
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
        tarjetas.addAll(gestorTarjetas.obtenerTarjetas());
    }
}
