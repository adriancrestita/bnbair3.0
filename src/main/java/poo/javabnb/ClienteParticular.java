package poo.javabnb;

import ManejoDatos.Deserializador;
import ManejoDatos.Serializador;
import java.io.*;
import static poo.javabnb.MetodosAuxiliares.elementosPorDato;

public class ClienteParticular extends Usuario implements Serializable{
    
    //Atributos
    private static final long serialVersionUID = 1L;
    private boolean esVIP;
    
    //Constructor
    public ClienteParticular(String dni, String nombre, String correoElectronico, String clave, String telefono, boolean esVIP) {
        super(dni, nombre, correoElectronico, clave, telefono);
        this.esVIP = esVIP;
    }
    
    //Métodos getters y setters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String getesVIP(){
        if(esVIP==true){
            return "Es VIP";
        }
        else{
            return "No es VIP";
        }
    }

    // Setters
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   
    public void setesVIP(boolean vip){
        this.esVIP = esVIP;
    }

    // Métodos específicos para ClienteParticular
    public void guardarParticular() {
        String linea = getNombre() + "," + getDni() + "," + getCorreoElectronico() + "," + getClave() + "," + getTelefono() + "," + getesVIP() + "\n";
        try {
            FileWriter myWriter = new FileWriter("datos_users.txt", true); //el true activa el append
            myWriter.write(linea);
            myWriter.close();
          } 
        catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
          }
    }
    
    
    
    public boolean cmpVIP(){
        return esVIP;   
    }
    
    public static void busquedaDatosCliente(String correo){
        try {
            String archivo = "datos_users.txt";
            String[] elementos = elementosPorDato(archivo, correo, 2);

            if (elementos != null) {
                for (String elemento : elementos) {
                    System.out.println(elemento);
                }
            } else {
                System.out.println("No se encontró ningun cliente con ese nombre.");
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
   /* 
    public static int lineaCliente(String correo) throws IOException{
        BufferedReader reader = null;
        String[] elementos = null;
        int lineNumber = 0;  // Inicializar contador de líneas


        try {
            reader = new BufferedReader(new FileReader("datos_users.txt"));
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
    
    
    public static void reemplazarLinea(String correoBuscado, String nombre, String dni, String correo, String contraseña, String telefono, boolean vip) throws IOException {
        String nuevaLinea = nombre + "," + dni + "," + correo + "," + contraseña + "," + telefono + "," + vip + "\n";

        File file = new File("datos_users.txt");
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
                if (currentLineNumber == lineaCliente(correoBuscado)) {
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
*/
}
