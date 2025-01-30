import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> pedidos;

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

    public void addPedido(String pedido) {
        pedidos.add(pedido);
    }

    public String undo() {
        if (!pedidos.isEmpty()) {
            return pedidos.remove(pedidos.size() - 1);
        }
        return "No hay pedidos para deshacer.";
    }

    public void removeLastPedido() {
        System.out.println("Pedido eliminado: " + undo());
    }

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

    public List<String> getPedidos() {
        return pedidos;
    }
}
