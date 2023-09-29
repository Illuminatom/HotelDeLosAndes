package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ServiciosSpa;

public interface ServiciosSpaRepository extends JpaRepository<ServiciosSpa, Integer>{
    @Query(value = "SELECT * FROM serviciosspa", nativeQuery = true)
    Collection<ServiciosSpa> darServiciosSpas();

    @Query(value = "SELECT * FROM serviciosspa WHERE SPA_id=:SPA_id AND ServicioSpa_id=:ServicioSpa_id", nativeQuery = true)
    ServiciosSpa darServicioSpa(@Param("SPA_id") int SPA_id, @Param("ServicioSpa_id") int ServicioSpa_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciosspa (SPA_id, ServicioSpa_id) VALUES (:SPA_id, :ServicioSpa_id)", nativeQuery = true)
    void insertarServicioSpa(@Param("SPA_id") int SPA_id, @Param("ServicioSpa_id") int ServicioSpa_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosspa SET SPA_id=:SPA_id_actualizado, ServicioSpa_id=:ServicioSpa_id_actualizado WHERE SPA_id=:SPA_id AND ServicioSpa_id=:ServicioSpa_id", nativeQuery = true)
    void actualizarServicioSpa(@Param("SPA_id") int SPA_id, @Param("ServicioSpa_id") int ServicioSpa_id, @Param("SPA_id_actualizado") int SPA_id_actualizado, @Param("ServicioSpa_id_actualizado") int ServicioSpa_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosspa WHERE SPA_id=:SPA_id AND ServicioSpa_id=:ServicioSpa_id", nativeQuery = true)
    void eliminarServicioSpa(@Param("SPA_id") int SPA_id, @Param("ServicioSpa_id") int ServicioSpa_id);
}
