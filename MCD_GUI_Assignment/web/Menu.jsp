<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Product, model.domain.ProductCategory"%>
<%@page import="model.da.ProductDA"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="HTML_parts/Meta.jsp" %>

        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

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

            <div class="row border" id="main">

                <div class="col-2 nav">
                    <div class="sidebar">
                        <ul id class="navbar-nav">
                            <li class="nav-item disabled">
                                <h2 id="catalog">Category</h2>
                            </li>
                            
                            <!-- set active class to nav-link according to the parameter "searchProductByCategory" -->
                            <% active = (request.getParameter("searchProductByCategory") == null) ? "active" : "";  %>
                            <li class="nav-item">
                                <a class="nav-link  <%= active%>" href="productMenuServlet">All</a>
                            </li>
                            
                            <% for (ProductCategory productCategory : productCategoryList) {%>
                            
                            <% active = (productCategory.getCategoryName().equalsIgnoreCase(request.getParameter("searchProductByCategory"))) ? "active" : "";%>
                            
                            <li class="nav-item">
                                <a class="nav-link  <%= active%>"
                                   href="productMenuServlet?searchProductByCategory=<%= productCategory.getCategoryName()%> "><%= productCategory.getCategoryName()%></a>
                            </li>

                            <% }%> 

                        </ul>
                    </div>
                </div>

                <div id="main-content" class="col-10  mt-4 mb-5">

                    <div class ="title">
                        <h3>McDonald<span>Menu</span></h3>
                    </div>

                    <div id="search" class="d-flex mb-5 mx-auto">
                        <input type="text" class="searchTerm" placeholder="What are you looking for?">
                        <button type="submit" class="searchButton">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>



                    <div id="product" class="container-fluid">

                        <div id="menu" class="row">

                            <% for (Product product : productList) {%>

                            <div class="col-lg-4 d-flex align-items-stretch">
                                <form method="post" action="#">
                                    <div class="card-group h-100">


                                        <div id="product-card" class="card">
                                            <img class="card-img-top rounded" src="data:image/jpg;base64,<%= product.getProductImageBase64()%>" height="270" width="100" alt="<%= product.getProductName()%>">
                                            <div class="card-body">
                                                <h5 class="card-title"><%= product.getProductName()%></h5>
                                                <p class="card-text"><%= product.getProductPrice()%></p>
                                                <a href="#" class="btn btn-primary">Add To Cart</a>
                                            </div>
                                        </div>

                                    </div>
                                </form>
                            </div>


                            <% }%> 

                        </div>


                    </div>
                </div>

            </div>
        </div>

        <%@ include file="HTML_parts/Footer.jsp" %>
    </body>
</html>

