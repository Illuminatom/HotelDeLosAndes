package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Dotacion;

public interface DotacionRepository extends JpaRepository<Dotacion, Integer>{
    @Query(value = "SELECT * FROM dotacion", nativeQuery = true)
    Collection<Dotacion> darDotaciones();

    @Query(value = "SELECT * FROM dotaciones WHERE TipoHabitacion_id=:TipoHabitacion_id AND Producto_id=:Producto_id", nativeQuery = true)
    Dotacion darDotacion(@Param("TipoHabitacion_id") int TipoHabitacion_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO dotacion (TipoHabitacion_id, Producto_id) VALUES (:TipoHabitacion_id, :Producto_id)", nativeQuery = true)
    void insertarDotacion(@Param("TipoHabitacion_id") int TipoHabitacion_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE dotacion SET TipoHabitacion_id=:TipoHabitacion_id_actualizado, Producto_id=:Producto_id_actualizado WHERE TipoHabitacion_id=:TipoHabitacion_id AND Producto_id=:Producto_id", nativeQuery = true)
    void actualizarDotacion(@Param("TipoHabitacion_id") int TipoHabitacion_id, @Param("Producto_id") int Producto_id, @Param("TipoHabitacion_id_actualizado") int TipoHabitacion_id_actualizado, @Param("Producto_id_actualizado") int Producto_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM dotacion WHERE TipoHabitacion_id=:TipoHabitacion_id AND Producto_id=:Producto_id", nativeQuery = true)
    void eliminarDotacion(@Param("TipoHabitacion_id") int TipoHabitacion_id, @Param("Producto_id") int Producto_id);
}
