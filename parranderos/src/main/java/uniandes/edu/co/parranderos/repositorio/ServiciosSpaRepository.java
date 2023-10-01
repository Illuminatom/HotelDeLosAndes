package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ServiciosSpa;

public interface ServiciosSpaRepository extends JpaRepository<ServiciosSpa, Integer>{
    @Query(value = "SELECT * FROM servicios_spa", nativeQuery = true)
    Collection<ServiciosSpa> darServiciosSpas();

    @Query(value = "SELECT * FROM servicios_spa WHERE SPA_id=:SPA_id AND Servicio_Spa_id=:Servicio_Spa_id", nativeQuery = true)
    ServiciosSpa darServicioSpa(@Param("SPA_id") int SPA_id, @Param("Servicio_Spa_id") int Servicio_Spa_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios_spa (SPA_id, Servicio_Spa_id) VALUES (:SPA_id, :Servicio_Spa_id)", nativeQuery = true)
    void insertarServicioSpa(@Param("SPA_id") int SPA_id, @Param("Servicio_Spa_id") int Servicio_Spa_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios_spa SET SPA_id=:SPA_id_actualizado, Servicio_Spa_id=:Servicio_Spa_id_actualizado WHERE SPA_id=:SPA_id AND Servicio_Spa_id=:Servicio_Spa_id", nativeQuery = true)
    void actualizarServicioSpa(@Param("SPA_id") int SPA_id, @Param("Servicio_Spa_id") int Servicio_Spa_id, @Param("SPA_id_actualizado") int SPA_id_actualizado, @Param("Servicio_Spa_id_actualizado") int Servicio_Spa_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios_spa WHERE SPA_id=:SPA_id AND Servicio_Spa_id=:Servicio_Spa_id", nativeQuery = true)
    void eliminarServicioSpa(@Param("SPA_id") int SPA_id, @Param("Servicio_Spa_id") int Servicio_Spa_id);
}
