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

//    public List<Object[]> obtenerTodosLosUsuarios() {
//        cargarDatos();
//        
//        List<ClienteParticular> cp = new ArrayList<>();
//        for (ClienteParticular cliente : clientes) {
//            String numeroTarjeta = gestorTarjetas.obtenerNumeroTarjeta(cliente.getCorreoElectronico());
//            cp.add(cliente);
////            usuarios.add(new Object[]{
////                "Cliente", cliente.getNombre(), cliente.getCorreoElectronico(),
////                cliente.getTelefono(), cliente.getDni(), numeroTarjeta, cliente.cmpVIP() ? "VIP" : "No VIP", ""
////            });
//        }
//
//        List<Anfitrion> anf = new ArrayList<>();
//        for (Anfitrion anfitrion : anfitriones) {
//            String numeroTarjeta = gestorTarjetas.obtenerNumeroTarjeta(anfitrion.getCorreoElectronico());
//            anf.add(anfitrion);
////            anf.add(new Object[]{
////                "Anfitrion", anfitrion.getNombre(), anfitrion.getCorreoElectronico(),
////                anfitrion.getTelefono(), anfitrion.getDni(), numeroTarjeta,anfitrion.cmpSuperAnfitrion(), anfitrion.getFechaRegistro()
////            });
//        }
//        
//        List<Object[]> objetos = new ArrayList<>();
//        objetos.addAll(cp);
//        return usuarios;
//    }
}
