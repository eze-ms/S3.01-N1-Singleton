import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> comandos;

    private Undo() {
        comandos = new ArrayList<>();
    }

    //* Método estático para obtener la instancia única
    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void addComando(String comando) {
        comandos.add(comando);
    }

    public String undo() {
        if (!comandos.isEmpty()) {
            return comandos.remove(comandos.size() - 1);
        }
        return "No hay comandos para deshacer.";
    }

    public void removeLastComando() {
        if (comandos.isEmpty()) {
            System.out.println("No hay comandos para deshacer.");
        } else {
            System.out.println("Comando eliminado: " + undo());
        }
    }

    public void listComandos() {
        if (comandos.isEmpty()) {
            System.out.println("No hay comandos en el historial.");
        } else {
            System.out.println("Historial de comandos:");
            for (String comando : comandos) {
                System.out.println(comando);
            }
        }
    }

    public List<String> getComandos() {
        return comandos;
    }
}
