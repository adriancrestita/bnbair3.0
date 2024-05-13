/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDatos;

import java.util.ArrayList;
import poo.javabnb.ClienteParticular;

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
}

