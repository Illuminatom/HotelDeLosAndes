
package uniandes.edu.co.parranderos.repositorios;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.parranderos.modelo.Reserva;
public interface ReservaRepository extends MongoRepository<Reserva, ObjectId> {
    List<Reserva> findAll();
    Reserva findById(String id);
    void deleteById(String id);
}


