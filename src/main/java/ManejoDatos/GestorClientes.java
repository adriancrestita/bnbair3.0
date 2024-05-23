package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import poo.javabnb.ClienteParticular;
import poo.javabnb.Sesion;

public class GestorClientes {
    private static List<ClienteParticular> clientes;
    private final String FILENAME = "clientes.dat";
    
    public GestorClientes() {
        clientes = new ArrayList<>();
        cargarClientes();
    }

    public void agregarCliente(ClienteParticular cliente) {
        if (cliente.getCorreoElectronico() == null || cliente.getCorreoElectronico().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede ser nulo o vacío");
        }
        else{
            clientes.add(cliente);
            guardarClientes();  
        }  
    }

    public List<ClienteParticular> obtenerClientes() {
        return clientes;
    }

    private void guardarClientes() {
       try{
           FileOutputStream fos = new FileOutputStream("clientes.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(clientes);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }        
    }

    public static void cargarClientes() {
        try{
            FileInputStream fis = new FileInputStream("clientes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();

            if(obj instanceof List) {
                List tempList = (List) obj;
                tempList.stream().forEach(object -> {
                    if(object instanceof ClienteParticular) {
                        clientes.add((ClienteParticular) object);
                    }
                });
            }
        }catch(Exception e){
            System.out.println(e);
        }    
    }
    
    public ClienteParticular obtenerCliente(String correo) {
        cargarClientes(); // Se asegura de cargar los datos más recientes
        for (ClienteParticular cliente : clientes) {
            if (cliente.getCorreoElectronico().equals(correo)) {
                return cliente;
            }
        }
        return null; // Retornar null si no se encuentra el cliente
    }
    
    public void actualizarClientes(){
        
    }
    public boolean modificarCliente(String correo, ClienteParticular clienteActualizado) {
        cargarClientes(); // Asegúrate de cargar los datos más recientes
        ClienteParticular cliente = obtenerCliente(correo);
        cliente.setClave(clienteActualizado.getClave());
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setCorreoElectronico(clienteActualizado.getCorreoElectronico());
        cliente.setTelefono(clienteActualizado.getTelefono());
        cliente.setesVIP(clienteActualizado.cmpVIP());
        guardarClientes();
        imprimirClientes();
        /*for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCorreoElectronico().equals(correo)) {
                clientes.set(i, clienteActualizado);
                guardarClientes();
                
                //En caso de cambiar el correo actualiza el correo del usuario que ha iniciado sesion
                Sesion.iniciarSesion(clienteActualizado.getCorreoElectronico());
                
                return true; // Cliente actualizado
            }
        }*/
        return true; // Cliente no encontrado
    }
    public void imprimirClientes() {
        for (ClienteParticular cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Correo Electrónico: " + cliente.getCorreoElectronico());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("VIP: " + (cliente.cmpVIP() ? "Sí" : "No"));
            System.out.println("-----------------------------");
        }
    }
}
