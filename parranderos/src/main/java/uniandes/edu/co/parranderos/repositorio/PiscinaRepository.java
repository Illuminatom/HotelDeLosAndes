package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer>{
    @Query(value = "SELECT * FROM piscina", nativeQuery = true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT * FROM piscina WHERE id=:id", nativeQuery = true)
    Piscina darPiscina(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscina(id, profundidad, costo) VALUES (:id, :profundidad, :costo)", nativeQuery = true)
    void insertarPiscina(@Param("id") int id, @Param("profundidad") int profundidad, @Param("costo") int costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscina SET id=:id_actualizada, profundidad=:profundidad, costo=:costo WHERE id=:id", nativeQuery = true)
    void actualizarPiscina(@Param("id") int id, @Param("id_actualizada") int id_actualizada, @Param("profundidad") int profundidad, @Param("costo") int costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscina WHERE id=:id", nativeQuery = true)
    void eliminarPiscina(@Param("id") int id);    
}
