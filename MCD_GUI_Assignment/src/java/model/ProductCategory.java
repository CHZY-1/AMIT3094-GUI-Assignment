package model;

import java.io.Serializable;

public class ProductCategory implements Serializable  {
    private String CategoryID;
    private String CategoryName;
            
  public ProductCategory(){}
  
  public ProductCategory(String CategoryName) {
        this.CategoryName = CategoryName;
  }
  
  public ProductCategory(String CategoryID, String CategoryName){
      this.CategoryID = CategoryID;
      this.CategoryName = CategoryName;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory{" + "CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + '}';
    }
}