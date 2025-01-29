import java.util.ArrayList;
import java.util.List;

//! Clase Singleton para gestionar el historial de pedidos
public class Undo {
    private static Undo instance; // Instancia única
    private List<String> pedidos; // Lista para guardar los pedidos

    //* Constructor privado para evitar instanciación directa
    private Undo() {
        pedidos = new ArrayList<>();
    }

    //* Metodo estático para obtener la instancia única
    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    //* Metodo para agregar un pedido
    public void addPedido(String pedido) {
        pedidos.add(pedido);
    }

    //* Metodo para deshacer el último pedido
    public String undo() {
        if (!pedidos.isEmpty()) {
            return pedidos.remove(pedidos.size() - 1);
        }
        return "No hay pedidos para deshacer.";
    }

    //* Metodo para eliminar el último pedido (llama a undo)
    public void removeLastPedido() {
        System.out.println("Pedido eliminado: " + undo());
    }

    //* Metodo para listar los pedidos
    public void listPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en el historial.");
        } else {
            System.out.println("Historial de pedidos:");
            for (String pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    //* Metodo para obtener todos los pedidos
    public List<String> getPedidos() {
        return pedidos;
    }
}
