// Author:Lim Wei Zhe
// Description:It is a Java Class that is needed for the MVC concept. This class is a controller class for CustomerDA class 

package controller.Control;

import model.da.CustomerDA;
import model.da.StaffDA;
import model.domain.Customer;
import java.io.Serializable;

public class CustomerControl implements Serializable{
    
    private CustomerDA custDA;
    private StaffDA staffDA;
    private String custID;
    
    public CustomerControl() {
        custDA = new CustomerDA();
        this.custID = custDA.generateLatestID();
    }
    
    //create
    public void addCustomer(Customer cust) {
        custDA.addCustomer(cust);
    }
    
    //retrive 
    public Customer retrieveCustomer(String customerID){
        return custDA.retrieveCustomer(customerID);
    }
        
    public String custID(){
        //code in DA
        String customerID = custDA.generateLatestID();
        return customerID;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }
    
    
}
