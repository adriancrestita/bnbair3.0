/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDatos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import poo.javabnb.Anfitrion;
import poo.javabnb.ClienteParticular;
import static poo.javabnb.MetodosAuxiliares.esCorreo;
import static poo.javabnb.MetodosAuxiliares.esDni;
import static poo.javabnb.MetodosAuxiliares.esFechaCaducidadValida;
import static poo.javabnb.MetodosAuxiliares.xLongitud;

/**
 *
 * @author crestas
 */
public class VerificarDatos {
    
    private static GestorClientes gestorClientes;
    private static GestorAnfitrion gestorAnfitrion;
    private static final String CLIENTES_FILENAME = "clientes.dat";
    private static final String ANFITRIONES_FILENAME = "anfitriones.dat";

    public VerificarDatos() {
        gestorClientes = new GestorClientes();
        gestorAnfitrion = new GestorAnfitrion();
        
    }

    /**
     * Verificar registro de Cliente
     * @param email
     * @return boolean
     * @throws IOException 
     */
    public static boolean verificarCorreoCliente(String email)throws IOException {
        for (ClienteParticular cliente : gestorClientes.obtenerClientes()) {
            if (cliente.getCorreoElectronico().equals(email)) {
                return false; // Email ya registrado
            }
        }
        return true; // Email disponible
    }

    /**
     * Verificar registro de Anfitrion
     * @param email
     * @return boolean
     * @throws IOException 
     */
    public static boolean verificarCorreoAnfitrion(String email)throws IOException {
        for (Anfitrion anfitrion : gestorAnfitrion.obtenerAnfitriones()) {
            if (anfitrion.getCorreoElectronico().equals(email)) {
                return false; // Email ya registrado
            }
        }
        return true; // Email disponible
    }

    /**
     * Iniciar sesion cliente
     * @param email
     * @param password
     * @return Cliente
     */
    public static ClienteParticular iniciarSesionCliente(String email, String password) {
        List<ClienteParticular> clientes = leerDatos(CLIENTES_FILENAME);
        for (ClienteParticular cliente : clientes) {
            if (cliente.getCorreoElectronico().equals(email) && cliente.getClave().equals(password)) {
                return cliente; // Inicio de sesión exitoso
            }
        }
        return null; // Credenciales incorrectas
    }
    
    /**
     * Iniciar sesion Anfitrion
     * @param email
     * @param password
     * @return Anfitrion
     */
    public static Anfitrion iniciarSesionAnfitrion(String email, String password) {
        List<Anfitrion> anfitriones = leerDatos(ANFITRIONES_FILENAME);
        for (Anfitrion anfitrion : anfitriones) {
            if (anfitrion.getCorreoElectronico().equals(email) && anfitrion.getClave().equals(password)) {
                return anfitrion; // Inicio de sesión exitoso
            }
        }
        return null; // Credenciales incorrectas
    }

    /**
     * Método genérico para leer datos de un archivo .dat
     * @param <T>
     * @param filename
     * @return List
     */
    private static <T> List<T> leerDatos(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, return empty list
            return List.of();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return List.of();
        }
    }
    
    /**
     * Método que valida si la tarjeta del usuario es valida (longitudes y fecha caducidad posterior a la actual)
     * @param titularTarjeta
     * @param numeroTarjeta
     * @param fechaCaducidad
     * @return boolean
     * @throws IOException 
     */
    public boolean validarTarjeta(String titularTarjeta, String numeroTarjeta, String fechaCaducidad) throws IOException {        
        // Validar que los campos no están vacíos ni tienen el texto por defecto
        if (titularTarjeta.isEmpty() || titularTarjeta.equals("Ingrese el nombre del titular") ||
            numeroTarjeta.isEmpty() || numeroTarjeta.equals("Ingrese el número de tarjeta") ||
            fechaCaducidad.isEmpty() || fechaCaducidad.equals("Ingrese la fecha de caducidad")) {
            return false;
        }

        // Verificar cada campo con sus respectivas funciones de validación
        if((xLongitud(numeroTarjeta, 16) && esFechaCaducidadValida(fechaCaducidad)) == true){
            return true;
        }  
        else{
            JOptionPane.showMessageDialog(null, "Los datos introducidos no son validos");
            return false;
        }
    }
    
    /**
     * Método que verifica si los daos introducidos en un registro son validos para cliente/anfitrion
     * @param correo
     * @param nombre
     * @param contraseña
     * @param telefono
     * @param dni
     * @param tipo
     * @return boolean
     * @throws IOException 
     */
    public boolean validarRegistro(String correo, String nombre, String contraseña, String telefono, String dni, String tipo) throws IOException {        
        // Validar que los campos no están vacíos ni tienen el texto por defecto
        if (correo.isEmpty() || correo.equals("Ingrese el correo") ||
            nombre.isEmpty() || nombre.equals("Ingrese el nombre") ||
            contraseña.isEmpty() || contraseña.equals("Introduce la contraseña") ||
            telefono.isEmpty() || telefono.equals("Ingrese el teléfono") ||
            dni.isEmpty() || dni.equals("Ingrese el DNI")) {
            return false;
        }

        // Verificar cada campo con sus respectivas funciones de validación
        if("Anfitrión".equals(tipo)){
            if(verificarCorreoAnfitrion(correo) == true){
                if((esCorreo(correo) && xLongitud(telefono, 9) && esDni(dni)) == true){
                        return true;
                }

                else{
                    JOptionPane.showMessageDialog(null, "Los datos introducidos no son válidos");
                    return false;
                }    
            }

            else{
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
                return false;
            }    
        }
        if("Cliente".equals(tipo)){
            if(verificarCorreoCliente(correo) == true){
                if((esCorreo(correo) && xLongitud(telefono, 9) && esDni(dni)) == true){
                        return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Los datos introducidos no son válidos");
                    return false;
                }    
            }
            else{
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
                return false;
            }    
        }
        else{
            return false;
        }  
    }
    
    /**
     * Método que valida si los datos introducidos en un inmueble son correctos
     * @param titulo
     * @param calle
     * @param numero
     * @param cp
     * @param ciudad
     * @param precio
     * @return boolean
     */
    public static boolean validarInmueble(String titulo, String calle, String numero, String cp, String ciudad, String precio){
        if (titulo.isEmpty() || titulo.equals("Ingrese el titulo") ||
            numero.isEmpty() || numero.equals("Ingrese el numero") ||
            calle.isEmpty() || calle.equals("Introduce la calle") ||
            ciudad.isEmpty() || ciudad.equals("Ingrese la ciudad") ||
            precio.isEmpty() || precio.equals("") ||
            cp.isEmpty() || cp.equals("Ingrese el C.P.")) {
            return false;
        }
        else{
            if(Integer.parseInt(numero)>0 && cp.length()==5 && Integer.parseInt(precio)>0){
                return true;
            }
        }
        return false;
    }
}

