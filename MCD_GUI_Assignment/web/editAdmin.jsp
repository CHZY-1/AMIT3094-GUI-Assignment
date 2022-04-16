
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Role"%>
<%@page import="model.domain.Address"%>
<%@page import="model.domain.Staff"%>
<%@page import="model.da.AddressDA"%>
<%@page import="model.da.RoleDA"%>
<%
RoleDA roleDA=new RoleDA();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-Edit Admin</title>
        <style>
            html{
                background-color: #fff7ed;
            }
            table td{
                width:220px;
                height: 33px;
                padding-left: 20px;
            }
            table{
                margin: auto;
                padding: 10px;
                background-color: #ffe1bf;
                border-radius: 25px;
                box-shadow: 5px 10px 18px #888888;
                overflow: hidden;
                border-collapse: collapse;
            }
            .title{
                text-align: center;
                padding: 12px 0px;
                background-color: #ffba6b;
                border-radius: 20px;
                font-size: 18px;
            }
            input{
                border-radius: 5px;
                border:1px solid black;
            }
            h1{
                margin: auto;
                justify-content: center;
                background-color: #ffba6b;
                border-radius: 20px;
                width: 300px;
                text-align: center;
            }
            input[type=submit],input[type=button],button{
                font-weight: bold;
                font-size: 15px;
                border: none;
                border-radius: 10px;
                padding: 8px;
                background-color: #ff961f; 
                margin-right: 15px;
            }
            input[type=submit]:hover,input[type=button]:hover,button:hover{
                color: white;
            }
            input::-webkit-outer-spin-button,
            input::-webkit-inner-spin-button {
              -webkit-appearance: none;
              margin: 0;
            }
        </style>
    </head>
    <body>
        <br/><br/>
        <h1>Edit Staff</h1>
        <br/>
        <%
        Staff staff=(Staff) request.getAttribute("StaffObj");
        %>
        
        <form action="editAdminServlet" method="post">
            <table>
                <tr style="">
                    <td colspan="2" class="title"><b>Staff Personal Information</b></td>
                    <%List<String> err=(List<String>)request.getAttribute("errM");
                if(err!=null){
                %>
                
                <td rowspan="14" style="background-color:#fff4e8;border-radius: 15px;vertical-align: top; border: 20px solid transparent;border-collapse: separate;">
                    <b style="font-size: 30px;text-align: center;">Error!</b><br/><br/>
                    <ul>
                        <%for(String e: err){%>
                    <li><%=e%></li>
                    <%}%>
                    </ul>
                    
                </td>
                <%} request.getSession().removeAttribute("errM");%>
                </tr>
            <tr>
                <td>Staff ID :</td>
                <td><%= staff.getStaffID()%>
                    <input type="hidden" name="ID" value="<%= staff.getStaffID()%>"/></td>
                 
            </tr>
            <tr>
                <td>Name :</td>
                <td><input type="text" name="name" value="<%= staff.getName()%>" required/></td>
            </tr>
            <tr>
                <td>IC :</td>
                <td><input type="number" name="ic" value="<%= staff.getIc()%>"required/></td>
            </tr>
            <tr>
                <td>Gender : </td>
                <td><input type="radio" id="male" name="gender" value="Male" <%= staff.getGender().equals("Male")?"checked":"" %>/>
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="Female" <%= staff.getGender().equals("Female")?"checked":"" %>/>
            <label for="male">Female</label></td>
            </tr>
            <tr>
                <td>Phone No. :</td>
                <td><input type="number" name="phone" value="<%= staff.getPhoneNo()%>" required/></td>
            </tr>
            <% AddressDA addDA=new AddressDA(); 
                Address addr=addDA.getAddress(staff.getAddress().getAddressId());%>
                
            <tr>
                <td colspan="2" style="text-align: center;"><b>Address</b></td>
            </tr>
            <tr>
                <td>Street : </td>
                <td><input type="hidden" name="addID" value="<%= staff.getAddress().getAddressId()%>"/>
                    <input type="text" name="street" value="<%= addr.getStreet()%>" required/></td>
            </tr>
            <tr>
                <td><label for="State">State :</label></td>
                <td><select name="state" id="State">
              <option value="Johor" <%= addr.getState().equals("Johor")?"selected":"" %>>Johor</option>
              <option value="Kedah" <%= addr.getState().equals("Kedah")?"selected":"" %>>Kedah</option>
              <option value="Kelantan" <%= addr.getState().equals("Kelantan")?"selected":"" %>>Kelantan</option>
              <option value="Melaka" <%= addr.getState().equals("Melaka")?"selected":"" %>>Melaka</option>
              <option value="Negeri Sembilan" <%= addr.getState().equals("Negeri Sembilan")?"selected":"" %>>Negeri Sembilan</option>
              <option value="Pahang" <%= addr.getState().equals("Pahang")?"selected":"" %>>Pahang</option>
              <option value="Penang" <%= addr.getState().equals("Penang")?"selected":"" %>>Penang</option>
              <option value="Perak" <%= addr.getState().equals("Perak")?"selected":"" %>>Perak</option>
              <option value="Perlis" <%= addr.getState().equals("Perlis")?"selected":"" %>>Perlis</option>
              <option value="Sabah" <%= addr.getState().equals("Sabah")?"selected":"" %>>Sabah</option>
              <option value="Sarawak" <%= addr.getState().equals("Sarawak")?"selected":"" %>>Sarawak</option>
              <option value="Selangor" <%= addr.getState().equals("Selangor")?"selected":"" %>>Selangor</option>
              <option value="Terengganu" <%= addr.getState().equals("Terengganu")?"selected":"" %>>Terengganu</option>
            </select></td>
            </tr>
            
            <tr>
                <td>Postcode : </td>
                <td><input type="number" name="postcode" value="<%= addr.getPostcode()%>" required/></td>
            </tr>
            <tr>
                <td colspan="2"  class="title"><b>Account Information</b></td>
            </tr>
            <tr>
                <td><label for="role">Role : </label></td>
                <td><select name="roles" id="role">
                        <% List<Role> roleList=roleList=roleDA.listRole();
                        for(Role r: roleList){%>
                        <option value="<%= r.getRoleID()%>" <%= staff.getRoleID().getRoleID().equals(r.getRoleID())?"selected":"" %>><%= r.getRoleName()%></option>
                        <%}%>
                        <!--<option value="Manager">Manager</option>
                        <option value="Assistant Manager">Assistant Manager</option>
                        <option value="Worker">Worker</option>-->
                      </select></td>
            </tr>
             <tr>
                <td><label for="status">Status :</label></td>
                <td><select name="status" id="status">
              <option value="Active" <%= staff.getStatus().equals("Active")?"selected":"" %>>Active</option>
              <option value="Inactive" <%= staff.getStatus().equals("Inactive")?"selected":"" %>>Inactive</option>
            </select></td>
            </tr>
            <tr>
                <td>Salary (RM) : </td>
                <td><input type="number" step=0.01 name="salary" value="<%= String.format("%.2f",staff.getSalary())%>" required/></td>
            </tr>
            <tr>
                <td style="color: red;padding-bottom: 15px;">*Note that Staff ID and Password cannot be changed.</td>
                <td style="text-align: center;"><input type="submit" name="submit" value="Edit"/>
                
                    <button onclick="window.location.href='admin_list.jsp'" >Back</button>
             
                </td>
            </tr>
            </table>
        </form>
        
        <!---<form action="" method="post">
            <table>
                <tr style="">
                    <td colspan="2" class="title"><b>Staff Personal Information</b></td>
            </tr>
            <tr>
                <td>Staff ID :</td>
                <td>A001</td>
            </tr>
            <tr>
                <td>Name :</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>IC :</td>
                <td><input type="text" name="ic"/></td>
            </tr>
            <tr>
                <td>Gender : </td>
                <td><input type="radio" id="male" name="gender" value="Male">
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="Female">
            <label for="male">Female</label></td>
            </tr>
            <tr>
                <td>Phone No. :</td>
                <td><input type="text" name="phone"/></td>
            </tr>
            <tr>
                <td>Address</td>
                <td></td>
            </tr>
            <tr>
                <td>Street : </td>
                <td><input type="text" name="street"/></td>
            </tr>
            <tr>
                <td>State :</td>
                <td><input list="state" name="State">
            <datalist id="state">
              <option value="Johor">
              <option value="Kedah">
              <option value="Kelantan">
              <option value="Melaka">
              <option value="Negeri Sembilan">
              <option value="Pahang">
              <option value="Penang">
              <option value="Perak">
              <option value="Perlis">
              <option value="Sabah">
              <option value="Sarawak">
              <option value="Selangor">
              <option value="Terengganu">
            </datalist></td>
            </tr>
            
            <tr>
                <td>Postcode : </td>
                <td><input type="text" name="postcode"/></td>
            </tr>
            <tr>
                <td colspan="2"  class="title"><b>Account Information</b></td>
            </tr>
            <tr>
                <td><label for="role">Role : </label></td>
                <td><select name="roles" id="role">
                        <option value="Manager">Manager</option>
                        <option value="Assistant Manager">Assistant Manager</option>
                        <option value="Worker">Worker</option>
                      </select></td>
            </tr>
            <tr>
                <td>Salary (RM) : </td>
                <td><input type="text" name="salary"/></td>
            </tr>
            <tr>
                <td style="color: red;padding-bottom: 15px;">*Note that Staff ID and Password cannot be changed.</td>
                <td style="text-align: center;"><input type="submit" name="submit" value="Edit"/>
                <form>
                 <input type="button" value="Back" onclick="history.back();" >
             </form>
                </td>
            </tr>
            </table>
        </form>--->
    </body>
</html>
