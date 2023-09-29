package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.PlatosRestauranteBar;

public interface PlatosRestauranteBarRepository extends JpaRepository<PlatosRestauranteBar, Integer>{
    @Query(value = "SELECT * FROM platosrestaurantebar", nativeQuery = true)
    Collection<PlatosRestauranteBar> darPlatosRestauranteBar();

    @Query(value = "SELECT * FROM platosrestaurantebar WHERE RestauranteBar_id=:RestauranteBar_id AND Plato_id=:Plato_id", nativeQuery = true)
    PlatosRestauranteBar darPlatoRestauranteBar(@Param("RestauranteBar_id") int RestauranteBar_id, @Param("Plato_id") int Plato_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO platosrestaurantebar (RestauranteBar_id, Plato_id) VALUES (:RestauranteBar_id, :Plato_id)", nativeQuery = true)
    void insertarPlatosRestauranteBar(@Param("RestauranteBar_id") int RestauranteBar_id, @Param("Plato_id") int Plato_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE platosrestaurantebar SET Restaurante_id=:RestauranteBar_id_actualizado, Plato_id=:Plato_id_actualizado WHERE RestauranteBar_id=:RestauranteBar_id AND Plato_id=:Plato_id", nativeQuery = true)
    void actualizarPlatosRestauranteBar(@Param("RestauranteBar_id") int RestauranteBar_id, @Param("Plato_id") int Plato_id, @Param("RestauranteBar_id_actualizado") int RestauranteBar_id_actualizado, @Param("Plato_id_actualizado") int Plato_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM platosrestaurantebar WHERE RestauranteBar_id=:RestauranteBar_id AND Plato_id=:Plato_id", nativeQuery = true)
    void eliminarPlatosRestauranteBar(@Param("RestauranteBar_id") int RestauranteBar_id, @Param("Plato_id") int Plato_id);
}
