/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDatos;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    public static boolean verificarInicioSesion(String correoIntroducido, String contraseñaIntroducida) {
        ArrayList<ClienteParticular> clientes = Deserializador.leerClientes();
        for (ClienteParticular cliente : clientes) {
            if (cliente.getCorreoElectronico().equals(correoIntroducido) && cliente.getClave().equals(contraseñaIntroducida)) {
                return true; // Credenciales correctos
            }
        }
        return false; // Credenciales incorrectos
    }
    
    public boolean validarRegistro(String correo, String nombre, String contraseña, String telefono, String dni, String titularTarjeta, String numeroTarjeta, String fechaCaducidad, boolean esVIP) throws IOException {        
        // Validar que los campos no están vacíos ni tienen el texto por defecto
        if (correo.isEmpty() || correo.equals("Ingrese el correo") ||
            nombre.isEmpty() || nombre.equals("Ingrese el nombre") ||
            contraseña.isEmpty() || contraseña.equals("Introduce la contraseña") ||
            telefono.isEmpty() || telefono.equals("Ingrese el teléfono") ||
            dni.isEmpty() || dni.equals("Ingrese el DNI") ||
            titularTarjeta.isEmpty() || titularTarjeta.equals("Ingrese el nombre del titular") ||
            numeroTarjeta.isEmpty() || numeroTarjeta.equals("Ingrese el número de tarjeta") ||
            fechaCaducidad.isEmpty() || fechaCaducidad.equals("Ingrese la fecha de caducidad")) {
            return false;
        }

        // Verificar cada campo con sus respectivas funciones de validación
        if 
        if((esCorreo(correo) && xLongitud(telefono, 9) && esDni(dni) && xLongitud(numeroTarjeta, 16) && esFechaCaducidadValida(fechaCaducidad)) == true){
            /*if(existeCliente(correo) == false){
                return true;
            }
            
            else{
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
                return false;
            }*/
        }  
        else{
            JOptionPane.showMessageDialog(null, "Los datos introducidos no son validos");
            return false;
        }
    }
}

