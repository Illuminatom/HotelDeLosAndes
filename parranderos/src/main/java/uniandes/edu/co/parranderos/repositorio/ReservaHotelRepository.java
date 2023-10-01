package uniandes.edu.co.parranderos.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ReservaHotel;

public interface ReservaHotelRepository extends JpaRepository<ReservaHotel, Integer>{
    @Query(value = "SELECT * FROM reserva_hotel", nativeQuery = true)
    Collection<ReservaHotel> darReservasHotel();

    @Query(value = "SELECT * FROM reserva_hotel WHERE id=:id", nativeQuery = true)
    ReservaHotel darReservaHotel(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reserva_hotel (id, fecha_entrada, fechaSalida, numPersonas, Habitacion_id, Cliente_id, Plan_id) VALUES (:id , :fecha_entrada, :fechaSalida, :numPersonas, :Habitacion_id, :Cliente_id, :Plan_id)", nativeQuery = true)
    void insertarReservaHotel(@Param("id") int id, @Param("fecha_entrada") Date fecha_entrada, @Param("fechaSalida") Date fechaSalida, @Param("numPersonas") int numPersonas, @Param("Habitacion_id") int Habitacion_id, @Param("Cliente_id") int Cliente_id, @Param("Plan_id") int Plan_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reserva_hotel SET fecha_entrada=:fecha_entrada, fechaSalida=:fechaSalida, numPersonas=:numPersonas, Habitacion_id=:Habitacion_id, Cliente_id=:Cliente_id, Plan_id=:Plan_id WHERE id=:id", nativeQuery = true)
    void actualizarReservaHotel(@Param("id") int id, @Param("fecha_entrada") Date fecha_entrada, @Param("fechaSalida") Date fechaSalida, @Param("numPersonas") int numPersonas, @Param("Habitacion_id") int Habitacion_id, @Param("Cliente_id") int Cliente_id, @Param("Plan_id") int Plan_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reserva_hotel WHERE id=:id", nativeQuery = true)
    void eliminarReservaHotel(@Param("id") int id);
}
