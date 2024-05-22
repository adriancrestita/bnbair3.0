package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import poo.javabnb.ClienteParticular;

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

    private void cargarClientes() {
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
    
    public void eliminarCliente(String correo) {
        if (correo == null || correo.isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede ser nulo o vacío");
        } else {
            boolean removed = clientes.removeIf(cliente -> cliente.getCorreoElectronico().equals(correo));
            if (removed) {
                guardarClientes();
                cargarClientes();
                System.out.println("Cliente eliminado con éxito.");
            } else {
                System.out.println("No se encontró un cliente con el correo especificado.");
            }
        }
    }
    
    public ClienteParticular obtenerCliente(String correo) {
        cargarClientes(); // Asegúrate de cargar los datos más recientes
        for (ClienteParticular cliente : clientes) {
            if (cliente.getCorreoElectronico().equals(correo)) {
                return cliente;
            }
        }
        return null; // Retornar null si no se encuentra el cliente
    }
    
    public void modificarCliente(String correo, ClienteParticular nuevoCliente) {
        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCorreoElectronico().equals(correo)) {
                clientes.set(i, nuevoCliente);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            guardarClientes();
            cargarClientes();
            System.out.println("Cliente modificado con éxito.");
        } else {
            System.out.println("No se encontró un cliente con el correo especificado.");
        }
    }
}