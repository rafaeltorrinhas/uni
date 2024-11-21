package Teste2;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {


    // one or more attributes may be missing
    private int id;
    private static int nextid=0;
    private ArrayList<Item> items;
    private String storeId;
    private String clientId;
    private LocalDateTime orderDateTime;
    private Boolean expressOrder;
    public  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Order(String storeId,String clientId,ArrayList<Item> itens,String orderDateTime, Boolean expressOrder){
        LocalDateTime dateandTime = LocalDateTime.parse(orderDateTime,formatter);
        this.id=nextid;
        nextid ++;
        this.storeId=storeId;
        this.clientId=clientId;
        this.items=itens;
        this.orderDateTime=(dateandTime);
        this.expressOrder=expressOrder;

    }
 

    // the construtor(s) and others methods of this class should be below
    
    public String getClientId() {
        return clientId;
    }
    public int getId() {
        return id;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public String getOrderDateTime() {
        return orderDateTime.format(formatter);
    }
    public String getStoreId() {
        return storeId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public void setOrderDateTime(String orderDateTime) {
        LocalDateTime dateandTime = LocalDateTime.parse(orderDateTime,formatter);
        this.orderDateTime = dateandTime;
    }
    public Boolean getExpressOrder() {
        return expressOrder;
    }
    public void setExpressOrder(Boolean expressOrder) {
        this.expressOrder = expressOrder;
    }
    public double total(){
        StandardOrderCostCalculator calculator = new StandardOrderCostCalculator();
        return calculator.calculateOrderCost(this); 
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        for(Item i:this.getItems()){
            stb.append(i.getName()+":"+i.getPrice()+"|");
        }
        String itenString = stb.toString();
        return " "+this.getId()+";"+this.getClientId()+";"+this.getStoreId()+";"+itenString +";"+this.getOrderDateTime()+";" +( this.getExpressOrder()? "Express":"normal") ;
    }





}
