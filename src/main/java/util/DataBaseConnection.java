package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnection {
    // Database name | Nombre de la base de datos
    private static final String DATABASE = "crmgym_test";

    // Connection URL | URL de conexión
    // "useSSL=false" disables SSL (not recommended for production) | "useSSL=false" desactiva SSL (no recomendado en producción)
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";

    // DB credentials stored as environment variables | Credenciales a la BD almacenadas como variables de entorno
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    // Logger instance for error tracking | Instancia de Logger para seguimiento de errores
    private static final Logger LOGGER = Logger.getLogger(DataBaseConnection.class.getName());

    // Static block to check enviroment variables | Bloque estático para verificar variables de entorno
    static {
        if (USER == null || PASSWORD == null) {
            throw new IllegalStateException("Las variables de entorno DB_USER y DB_PASSWORD no están definidas.");
        }
    }

    /**
     * Establishes a database connection | Establece una conexión a la base de datos
     *
     * @return A Connection object | Un objeto Connection
     * @throws SQLException If an error occurs while connecting | Si ocurre un error al establecer la conexión
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Validates if a conecction is active | Válida si una conexión está activa
     *
     * @param connection The connection to validate | La conexión a validar
     * @return true if the connection is valid, false otherwise | true si la conexión es válida, false en caso contrario
     */
    public static boolean isConnectionValid(Connection connection) {
        try {
            return connection != null && connection.isValid(2); //2 -second timeout | Tiempo fuera de 2 segundos

        }catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error validando la conexión ", e);
            return false;
        }
    }



}
