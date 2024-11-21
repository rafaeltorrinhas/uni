
package Teste2;

import java.io.IOException;
import java.util.ArrayList;

public class OrderTester {
    public static void main(String[] args) throws IOException {
        OrderManager om = new OrderManager();

		ArrayList<Item> items1 = new ArrayList<>();
        ArrayList<Item> items2 = new ArrayList<>();
        ArrayList<Item> items3 = new ArrayList<>();


        items1.add(new Item("Super-Bock, pack de 6", 4));
        items1.add(new Item("Fanta", 2.5));
        items1.add(new Item("Leite, pack de 6", 5.4));

        items2.add(new Item("Cadeira", 125));
        items2.add(new Item("Mesa", 300));

        items3.add(new Item("Coca-Cola", 4));
        items3.add(new Item("Fanta", 2.5));
        items3.add(new Item("Sprite pack 6", 12));

       
        // ----------------------------------------------------------
        om.addOrder(new Order("10", "11", items1, "2024-05-18 09:15", true));
        om.addOrder(new Order("2", "54", items2, "2024-05-21 12:13", false));
        om.addOrder(new Order("14", "11", items3, "2024-05-21 12:13", false));
        // ----------------------------------------------------------

        om.printAllOrders();

        // ----------------------------------------------------------
        System.out.println("Dados do primeiro pedido !");
        System.out.println(om.getOrder(1));
        System.out.println("Custo;");
        System.out.println(om.calculateOrderCost(1));
        System.out.println("Dados do segundo pedido !");
        System.out.println(om.getOrder(2));
        System.out.println("Custo;");
        System.out.println(om.calculateOrderCost(2));
        System.out.println(om.getOrder(30));              // não existe!
        System.out.println(om.calculateOrderCost(30));  // não existe!
        // ----------------------------------------------------------

       om.readFile("pedidos.txt");


        om.printAllOrders();


        om.writeFile("pedidosFinal.txt");

    }
}
