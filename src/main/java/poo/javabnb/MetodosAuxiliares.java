package poo.javabnb;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.JOptionPane;

public class MetodosAuxiliares {
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    private ClienteParticular cp;

    public MetodosAuxiliares(){
        
    }
    
    /**
     * Comprueba si el dni es válido
     * @param dni
     * @return boolean
     */
    public static boolean esDni(String dni){
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
    
    /**
     * comprueba si el correo es válid
     * @param texto
     * @return boolean
     */
    public static boolean esCorreo(String texto) {
        if (texto == null) {
            return false;
        }
        return texto.matches("[^@]*@[^@]*");
    }
    
    /**
     * Comprueba si la tarjeta no está caducada
     * @param fechaCaducidad
     * @return boolean
     */
    public static boolean esFechaCaducidadValida(String fechaCaducidad) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth fecha = YearMonth.parse(fechaCaducidad, formatter);
            YearMonth fechaActual = YearMonth.now();
            return fecha.isAfter(fechaActual) || fecha.equals(fechaActual);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    /**
     * Comprueba que la cadena de texto coincide con la longitud introducida
     * @param texto
     * @param longitud
     * @return boolean
     */
    public static boolean xLongitud(String texto, int longitud) {
        if (texto == null) {
            return false;  // Considera si una cadena nula debe retornar false o lanzar una excepción.
        }
        return texto.length() == longitud;
    }
    
   /**
    * Retorna la fecha en el momento que se ejecuta el método
    * @return String 
    */
    public static String fechaActual(){
        Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaActual = sdf.format(todayDate);
        return fechaActual;
    }
    
    public boolean validarFormulario(String correo, String nombre, String contraseña, String telefono, String dni, boolean esVIP) throws IOException {        
        // Validar que los campos no están vacíos ni tienen el texto por defecto
        if (correo.isEmpty() || correo.equals("Ingrese el correo") ||
            nombre.isEmpty() || nombre.equals("Ingrese el nombre") ||
            contraseña.isEmpty() || contraseña.equals("Introduce la contraseña") ||
            telefono.isEmpty() || telefono.equals("Ingrese el teléfono") ||
            dni.isEmpty() || dni.equals("Ingrese el DNI")){
            return false;
        }

        // Verificar cada campo con sus respectivas funciones de validación
        if((esCorreo(correo) && xLongitud(telefono, 9) && esDni(dni)) == true){
            return true;
        }  
        else{
            JOptionPane.showMessageDialog(null, "Los datos introducidos no son validos");
            return false;
        }
    }
    
    
    
    public boolean validarFormulario(String correo, String nombre, String contraseña, String telefono, String dni) throws IOException {        
        // Validar que los campos no están vacíos ni tienen el texto por defecto
        if (correo.isEmpty() || correo.equals("Ingrese el correo") ||
            nombre.isEmpty() || nombre.equals("Ingrese el nombre") ||
            contraseña.isEmpty() || contraseña.equals("Introduce la contraseña") ||
            telefono.isEmpty() || telefono.equals("Ingrese el teléfono") ||
            dni.isEmpty() || dni.equals("Ingrese el DNI")){
            return false;
        }

        // Verificar cada campo con sus respectivas funciones de validación
        if((esCorreo(correo) && xLongitud(telefono, 9) && esDni(dni)) == true){
            return true;
        }  
        else{
            JOptionPane.showMessageDialog(null, "Los datos introducidos no son validos");
            return false;
        }
    }

   
}
    
    
    
   