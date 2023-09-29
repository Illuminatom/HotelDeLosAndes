package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ServicioPlan;

public interface ServicioPlanRepository extends JpaRepository<ServicioPlan, Integer> {
    @Query(value = "SELECT * FROM servicioplan", nativeQuery = true)
    Collection<ServicioPlan> darServiciosPlanes();

    @Query(value = "SELECT * FROM servicioplan WHERE Plan_id=:Plan_id AND ServicioBasico_id=:ServicioBasico_id", nativeQuery = true)
    ServicioPlan darServicioPlan(@Param("Plan_id") int Plan_id, @Param("ServicioBasico_id") int ServicioBasico_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicioplan (Plan_id, ServicioBasico_id, descuento) VALUES (:Plan_id, :ServicioBasico_id, :descuento)", nativeQuery = true)
    void insertarServicioPlan(@Param("Plan_id") int Plan_id, @Param("ServicioBasico_id") int ServicioBasico_id, @Param("descuento") int descuento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicioplan SET Plan_id=:Plan_id_actualizado, ServicioBasico_id=:ServicioBasico_id_actualizado, descuento=:descuento WHERE Plan_id=:Plan_id AND ServicioBasico_id=:ServicioBasico_id", nativeQuery = true)
    void actualizarServicioPlan(@Param("Plan_id") int Plan_id, @Param("ServicioBasico_id") int ServicioBasico_id, @Param("Plan_id_actualizado") int Plan_id_actualizado, @Param("ServicioBasico_id_actualizado") int ServicioBasico_id_actualizado, @Param("descuento") int descuento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicioplan WHERE Plan_id=:Plan_id AND ServicioBasico_id=:ServicioBasico_id", nativeQuery = true)
    void eliminarServicioPlan(@Param("Plan_id") int Plan_id, @Param("ServicioBasico_id") int ServicioBasico_id);
}
