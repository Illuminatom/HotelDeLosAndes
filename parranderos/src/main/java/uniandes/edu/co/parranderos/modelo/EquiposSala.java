package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "EquiposSala")
public class EquiposSala {
    @EmbeddedId
    private EquiposSalaPK pk;

    public EquiposSala()
    {;}

    public EquiposSala(Producto producto_id, Sala sala_id) {
        this.pk = new EquiposSalaPK(producto_id, sala_id);
    }

    public EquiposSalaPK getPk() {
        return pk;
    }

    public void setPk(EquiposSalaPK pk) {
        this.pk = pk;
    }
}
