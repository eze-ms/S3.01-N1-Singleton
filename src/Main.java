public class Main {
    public static void main(String[] args) {
        // Obtener la instancia única de Undo
        Undo undo = Undo.getInstance();

        // Agregar comandos
        undo.addPedido("Pedido 1");
        undo.addPedido("Pedido 2");
        undo.addPedido("Pedido 3");

        // Listar comandos
        System.out.println("Después de agregar pedidos:");
        undo.listPedidos();

        // Eliminar el último comando
        undo.removeLastPedido();

        // Listar comandos nuevamente
        System.out.println("Después de eliminar el último pedido:");
        undo.listPedidos();

        // Eliminar otro comando
        undo.removeLastPedido();

        // Listar comandos al final
        System.out.println("Después de eliminar otro pedido:");
        undo.listPedidos();
    }
}
