package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SPA")
public class SPA {
    @EmbeddedId
    private SPAPK pk;

    public SPA()
    {;}

    public SPA(ServicioBasico id) {
        this.pk = new SPAPK(id);
    }

    public SPAPK getPk() {
        return pk;
    }

    public void setPk(SPAPK pk) {
        this.pk = pk;
    }
}
