package uniandes.edu.co.parranderos.scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertProducto {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D13202320";
        String contraseña = "VkqLydCSGfaA";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO producto (id, nombre, precio, tipo_producto, cantidad_disponible) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();
            
            long inicio = System.currentTimeMillis() / 1000 / 60;
            for (int i = 1; i <= 100000; i++) {
                int id = i;
                String nombre = "Producto " + i;
                int precio = 10000 + random.nextInt(2000000);
                String[] tiposProductos = {"Alimentación", "Electrónica", "Ropa", "Hogar", "Juguetes"};
                String tipoProducto = tiposProductos[random.nextInt(tiposProductos.length)];
                Integer cantidadDisponible = random.nextBoolean() ? random.nextInt(1000) : null;

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nombre);
                preparedStatement.setInt(3, precio);
                preparedStatement.setString(4, tipoProducto);
                if (cantidadDisponible == null) {
                    preparedStatement.setNull(5, java.sql.Types.INTEGER);
                } else {
                    preparedStatement.setInt(5, cantidadDisponible);
                }

                preparedStatement.executeUpdate();
            }
            long fin = System.currentTimeMillis() / 1000 / 60;
            System.out.println("Tiempo de ejecución: " + (fin - inicio) + " minutos");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
