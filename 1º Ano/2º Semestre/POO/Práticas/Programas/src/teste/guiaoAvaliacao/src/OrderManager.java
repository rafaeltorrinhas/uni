import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderManager {
    private Map<Integer, Order> orders;

    public OrderManager() {
        this.orders = new HashMap<>();
    }

    public void readFile(String file) throws FileNotFoundException {
        File file1 = new File(file);
        Scanner sc = new Scanner(file1);
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            String[] data = line.split("\t");
            // id cliente
            String idCliente = data[0].trim();

            // id loja
            String idLoja = data[1].trim();

            // lista de items
            ArrayList<Item> items = new ArrayList<>();

            String[] produtos = data[2].split("\\|");
            for (String p : produtos) {
                String[] produto = p.split("\\:");
                String name = produto[0];
                double price = Double.parseDouble(produto[1]);
                items.add(new Item(name, price));
            }

            // data
            String orderDateTime = data[3];

            // expresso
            Boolean expresso = false;
            if (data[4].equals("expresso")) {
                expresso = true;
            }
            System.out.println("ddsjffwe");
            if (orders.size() != 0) {
                Order order = new Order(idLoja, idCliente, items, orderDateTime, expresso, 0);
                order.setId(orders.size() + 1);

                orders.put(order.getId(), order);
            }

            Order order = new Order(idLoja, idCliente, items, orderDateTime, expresso);
            order.setId(orders.size() + 1);

            orders.put(order.getId(), order);

        }
        sc.close();
    }

    public void writeFile(String file) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            PrintWriter writer = new PrintWriter(new File(file));

            for (Order o : orders.values()) {
                writer.print(o.getClientId() + ";" + o.getStoreId() + ";");

                for (Item i : o.getItems()) {
                    writer.print(i.getName() + ":" + i.getPrice() + "|");
                }

                writer.print(";" + o.getOrderDateTime().format(f) + ";");

                if (o.getExpresso()) {
                    writer.print("espresso\n");
                } else {
                    writer.print("normal\n");
                }
            }
            writer.close();

        } catch (Exception e) {
            System.err.println("Erro ao escrever no ficheiro!!");
        }
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public void removeOrder(int id) {
        orders.remove(id);
    }

    public Order getOrder(int id) {
        return orders.get(id);
    }

    public double calculateOrderCost(int id) {
        Order order = orders.get(id);
        if (order == null) {
            return -1;
        }
        StandardOrderCostCalculator c = new StandardOrderCostCalculator();

        return c.calculateOrderCost(order);
    }

    public void printAllOrders() {
        for (Order o : orders.values()) {
            System.out.println(o);
        }
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

}
