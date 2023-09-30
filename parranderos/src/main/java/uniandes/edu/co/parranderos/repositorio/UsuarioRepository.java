package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "SELECT * FROM usuario", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuario WHERE documento = :documento", nativeQuery = true)
    Usuario darUsuario(@Param("documento") int documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario (documento, tipo_documento, nombre, correo_electronico, Tipo_usuario_id, Hotel_id) VALUES (:documento, :tipo_documento, :nombre, :correo_electronico, :Tipo_usuario_id, :Hotel_id)", nativeQuery = true)
    void insertarUsuario(@Param("documento") int documento, @Param("tipo_documento") String tipo_documento, @Param("nombre") String nombre, @Param("correo_electronico") String correo_electronico, @Param("Tipo_usuario_id") int Tipo_usuario_id, @Param("Hotel_id") int Hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuario SET tipo_documento=:tipo_documento, nombre=:nombre, correo_electronico=:correo_electronico, Tipo_usuario_id=:Tipo_usuario_id, Hotel_id=:Hotel_id WHERE documento=:documento", nativeQuery = true)
    void actualizarUsuario(@Param("documento") int documento, @Param("tipo_documento") String tipo_documento, @Param("nombre") String nombre, @Param("correo_electronico") String correo_electronico, @Param("Tipo_usuario_id") int Tipo_usuario_id, @Param("Hotel_id") int Hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuario WHERE documento=:documento", nativeQuery = true)
    void eliminarUsuario(@Param("documento") int documento);
}
