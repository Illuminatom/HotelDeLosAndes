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
    private int cobroTotal;

    public Cliente(Usuario documento, String metodoPago, int cobroTotal) {
        this.pk = new ClientePK(documento);
        this.metodoPago = metodoPago;
        this.cobroTotal = cobroTotal;
    }

    public Cliente()
    {;}

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getCobroTotal() {
        return cobroTotal;
    }

    public void setCobroTotal(int cobroTotal) {
        this.cobroTotal = cobroTotal;
    }

    public ClientePK getPk() {
        return pk;
    }

    public void setPk(ClientePK pk) {
        this.pk = pk;
    }    
}
