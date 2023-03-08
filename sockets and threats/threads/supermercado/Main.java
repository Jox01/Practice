package supermercado;

public class Main {
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1, 6});

        Cajera cajera1 = new Cajera("Cajera 1");
        Cajera cajera2 = new Cajera("Cajera 2");

        long initialTime = System.currentTimeMillis();

        cajera1.processarCompra(cliente1, initialTime);
        cajera2.processarCompra(cliente2, initialTime);
    }
}
