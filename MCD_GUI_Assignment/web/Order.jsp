<%@page import="model.domain.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <%@ include file="HTML_parts/Meta.jsp" %>

        <title>Order</title>



        <style>
            div.form-check{
                margin-top: 3%;
                margin-bottom: 3%;
            }

            div.form-check>label#time{
                padding-left: 6%;
            }

            div#order-row{
                margin-top: 3%;
            }

            div#payment-method{
                width: 100%;
            }

            div#payment-method>label#payment-method{
                padding-left: 5%;
            }

            div#customer-details table {
                border-spacing: 15px;
            }

            div#customer-details td {
                padding: 10px;
            }

            div#delivery-later-div label,input{
                padding-left: 3%;
                margin-left: 3%;
                margin-top: 3%;
            }

            #page-progress .active {
                font-weight: 700;
                position: relative
            }

            #page-progress .active .fa-check {
                position: absolute;
                left: 50%;
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
                width: 49%;
            }

        </style>

    </head>




    <body class="d-flex flex-column min-vh-100">

        <%
            ArrayList<Product> cart = new ArrayList<Product>();
            double totalPrice = 0.0;
            double tax = 0.0;
            boolean cartIsEmpty = true;

            if (session.getAttribute("cart") != null) {
                cart = (ArrayList<Product>) session.getAttribute("cart");
                totalPrice = (Double) session.getAttribute("totalPrice");
                tax = totalPrice * 0.06;
            }

            if (session.getAttribute("cart") != null && !cart.isEmpty()) {
                cartIsEmpty = false;
            } else {
                cartIsEmpty = true;
            }

        %>


        <%@ include file="HTML_parts/Header.jsp" %>

        <div class="container bg-light mx-auto rounded mb-5 mt-4">

            <div id="title" class="row bg-warning border rounded">
                <div class="col py-5 text-center">
                    <h1>Order Details</h1>
                </div>
            </div>

            <div class='row mb-4'>
                <div class="col-12">
                    <div id="page-progress" class="d-flex justify-content-center align-items-center pt-4 pb-3">
                        <div class="px-sm-5 px-2">CART</div>
                        <div class="px-sm-5 px-2 active">ORDER DETAILS<i class="fas fa-check"></i></div>
                        <div class="px-sm-5 px-2">CHECKOUT</div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar bg-success" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>

            <div id="main-content" class="row mt-1 ml-1 mb-5">

                <div id="side-panel" class="col-md-4 order-md-2 mb-4">

                    <div class="p-2 border">
                        <h5 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-muted pl-3">Order Items</span>
                            <span class="badge badge-secondary badge-pill"><%= cart.size()%></span>
                        </h5>

                        <ul class="list-group mb-3">

                            <% for (Product cartProduct : cart) {%>

                            <li class="list-group-item d-flex justify-content-between lh-condensed">
                                <div>
                                    <h5 class="my-0"> <%= cartProduct.getProductName()%> </h5>
                                    <small class="text-muted"><%= cartProduct.getProductCategory().getCategoryName()%> </small>
                                </div>
                                <span class="text-muted">RM <%= String.format("%.2f", cartProduct.getProductPrice())%></span>
                            </li>

                            <% }%>

                            <li class="list-group-item d-flex justify-content-between bg-light">
                                <div class="text-success">
                                    <small class="my-0">Taxes and Delivery Fees</small>
                                </div>
                                <span class="text-success">+ RM <%= String.format("%.2f", tax)%></span>
                            </li>

                            <li class="list-group-item d-flex justify-content-between">
                                <span>Total (MYR)</span>
                                <strong>RM <%= String.format("%.2f", totalPrice)%></strong>
                            </li>
                        </ul>

                        <div class="container pt-2 mb-3">
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Continue Order</button>
                        </div>

                    </div>




                </div>

                <div id="order-form" class="col-md-8 order-md-1 border">

                    <div class="container-fluid">
                        <div class="row border-bottom">
                            <div class="col-12 pl-5 py-2"><h2>Order #1234</h2></div>
                        </div>

                        <div id="order-row" class="row d-flex h-100 border-bottom">

                            <div class="col-4"><div class="pt-2"><h5>Delivery Time</h5></div></div>

                            <div class="col-8 align-items-center">

                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="delivery-time-radios" value="delivery-now" id="orderNow" required>
                                    <label id="time" class="form-check-label" for="delivery-now">
                                        Delivery Now
                                    </label>
                                </div>

                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="delivery-time-radios" value="delivery-later" id="orderLater" required>
                                    <label id="time" class="form-check-label" for="delivery-later">
                                        Delivery Later
                                    </label>
                                </div>

                            </div>


                            <div class="row d-flex align-items-center mb-3 mt-2 w-100" id="deliveryLaterDiv">
                                <div class="col-6 pl-4">
                                    <label id="delivery-later-date" for="delivery-later-date">Select a Date: </label>
                                    <input  type="date" id="appt" name="delivery-later-date">
                                </div>
                                <div class="col-6">
                                    <label for="delivery-later-time">Time: </label>
                                    <input  type="time" id="appt" name="delivery-later-time">
                                </div>
                            </div>

                        </div>

                        <div id="order-row" class="row h-100 border-bottom">

                            <div class="col-4">
                                <div class="pt-2">
                                    <h5>Customer Details</h5>
                                    <a href="#">Edit</a>
                                </div>
                            </div>

                            <div class="col-8 d-flex align-items-center mb-3">
                                <div class="container-fluid">

                                    <div id="customer-details" class="row">
                                        <table>
                                            <tbody>
                                                <tr>
                                                    <td><p>ID</p></td>
                                                    <td><p>Cust-1</p></td>
                                                </tr>
                                                <tr>
                                                    <td><p>Name</p></td>
                                                    <td><p>John</p></td>
                                                </tr>
                                                <tr>
                                                    <td><p>Email</p></td>
                                                    <td><p>John@gmail.com</p></td>
                                                </tr>
                                                <tr>
                                                    <td><p>Phone</p></td>
                                                    <td><p>0111223344</p></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div id="order-row" class="row h-100 border-bottom">

                            <div class="col-4"><div class="pt-2"><h5>Address</h5></div></div>

                            <div class="col-8 d-flex align-items-center mb-3">
                                <div>
                                    <p>Street 1, address 2, state1, country</p>
                                    <span><a href="#">Change Address</a></span>
                                </div>

                            </div>
                        </div>

                        <!--                        <div class="container-fluid mb-5 mt-5">
                                                    
                                                    <div class="row mt-3">
                                                    <div class="col-9 mb-3">
                                                        <label for="address">Street</label>
                                                        <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>
                                                    </div>
                                                 </div>
                        
                                                    <div class="row">
                                                        <div class="col-md-3 mb-3">
                                                            <label for="state">State</label>
                                                            <select class="custom-select" id="state" required>
                                                                <option value="">Choose...</option>
                                                                <option>California</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-md-3 mb-3 ml-3">
                                                            <label for="zip">Postcode</label>
                                                            <input type="text" class="form-control" id="postcode" placeholder="" required>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="row mt-3 border-bottom">
                                                        <div class="col-12">
                                                            <button class="btn btn-primary btn-lg btn-block" type="submit">Save Address</button>
                                                        </div>
                                                    </div>
                                                </div>-->


                        <div id="order-row" class="row h-100 border-bottom">

                            <div class="col-4"><div class="pt-2"><h5>Payment Method</h5></div></div>

                            <div class="col-8 d-block mb-3">

                                <div class="form-check" id="payment-method">
                                    <input class="form-check-input" type="radio" name="payment-method-radios" value="" id="payment-method" required>
                                    <label class="form-check-label" id="payment-method" for="payment-method">Credit Card</label>
                                </div>

                                <div class="form-check" id="payment-method">
                                    <input class="form-check-input" type="radio" name="payment-method-radios" value="" id="payment-method" required>
                                    <label class="form-check-label" id="payment-method" for="payment-method">Debit Card</label>
                                </div>

                            </div>

                        </div>

                        <div class="row mt-5 mb-5">
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
                        </div>

                    </div>
                </div>


            </div>
        </div>

        <%@ include file="HTML_parts/Footer.jsp" %>
    </body>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">

        $(document).ready(function () {

            $("div#deliveryLaterDiv").hide();

            $("input[name=delivery-time-radios]").change(function () {

                if ($("#orderLater").prop("checked")) {
                    $("#deliveryLaterDiv").show();
                    //                console.log("show");

                } else if ($("#orderNow").prop("checked")) {
                    $("div#deliveryLaterDiv").hide();
                    //                console.log("hide");

                }
            });
            
        });

    </script>

</html>

