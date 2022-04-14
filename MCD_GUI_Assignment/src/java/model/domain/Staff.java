package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Staff implements Serializable{
    
    private String staffID;
    private String name;
    private String ic;
    private String password;
    private String status;
    private String phoneNo;
    private String gender;
    private double salary;
    private Address address;
    private Role roleID;
    
    
    public Staff() {
    }
    
    public Staff(String staffID, String name, String ic, String password, String status, String phoneNo, String gender, double salary, Address address, Role roleID) {
        this.staffID = staffID;
        this.name = name;
        this.ic = ic;
        this.password = password;
        this.status = status;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.salary = salary;
        this.address = address;
        this.roleID = roleID;
    }

    public Staff(String staffID, String name, String ic, String password, String phoneNo, String gender) {
        this.staffID = staffID;
        this.name = name;
        this.ic = ic;
        this.password = password;
        this.phoneNo = phoneNo;
        this.gender = gender;
    }

    public Staff(String staffID, String name, String ic, String status, String phoneNo, String gender, double salary) {
        this.staffID = staffID;
        this.name = name;
        this.ic = ic;
        this.status = status;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.salary = salary;
    }
    
    public ArrayList<String> validateStaff(Staff s,Address a,String pass){
       ArrayList<String> err=new ArrayList<String>();
        //name
        if(s.getName() == null){
            err.add("Staff Name cannot be empty");
        }else if(s.getName().length() > 30){
            err.add("Staff Name cannot have more then 30 characters");
        }else if(!Pattern.matches("^[a-zA-Z ]+$", s.getName())){
            err.add("Staff Name should only have alphabets");
        }
        
        //ic
        if(s.getIc() == null){
            err.add("Staff IC cannot be empty");
        }else if(s.getIc().length() != 12){
            err.add("Staff IC should have 12 digits only");
        }else if(!Pattern.matches("^[0-9]+$", s.getIc())){
            err.add("Staff IC should have digits only");
        }
        
        //phone number
        if(s.getPhoneNo()== null){
            err.add("Phone Number field cannot be empty");
        }else if(s.getPhoneNo().length() > 11){
            err.add("Phone Number length cannot be more than 11 numbers"); 
        }else if(!Pattern.matches("^01[0-9]+$", s.getPhoneNo())){
            err.add("Your Mobile phone number should start with 01....");
        }
        
        //street
        if(a.getStreet()== null){
            err.add("Address Street cannot be empty");
        }else if(a.getStreet().length() > 30){
            err.add("Address Street cannot have more then 30 characters");
        }else if(!Pattern.matches("^[0-9A-Za-z, ]+$", a.getStreet())){
            err.add("Address Street contain invalid characters");
        }
        
        //postcode
        if(a.getPostcode()== null){
            err.add("Address Postcode cannot be empty");
        }else if(a.getPostcode().length() != 5){
            err.add("Address Postcode should have 5 digits");
        }else if(!Pattern.matches("^[0-9]+$", a.getPostcode())){
            err.add("Address Postcode contain invalid characters");
        }
        
          
        if(s.getPassword()== null ){
            err.add("Password field cannot be empty");
        }else if(!s.getPassword().equals(pass)){
            err.add("Password does not match");
        }else if(s.getPassword().length()<8){
            err.add("Password should not less than 8 alpha-numeric");
        }else if(s.getPassword().length() > 20){
            err.add("Password cannot have more than 20 alpha-numeric");
        }else if(!Pattern.matches("^[a-zA-Z_0-9]+$", s.getPassword())){
            err.add("Your password should have at least 1 digit and 1 letter"); 
        }
        
        return err;
    }
    public ArrayList<String> validateStaffe(Staff s,Address a){
       ArrayList<String> err=new ArrayList<String>();
        //name
        if(s.getName() == null){
            err.add("Staff Name cannot be empty");
        }else if(s.getName().length() > 30){
            err.add("Staff Name cannot have more then 30 characters");
        }else if(!Pattern.matches("^[a-zA-Z ]+$", s.getName())){
            err.add("Staff Name should only have alphabets");
        }
        
        //ic
        if(s.getIc() == null){
            err.add("Staff IC cannot be empty");
        }else if(s.getIc().length() != 12){
            err.add("Staff IC should have 12 digits only");
        }else if(!Pattern.matches("^[0-9]+$", s.getIc())){
            err.add("Staff IC should have digits only");
        }
        
        //phone number
        if(s.getPhoneNo()== null){
            err.add("Phone Number field cannot be empty");
        }else if(s.getPhoneNo().length() > 11){
            err.add("Phone Number length cannot be more than 11 numbers"); 
        }else if(!Pattern.matches("^01[0-9]+$", s.getPhoneNo())){
            err.add("Your Mobile phone number should start with 01....");
        }
        
        //street
        if(a.getStreet()== null){
            err.add("Address Street cannot be empty");
        }else if(a.getStreet().length() > 30){
            err.add("Address Street cannot have more then 30 characters");
        }else if(!Pattern.matches("^[0-9A-Za-z, ]+$", a.getStreet())){
            err.add("Address Street contain invalid characters");
        }
        
        //postcode
        if(a.getPostcode()== null){
            err.add("Address Postcode cannot be empty");
        }else if(a.getPostcode().length() > 5){
            err.add("Address Postcode cannot have more then 5 digits");
        }else if(!Pattern.matches("^[0-9]+$", a.getPostcode())){
            err.add("Address Postcode contain invalid characters");
        }
        
        return err;
    }
    
    //setter
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }
    
    //getter

    public String getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public String getIc() {
        return ic;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    public Role getRoleID() {
        return roleID;
    }
    
}