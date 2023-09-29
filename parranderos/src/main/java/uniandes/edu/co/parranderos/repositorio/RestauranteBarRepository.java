package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.RestauranteBar;

public interface RestauranteBarRepository extends JpaRepository<RestauranteBar, Integer>{
    @Query(value = "SELECT * FROM restaurantebar ", nativeQuery = true)
    Collection<RestauranteBar> darRestaurantesBares();

    @Query(value = "SELECT * FROM restaurantebar WHERE id=:id", nativeQuery = true)
    RestauranteBar darRestauranteBar(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO restaurantebar (id, estilo) VALUES (:id, :estilo)", nativeQuery = true)
    void insertarRestauranteBar(@Param("id") int id, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurantebar SET id=:id_actualizada, estilo=:estilo WHERE id=:id", nativeQuery = true)
    void actualizarRestauranteBar(@Param("id") int id, @Param("id_actualizada") int id_actualizada, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurantebar WHERE id=:id", nativeQuery = true)
    void eliminarRestauranteBar(@Param("id") int id);
}
