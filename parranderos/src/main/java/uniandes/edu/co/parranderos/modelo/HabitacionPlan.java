package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Habitacion_Plan")
public class HabitacionPlan {
    @EmbeddedId
    private HabitacionPlanPK pk;

    public HabitacionPlan(TipoHabitacion TipoHabitacion_id, Plan Plan_id) {
        this.pk = new HabitacionPlanPK(TipoHabitacion_id, Plan_id);
    }

    public HabitacionPlan()
    {;}

    public HabitacionPlanPK getPk() {
        return pk;
    }

    public void setPk(HabitacionPlanPK pk) {
        this.pk = pk;
    }   
}
