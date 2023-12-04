package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.Producto;

public interface ProductoRepository extends MongoRepository<Producto, ObjectId>{
    List<Producto> findAll();
    Producto findById(String id);
    void deleteById(String id);
}
