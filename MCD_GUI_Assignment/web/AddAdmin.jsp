

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Staff" %>
<%@page import="model.domain.Role"%>
<%@page import="model.da.RoleDA"%>
<%@page import="model.da.StaffDA"%>
<%
RoleDA roleDA=new RoleDA();
StaffDA staffDA=new StaffDA();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-Add Admin</title>
        <style>
            html{
                background-color: #fff7ed;
            }
            table{
                margin: auto;
            }
            table td{
                width:220px;
                height: 33px;
                padding-left: 20px;
            }
            table{
                padding: 10px;
                background-color: #ffedbd;
                border-radius: 25px;
                box-shadow: 5px 10px 18px #888888;
                overflow: hidden;
                border-collapse: collapse;
            }
            .title{
                text-align: center;
                padding: 12px 0px;
                background-color: #ffda75;
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
                background-color: #ffda75;
                border-radius: 20px;
                width: 300px;
                text-align: center;
            }
          
         input[type=button],input[type=submit]{
            text-decoration: none;
             color: black;
             padding: 8px;
             text-align: center;
             background-color: #ffbb00;
             border: none;
             border-radius: 10px;
             margin: 10px;
             font-size: 15px;
             font-family: sans-serif;
             font-weight: bold;
        }
        input[type=submit]:hover,input[type=button]:hover{
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
        <h1>Add New Staff</h1>
        <br/>
        <form action="addAdminServlet" method="post">
            <table>
                <tr style="">
                    <td colspan="2" class="title"><b>Staff Personal Information</b></td>
                    <%List<String> err=(List<String>)request.getAttribute("errM");
                if(err!=null){
                %>
                
                <td rowspan="15" style="background-color:#ffda75;border-radius: 15px;vertical-align: top; border: 20px solid transparent;border-collapse: separate;">
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
                <% String newID=staffDA.newStaffID();%>
                <td><b><%= newID%></b>
                    <input type="hidden" name="ID" value="<%= newID%>"/></td>
               
            </tr>
            <tr>
                <td>Name :</td>
                <td><input type="text" name="name" required/></td>
            </tr>
            <tr>
                <td>IC :</td>
                <td><input type="number" name="ic" required/></td>
            </tr>
            <tr>
                <td>Gender : </td>
                <td><input type="radio" id="male" name="gender" value="Male" checked>
            <label for="male" >Male</label>
            <input type="radio" id="female" name="gender" value="Female">
            <label for="male">Female</label></td>
            </tr>
            <tr>
                <td>Phone No. :</td>
                <td><input type="number" name="phone" required/></td>
            </tr>
            <tr>
                <td>Address</td>
                <td></td>
            </tr>
            <tr>
                <td>Street : </td>
                <td><input type="text" name="street" required/></td>
            </tr>
            <tr>
                <td><label for="State">State :</label></td>
                <td><select name="state" id="State">
              <option value="Johor">Johor</option>
              <option value="Kedah">Kedah</option>
              <option value="Kelantan">Kelantan</option>
              <option value="Melaka">Melaka</option>
              <option value="Negeri Sembilan">Negeri Sembilan</option>
              <option value="Pahang">Pahang</option>
              <option value="Penang">Penang</option>
              <option value="Perak">Perak</option>
              <option value="Perlis">Perlis</option>
              <option value="Sabah">Sabah</option>
              <option value="Sarawak">Sarawak</option>
              <option value="Selangor">Selangor</option>
              <option value="Terengganu">Terengganu</option>
            </select></td>
            </tr>
            
            <tr>
                <td>Postcode : </td>
                <td><input type="number" name="postcode" required/></td>
            </tr>
            <tr>
                <td colspan="2"  class="title"><b>Account Information</b></td>
            </tr>
            <tr>
                <td>Password :</td>
                <td><input type="password" name="password" required/></td>
            </tr>
            <tr>
                <td>Confirm Password : </td>
                <td><input type="password" name="conPass" required/></td>
            </tr>
            <tr>
                <td><label for="role">Role : </label></td>
                <td><select name="roles" id="role">
                        <% List<Role> roleList=roleDA.listRole();
                        for(Role r: roleList){%>
                        <option value="<%= r.getRoleID()%>"><%= r.getRoleName()%></option>
                        <%}%>
                        <!--<option value="Manager">Manager</option>
                        <option value="Assistant Manager">Assistant Manager</option>
                        <option value="Worker">Worker</option>-->
                      </select></td>
            </tr>
            <tr>
                <td>Salary (RM) : </td>
                <td><input type="number" step=0.01 name="salary" required/></td>
            </tr>
            <tr>
                <td style="color: red;padding-bottom: 15px;">*Note that Staff ID is automatically assigned</td>
                <td style="text-align: center;">
                    <input type="submit" value="Add" name="submit"/>
                    <form>
                        <input type="button" value="Back" onclick="history.back()">
                    </form>
                </td>
            </tr>
            </table>
        </form>
        <script type="text/javascript">
            function GoBackWithRefresh(event) {
                if ('referrer' in document) {
                    window.location = document.referrer;
                    /* OR */
                    //location.replace(document.referrer);
                } else {
                    window.history.back();
                }
            }
            <!--<a href="#" onclick="GoBackWithRefresh();return false;">BACK</a>`-->
        </script>
    </body>
</html>
