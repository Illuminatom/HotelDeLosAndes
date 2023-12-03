package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, ObjectId>{
    List<TipoHabitacion> findAll();
    TipoHabitacion findById(String id);
}
