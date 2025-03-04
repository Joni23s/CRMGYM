import dao.ClientDao;
import model.Client;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClientDao clientDao = new ClientDao();

        // 1. Crear un nuevo cliente
        Client newClient = new Client(13034567, "Santi", "Baj", "baj.santi@example.com", 2634890545L);
        int addedId = clientDao.addClient(newClient);
        if (addedId != -1) {
            System.out.println("Cliente agregado con éxito: \n" + newClient);
        } else {
            System.out.println("Error al agregar el cliente.");
        }

        // 2. Listar todos los clientes
        List<Client> clients = clientDao.getAllClients();
        System.out.println("\nLista de clientes:");
        for (Client client : clients) {
            System.out.println(client);
        }

        // 3. Buscar un cliente por ID
        int searchId = 13034567;
        Client foundClient = clientDao.findClientById(searchId);
        if (foundClient != null) {
            System.out.println("\nCliente encontrado: \n" + foundClient);
        } else {
            System.out.println("\nCliente con ID " + searchId + " no encontrado.");
        }

        // 4. Actualizar un cliente
        if (foundClient != null) {
            foundClient.setEmail("nuevo.email@example.com");
            boolean updated = clientDao.updateClient(foundClient);
            if (updated) {
                System.out.println("\nCliente actualizado: \n" + clientDao.findClientById(13034567));
            } else {
                System.out.println("\nError al actualizar el cliente.");
            }
        }

        // 5. Eliminar un cliente
        boolean deleted = clientDao.deleteClient(13034567);
        if (deleted) {
            System.out.println("\nCliente eliminado correctamente.");
        } else {
            System.out.println("\nError al eliminar el cliente.");
        }

        // 6. Verificar que el cliente ya no existe
        Client deletedClient = clientDao.findClientById(13034567);
        if (deletedClient == null) {
            System.out.println("\nEl cliente ya no existe en la base de datos.");
        } else {
            System.out.println("\nEl cliente todavía está en la base de datos: \n" + deletedClient);
        }
    }
    }


