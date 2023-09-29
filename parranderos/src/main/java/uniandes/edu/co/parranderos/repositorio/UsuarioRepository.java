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

    @Query(value = "SELECT * FROM usuario WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario (tipoDocumento, nombre, correoElectronico, tipoUsuario, Hotel_id) VALUES (:tipoDocumento, :nombre, :correoElectronico, :tipoUsuario, :Hotel_id)", nativeQuery = true)
    void insertarUsuario(@Param("tipoDocumento") String tipoDocumento, @Param("nombre") String nombre, @Param("correoElectronico") String correoElectronico, @Param("tipoUsuario") String tipoUsuario, @Param("Hotel_id") int Hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuario SET tipoDocumento=:tipoDocumento, nombre=:nombre, correoElectronico=:correoElectronico, tipoUsuario=:tipoUsuario, Hotel_id=:Hotel_id WHERE documento=:documento", nativeQuery = true)
    void insertarUsuario(@Param("documento") String documento, @Param("tipoDocumento") String tipoDocumento, @Param("nombre") String nombre, @Param("correoElectronico") String correoElectronico, @Param("tipoUsuario") String tipoUsuario, @Param("Hotel_id") int Hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuario WHERE documento=:documento", nativeQuery = true)
    void eliminarUsuario(@Param("documento") int documento);
}
