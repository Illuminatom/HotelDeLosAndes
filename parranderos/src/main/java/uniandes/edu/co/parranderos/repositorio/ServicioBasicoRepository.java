package uniandes.edu.co.parranderos.repositorio;

import java.sql.Date;
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

    @Query(value = "SELECT * FROM servicio_basico WHERE id >= :piso AND id <=:techo", nativeQuery = true)
    Collection<ServicioBasico> darServiciosBasicosEnIntervalo(@Param("piso") int piso, @Param("techo") int techo);

    @Query(value = "SELECT * FROM servicio_basico WHERE id=:id", nativeQuery = true)
    ServicioBasico darServicioBasico(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicio_basico (id, nombre, capacidad, costo, hora_apertura, hora_cierre) VALUES (:id, :nombre, :capacidad, :costo, :hora_apertura, :hora_cierre)", nativeQuery = true)
    void insertarServicioBasico(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("costo") int costo, @Param("hora_apertura") String hora_apertura, @Param("hora_cierre") String hora_cierre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicio_basico SET nombre=:nombre, capacidad=:capacidad, costo=:costo, hora_apertura=:hora_apertura, hora_cierre=:hora_cierre WHERE id=:id", nativeQuery = true)
    void actualizarServicioBasico(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("costo") int costo, @Param("hora_apertura") String hora_apertura, @Param("hora_cierre") String hora_cierre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicio_basico WHERE id=:id", nativeQuery = true)
    void eliminarServicioBasico(@Param("id") int id);

    @Query(value = "SELECT DISTINCT sb.* FROM (SELECT servicio_basico.* FROM consumo_servicio_cliente INNER JOIN servicio_basico ON servicio_basico.id = consumo_servicio_cliente.servicio_basico_id WHERE fecha >= :fecha_menor AND fecha <= :fecha_mayor ORDER BY fecha) sb WHERE ROWNUM <=20", nativeQuery = true)
    Collection<ServicioBasico> darServiciosMasPopularesEnUnIntervalo(@Param("fecha_menor") Date fecha_menor, @Param("fecha_mayor") Date fecha_mayor);

    @Query(value = "SELECT * FROM servicio_basico WHERE id >= :idMenor AND id <= :idMayor AND capacidad >= :capacidadPiso AND capacidad <= :capacidadTecho AND nombre LIKE '%' || :nombre || '%' AND costo >= :precioPiso AND costo <= :precioTecho AND TO_DATE(hora_apertura, 'HH24:MI') >= TO_DATE(:horaApertura, 'HH24:MI') AND TO_DATE(hora_cierre, 'HH24:MI') >= TO_DATE(:horaCierre, 'HH24:MI') ", nativeQuery = true)
    Collection<ServicioBasico> darServiciosConFiltros(@Param("idMenor") int idMenor, @Param("idMayor") int idMayor, @Param("capacidadPiso") int capacidadPiso, @Param("capacidadTecho") int capacidadTecho, @Param("nombre") String nombre, @Param("precioPiso") int precioPiso, @Param("precioTecho") int precioTecho, @Param("horaApertura") String horaApertura, @Param("horaCierre") String horaCierre);
}
