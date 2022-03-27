package model.domain;

import java.io.Serializable;

public class Role implements Serializable{

    private String roleID;
    private String roleName;
    
    public Role() {
    }

    public Role(String roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }
    
    //getter
    public String getRoleID() {
        return roleID;
    }

    public String getRoleName() {
        return roleName;
    }
    
    //setter
    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
}
