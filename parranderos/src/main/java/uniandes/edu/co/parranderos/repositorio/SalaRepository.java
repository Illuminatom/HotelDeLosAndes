package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer>{
    @Query(value = "SELECT * FROM sala", nativeQuery = true)
    Collection<Sala> darSalas();

    @Query(value = "SELECT * FROM sala WHERE id=:id", nativeQuery = true)
    Sala darSala(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sala (id, tipo, costo) VALUES (:id, :tipo, :costo)", nativeQuery = true)
    void insertar(@Param("id") int id, @Param("tipo") String tipo, @Param("costo") int costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE sala SET id=:id_actualizada, tipo=:tipo, costo=:costo WHERE id=:id", nativeQuery = true)
    void actualizarSala(@Param("id") int id, @Param("id_actualizada") int id_actualizada, @Param("tipo") String tipo, @Param("costo") int costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sala WHERE id=:id", nativeQuery = true)
    void eliminarSala(@Param("id") int id);
}
