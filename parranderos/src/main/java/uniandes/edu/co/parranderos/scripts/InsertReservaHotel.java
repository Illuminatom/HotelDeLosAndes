package uniandes.edu.co.parranderos.scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

public class InsertReservaHotel {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D13202320";
        String contraseña = "VkqLydCSGfaA";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO reserva_hotel (id, fecha_entrada, fecha_salida, num_personas, Habitacion_id, Cliente_id, plan_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();
            long inicio = System.currentTimeMillis()/1000/60;

            for (int i = 1; i <= 50000; i++) {
                int id = i;
                long currentTimeMillis = System.currentTimeMillis();
                long randomTimeOffset = random.nextInt(365 * 5) * 24 * 60 * 60 * 1000L;
                Date fechaEntrada = new Date(currentTimeMillis - randomTimeOffset);
                long diasEstadia = (random.nextInt(30) + 1) * 24 * 60 * 60 * 1000L;
                Date fechaSalida = new Date(fechaEntrada.getTime() + diasEstadia);

                if (fechaSalida.before(fechaEntrada)) {
                    Date temp = fechaSalida;
                    fechaSalida = fechaEntrada;
                    fechaEntrada = temp;
                }

                int numPersonas = random.nextInt(5) + 1;
                int habitacionId = random.nextInt(25000) + 1;
                int clienteId = random.nextInt(12500) + 12500; 
                Integer planId = null;
                if (random.nextDouble() < 0.5) {
                    planId = random.nextInt(10000) + 1;
                }

                preparedStatement.setInt(1, id);
                preparedStatement.setDate(2, new java.sql.Date(fechaEntrada.getTime()));
                preparedStatement.setDate(3, new java.sql.Date(fechaSalida.getTime()));
                preparedStatement.setInt(4, numPersonas);
                preparedStatement.setInt(5, habitacionId);
                preparedStatement.setInt(6, clienteId);
                if (planId == null) {
                    preparedStatement.setNull(7, java.sql.Types.INTEGER);
                } else {
                    preparedStatement.setInt(7, planId);
                }

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
