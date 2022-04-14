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
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ProductDA {

    private String host = "jdbc:derby://localhost:1527/MCD";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PRODUCT";
    private Connection conn;
    private PreparedStatement stmt;

    public ProductDA() throws SQLException {
        try {
            createConnection();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public ProductDA(String user, String password, String tableName) throws SQLException {
        this.user = user;
        this.password = password;
        this.tableName = tableName;

        try {
            createConnection();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public Product getProduct(String productID) throws SQLException, NullPointerException{
        String queryStr = "SELECT * FROM " + tableName + " WHERE PRODUCT_ID = ?";
        Product product = null;
        byte[] imageBytes = new byte[0];

        try {
            //bind query and parameter
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, productID);
            try ( //execute query
                    ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Blob blob = rs.getBlob("PRODUCT_IMAGE");
                    
                    if(blob != null){
                        //retrieve image blob length
                        int blobLength = (int) blob.length();

                        //convert blob to bytes array
                        imageBytes = blob.getBytes(1, blobLength);
                        blob.free();
                    }

                    product = new Product(productID,
                            rs.getString("PRODUCT_NAME"),
                            imageBytes,
                            rs.getDouble("PRODUCT_PRICE"),
                            rs.getBoolean("HIDDEN"),
                            new ProductCategory(rs.getString("CATEGORY_ID")));
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return product;
    }

    public ArrayList<Product> getAllProduct() throws SQLException, NullPointerException{
        String queryStr = "SELECT * FROM " + tableName + 
                " INNER JOIN PRODUCT_CATEGORY "
                + "ON PRODUCT.CATEGORY_ID = PRODUCT_CATEGORY.CATEGORY_ID "
                + "ORDER BY CATEGORY_NAME";
        Product product = new Product();
        ArrayList<Product> productList = new ArrayList<Product>();

        try {
            //bind query and parameter
            stmt = conn.prepareStatement(queryStr);
            //execute query
            ResultSet rs = stmt.executeQuery();
            byte[] imageBytes = new byte[0];

            while (rs.next()) {
//                System.out.println("Record Found");
//                System.out.println(rs.getString("PRODUCT_ID"));
                
                //Note: Product Image cannot be Null else will throw null pointer exception
                Blob blob = rs.getBlob("PRODUCT_IMAGE");

                if(blob != null){
                        //retrieve image blob length
                        int blobLength = (int) blob.length();

                        //convert blob to bytes array
                        imageBytes = blob.getBytes(1, blobLength);
                        blob.free();
                    }
                
                product = new Product(rs.getString("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        imageBytes,
                        rs.getDouble("PRODUCT_PRICE"),
                        rs.getBoolean("HIDDEN"),
                        new ProductCategory(rs.getString("CATEGORY_ID"),rs.getString("CATEGORY_NAME")));

                productList.add(product);

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return productList;
    }

    public ArrayList<Product> getAllProductByCategory(String category) throws SQLException, NullPointerException{
        String queryStr = "SELECT * FROM " + tableName + 
                " INNER JOIN PRODUCT_CATEGORY "
                + "ON PRODUCT.CATEGORY_ID = PRODUCT_CATEGORY.CATEGORY_ID "
                + "WHERE PRODUCT.CATEGORY_ID=? ORDER BY CATEGORY_NAME";
        Product product = new Product();
        ArrayList<Product> productList = new ArrayList<Product>();

        try {
            //bind query and parameter
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, category);
            //execute query
            ResultSet rs = stmt.executeQuery();
            byte[] imageBytes = new byte[0];

            while (rs.next()) {
//                System.out.println("Record Found");
//                System.out.println(rs.getString("PRODUCT_ID"));
                
                //Note: Product Image cannot be Null else will throw null pointer exception
                Blob blob = rs.getBlob("PRODUCT_IMAGE");

                if(blob != null){
                        //retrieve image blob length
                        int blobLength = (int) blob.length();

                        //convert blob to bytes array
                        imageBytes = blob.getBytes(1, blobLength);
                        blob.free();
                    }
                
                product = new Product(rs.getString("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        imageBytes,
                        rs.getDouble("PRODUCT_PRICE"),
                        rs.getBoolean("HIDDEN"),
                        new ProductCategory(rs.getString("CATEGORY_ID"),rs.getString("CATEGORY_NAME")));

                productList.add(product);

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return productList;
    }
    
    public int insertNewProduct(Product product) throws SQLException, IOException {
        String sqlStr = "INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) VALUES(?,?,?,?,?,?)";
        int affectedRows = 0;

        ByteArrayInputStream productImageBS = new ByteArrayInputStream(product.getProductImage());

//        Blob image = new SerialBlob(product.getProductImage());
        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, product.getProductID());
            stmt.setString(2, product.getProductName());
            stmt.setBinaryStream(3, productImageBS, productImageBS.available());
//            stmt.setBlob(3, image);
            stmt.setDouble(4, product.getProductPrice());
            stmt.setBoolean(5, product.isHidden());
            stmt.setString(6, product.getProductCategory().getCategoryID());

            affectedRows = stmt.executeUpdate();

            productImageBS.close();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return affectedRows;
    }
    
    public String newProductID(){
        String ProductID=null;
        String sqlQuery="SELECT PRODUCT_ID FROM PRODUCT";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductID=rs.getString(1);
            }
            stmt.close();
        }catch (SQLException ex) {
            ex.getMessage();
        }
        
        ProductID=newID(ProductID);
        return ProductID;
    }
    public String newID(String ProductID){
       String[] id = ProductID.split("-");
       int no=Integer.parseInt(id[1]);
        no++;
        //(int)id[1]=Integer.parseInt(id[1])+1;
        String seq = String.format("%03d", no);
        String PID=id[0]+"-"+seq;
        return PID;
    }

    public int updateProduct(Product product) throws SQLException, IOException {

        String sqlStr = "UPDATE PRODUCT SET PRODUCT_ID=?, "
                + "PRODUCT_NAME=?, "
                + "PRODUCT_IMAGE=?, "
                + "PRODUCT_PRICE=?, "
                + "HIDDEN=?, "
                + "CATEGORY_ID=? "
                + "WHERE PRODUCT_ID=?";

        int affectedRows = 0;

        ByteArrayInputStream productImageBS = new ByteArrayInputStream(product.getProductImage());

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, product.getProductID());
            stmt.setString(2, product.getProductName());
            stmt.setBinaryStream(3, productImageBS, productImageBS.available());
            stmt.setDouble(4, product.getProductPrice());
            stmt.setBoolean(5, product.isHidden());
            stmt.setString(6, product.getProductCategory().getCategoryID());
            stmt.setString(7, product.getProductID());

            affectedRows = stmt.executeUpdate();

            productImageBS.close();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return affectedRows;
    }
    
    public int updateProductWithoutImage(Product product) throws SQLException, IOException {

        String sqlStr = "UPDATE PRODUCT SET PRODUCT_NAME=?, "
                + "PRODUCT_PRICE=?, "
                + "CATEGORY_ID=? "
                + "WHERE PRODUCT_ID=?";

        int affectedRows = 0;

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, product.getProductName());
            stmt.setDouble(2, product.getProductPrice());
            stmt.setString(3, product.getProductCategory().getCategoryID());
            stmt.setString(4, product.getProductID());

            affectedRows = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return affectedRows;
    }

    public int deleteProduct(String productID) throws SQLException {
        String sqlStr = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
        int affectedRows = 0;

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, productID);

            affectedRows = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return affectedRows;
    }
    public int hideProduct(String productID) throws SQLException {
        String sqlStr = "UPDATE PRODUCT SET HIDDEN=TRUE WHERE PRODUCT_ID = ?";
        int affectedRows = 0;

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, productID);

            affectedRows = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return affectedRows;
    }

    //Print exception message
    public void printStackTrace(SQLException ex) {
        StackTraceElement[] elements = ex.getStackTrace();
        for (StackTraceElement e : elements) {
            System.out.println("File Name: " + e.getFileName());
            System.out.println("Class Name: " + e.getClassName());
            System.out.println("Method Name: " + e.getMethodName());
            System.out.println("Line Number: " + e.getLineNumber());
            System.out.println("");
        }
    }

    public String blobToBase64Image(Blob blob) throws IOException, SQLException {

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
    private void createConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            throw ex;
        }
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
    
    public static void main(String[] args){
        try {
            ProductDA productDA = new ProductDA();
            ArrayList<Product> productList = productDA.getAllProduct();
            
            productList.forEach((product) -> {
                System.out.println(product.toString());
            });
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}