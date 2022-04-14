package model.da;

import model.domain.Role;
import model.domain.Staff;
import model.domain.Address;
import java.sql.*;
import java.util.ArrayList;

public class StaffDA {
    private String host = "jdbc:derby://localhost:1527/MCD";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Staff";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
        public StaffDA() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
            // stmt = conn.prepareStatement(sqlQueryStr);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
    }
    public void addStaff(Staff staff){
        String sqlStr="INSERT INTO "+tableName+" VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        try{
            stmt=conn.prepareStatement(sqlStr);
            //update the value for each ?
            stmt.setString(1, staff.getStaffID());
            stmt.setString(2, staff.getName());
            stmt.setString(3, staff.getIc());
            stmt.setString(4, staff.getPassword());
            stmt.setString(5, staff.getStatus());
            stmt.setString(6, staff.getPhoneNo());
            stmt.setString(7, staff.getGender());
            stmt.setDouble(8, staff.getSalary());
            stmt.setString(9, staff.getAddress().getAddressId());
            stmt.setString(10, staff.getRoleID().getRoleID());
            
            int rows=stmt.executeUpdate();
            stmt.close();
        }catch(SQLException ex){
            ex.getMessage();
        }
    }   
     public ArrayList<Staff> listStaff(){
        ArrayList<Staff> staff=new ArrayList<Staff>();
        String sqlQuery="SELECT * FROM Staff";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                staff.add(new Staff(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getDouble(8),new Address(rs.getString(9)),new Role(rs.getString(10))));
            }
            stmt.close();
        }catch (SQLException ex) {
            ex.getMessage();
        }
        return staff;
    }
      public ArrayList<Staff> listStaffByRole(String roleID){
        ArrayList<Staff> staff=new ArrayList<Staff>();
        String sqlQuery="SELECT * FROM Staff WHERE ROLE_ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, roleID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                staff.add(new Staff(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getDouble(8),new Address(rs.getString(9)),new Role(rs.getString(10))));
            }
            stmt.close();
        }catch (SQLException ex) {
            ex.getMessage();
        }
        return staff;
    }
    public Staff getStaff(String staffID){
        Staff staff=null;
        String sqlQuery="SELECT * FROM Staff WHERE Staff_ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, staffID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                staff=new Staff(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getDouble(8),new Address(rs.getString(9)),new Role(rs.getString(10)));
            }
            stmt.close();
        }catch (SQLException ex) {
            ex.getMessage();
        }
        return staff;
    }
    
    public ArrayList<Staff> getStaffDe(String staffName){
         ArrayList<Staff> staff=new ArrayList<Staff>();
        String sqlQuery="SELECT * FROM Staff WHERE Staff_Name=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, staffName);
            rs = stmt.executeQuery();
            while (rs.next()) {
                staff.add(new Staff(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getDouble(8),new Address(rs.getString(9)),new Role(rs.getString(10))));
            }
            stmt.close();
        }catch (SQLException ex) {
            ex.getMessage();
        }
        return staff;
    }
    
    public ArrayList<Staff> listStaffOrder(String order){
        ArrayList<Staff> staff=new ArrayList<Staff>();
        String sqlQuery="SELECT * FROM Staff ORDER BY STAFF_NAME =?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, order);
            rs = stmt.executeQuery();
            while (rs.next()) {
                staff.add(new Staff(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getDouble(8),new Address(rs.getString(9)),new Role(rs.getString(10))));
            }
            stmt.close();
        }catch (SQLException ex) {
            ex.getMessage();
        }
        return staff;
    }
    
    public String newStaffID(){
        String StaffID=null;
        String sqlQuery="SELECT Staff_ID FROM Staff";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StaffID=rs.getString(1);
            }
            stmt.close();
        }catch (SQLException ex) {
            ex.getMessage();
        }
        
        StaffID=newID(StaffID);
        return StaffID;
    }
    public String newID(String StaffID){
        
       String[] id = StaffID.split("-");
       int no=Integer.parseInt(id[1]);
        no++;
        //(int)id[1]=Integer.parseInt(id[1])+1;
        String seq = String.format("%03d", no);
        String SID=id[0]+"-"+seq;
        return SID;
    }
    public void delStaff(String staffID){
        String sql = "DELETE FROM Staff WHERE Staff_ID = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, staffID);
            int rows=stmt.executeUpdate();
            stmt.close();
        }catch(SQLException ex){
           ex.getMessage();
        }
    } 
    
    public void modSelf(Staff staff){
        String sql = "UPDATE  Staff SET  Staff_Name = ?,IC = ?,Phone_No = ?,Gender = ?,password = ? WHERE Staff_ID = ?";
        try{
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, staff.getName());
            stmt.setString(2, staff.getIc());
            stmt.setString(3, staff.getPhoneNo());
            stmt.setString(4, staff.getGender());
            stmt.setString(5, staff.getPassword());
            stmt.setString(6, staff.getStaffID());
            int rows=stmt.executeUpdate();
            stmt.close();
        }catch(SQLException ex){
           ex.getMessage();
        }
    }
    
    public void modStaff(Staff staff,String roleID){
        String sql = "UPDATE  Staff SET  Staff_Name = ?,IC = ?,status = ?,Phone_No = ?,Gender = ?,Salary = ?,Role_ID = ? WHERE Staff_ID = ?";
        try{
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, staff.getName());
            stmt.setString(2, staff.getIc());
            stmt.setString(3, staff.getStatus());
            stmt.setString(4, staff.getPhoneNo());
            stmt.setString(5, staff.getGender());
            stmt.setDouble(6, staff.getSalary());
            stmt.setString(7, roleID);
            stmt.setString(8, staff.getStaffID());
            int rows=stmt.executeUpdate();
            stmt.close();
        }catch(SQLException ex){
           ex.getMessage();
        }
    }
    
    /*public void modStaff(Staff staff,String roleID) throws SQLException{
        String sql = "UPDATE  Staff SET  Name = ?,IC=?,status=?,PhoneNo=?,Gender=?,Salary=?,Role_ID=? WHERE Staff_ID = ?";
        try{
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, staff.getName());
            stmt.setString(2, staff.getIc());
            stmt.setString(3, staff.getStatus());
            stmt.setString(4, staff.getPhoneNo());
            stmt.setString(5, staff.getGender());
            stmt.setDouble(6, staff.getSalary());
            stmt.setString(7, roleID);
            stmt.setString(8, staff.getStaffID());
            int rows=stmt.executeUpdate();
            
        }catch(SQLException ex){
           throw ex;
        }
    }*/
}
