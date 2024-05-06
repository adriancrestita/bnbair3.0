package poo.javabnb;

import java.time.*;

public class Anfitrion extends Usuario {
    
    //Atributos
    private LocalDate fechaRegistro; //LocalDate para el registro en hora actual
    private boolean esSuperanfitrion;
    
    //Constructor
    public Anfitrion(String dni, String nombre, String correoElectronico, String clave, String telefono, LocalDate fechaRegistro, boolean esSuperanfitrion) {
        super(dni, nombre, correoElectronico, clave, telefono);
        this.fechaRegistro = fechaRegistro;
        this.esSuperanfitrion = esSuperanfitrion;
    }

}
