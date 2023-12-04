package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, ObjectId>{
    List<Cliente> findAll();
    Cliente findByDocumento(int documento);
    void deleteByDocumento(int documento);
}
