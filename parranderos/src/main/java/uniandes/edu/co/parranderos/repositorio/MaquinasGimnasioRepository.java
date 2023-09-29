package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.MaquinasGimnasio;

public interface MaquinasGimnasioRepository extends JpaRepository<MaquinasGimnasio, Integer>{
    @Query(value = "SELECT * FROM maquinasgimnasio", nativeQuery = true)
    Collection<MaquinasGimnasio> darMaquinasGimnasios();

    @Query(value = "SELECT * FROM maquinasgimnasio WHERE Gimnasio_id=:Gimnasio_id AND Producto_id=:Producto_id", nativeQuery = true)
    MaquinasGimnasio darMaquinasGimnasio(@Param("Gimnasio_id") int Gimnasio_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO maquinasgimnasio (Gimnasio_id, Producto_id) VALUES (:Gimnasio_id, :Producto_id)", nativeQuery = true)
    void insertarMaquinaGimnasio(@Param("Gimnasio_id") int Gimnasio_id, @Param("Producto_id") int Producto_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE maquinasgimnasio SET Gimnasio_id=:Gimnasio_id_actualizado, Producto_id=:Producto_id_actualizado WHERE Gimnasio_id=:Gimnasio_id AND Producto_id=:Producto_id", nativeQuery = true)
    void actualizarMaquinaGimnasio(@Param("Gimnasio_id") int Gimnasio_id, @Param("Producto_id") int Producto_id, @Param("Gimnasio_id_actualizado") int Gimnasio_id_actualizado, @Param("Producto_id_actualizado") int Producto_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM maquinasgimnasio WHERE Gimnasio_id=:Gimnasio_id AND Producto_id=:Producto_id", nativeQuery = true)
    void eliminarMaquinaGimnasio(@Param("Gimnasio_id") int Gimnasio_id, @Param("Producto_id") int Producto_id);
}
