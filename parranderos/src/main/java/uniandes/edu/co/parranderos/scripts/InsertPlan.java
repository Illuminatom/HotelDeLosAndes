package uniandes.edu.co.parranderos.scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertPlan {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D13202320";
        String contraseña = "VkqLydCSGfaA";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO plan (id, nombre, descuento_habitacion) " +
                    "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();
            long inicio = System.currentTimeMillis()/1000/60;

            for (int i = 1; i <= 10000; i++) {
                int id = i;
                String nombre = "Plan " + i;
                double descuentoHabitacion = 10.0 + (random.nextDouble() * 40.0); // Rango de 10.0 a 50.0

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nombre);
                preparedStatement.setDouble(3, descuentoHabitacion);

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
