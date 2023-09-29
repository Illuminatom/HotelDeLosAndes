package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class TiendaPK implements Serializable{
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ServicioBasico id;    

    public TiendaPK()
    {super();}

    public ServicioBasico getId() {
        return id;
    }

    public void setId(ServicioBasico id) {
        this.id = id;
    }

    public TiendaPK(ServicioBasico id) {
        super();
        this.id = id;
    }
}
