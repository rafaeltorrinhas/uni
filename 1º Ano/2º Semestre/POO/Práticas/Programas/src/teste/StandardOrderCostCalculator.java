package teste;

public class StandardOrderCostCalculator implements OrderCostCalculator {

  public double calculateOrderCost(Order order) {
    if (order == null) {
      return -1;
    } else {
      double total = OrderCostCalculator.super.calculateOrderCost(order);
      if (order.isExpress() == true) {
        total += total * .25;
      }
      return total;
    }
  }

}
