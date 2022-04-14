package model.domain;

import java.io.Serializable;

public class Address implements Serializable{
    private String addressId;
    private String street;
    private String state;
    private String postcode;

    public Address() {
        
    }

    public Address(String addressId) {
        this.addressId = addressId;
    }
    
     
    public Address(String street, String state, String postcode) {
        this.street = street;
        this.state = state;
        this.postcode = postcode;
    }

    public Address(String addressId, String street, String state, String postcode) {
        this.addressId = addressId;
        this.street = street;
        this.state = state;
        this.postcode = postcode;
    }

    
    public String getAddressId() {
        return addressId;
    }

    public void setAddressID(String addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}