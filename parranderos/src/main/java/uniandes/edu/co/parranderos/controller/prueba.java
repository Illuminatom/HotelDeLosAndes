package uniandes.edu.co.parranderos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class prueba{

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/testdb")
    public String testDatabaseConnection() {
        try {
            mongoTemplate.executeCommand("{ buildInfo: 1 }");
            return "La conexión con la base de datos MongoDB fue exitosa.";
        } catch (Exception e) {
            return "Error al conectar con la base de datos MongoDB: " + e.getMessage();
        }
    }
}
