package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import poo.javabnb.ClienteParticular;
import poo.javabnb.Sesion;

public class GestorClientes {
    private List<ClienteParticular> clientes;
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
    
    private static void guardarClientes(List<ClienteParticular> array) {
       try{
           FileOutputStream fos = new FileOutputStream("clientes.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(array);
           oos.close();
       }catch(Exception e){
           System.out.println(e);
       }        
    }


    public void cargarClientes() {
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
    
    public static List<ClienteParticular> deserializarUsuarios() throws IOException, ClassNotFoundException {
        File file = new File("clientes.dat");
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            return (List<ClienteParticular>) ois.readObject();
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
    
    public static boolean modificarCliente(String correoOriginal, ClienteParticular cliente) {
        try {
            List<ClienteParticular> clientesMod = deserializarUsuarios();

            for (int i = 0; i < clientesMod.size(); i++) {
                ClienteParticular cp = clientesMod.get(i);
                if (cp.getCorreoElectronico().equals(correoOriginal)) {
                    clientesMod.set(i, cliente);
                    guardarClientes(clientesMod);
                    return true; //cliente actualizado
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al modificar el usuario: " + ex.getMessage());
        }
        return false;
    }
    
    public static void eliminarCliente(String correo) {
        try {
            List<ClienteParticular> clientesMod = deserializarUsuarios();

            for (int i = 0; i < clientesMod.size(); i++) {
                ClienteParticular cp = clientesMod.get(i);
                if (cp.getCorreoElectronico().equals(correo)) {
                    clientesMod.remove(i);
                    guardarClientes(clientesMod);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar el usuario: " + ex.getMessage());
        }
    }
}