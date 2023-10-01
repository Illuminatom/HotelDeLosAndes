package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.EquiposSala;

public interface EquiposSalaRepository extends JpaRepository<EquiposSala, Integer>{
    @Query(value = "SELECT * FROM equipos_sala", nativeQuery = true)
    Collection<EquiposSala> darEquiposSalas();

    @Query(value = "SELECT * FROM equipos_sala WHERE Sala_id=:Sala_id AND Producto_id=:Producto_id", nativeQuery = true)
    EquiposSala darEquiposSala(@Param("Sala_id") int Sala_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO equipos_sala (Sala_id, Producto_id) VALUES (:Sala_id, :Producto_id)", nativeQuery = true)
    void insertarEquiposSala(@Param("Sala_id") int Sala_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE equipo_ssala SET Sala_id=:Sala_id_actualizado, Producto_id=:Producto_id_actualizado) WHERE Sala_id=:Sala_id AND Producto_id=:Producto_id", nativeQuery = true)
    void actualizarEquiposSala(@Param("Sala_id") int Sala_id, @Param("Producto_id") int Producto_id, @Param("Sala_id_actualizado") int Sala_id_actualizado, @Param("Producto_id_actualizado") int Producto_id_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM equipos_sala WHERE Sala_id=:Sala_id AND Producto_id=:Producto_id", nativeQuery = true)
    void eliminarEquiposSala(@Param("Sala_id") int Sala_id, @Param("Producto_id") int Producto_id);
}
