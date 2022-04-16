<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Payment"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>

<html>
    <head>
          <%@ include file="HTML_parts/AdminHeader.jsp" %>
        <title>Sales-List</title>
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
            <h1>Sales List</h1>
                <div class="all">
                </div>  
            <br/>
            <%

    String host = "jdbc:derby://localhost:1527/MCD";
    String user = "nbuser";
    String password = "nbuser";
    String tableName = "PAYMENT";

    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
     %>
                <table class="record">
                <tr style="background-color: #ffda75">
                    <th>Customer Name</th>
                    <th>Payment ID</th>
                    <th>Payment Method</th>
                    <th>Total_Payment_Amount</th>
                    <th>Order Status</th>
                    <th>Customer ID</th>
                    <th>CARD</th>
                </tr>
                
                  <%
try{ 
conn = DriverManager.getConnection(host, user, password);
System.out.println("***TRACE: Connection established.");
stmt = conn.createStatement();
String sql ="SELECT * FROM PAYMENT, CUSTOMER ";

resultSet = stmt.executeQuery(sql);
while(resultSet.next()){
%>
                    <tr>
                        <td><%=resultSet.getString("CUSTOMER_NAME") %></td>
                        <td><%=resultSet.getString("PAYMENT_ID") %></td>
                        <td><%=resultSet.getString("PAYMENT_METHOD") %></td>
                        <td><%=resultSet.getDouble("TOTAL_PAYMENT_AMOUNT")%></td>
                        <td><%=resultSet.getString("ORDER_STATUS")%></td>
                        <td><%=resultSet.getString("CUSTOMER_ID") %></td>
                        <td><%=resultSet.getString("CARD_NO") %></td>
                    </tr>
                    <% 
}
 stmt.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
    </body>
</html>
