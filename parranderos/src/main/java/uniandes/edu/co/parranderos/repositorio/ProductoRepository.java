package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    @Query(value = "SELECT * FROM ", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM producto WHERE id=:id", nativeQuery = true)
    Producto darProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto (id, nombre, precio, cantidadDisponible, tipoProducto) VALUES (:nombre, :precio, :cantidadDisponible, :tipoProducto)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("precio") int precio, @Param("cantidadDisponible") int cantidadDisponible, @Param("tipoProducto") String tipoProducto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET nombre=:nombre, precio=:precio, cantidadDisponible=:cantidadDisponible, tipoProducto=:tipoProducto WHERE id=:id", nativeQuery = true)
    void actualizarProducto(@Param("id") int id, @Param("nombre") String nombre, @Param("precio") int precio, @Param("cantidadDisponible") int cantidadDisponible, @Param("tipoProducto") String tipoProducto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto WHERE id=:id", nativeQuery = true)
    void eliminarProducto(@Param("id") int id);
}