
package teste;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class OrderManager {
  private HashMap<Integer, Order> orders;

  public HashMap<Integer, Order> getOrders() {
    return orders;
  }

  public void addOrder(Order order) {
    orders.put(order.getId(), order);
  };

  public void removeOrder(int id) {
    orders.remove(id);
  }

  public Order searchOrder(int id) {
    return orders.get(id);
  }

  public void printAllOrders() {
    for (int i = 0; i < orders.size(); i++) {
      if (searchOrder(i) != null) {
        System.out.println(searchOrder(i));
      }
    }
  }

  public void readFile(String file) {
    try {
      Scanner sc = new Scanner(new FileReader(file));

      while (sc.hasNext()) {
        System.out.println();
      }
      sc.close();

    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
    }
  }

  public void writeFile(String file) {
    try {
      FileWriter writer = new FileWriter(file);
      for (Order order : orders.values()) {
        writer.write(order.toString() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Error writing to file.");
    }
  }

  public double calculateOrderCost(int id) {
    StandardOrderCostCalculator calculator = new StandardOrderCostCalculator();
    return calculator.calculateOrderCost(searchOrder(id));
  }

}
