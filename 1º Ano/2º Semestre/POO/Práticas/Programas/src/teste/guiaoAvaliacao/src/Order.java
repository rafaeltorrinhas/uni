import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    // one or more attributes may be missing
    private static int nextId = 1;
    private int id;
    private ArrayList<Item> items;
    private String storeId;
    private String clientId;
    private LocalDateTime orderDateTime;
    private Boolean expresso;

    
    // the construtor(s) and others methods of this class should be below
    
    public Order(String clientId, String storeId, ArrayList<Item> items, String orderDateTime, Boolean expresso) {
        this.id = nextId++;
        this.items = items;
        this.storeId = storeId;
        this.clientId = clientId;
        this.expresso = expresso;

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(orderDateTime, f);
        this.orderDateTime = date;
    }

    public Order(String clientId, String storeId, ArrayList<Item> items, String orderDateTime, Boolean expresso, int notNew) {
        
        this.items = items;
        this.storeId = storeId;
        this.clientId = clientId;
        this.expresso = expresso;

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(orderDateTime, f);
        this.orderDateTime = date;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


    public String getStoreId() {
        return storeId;
    }


    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }


    public String getClientId() {
        return clientId;
    }


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }


    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }


    public Boolean getExpresso() {
        return expresso;
    }


    public void setExpresso(Boolean expresso) {
        this.expresso = expresso;
    }

    public String listItems() {
        String s = "";
        for (Item i : items) {
            s += i.getName() + ":" + String.valueOf(i.getPrice() + "|");
        }
        return s;
    }
    
    public double valorTotal() {
        double soma = 0;
        for (Item i : items) {
            soma += i.getPrice();
        }

        return soma;
    }

    
    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String exp;
        
        if (expresso) {
            exp = "true";
        }else {
            exp = "false";
        }

        String stringOfReturn = "Id: " + String.valueOf(id) + "\n\tProdutos: " + listItems() + "\n\tId loja: " + storeId + "\n\tId Cliente: " + clientId + "\n\tData: " + orderDateTime.format(f) + "\n\tExpresso: " + exp;
        return stringOfReturn;
        
    }

    
}
