

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Role" %>
<jsp:useBean id="role" class="model.domain.Role" scope="session"/>
<jsp:useBean id="roleDA" class="model.da.RoleDA" scope="application"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-Add Role</title>
    </head>
    <style>
        html{
             background-color: #fff7ed;
            text-align: center;
        }
        form{
            border: 5px solid #ffbb00;
            border-radius: 10px;
            background-color: #ffedbd;
            text-align: left;
            padding: 15px;
            width: 300px;
            margin: auto;
        }
        input[type=submit],button{
             color: black;
             font-weight: bold;
             padding: 5px;
             text-align: center;
             background-color: #ffbb00;
             border-radius: 5px;
             border: none;
             margin: 10px;
             font-size: 20px;
             font-family: sans-serif;
        }
        td:nth-child(1){
            width: 80px;
        }
        input[type=submit]:hover,button:hover{
            color: white;
        }
    </style>
    <body>
        <br/>
        <h1>Admin Add Now Role</h1>
        <% String newID=roleDA.newRoleID(); %>
        <form method="post" action="saveStaffRole.jsp">
            <!--will take value from database and assign id to it-->
            <input type="hidden" name="roleID" value="<%= newID%>"/>
            <b>Role Name:  <b/><input type="text" name="roleName"/><br/><br/>
            <b>Permission:</b><br/>
            <table>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="permission" id="orders" value="order">
            <label for="orders">Order Module</label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="permission" id="customer" value="customer">
            <label for="customer">Customer Module</label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="permission" id="menu" value="menu">
            <label for="menu">Menu Module</label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="permission" id="sale" value="sale">
            <label for="sale">Sale Module</label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="permission" id="admin" value="admin">
            <label for="admin">Admin Module</label></td>
                </tr>
            </table>
            <input type="submit" name="submit" value="Add" style="margin-left: 110px;"/>
            <button onclick="return closeWindow();">Back</button>
            </form>
        
        <script type="text/javascript">
        function closeWindow() {
            let new_window =open(location, '_self');
            new_window.close();
            return false;
        }
    </script>
    </body>
</html>
