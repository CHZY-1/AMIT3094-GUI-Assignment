

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Role"%>
<%@page import="model.domain.Staff"%>
<%@page import="model.da.RoleDA"%>
<%
RoleDA roleDA=new RoleDA();
Staff staff=(Staff) request.getAttribute("StaffObj"); 
Role role=roleDA.getRole(staff.getRoleID().getRoleID());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-Delete Admin</title>
        <style>
            html{
                 background-color: #fff7ed;
            }
            h1,h3{
                text-align: center;
            }
            table{
                margin: auto;
                border: 5px solid #ffa83b;
                border-radius: 15px;
                overflow: hidden;
                background-color: #ffd39c;
            }
            td{
                border-collapse: collapse;
                width:200px;
                padding: 10px;
                height: 20px;
            }
            td:nth-child(2){
                width: 10px;
            }
            td:nth-child(1){
                font-weight: bold;
            }
           input[type=submit],button{
             color: black;
             padding: 8px;
             text-align: center;
             background-color: #ff8e00;
             border-radius: 5px;
             border: none;
             margin: 10px;
             font-size: 14px;
             font-family: sans-serif;
             font-weight: bold;
        }
        input[type=submit]:hover,button:hover{
            color: white;
        }
        </style>
    </head>
    <body>
        <h1>Delete Staff</h1>
        <h3>Are you sure you want to delete the following Staff Account?</h3>
        <table>
            <tr>
                <td>Staff ID</td>
                <td>:</td>
                <td><%= staff.getStaffID()%></td>
            </tr>
            <tr>
                <td>Name</td>
                <td>:</td>
                <td><%= staff.getName()%></td>
            </tr>
            <tr>
                <td>IC</td>
                <td>:</td>
                <td><%= staff.getIc()%></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>:</td>
                <td><%= staff.getGender()%></td>
            </tr>
            <tr>
                <td>Phone No.</td>
                <td>:</td>
                <td><%= staff.getPhoneNo()%></td>
            </tr>
            <tr>
                <td>Role</td>
                <td>:</td>
                <td><%= role.getRoleName()%></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td>:</td>
                <td>RM <%= String.format("%.2f",staff.getSalary())%></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>
                    <form method="post" action="delAdminServlet" style="float: left;">
                    <input type="hidden" name="id" value="<%= staff.getStaffID()%>"/>
                    <input type="submit" name="submit" value="Delete"/>
                    </form>
                    <button onclick="window.location.href='admin_list.jsp'">Back</button>
                    
                </td>
            </tr>
        </table>
        
          <script type="text/javascript">
        function closeWindow() {
            let new_window =open(location, '_self');
            new_window.close();
            return false;
        }
    </script>
    </body>
</html>
