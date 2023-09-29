package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Gimnasio")
public class Gimnasio {
    
    @EmbeddedId
    private GimnasioPK pk;

    private int costo;

    public Gimnasio()
    {;}

    public Gimnasio(ServicioBasico id, int costo) {
        this.pk = new GimnasioPK(id);
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public GimnasioPK getPk() {
        return pk;
    }

    public void setPk(GimnasioPK pk) {
        this.pk = pk;
    }
}
