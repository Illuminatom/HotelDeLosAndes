package uniandes.edu.co.parranderos.modelo;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RestauranteBar")
public class RestauranteBar {
    
    @Id
    private ObjectId _id;

    private String id;
    private String estilo;

    @Transient
    private String servicioId;

    private ServicioBasico servicio;

    private ArrayList<Producto> platos;

    public RestauranteBar(){}

    public RestauranteBar(String id, String estilo, ServicioBasico servicio) {
        this.id = id;
        this.estilo = estilo;
        this.platos = new ArrayList<Producto>();
        this.servicio = servicio;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public ServicioBasico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioBasico servicio) {
        this.servicio = servicio;
    }

    public ArrayList<Producto> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Producto> platos) {
        this.platos = platos;
    }

    public String getServicioId() {
        return servicioId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }
}
