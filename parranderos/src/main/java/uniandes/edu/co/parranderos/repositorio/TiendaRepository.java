package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.parranderos.modelo.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

    @Query(value = "SELECT * FROM tienda", nativeQuery = true)
    Collection<Tienda> darTiendas();

    @Query(value = "SELECT * FROM tienda WHERE id = :id", nativeQuery = true)
    Tienda darTiendaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tienda (id, tipo) VALUES (:id, :tipo)", nativeQuery = true)
    void insertarTienda(@Param("id") int id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tienda SET id=:id_actualizado tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarTienda(@Param("id") int id, @Param("id_actualizado") int id_actualizado, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tienda WHERE id = :id", nativeQuery = true)
    void eliminarTienda(@Param("id") int id);
}
