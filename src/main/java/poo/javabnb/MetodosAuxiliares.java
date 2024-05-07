package poo.javabnb;

import java.io.*;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class MetodosAuxiliares {
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    private ClienteParticular cp;

    public MetodosAuxiliares(){
        
    }
    
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
    
    public static boolean esCorreo(String texto) {
        if (texto == null) {
            return false;
        }
        return texto.matches("[^@]*@[^@]*");
    }
    
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
    
    public static boolean xLongitud(String texto, int longitud) {
        if (texto == null) {
            return false;  // Considera si una cadena nula debe retornar false o lanzar una excepción.
        }
        return texto.length() == longitud;
    }
    
    public boolean existeCliente(String correoBuscado) throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        String[] elementos = null;
        try {
            reader = new BufferedReader(new FileReader("datos_users.txt"));
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                elementos = lineaActual.split(","); // Dividir la línea por comas
                if (elementos.length > 0 && elementos[2].equals(correoBuscado)) {
                    return true; // Retorna true si coincide
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return false; // Retorna false si no se encuentra cliente que coincida
    }
    
    public boolean existeAnfitrion(String correoBuscado) throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        String[] elementos = null;
        try {
            reader = new BufferedReader(new FileReader("datos_anfitrion.txt"));
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                elementos = lineaActual.split(","); // Dividir la línea por comas
                if (elementos.length > 0 && elementos[2].equals(correoBuscado)) {
                    return true; // Retorna true si coincide
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return false; // Retorna false si no se encuentra cliente que coincida
    }
   
    public boolean validarFormulario(String correo, String nombre, String contraseña, String telefono, String dni, String titularTarjeta, String numeroTarjeta, String fechaCaducidad, boolean esVIP) throws IOException {        
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
        if((esCorreo(correo) && xLongitud(telefono, 9) && esDni(dni) && xLongitud(numeroTarjeta, 16) && esFechaCaducidadValida(fechaCaducidad)) == true){
            if(existeCliente(correo) == false){
                return true;
            }
            
            else{
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
                return false;
            }
        }  
        else{
            JOptionPane.showMessageDialog(null, "Los datos introducidos no son validos");
            return false;
        }
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
    
    public boolean validarFormulario(String titularTarjeta, String numeroTarjeta, String fechaCaducidad) throws IOException {        
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
    
    public boolean inicioSesionValido(String correo, String contraseña) throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        String[] elementos = null;
        try {
            reader = new BufferedReader(new FileReader("datos_users.txt"));
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                elementos = lineaActual.split(","); // Dividir la línea por comas
                if (elementos.length > 0 && elementos[2].equals(correo) && elementos[3].equals(contraseña)) {
                    return true; // Retorna true si coincide
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return false; // Retorna false si no se encuentra cliente que coincida
    }

    public static String[] elementosPorDato(String archivo, String correo, int posicion) throws IOException{
        BufferedReader reader = null;
        String[] elementos = null;

        try {
            reader = new BufferedReader(new FileReader(archivo));
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                elementos = lineaActual.split(","); // Dividir la línea por comas
                if (elementos.length > 0 && elementos[posicion].equals(correo)) {
                    return elementos; // Retorna los elementos si el primer dato coincide
                }
            }
        } 
        finally {
            if (reader != null) {
                reader.close();
            }
        }
        return null; // Retorna null si no se encuentra ninguna línea que coincida
    }
    
    public static int lineaCliente(String correo, String archivo) throws IOException{
        BufferedReader reader = null;
        String[] elementos = null;
        int lineNumber = 0;  // Inicializar contador de líneas


        try {
            reader = new BufferedReader(new FileReader(archivo));
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                lineNumber++;
                elementos = lineaActual.split(","); // Dividir la línea por comas
                if (elementos.length > 0 && elementos[2].equals(correo)) {
                    return lineNumber; // Retorna los elementos si el primer dato coincide
                }
            }
        } 
        finally {
            if (reader != null) {
                reader.close();
            }
        }
        return 0; // Retorna null si no se encuentra ninguna línea que coincida
    }
    
    
    public static void reemplazarLinea(String correoBuscado, String nuevaLinea, String archivo) throws IOException {

        File file = new File(archivo);
        File tempFile = new File(file.getAbsolutePath() + ".tmp");

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            int currentLineNumber = 0;

            while ((currentLine = reader.readLine()) != null) {
                currentLineNumber++;
                // Reemplaza la línea si es la línea especificada
                if (currentLineNumber == lineaCliente(correoBuscado, archivo)) {
                    writer.write(nuevaLinea + System.lineSeparator());
                } else {
                    writer.write(currentLine + System.lineSeparator());
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

        // Eliminar el archivo original y renombrar el archivo temporal para reemplazarlo
        if (!file.delete() || !tempFile.renameTo(file)) {
            throw new IOException("No se pudo reemplazar el archivo original con el archivo actualizado");
        }
    }
    
    
    
}


/*
// TODO add your handling code here:
        int check=0;
        if(jmailsign.getText().equals("") || jmailsign.getText().equals("Ingrese el correo") || esCorreo(jmailsign.getText()) == false){
            JOptionPane.showMessageDialog(null, "Rellene el correo");
            check++;
        }
        if(jpasswordsign.getPassword().equals("") || jpasswordsign.getPassword().equals("Ingrese la contraseña")){
            JOptionPane.showMessageDialog(null, "Rellene la password");
            check++;
        }
        if(jnombre.getText().equals("") || jnombre.getText().equals("Ingrese el DNI") || esDni(jnombre.getText()) == false){
            JOptionPane.showMessageDialog(null, "Rellene el DNI");
            check++;
        }
        if(jnumtarj.getText().equals("") || jnumtarj.getText().equals("Ingrese el numero de tarjeta") || xLongitud(jnumtarj.getText(),16) == false){
            JOptionPane.showMessageDialog(null, "Rellene el numero de la tarjeta");
            check++;
        }
        if(jfcaducidad.getText().equals("") || jfcaducidad.getText().equals("Ingrese la fecha de caducidad") || esFechaCaducidad(jfcaducidad.getText()) == false){
            JOptionPane.showMessageDialog(null, "Rellene la fecha de caducidad");
            check++;
        }
        if(jtitular.getText().equals("") || jtitular.getText().equals("Ingrese el nombre del titular")){
            JOptionPane.showMessageDialog(null, "Rellene el nombre del titular");
            check++;
        }
        if(jphonenumber.getText().equals("") || jphonenumber.getText().equals("Ingrese el teléfono") || xLongitud(jphonenumber.getText(),9) == false){
            JOptionPane.showMessageDialog(null, "Rellene el numero de telefono");
            check++;
        }
        if(jnombre.getText().equals("") || jnombre.getText().equals("Ingrese el nombre")){
            JOptionPane.showMessageDialog(null, "Rellene el nombre");
            check++;
        }
        
        
        ClienteParticular particular = new ClienteParticular(jnombre.getText(), jnombre.getText(), jmailsign.getText(), jpasswordsign.getText(), jphonenumber.getText(), jesVIP.isEnabled());
        
        //Asignamos valores a los atributos con los SET de Cliente Particular
        particular.setDni(jnombre.getText());
        particular.setNombre(jnombre.getText());
        particular.setCorreoElectronico(jmailsign.getText());
        particular.setClave(String.valueOf(jpasswordsign.getPassword()));
        particular.setTelefono(jphonenumber.getText());
        particular.setesVIP(jesVIP.isEnabled());
        
        Javabnb bnb = new Javabnb();
        
        try {
            if(bnb.existeCliente(jmailsign.getText()) == false && check==0){
                particular.guardarParticular();
                cambioLogin(check);

                
            }
            else{
                JOptionPane.showMessageDialog(null, "Este usuario ya existe");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(FrameRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
*/