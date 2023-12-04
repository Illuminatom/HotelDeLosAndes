package uniandes.edu.co.parranderos.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cliente")
public class Cliente {
    @Id
    private ObjectId _id;

    private int documento;
    private String nombre;
    private String tipoDocumento;
    private String metodoPago;

    public Cliente() {
    }

    public Cliente(int documento, String nombre, String tipoDocumento, String metodoPago) {
        this.documento = documento;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.metodoPago = metodoPago;
    }
    
    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
