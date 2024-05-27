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

    /**
     * Dado un objeto de cliente, añade el mismo a clientes.dat y lo guarda
     * @param cliente 
     */
    public void agregarCliente(ClienteParticular cliente) {
        if (cliente.getCorreoElectronico() == null || cliente.getCorreoElectronico().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede ser nulo o vacío");
        }
        else{
            clientes.add(cliente);
            guardarClientes(obtenerClientes());  
        }  
    }
    
    /**
     * 
     * @return de la lista de todos los objetos de clientes 
     */
    public List<ClienteParticular> obtenerClientes() {
        return clientes;
    }
    
    /**
     * Guarda los anfitriones en anfitriones.dat una vez proporcionada una List de anfitriones
     * @param array 
     */
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

    /**
     * Carga todos los clientes en el programa obteniendo los archivos desde clientes.dat
     */
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
    
    /**
     * Deserializa el .dat de clientes para poder trabajar con él directamente desde el .dat
     * @return la lista de Anfitriones
     * @throws IOException
     * @throws ClassNotFoundException 
     */
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
    
    /**
     * Método encargado de modificar un objeto de ClinteParticular ya existente en el .dat dado el objeto modificado y carga la lista modificada
     * @param correoOriginal
     * @param cliente
     * @return true/false para saber si se ha cumplido el proceso
     */
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
    
    /**
     * Método similar a modificar, pero que elimina directamente el objeto 
     * @param correo
     * @return lista de clientes actualizada para poder guardarlo posteriormente
     */
    public static List<ClienteParticular> eliminarCliente(String correo) {
        List<ClienteParticular> clientesMod = new ArrayList<>();
        try {
            clientesMod = deserializarUsuarios();

            for (int i = 0; i < clientesMod.size(); i++) {
                ClienteParticular cp = clientesMod.get(i);
                if (cp.getCorreoElectronico().equals(correo)) {
                    clientesMod.remove(i);
                    guardarClientes(clientesMod);
                    break;
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al eliminar el usuario: " + ex.getMessage());
        }
        return clientesMod;
    }
    
}
