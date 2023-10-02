package uniandes.edu.co.parranderos.repositorio;

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
    @Query(value = "INSERT INTO servicio_basico (id, nombre, capacidad) VALUES (:id, :nombre, :capacidad)", nativeQuery = true)
    void insertarServicioBasico(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicio_basico SET nombre=:nombre, capacidad=:capacidad WHERE id=:id", nativeQuery = true)
    void actualizarServicioBasico(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicio_basico WHERE id=:id", nativeQuery = true)
    void eliminarServicioBasico(@Param("id") int id);
}
