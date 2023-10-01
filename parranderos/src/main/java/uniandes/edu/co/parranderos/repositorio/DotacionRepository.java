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

    @Query(value = "SELECT * FROM dotacion WHERE Tipo_Habitacion_id=:Tipo_Habitacion_id AND Producto_id=:Producto_id", nativeQuery = true)
    Dotacion darDotacion(@Param("Tipo_Habitacion_id") int Tipo_Habitacion_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO dotacion (Tipo_Habitacion_id, Producto_id) VALUES (:Tipo_Habitacion_id, :Producto_id)", nativeQuery = true)
    void insertarDotacion(@Param("Tipo_Habitacion_id") int Tipo_Habitacion_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE dotacion SET Tipo_Habitacion_id=:Tipo_Habitacion_id_actualizado, Producto_id=:Producto_id_actualizado WHERE Tipo_Habitacion_id=:Tipo_Habitacion_id AND Producto_id=:Producto_id", nativeQuery = true)
    void actualizarDotacion(@Param("Tipo_Habitacion_id") int Tipo_Habitacion_id, @Param("Producto_id") int Producto_id, @Param("Tipo_Habitacion_id_actualizado") int Tipo_Habitacion_id_actualizado, @Param("Producto_id_actualizado") int Producto_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM dotacion WHERE Tipo_Habitacion_id=:Tipo_Habitacion_id AND Producto_id=:Producto_id", nativeQuery = true)
    void eliminarDotacion(@Param("Tipo_Habitacion_id") int Tipo_Habitacion_id, @Param("Producto_id") int Producto_id);
}
