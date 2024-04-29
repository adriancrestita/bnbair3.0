package poo.javabnb;

import java.io.IOException;

public class MetodosAuxiliares {
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

    public MetodosAuxiliares(){
        
    }
    public boolean esDni(String dni){
        if (dni == null || dni.length() != 9) {
            return false;
        }

        String parteNumerica = dni.substring(0, 8);
        char letra = dni.charAt(8);
        if (!parteNumerica.matches("\\d{8}")) {  // Comprueba si la parte numérica son exactamente 8 dígitos.
            return false;
        }

        int indice = Integer.parseInt(parteNumerica) % 23;
        return LETRAS_DNI.charAt(indice) == letra;
    }
    
    public static boolean esCorreo(String correo) {
        if (correo == null) {
            return false;
        }

        // La expresión regular "^([^@]*@[^@]*)$" explicada:
        // ^ - inicio de la cadena
        // ([^@]*@[^@]*) - cualquier cantidad de caracteres que no sean '@', seguido por un '@', 
        //                 seguido por cualquier cantidad de caracteres que no sean '@'
        // $ - fin de la cadena
        return correo.matches("\\S+@\\S+\\.\\S+");
    }
    
    public static boolean esFechaCaducidad(String fecha) {
        if (fecha == null) {
            return false;
        }
        
        // Comprobar el formato general con una expresión regular
        if (!fecha.matches("\\d{2}/\\d{2}")) {
            return false;
        }

        // Dividir la fecha en mes y año
        String[] partes = fecha.split("/");
        if (partes.length != 2) {
            return false;
        }

        String mes = partes[0];
        String ano = partes[1];

        // Validar el rango del mes
        try {
            int mesInt = Integer.parseInt(mes);
            if (mesInt < 1 || mesInt > 12) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;  // El mes no es un número válido
        }

        // No es necesario validar el año en términos de rango, pues "aa" ya es validado por la expresión regular
        return true;
    }
    
    public static boolean xLongitud(String texto, int longitud) {
        if (texto == null) {
            return false;  // Considera si una cadena nula debe retornar false o lanzar una excepción.
        }
        return texto.length() == longitud;
    }
    public String determinarVerificacion(String correo, String dni, String fc, String tlfn, String ntarj, int check, boolean criterios) throws IOException {
        Javabnb bnb = new Javabnb();
        if (!bnb.existeCliente(correo) && check == 0 && criterios) {
            return "REGISTRAR";
        } else if (!esCorreo(correo)) {
            return "CORREO_INVALIDO";
        } else if (bnb.existeCliente(correo)) {
            return "USUARIO_EXISTE";
        } else if(!esDni(dni)){
            return "DNI_INVALIDO";
        } else if(!esFechaCaducidad(fc)){
            return "FECHA_CADUCIDAD_INVALIDA";
        } else if(!xLongitud(tlfn, 9)){
            return "TELEFONO_INVALIDO";
        } else if(!xLongitud(ntarj,16)){
            return "NUMERO_TARJETA_INVALIDO";
        }
        else {
            return "ERROR";
        }
    }
    
}
