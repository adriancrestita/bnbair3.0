package ManejoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
}