package model.domain;

import java.io.Serializable;
import java.util.*;

public class Order implements Serializable {
    
    private int orderId;
    private String orderStatus;
    private ArrayList<Product> productList = new ArrayList<Product>();

    public Order() {
    }

    public Order(int orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public Order(String orderStatus, ArrayList<Product> productList) {
        this.orderStatus = orderStatus;
        this.productList = productList;
    }
    
    public Order(int orderId, String orderStatus, ArrayList<Product> productList) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.productList = productList;
    }
    
    
    // Getter
    public int getOrderId() {
        return orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    
    // Setter
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
    
    // Food Order List
    public int getProductListSize(){
        return productList.size();
    }
    
   public void addProductList(Product product){
       this.productList.add(product);
   }
   
   public void removeProductList(Product product){
       this.productList.remove(product);
   }
   
   public void removeProductList(int index){
       this.productList.remove(index);
   }
   
}