package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tienda")
public class Tienda {
    @EmbeddedId
    private TiendaPK pk;

    private String tipo;

    public Tienda(ServicioBasico id, String tipo) {
        this.pk = new TiendaPK(id);
        this.tipo = tipo;
    }
    
    public Tienda()
    {;}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TiendaPK getPk() {
        return pk;
    }

    public void setPk(TiendaPK pk) {
        this.pk = pk;
    }
}
