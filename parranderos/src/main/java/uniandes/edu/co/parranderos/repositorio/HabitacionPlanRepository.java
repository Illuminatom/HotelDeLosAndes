package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.HabitacionPlan;

public interface HabitacionPlanRepository extends JpaRepository<HabitacionPlan, Integer>{
    @Query(value = "SELECT * FROM habitacion_plan", nativeQuery = true)
    Collection<HabitacionPlan> darHabitacionesPlan();

    @Query(value = "SELECT * FROM habitacion_plan WHERE Tipo_Habitacion_id=:Tipo_Habitacion_id AND Plan_id=:Plan_id", nativeQuery = true)
    HabitacionPlan darHabitacionPlan(@Param("Tipo_Habitacion_id") int Tipo_Habitacion_id, @Param("Plan_id") int Plan_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitacion_plan (Tipo_Habitacion_id, Plan_id) VALUES (:Tipo_Habitacion_id, :Plan_id)", nativeQuery = true)
    void insertarHabitacionPlan(@Param("Tipo_Habitacion_id") int Tipo_Habitacion_id, @Param("Plan_id") int Plan_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacion_Plan SET Tipo_Habitacion_id=:Tipo_Habitacion_id_actualizado, Plan_id=:Plan_id_actualizado WHERE Tipo_Habitacion_id=:Tipo_Habitacion_id AND Plan_id=:Plan_id", nativeQuery = true)
    void actualizarHabitacionPlan(@Param("Tipo_Habitacion_id") int Tipo_Habitacion_id, @Param("Plan_id") int Plan_id, @Param("Tipo_Habitacion_id_actualizado") int Tipo_Habitacion_id_actualizado, @Param("Plan_id_actualizado") int Plan_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitacion_plan WHERE Tipo_Habitacion_id=:Tipo_Habitacion_id AND Plan_id=:Plan_id", nativeQuery = true)
    void eliminarHabitacionPlan(@Param("Tipo_Habitacion_id") int Tipo_Habitacion_id, @Param("Plan_id") int Plan_id);
}
