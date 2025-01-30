public class Main {
    public static void main(String[] args) {
        // Obtener la instancia única de Undo
        Undo undo = Undo.getInstance();

        // Agregar comandos
        undo.addPedido("Pedido 1");
        undo.addPedido("Pedido 2");
        undo.addPedido("Pedido 3");

        System.out.println();

        undo.listPedidos();
        undo.removeLastPedido();

        System.out.println();


        System.out.println("Después de eliminar el último pedido:");
        undo.listPedidos();
        undo.removeLastPedido();

        System.out.println();

        System.out.println("Después de eliminar otro pedido:");
        undo.listPedidos();
    }
}
