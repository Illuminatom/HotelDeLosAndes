package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PlatosRestauranteBarPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "Plato_id", referencedColumnName = "id")
    private Plato Plato_id;

    @ManyToOne
    @JoinColumn(name = "RestauranteBar_id", referencedColumnName = "id")
    private RestauranteBar RestauranteBar_id;

    public PlatosRestauranteBarPK()
    {super();}

    public PlatosRestauranteBarPK(Plato plato_id, RestauranteBar restauranteBar_id) {
        super();
        Plato_id = plato_id;
        RestauranteBar_id = restauranteBar_id;
    }

    public Plato getPlato_id() {
        return Plato_id;
    }

    public void setPlato_id(Plato plato_id) {
        Plato_id = plato_id;
    }

    public RestauranteBar getRestauranteBar_id() {
        return RestauranteBar_id;
    }

    public void setRestauranteBar_id(RestauranteBar restauranteBar_id) {
        RestauranteBar_id = restauranteBar_id;
    }
}
