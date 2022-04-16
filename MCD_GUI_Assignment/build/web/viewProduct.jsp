
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Product"%>
<%@page import="model.domain.ProductCategory"%>
<%@page import="model.da.ProductDA"%>
<%@page import="controller.Control.ProductCategoryController"%>
<%
Product prod=(Product)request.getAttribute("prodObj");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-View Profile</title>
        <style>
            html{
                 background-color: #fff7ed;
            }
            img{
                margin: 50px;
                width: 300px;
                height: 250px;
                border-radius: 15px;
                border: 5px solid #ffda75;
            }
            .image{
                text-align: center;
                margin: auto;
                border-color: #ffda75;
            }
            h1{
                padding: 20px 0px 30px;
                margin: auto;
                text-align: center;
            }
            table td{
                width:220px;
                height: 33px;
                padding-left: 10px;
                
            }
            td:nth-child(1){
                font-weight: bold;
                width: 150px;
                
            }
            td:nth-child(2){
                width: 5px;
            }
             td:nth-child(3){
                width: 220px;
                padding-right: 15px;
            }
            table{
                margin: auto;
                padding: 10px;
                background-color: #ffedbd;
                border-radius: 15px;
                box-shadow: 5px 10px 18px #888888;
                overflow: hidden;
                border-collapse: collapse;
            }
            .title{
                text-align: center;
                background-color: #ffba6b;
                border-radius: 10px;
                font-size: 18px;
                border: 20px solid transparent;
            }
            input[type=submit],input[type=button],button{
                color: black;
                font-weight: bold;
                background-color: #ffbb00;
                border-radius: 5px;
                padding: 5px;
                border: none;
                text-decoration: none;
                font-size: 15px;
                width: 50px;
            }
            input[type=submit]:hover,input[type=button]:hover,button:hover{
                color: white;
            }
            form{
                float: left;
                margin: 20px;
            }
            .detail{
                padding-left: 100px;
            }
        </style>
    </head>
    <body>
        <h1>Product Detail</h1>
        <div class="overall">
            <table>
            <tr>
                    <td colspan="3" class="image"><img class="card-img-top rounded" src="data:image/jpg;base64,<%= prod.getProductImageBase64()%>" alt="<%= prod.getProductName()%>"></td>
            </tr>
            <tr >
                <td class="detail">Product ID</td>
                <td>:</td>
                <td><%=prod.getProductID()%></td>
            </tr>
            <tr >
                <td class="detail">Product Name</td>
                <td>:</td>
                <td><%=prod.getProductName()%></td>
            </tr>
            <tr>
                <td class="detail">Price</td>
                <td>:</td>
                <td>RM <%= String.format("%.2f",prod.getProductPrice())%></td>
            </tr>
            <tr>
                <td class="detail">Product Category</td>
                <td>:</td>
                <td><% ProductCategoryController pcon=new ProductCategoryController();
                    ProductCategory ca=pcon.getProductCategoryByID(prod.getProductCategory().getCategoryID());%>
                    <%=ca.getCategoryName()%></td>
            </tr>
            <tr>
                <td colspan="3">
                    <form action="getProductServlet" method="post" style="margin-left: 250px;">
                            <input type="hidden" name="productID" value="<%=prod.getProductID()%>"/>
                            <input type="hidden" name="location" value="edit"/>
                        <input type="submit" name="name" value="Edit"/>
                        </form>
                        <button onclick="window.location.href='AdminMenu.jsp'" style="margin-top: 20px;">Back</button>
                    
                </td>
            </tr>
                </table>
        </div>
    </body>
</html>

