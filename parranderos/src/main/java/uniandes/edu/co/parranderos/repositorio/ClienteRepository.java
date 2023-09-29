package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    @Query(value = "SELECT * FROM cliente", nativeQuery = true)
    Collection<Cliente> darClientes();
    
    @Query(value = "SELECT * FROM cliente WHERE documento=:documento", nativeQuery = true)
    Cliente darCliente(@Param("documento") int documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cliente (documento, metodoPago, cobroTotal)", nativeQuery = true)
    void insertarCliente(@Param("documento") int documento, @Param("metodoPago") String metodoPago ,@Param("cobroTotal") int cobroTotal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente SET documento=:documento_actualizado, metodoPago=:metodoPago, cobroTotal=:cobroTotal WHERE documento=:documento", nativeQuery = true)
    void actualizarCliente(@Param("documento") int documento, @Param("documento_actualizado") int documento_actualizado,@Param("metodoPago") String metodoPago ,@Param("cobroTotal") int cobroTotal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente WHERE documento=:documento", nativeQuery = true)
    void eliminarCliente(@Param("documento") int documento);
}
