package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Plato")
public class Plato {
    @EmbeddedId
    private PlatoPK pk;

    private String descripcion;

    public Plato()
    {;}

    public Plato(Producto id, String descripcion) {
        this.pk = new PlatoPK(id);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PlatoPK getPk() {
        return pk;
    }

    public void setPk(PlatoPK pk) {
        this.pk = pk;
    }
}
