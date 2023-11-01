package uniandes.edu.co.parranderos.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ConsumoServicioCliente;

public interface ConsumoServicioClienteRepository extends JpaRepository<ConsumoServicioCliente, Integer>{
    @Query(value = "SELECT * FROM consumo_servicio_cliente", nativeQuery = true)
    Collection<ConsumoServicioCliente> darConsumoServiciosClientes();

    @Query(value = "SELECT * FROM consumo_servicio_cliente WHERE ReservaHotel_id=:ReservaHotel_id, Servicio_Basico_id=:Servicio_Basico_id, fecha=:fecha", nativeQuery = true)
    ConsumoServicioCliente darConsumoServicioCliente(@Param("ReservaHotel_id") int ReservaHotel_id, @Param("Servicio_Basico_id") int Servicio_Basico_id, @Param("fecha") Date fecha);    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumo_servicio_cliente (ReservaHotel_id, Servicio_Basico_id, fecha, descripcion, costo) VALUES (:ReservaHotel_id, :Servicio_Basico_id, :fecha, :descripcion, :costo)", nativeQuery = true)
    void insertarConsumoServicioCliente(@Param("ReservaHotel_id") int ReservaHotel_id, @Param("Servicio_Basico_id") int Servicio_Basico_id, @Param("fecha") Date fecha, @Param("descripcion") String descripcion, @Param("costo") int costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumo_servicio_cliente SET ReservaHotel_id=:ReservaHotel_id_actualizado, Servicio_Basico_id=:Servicio_Basico_id_actualizado, fecha=:fecha_actualizada, descripcion=:descripcion, costo=:costo WHERE ReservaHotel_id=:ReservaHotel_id, Servicio_Basico_id=:Servicio_Basico_id, fecha=:fecha, costo=:costo", nativeQuery = true)
    void actualizarConsumoServicioCliente(@Param("ReservaHotel_id") int ReservaHotel_id, @Param("Servicio_Basico_id") int Servicio_Basico_id, @Param("fecha") Date fecha, @Param("descripcion") String descripcion, @Param("ReservaHotel_id_actualizado") int ReservaHotel_id_actualizado, @Param("Servicio_Basico_id_actualizado") int Servicio_Basico_id_actualizado, @Param("fecha_actualizada") Date fecha_actualizada, @Param("costo") int costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumo_servicio_cliente WHERE ReservaHotel_id=:ReservaHotel_id, Servicio_Basico_id=:Servicio_Basico_id, fecha=:fecha", nativeQuery = true)
    void eliminarConsumoServicioCliente(@Param("ReservaHotel_id") int ReservaHotel_id, @Param("Servicio_Basico_id") int Servicio_Basico_id, @Param("fecha") Date fecha);
}
