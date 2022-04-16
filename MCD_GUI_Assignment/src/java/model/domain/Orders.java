// Author:Lim Sheng En
// Description: The Orders Class provides the attributes of the product details in orders statement, 
//              it  has an aggregation relationship with product and payment. 
//              The class also provides a few functions that are needed to store and auto generate order ID in the class.

package model.domain;

import java.io.Serializable;
import java.util.*;


public class Orders implements Serializable {
    
    private String orderId;
    private String comment;
    private String rating;
    private int orderQuantity;
    private Product product;
    private Payment payment;

    public Orders() {
    }

    public Orders(String orderId) {
        this.orderId = orderId;
    }

    public Orders(String orderId, Product product, int orderQuantity, Payment payment) {
        this.orderId = orderId;
        this.product = product;
        this.orderQuantity = orderQuantity;
        this.payment = payment;
    }

    public Orders(String orderId, String comment, String rating, int orderQuantity, Product product,  Payment payment) {
        this.orderId = orderId;
        this.comment = comment;
        this.rating = rating;
        this.orderQuantity = orderQuantity;
        this.product = product;
        this.payment = payment;
    }

    
    public String getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public String getComment() {
        return comment;
    }

    public String getRating() {
        return rating;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", "
                + "product=" + product.getProductName() + ", "
                + "comment=" + comment + ", "
                + "rating=" + rating + ", "
                + "orderQuantity=" + orderQuantity + ", "
                + "payment=" + payment.getPaymentID() + '}';
    }
    
}