package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @EmbeddedId
    private ClientePK pk;

    private String metodoPago;

    public Cliente(Usuario documento, String metodoPago) {
        this.pk = new ClientePK(documento);
        this.metodoPago = metodoPago;
    }

    public Cliente()
    {;}

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public ClientePK getPk() {
        return pk;
    }

    public void setPk(ClientePK pk) {
        this.pk = pk;
    }    
}
