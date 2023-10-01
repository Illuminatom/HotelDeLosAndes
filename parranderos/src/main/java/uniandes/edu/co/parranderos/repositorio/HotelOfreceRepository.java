package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.HotelOfrece;

public interface HotelOfreceRepository extends JpaRepository<HotelOfrece, Integer>{
    @Query(value = "SELECT * FROM hotel_ofrece", nativeQuery = true)
    Collection<HotelOfrece> darHotelesOfrecen();

    @Query(value = "SELECT * FROM hotel_ofrece WHERE Hotel_id=:Hotel_id AND Servicio_Basico_id=:Servicio_Basico_id", nativeQuery = true)
    HotelOfrece darHotelOfrece(@Param("Hotel_id") int Hotel_id, @Param("Servicio_Basico_id") int Servicio_Basico_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hotel_ofrece (Hotel_id, Servicio_Basico_id) VALUES (:Hotel_id, :Servicio_Basico_id)", nativeQuery = true)
    void insertarHotelOfrece(@Param("Hotel_id") int Hotel_id, @Param("Servicio_Basico_id") int Servicio_Basico_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hotel_ofrece SET Hotel_id=:Hotel_id_actualizado, Servicio_Basico_id=:Servicio_Basico_id_actualizado WHERE Hotel_id=:Hotel_id AND Servicio_Basico_id=:Servicio_Basico_id", nativeQuery = true)
    void actualizarHotelOfrece(@Param("Hotel_id") int Hotel_id, @Param("Servicio_Basico_id") int Servicio_Basico_id, @Param("Hotel_id_actualizado") int Hotel_id_actualizado, @Param("Servicio_Basico_id_actualizado") int Servicio_Basico_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hotel_ofrece WHERE Hotel_id=:Hotel_id AND Servicio_Basico_id=:Servicio_Basico_id", nativeQuery = true)
    void eliminarHotelOfrece(@Param("Hotel_id") int Hotel_id, @Param("Servicio_Basico_id") int Servicio_Basico_id);
}
