package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{
    @Query(value = "SELECT * FROM prestamo", nativeQuery = true)
    Collection<Prestamo> darPrestamos();

    @Query(value = "SELECT * FROM prestamo WHERE id=:id", nativeQuery = true)
    Prestamo darPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamo (id, Producto_id) VALUES (:id, :Producto_id)", nativeQuery = true)
    void insertarPrestamo(@Param("id") int id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamo SET id=:id_actualizada, Producto_id=:Producto_id WHERE id=:id", nativeQuery = true)
    void actualizarPrestamo(@Param("id") int id, @Param("id_actualizada") int id_actualizada, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamo WHERE id=:id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") int id);
}
