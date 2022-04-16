<%@page import="model.da.StaffDA"%>
<%@page import="model.domain.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Customer" %>
<%@page import="model.domain.Role"%>
<%@page import="model.da.CustomerDA"%>
<%@page import="model.da.RoleDA"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%
    CustomerDA customerDA = new CustomerDA();
    RoleDA roleDA = new RoleDA();
%>
<!DOCTYPE html>
<html>
    <head>
         <%@ include file="HTML_parts/AdminHeader.jsp" %>
        <title>Customer List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            html{
                 background-color: #fff7ed;
            }
            h1{
                text-align: center;
                border-style: outset;
                font-family: Arial;
                border: 5px solid #ffbb00;
                width: 220px;
                margin: auto;
                justify-content: center;
                margin-top: 60px;
                background-color:#ffda75;
            }
            
            table.record{
                border:4px solid black;
                margin:auto;
                font-size:20px;
                overflow: hidden;
                border-spacing: 0;
            }
            
            table.record tr, table.record td, table.record th{
                border: 1pt solid black;
                width: 150px;
                padding:0px 10px;
                height: 40px;
            }
           
            table.record tr:nth-child(odd){
                background-color: #fafafa;
            }
            table.record tr:nth-child(even){
                background-color: #ffedbd;
            }
            .actionButton{
                width: 230px;
            }
            .actionButton input{
                background-color: transparent;
                border:1pt solid transparent;
                padding: 10px;
            }
            .actionButton form{
                float: left;
                margin-right: 10px;
            }
            .actionButton form input:hover{
                background-color: white;
                border-radius: 50%;
            }
            .all{
                margin: 50px 0px 30px 230px;
                width: 1100px;
            }
            .add{
                text-align: center;
                width: 130px;
                height: 25px;
                margin-right: 15px;
                text-decoration: none;
                background-color: #ffbb00;
                color: black;
                font-weight: bold;
                padding: 6px;
                border: 3px solid black;
                border-radius: 10px;
            }
            button{
                background-color: #ffbb00;
                border-radius: 5px;
            }

        </style>
    </head>
    
    <body>
            <h1>Customer List</h1>
            <div class="all">
                </div>  
            <br/>
            <%

    String host = "jdbc:derby://localhost:1527/MCD";
    String user = "nbuser";
    String password = "nbuser";
    String tableName = "CUSTOMER";

    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
     %>
            <table class="record">
                <tr style="background-color: #ffda75">
                    <th >Staff ID</th>
                    <th>Name</th>
                    <th>Email</th>
                  
                </tr>
                  <%
try{ 
conn = DriverManager.getConnection(host, user, password);
System.out.println("***TRACE: Connection established.");
stmt = conn.createStatement();
String sql ="SELECT * FROM CUSTOMER ";

resultSet = stmt.executeQuery(sql);
while(resultSet.next()){
%>    
                    <tr>
                        <td style ="text-align: center;width: 200px;"><%= resultSet.getString("CUSTOMER_ID") %></td>
                        <td style ="text-align: center;width: 300px;"><%= resultSet.getString("CUSTOMER_NAME")%></td>
                        <td style ="text-align: center;width: 200px;"><%= resultSet.getString("EMAIL")%></td>
                        
                    </tr>
                    <% 
}
 stmt.close();
} catch (Exception e) {
e.printStackTrace();
}
%>           
            </table>
    </body>
</html>