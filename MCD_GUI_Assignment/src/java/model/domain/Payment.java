package model.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class Payment implements Serializable {

    private String paymentID;
    private String paymentMethod;
    private double totalPaymentAmount;
    private String orderStatus;
    private Date dateTime;
    private Customer customer;
    private Card card;

    public Payment() {
        setDateTimeNow();
    }

    public Payment(String paymentID) {
        this.paymentID = paymentID;

        setDateTimeNow();
    }

    public Payment(String paymentMethod, double totalPaymentAmount, Customer customer, Card card) {
        this.paymentMethod = paymentMethod;
        this.totalPaymentAmount = totalPaymentAmount;
        this.customer = customer;
        this.card = card;

        setDateTimeNow();
    }

    public Payment(String paymentID, String paymentMethod, double totalPaymentAmount, Customer customer, Card card) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.totalPaymentAmount = totalPaymentAmount;
        this.customer = customer;
        this.card = card;

        setDateTimeNow();

    }

    public Payment(String paymentID, String paymentMethod, double totalPaymentAmount, Date paymentTime, Customer customer, Card card) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.totalPaymentAmount = totalPaymentAmount;
        this.dateTime = paymentTime;
        this.customer = customer;
        this.card = card;
    }

    public Payment(String paymentID, String paymentMethod, double totalPaymentAmount, String orderStatus, Date paymentTime, Customer customer, Card card) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.totalPaymentAmount = totalPaymentAmount;
        this.orderStatus = orderStatus;
        this.dateTime = paymentTime;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Card getCard() {
        return card;
    }

    public Date getDateTime() {
        return dateTime;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setDateTimeNow() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.dateTime = date;
    }

    public Timestamp getPaymentTimestamp() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        Timestamp paymentTime = new Timestamp(date.getTime());

        this.dateTime = new Date(System.currentTimeMillis());

        return paymentTime;
    }

    public static Date convertTimestampToDate(Timestamp timestamp) {

        Date date = new Date(timestamp.getTime());
        return date;
    }

    @Override
    public String toString() {
        return "Payment{" + "PaymentID=" + paymentID + ", "
                + "paymentMethod=" + paymentMethod + ", "
                + "PaymentAmount=" + totalPaymentAmount + ", "
                + "PaymentTime=" + dateTime + ", "
                + "customer=" + customer.getCustomerName() + ", "
                + "card=" + card.getCardNo() + '}';
    }

}
