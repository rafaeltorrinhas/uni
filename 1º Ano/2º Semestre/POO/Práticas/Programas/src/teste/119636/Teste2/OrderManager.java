package Teste2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();

    public OrderManager(){

    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public Order getOrder(int id){
        Order toReturn=null;
        for(Order o: orders){
            if(o.getId() ==id){
                toReturn=o;
            }
        }
        if(toReturn == null){
            System.out.println("Id desconhecido");
        }
        return toReturn;
    }
    public void removeOrder(int id){
        orders.remove(getOrder(id));
    }
    public double calculateOrderCost(int id){
        Order o =getOrder(id);
        if(o==null){
            return -1;
        }
        StandardOrderCostCalculator calculator = new StandardOrderCostCalculator();
        return calculator.calculateOrderCost(o); 
    }
    public void printAllOrders(){
        for (Order o: orders){
            System.out.println(o);
        }
    }
    public void readFile(String file) throws IOException{
        Scanner input = null;
        try {
             input = new Scanner(new FileReader(file,StandardCharsets.UTF_8));
            while (input.hasNextLine()){
                String data =input.nextLine();
                String[] words = data.split("[\\;\\\\]");
                String[] itensString = words[2].split("[\\:|\\\\]");
                ArrayList<Item> itensData = new ArrayList<>();
                if(words[2].equals("Composição")){
                    continue;
                }

                for(int i=0; i<itensString.length;i=i+2){
                    Item item = new Item(itensString[i], Double.parseDouble(itensString[i+1]));
                    itensData.add(item);
                }

                addOrder(new Order(words[0], words[1], itensData, words[3], words[4].equals("expresso")));
            }

                
            

        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não existente!");
        } finally {
            if (input != null) input.close();
        }
    }

    public void writeFile(String file){



            try {
                FileWriter myWriter = new FileWriter(file,StandardCharsets.UTF_8);
                for(Order o: orders){
                    myWriter.write(o.toString()+";\n");
                }
    
    
                myWriter.close();
            
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
}


