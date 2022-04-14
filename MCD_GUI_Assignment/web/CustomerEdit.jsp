<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Customer"%>
<%@ page import="java.util.*;"%>

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
            body{
                background-color:#f2f2f2;
            }
            p{
                margin:20px 0px;
                line-height: 35px;
                font-size: 20px;
            }
            .border1{
                margin: auto;
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
            .link{
                color:red;
            }
            .link:hover{
                color:#f3ad12;
            }
        </style>  
    </head>
    <body class="d-flex flex-column min-vh-100">  
        <%@ include file="HTML_parts/Header.jsp" %>

        <% Customer customerDetails = (Customer) session.getAttribute("customer");%>

        <div class="container mb-3 mt-3">

            <div class="row">
                <div class="col-12">
                    
                    <form action="CustomerUpdateServlet" method="POST">
                        <div class="border1">     
                            <h1>Edit Profile</h1>
                            <br/>
                            <input type="hidden"  value="<%= customerDetails.getCustomerID()%>" id="customerID" name="customerID"/>
                            <input type="hidden"  value="<%= customerDetails.getAddress().getAddressId()%>" id="addressID" name="addressID"/>
                            <input type="hidden"  value="<%= customerDetails.getPassword()%>" id="password" name="password"/>

                            <p>Customer Name:</p>
                            <input type="text"  value="<%= customerDetails.getCustomerName()%>" id="customername" name="customerName"/>              
                            <p>Email:</p>
                            <input type="text"  value="<%= customerDetails.getEmail()%>" id="email" name="email"/>          
                            <p>Phone Number:</p>
                            <input type="text"  value="<%= customerDetails.getPhoneNum()%>" id="phonenumber" name="phoneNumber"/>
                            <p>Street:</p>
                            <input type="text"  value="<%= customerDetails.getAddress().getStreet()%>" id="street" name="street"/>             
                            <p>State:</p>
                            <input type="text"  value="<%= customerDetails.getAddress().getState()%>" id="state" name="state"/>    
                            <p>Postcode:</p>
                            <input type="text"  value="<%= customerDetails.getAddress().getPostcode()%>" id="postcode" name="postcode"/>    
                            <br/>
                            <br/>
                            <input type="submit" name="submit" class="button" value="Save Details" />
                        </div>
                    </form>
                </div>
            </div>

        </div>

        <%@ include file="HTML_parts/Footer.jsp" %>
    </body>       
</html>
