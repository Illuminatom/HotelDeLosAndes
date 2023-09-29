package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ServiciosSpa")
public class ServiciosSpa {
    @EmbeddedId
    private ServiciosSpaPK pk;
    
    public ServiciosSpa()
    {;}

    public ServiciosSpa(ServicioSpa servicioSpa_id, SPA sPA_id) {
        this.pk = new ServiciosSpaPK(servicioSpa_id, sPA_id);
    }

    public ServiciosSpaPK getPk() {
        return pk;
    }

    public void setPk(ServiciosSpaPK pk) {
        this.pk = pk;
    }
}
