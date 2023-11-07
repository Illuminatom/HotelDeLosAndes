package uniandes.edu.co.parranderos.scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertHabitacion {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D13202320";
        String contraseña = "VkqLydCSGfaA";


        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO habitacion (id, disponible, hotel_id, Tipo_habitacion_id) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();
            long inicio = System.currentTimeMillis()/1000/60;
            for (int i = 1; i <= 25000; i++) {
                int id = i;
                String disponible = random.nextBoolean() ? "si" : "no";
                int hotelId = random.nextInt(1000) + 1;
                int tipoHabitacionId = random.nextInt(5) + 1;

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, disponible);
                preparedStatement.setInt(3, hotelId);
                preparedStatement.setInt(4, tipoHabitacionId);

                preparedStatement.executeUpdate();
            }
            long fin = System.currentTimeMillis()/1000/60;
            System.out.println("Tiempo de insercion: "+ (fin-inicio) + " minutos");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
