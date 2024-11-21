package avaliacaoaula;

public class LoanCostCalculator implements IBookCostCalculator {

  private double costPerDay = 0.75;
  private double minimumCost = 3.0;

  @Override
  public double calculateCost(int days) {
    double cost = costPerDay * days;
    if (cost < minimumCost) {
      cost = minimumCost;
    }
    return cost;
  }

}
