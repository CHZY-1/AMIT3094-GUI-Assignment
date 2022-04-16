// Author:Chan Zhi Yang
// Description:The product category class contains product category name and product category id. 
package model.domain;

import java.io.Serializable;

public class ProductCategory implements Serializable  {
   private String categoryID;
   private String categoryName;
            
  public ProductCategory(){
  }

    public ProductCategory(String categoryID) {
        this.categoryID = categoryID;
    }
  
  public ProductCategory(String CategoryID, String CategoryName){
      this.categoryID = CategoryID;
      this.categoryName = CategoryName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.categoryID = CategoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.categoryName = CategoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory{" + "CategoryID=" + categoryID + ", CategoryName=" + categoryName + '}';
    }
}