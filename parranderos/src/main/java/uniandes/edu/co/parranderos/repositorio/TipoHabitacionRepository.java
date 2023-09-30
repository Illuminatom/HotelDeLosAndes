package uniandes.edu.co.parranderos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import uniandes.edu.co.parranderos.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {

    @Query(value = "SELECT * FROM tipohabitacion", nativeQuery = true)
    Collection<TipoHabitacion> darTiposHabitacion();

    @Query(value = "SELECT * FROM tipohabitacion WHERE id = :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacionPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipohabitacion (id, nombre, capacidad, precio_noche) VALUES (:id, :nombre, :capacidad, :precionoche)", nativeQuery = true)
    void insertarTipoHabitacion(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("precionoche") int precionoche);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tipohabitacion SET nombre = :nombre, capacidad = :capacidad, precio_noche = :precionoche WHERE id = :id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("precionoche") int precionoche);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipohabitacion WHERE id = :id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") int id);
}
