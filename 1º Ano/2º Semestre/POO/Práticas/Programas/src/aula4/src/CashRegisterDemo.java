package aula4.src;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class CashRegister {
    String names[];
    double price[];
    int qty[];
    double total[];
    int i = 0;

    public CashRegister() {
        names = new String[5];
        price = new double[5];
        qty = new int[5];
        total = new double[5];
    }

    public void addProduct(Product product) {
        names[i] = product.getName();
        price[i] = product.getPrice();
        qty[i] = product.getQuantity();
        total[i] = product.getTotalValue();
        i++;
    }

    double totalf;

    public String toString() {
        String result = String.format("%-15s %5s %10s %10s \n", "Product", "Price", "Quantity", "Total");

        for (int i = 0; i <= names.length - 1; i++) {
            result += String.format("%-15s %5.2f %10s %10.2f \n", names[i], price[i], qty[i], total[i]);
            totalf += total[i];
        }
        result += String.format("Total value: %.2f", totalf);

        return result;
    }
}

public class CashRegisterDemo {

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));

        // Listar o conteúdo e valor total
        System.out.println(cr);

    }
}
