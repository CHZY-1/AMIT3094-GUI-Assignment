<%@page import="java.util.ArrayList"%>
<%@page import="model.domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="HTML_parts/Meta.jsp" %>
        <title>MCD Home Page</title>
        
        <style>
            .carousel-inner > .item > img {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
            }
            
            /* Fixed image height in bootstraps carousel */
            .home-carousel-Img img {
                height: 550px;
                max-height: 550px;
              }
              
              /*Change Arrow Colors in bootstraps carousel */
              .carousel-control-prev-icon {
                background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23fff' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E") !important;
               }

               .carousel-control-next-icon {
                 background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23fff' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E") !important;
               }
               
               /*Customize container*/
               .custom-container{
                   margin-top: 50px;
                   margin-bottom: 10px;
               }
               
               .product{
                    margin-top:10px;
                    margin-bottom:10px;
                    border: #cdcdcd medium solid;
                    border-radius: 10px;
                    -moz-border-radius: 10px;
                    -webkit-border-radius: 10px;
                }
        </style>
        
    </head>
    
    <%
        ArrayList<Product> productList = new ArrayList<Product>();
        
        if(request.getAttribute("randomProductList") == null){
            response.sendRedirect("HomeServlet");
        }else{
            productList = (ArrayList<Product>) request.getAttribute("randomProductList");
        }
    %>

    <body class="d-flex flex-column min-vh-100">
            <%@ include file="HTML_parts/Header.jsp" %>
            
            
            <div id="home-slideshow" class="container" style="margin-top: 5px;">
                <div id="home-carousel" class="carousel slide carousel-fade" data-ride="carousel">
                    <ol class="carousel-indicators">
                      <li data-target="#home-carousel" data-slide-to="0" class="active"></li>
                      <li data-target="#home-carousel" data-slide-to="1"></li>
                      <li data-target="#home-carousel" data-slide-to="2"></li>
                      <li data-target="#home-carousel" data-slide-to="3"></li>
                    </ol>
                    <div class="carousel-inner">
                      <div class="carousel-item home-carousel-Img active" data-interval="3000">
                        <img class="rounded img-fluid mx-auto d-block" src="Pictures/MCD-Home1.jpg" alt="First slide">
                      </div>
                      <div class="carousel-item home-carousel-Img" data-interval="3000">
                        <img class="rounded img-fluid mx-auto d-block" src="Pictures/MCD-Home2.png" alt="Second slide">
                      </div>
                      <div class="carousel-item home-carousel-Img" data-interval="3000">
                        <img class="rounded img-fluid mx-auto d-block" src="Pictures/MCD-Home3.png" alt="Third slide">
                      </div>
                      <div class="carousel-item home-carousel-Img" data-interval="3000">
                        <img class="rounded img-fluid mx-auto d-block" src="Pictures/MCD-Home5.png" alt="Fourth slide">
                      </div>
                        
                    </div>
                    <a class="carousel-control-prev" href="#home-carousel" role="button" data-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#home-carousel" role="button" data-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                    </a>
                 </div>
            </div>
            
            
            <div id="home-recommend" class="container custom-container bg-light">
                
                <div class="row mb-3"><div class="col bg-warning rounded d-flex align-items-center justify-content-center"><h1>Recommended</h1></div></div>
                
                <div class="row text-center mb-3">
                    
                    <% for(Product product : productList) { %>
                    <div class="col">
                        <div class="product">
                            <h1> <%= product.getProductName()%> </h1>
                        </div>
                    </div>
                    <% } %>
                    
                    <div class="col">
                        <div class="product">
                            <h1> Product 2 </h1>
                        </div>
                    </div>
                    <div class="col">
                        <div class="product">
                            <h1> Product 3 </h1>
                        </div>
                    </div>
                </div>
                
            </div>
            
            
            <div id="home-about-us" class="container custom-container bg-light">
                <div class="row"><div class="col bg-warning rounded d-flex align-items-center justify-content-center"><h1>About Us</h1><br/></div></div>
                
                <div class="row" style="margin-bottom: 30px; margin-top: 30px;">
                    <img class="img-fluid mx-auto d-block" src="Pictures/MCD-About-us.jpg" alt=""/>
                </div>
                
                <div class="row-text-center">
                    <p>McDonald’s is the world’s leading quick service restaurant chain with more than 36,000 
                        restaurants worldwide, serving more than 69 million customers daily in over 100 countries. 
                        In Malaysia, McDonald’s serves over 13.5 million customers a month in 300 restaurants nationwide. 
                        McDonald’s employs more than 14,000 Malaysians in its restaurants across the nation, providing career, training and development opportunities.
                    </p>
                </div>            
            </div>
            
            
            <div class="container custom-container">
                <div class="row" style="margin-bottom: 40px;">
                    <img class="img-fluid mx-auto d-block" src="Pictures/MCD-Home4.png" alt=""/>
                </div>
            </div>
            
            <%@ include file="HTML_parts/Footer.jsp" %>
        
    </body>
</html>
