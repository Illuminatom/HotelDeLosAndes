package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lavanderia")
public class Lavanderia {
    
    @EmbeddedId
    private LavanderiaPK pk;

    private int costoPrenda;
    private int costoPorParZapatos;

    public Lavanderia(ServicioBasico id, int costoPrenda, int costoPorParZapatos) {
        this.pk = new LavanderiaPK(id);
        this.costoPrenda = costoPrenda;
        this.costoPorParZapatos = costoPorParZapatos;
    }

    public Lavanderia()
    {;}

    public int getCostoPrenda() {
        return costoPrenda;
    }

    public void setCostoPrenda(int costoPrenda) {
        this.costoPrenda = costoPrenda;
    }

    public int getCostoPorParZapatos() {
        return costoPorParZapatos;
    }

    public void setCostoPorParZapatos(int costoPorParZapatos) {
        this.costoPorParZapatos = costoPorParZapatos;
    }

    public LavanderiaPK getPk() {
        return pk;
    }

    public void setPk(LavanderiaPK pk) {
        this.pk = pk;
    }
}
