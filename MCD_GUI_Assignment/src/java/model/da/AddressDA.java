package model.da;

import model.domain.Address;
import java.sql.*;

public class AddressDA {
    private String host = "jdbc:derby://localhost:1527/MCD";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ADDRESS";
    private Connection conn;
    private PreparedStatement stmt;
    
    
    public AddressDA() {
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
    
    public Address addAddress(Address addr) {
        
        //not recommend use JOption Pane
        String insertStr = "INSERT INTO ADDRESS VALUES(?,?,?,?)";
        
        String addrID = generateLatestAddressID();
//        Customer custobj = cust;
//        Address address = cust.getAddress();
//        String addressID = address.getAddressId(); //store address ID to database
        
        try{ 
            stmt = conn.prepareStatement(insertStr);
            
            stmt.setString(1, addrID);
            stmt.setString(2, addr.getStreet());
            stmt.setString(3, addr.getState());
            stmt.setString(4, addr.getPostcode());

            stmt.executeUpdate();
            
            addr.setAddressID(addrID);
            stmt.close();
        }catch(SQLException ex){
             ex.getMessage();
        } 
        return addr;
        
    }
    
    public Address retrieveAddress(String addressID){
        String query = "SELECT * FROM ADDRESS WHERE ADDRESS_ID = ?";
        Address address = null;
        
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, addressID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                address = new Address(rs.getString("ADDRESS_ID"),rs.getString("ADDRESS_STREET"),rs.getString("ADDRESS_STATE"),rs.getString("POSTCODE"));
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return address;
    }
    
    
      public void modAddress(Address addr){
        String sql = "UPDATE  Address SET  ADDRESS_STREET= ?,ADDRESS_STATE=?,POSTCODE=? WHERE ADDRESS_ID = ?";
        try{
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,addr.getStreet());
            stmt.setString(2, addr.getState());
            stmt.setString(3, addr.getPostcode());
            stmt.setString(4, addr.getAddressId());
            int rows=stmt.executeUpdate();
            stmt.close();
        }catch(SQLException ex){
           ex.getMessage();
        }
      }
      
      public void delAddress(String addrID){
        String sql = "DELETE FROM Address WHERE ADDRESS_ID = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,addrID);
            int rows=stmt.executeUpdate();
            stmt.close();
        }catch(SQLException ex){
           ex.getMessage();
        }
      }
    
    public String generateLatestAddressID(){
        String customerID = "";
        String sqlQuery="SELECT ADDRESS_ID FROM ADDRESS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                customerID=rs.getString("ADDRESS_ID");
            }
            stmt.close();
        }catch (SQLException ex) {
            ex.getMessage();
        }
        
        customerID = newAddressID(customerID);
        return customerID;
        
    }
    
    public String newAddressID(String AddressID){
        
       String[] id = AddressID.split("-");
       int no=Integer.parseInt(id[1]);
       no++;
        //(int)id[1]=Integer.parseInt(id[1])+1;
        String seq = String.format("%03d", no);
        String AID=id[0]+"-"+seq;
        return AID;
    }
    
    //close connection object
    private void shutDown() throws SQLException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
}
