// Author:Lim Sheng Yang
// Description:This is the domain class for staff roles which consist of the information of the role such as name of the role and the permission for this role to enter a specific module. 
package model.domain;

import java.io.Serializable;

public class Role implements Serializable{

    private String roleID;
    private String roleName;
    private String orders;
    private String customer;
    private String menu;
    private String sale;
    private String admin;
                                    
    
    public Role() {
    }
    
    public Role(String roleID) {
        this.roleID = roleID;
    }
    
    public Role(String roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public Role(String roleID, String roleName, String orders, String customer, String menu, String sale, String admin) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.orders = orders;
        this.customer = customer;
        this.menu = menu;
        this.sale = sale;
        this.admin = admin;
    }
    
    
    
    //getter
    public String getRoleID() {
        return roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getOrders() {
        return orders;
    }

    public String getCustomer() {
        return customer;
    }

    public String getMenu() {
        return menu;
    }

    public String getSale() {
        return sale;
    }

    public String getAdmin() {
        return admin;
    }
    
    //setter
    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
    
}
