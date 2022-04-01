package model.domain;

import java.io.Serializable;

public class Customer implements Serializable{
    private String customerID;
    private String customerName;
    private String email;
    private String phoneNum;
    private String password;
    private Address address;

    public Customer() {
    }
    
    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public Customer(String customerName, String password) {
        this.customerName = customerName;
        this.password = password;
    }

    public Customer(String customerID, String customerName, String email, String phoneNum, String password, Address address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
        this.address = address;
    }
    
    // Getters
    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }
    
    
    // Setters
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
    
}
