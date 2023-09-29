package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ServicioBasico;

public interface ServicioBasicoRepository extends JpaRepository<ServicioBasico, Integer>{
    @Query(value = "SELECT * FROM serviciobasico", nativeQuery = true)
    Collection<ServicioBasico> darServiciosBasicos();

    @Query(value = "SELECT * FROM serviciobasico WHERE id=:id", nativeQuery = true)
    ServicioBasico darServicioBasico(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciobasico (id, nombre, capacidad) VALUES (:nombre, :capacidad)", nativeQuery = true)
    void insertarServicioBasico(@Param("nombre") String nombre, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciobasico SET nombre=:nombre, capacidad=:capacidad WHERE id=:id", nativeQuery = true)
    void actualizarServicioBasico(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciobasico WHERE id=:id", nativeQuery = true)
    void eliminarServicioBasico(@Param("id") int id);
}
