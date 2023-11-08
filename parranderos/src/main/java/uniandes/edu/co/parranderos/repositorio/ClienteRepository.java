package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    @Query(value = "SELECT * FROM cliente", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM cliente WHERE ROWNUM <= :limit", nativeQuery = true)
    Collection<Cliente> darClientesParcial(@Param("limit") int limit);
    
    @Query(value = "SELECT * FROM cliente WHERE documento=:documento", nativeQuery = true)
    Cliente darCliente(@Param("documento") int documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cliente (documento, metodo_Pago)", nativeQuery = true)
    void insertarCliente(@Param("documento") int documento, @Param("metodo_Pago") String metodo_Pago);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente SET documento=:documento_actualizado, metodo_Pago=:metodo_Pago WHERE documento=:documento", nativeQuery = true)
    void actualizarCliente(@Param("documento") int documento, @Param("documento_actualizado") int documento_actualizado,@Param("metodo_Pago") String metodo_Pago);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente WHERE documento=:documento", nativeQuery = true)
    void eliminarCliente(@Param("documento") int documento);

    @Query(value = "SELECT SUM(consumo_servicio_cliente.costo) as consumo FROM cliente INNER JOIN reserva_hotel ON reserva_hotel.cliente_id = cliente.documento INNER JOIN consumo_servicio_cliente ON consumo_servicio_cliente.reserva_hotel_id = reserva_hotel.id WHERE consumo_servicio_cliente.fecha >= SYSDATE - INTERVAL '1' YEAR AND cliente.documento = :documento GROUP BY cliente.documento", nativeQuery = true)
    Integer darConsumoServiciosClienteUltimoAnio(@Param("documento") int documento);

    @Query(value = "SELECT SUM(cliente_consume_producto.costo) as consumo FROM cliente INNER JOIN reserva_hotel ON reserva_hotel.cliente_id = cliente.documento INNER JOIN cliente_consume_producto ON cliente_consume_producto.reserva_hotel_id = reserva_hotel.id WHERE cliente_consume_producto.fecha >= SYSDATE - INTERVAL '1' YEAR AND cliente.documento = :documento GROUP BY cliente.documento", nativeQuery = true)
    Integer darConsumoProductoClienteUltimoAnio(@Param("documento") int documento);

    @Query(value = "SELECT * FROM (SELECT SUM(TO_DATE(FECHA_SALIDA, 'DD-MON-RR') - TO_DATE(FECHA_ENTRADA, 'DD-MON-RR')) AS diasAlojado FROM reserva_hotel WHERE FECHA_ENTRADA >= TRUNC(SYSDATE - 365) AND reserva_hotel.cliente_id=:clienteId GROUP BY reserva_hotel.cliente_id) WHERE diasAlojado >=14 ORDER BY diasAlojado", nativeQuery = true)
    Integer darDiasOcupadaUltimoAnio(@Param("clienteId") int clienteId);
}
