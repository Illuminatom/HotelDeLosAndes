package uniandes.edu.co.parranderos.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Prestamo")
public class Prestamo {
    
    @Id
    private ObjectId _id;

    private String id;

    @Transient
    private String productoId;

    @Transient
    private String nombreProducto;

    @Transient
    private double precioProducto;

    @Transient
    private String tipoProducto;

    private Producto producto;

    @Transient
    private String servicioId;

    @Transient
    private String nombreServicio;

    @Transient
    private int capacidadServicio;

    @Transient 
    private double costoServicio;

    @Transient
    private String horaAperturaServicio;

    @Transient
    private String horaCierreServicio;

    private ServicioBasico servicio;

    public Prestamo(){}

    public Prestamo(String id, Producto producto, ServicioBasico servicio) {
        this.id = id;
        this.producto = producto;
        this.servicio = servicio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ServicioBasico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioBasico servicio) {
        this.servicio = servicio;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getServicioId() {
        return servicioId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getCapacidadServicio() {
        return capacidadServicio;
    }

    public void setCapacidadServicio(int capacidadServicio) {
        this.capacidadServicio = capacidadServicio;
    }

    public double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public String getHoraAperturaServicio() {
        return horaAperturaServicio;
    }

    public void setHoraAperturaServicio(String horaAperturaServicio) {
        this.horaAperturaServicio = horaAperturaServicio;
    }

    public String getHoraCierreServicio() {
        return horaCierreServicio;
    }

    public void setHoraCierreServicio(String horaCierreServicio) {
        this.horaCierreServicio = horaCierreServicio;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
