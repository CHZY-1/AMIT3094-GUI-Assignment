<%@page import="model.domain.Payment"%>
<%@page import="model.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
    <head>
        <%@ include file="HTML_parts/Meta.jsp" %>
        <title>Payment Report</title>
        <style>
            body{
                background-color:#f2f2f2;
            }
            p{
                margin:20px 0px;
                font-size:20px;
                font-family: 'Trebuchet MS', sans-serif;
            }
            .border1{
                margin: auto;
                width: 500px;
                border: 5px solid #FFFFFF;
                padding: 10px 20px;
                background-color:white;
                border-bottom-width:30px;
            }            
            h2{
                color: #f3ad12;
                margin:0;
                font-family: 'Trebuchet MS', sans-serif;
                text-decoration: underline;
            }
            .button {
                background-color: #f3ad12;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                border-radius: 5px;
                border:none;
                width:100%;
            }
            
            .button:hover{
                background-color: buttonface;
                border-color:#f3ad12;
                border:2px solid black;
                color:black;
            }
            
            td{
                padding-left: 10px;
            }
            
        </style>
    </head>
    <body class="d-flex flex-column min-vh-100">  
        <%@ include file="HTML_parts/Header.jsp" %>


        <%

            Customer customer = (Customer) session.getAttribute("customer");
            Payment payment = (Payment) session.getAttribute("payment");

        %>


        <br/>
        <div class="container mt-3 mb-3">
            <div class="border1 rounded">
                <h2 class="text-center pb-2">Payment Successful</h2>
                <table>
                    <tr>
                        <td><p>Payment ID</p></td>
                        <td><%= payment.getPaymentID() %></td>
                    </tr>
                    <tr>
                        <td><p>Customer ID</p></td>
                        <td><%= customer.getCustomerID() %></td>
                    </tr>
                    <tr>
                        <td><p>Customer Name</p></td>
                        <td><%= customer.getCustomerName() %></td>
                    </tr>
                    <tr>
                        <td><p>Customer Email</p></td>
                        <td><%= customer.getEmail() %></td>
                    </tr>
                    
                    <tr>
                        <td><p>Card Number</p></td>
                        <td><%= payment.getCard().getCardNo() %></td>
                    </tr>
                    <tr>
                        <td><p>Total Payment Amount</p></td>
                        <td><%= String.format("%.2f",payment.getTotalPaymentAmount()) %></td>
                    </tr>
                    <tr>
                        <td><p>Payment Time</p></td>
                        <td><%= payment.getPaymentTimestamp() %></td>
                    </tr>
                    <tr>
                        <td><p>Address</p></td>
                        <td><%= customer.getAddress().toString() %></td>
                    </tr>
                </table>
                    <button class="button" onclick="window.location.href='Home.jsp' " type="submit">Proceed</button>
            </div>
        </div>
        <br/>
        <%@ include file="HTML_parts/Footer.jsp" %> 
    </body>
</html>