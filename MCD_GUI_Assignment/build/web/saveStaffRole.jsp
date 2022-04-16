
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Role"%>
<jsp:useBean id="role" class="model.domain.Role" scope="session"/>
<jsp:setProperty name="role" property="*"/>
<jsp:useBean id="roleDA" class="model.da.RoleDA" scope="application"/>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save Staff Role</title>
        <style>
            html{
             background-color: #fff7ed;
            text-align: center;
        }
            input[type=submit]:hover,button:hover{
            color: white;
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
             font-size: 15px;
             font-family: sans-serif;
             margin-left: 130px;
        }
         div{
            border: 5px solid #ffbb00;
            border-radius: 10px;
            background-color: #ffedbd;
            text-align: left;
            padding: 15px;
            width: 300px;
            margin: auto;
        }
        </style>
    </head>
    <body>
        <%
                String[] permission = request.getParameterValues("permission");
	for(String p : permission) {
                        if(p.equals("order"))
                            role.setOrders("True");
                        if(p.equals("customer"))
                            role.setCustomer("True");
                        if(p.equals("admin"))
                            role.setAdmin("True");
                        if(p.equals("menu"))
                            role.setMenu("True");
                        if(p.equals("sale"))
                            role.setSale("True");
                        
	}
                if(role.getOrders()!="True"){
                    role.setOrders("False");
                }
                if(role.getAdmin()!="True"){
                    role.setAdmin("False");
                }
                if(role.getMenu()!="True"){
                    role.setMenu("False");
                }
                if(role.getSale()!="True"){
                    role.setSale("False");
                }
                if(role.getCustomer()!="True"){
                    role.setCustomer("False");
                }
                
        int success=roleDA.addRole(role);
        request.getSession().removeAttribute("role");
        %>
        <br/><br/>
        <div>
        <% if(success==1){%>
        <b>The new role called <%= role.getRoleName()%> has been added successfully.</b>
        <%}else{%>
        <b style="color: red;">An error occur while adding the new role.Try again later!</b>
        <%}%>
        <br/><br/>
        <button onclick="return closeWindow();">Close</button>
         
        <script type="text/javascript">
        function closeWindow() {
            let new_window =open(location, '_self');
            new_window.close();
            return false;
        }
    </script>
        </div>
        
    </body>
</html>
