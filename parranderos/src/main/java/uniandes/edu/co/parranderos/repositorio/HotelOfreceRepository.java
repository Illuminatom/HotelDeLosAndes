package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.HotelOfrece;

public interface HotelOfreceRepository extends JpaRepository<HotelOfrece, Integer>{
    @Query(value = "SELECT * FROM hotelofrece", nativeQuery = true)
    Collection<HotelOfrece> darHotelesOfrecen();

    @Query(value = "SELECT * FROM WHERE Hotel_id=:Hotel_id AND ServicioBasico_id=:ServicioBasico_id", nativeQuery = true)
    HotelOfrece darHotelOfrece(@Param("Hotel_id") int Hotel_id, @Param("ServicioBasico_id") int ServicioBasico_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hotelofrece (Hotel_id, ServicioBasico_id) VALUES (:Hotel_id, :ServicioBasico_id)", nativeQuery = true)
    void insertarHotelOfrece(@Param("Hotel_id") int Hotel_id, @Param("ServicioBasico_id") int ServicioBasico_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hotelOfrece SET Hotel_id=:Hotel_id_actualizado, ServicioBasico_id=:ServicioBasico_id_actualizado WHERE Hotel_id=:Hotel_id AND ServicioBasico_id=:ServicioBasico_id", nativeQuery = true)
    void actualizarHotelOfrece(@Param("Hotel_id") int Hotel_id, @Param("ServicioBasico_id") int ServicioBasico_id, @Param("Hotel_id_actualizado") int Hotel_id_actualizado, @Param("ServicioBasico_id_actualizado") int ServicioBasico_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hotelofrece WHERE Hotel_id=:Hotel_id AND ServicioBasico_id=:ServicioBasico_id", nativeQuery = true)
    void eliminarHotelOfrece(@Param("Hotel_id") int Hotel_id, @Param("ServicioBasico_id") int ServicioBasico_id);
}
