package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
    
    @Id
    private int documento;

    private String tipoDocumento;
    private String nombre;

    @Column(name = "correo_electronico")
    private String correoElectronico;
    
    @ManyToOne
    @JoinColumn(name = "TipoUsuario_id", referencedColumnName = "id")
    private TipoUsuario TipoUsuario_id;
    @ManyToOne
    @JoinColumn(name = "Hotel_id", referencedColumnName = "id")
    private Hotel Hotel_id;

    public Usuario(int documento, String tipoDocumento, String nombre, String correoElectronico, TipoUsuario tipoUsuario_id, Hotel hotel_id) {
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.TipoUsuario_id = tipoUsuario_id;
        this.Hotel_id = hotel_id;
    }

    public Usuario()
    {;}

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public TipoUsuario getTipoUsuario_id() {
        return TipoUsuario_id;
    }

    public void setTipoUsuario_id(TipoUsuario tipoUsuario_id) {
        TipoUsuario_id = tipoUsuario_id;
    }

    public Hotel getHotel_id() {
        return Hotel_id;
    }

    public void setHotel_id(Hotel hotel_id) {
        Hotel_id = hotel_id;
    }

}
