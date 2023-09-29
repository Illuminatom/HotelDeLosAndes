package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.parranderos.modelo.SPA;

public interface SPARepository extends JpaRepository<SPA, Integer> {

    @Query(value = "SELECT * FROM spa", nativeQuery = true)
    Collection<SPA> darSpas();

    @Query(value = "SELECT * FROM spa WHERE id = :id", nativeQuery = true)
    SPA darSpaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spa (id) VALUES (:id)", nativeQuery = true)
    void insertarSPA(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE spa SET id = :id_actualizado WHERE id = :id", nativeQuery = true)
    void actualizarSPA(@Param("id") int id, @Param("id_actualizado") int id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spa WHERE id = :id", nativeQuery = true)
    void eliminarSPA(@Param("id") int id);
}
