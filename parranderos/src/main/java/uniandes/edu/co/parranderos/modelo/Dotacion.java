package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dotacion")
public class Dotacion {
    @EmbeddedId
    private DotacionPK pk;

    public Dotacion(TipoHabitacion TipoHabitacion_id, Producto Producto_id) {
        this.pk = new DotacionPK(TipoHabitacion_id, Producto_id);
    }

    public Dotacion()
    {;}

    public DotacionPK getPk() {
        return pk;
    }

    public void setPk(DotacionPK pk) {
        this.pk = pk;
    }   
}
