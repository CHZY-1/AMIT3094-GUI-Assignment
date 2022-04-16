
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
            input[type=submit],input[type=button],button,a{
                font-weight: bold;
                font-size: 15px;
                border: none;
                border-radius: 10px;
                padding: 8px;
                background-color: #ff961f; 
                margin-right: 15px;
                color: black;
            }
            input[type=submit]:hover,input[type=button]:hover,button:hover,a:hover{
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
        <h1>Edit My Profile</h1>
        <br/>
        <%
        Staff staff=(Staff) request.getAttribute("StaffObj");
        %>
        
        <form action="editAdminSelf" method="post">
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
                <td>Password :</td>
                <td><input type="password" name="password" required value="<%= staff.getPassword()%>"/></td>
            </tr>
            <tr>
                <td>Confirm Password : </td>
                <td><input type="password" name="conPass" required value="<%= staff.getPassword()%>"/></td>
            </tr>
            <tr>
                <td style="color: red;padding-bottom: 15px;">*Note that Staff ID cannot be changed.</td>
                <td style="text-align: center;"><input type="submit" name="submit" value="Edit"/>
                    <!---to be edit later-->
                    <a href="getAdminServlet?ID=SF-001&location=viewSelf" style="text-decoration: none;font: Arial;font-size: 16px;">Back</a>
    
                </td>
            </tr>
            </table>
        </form>
    </body>
</html>
