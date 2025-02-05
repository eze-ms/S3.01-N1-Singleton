import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final Undo undo;

    public Menu() {
        scanner = new Scanner(System.in);
        undo = Undo.getInstance();
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar comando");
            System.out.println("2. Deshacer último comando");
            System.out.println("3. Mostrar historial de comandos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            int opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        }
    }

    private int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresa un número válido.");
            return -1;
        }
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> agregarComando();
            case 2 -> deshacerComando();
            case 3 -> mostrarHistorial();
            case 4 -> salir();
            default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
        }
    }

    private void agregarComando() {
        System.out.print("Introduce el comando: ");
        String comando = scanner.nextLine();
        undo.addComando(comando);
        System.out.println("Comando añadido.");
    }

    private void deshacerComando() {
        System.out.println("Deshacer: " + undo.undo());
    }

    private void mostrarHistorial() {
        undo.listComandos();
    }

    private void salir() {
        System.out.println("Saliendo...");
        scanner.close();
        System.exit(0);
    }
}
