// Author:Chan Zhi Yang
// Description:A java class that is part of the MVC pattern. This class is a controller class for the OrderDA class and Order class. 
package controller.Control;

import java.sql.SQLException;
import java.util.ArrayList;
import model.da.OrderDA;
import model.domain.Orders;

public class OrderController{
    
    private OrderDA orderDA;
    
    public OrderController() throws SQLException {
        orderDA = new OrderDA();
    }
    
    public OrderController(String user, String password, String tableName) throws SQLException {
        orderDA = new OrderDA(user,password,tableName);
    }

    public Orders retrieveOrder(String orderID) throws SQLException {
        
        return orderDA.getOrder(orderID);
    }
    
    public  ArrayList<Orders> retrieveAllOrder() throws SQLException {
        
        return orderDA.getAllOrder();
    }
    
    public int insertNewOrder(Orders order) throws SQLException{
        
        return orderDA.insertNewOrder(order);
    }
    
    public int insertMultipleOrders(ArrayList<Orders> orderList) throws SQLException{
        
        return orderDA.insertMultipleOrders(orderList);
    }
    
    public int updateOrder(Orders orders) throws SQLException{
        
        return orderDA.updateOrder(orders);
    }
    
    public int deleteOrder(String orderID) throws SQLException{
        
        return orderDA.deleteOrder(orderID);
    }
    
    public String generateNewOrderID(){
        
        return orderDA.newOrderID();
    }
    
}