package dao;

import model.Client;

import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static util.DataBaseConnection.getConnection;

/**
 * Implementación de la interfaz IClientDao para gestionar las operaciones de la entidad Client en la base de datos.
 * Implementation of the IClientDao interface to manage Client entity operations in the database.
 */
public class ClientDaoImpl implements ClientDao {
    private static final Logger LOGGER = Logger.getLogger(ClientDaoImpl.class.getName());
    private static final boolean DEBUG_MODE = isDebugging();

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client ORDER BY documentId";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                clients.add(mapResultSetToClient(rs));
            }
            if (DEBUG_MODE) {
                LOGGER.log(Level.INFO, "Se listaron {0} clientes exitosamente.", clients.size());
            }
        } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error al listar clientes", e);
        }
        return clients;
    }

    @Override
    public Client findClientById(int documentId) {
        String sql = "SELECT * FROM client WHERE documentId = ?";

        try (Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, documentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    if (DEBUG_MODE) {
                        LOGGER.log(Level.INFO, "Cliente con DNI {0} encontrado exitosamente.", documentId);
                    }
                    return mapResultSetToClient(rs);

                } else {
                    if (DEBUG_MODE) {
                        LOGGER.log(Level.WARNING, "Cliente con DNI {0} no encontrado.", documentId);
                    }
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al recuperar un Cliente por Id. ", e);
        }
        return null;
    }

    @Override
    public int addClient(Client client) {

        String sql = "INSERT INTO client(documentId, name, lastName, email, phoneNumber, isActive)" +
                " VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            setClientParameters(ps, client);
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                if (DEBUG_MODE) {
                    LOGGER.log(Level.INFO, "Cliente con DNI {0} agregado exitosamente.", client.getDocumentId());
                }
                return client.getDocumentId();

            } else {
                if (DEBUG_MODE) {
                    LOGGER.log(Level.WARNING, "No se pudo agregar el cliente con DNI {0}.", client.getDocumentId());
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al agregar un nuevo cliente", e);
        }

        return -1;
    }

    @Override
    public boolean updateClient(Client client) {

        String sql = "UPDATE client SET documentId=?, name=?, lastName=?, email=?, phoneNumber=?, isActive=?" +
                " WHERE documentId=?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            setClientParameters(ps, client);
            ps.setInt(7, client.getDocumentId());
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                if (DEBUG_MODE) {
                    LOGGER.log(Level.INFO, "Cliente con DNI {0} actualizado exitosamente.", client.getDocumentId());
                }
                return true;

            } else {
                if (DEBUG_MODE) {
                    LOGGER.log(Level.WARNING, "No se pudo actualizar el cliente con DNI {0}.", client.getDocumentId());
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al modificar al cliente: ", e);
        }

        return false;
    }

    @Override
    public boolean deleteClient(int documentId) {
        String sql = "DELETE FROM client WHERE documentId=?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1,documentId);
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                if (DEBUG_MODE) {
                    LOGGER.log(Level.INFO, "Cliente con DNI {0} eliminado exitosamente.", documentId);
                }
                return true;

            } else {
                if (DEBUG_MODE) {
                    LOGGER.log(Level.WARNING, "No se pudo eliminar el cliente con DNI {0}.", documentId);
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al eliminar un cliente. ", e);
        }

        return false;
    }

    /**
     * Mapea un ResultSet a un objeto Client.
     * Maps a ResultSet to a Client object.
     */
    private Client mapResultSetToClient(ResultSet rs) throws Exception {
        return new Client(
                rs.getInt("documentId"),
                rs.getString("name"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getLong("phoneNumber"),
                rs.getBoolean("isActive")
        );
    }

    /**
     * Establece los parámetros de un PreparedStatement con los datos de un objeto Client.
     * Sets the parameters of a PreparedStatement using a Client object.
     */
    private void setClientParameters(PreparedStatement ps, Client client) throws Exception {
        ps.setInt(1, client.getDocumentId());
        ps.setString(2, client.getName());
        ps.setString(3, client.getLastName());
        ps.setString(4, client.getEmail());
        ps.setLong(5, client.getPhoneNumber());
        ps.setBoolean(6, client.isActive());
    }


    /** Verifica si el programa se está ejecutando en modo Debug detectando el argumento "-agentlib:jdwp",
     *que se agrega automáticamente cuando se ejecuta en modo depuración en IntelliJ IDEA.
     *Esto permite que el programa active comportamientos específicos para el modo Debug.
     * Checks if the program is running in Debug mode by detecting the "-agentlib:jdwp" argument,
     * which is automatically added when running in debug mode in IntelliJ IDEA.
     *This allows the program to enable specific behaviors for Debug mode. */
    private static boolean isDebugging() {
        return ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("-agentlib:jdwp");
    }
}
