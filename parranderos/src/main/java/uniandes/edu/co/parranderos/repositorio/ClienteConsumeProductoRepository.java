package uniandes.edu.co.parranderos.repositorio;

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

    @Query(value = "SELECT * FROM cliente_consume_producto WHERE Cliente_documento=:Cliente_documento AND Producto_id=:Producto_id", nativeQuery = true)
    ClienteConsumeProducto darClienteConsumeProducto(@Param("Cliente_documento") int Cliente_documento, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cliente_consume_producto (Cliente_documento, Producto_id, cantidad) VALUES :Cliente_documento, :Producto_id, :cantidad", nativeQuery = true)
    void insertarClienteConsumeProducto(@Param("Cliente_documento") int Cliente_documento, @Param("Producto_id") int Producto_id,@Param("cantidad") int cantidad );

    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente_consume_producto SET Cliente_documento=:Cliente_documento_actualizado, Producto_id=:Producto_id_actualizado, cantidad=:cantidad WHERE Cliente_documento=:Cliente_documento AND Producto_id=:Producto_id", nativeQuery = true)
    void actualizarClienteConsumeProducto(@Param("Cliente_documento") int Cliente_documento, @Param("Producto_id") int Producto_id,@Param("cantidad") int cantidad, @Param("Cliente_documento_actualizado") int Cliente_documento_actualizado, @Param("Producto_id_actualizado") int Producto_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente_consume_producto WHERE Cliente_documento=:Cliente_documento AND Producto_id=:Producto_id", nativeQuery = true)
    void eliminarClienteConsumeProducto(@Param("Cliente_documento") int Cliente_documento, @Param("Producto_id") int Producto_id);

}
