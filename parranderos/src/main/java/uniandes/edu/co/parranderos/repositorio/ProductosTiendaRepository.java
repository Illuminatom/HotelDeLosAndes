package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ProductosTienda;

public interface ProductosTiendaRepository extends JpaRepository<ProductosTienda, Integer> {
    @Query(value = "SELECT * FROM productostienda", nativeQuery = true)
    Collection<ProductosTienda> darProductosTienda();

    @Query(value = "SELECT * FROM productostienda WHERE Tienda_id=:Tienda_id AND Producto_id=:Producto_id", nativeQuery = true)
    ProductosTienda darProductoTienda(@Param("Tienda_id") int Tienda_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productostienda (Tienda_id, Producto_id) VALUES (:Tienda_id, :Producto_id)", nativeQuery = true)
    void insertarProductoTienda(@Param("Tienda_id") int Tienda_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productostienda SET Tienda_id=:Tienda_id_actualizado, Producto_id=:Producto_id_actualizado WHERE Tienda_id=:Tienda_id AND Producto_id=:Producto_id", nativeQuery = true)
    void actualizarProductoTienda(@Param("Tienda_id") int Tienda_id, @Param("Producto_id") int Producto_id, @Param("Tienda_id_actualizado") int Tienda_id_actualizado, @Param("Producto_id_actualizado") int Producto_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productostienda WHERE Tienda_id=:Tienda_id AND Producto_id=:Producto_id", nativeQuery = true)
    void eliminaProductoTienda(@Param("Tienda_id") int Tienda_id, @Param("Producto_id") int Producto_id);    
}
