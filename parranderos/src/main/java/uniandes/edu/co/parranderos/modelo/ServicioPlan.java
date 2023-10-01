package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servicio_Plan")
public class ServicioPlan {
    @EmbeddedId
    private ServicioPlanPK pk;

    private int descuento;

    public ServicioPlan()
    {;}

    public ServicioPlan(ServicioBasico ServicioBasico_id, Plan Plan_id, int descuento) {
        this.pk = new ServicioPlanPK(ServicioBasico_id, Plan_id);
        this.descuento = descuento;
    }

    public ServicioPlanPK getPk() {
        return pk;
    }

    public void setPk(ServicioPlanPK pk) {
        this.pk = pk;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }        
}
