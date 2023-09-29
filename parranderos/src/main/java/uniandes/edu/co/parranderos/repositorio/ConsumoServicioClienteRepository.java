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
    @Query(value = "SELECT * FROM consumoserviciocliente", nativeQuery = true)
    Collection<ConsumoServicioCliente> darConsumoServiciosClientes();

    @Query(value = "SELECT * FROM consumoserviciocliente WHERE Cliente_documento=:Cliente_documento, ServicioBasico_id=:ServicioBasico_id, fecha=:fecha", nativeQuery = true)
    ConsumoServicioCliente darConsumoServicioCliente(@Param("Cliente_documento") int Cliente_documento, @Param("ServicioBasico_id") int ServicioBasico_id, @Param("fecha") Date fecha);    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumoserviciocliente (Cliente_documento, ServicioBasico_id, fecha, descripcion) VALUES (:Cliente_documento, :ServicioBasico_id, :fecha, :descripcion)", nativeQuery = true)
    void insertarConsumoServicioCliente(@Param("Cliente_documento") int Cliente_documento, @Param("ServicioBasico_id") int ServicioBasico_id, @Param("fecha") Date fecha, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumoserviciocliente SET Cliente_documento=:Cliente_documento_actualizado, ServicioBasico_id=:ServicioBasico_id_actualizado, fecha=:fecha_actualizada, descripcion=:descripcion WHERE Cliente_documento=:Cliente_documento, ServicioBasico_id=:ServicioBasico_id, fecha=:fecha", nativeQuery = true)
    void actualizarConsumoServicioCliente(@Param("Cliente_documento") int Cliente_documento, @Param("ServicioBasico_id") int ServicioBasico_id, @Param("fecha") Date fecha, @Param("descripcion") String descripcion, @Param("Cliente_documento_actualizado") int Cliente_documento_actualizado, @Param("ServicioBasico_id_actualizado") int ServicioBasico_id_actualizado, @Param("fecha_actualizada") Date fecha_actualizada);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumoserviciocliente WHERE Cliente_documento=:Cliente_documento, ServicioBasico_id=:ServicioBasico_id, fecha=:fecha", nativeQuery = true)
    void eliminarConsumoServicioCliente(@Param("Cliente_documento") int Cliente_documento, @Param("ServicioBasico_id") int ServicioBasico_id, @Param("fecha") Date fecha);
}
