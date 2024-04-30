package poo.javabnb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TarjetaCredito extends ClienteParticular{
    
    //Atributos
    private String nombreTitular;
    private String numeroTarjeta;
    private String fechaCaducidad;
    
    //Constructor
    
    public TarjetaCredito(String nombreTitular, String numeroTarjeta, String fechaCaducidad, String dni, String nombre, String correoElectronico, String clave, String telefono, boolean esVIP) {
        super(dni,nombre,correoElectronico,clave,telefono,esVIP);
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
    }

    // Getters y setters
    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
    public boolean tarjetaCorrecta(String correoBuscado,String numtarj, String titular, String fcad) throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        String[] elementos = null;
        try {
            reader = new BufferedReader(new FileReader("datos_tarjeta.txt"));
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                elementos = lineaActual.split(","); // Dividir la línea por comas
                if (elementos.length > 0 && elementos[0].equals(correoBuscado) && elementos[1].equals(titular) && elementos[2].equals(numtarj) && elementos[3].equals(fcad)) {
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
    
    
    public void guardarTarjeta() {
        String linea = correoElectronico + "," + nombreTitular + "," + numeroTarjeta + "," + fechaCaducidad + "\n";
        try {
            FileWriter myWriter = new FileWriter("datos_tarjeta.txt", true); //el true activa el append
            myWriter.write(linea/*.getBytes(), StandardOpenOption.APPEND*/);
            myWriter.close();
          } 
        catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
          }
    }
}
