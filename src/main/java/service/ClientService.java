package service;

import dao.ClientDao;
import dao.IClientDao;
import model.Client;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientService {
    private final IClientDao clientDao = new ClientDao();
    private final Scanner console = new Scanner(System.in);

    public ClientService() {}

    public void listClients() {
        System.out.println("\t--- Listado de Clientes ---");
        clientDao.getAllClients().forEach(System.out::println);
        printSeparator();
    }

    public void findClient() {
        int documentId = getIntInput("Ingrese el DNI del Cliente: ");
        Client client = clientDao.findClientById(documentId);

        System.out.println(client != null ? "\n" + client : "\nCliente no encontrado.");
        printSeparator();
    }


    public void addClient() {
        System.out.println("--- Agregar un nuevo Cliente ---");

        int documentId = getIntInput("DNI: ");
        String name = getStringInput("Nombre: ");
        String lastName = getStringInput("Apellido: ");
        String email = getEmailInput("Email: ");
        long phoneNumber = getLongInput("Celular: ");

        int returnClient = clientDao.addClient(new Client(documentId, name, lastName, email, phoneNumber));

        System.out.println(returnClient != -1 ? "Cliente agregado con éxito: \n" +
                clientDao.findClientById(documentId) : "No se pudo agregar un nuevo Cliente");
        printSeparator();
    }

    public void updateClient() {
        System.out.println("--- Modificar un Cliente ---");

        int documentId = getIntInput("DNI del Cliente a modificar: ");
        Client client = clientDao.findClientById(documentId);

        if (client == null) {
            System.out.println("No se encontró un cliente con DNI: " + documentId);
            return;
        }

        System.out.println("Ingrese un '-' para NO modificar un campo");

        client.setDocumentId(getIntInput("Nuevo DNI: ", client.getDocumentId()));
        client.setName(getStringInput("Nombre: ", client.getName()));
        client.setLastName(getStringInput("Apellido: ", client.getLastName()));
        client.setEmail(getEmailInput("Email: ", client.getEmail()));
        client.setPhoneNumber(getLongInput("Celular: ", client.getPhoneNumber()));
        client.setActive(getStateInput("Estado (activo/inactivo): ", client.isActive()));

        clientDao.updateClient(client);
        System.out.println("Cliente actualizado: \n" + client);
            printSeparator();

    }

    public void deleteClient() {
        System.out.println("--- Eliminar un Cliente ---");

        int documentId = getIntInput("Ingrese el DNI del Cliente a eliminar: ");
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

    private int getIntInput(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(console.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido.");
            }
        }
    }

    private int getIntInput(String message, int currentValue) {
        while (true) {
            System.out.print(message);
            String input = console.nextLine().trim();
            if (input.equals("-")){
                return currentValue;
            }

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido.");
            }
        }
    }

    private String getStringInput(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = console.nextLine().trim();

            if (!input.isBlank()) {
                return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
            } else {
                System.out.println("Error: el campo no puede estar en blanco o vació.");
            }

        }
    }

    private String getStringInput(String message, String currentValue) {
        String input;
        while (true) {
            System.out.print(message);
            input = console.nextLine().trim();

            if (input.equals("-")){
                return currentValue;
            }

            if (!input.isBlank()) {
                return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
            } else {
                System.out.println("Error: el campo no puede estar en blanco o vació.");
            }

        }
    }

    private String getEmailInput(String message) {
        Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        String input;

        do {
            System.out.print(message);
            input = console.nextLine();

            if (EMAIL_PATTERN.matcher(input).matches()) {
                return input.toLowerCase();
            } else {
                System.out.println("Error: el formato del correo electrónico no es válido");
            }

        }while (true);
    }

    private String getEmailInput(String message, String currentValue) {
        Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        String input;

        do {
            System.out.print(message);
            input = console.nextLine();

            if (input.equals("-")){
                return currentValue;
            }

            if (EMAIL_PATTERN.matcher(input).matches()) {
                return input.toLowerCase();
            } else {
                System.out.println("Error: el formato del correo electrónico no es válido");
            }

        }while (true);
    }

    private long getLongInput(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Long.parseLong(console.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido.");
            }
        }
    }

    private long getLongInput(String message, Long currentValue) {
        while (true) {
            System.out.print(message);

            String input = console.nextLine().trim();
            if (input.equals("-")){
                return currentValue;
            }
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido.");
            }
        }
    }

    private boolean getStateInput(String message, boolean currentValue) {
        while (true) {
            System.out.print(message);
            String input = console.nextLine().trim().toLowerCase();

            if (input.equals("-")) {
                return currentValue;
            } else if (input.equalsIgnoreCase("activo") || input.equalsIgnoreCase("inactivo")) {

                return input.equals("activo");
            } else {
                System.out.println("Error: ingresa 'activo', 'inactivo' o '-' para mantener el valor actual.");
            }
        }
    }

}
