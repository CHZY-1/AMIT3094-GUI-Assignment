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

            .title h4{
                text-transform: captitalize;
                font-size: 36px;
                position: relative;
                display: insline-block;
                padding-bottom: 20px;
            } 

            .title h4 span{
                display: block;
                font-size: 18px;
                font-style: italic;
                margin-bottom: -15px;    
            }

            .title h4:before{
                position: absolute;
                content: "";
                width: 100px;
                height: 2px;
                background-color: yellow;
                bottom: 0;
                left:50%;
                transform: translateX(-50%);
            }

            .menu{
                display: flex ;
                flex-wrap: wrap;
            }

            .single-menu{
                flex-basis:550px;
                margin-bottom: 10px;
                padding-bottom: 20px;
                border-bottom: 1px solid #ddd;
            }

            .single-menu{
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
                margin-left: 7px;
                margin-right: 7px;
            }

            .single-menu h4{
                text-transform: capitalize;
                font-size: 22px;
                border-bottom: 1px dashed #333;
                margin-bottom: 5px;
                padding-bottom: 5px;
            }

            .single-menu h4 span{
                float: right;
                color: #ff9900;
                font-style: italic;
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
                margin-top: 3px;
                margin-bottom: 5px;
            }

        </style> 

    </head>

    <body class="d-flex flex-column min-vh-100">

        <%@ include file="HTML_parts/Header.jsp" %>

        <div class="container-fluid">

            <div class="row border" id="main">

                <div class="col-2 nav">
                    <div class="sidebar">
                        <ul id class="navbar-nav">
                            <li class="nav-item disabled">
                                <h2 id="catalog">Category</h2>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">All</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Burgers</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Drinks</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Desserts</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Others</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div id="main-content" class="col-10  mt-4">

                    <div class ="title">
                        <h4>McDonald<span>Menu</span></h4>
                    </div>

                    <div id="search" class="d-flex mb-5 mx-auto">
                        <input type="text" class="searchTerm" placeholder="What are you looking for?">
                        <button type="submit" class="searchButton">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>

                    <div id="product" class="container-fluid">
                        <form method="post" action="MenuS.java">
                            <div class="menu d-flex justify-content-center">

                                <div class="card-group">

                                    <div class="single-menu border justify-content-center">
                                        <div id="product-card" class="card">
                                            <img class="card-img-top" src="Pictures/apple.jpg" alt="Product Name">
                                            <div class="card-body">
                                                <h5 class="card-title">Card title</h5>
                                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                                <a href="#" class="btn btn-primary">Go somewhere</a>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="single-menu border justify-content-center">
                                        <div id="product-card" class="card">
                                            <img class="card-img-top" src="Pictures/apple.jpg" alt="Card image cap">
                                            <div class="card-body">
                                                <h5 class="card-title">Card title</h5>
                                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                                <a href="#" class="btn btn-primary">Go somewhere</a>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="single-menu border">
                                        <div id="product-card" class="card">
                                            <img class="card-img-top" src="Pictures/apple.jpg" alt="Card image cap">
                                            <div class="card-body">
                                                <h5 class="card-title">Card title</h5>
                                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                                <a href="#" class="btn btn-primary">Go somewhere</a>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="single-menu">
                                        <div id="product-card" class="card">
                                            <img class="card-img-top" src="Pictures/apple.jpg" alt="Card image cap">
                                            <div class="card-body">
                                                <h5 class="card-title">Card title</h5>
                                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                                <a href="#" class="btn btn-primary">Go somewhere</a>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="single-menu">
                                        <div id="product-card"><h4>Big Mac <span>RM11.79</span></h4> </div>
                                    </div>

                                    <div class="single-menu">
                                        <div id="product-card"><h4>Big Mac <span>RM11.79</span></h4> </div>
                                    </div>

                                </div>


                            </div>
                        </form>
                    </div>


                </div>
            </div>

        </div>

        <%@ include file="HTML_parts/Footer.jsp" %>
    </body>
</html>

