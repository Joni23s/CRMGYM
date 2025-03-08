package presentation;

import service.ClientService;

import java.util.Scanner;

public class CrmGymApp {
    private static final String SEPARATOR = "═════════════════════════════════════════════════════════";
    private static final Scanner console = new Scanner(System.in);
    private static final ClientService clientService = new ClientService();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        boolean exit = false;

        while (!exit) {
            try {
                exit = executeOptions(showMenu());

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int showMenu() {
        System.out.println("""
                --- CRM GYM App ---
                1. Listar Clientes
                2. Buscar Cliente por DNI
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elige una opción (escribe el n° correspondiente): \s
                """);
        return Integer.parseInt(console.nextLine());
    }

    private static boolean executeOptions(int option) {
        System.out.println(SEPARATOR);

        switch (option) {
            case 1 -> clientService.listClients();
            case 2 -> clientService.findClient();
            case 3 -> clientService.addClient();
            case 4 -> clientService.updateClient();
            case 5 -> clientService.deleteClient();
            case 6 -> exit();
            default -> System.out.println("Opción no válida. Inténtalo de nuevo");
        }
        return option == 6;

    }

    private static void exit() {
        System.out.println("---> Gracias por usar CRM GYM <---");
        System.out.println(SEPARATOR);
    }

}
