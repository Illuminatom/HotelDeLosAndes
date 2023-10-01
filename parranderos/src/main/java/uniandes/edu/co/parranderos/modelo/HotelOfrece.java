package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hotel_Ofrece")
public class HotelOfrece {
    @EmbeddedId
    private HotelOfrecePK pk;

    public HotelOfrece(Hotel Hotel_id, ServicioBasico ServicioBasico_id){
        this.pk = new HotelOfrecePK(Hotel_id, ServicioBasico_id);
    }

    public HotelOfrece()
    {;}

    public HotelOfrecePK getPk() {
        return pk;
    }

    public void setPk(HotelOfrecePK pk) {
        this.pk = pk;
    }
}
