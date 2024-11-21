package teste;

import java.util.*;
import java.time.*;

public class Order {
  int id;
  List<Item> order = new ArrayList<>();
  String shop;
  String customer;
  LocalDateTime date;
  boolean express;

  public int getId() {
    return id;
  }

  public List<Item> getOrder() {
    return order;
  }

  public void setOrder(List<Item> order) {
    this.order = order;
  }

  public String getShop() {
    return shop;
  }

  public void setShop(String shop) {
    this.shop = shop;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public boolean isExpress() {
    return express;
  }

  public void setExpress(boolean express) {
    this.express = express;
  }

  public Order(int id, List<Item> order, String shop, String customer, LocalDateTime date, boolean express) {
    this.id = id++;
    this.order = order;
    this.shop = shop;
    this.customer = customer;
    this.date = date;
    this.express = express;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", order=" + order + ", shop=" + shop + ", customer=" + customer + ", date=" + date
        + ", express=" + express + "]";
  }

}
