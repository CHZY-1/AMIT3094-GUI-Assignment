<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Customer"%>
<%@ page import="java.util.*;"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <%@ include file="HTML_parts/Meta.jsp" %>

        <meta charset="UTF-8">
        <title>Payment Form</title>
        <style>

            #card-body{
                width: 750px;
                height: 600px;
                border: 1px solid black;
                background-color: white;
                display: flex;
                flex-direction: column;
                padding: 40px;
                justify-content:space-around;
                margin-top: 4%;
                margin-bottom: 7%;
            }

            #cart-body h1{
                text-align: center;
            }

            .first-row{
                display: flex;
            }

            .owner{
                width: 100%;
                margin-right: 40px;
            }

            .input-field{
                border: 1px solid #999;
            }

            .input-field input{
                width: 100%;
                border:none;
                outline: none;
                padding: 10px;
            }

            .selection{
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .selection select{
                padding: 10px 20px;
            }

            #card-body a{
                background-color: red;
                color: white;
                text-align: center;
                text-transform: uppercase;
                text-decoration: none;
                padding: 10px;
                font-size: 18px;
                transition: 0.5s;
            }

            #card-body a:hover{
                background-color:white;
                border-color:red;
                border:2px;
                color:red;
            }
            .button{
                min-height: 50px; 
                width: 100%;
            }
            
             #page-progress .active {
                font-weight: 700;
                position: relative
            }

            #page-progress .active .fa-check {
                position: absolute;
                left: 45%;
                bottom: -35px;
                background-color: #fff;
                font-size: 0.7rem;
                padding: 5px;
                border: 1px solid #008000;
                border-radius: 50%;
                color: #008000
            }

            .progress {
                height: 15px;
                background-color: #ccc
            }
            .progress div {
                display: flex;
                align-items: center;
                justify-content: center
            }
            .progress .progress-bar {
                width: 75%;
            }

        </style>
    </head>
    <body class="d-flex flex-column min-vh-100">

        <%@ include file="HTML_parts/Header.jsp" %>

        <div class="container py-2 rounded" id="card-body">
            <div id="payment-form" class="">
                <form action="PaymentServlet" method="POST">
                    <h1 class="text-center">Payment</h1><br>

                    <div class='row mb-4'>
                        <div class="col-12">
                            <div id="page-progress" class="d-flex justify-content-center align-items-center pt-4 pb-3">
                                <div class="px-sm-5 px-2">CART</div>
                                <div class="px-sm-5 px-2">ORDER DETAILS</div>
                                <div class="px-sm-5 px-2  active">PAYMENT<i class="fas fa-check"></i></div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar bg-success" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                    <div class="first-row pb-2">
                        <div class="owner">
                            <h3>Owner</h3>
                            <div class="input-field">
                                <input type="text" name="cardHolderName" required>
                            </div>
                        </div>
                        <div class="cvv">
                            <h3>CVV</h3>
                            <div class="input-field">
                                <input type="password" maxlength="3" name="cvv" pattern="[0-9]{3}" required>
                            </div>
                        </div>
                    </div>

                    <div class="second-row py-1">
                        <div class="card-number">
                            <h3>Card Number</h3>
                            <div class="input-field">
                                <input type="tel" inputmode="numeric" name="cardNum" maxlength="19" name="cardNum" pattern="[0-9\s]{13,19}" autocomplete="cc-number" placeholder="xxxx xxxx xxxx xxxx"  required>
                            </div>
                        </div>
                    </div>

                    <div class="third-row py-1">
                        <div class="selection">
                            <div class="cardnumber">
                                <h3>Expired Date</h3>
                                <div class="date">
                                    <select name="months" id="months" required>
                                        <option value="Jan">Jan</option>
                                        <option value="Feb">Feb</option>
                                        <option value="Mar">Mar</option>
                                        <option value="Apr">Apr</option>
                                        <option value="May">May</option>
                                        <option value="Jun">Jun</option>
                                        <option value="Jul">Jul</option>
                                        <option value="Aug">Aug</option>
                                        <option value="Sep">Sep</option>
                                        <option value="Oct">Oct</option>
                                        <option value="Nov">Nov</option>
                                        <option value="Dec">Dec</option>
                                    </select>
                                    <select name="years" id="years">
                                        <% for (int i = 2022; i <= 2035; i++) {%>
                                        <option value="<%= i%>"><%= i%></option>
                                        <% }%>
                                    </select>
                                </div>
                            </div>

                            <div class="cardtype mr-3">
                                <h3>Card type</h3>
                                <div class="card type">
                                    <select name="cards" id="types" required>
                                        <option value="Master">Master Card</option>
                                        <option value="Visa">Visa Card</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="first-row">
                        <input type="submit" name="submit" value="Confirm" class="button btn btn-primary"/>
                    </div>

                    <input type="hidden" name="paymentID" id="paymentID" value="<%= request.getParameter("paymentID")%>" />
                    <input type="hidden" name="delivery-time-radios" id="delivery-time-radios" value="<%= request.getParameter("delivery-time-radios")%>" />
                    <input type="hidden" name="delivery-later-date" id="delivery-later-date" value="<%= request.getParameter("delivery-later-date")%>" />
                    <input type="hidden" name="delivery-later-time" id="delivery-later-time" value="<%= request.getParameter("delivery-later-time")%>" />
                    <input type="hidden" name="payment-method-radios" id="payment-method-radios" value="<%= request.getParameter("payment-method-radios")%>" />

                </form>
            </div>
        </div>

        <%@ include file="HTML_parts/Footer.jsp" %>

    </body>
</html>
