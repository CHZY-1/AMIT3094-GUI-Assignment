<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Payment"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Payment</title>
                <style>
               div{
                height: 900px;
                border: 5px solid;
                display: flex;
                flex-direction: column;
                padding: 20px;
                position: relative;
                margin: 20px;
                border-radius: 10px;
                background-color: white;
                }
               body{
                background-color:#f2f2f2;
                }
               p{
                margin:20px 0px;
                }
              .border1{
                margin: auto;
                width: 500px;
                border: 5px solid #FFFFFF;
                padding: 10px 20px;
                height: 700px;
                }
                select{
                padding: 12px 0px;
                margin: -10px 0px;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 2px;
                box-sizing: border-box;
                }
              input[type=text]{
                padding: 12px 0px;
                margin: -10px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 2px;
                box-sizing: border-box;
                }
                div.selection{
                }
             h1{
                color: #f3ad12;
                margin:0;
                }
            .button {
                background-color: red;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                border:none;
                width:100%;
                }
             .button:hover{
                    background-color:white;
                    border-color:red;
                    border:2px;
                    color:red;
                }                
        </style> 
    </head>
    <body>
        <%

    String host = "jdbc:derby://localhost:1527/MCD";
    String user = "nbuser";
    String password = "nbuser";
    String tableName = "PAYMENT";

    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
     %>
                  <%
try{ 
conn = DriverManager.getConnection(host, user, password);
System.out.println("***TRACE: Connection established.");
stmt = conn.createStatement();
String sql ="SELECT * FROM PAYMENT";

resultSet = stmt.executeQuery(sql);
while(resultSet.next()){
%>   
        <div class="border1">
            <h1>Payment</h1>      
            <p>Payment Method</p>
            <form method="POST" action="Card.jsp">
                <select name="months" class="method" style="width:500px;">
                            <option value="card">Visa</option>
                            <option value="card">Master</option>
                </select>
                <p>Total Payment Amount:</p>
                <input type="text" readonly name="customeremail" value="<%=resultSet.getDouble("TOTAL_PAYMENT_AMOUNT") %>" style="width:500px;" />
                <p>Date and Time:</p>
                <input type="text" readonly name="customerpn"  value=" <%= (new java.util.Date()).toLocaleString()%>" style="width:500px;" />
                <p>Order ID:</p>
                <input type="text" readonly name="Street"  value=""style="width:500px;" />
                <p>Customer ID:</p>
                <input type="text" readonly name="State"  value="<%=resultSet.getString("CUSTOMER_ID") %>" style="width:500px;" />
                <br/>
                <br/>
                <input type="submit" name="submit" class="button" value="Proceed To Next" />
            </form>
        </div>
        <% 
}
 stmt.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
    </body>
</html>
