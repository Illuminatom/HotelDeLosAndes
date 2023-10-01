package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{
    @Query(value = "SELECT * FROM plan", nativeQuery = true)
    Collection<Plan> darPlanes();

    @Query(value = "SELECT * FROM plan WHERE id=:id", nativeQuery = true)
    Plan darPlan(@Param("id") int id);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO plan (id, nombre, descuento_Habitacion) VALUES (:id, :nombre, :descuento_habitacion)", nativeQuery = true)
    void insertarPlan(@Param("id") int id, @Param("nombre") String nombre, @Param("descuento_Habitacion") int descuento_Habitacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE plan SET nombre=:nombre, descuento_Habitacion=:descuento_Habitacion WHERE id=:id", nativeQuery = true)
    void actualizarPlan(@Param("id") int id, @Param("nombre") String nombre, @Param("descuento_Habitacion") int descuento_Habitacion);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM plan WHERE id=:id", nativeQuery = true)
    void eliminarPlan(@Param("id") int id);
}
