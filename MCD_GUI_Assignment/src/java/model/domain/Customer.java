package model.domain;

import java.io.Serializable;

public class Customer implements Serializable{
    private String customerName;
    private String email;
    private int phoneNum;
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

    public Customer(String customerName, String email, int phoneNum, String password, Address address) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
        this.address = address;
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %d %s %s", customerName, email, phoneNum, password, address);
    }
    
}
