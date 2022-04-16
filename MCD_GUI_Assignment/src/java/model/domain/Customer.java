// Author:Lim Wei Zhe
// Description:The Customer Class provides all of the attributes of the customer information such as the customer ID, email, password and also the address information from the Address Class 
package model.domain;

import java.io.Serializable;
import java.util.Objects;
import model.domain.Address;
import java.util.regex.Pattern;

public class Customer implements Serializable{
    private String customerID;
    private String customerName;
    private String email;
    private String phoneNum;
    private String password;
    private Address address;

    public Customer(){
    }
    
    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public Customer(String customerID, String password) {
        this.customerID = customerID;
        this.password = password;
    }

    public Customer(String customerID, String customerName, String password) {
        this.customerID = customerID;
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

    public Customer(String customerID, String customerName, String email, String phoneNum, String password) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
    }

    public String getCustomerID() {
        return customerID;
    }
    
    public void setCustomerId(String customerID) {
        this.customerID = customerID;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
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
   
    
    public String validateUsername(String customerName){
        String errMsg1 = "";
        
        if(customerName == null){
            errMsg1 += "Customer Name cannot be empty\n\n";
        
        }else if(customerName.length() > 30){
            errMsg1 += "Customer Name cannot have more then 30 characters\n\n";
         
        }else if(!Pattern.matches("^[a-zA-Z]+$", customerName)){
            errMsg1 += "Customer Name should only have alphabets and don't have space\n\n";
            
        }
        
        return errMsg1;
        
    }
    
    public String validatePhoneNum(String phoneNum){
        String errMsg2 = "";
        
        if(phoneNum == null){
            errMsg2 += "Phone Number field cannot be empty\n\n";
            
        }else if(phoneNum.length() > 12){
            errMsg2 += "Phone Number length cannot be more than 12 numbers\n\n"; 
            
        }else if(!Pattern.matches("^01[0-9]-[0-9]+$", phoneNum)){
            errMsg2 += "Your Mobile phone number format is invalid. \nThe format should be 01x-xxxxxxxx" +
                " and should start with 01\n\n";
        }

        return errMsg2;
        
    }
    
    public String validatePassword(String password){
        
        String errMsg3 = "";
        
        if(password == null ){
            errMsg3 += "Password field cannot be empty" + "\n\n";
            
        }else if(password.length() > 7){
            errMsg3 += "Password cannot have more than 7 alpha-numeric" + "\n\n";
            
        }else if(!Pattern.matches("^[a-zA-Z_0-9]+$", password)){
            errMsg3 += "Your should have at least 1 digit and 1 letter" + "\n\n"; 
        }
        
        return errMsg3;
        
    }
    
    public String validateCustomerID(String customerID){
        
        String errMsg4 = "";
        
        if(customerID == null){
            errMsg4 = "Customer ID cannot be empty" + "\n\n";
        }else if(customerID.length() > 6){
            errMsg4 += "Password cannot have more than 7 alpha-numeric" + "\n\n";
        }else if(!Pattern.matches("^CU-[0-9][0-9][0-9]+$", customerID)){
            errMsg4 += "Your Customer ID should be CU-xxx" + "\n\n"; 
        }
        
        return errMsg4;
    }
    

    
//    public String validateEmail(){
//        String errMsg
//    }
    
}
