
<%@page import="model.da.RoleDA"%>
<%@page import="model.domain.Role"%>
<%@page import="model.domain.Address"%>
<%@page import="model.da.AddressDA"%>
<%@page import="model.domain.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-View Profile</title>
        <style>
            html{
                 background-color: #fff7ed;
            }
            .image img{
                width: 200px;
                height: 200px;
                border-radius: 50%;
                border:5px solid white;
                margin: auto;
            }
            .image{
                text-align: center;
                margin: 50px;
                width: 300px;
            }
            h1{
                padding: 20px 0px 30px;
                margin: auto;
                text-align: center;
            }
            table td{
                width:220px;
                height: 33px;
                padding-left: 20px;
                
            }
            td:nth-child(1){
                font-weight: bold;
            }
            table{
                margin: auto;
                padding: 10px;
                background-color: #ffe1bf;
                border-radius: 15px;
                box-shadow: 5px 10px 18px #888888;
                overflow: hidden;
                border-collapse: collapse;
            }
            .title{
                text-align: center;
                background-color: #ffba6b;
                border-radius: 10px;
                font-size: 18px;
                border: 20px solid transparent;
            }
            input[type=submit],input[type=button],button{
                color: black;
                font-weight: bold;
                background-color: #ff961f;
                border-radius: 5px;
                padding: 5px;
                border: none;
                margin-right: 20px;
                text-decoration: none;
                font-size: 15px;
                width: 50px;
            }
            input[type=submit]:hover,input[type=button]:hover,button:hover{
                color: white;
            }
            form{
                float: left;
            }
        </style>
    </head>
    <body>
         <%
       // Staff staff=request.getParameter("StaffObj");
        Staff staff=(Staff) request.getAttribute("StaffObj");
        %>
        <h1>Staff Profile</h1>
        <div class="overall">
            <table>
                <tr>
                 <td rowspan="14"><div class="image"><img src=<%= staff.getGender().equals("Male")?"image/man.png":"image/lady1.jpg" %> style=""/><h1><%= staff.getName()%></h1></div></td>
                 <td colspan="2" class="title"><b>Staff Personal Information</b></td>
            </tr>
            <tr>
                <td>Staff ID :</td>
                <td><%= staff.getStaffID()%></td>
            </tr>
            <tr>
                <td>Name :</td>
                <td><%= staff.getName()%></td>
            </tr>
            <tr>
                <td>IC :</td>
                <td><%= staff.getIc()%></td>
            </tr>
            <tr>
                <td>Gender : </td>
                <td><%= staff.getGender()%></td>
            </tr>
            <tr>
                <td>Phone No. :</td>
                <td><%= staff.getPhoneNo()%></td>
            </tr>
            <tr>
                <td>Address</td>
                <td></td>
            </tr>
            <% AddressDA addDA=new AddressDA(); 
                Address addr=addDA.getAddress(staff.getAddress().getAddressId());%>
            <tr>
                <td>Street : </td>
                <td><%= addr.getStreet()%></td>
            </tr>
            <tr>
                <td>State :</td>
                <td><%= addr.getState()%></td>
            </tr>
            
            <tr>
                <td>Postcode : </td>
                <td><%= addr.getPostcode()%></td>
            </tr>
            <tr>
                <td colspan="2"  class="title"><b>Account Information</b></td>
            </tr>
            <tr>
                <%
                    RoleDA RDA=new RoleDA();
                    Role role=RDA.getRole(staff.getRoleID().getRoleID());
                
                %>
                <td>Role :</td>
                <td><%= role.getRoleName()%></td>
            </tr>
            <tr>
                <td>Salary : </td>
                <td>RM <%= String.format("%.2f",staff.getSalary())%></td>
            </tr>
            <tr>
                <td style="color: red;padding-bottom: 15px;float: left;"></td>
                <td>
                    <form action="getAdminServlet"  method="post">
                        <input type="hidden" name="id" value="<%= staff.getStaffID()%>"/>
                        <input type="hidden" name="location" value="edit"/>
                        <input type="submit" name="name" value="Edit"/>
                     </form>
                        <button onclick="window.location.href='admin_list.jsp'">Back</button>
                    
                </td>
            </tr>
                </table>
        </div>
    </body>
</html>
