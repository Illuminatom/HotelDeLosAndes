package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicioPlanPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ServicioBasico_id", referencedColumnName = "id")
    private ServicioBasico ServicioBasico_id;

    @ManyToOne
    @JoinColumn(name = "Plan_id", referencedColumnName = "id")
    private Plan Plan_id;

    public ServicioPlanPK(ServicioBasico servicioBasico_id, Plan plan_id) {
        super();
        ServicioBasico_id = servicioBasico_id;
        Plan_id = plan_id;
    }

    public ServicioPlanPK()
    {super();}

    public ServicioBasico getServicioBasico_id() {
        return ServicioBasico_id;
    }

    public void setServicioBasico_id(ServicioBasico servicioBasico_id) {
        ServicioBasico_id = servicioBasico_id;
    }

    public Plan getPlan_id() {
        return Plan_id;
    }

    public void setPlan_id(Plan plan_id) {
        Plan_id = plan_id;
    }        
}
