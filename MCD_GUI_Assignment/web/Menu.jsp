<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Product, model.domain.ProductCategory"%>
<%@page import="model.da.ProductDA"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="HTML_parts/Meta.jsp" %>

        <title>Menu</title>

        <style type="text/css">	 
            body { 
                font-family: 'Poppins', sans-serif; 
            } 

            .title{
                text-align: center;
                margin-bottom: 3%;
            }

            .title h3{
                font-size: 36px;
                position: relative;
                display: inline-block;
                padding-bottom: 20px;
            } 

            .title h3 span{
                display: block;
                font-size: 18px;
                font-style: italic;
                margin-bottom: -13px;    
            }

            .title h3:before{
                position: absolute;
                content: "";
                width: 100px;
                height: 2px;
                background-color: yellow;
                bottom: 0;
                left:50%;
                transform: translateX(-50%);
            }



            .sidebar{
                max-width: 200px;
                box-sizing:border-box;
                list-style: none;
                display: flex;
                text-align: center;
                background-color:#fcba03;    
            }

            #catalog{
                color: black;
                font-size:25px;
                letter-spacing: 4px;
                padding: 15px;
                border-bottom: 1px solid black;
            }

            .sidebar li {
                text-decoration: none;
                color:black;
                font-size: 19px;
                letter-spacing: 2px;
                display: list-item;
                padding: 15px;
            }

            .sidebar .nav-link{
                color: black;
            }

            .sidebar .active{
                color:dodgerblue;
            }

            .sidebar a:hover{
                background-color: white;
                transition: 0.5s;
                letter-spacing: 2px;
                text-transform: uppercase;
            }

            #search {
                width: 60%;
            }

            .searchTerm {
                width: 100%;
                height: 100%;
                border: 3px solid #00B4CC;
                border-right: none;
                padding: 5px;
                border-radius: 5px 0 0 5px;
                outline: none;
                color: #9DBFAF;
            }

            .searchTerm:focus{
                color: #00B4CC;
            }

            .searchButton {
                min-width: 15%;
                height: 100%;
                border: 1px solid #00B4CC;
                background: #00B4CC;
                text-align: center;
                color: #fff;
                border-radius: 0 5px 5px 0;
                cursor: pointer;
                font-size: 20px;
            }

            #product-card{
                width: 18rem;
                margin-top: 7%;
                margin-bottom: 7%;
            }

        </style> 

    </head>

    <%
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        String active = "";
        int index=0;

        if (session.getAttribute("productList") == null || session.getAttribute("productCategoryList") == null) {
            response.sendRedirect("productMenuServlet");
        } else {
            productList = (ArrayList<Product>) session.getAttribute("productList");
            productCategoryList = (ArrayList<ProductCategory>) session.getAttribute("productCategoryList");
        }

    %>

    <body class="d-flex flex-column min-vh-100">

        <%@ include file="HTML_parts/Header.jsp" %>

        <div id="main-body-container" class="container-fluid">

            <div class="row" id="main">

                <div class="col-2 nav">
                    <div class="sidebar">
                        <ul id class="navbar-nav">
                            <li class="nav-item disabled">
                                <h2 id="catalog">Category</h2>
                            </li>

                            <!-- set active class to nav-link according to the parameter "searchProductByCategory" -->
                            <% active = (request.getParameter("searchProductByCategory") == null) ? "active" : "";%>
                            <li class="nav-item">
                                <a class="nav-link  <%= active%>" href="productMenuServlet">All</a>
                            </li>

                            <% for (ProductCategory productCategory : productCategoryList) {%>

                            <% active = (productCategory.getCategoryName().equalsIgnoreCase(request.getParameter("searchProductByCategory"))) ? "active" : "";%>

                            <li class="nav-item">
                                <a class="nav-link  <%= active%>"
                                   href="productMenuServlet?searchProductByCategory=<%= productCategory.getCategoryName()%> "><%= productCategory.getCategoryName()%>
                                </a>
                            </li>

                            <% }%> 

                        </ul>
                    </div>
                </div>

                <div id="main-content" class="col-10  mt-4 mb-5">

                    <div class ="title">
                        <h3>McDonald<span>Menu</span></h3>
                    </div>

                    <form action="productMenuServlet" method="post">
                        <div id="search" class="d-flex mb-5 mx-auto">

                            <input type="text" name="search-value" class="searchTerm" placeholder="What are you looking for ?">
                            <button type="submit" class="searchButton">
                                <i class="fa fa-search"></i>
                            </button>

                        </div>
                    </form>



                    <div id="product" class="container-fluid">

                        <div id="menu" class="row">
                            
                            <% if(!productList.isEmpty()) { %>

                            <% for (Product product : productList) {%>

                            <div class="col-lg-4 d-flex align-items-stretch">

                                <form method="post" action="cartServlet">
                                    <div class="card-group h-100">


                                        <div id="product-card" class="card">
                                            <img class="card-img-top rounded" src="data:image/jpg;base64,<%= product.getProductImageBase64()%>" height="270" width="100" alt="<%= product.getProductName()%>">
                                            <div class="card-body">
                                                <h4 class="card-title pl-3"><%= product.getProductName()%></h4>

                                                <p class="card-text pl-3">Price: RM <%= String.format("%.2f", product.getProductPrice())%> </p>

                                                <div id="input-group" class="input-group mb-3">
                                                    <span class="input-group-btn">
                                                        <button type="button" id="<%= index %>" class="quantity-left-minus btn btn-number"  data-type="minus" data-field="">
                                                            <i class="fa fa-minus"></i>
                                                        </button>
                                                    </span>
                                                    <input type="text" id="quantity-<%= index %>" name="productQuantity" class="form-control input-number bg-light text-center rounded" value="1" min="1" max="100" readonly>
                                                    <span class="input-group-btn">
                                                        <button type="button" id="<%= index %>" class="quantity-right-plus btn btn-number" data-type="plus" data-field="">
                                                            <i class="fa fa-plus"></i>
                                                        </button>
                                                    </span>
                                                </div>

                                                <input type="hidden" name="productQuantity" id="product-quantity-<%= index %>" value="1" />
                                                <input type="hidden" name="productID" value="<%= product.getProductID()%>" />
                                                <input type="hidden" name="productName" value="<%= product.getProductName()%>" />
                                                <input type="hidden" name="productImage" value="<%= product.getProductImageBase64()%>" />
                                                <input type="hidden" name="productPrice" value="<%= product.getProductPrice()%>" />
                                                <input type="hidden" name="productCategoryID" value="<%= product.getProductCategory().getCategoryID()%>" />
                                                <input type="hidden" name="productCategoryName" value="<%= product.getProductCategory().getCategoryName()%>" />
                                                <input type="hidden" name="action" value="addToCart" />

                                                <div class="container pt-2"><input type="submit" id="add-to-cart" class="btn btn-primary w-100" name="add-to-cart-button" value="Add To Cart"/></div>


                                            </div>
                                        </div>

                                    </div>
                                </form>
                            </div>

                            <% index++; %> 
                            <% }%> 

                        </div>
                            
                           <% }else{ %>
                           
                           <div class="container d-block pt-3 text-center" style="height: 400px;"><h2>No Products Found</h2></div>
                           
                           <% } %>


                    </div>
                </div>

            </div>
        </div>

        <%@ include file="HTML_parts/Footer.jsp" %>
    </body>
</html>

<script>

   // Quantity Plus and Minus function 
    $(document).ready(function () {

        var quantitiy = 0;
        $('.quantity-right-plus').click(function (e) {

            e.preventDefault();
            
            var id = $(this).attr('id');
            
            var quantityFieldID = "#quantity-"+id;

            var quantity = parseInt($(quantityFieldID).val());
            var hiddenProductQuantityID = '#product-quantity-'+id;

            $(quantityFieldID).val(quantity + 1);
            $(hiddenProductQuantityID).val(quantity + 1);
            
//            console.log(id);
//            console.log(quantityFieldID);
            console.log(hiddenProductQuantityID);


        });

        $('.quantity-left-minus').click(function (e) {

            e.preventDefault();
            
            var id = $(this).attr('id');
            
            var quantityFieldID = "#quantity-"+id;
            
            var hiddenProductQuantityID = '#product-quantity-'+id;

            var quantity = parseInt($(quantityFieldID).val());

            if (quantity > 1) {
                $(quantityFieldID).val(quantity - 1);
                
                $(hiddenProductQuantityID).val(quantity - 1);
            }
            
        });

    });

</script>
