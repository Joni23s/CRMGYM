import model.Client;
import util.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Lista para almacenar los clientes obtenidos de la BD
        List<Client> clients = new ArrayList<>();

        // Intentamos la conexión y la consulta
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM client")) {

            // Recorremos el resultado y creamos objetos Client
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("documentId"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getLong("phoneNumber"),
                        resultSet.getBoolean("isActive")
                );
                clients.add(client); // Agregamos a la lista
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener clientes: " + e.getMessage());
        }

        // Mostramos los clientes en la consola
        if (clients.isEmpty()) {
            System.out.println("⚠ No hay clientes en la base de datos.");
        } else {
            System.out.println("✅ Lista de Clientes:");
            clients.forEach(System.out::println);
        }
    }
    }


