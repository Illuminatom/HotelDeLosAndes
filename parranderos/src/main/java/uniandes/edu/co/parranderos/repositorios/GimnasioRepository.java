package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.Gimnasio;

public interface GimnasioRepository extends MongoRepository<Gimnasio, ObjectId>{
    List<Gimnasio> findAll();
    Gimnasio findById(String id);
    void deleteById(String id);
}
