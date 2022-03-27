package model.domain;

import java.io.Serializable;

public class Address implements Serializable{
    private String addressId;
    private String street;
    private String state;
    private int postcode;

    public Address() {
        
    }

     public Address(String street) {
        this.street = street;
    }
     
    public Address(String street, String state, int postcode) {
        this.street = street;
        this.state = state;
        this.postcode = postcode;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
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

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
