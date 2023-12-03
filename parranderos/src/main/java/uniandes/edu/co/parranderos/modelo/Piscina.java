package uniandes.edu.co.parranderos.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Piscina")
public class Piscina {
    
    @Id
    private ObjectId _id;

    private String id;
    private double profundidad;

    @Transient
    private String servicioId;

    private ServicioBasico servicio;

    public Piscina(){}

    public Piscina(String id, double profundidad, ServicioBasico servicio) {
        this.id = id;
        this.profundidad = profundidad;
        this.servicio = servicio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    } 

    public ServicioBasico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioBasico servicio) {
        this.servicio = servicio;
    }

    public String getServicioId() {
        return servicioId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }    
}
