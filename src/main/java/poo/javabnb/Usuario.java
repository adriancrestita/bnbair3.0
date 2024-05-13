package poo.javabnb;

public abstract class Usuario {
    protected String dni;
    protected String nombre;
    protected String correoElectronico;
    protected String clave;
    protected String telefono;

    public Usuario(){
        
    }
    public Usuario(String dni, String nombre, String correoElectronico, String clave, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
        this.telefono = telefono;
    }
}