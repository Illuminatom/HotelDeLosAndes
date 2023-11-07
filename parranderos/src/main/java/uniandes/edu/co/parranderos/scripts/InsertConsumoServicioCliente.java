package uniandes.edu.co.parranderos.scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Date;

public class InsertConsumoServicioCliente {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D13202320";
        String contraseña = "VkqLydCSGfaA";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {
            String sql = "INSERT INTO consumo_servicio_cliente (reserva_hotel_id, servicio_basico_id, fecha, descripcion, costo) " +
                    "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                Random random = new Random();
                long inicio = System.currentTimeMillis() / 1000 / 60;

                for (int i = 1; i <= 100000; i++) {
                    int reservaHotelId = random.nextInt(50000) + 1;
                    int servicioBasicoId = random.nextInt(50000) + 1;
                    
                    Date fechaReserva = generarFechaConsumo(reservaHotelId, connection);

                    String descripcion = "Consumo " + i;
                    int costo = 100000 + random.nextInt(900001);
                    
                    preparedStatement.setInt(1, reservaHotelId);
                    preparedStatement.setInt(2, servicioBasicoId);
                    preparedStatement.setDate(3, new java.sql.Date(fechaReserva.getTime()));
                    preparedStatement.setString(4, descripcion);
                    preparedStatement.setInt(5, costo);
                    
                    preparedStatement.executeUpdate();
                }
                
                long fin = System.currentTimeMillis() / 1000 / 60;
                System.out.println("Tiempo de inserción: " + (fin - inicio) + " minutos");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Esto saca las fechas de inicio y fin de la reserva y genera una fecha aleatoria entre ellas
    private static Date generarFechaConsumo(int reservaHotelId, Connection connection) {
        try {
            String sql = "SELECT fecha_entrada, fecha_salida FROM reserva_hotel WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, reservaHotelId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Date fechaEntrada = resultSet.getDate("fecha_entrada");
                        Date fechaSalida = resultSet.getDate("fecha_salida");
                        long fechaEntradaMillis = fechaEntrada.getTime();
                        long fechaSalidaMillis = fechaSalida.getTime();
                        long range = fechaSalidaMillis - fechaEntradaMillis;
                        long randomTimeOffset = (long) (Math.random() * range);
                        return new Date(fechaEntradaMillis + randomTimeOffset);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
