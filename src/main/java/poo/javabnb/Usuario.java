package poo.javabnb;

public abstract class Usuario {
    protected String dni;
    protected String nombre;
    protected String correoElectronico;
    protected String clave;
    protected String telefono;

    public Usuario(String dni, String nombre, String correoElectronico, String clave, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
        this.telefono = telefono;
    }
}
    // Métodos getters y setters
    // Getters
/*
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
   
}
*/
