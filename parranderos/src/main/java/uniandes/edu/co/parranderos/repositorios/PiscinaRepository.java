package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.Piscina;

public interface PiscinaRepository extends MongoRepository<Piscina, ObjectId>{
    List<Piscina> findAll();
    Piscina findById(String id);
    void deleteById(String id);
}
