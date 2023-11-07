package uniandes.edu.co.parranderos.scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertServicioBasico {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D13202320";
        String contraseña = "VkqLydCSGfaA";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO servicio_basico (id, nombre, capacidad, costo, hora_apertura, hora_cierre) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();
            long inicio = System.currentTimeMillis() / 1000 / 60;

            for (int i = 1; i <= 50000; i++) {
                int id = i;
                String nombre = "Servicio " + id;
                int capacidad = random.nextInt(100) + 1;
                int costo = 10000 + random.nextInt(500000);
                
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                long horaAperturaMillis = 6 * 60 * 60 * 1000 + random.nextInt((18 * 60 * 60 * 1000));
                long horaCierreMillis = horaAperturaMillis + random.nextInt((6 * 60 * 60 * 1000));
                
                if (horaCierreMillis < horaAperturaMillis) {
                    horaCierreMillis = horaAperturaMillis;
                }
                String horaApertura = sdf.format(new Date(horaAperturaMillis));
                String horaCierre = sdf.format(new Date(horaCierreMillis));
                
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nombre);
                preparedStatement.setInt(3, capacidad);
                preparedStatement.setInt(4, costo);
                preparedStatement.setString(5, horaApertura);
                preparedStatement.setString(6, horaCierre);

                preparedStatement.executeUpdate();
            }
            long fin = System.currentTimeMillis() / 1000 / 60;
            System.out.println("Tiempo de inserción: " + (fin - inicio) + " minutos");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
