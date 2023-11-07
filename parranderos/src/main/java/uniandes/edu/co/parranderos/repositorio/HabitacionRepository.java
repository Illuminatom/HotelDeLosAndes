package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    @Query(value = "SELECT * FROM habitacion", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitacion WHERE id >= :piso AND id <= :techo", nativeQuery = true)
    Collection<Habitacion> darHabitacionesEnIntervalo(@Param("piso") int piso, @Param("techo") int techo);

    @Query(value = "SELECT * FROM habitacion WHERE id=:id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitacion (id, disponible, Hotel_id, tipo_habitacion_id) VALUES (:id, :disponible, :Hotel_id, :tipo_habitacion_id)", nativeQuery = true)
    void insertarHabitacion(@Param("id") int id, @Param("disponible") String disponible, @Param("Hotel_id") int Hotel_id, @Param("tipo_habitacion_id") int tipo_habitacion_id);    

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacion SET disponible=:disponible, Hotel_id=:Hotel_id, tipo_habitacion_id=:tipo_habitacion_id WHERE id=:id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") int id, @Param("disponible") String disponible, @Param("Hotel_id") int Hotel_id, @Param("tipo_habitacion_id") int tipo_habitacion_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitacion WHERE id=:id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") int id);

    @Query(value = "SELECT SUM (cliente_consume_producto.costo) as total FROM habitacion INNER JOIN reserva_hotel ON habitacion.id = reserva_hotel.habitacion_id INNER JOIN cliente_consume_producto ON reserva_hotel.id = cliente_consume_producto.Reserva_Hotel_id WHERE habitacion.id=:id_habitacion AND cliente_consume_producto.fecha >= SYSDATE - INTERVAL '1' YEAR GROUP BY habitacion.id", nativeQuery = true)
    Integer darCostoTotalProductosPorHabitacion(@Param("id_habitacion") int idHabitacion);

    @Query(value = "SELECT SUM (consumo_servicio_cliente.costo) as total FROM habitacion INNER JOIN reserva_hotel ON habitacion.id = reserva_hotel.habitacion_id INNER JOIN consumo_servicio_cliente ON reserva_hotel.id = consumo_servicio_cliente.Reserva_Hotel_id WHERE habitacion.id=:id_habitacion AND consumo_servicio_cliente.fecha >= SYSDATE - INTERVAL '1' YEAR GROUP BY habitacion.id", nativeQuery = true)
    Integer darCostoTotalServiciosPorHabitacion(@Param("id_habitacion") int idHabitacion);

    @Query(value = "SELECT SUM(TO_DATE(FECHA_SALIDA, 'DD-MON-RR') - TO_DATE(FECHA_ENTRADA, 'DD-MON-RR')) AS dias_ocupada FROM reserva_hotel WHERE FECHA_ENTRADA >= TRUNC(SYSDATE - 365) AND habitacion_id = :habitacion_id GROUP BY habitacion_id", nativeQuery = true)
    Double darDuracionReservaPorHabitacionEnElUltimoAnio(@Param("habitacion_id") int idHabitacion);
}