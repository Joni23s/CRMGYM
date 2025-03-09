package dao;

import model.Client;

import java.util.List;

/**
 * Interfaz para definir las operaciones CRUD de la entidad Client.
 * Interface to define the CRUD operations of the Client entity.
 */
public interface ClientDao {
    List<Client> getAllClients();
    Client findClientById(int documentId);
    int addClient(Client client);
    boolean updateClient(Client client);
    boolean deleteClient(int documentId);
}
