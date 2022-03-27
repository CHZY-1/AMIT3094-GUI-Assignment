package model;

import java.io.Serializable;

public class Product implements Serializable {
 
    private String productID;
    private String productName;
    private String productDescription;
    private Byte[] productImage;
    private double productPrice;
    private int orderQuantity;
    private ProductCategory productCategory;

    public Product(){}

    public Product(String productID, String productName, String productDescription, Byte[] productImage, double productPrice, int orderQuantity, ProductCategory productCategory) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.orderQuantity = orderQuantity;
        this.productCategory = productCategory;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Byte[] getProductImage() {
        return productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
    
    

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductImage(Byte[] productImage) {
        this.productImage = productImage;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    
    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", "
                + "productName=" + productName + ", "
                + "productDescription=" + productDescription + ", "
                + "productImage=" + productImage + ", "
                + "productPrice=" + productPrice + ", "
                + "orderQuantity=" + orderQuantity + ", "
                + "productCategory=" + productCategory + '}';
    }
    
    
}
