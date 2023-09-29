package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "MaquinasGimnasio")
public class MaquinasGimnasio {
    @EmbeddedId
    private MaquinasGimnasioPK pk;

    public MaquinasGimnasio()
    {;}

    public MaquinasGimnasio(Producto Producto_id, Gimnasio Gimnasio_id) {
        this.pk = new MaquinasGimnasioPK(Producto_id, Gimnasio_id);
    }

    public MaquinasGimnasioPK getPk() {
        return pk;
    }

    public void setPk(MaquinasGimnasioPK pk) {
        this.pk = pk;
    }
}
