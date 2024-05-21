package poo.javabnb;

import java.util.List;

public class Reservas {
    private String correoAnfitrion;
    private String correoCliente;
    private String tituloInmueble;
    private List<String> direccionInmueble;
    private String fechaEntrada;
    private String fechaSalida;
    private String huespedes;
    private String precioNoche;
    private String precioTotal;
    private String tarjetaCliente;
    private String tarjetaInmueble;
    
    private Anfitrion anfitrion;
    private ClienteParticular particular;
    private Inmueble inmueble;
    private TarjetaCredito tj;
    
    /*
    public Reservas(String correoAnfitrion, String correoCliente, String tituloInmueble, List<String> direccionInmueble,
                    String fechaEntrada, String fechaSalida, String huespedes, String precioNoche, String precioTotal,
                    String tarjetaCliente, String tarjetaInmueble, Anfitrion anfitrion, ClienteParticular particular,
                    Inmueble inmueble, TarjetaCredito tj) {
        this.correoAnfitrion = correoAnfitrion;
        this.correoCliente = correoCliente;
        this.tituloInmueble = tituloInmueble;
        this.direccionInmueble = direccionInmueble;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.huespedes = huespedes;
        this.precioNoche = precioNoche;
        this.precioTotal = precioTotal;
        this.tarjetaCliente = tarjetaCliente;
        this.tarjetaInmueble = tarjetaInmueble;
        this.anfitrion = anfitrion;
        this.particular = particular;
        this.inmueble = inmueble;
        this.tj = tj;
    }
    */
    // Getters and Setters for each attribute
    public String getCorreoAnfitrion() {
        return correoAnfitrion;
    }

    public void setCorreoAnfitrion(String correoAnfitrion) {
        this.correoAnfitrion = correoAnfitrion;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getTituloInmueble() {
        return tituloInmueble;
    }

    public void setTituloInmueble(String tituloInmueble) {
        this.tituloInmueble = tituloInmueble;
    }

    public List<String> getDireccionInmueble() {
        return direccionInmueble;
    }

    public void setDireccionInmueble(List<String> direccionInmueble) {
        this.direccionInmueble = direccionInmueble;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(String huespedes) {
        this.huespedes = huespedes;
    }

    public String getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(String precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getTarjetaCliente() {
        return tarjetaCliente;
    }

    public void setTarjetaCliente(String tarjetaCliente) {
        this.tarjetaCliente = tarjetaCliente;
    }

    public String getTarjetaInmueble() {
        return tarjetaInmueble;
    }

    public void setTarjetaInmueble(String tarjetaInmueble) {
        this.tarjetaInmueble = tarjetaInmueble;
    }

    public Anfitrion getAnfitrion() {
        return anfitrion;
    }

    public void setAnfitrion(Anfitrion anfitrion) {
        this.anfitrion = anfitrion;
    }

    public ClienteParticular getParticular() {
        return particular;
    }

    public void setParticular(ClienteParticular particular) {
        this.particular = particular;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public TarjetaCredito getTj() {
        return tj;
    }

    public void setTj(TarjetaCredito tj) {
        this.tj = tj;
    }
}
