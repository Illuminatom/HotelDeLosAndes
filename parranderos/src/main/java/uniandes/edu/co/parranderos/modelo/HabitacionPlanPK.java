package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class HabitacionPlanPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "TipoHabitacion_id", referencedColumnName = "id")
    private TipoHabitacion TipoHabitacion_id;

    @ManyToOne
    @JoinColumn(name = "Plan_id", referencedColumnName = "id")
    private Plan Plan_id;

    public HabitacionPlanPK(TipoHabitacion tipohabitacion_id, Plan plan_id) {
        super();
        TipoHabitacion_id = tipohabitacion_id;
        Plan_id = plan_id;
    }
    
    public HabitacionPlanPK()
    {super();}

    public Plan getPlan_id() {
        return Plan_id;
    }

    public void setPlan_id(Plan plan_id) {
        Plan_id = plan_id;
    }

    public TipoHabitacion getTipoHabitacion_id() {
        return TipoHabitacion_id;
    }

    public void setTipoHabitacion_id(TipoHabitacion tipoHabitacion_id) {
        TipoHabitacion_id = tipoHabitacion_id;
    }   
}
