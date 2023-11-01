package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer>{
    @Query(value = "SELECT * FROM gimnasio", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasio WHERE id=:id", nativeQuery = true)
    Gimnasio darGimnasio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasio (id) VALUES (:id)", nativeQuery = true)
    void insertarGimnasio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasio SET id=:id_actualizado WHERE id=:id", nativeQuery = true)
    void actualizarGimnasio(@Param("id") int id, @Param("id_actualizado") int id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasio WHERE id=:id", nativeQuery = true)
    void eliminarGimnasio(@Param("id") int id);
}