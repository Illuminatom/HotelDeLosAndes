package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.Lavanderia;

public interface LavanderiaRepository extends MongoRepository<Lavanderia, ObjectId> {
    List<Lavanderia> findAll();
    Lavanderia findById(String id);
    void deleteById(String id);
}