package uniandes.edu.co.parranderos.repositorios;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.parranderos.modelo.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, ObjectId> {
    List<Hotel> findAll();
    Hotel findById(String id);
}
