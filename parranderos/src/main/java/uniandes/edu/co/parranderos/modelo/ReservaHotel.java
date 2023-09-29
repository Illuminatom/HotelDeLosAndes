package uniandes.edu.co.parranderos.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ReservaHotel")
public class ReservaHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date fechaEntrada;
    private Date fechaSalida;
    private int numPersonas;

    @OneToOne
    @JoinColumn(name = "Habitacion_id", referencedColumnName = "id")
    private Habitacion Habitacion_id;

    @OneToOne
    @JoinColumn(name = "Cliente_id", referencedColumnName = "documento")
    private Cliente Cliente_id;

    @ManyToOne
    @JoinColumn(name = "Plan_id", referencedColumnName = "id")
    private Plan Plan_id;

    public ReservaHotel(Date fechaEntrada, Date fechaSalida, int numPersonas, Habitacion habitacion_id,
            Cliente cliente_id, Plan plan_id) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numPersonas = numPersonas;
        this.Habitacion_id = habitacion_id;
        this.Cliente_id = cliente_id;
        this.Plan_id = plan_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public Habitacion getHabitacion_id() {
        return Habitacion_id;
    }

    public void setHabitacion_id(Habitacion habitacion_id) {
        Habitacion_id = habitacion_id;
    }

    public Cliente getCliente_id() {
        return Cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        Cliente_id = cliente_id;
    }

    public Plan getPlan_id() {
        return Plan_id;
    }

    public void setPlan_id(Plan plan_id) {
        Plan_id = plan_id;
    }
}
