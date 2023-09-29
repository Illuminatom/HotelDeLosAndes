package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class SPAPK implements Serializable{
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ServicioBasico id;

    public SPAPK()
    {super();}

    public SPAPK(ServicioBasico id) {
        super();
        this.id = id;
    }

    public ServicioBasico getId() {
        return id;
    }

    public void setId(ServicioBasico id) {
        this.id = id;
    }
}
