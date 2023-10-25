package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.ProductoPlan;

public interface ProductoPlanRepository extends JpaRepository<ProductoPlan, Integer> {
    @Query(value = "SELECT * FROM producto_plan", nativeQuery = true)
    Collection<ProductoPlan> darProductosPlanes();

    @Query(value = "SELECT * FROM producto_plan WHERE Producto_id=:Producto_id AND Plan_id=:Plan_id", nativeQuery = true)
    ProductoPlan darProductoPlan(@Param("Producto_id") int Producto_id, @Param("Plan_id") int Plan_id);

    @Query(value = "SELECT * FROM producto_plan WHERE Plan_id=:Plan_id", nativeQuery = true)
    Collection<ProductoPlan> darProductosPlan(@Param("Plan_id") int Plan_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto_plan (Producto_id, Plan_id, cantidad, descripcion) VALUES (:Producto_id, :Plan_id, :cantidad, :descripcion)", nativeQuery = true)
    void insertarProductoPlan(@Param("Producto_id") int Producto_id, @Param("Plan_id") int Plan_id, @Param("cantidad") int cantidad, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto_plan SET Producto_id=:Producto_id_actualizado, Plan_id=:Plan_id_actualizado, cantidad=:cantidad, descripcion=:descripcion WHERE Producto_id=:Producto_id AND Plan_id=:Plan_id", nativeQuery = true)
    void actualizarProductoPlan(@Param("Producto_id") int Producto_id, @Param("Plan_id") int Plan_id, @Param("Producto_id_actualizado") int Producto_id_actualizado, @Param("Plan_id_actualizado") int Plan_id_actualizado, @Param("cantidad") int cantidad, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto_plan WHERE Producto_id=:Producto_id AND Plan_id=:Plan_id", nativeQuery = true)
    void eliminarProductoPlan(@Param("Producto_id") int Producto_id, @Param("Plan_id") int Plan_id);
}
