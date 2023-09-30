package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
    @Query(value = "SELECT * FROM tipo_usuario", nativeQuery = true)
    Collection<TipoUsuario> darTiposUsuarios();

    @Query(value = "SELECT * FROM tipo_usuario WHERE id=:id", nativeQuery = true)
    TipoUsuario darTipoUsuario(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipo_usuario (id, nombre, descripcion) VALUES (:id, :nombre, :descripcion)", nativeQuery = true)
    void insertarTipoUsuario(@Param("id") int id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tipo_usuario SET nombre=:nombre, descripcion=:descripcion WHERE id=:id", nativeQuery = true)
    void actualizarTipoUsuario(@Param("id") int id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipo_usuario WHERE id=:id", nativeQuery = true)
    void eliminarTipoUsuario(@Param("id") int id);
}
