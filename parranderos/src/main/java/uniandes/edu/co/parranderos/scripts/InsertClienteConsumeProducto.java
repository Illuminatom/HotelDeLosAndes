package uniandes.edu.co.parranderos.scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

public class InsertClienteConsumeProducto {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D13202320";
        String contraseña = "VkqLydCSGfaA";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO cliente_consume_producto (reserva_hotel_id, producto_id, cantidad, fecha, costo, descripcion) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            Random random = new Random();

            for (int i = 1; i <= 100000; i++) {
                int reservaHotelId = random.nextInt(50000) + 1;
                int productoId = random.nextInt(100000) + 1;
                int cantidad = random.nextInt(20) + 1;

                Date fecha = generarFechaConsumo(reservaHotelId, connection);

                int costo = obtenerCostoProducto(productoId, connection)*cantidad;
                String descripcion = (random.nextDouble() < 0.5) ? "Descripción opcional" : null;

                preparedStatement.setInt(1, reservaHotelId);
                preparedStatement.setInt(2, productoId);
                preparedStatement.setInt(3, cantidad);
                preparedStatement.setDate(4, new java.sql.Date(fecha.getTime()));
                preparedStatement.setInt(5, costo);
                preparedStatement.setString(6, descripcion);

                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Esto da el costo del producto para despues calcular el costo total del consumo multiplicando por la cantidad
    private static int obtenerCostoProducto(int productoId, Connection connection) {
        try{
            String sql = "SELECT precio FROM producto WHERE id = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1, productoId);
                try(ResultSet resultSet = preparedStatement.executeQuery();){
                    if(resultSet.next()){
                        return resultSet.getInt("precio");
                    }
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
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
