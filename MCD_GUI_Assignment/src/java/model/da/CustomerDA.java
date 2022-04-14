package model.da;

import model.domain.Address;
import model.domain.Customer;
import model.domain.Role;
import model.domain.Staff;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDA {

    private final String host = "jdbc:derby://localhost:1527/MCD";
    private final String user = "nbuser";
    private final String password = "nbuser";
    private final String tableName = "CUSTOMER";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public CustomerDA() {
        createConnection();
    }

    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            //System.out.println("Error. Cannot connect to database");
            ex.getMessage();
        }
    }

    public boolean Confirmlogin(String customerid, String password) {
        boolean detect = true;
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMER_ID = ? AND PASSWORD = ? ";
        Customer cust = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, customerid);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                cust = new Customer(rs.getString("CUSTOMER_ID"), rs.getString("CUSTOMER_NAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("PASSWORD"));
            } else {
                detect = false;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.toString());
        }
        return detect;
    }

    public void addCustomer(Customer cust) {
        //not recommend use JOption Pane
        String insertStr = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?)";

        try {
            stmt = conn.prepareStatement(insertStr);

            stmt.setString(1, cust.getCustomerID());
            stmt.setString(2, cust.getCustomerName());
            stmt.setString(3, cust.getEmail());
            stmt.setString(4, cust.getPhoneNum());
            stmt.setString(5, cust.getPassword());
            stmt.setString(6, cust.getAddress().getAddressId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public ArrayList<Customer> listCustomer() {
        ArrayList<Customer> customer = new ArrayList<Customer>();
        String sqlQuery = "SELECT * FROM CUSTOMER";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                customer.add(new Customer(rs.getString("CUSTOMER_ID"),
                        rs.getString("CUSTOMER_NAME"), 
                        rs.getString("EMAIL"),
                        rs.getString("PHONE"), 
                        rs.getString("PASSWORD"), 
                        new Address(rs.getString("ADDRESS_ID"))));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return customer;
    }

    public ArrayList<Customer> listNewCustomer() {
        ArrayList<Customer> customer = new ArrayList<Customer>();
        String sqlQuery = "SELECT * FROM CUSTOMER ORDER BY CUSTOMER_ID DESC";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                customer.add(new Customer(rs.getString("CUSTOMER_ID"),
                        rs.getString("CUSTOMER_NAME"), 
                        rs.getString("EMAIL"),
                        rs.getString("PHONE"), 
                        rs.getString("PASSWORD"), 
                        new Address(rs.getString("ADDRESS_ID"))));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return customer;
    }

    //update
    public Customer retrieveCustomer(String customerID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMER_ID = ?";
        Customer customer = null;
        Address address = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, customerID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                customer = new Customer(rs.getString("CUSTOMER_ID"),
                        rs.getString("CUSTOMER_NAME"),
                        rs.getString("EMAIL"),
                        rs.getString("PHONE"),
                        rs.getString("PASSWORD"),
                        new Address(rs.getString("ADDRESS_ID")));
            }

            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return customer;
    }

    public Customer retrieveEmail(String email) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE EMAIL = ?";
        Customer customer = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                customer = new Customer(email, rs.getString("EMAIL"));
            }

            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            ex.getMessage();
        }

        return customer;
    }

    public String generateLatestID() {
        String customerID = "";
        String sqlQuery = "SELECT CUSTOMER_ID FROM CUSTOMER";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                customerID = rs.getString("CUSTOMER_ID");
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
        customerID = newID(customerID);

        return customerID;
    }

    public String newID(String CustomerID) {

        String[] id = CustomerID.split("-");
        int no = Integer.parseInt(id[1]);
        no++;
        //(int)id[1]=Integer.parseInt(id[1])+1;
        String seq = String.format("%03d", no);
        String CID = id[0] + "-" + seq;
        return CID;
    }

    public int updateRecord(Customer customer) throws SQLException {
        String queryStr = "UPDATE " + tableName + " SET CUSTOMER_NAME =?, EMAIL =?, PHONE =?, PASSWORD = ? , ADDRESS_ID = ? WHERE CUSTOMER_ID =?";
        int count = 0;

        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1, customer.getCustomerName());
        stmt.setString(2, customer.getEmail());
        stmt.setString(3, customer.getPhoneNum());
        stmt.setString(4, customer.getPassword());
        stmt.setString(5, customer.getAddress().getAddressId());
        stmt.setString(6, customer.getCustomerID());

        count = stmt.executeUpdate();

        return count;
    }

    public Customer getRecordById(String id) {
        String queryStr = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        Customer cus = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cus = new Customer(rs.getString("CUSTOMER_ID"),
                        rs.getString("CUSTOMER_NAME"), rs.getString("EMAIL"),
                        rs.getString("PHONE"), rs.getString("PASSWORD"));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.toString());
        }
        return cus;
    }

}
