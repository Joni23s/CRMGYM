import util.DataBaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            if (connection != null && connection.isValid(2)) {
                System.out.println("✅ Connection to the database was successful! / ¡Conexión a la base de datos exitosa!");
            } else {
                System.out.println("❌ Connection is not valid. / La conexión no es válida.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed! / ¡Falló la conexión a la base de datos!");
            e.printStackTrace();
        }
    }
}

