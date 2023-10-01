package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Platos_Restaurante_Bar")
public class PlatosRestauranteBar {
    @EmbeddedId
    private PlatosRestauranteBarPK pk;

    public PlatosRestauranteBar()
    {;}

    public PlatosRestauranteBar(Plato plato_id, RestauranteBar restauranteBar_id) {
        this.pk = new PlatosRestauranteBarPK(plato_id, restauranteBar_id);
    }

    public PlatosRestauranteBarPK getPk() {
        return pk;
    }

    public void setPk(PlatosRestauranteBarPK pk) {
        this.pk = pk;
    }
}
