package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.HabitacionPlan;

public interface HabitacionPlanRepository extends JpaRepository<HabitacionPlan, Integer>{
    @Query(value = "SELECT * FROM habitacionplan", nativeQuery = true)
    Collection<HabitacionPlan> darHabitacionesPlan();

    @Query(value = "SELECT * FROM WHERE TipoHabitacion_id=:TipoHabitacion_id AND Plan_id=:Plan_id", nativeQuery = true)
    HabitacionPlan darHabitacionPlan(@Param("TipoHabitacion_id") int TipoHabitacion_id, @Param("Plan_id") int Plan_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitacionplan (TipoHabitacion_id, Plan_id) VALUES (:TipoHabitacion_id, :Plan_id)", nativeQuery = true)
    void insertarHabitacionPlan(@Param("TipoHabitacion_id") int TipoHabitacion_id, @Param("Plan_id") int Plan_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacionPlan SET TipoHabitacion_id=:TipoHabitacion_id_actualizado, Plan_id=:Plan_id_actualizado WHERE TipoHabitacion_id=:TipoHabitacion_id AND Plan_id=:Plan_id", nativeQuery = true)
    void actualizarHabitacionPlan(@Param("TipoHabitacion_id") int TipoHabitacion_id, @Param("Plan_id") int Plan_id, @Param("TipoHabitacion_id_actualizado") int TipoHabitacion_id_actualizado, @Param("Plan_id_actualizado") int Plan_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitacionplan WHERE TipoHabitacion_id=:TipoHabitacion_id AND Plan_id=:Plan_id", nativeQuery = true)
    void eliminarHabitacionPlan(@Param("TipoHabitacion_id") int TipoHabitacion_id, @Param("Plan_id") int Plan_id);
}
