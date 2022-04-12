<%@page import="model.domain.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="HTML_parts/Meta.jsp" %>

        <title>Cart</title>

    </head>

    <style>

        .cart_items {
            margin-top: 8px
        }

        /*        fixed container width*/

        div#cart-body{
            max-width: 80%;
        }

        .cart_list {
            border: solid 1px #e8e8e8;
            box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
            background-color: #fff
        }


        .cart_item_info {
            width: calc(100% - 180px);
            float: left;
            padding-top: 18px
        }


        .cart_item_name {
            margin-left: 7%
        }

        .cart_item_title {
            font-size: 18px;
            font-weight: 400;
            color: rgba(0, 0, 0, 0.5)
        }

        .cart_item_text {
            display: block;
            word-wrap:break-word;
            font-size: 18px;
            margin-top: 35px;
        }

        .cart_info_col{
            display: block;
            max-width: 35%;
        }

        .icon-input-btn{

            margin-left: 5%;
            display: inline-block;
            position: relative;
            background-color: DodgerBlue;
            border-radius: 7%;
            color: white;
            cursor: pointer;

        }

        .icon-input-btn input[type="submit"]{
            padding-left: 2em;
        }

        .icon-input-btn .fa{
            display: inline-block;
            position: absolute;
            left: 0.50em;
            top: 30%;
        }

        #remove-button{
            margin-left: 20%;
        }


    </style>

    <body>

        <%
            ArrayList<Product> cart = new ArrayList<Product>();
            double totalPrice = 0;
            boolean cartIsEmpty = true;

            if (session.getAttribute("cart") != null) {
                cart = (ArrayList<Product>) session.getAttribute("cart");
            }

            if (session.getAttribute("cart") != null && !cart.isEmpty()) {
                cartIsEmpty = false;
            } else {
                cartIsEmpty = true;
            }

        %>

        <%@ include file="HTML_parts/Header.jsp" %>

        <div class="container-fluid my-5">

            <div class="row d-flex justify-content-center">

                <div id="cart-body" class=”col-10 w-100”>


                     <div id="cart" class="card mb-4">

                        <div class="card-header py-3 bg-warning d-flex justify-content-between">
                            <h4 class="mb-0">Cart - <%= cart.size()%> items</h4>
                            <button type="button" onclick="location.href = 'Menu.jsp';" class="btn btn-primary mr-2">Back To Menu</button>
                        </div>

                        <div class="card-body">

                            <% if (cartIsEmpty == true) {%>

                            <div class="card mb-3 ">
                                <div class="row no-gutters">


                                    <div class="col-12">

                                        <h2 class="text-center">Nothing In the Cart Yet <%= cartIsEmpty%> </h2>
                                    </div>

                                </div>
                            </div>

                            <% } else { %>


                            <% for (Product cartProduct : cart) {%>
                            <form method="post" action="cartServlet">

                                <input type="hidden" name="productID" value="<%= cartProduct.getProductID()%>" />
                                <input type="hidden" name="productName" value="<%= cartProduct.getProductName()%>" />
                                <input type="hidden" name="productImage" value="<%= cartProduct.getBase64Image()%>" />
                                <input type="hidden" name="productPrice" value="<%= cartProduct.getProductPrice()%>" />
                                <input type="hidden" name="productCategoryID" value="<%= cartProduct.getProductCategory().getCategoryID()%>" />
                                <input type="hidden" name="productCategoryName" value="<%= cartProduct.getProductCategory().getCategoryName()%>" />
                                <input type="hidden" name="action" value="removeFromCart" />



                                <div class="card mb-3 ">
                                    <div id="cart" class="row no-gutters">


                                        <div class="col-md-4">
                                            <img id="product-img" src="data:image/jpg;base64,<%= cartProduct.getBase64Image()%> " class="img-fluid rounded">
                                        </div>

                                        <div class="col-md-8">
                                            <div class="card-body">

                                                <div class="cart_list ml-3 mr-3 mt-4">
                                                    <div class="cart_item clearfix">
                                                        <div class="cart_item_info d-flex flex-md-row flex-column justify-content-between mb-3">

                                                            <div class="cart_item_name cart_info_col">
                                                                <div class="cart_item_title">Name</div>
                                                                <div class="cart_item_text"><%= cartProduct.getProductName()%></div>
                                                            </div>

                                                            <div class="cart_info_col">
                                                                <div class="cart_item_title">Category</div>
                                                                <div class="cart_item_text"><%= cartProduct.getProductCategory().getCategoryName()%></div>
                                                            </div>

                                                            <div class="cart_info_col">
                                                                <div class="cart_item_title">Quantity</div>
                                                                <div class="cart_item_text">1</div>
                                                            </div>

                                                            <div class="cart_info_col">
                                                                <div class="cart_item_title">Price</div>
                                                                <div class="cart_item_text"><%= String.format("%.2f", cartProduct.getProductPrice())%></div>
                                                            </div>

                                                            <div class="cart_info_col">
                                                                <div class="cart_item_title"></div>
                                                                <div class="cart_item_text" id="remove-button">

                                                                    <span class="icon-input-btn">
                                                                        <i class="fa fa-trash"></i> 
                                                                        <input type="submit" class="btn btn-primary" value="Remove">
                                                                    </span>




                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </form>

                            <% } %>

                            <% } %>


                        </div>


                    </div>

                </div>

                <div class="col-2">

                    <div class="card mb-4">
                        <div class="card-header py-3 bg-warning">
                            <h5 class="mb-0">Summary</h5>
                        </div>
                        <div class="card-body">
                            <ul class="list-group list-group-flush">

                                <li
                                    class="list-group-item d-flex justify-content-between align-items-center px-0 pb-0 border-bottom">
                                    Product
                                    <span class="pr-1">RM</span>
                                </li>


                                <% for (Product cartProduct : cart) {%>
                                <li
                                    class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0 text-break">
                                    <%= cartProduct.getProductName()%>
                                    <span class="text-nowrap"><%= String.format("%.2f", cartProduct.getProductPrice())%></span>
                                </li>

                                <%
                                    totalPrice += Double.valueOf(cartProduct.getProductPrice());
                                %>

                                <% }%>

                                <li
                                    class="list-group-item d-flex justify-content-between align-items-center px-0 mb-3">
                                    <div>
                                        <strong>Total amount</strong>
                                        <p class="mb-0">(including TAX)</p>
                                    </div>
                                    <span><strong><%= totalPrice%></strong></span>
                                </li>
                            </ul>

                            <% if (cartIsEmpty != true) { %>

                            <form method="post" action="orderServlet">

                                <button type="button" class="btn btn-primary btn-lg btn-block">
                                    Go to checkout
                                </button>

                            </form>

                            <% }%>

                        </div>
                    </div>

                </div>

            </div>


        </div>


        <%@ include file="HTML_parts/Footer.jsp" %>
    </body>
</html>
