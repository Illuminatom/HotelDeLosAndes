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
    @Query(value = "INSERT INTO habitacion (id, disponible, Hotel_id, tipo_habitacion_id) VALUES (:id, :disponible, :Hotel_id, :tipo_habitacion_id)", nativeQuery = true)
    void insertarHabitacion(@Param("id") int id, @Param("disponible") String disponible, @Param("Hotel_id") int Hotel_id, @Param("tipo_habitacion_id") int tipo_habitacion_id);    

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacion SET disponible=:disponible, Hotel_id=:Hotel_id, tipo_habitacion_id=:tipo_habitacion_id WHERE id=:id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") int id, @Param("disponible") String disponible, @Param("Hotel_id") int Hotel_id, @Param("tipo_habitacion_id") int tipo_habitacion_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitacion WHERE id=:id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") int id);
}
