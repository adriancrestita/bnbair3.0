package poo.javabnb;

import ManejoDatos.GestorAnfitrion;

public class Sesion {
    // Atributo estático para mantener el correo del usuario que ha iniciado sesión
    private static String correoUsuario;

    // Método para iniciar sesión y guardar el correo del usuario
    public static void iniciarSesion(String correo) {
        correoUsuario = correo;
    }

    // Método para obtener el correo del usuario que ha iniciado sesión
    public static String obtenerCorreoUsuario() {
        return correoUsuario;
    }
}