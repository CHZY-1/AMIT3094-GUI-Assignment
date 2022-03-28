package model.domain;

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Payment implements Serializable{
    
    private String paymentID;
    private String paymentMethod;
    private double totalPaymentAmount;
    private Date dateTime;
    private Order order;
    private Customer customer;
    private Card card;

    public Payment() {
    }

    public Payment(String paymentID, String paymentMethod, double totalPaymentAmount, Order order, Customer customer, Card card) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.totalPaymentAmount = totalPaymentAmount;
        this.order = order;
        this.customer = customer;
        this.card = card;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        setDateTime(date);
        
    }

    public Payment(String paymentID, String paymentMethod, double totalPaymentAmount, Date dateTime, Order order, Customer customer, Card card) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.totalPaymentAmount = totalPaymentAmount;
        this.dateTime = dateTime;
        this.order = order;
        this.customer = customer;
        this.card = card;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public Order getOrder() {
        return order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Card getCard() {
        return card;
    }
    
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setTotalPaymentAmount(double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", "
                + "paymentMethod=" + paymentMethod + ", "
                + "totalPaymentAmount=" + totalPaymentAmount + ", "
                + "dateTime=" + dateTime + ", "
                + "order=" + order + ", "
                + "customer=" + customer + ", "
                + "card=" + card + '}';
    }
    
    
}