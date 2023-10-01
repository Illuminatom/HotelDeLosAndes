package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ServicioSpa;

public interface ServicioSpaRepository extends JpaRepository<ServicioSpa, Integer>{
    @Query(value = "SELECT * FROM servicio_spa", nativeQuery = true)
    Collection<ServicioSpa> darServiciosSpas();

    @Query(value = "SELECT * FROM servicio_spa WHERE id=:id", nativeQuery = true)
    ServicioSpa darServicioSpa(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicio_spa (id, duracion) VALUES (:id, :duracion)", nativeQuery = true)
    void insertarServicioSpa(@Param("id") int id, @Param("duracion") String duracion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicio_spa SET id=:id_actualizada, duracion=:duracion WHERE id=:id", nativeQuery = true)
    void actualizarServicioSpa(@Param("id") int id, @Param("id_actualizada") int id_actualizada, @Param("duracion") String duracion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicio_spa WHERE id=:id", nativeQuery = true)
    void eliminarServicioSpa(@Param("id") int id);
}
