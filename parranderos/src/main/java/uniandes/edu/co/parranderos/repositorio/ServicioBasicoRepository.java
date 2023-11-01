package uniandes.edu.co.parranderos.repositorio;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ServicioBasico;

public interface ServicioBasicoRepository extends JpaRepository<ServicioBasico, Integer>{
    @Query(value = "SELECT * FROM servicio_basico", nativeQuery = true)
    Collection<ServicioBasico> darServiciosBasicos();

    @Query(value = "SELECT * FROM servicio_basico WHERE id=:id", nativeQuery = true)
    ServicioBasico darServicioBasico(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicio_basico (id, nombre, capacidad, costo, hora_apertura, hora_cierre) VALUES (:id, :nombre, :capacidad, :costo, :hora_apertura, :hora_cierre)", nativeQuery = true)
    void insertarServicioBasico(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("costo") int costo, @Param("hora_apertura") Timestamp hora_apertura, @Param("hora_cierre") Timestamp hora_cierre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicio_basico SET nombre=:nombre, capacidad=:capacidad, costo=:costo, hora_apertura=:hora_apertura, hora_cierre=:hora_cierre WHERE id=:id", nativeQuery = true)
    void actualizarServicioBasico(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("costo") int costo, @Param("hora_apertura") Timestamp hora_apertura, @Param("hora_cierre") Timestamp hora_cierre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicio_basico WHERE id=:id", nativeQuery = true)
    void eliminarServicioBasico(@Param("id") int id);
}
