package uniandes.edu.co.parranderos.repositorio;

import java.sql.Date;
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

    @Query(value = "SELECT * FROM usuario WHERE documento >= :piso AND documento <= :techo", nativeQuery = true) 
    Collection<Usuario> darUsuariosEnIntervalo(@Param("piso") int piso, @Param("techo") int techo);

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

    @Query(value = "SELECT SUM (consumo_servicio_Cliente.costo) as total FROM Cliente INNER JOIN reserva_hotel ON Cliente.documento = reserva_hotel.Cliente_id INNER JOIN consumo_servicio_Cliente ON reserva_hotel.id = consumo_servicio_Cliente.Reserva_Hotel_id WHERE Cliente.documento=:documento AND consumo_servicio_Cliente.fecha >= :fechaMenor AND consumo_servicio_Cliente.fecha <= :fechaMayor GROUP BY Cliente.documento", nativeQuery = true)
    Integer darCostoTotalServiciosPorUsuarioEnIntervalo(@Param("documento") int documento, @Param("fechaMenor") Date fechaMenor, @Param("fechaMayor") Date fechaMayor);

    @Query(value = "SELECT SUM(Cliente_consume_producto.costo) as total FROM Cliente INNER JOIN reserva_hotel ON Cliente.documento = reserva_hotel.Cliente_id INNER JOIN Cliente_consume_producto ON reserva_hotel.id = Cliente_consume_producto.Reserva_Hotel_id WHERE Cliente.documento=:documento AND Cliente_consume_producto.fecha >= :fechaMenor AND Cliente_consume_producto.fecha <= :fechaMayor GROUP BY Cliente.documento", nativeQuery = true)
    Integer darCostoTotalProductosPorUsuarioEnIntervalo(@Param("documento") int documento, @Param("fechaMenor") Date fechaMenor, @Param("fechaMayor") Date fechaMayor);  
}
