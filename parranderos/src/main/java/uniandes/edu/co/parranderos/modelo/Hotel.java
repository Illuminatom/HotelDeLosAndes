package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String nombre;
    private Integer numEstrellas;

    public Hotel(String nombre, Integer numEstrellas) {
        this.nombre = nombre;
        this.numEstrellas = numEstrellas;
    }

    public Hotel()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumEstrellas() {
        return numEstrellas;
    }

    public void setNumEstrellas(Integer numEstrellas) {
        this.numEstrellas = numEstrellas;
    }    
}
