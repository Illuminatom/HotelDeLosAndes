package uniandes.edu.co.parranderos.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Lavanderia")
public class Lavanderia {
    
    @Id
    private ObjectId _id;

    private String id;
    private double costoPorPrenda;
    private double costoPorParZapatos;

    @Transient
    private String servicioId;

    private ServicioBasico servicio;

    public Lavanderia(){}

    public Lavanderia(String id, double costoPorPrenda, double costoPorParZapatos, ServicioBasico servicio) {
        this.id = id;
        this.costoPorPrenda = costoPorPrenda;
        this.servicio = servicio;
        this.costoPorParZapatos = costoPorParZapatos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCostoPorPrenda() {
        return costoPorPrenda;
    }

    public void setCostoPorPrenda(double costoPorPrenda) {
        this.costoPorPrenda = costoPorPrenda;
    }

    public double getCostoPorParZapatos() {
        return costoPorParZapatos;
    }

    public void setCostoPorParZapatos(double costoPorParZapatos) {
        this.costoPorParZapatos = costoPorParZapatos;
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
