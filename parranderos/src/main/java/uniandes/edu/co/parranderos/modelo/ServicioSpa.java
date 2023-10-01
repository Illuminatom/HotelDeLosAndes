package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servicio_Spa")
public class ServicioSpa {
    @EmbeddedId
    private ServicioSpaPK pk;

    private String duracion;

    public ServicioSpa(Producto id, String duracion) {
        this.pk = new ServicioSpaPK(id);
        this.duracion = duracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public ServicioSpaPK getPk() {
        return pk;
    }

    public void setPk(ServicioSpaPK pk) {
        this.pk = pk;
    }
}
