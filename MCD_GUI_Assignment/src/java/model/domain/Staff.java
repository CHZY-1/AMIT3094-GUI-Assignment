package model.domain;

import java.io.Serializable;

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
