package controller;

import java.sql.SQLException;
import model.da.ProductCategoryDA;
import model.domain.ProductCategory;

public class ProductCategoryController{
    
    private ProductCategoryDA productCategoryDA;
    
    public ProductCategoryController() throws SQLException {
        productCategoryDA = new ProductCategoryDA();
    }
    
    public ProductCategoryController(String user, String password, String tableName) throws SQLException {
        productCategoryDA = new ProductCategoryDA(user,password,tableName);
    }

    public ProductCategory getProductCategoryByID(String  productCategoryID) throws SQLException {
        
        return productCategoryDA.getProductCategory(productCategoryID);
    }
    
    public int addProductCategory(ProductCategory productCategory) throws SQLException{
        
        return productCategoryDA.insertNewProductCategory(productCategory);
    }
    
    public int updateProductCategory(ProductCategory productCategory) throws SQLException{
        
        return productCategoryDA.updateProductCategory(productCategory);
    }
    
    public int deleteProductCategory(String productCategoryID) throws SQLException{
        
        return productCategoryDA.deleteProductCategory(productCategoryID);
    }
}