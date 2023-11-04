package uniandes.edu.co.parranderos.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ClienteConsumeProducto;

public interface ClienteConsumeProductoRepository extends JpaRepository<ClienteConsumeProducto, Integer>{
    @Query(value = "SELECT * FROM cliente_consume_producto", nativeQuery = true)
    Collection<ClienteConsumeProducto> darClientesConsumenProductos();

    @Query(value = "SELECT * FROM cliente_consume_producto WHERE ReservaHotel_id=:ReservaHotel_id AND Producto_id=:Producto_id AND fecha=:fecha", nativeQuery = true)
    ClienteConsumeProducto darClienteConsumeProducto(@Param("ReservaHotel_id") int ReservaHotel_id, @Param("Producto_id") int Producto_id, @Param("fecha") Date fecha);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cliente_consume_producto (ReservaHotel_id, Producto_id, cantidad, fecha, costo, descripcion) VALUES :ReservaHotel_id, :Producto_id, :cantidad, :fecha, :costo, :descripcion", nativeQuery = true)
    void insertarClienteConsumeProducto(@Param("ReservaHotel_id") int ReservaHotel_id, @Param("Producto_id") int Producto_id,@Param("cantidad") int cantidad, @Param("fecha") Date fecha, @Param("costo") int costo, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente_consume_producto SET ReservaHotel_id=:ReservaHotel_id_actualizado, Producto_id=:Producto_id_actualizado, cantidad=:cantidad, fecha=:fecha_actualizada, costo=:costo, descripcion=:descripcion WHERE ReservaHotel_id=:ReservaHotel_id AND Producto_id=:Producto_id, fecha=:fecha", nativeQuery = true)
    void actualizarClienteConsumeProducto(@Param("ReservaHotel_id") int ReservaHotel_id, @Param("Producto_id") int Producto_id,@Param("cantidad") int cantidad, @Param("ReservaHotel_id_actualizado") int ReservaHotel_id_actualizado, @Param("Producto_id_actualizado") int Producto_id_actualizado, @Param("fecha_actualizada") Date fecha_actualizada, @Param("fecha") Date fecha, @Param("costo") int costo, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente_consume_producto WHERE ReservaHotel_id=:ReservaHotel_id AND Producto_id=:Producto_id AND fecha=:fecha", nativeQuery = true)
    void eliminarClienteConsumeProducto(@Param("ReservaHotel_id") int ReservaHotel_id, @Param("Producto_id") int Producto_id, @Param("fecha") Date fecha);

}
