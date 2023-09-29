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
    private int costo;

    public Sala()
    {;}

    public Sala(ServicioBasico id, String tipo, int costo) {
        this.pk = new SalaPK(id);
        this.tipo = tipo;
        this.costo = costo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public SalaPK getPk() {
        return pk;
    }

    public void setPk(SalaPK pk) {
        this.pk = pk;
    }   
}
