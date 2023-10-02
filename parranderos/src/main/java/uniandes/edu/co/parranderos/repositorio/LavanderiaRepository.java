package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Lavanderia;

public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer>{
    @Query(value = "SELECT * FROM lavanderia", nativeQuery = true)
    Collection<Lavanderia> darLavanderias();

    @Query(value = "SELECT * FROM lavanderia WHERE id=:id", nativeQuery = true)
    Lavanderia darLavanderia(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO lavanderia (id, costo_Por_Prenda, costo_Por_Par_Zapatos) VALUES (:id, :costo_Por_Prenda, :costo_Por_Par_Zapatos)", nativeQuery = true)
    void insertarLavanderia(@Param("id") int id, @Param("costo_Por_Prenda") int costo_Por_Prenda, @Param("costo_Por_Par_Zapatos") int costo_Por_Par_Zapatos);

    @Modifying
    @Transactional
    @Query(value = "UPDATE lavanderia SET id=:id_actualizada, costo_Por_Prenda=:costo_Por_Prenda, costo_Por_Par_Zapatos=:costo_Por_Par_Zapatos WHERE id=:id", nativeQuery = true)
    void actualizarLavanderia(@Param("id") int id, @Param("id_actualizada") int id_actualizada, @Param("costo_Por_Prenda") int costo_Por_Prenda, @Param("costo_Por_Par_Zapatos") int costo_Por_Par_Zapatos);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM lavanderia WHERE id=:id", nativeQuery = true)
    void eliminarLavanderia(@Param("id") int id);
}
