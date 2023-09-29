package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    @Query(value = "SELECT * FROM habitacion", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitacion WHERE id=:id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitacion (id, disponible, Hotel_id, TipoHabitacion_id) VALUES(:disponible, :Hotel_id, :TipoHabitacion_id)", nativeQuery = true)
    void insertarHabitacion(@Param("disponible") Boolean disponible, @Param("Hotel_id") int Hotel_id, @Param("TipoHabitacion_id") int TipoHabitacion_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacion SET disponible=:disponible, Hotel_id=:Hotel_id, TipoHabitacion_id=:TipoHabitacion_id WHERE id=:id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") int id, @Param("disponible") Boolean disponible, @Param("Hotel_id") int Hotel_id, @Param("TipoHabitacion_id") int TipoHabitacion_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitacion WHERE id=:id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") int id);
}
