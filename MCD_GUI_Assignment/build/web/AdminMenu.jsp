<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Product" %>
<%@page import="model.domain.ProductCategory"%>
<%@page import="model.da.RoleDA"%>
<%@page import="model.da.StaffDA"%>
<%@page import="model.da.ProductDA"%>
<%@page import="model.da.ProductCategoryDA"%>
<%@page import="controller.Control.ProductController"%>
<%
RoleDA roleDA=new RoleDA();
StaffDA staffDA=new StaffDA();
ProductController prodCon=new ProductController();
ProductDA prodDA=new ProductDA();
%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
hidden form field
-->
<html>
    <head>
        <title>Admin-Menu</title>
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
            }
            
            table.record{
                border:4px solid black;
                margin: auto;
                font-size:20px;
                overflow: hidden;
                border-spacing: 0;
            }
            
            table.record tr, table.record td, table.record th{
                border: 1pt solid black;
                width: 120px;
                padding-left: 10px;
                height: 40px;
            }
            table.record td:nth-child(2), table.record th:nth-child(2){
                width: 300px;
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
                margin: 50px 0px 30px 250px;
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
            button{
                background-color: #ffbb00;
                border-radius: 5px;
            }
            .center{
                text-align: center;
            }
        </style>
    </head>
    
    <body>
        <jsp:include page="HTML_parts/AdminHeader.jsp" />
            <h1>Product List</h1>
                <div class="all">
                    <form action="searchAdmin" method="post" style="float:left; margin:0px 350px 0px 20px;height: 20px;">
                        <b style="font-size: 20px;padding-bottom: -5px;">Product Category: </b>
                        <select name="search" id="category" style="width: 100px;height: 27px;">
                            <% ProductCategoryDA progCaDA=new ProductCategoryDA();
                            List<ProductCategory> progCaList=progCaDA.getAllProductCategory();
                            %><option value="All" selected="">All</option><%
                        for(ProductCategory c: progCaList){%>
                        <option value="<%= c.getCategoryID()%>"><%= c.getCategoryName()%></option>
                        <%}%>
                      </select>
                         <input type="hidden" name="place" value="menu"/>
                         <button type="submit" style="padding: 4px;"><i class="fa fa-search"></i></button>
                        </form>
                    <a href="JavaScript:createPopupWin('AddCategory.jsp','Admin-Add Role', 500, 400)" class="add"><b>Add Product Category</b></a>
                    <a href="AddFood.jsp" class="add"><b>Add New Product</b></a>
                </div>  
            <br/>
                <table class="record">
                <tr style="background-color: #ffda75;">
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Price (RM)</th>
                    <th>Image</th>
                    <th>Category</th>
                    <th>Actions</th>
                </tr>
                <%
                String msg=(String)request.getAttribute("pMsg");
                if(msg!=null){
                %>
                <script type="text/javascript">
                    alert("<%=msg%>");
                </script>
                <%}request.getSession().removeAttribute("pMsg");
                        String val="";
                        val=(String)request.getAttribute("seVa");
                        ArrayList<Product> product=new ArrayList<Product>();
                        product=prodDA.getAllProduct();

                       if(val!=null && val!=""){
                           if(val!="All"){
                            product=prodDA.getAllProductByCategory(val);
                            }
                            if(val=="!@#$"||val=="All"){
                                product=prodDA.getAllProduct();
                            }
                        }
                        
                        
                        for(Product p: product){
                            if(p.isHidden()==false){
                    %>
                    <tr>
                    <td class="center"><%=p.getProductID()%></td>
                    <td><%=p.getProductName()%></td>
                    <td class="center"><%= String.format("%.2f",p.getProductPrice())%></td>
                    <td><img style="width: 150px;height: 150px;margin: 10px 10px 10px 0;background-color: white;" src="data:image/jpg;base64,<%= p.getProductImageBase64()%>" alt="<%= p.getProductName()%>"></td>
                    
                    <td class="center"><%=p.getProductCategory().getCategoryName()%></td>
                    <td>
                        <div class="actionButton"> 
                        <form action="getProductServlet"  method="post">
                            <input type="hidden" name="productID" value="<%=p.getProductID()%>"/>
                            <input type="hidden" name="location" value="view"/>
                            <input type="image" src="image/view-eye.png" alt="submit" name="submit" style="width:35px; height:23px;margin-top:5px;"/>
                        </form>
                        <form action="getProductServlet" method="post">
                            <input type="hidden" name="productID" value="<%=p.getProductID()%>"/>
                            <input type="hidden" name="location" value="edit"/>
                            <input type="image" src="image/edit-pen.png" alt="submit" name="submit" style="width:36px; height:28px;"/>
                        </form>
                        <form action="getProductServlet" method="post">
                            <input type="hidden" name="productID" value="<%=p.getProductID()%>"/>
                            <input type="hidden" name="location" value="delete"/>
                            <input type="image" src="image/delete-bin.png" alt="submit" name="submit" style="width:35px; height:28px;"/>
                        </form>
                        </div>
                    </td>
                </tr>
                
                  <%}}request.getSession().removeAttribute("seVa");%>
            
            </table>
            
        <script type="text/javascript">
        function createPopupWin(pageURL, pageTitle,popupWinWidth, popupWinHeight) {
            var left = (screen.width - popupWinWidth) / 2;
            var top = (screen.height - popupWinHeight) / 4;
              
            var myWindow = window.open(pageURL, pageTitle, 
                    'resizable=yes, width=' + popupWinWidth
                    + ', height=' + popupWinHeight + ', top='
                    + top + ', left=' + left);
        }
        </script>
        
        
    </body>
</html>
