package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurante_Bar")
public class RestauranteBar {
    @EmbeddedId
    private RestauranteBarPK pk;

    private String estilo;

    public RestauranteBar()
    {;}

    public RestauranteBar(ServicioBasico id, String estilo) {
        this.pk = new RestauranteBarPK(id);
        this.estilo = estilo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public RestauranteBarPK getPk() {
        return pk;
    }

    public void setPk(RestauranteBarPK pk) {
        this.pk = pk;
    }
}
