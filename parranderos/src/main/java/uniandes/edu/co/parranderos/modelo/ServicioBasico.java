package uniandes.edu.co.parranderos.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ServicioBasico")
public class ServicioBasico {
    @Id
    private ObjectId _id;

    private String id;

    private String nombre;
    private int capacidad;
    private double costo;
    private String horaApertura;
    private String horaCierre;
    private int[] consumos; 

    @Transient 
    private int servicioEspecificoId;

    private Object servicioEspecifico;

    public ServicioBasico(){}

    public ServicioBasico(String id, String nombre, int capacidad, double costo, String horaApertura, String horaCierre) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costo = costo;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public int[] getConsumos() {
        return consumos;
    }

    public void setConsumos(int[] consumos) {
        this.consumos = consumos;
    }

    public int getServicioEspecificoId() {
        return servicioEspecificoId;
    }

    public void setServicioEspecificoId(int servicioEspecificoId) {
        this.servicioEspecificoId = servicioEspecificoId;
    }

    public Object getServicioEspecifico() {
        return servicioEspecifico;
    }

    public void setServicioEspecifico(Object servicioEspecifico) {
        this.servicioEspecifico = servicioEspecifico;
    }
}