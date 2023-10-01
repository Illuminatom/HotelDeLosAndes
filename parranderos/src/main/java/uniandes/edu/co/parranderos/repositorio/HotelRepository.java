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
    @Query(value = "INSERT INTO hotel (id, nombre, num_estrellas) VALUES (:id, :nombre, :num_estrellas)", nativeQuery = true)
    void insertarHotel(@Param("id") int id, @Param("nombre") String nombre, @Param("num_estrellas") int num_estrellas);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hotel SET nombre =:nombre, num_estrellas=:num_estrellas WHERE id=:id", nativeQuery = true)
    void actualizarHotel(@Param("id") int id, @Param("nombre") String nombre, @Param("num_estrellas") int num_estrellas);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hotel WHERE id= :id", nativeQuery = true)
    void eliminarHotel(@Param("id") int id);
 }
