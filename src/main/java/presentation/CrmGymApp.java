package presentation;

import service.ClientService;

import java.util.Scanner;

public class CrmGymApp {
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
                printSeparator();
                System.out.println("❌ Error: " + e.getMessage());
                printSeparator();
            }
            System.out.println();
        }
    }

    private static int showMenu() {
        int option;
        while (true) {
            try {
                System.out.println("""
                              ╔═══════════════════════════════════════════════════════╗
                              ║             🏋️‍♂️ CRM GYM App 🏋️‍♂️(Fase 1)                ║
                              ╠═══════════════════════════════════════════════════════╣
                              ║     1. 📋 Listar Clientes                             ║
                              ║     2. 🔍 Buscar Cliente por DNI                      ║
                              ║     3. ➕ Agregar Cliente                             ║
                              ║     4. ✏️ Modificar Cliente                           ║
                              ║     5. ❌ Eliminar Cliente                            ║
                              ║     6. 🚪 Salir                                       ║
                              ╚═══════════════════════════════════════════════════════╝
                              """);
                System.out.print("Elige una opción (escribe el n° correspondiente): ");
                option = Integer.parseInt(console.nextLine());
                return option;

            } catch (NumberFormatException e) {
                printSeparator();
                System.out.println("⚠️ Entrada no válida. Por favor, ingresa un número entre 1 y 6.");
                printSeparator();
            }
        }
    }


    private static boolean executeOptions(int option) {
        printSeparator();

        switch (option) {
            case 1 -> clientService.listClients();
            case 2 -> clientService.findClient();
            case 3 -> clientService.addClient();
            case 4 -> clientService.updateClient();
            case 5 -> clientService.deleteClient();
            case 6 -> exit();
            default -> System.out.println("⚠\uFE0F Opción no válida. Inténtalo de nuevo");
        }
        printSeparator();
        return option == 6;

    }

    private static void exit() {
        System.out.println("""
                            ╔═════════════════════════════════════════════════════════╗
                            ║          🏁 Gracias por usar CRM GYM 🏁    (Fase 1)    ║
                            ╚═════════════════════════════════════════════════════════╝
                            """);
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println("═════════════════════════════════════════════════════════");
    }

}
