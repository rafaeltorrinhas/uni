package Teste2;

import java.util.ArrayList;

public class StandardOrderCostCalculator implements OrderCostCalculator{

    public StandardOrderCostCalculator(){
        
    }
    public double calculateOrderCost(Order order) {
        ArrayList<Item> itensOrder = order.getItems();
        double total=0;
        boolean isEspress= order.getExpressOrder();
        for(Item i: itensOrder){
            if(isEspress){
            total += i.getPrice()*1.25;
            }
            else{
                total += i.getPrice();
            }
        }

        return total;
    }
}
