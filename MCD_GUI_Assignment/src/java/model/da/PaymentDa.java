// Author:Chan Zhi Yang
// Description:A Class that uses JDBC function to connect with the derby database. This class mainly provides functions of CRUD operations for the Payment table. 
package model.da;

import model.domain.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentDA {

    private String host = "jdbc:derby://localhost:1527/MCD";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PAYMENT";
    private Connection conn;
    private PreparedStatement stmt;

    public PaymentDA() throws SQLException {
        try {
            createConnection();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public PaymentDA(String user, String password, String tableName) throws SQLException {
        this.user = user;
        this.password = password;
        this.tableName = tableName;

        try {
            createConnection();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public Payment retievePaymentRecord(String paymentID) throws SQLException {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PAYMENT_ID = ?";

        Payment payment = null;

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, paymentID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                payment = new Payment(paymentID,
                        rs.getString("PAYMENT_METHOD"),
                        rs.getDouble("TOTAL_PAYMENT_AMOUNT"),
                        rs.getString("ORDER_STATUS"),
                        rs.getDate("DATE_TIME"),
                        new Customer(rs.getString("CUSTOMER_ID")),
                        new Card(rs.getString("CARD_NO")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return payment;
    }
    
    public int insertPayment(Payment payment) throws SQLException {
        String sqlStr = "INSERT INTO PAYMENT VALUES(?,?,?,?,?,?,?)";
        int rows = 0;

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, payment.getPaymentID());
            stmt.setString(2, payment.getPaymentMethod());
            stmt.setDouble(3, payment.getTotalPaymentAmount());
            stmt.setString(4, payment.getOrderStatus());
            stmt.setTimestamp(5, payment.getPaymentTimestamp());
            stmt.setString(6, payment.getCustomer().getCustomerID());
            stmt.setString(7, payment.getCard().getCardNo());
            
            rows = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }
        return rows;
    }

    public int updatePayment(Payment payment) throws SQLException {
        String sqlStr = "UPDATE PAYMENT SET PAYMENT_ID=?, "
                + "PAYMENT_ID=?, "
                + "PAYMENT_METHOD=?, "
                + "TOTAL_PAYMENT_AMOUNT=?, "
                + "ORDER_STATUS=?, "
                + "DATE_TIME=?, "
                + "CUSTOMER_ID=?, "
                + "CARD_NO=? "
                + "WHERE CUSTOMER_ID=?";
        int rows = 0;

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, payment.getPaymentID());
            stmt.setString(2, payment.getPaymentMethod());
            stmt.setDouble(3, payment.getTotalPaymentAmount());
            stmt.setString(4, payment.getOrderStatus());
            stmt.setTimestamp(5, payment.getPaymentTimestamp());
            stmt.setString(6, payment.getCustomer().getCustomerID());
            stmt.setString(7, payment.getCard().getCardNo());

            rows = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return rows;
    }
    
    
    public int deletePayment(String paymentID) throws SQLException {
        String sqlStr = "DELETE FROM PAYMENT WHERE PAYMENT_ID = ?";
        int rows = 0;

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, paymentID);

            rows = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return rows;
    }

    public String newPaymentID() {
        String paymentID = "";
        String sqlQuery = "SELECT PAYMENT_ID FROM PAYMENT";

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();
            
             if (rs.next() == false) {
                 paymentID = "PAY-000";
            } else {
                do {
                  paymentID = rs.getString(1);
                } while (rs.next());
            }
             
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        paymentID = newID(paymentID);
        return paymentID;
    }

    public String newID(String paymentID) {
        String[] id = paymentID.split("-");
        int no = Integer.parseInt(id[1]);
        no++;

        String seq = String.format("%03d", no);
        String PID = id[0] + "-" + seq;
        return PID;
    }

    private void createConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            throw ex;
        }
    }

    private void shutDown() throws SQLException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
    
    public static void main (String args[]){
        try {
            PaymentDA paymentDA = new PaymentDA();
            System.out.println(paymentDA.newPaymentID());
//            System.out.println(paymentDA.newID("PAY-3"));
            
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
