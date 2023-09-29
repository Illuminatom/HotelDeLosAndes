package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Integer>{
    @Query(value = "SELECT * FROM plato", nativeQuery = true)
    Collection<Plato> darPlatos();

    @Query(value = "SELECT * FROM plato WHERE id=:id", nativeQuery = true)
    Plato darPlato(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO plato (id, descripcion) VALUES (:id, :descripcion)", nativeQuery = true)
    void insertarPlato(@Param("id") int id, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE plato SET id=:id_actualizada, descripcion=:descripcion WHERE id=:id", nativeQuery = true)
    void actualizarPlato(@Param("id") int id, @Param("id_actualizada") int id_actualizada, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM plato WHERE id=:id", nativeQuery = true)
    void eliminarPlato(@Param("id") int id);
}
