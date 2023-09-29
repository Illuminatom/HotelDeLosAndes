package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
    @Query(value = "SELECT * FROM hotel", nativeQuery = true)
    Collection<Hotel> darHoteles();    

    @Query(value = "SELECT * FROM hotel WHERE id = :id", nativeQuery = true)
    Hotel darHotel(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hotel (id, nombre, numEstrellas) VALUES (:nombre, :numEstrellas)", nativeQuery = true)
    void insertarHotel(@Param("nombre") String nombre, @Param("numEstrellas") int numEstrellas);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hotel SET nombre =:nombre, numEstrellas=:numEstrellas WHERE id=:id", nativeQuery = true)
    void actualizarHotel(@Param("id") int id, @Param("nombre") String nombre, @Param("numEstrellas") int numEstrellas);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hotel WHERE id= :id", nativeQuery = true)
    void eliminarHotel(@Param("id") int id);
 }
