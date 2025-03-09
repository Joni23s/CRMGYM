package service;

import dao.ClientDaoImpl;
import dao.ClientDao;
import model.Client;
import validations.ClientValidation;

public class ClientService {
    private final ClientDao clientDao = new ClientDaoImpl();
    private final ClientValidation clientValidation = new ClientValidation();

    public ClientService() {}

    public void listClients() {
        System.out.println("\t--- Listado de Clientes ---");
        clientDao.getAllClients().forEach(System.out::println);
        printSeparator();
    }

    public void findClient() {
        int documentId = clientValidation.getIntInput("Ingrese el DNI del Cliente: ");
        Client client = clientDao.findClientById(documentId);

        System.out.println(client != null ? "\n" + client : "\nCliente no encontrado.");
        printSeparator();
    }


    public void addClient() {
        System.out.println("--- Agregar un nuevo Cliente ---");

        int documentId = clientValidation.isDocumentIdDuplicated("DNI: ");
        String name = clientValidation.getStringInput("Nombre: ");
        String lastName = clientValidation.getStringInput("Apellido: ");
        String email = clientValidation.getEmailInput("Email: ");
        long phoneNumber = clientValidation.getLongInput("Celular: ");

        int returnClient = clientDao.addClient(new Client(documentId, name, lastName, email, phoneNumber));

        System.out.println(returnClient != -1 ? "Cliente agregado con éxito: \n" +
                clientDao.findClientById(documentId) : "No se pudo agregar un nuevo Cliente");
        printSeparator();
    }

    public void updateClient() {
        System.out.println("--- Modificar un Cliente ---");

        int documentId = clientValidation.getIntInput("DNI del Cliente a modificar: ");
        Client client = clientDao.findClientById(documentId);

        if (client == null) {
            System.out.println("No se encontró un cliente con DNI: " + documentId);
            return;
        }

        System.out.println("Ingrese un '-' para NO modificar un campo");

        client.setDocumentId(clientValidation.isDocumentIdDuplicated("Nuevo DNI: ", client));
        client.setName(clientValidation.getStringInput("Nombre: ", client.getName()));
        client.setLastName(clientValidation.getStringInput("Apellido: ", client.getLastName()));
        client.setEmail(clientValidation.getEmailInput("Email: ", client.getEmail()));
        client.setPhoneNumber(clientValidation.getLongInput("Celular: ", client.getPhoneNumber()));
        client.setActive(clientValidation.getStateInput("Estado (activo/inactivo): ", client.isActive()));

        clientDao.updateClient(client);
        System.out.println("Cliente actualizado: \n" + client);
            printSeparator();

    }

    public void deleteClient() {
        System.out.println("--- Eliminar un Cliente ---");

        int documentId = clientValidation.getIntInput("Ingrese el DNI del Cliente a eliminar: ");
        Client client = clientDao.findClientById(documentId);

        if (client == null) {
            System.out.println("No se encontró registro de Cliente con DNI: " + documentId);

        } else {
            clientDao.deleteClient(documentId);
            System.out.println("Cliente eliminado con éxito: \n" + client);
        }
        printSeparator();
    }

    private void printSeparator() {
        System.out.println("═════════════════════════════════════════════════════════");
    }



}
