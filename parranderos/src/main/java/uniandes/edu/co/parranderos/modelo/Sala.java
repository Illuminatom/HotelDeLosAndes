package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sala")
public class Sala {
    @EmbeddedId
    private SalaPK pk;

    private String tipo;

    public Sala()
    {;}

    public Sala(ServicioBasico id, String tipo) {
        this.pk = new SalaPK(id);
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public SalaPK getPk() {
        return pk;
    }

    public void setPk(SalaPK pk) {
        this.pk = pk;
    }   
}
