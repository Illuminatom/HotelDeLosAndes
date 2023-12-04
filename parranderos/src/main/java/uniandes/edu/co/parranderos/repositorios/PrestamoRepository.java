package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.Prestamo;

public interface PrestamoRepository extends MongoRepository<Prestamo, ObjectId>{
    List<Prestamo> findAll();
    Prestamo findById(String id);
    void deleteById(String id);
}
