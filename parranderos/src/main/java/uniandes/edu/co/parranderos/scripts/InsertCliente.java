package uniandes.edu.co.parranderos.scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertCliente {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D13202320";
        String contraseña = "VkqLydCSGfaA";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO cliente (documento, metodo_pago) " +
                    "VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();
            long inicio = System.currentTimeMillis()/1000/60;
            for (int i = 12500; i <= 25000; i++) {
                int documento = i;
                String[] metodosPago = {"Efectivo", "Tarjeta de Crédito", "Tarjeta de Débito", "Transferencia"};
                String metodoPago = metodosPago[random.nextInt(metodosPago.length)];

                preparedStatement.setInt(1, documento);
                preparedStatement.setString(2, metodoPago);

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
