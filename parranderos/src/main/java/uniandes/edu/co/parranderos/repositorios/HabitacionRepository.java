package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.Habitacion;

public interface HabitacionRepository extends MongoRepository<Habitacion, ObjectId>{
    List<Habitacion> findAll();
    void deleteById(String id);
    Habitacion findById(String id);
}
