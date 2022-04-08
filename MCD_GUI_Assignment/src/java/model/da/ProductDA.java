package model.da;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import model.domain.Product;
import model.domain.ProductCategory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;

public final class ProductDA{
    private String host = "jdbc:derby://localhost:1527/MCD";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PRODUCT";
    private Connection conn;
    private PreparedStatement stmt;
    
    public ProductDA() throws SQLException{
        try{
            createConnection();
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    public ProductDA(String user, String password, String tableName) throws SQLException{
        this.user = user;
        this.password = password;
        this.tableName = tableName;
        
        try{
            createConnection();
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    
    
    public Product getProduct(String productID) throws SQLException {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PRODUCT_ID = ?";
        Product product = null;
        try {
            //bind query and parameter
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, productID);
            //execute query
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                Blob blob = rs.getBlob("PRODUCT_IMAGE");
                
                //retrieve image blob length
                int blobLength = (int) blob.length();
                
                //convert blob to bytes array
                byte[] imageBytes = blob.getBytes(1, blobLength);
                blob.free();
                
                product = new Product(productID,
                        rs.getString("PRODUCT_NAME"), 
                        imageBytes,
                        rs.getDouble("PRODUCT_PRICE"), 
                        rs.getInt("ORDER_QUANTITY"),
                        new ProductCategory(rs.getString("CATEGORY_ID")));
                }
            
        } catch (SQLException ex) {
            throw ex;
        }
        
        return product;
    }
    
    public ArrayList<Product> getAllProduct() throws SQLException {
        String queryStr = "SELECT * FROM " + tableName;
        Product product = null;
        ArrayList<Product> productList = new ArrayList<Product>();
        
        try {
            //bind query and parameter
            stmt = conn.prepareStatement(queryStr);
            //execute query
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
                Blob blob = rs.getBlob("PRODUCT_IMAGE");
                
                //retrieve image blob length
                int blobLength = (int) blob.length();
                
                //convert blob to bytes array
                byte[] imageBytes = blob.getBytes(1, blobLength);
                blob.free();
                
                product = new Product(rs.getString("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"), 
                        imageBytes,
                        rs.getDouble("PRODUCT_PRICE"), 
                        rs.getInt("ORDER_QUANTITY"),
                        new ProductCategory(rs.getString("CATEGORY_ID")));
                
               productList.add(product); 
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return productList;
    }

    
    public int insertNewProduct(Product product) throws SQLException{
        String sqlStr= "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?)";
        int affectedRows = 0;
        
        ByteArrayInputStream productImageBS= new ByteArrayInputStream(product.getProductImage());
        
        try{
            stmt = conn.prepareStatement(sqlStr);
            
            stmt.setString(1, product.getProductID());
            stmt.setString(2, product.getProductName());
            stmt.setBinaryStream(3, productImageBS);
            stmt.setDouble(4, product.getProductPrice());
            stmt.setInt(5, product.getOrderQuantity());
            stmt.setString(6, product.getProductCategory().getCategoryID());
            
            affectedRows = stmt.executeUpdate();
            
        }catch(SQLException ex){
            throw ex;
        }
        
        return affectedRows;
    }
    
    
    public int updateProduct(Product product) throws SQLException{
        
        String sqlStr = "UPDATE PRODUCT SET PRODUCT_ID=?, "
                + "PRODUCT_NAME=?, "
                + "PRODUCT_IMAGE=?, "
                + "PRODUCT_PRICE=?, "
                + "ORDER_QUANTITY=?, "
                + "CATEGORY_ID=? "
                + "WHERE PRODUCT_ID=?";
        
        int affectedRows= 0;
        
        ByteArrayInputStream productImageBS= new ByteArrayInputStream(product.getProductImage());
        
        try{
            stmt = conn.prepareStatement(sqlStr);
            
            stmt.setString(1, product.getProductID());
            stmt.setString(2, product.getProductName());
            stmt.setBinaryStream(3, productImageBS);
            stmt.setDouble(4, product.getProductPrice());
            stmt.setInt(5, product.getOrderQuantity());
            stmt.setString(6, product.getProductCategory().getCategoryID());
            stmt.setString(7, product.getProductID());
            
            affectedRows = stmt.executeUpdate();
            
        }catch(SQLException ex){
            throw ex;
        }
        
        return affectedRows;
    }
    
    public int deleteProduct(String productID) throws SQLException{
        String sqlStr= "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
        int affectedRows =0;
        
        try{
            stmt = conn.prepareStatement(sqlStr);
            
            stmt.setString(1, productID);
            
            affectedRows = stmt.executeUpdate();
            
            
        }catch(SQLException ex){
            throw ex;
        }
        
        return affectedRows;
    }
    
    //Print exception message
    public void printStackTrace(SQLException ex){
        StackTraceElement[] elements = ex.getStackTrace();
            for(StackTraceElement e: elements){
                System.out.println("File Name: " + e.getFileName());
                System.out.println("Class Name: " + e.getClassName());
                System.out.println("Method Name: " + e.getMethodName());
                System.out.println("Line Number: " + e.getLineNumber());
                System.out.println("");
            }   
    }
    
    public String blobToBase64Image(Blob blob) throws IOException, SQLException{
        
        InputStream inputStream = blob.getBinaryStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        byte[] imageBytes = outputStream.toByteArray();

        String base64Image = Base64.getEncoder().encodeToString(imageBytes);

        inputStream.close();
        outputStream.close();
        return base64Image;
    }
    
    
    //create connection object
    private void createConnection() throws SQLException{
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    //close connection object
    private void shutDown() throws SQLException{
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
}