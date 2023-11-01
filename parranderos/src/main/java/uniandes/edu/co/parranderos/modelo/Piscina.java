package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Piscina")
public class Piscina {

    @EmbeddedId
    private PiscinaPK pk;

    private int profundidad;
    
    public Piscina(ServicioBasico id, int profundidad) {
        this.pk = new PiscinaPK(id);
        this.profundidad = profundidad;
    }

    public Piscina()
    {;}

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public PiscinaPK getPk() {
        return pk;
    }

    public void setPk(PiscinaPK pk) {
        this.pk = pk;
    }    
}
