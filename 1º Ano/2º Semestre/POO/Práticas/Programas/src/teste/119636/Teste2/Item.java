package Teste2;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
    public String getName() {
		return name;
	}
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getName()+":"+this.getPrice();
    }

}
