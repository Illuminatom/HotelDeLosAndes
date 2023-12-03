package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.ServicioBasico;

public interface ServicioBasicoRepository extends MongoRepository<ServicioBasico, ObjectId>{
    List<ServicioBasico> findAll();
    ServicioBasico findById(String id);
    void deleteById(String id);
}
