package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Gimnasio")
public class Gimnasio {
    
    @EmbeddedId
    private GimnasioPK pk;

    public Gimnasio()
    {;}

    public Gimnasio(ServicioBasico id) {
        this.pk = new GimnasioPK(id);
    }

    public GimnasioPK getPk() {
        return pk;
    }

    public void setPk(GimnasioPK pk) {
        this.pk = pk;
    }
}
