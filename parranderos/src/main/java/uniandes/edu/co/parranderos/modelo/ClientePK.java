package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class ClientePK implements Serializable {
    @OneToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento")
    private Usuario documento;

    public ClientePK()
    {super();}

    public ClientePK(Usuario documento) {
        super();
        this.documento = documento;
    }

    public Usuario getDocumento() {
        return documento;
    }

    public void setDocumento(Usuario documento) {
        this.documento = documento;
    }
    
}
