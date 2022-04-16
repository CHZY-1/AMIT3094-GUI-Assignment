<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>

<html>
    <head>
          <%@ include file="HTML_parts/AdminHeader.jsp" %>
        <title>Type Of Report</title>
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
                border: 5px solid black;
                width: 300px;
                margin: auto;
                justify-content: center;
                margin-top: 60px;
                background-color: #ffda75;
            }
            
            form{
                text-align: center;
                border-style: outset;
                border:5px solid black;
                margin:auto;
                font-size:15px;
                overflow: hidden;
                border-spacing: 0;
                width: 500px;
                padding:0px 10px;
                height: 250px;
                background-color: bisque;
            }
            
            select{
                text-align: center;
                border-style: outset;
                border:5px solid black;
                margin:auto;
                font-size:15px;
                overflow: hidden;
                border-spacing: 0;
                padding:0px 10px;
                background-color: bisque;
            }

            .all{
                margin: 50px 0px 30px 230px;
                width: 1100px;
            }
        </style>
    </head>
    
    <body>
            <h1>Type Of Report</h1>
                <div class="all">
                </div>  
            <br/>
            
    <form name="redirect">
        <div class="all"></div>
        <select name="selection">
            <option value="">-----Type of Report-----</option>
            <option value="topsales.jsp">Top Sales Product Report</option>
            <option value="annualreport.jsp">Annual Sales Report</option>
            <option value="staffquantity.jsp">Staff Quantity Report</option>
        </select>
        <br>
        <input type=submit value="Run" onClick="WinOpen();"> 
        </br>
    </form>
               
    <script language="javascript">
    function WinOpen() 
    {
        document.redirect.action = document.redirect.selection.value;
        document.redirect.submit();
    }
    </script>
    </body>
</html>