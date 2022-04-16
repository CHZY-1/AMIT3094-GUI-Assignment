<%@page import="model.da.StaffDA"%>
<%@page import="model.domain.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Customer" %>
<%@page import="model.domain.Role"%>
<%@page import="model.da.CustomerDA"%>
<%@page import="model.da.RoleDA"%>
<%
    CustomerDA customerDA = new CustomerDA();
    RoleDA roleDA = new RoleDA();
%>
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="HTML_parts/Meta.jsp" %>

        <title>Admin Login</title>
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
                padding:5px;
            }

            td{
                text-align: center;
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

            table.record td:nth-child(1){
                width: 250px;
            }

            table.record td:nth-child(2){
                width: 450px;
            }

            table.record td:nth-child(3){
                width: 250px;
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
            button,.button{
                background-color: #ffbb00;
                border-radius: 5px;
            }
        </style>
    </head>

    <body class="d-flex flex-column min-vh-100">
        <%@ include file="HTML_parts/AdminHeader.jsp" %>
        <h1>Customer List</h1>
        <div class="all">

        </div>  
        <br/>
        <table class="record">
            <tr style="background-color: #ffda75">
                <th>Staff ID</th>
                <th>Name</th>
                <th>Gender</th>
            </tr>

            <% 
                String val="";
                val=(String)request.getAttribute("seVa");
                /*String order="";
                order=(String)request.getAttribute("order");*/
                List<Customer> customerList = new ArrayList<Customer>();
                               customerList = customerDA.listCustomer();
   
                if(val=="!@#$"){
                    customerList = customerDA.listCustomer();
                }
  
                for(Customer c: customerList){
            %>
            <%if(myrole.getCustomer().equals("True")){ %>
            <tr>
                <td><%= c.getCustomerID()%></td>
                <td><%= c.getCustomerName()%></td>
                <td><%= c.getEmail()%></td>
            </tr>
            <%}%>
            <%}request.getSession().removeAttribute("seVa");%>

        </table>

        <script type="text/javascript">
            function createPopupWin(pageURL, pageTitle, popupWinWidth, popupWinHeight) {
                var left = (screen.width - popupWinWidth) / 2;
                var top = (screen.height - popupWinHeight) / 4;

                var myWindow = window.open(pageURL, pageTitle,
                        'resizable=yes, width=' + popupWinWidth
                        + ', height=' + popupWinHeight + ', top='
                        + top + ', left=' + left);
            }
        </script>
        <%@ include file="HTML_parts/Footer.jsp" %>
    </body>
</html>