package uniandes.edu.co.parranderos.scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertUsuario {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D13202320";
        String contraseña = "VkqLydCSGfaA";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO usuario (documento, tipo_documento, nombre, correo_electronico, hotel_id, tipo_usuario_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();
            long inicio = System.currentTimeMillis()/1000/60;

            for (int i = 1; i <= 25000; i++) {
                int documento = i;
                String tipoDocumento = "Tipo" + (random.nextInt(5) + 1);
                String nombre = "Usuario" + i;
                String correoElectronico = "usuario" + i + "@correo.com";
                int hotelId = random.nextInt(1000) + 1;
                int tipoUsuarioId = random.nextInt(5) + 1;
                if (i >= 12500){
                    tipoUsuarioId = 1; // Apartir de los 12500 todos son clientes
                }

                preparedStatement.setInt(1, documento);
                preparedStatement.setString(2, tipoDocumento);
                preparedStatement.setString(3, nombre);
                preparedStatement.setString(4, correoElectronico);
                preparedStatement.setInt(5, hotelId);
                preparedStatement.setInt(6, tipoUsuarioId);

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
