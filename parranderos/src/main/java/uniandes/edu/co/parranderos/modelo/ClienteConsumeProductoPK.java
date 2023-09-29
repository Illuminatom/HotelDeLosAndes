package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ClienteConsumeProductoPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Cliente_documento", referencedColumnName = "documento")
    private Cliente Cliente_documento;

    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto Producto_id;

    public ClienteConsumeProductoPK(Cliente cliente_documento, Producto producto_id) {
        super();
        Cliente_documento = cliente_documento;
        Producto_id = producto_id;
    }

    public ClienteConsumeProductoPK()
    {super();}

    public Cliente getCliente_documento() {
        return Cliente_documento;
    }

    public void setCliente_documento(Cliente cliente_documento) {
        Cliente_documento = cliente_documento;
    }

    public Producto getProducto_id() {
        return Producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        Producto_id = producto_id;
    }   
}
