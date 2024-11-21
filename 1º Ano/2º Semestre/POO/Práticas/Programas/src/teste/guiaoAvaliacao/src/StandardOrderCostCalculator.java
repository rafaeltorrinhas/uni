public class StandardOrderCostCalculator  implements OrderCostCalculator{
    @Override
    public double calculateOrderCost(Order order) {
        double total;

        if (order.getExpresso()) {
            total = 0;
            for (Item i : order.getItems()) {
            total += i.getPrice();
            }
            total = total + total * 0.25;
            return total;
        } else {
            total = 0;
            for (Item i : order.getItems()) {
            total += i.getPrice();
            }
            return total;
        }
    }

}
