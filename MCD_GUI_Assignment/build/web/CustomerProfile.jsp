<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Customer"%>
<%@ page import="java.util.*;"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="HTML_parts/Meta.jsp" %>
        <meta charset="UTF-8">
        <title>Customer Profile</title>
        <style>
            .edit{
                position: absolute;
                top: 6px;
                right: 10px;
                font-size: 18px
            }
            p{
                margin:20px 0px;
                line-height: 35px;
                font-size: 20px;
            }
            .border1{
                margin-top: 60px;
                margin-bottom: 60px;
                width: 500px;
                border: 5px solid #FFFFFF;
                padding: 10px 20px;
                background-color:white;
            }
            input[type=text]{
                padding: 12px 10px;
                margin: -10px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 2px;
                box-sizing: border-box;
                width:100%;
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
            }
            .button:hover{
                background-color:white;
                border-color:red;
                border:2px;
                color:red;
            }
            .link{
                color:red;
            }
            .link:hover{
                color:#f3ad12;
            }
        </style>  
    </head>
    <body  class="d-flex flex-column min-vh-100">

        <%@ include file="HTML_parts/Header.jsp" %>  

        <% Customer customer = (Customer) session.getAttribute("customer");%>
        <div class="border1 bg-light mx-auto">
            <div class="container mb-5 mt-5">
                <h1 style="float:left">My Profile</h1>            
<!--                <a href="CustomerEdit.jsp" style="float:right">Edit</a>-->
                <br/>
                <br/>
                <p>Customer ID:</p>
                <input type="text" readonly value="<%= customer.getCustomerID()%>" id="customerID" name="customerID"/>            
                <p>Customer Name:</p>
                <input type="text" readonly value="<%= customer.getCustomerName()%>" id="customername" name="customername"/>              
                <p>Email:</p>
                <input type="text" readonly value="<%=customer.getEmail()%>" id="email" name="email"/>          
                <p>Phone Number:</p>
                <input type="text" readonly value="<%= customer.getPhoneNum()%>" id="phonenumber" name="phonenumber"/> 
                <p>Address:</p>
                <input type="text" readonly value="<%= customer.getAddress().toString()%>" id="street" name="street"/>
            </div>
        </div>

        <%@ include file="HTML_parts/Footer.jsp" %> 
    </body>     
</html>
