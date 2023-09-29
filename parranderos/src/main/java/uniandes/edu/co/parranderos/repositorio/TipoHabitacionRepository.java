package uniandes.edu.co.parranderos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import uniandes.edu.co.parranderos.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Long> {

    @Query(value = "SELECT * FROM tipohabitacion", nativeQuery = true)
    Collection<TipoHabitacion> darTiposHabitacion();

    @Query(value = "SELECT * FROM tipohabitacion WHERE id = :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacionPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipohabitacion (nombre, capacidad, precio_noche) VALUES (:nombre, :capacidad, :precioNoche)", nativeQuery = true)
    void insertarTipoHabitacion(@Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("precioNoche") int precioNoche);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tipohabitacion SET nombre = :nombre, capacidad = :capacidad, precio_noche = :precioNoche WHERE id = :id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id") Long id, @Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("precioNoche") int precioNoche);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipohabitacion WHERE id = :id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") Long id);
}
