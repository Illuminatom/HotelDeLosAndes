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
    private int costo;
    
    public Piscina(ServicioBasico id, int profundidad, int costo) {
        this.pk = new PiscinaPK(id);
        this.profundidad = profundidad;
        this.costo = costo;
    }

    public Piscina()
    {;}

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public PiscinaPK getPk() {
        return pk;
    }

    public void setPk(PiscinaPK pk) {
        this.pk = pk;
    }    
}
