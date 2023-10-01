package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.PlatosRestauranteBar;

public interface PlatosRestauranteBarRepository extends JpaRepository<PlatosRestauranteBar, Integer>{
    @Query(value = "SELECT * FROM platos_restaurante_bar", nativeQuery = true)
    Collection<PlatosRestauranteBar> darPlatosRestauranteBar();

    @Query(value = "SELECT * FROM platos_restaurante_bar WHERE Restaurante_Bar_id=:Restaurante_Bar_id AND Plato_id=:Plato_id", nativeQuery = true)
    PlatosRestauranteBar darPlatoRestauranteBar(@Param("Restaurante_Bar_id") int Restaurante_Bar_id, @Param("Plato_id") int Plato_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO platos_restaurante_bar (Restaurante_Bar_id, Plato_id) VALUES (:Restaurante_Bar_id, :Plato_id)", nativeQuery = true)
    void insertarPlatosRestauranteBar(@Param("Restaurante_Bar_id") int Restaurante_Bar_id, @Param("Plato_id") int Plato_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE platos_restaurante_bar SET Restaurante_id=:Restaurante_Bar_id_actualizado, Plato_id=:Plato_id_actualizado WHERE Restaurante_Bar_id=:Restaurante_Bar_id AND Plato_id=:Plato_id", nativeQuery = true)
    void actualizarPlatosRestauranteBar(@Param("Restaurante_Bar_id") int Restaurante_Bar_id, @Param("Plato_id") int Plato_id, @Param("Restaurante_Bar_id_actualizado") int Restaurante_Bar_id_actualizado, @Param("Plato_id_actualizado") int Plato_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM platos_restaurante_bar WHERE Restaurante_Bar_id=:Restaurante_Bar_id AND Plato_id=:Plato_id", nativeQuery = true)
    void eliminarPlatosRestauranteBar(@Param("Restaurante_Bar_id") int Restaurante_Bar_id, @Param("Plato_id") int Plato_id);
}
