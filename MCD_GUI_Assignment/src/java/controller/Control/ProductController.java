// Author:Chan Zhi Yang
// Description:A java class that is part of the MVC pattern. This class is a controller class for the ProductDA class and Product class. 
package controller.Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.da.ProductDA;
import model.domain.Product;

public class ProductController {

    private ProductDA productDA;

    public ProductController() throws SQLException {
        productDA = new ProductDA();
    }

    public ProductController(String user, String password, String tableName) throws SQLException {
        productDA = new ProductDA(user, password, tableName);
    }

    public Product getProductByID(String productID) throws SQLException {
        return productDA.getProduct(productID);
    }

    public ArrayList<Product> getAllProduct() throws SQLException {
        return productDA.getAllProduct();
    }

    public int insertProduct(Product product) throws SQLException, IOException {
        return productDA.insertNewProduct(product);
    }

    public int updateProduct(Product product) throws SQLException, IOException {
        return productDA.updateProduct(product);
    }

    public int deleteProduct(String productID) throws SQLException {
        return productDA.deleteProduct(productID);
    }

}