
package model.da;
import model.domain.Role;
import java.sql.*;
import java.util.ArrayList;

public class RoleDA {
    private String host = "jdbc:derby://localhost:1527/MCD";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Staff_Role";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public RoleDA() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
            // stmt = conn.prepareStatement(sqlQueryStr);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    public int addRole(Role role){
        String sqlStr="INSERT INTO "+tableName+" VALUES(?,?,?,?,?,?,?)";
        int rows=0;
        try{
            stmt=conn.prepareStatement(sqlStr);
            //update the value for each ?
            stmt.setString(1, role.getRoleID());
            stmt.setString(2, role.getRoleName());
            stmt.setString(3, role.getOrders());
            stmt.setString(4, role.getCustomer());
            stmt.setString(5, role.getMenu());
            stmt.setString(6, role.getSale());
            stmt.setString(7, role.getAdmin());
            rows=stmt.executeUpdate();
            stmt.close();
        }catch(SQLException ex){
            ex.getMessage();
        }
        return rows;
    }   
    public Role getRole(String roleID){
        Role role=null;
        String sqlQuery="SELECT * FROM Staff_Role WHERE Role_ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, roleID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                role=new Role(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7));
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return role;
    }
    
    public ArrayList<Role> listRole(){
        ArrayList<Role> role=new ArrayList<Role>();
        String sqlQuery="SELECT * FROM Staff_Role";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                role.add(new Role(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return role;
    }
    
    public String newRoleID(){
        String roleID=null;
         String sqlQuery="SELECT * FROM "+tableName+"";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                roleID=rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        roleID=newID(roleID);
        return roleID;
    }
    public String newID(String roleID){
        
       String[] id = roleID.split("-");
       int no=Integer.parseInt(id[1]);
        no++;
        String seq = String.format("%03d", no);
        String RID=id[0]+"-"+seq;
        return RID;
    }
    
    public void delRole(String roleID){
        String sql = "DELETE FROM "+tableName+" WHERE Role_ID = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, roleID);
            int rows=stmt.executeUpdate();
            
        }catch(SQLException ex){
           ex.getMessage();
        }
    } 
    public void modRole(Role role){
        String sql = "UPDATE  "+tableName+" SET  Role_Name = ? WHERE Role_ID = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, role.getRoleName());
            stmt.setString(2, role.getRoleID());
            int rows=stmt.executeUpdate();
            
        }catch(SQLException ex){
           ex.getMessage();
        }
    }
    
    
}
