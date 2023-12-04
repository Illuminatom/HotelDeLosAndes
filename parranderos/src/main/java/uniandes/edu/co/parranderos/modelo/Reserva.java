package uniandes.edu.co.parranderos.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reserva")
public class Reserva {
    
    @Id
    private ObjectId _id;

    private String id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private double cobroTotal;
    private Cliente cliente;
    private Habitacion habitacion;
    private List<ServicioBasico> consumoServicios;
    private List<Producto> consumoProductos;

    public Reserva(String id, Date fechaEntrada, Date fechaSalida,
    double cobroTotal, Cliente cliente,Habitacion habitacion ) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cobroTotal = cobroTotal;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.consumoServicios = consumoServicios;
        this.consumoProductos = consumoProductos;


    }

    public Reserva(){}

    

    public String getId() {
        return id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public double getCobroTotal() {
        return cobroTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public List<ServicioBasico> getConsumoServicios() {
        return consumoServicios;
    }

    public List<Producto> getConsumoProductos() {
        return consumoProductos;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setCobroTotal(double cobroTotal) {
        this.cobroTotal = cobroTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setConsumoServicios(List<ServicioBasico> consumoServicios) {
        this.consumoServicios = consumoServicios;
    }

    public void setConsumoProductos(List<Producto> consumoProductos) {
        this.consumoProductos = consumoProductos;
    }
    

}
