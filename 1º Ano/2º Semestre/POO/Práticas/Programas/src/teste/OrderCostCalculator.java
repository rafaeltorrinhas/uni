package teste;

public interface OrderCostCalculator {
  default double calculateOrderCost(Order order) {
    double price = 0;
    for (int i = 0; i < order.getOrder().size(); i++) {
      if (order.getOrder() != null) {
        price += order.getOrder().get(i).getPrice();
      }
    }
    return price;
  };
}
