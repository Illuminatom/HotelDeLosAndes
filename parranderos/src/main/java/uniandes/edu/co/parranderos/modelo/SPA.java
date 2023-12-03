package uniandes.edu.co.parranderos.modelo;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SPA")
public class SPA {
    
    @Id
    private ObjectId _id;

    private String id;

    @Transient
    private String servicioId;

    private ServicioBasico servicio;
    private ArrayList<Producto> serviciosSPA;

    public SPA(){}

    public SPA(String id, ServicioBasico servicio) {
        this.id = id;
        this.servicio = servicio;
        this.serviciosSPA = new ArrayList<Producto>();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServicioBasico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioBasico servicio) {
        this.servicio = servicio;
    }

    public ArrayList<Producto> getServiciosSPA() {
        return serviciosSPA;
    }

    public void setServiciosSPA(ArrayList<Producto> serviciosSPA) {
        this.serviciosSPA = serviciosSPA;
    }

    public String getServicioId() {
        return servicioId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }
}
