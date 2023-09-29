package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServiciosSpaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ServicioSpa_id", referencedColumnName = "id")
    private ServicioSpa ServicioSpa_id;
    
    @ManyToOne
    @JoinColumn(name = "SPA_id", referencedColumnName = "id")
    private SPA SPA_id;

    public ServiciosSpaPK()
    {super();}

    public ServiciosSpaPK(ServicioSpa servicioSpa_id, SPA sPA_id) {
        ServicioSpa_id = servicioSpa_id;
        SPA_id = sPA_id;
    }

    public ServicioSpa getServicioSpa_id() {
        return ServicioSpa_id;
    }

    public void setServicioSpa_id(ServicioSpa servicioSpa_id) {
        ServicioSpa_id = servicioSpa_id;
    }

    public SPA getSPA_id() {
        return SPA_id;
    }

    public void setSPA_id(SPA sPA_id) {
        SPA_id = sPA_id;
    }
}
