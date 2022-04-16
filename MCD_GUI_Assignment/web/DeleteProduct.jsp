

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
        <title>Admin-Delete Admin</title>
        <style>
            html{
                 background-color: #fff7ed;
            }
            h1,h3{
                text-align: center;
            }
            table{
                margin: auto;
                border: 5px solid #ffbb00;
                border-radius: 15px;
                overflow: hidden;
                background-color: #ffedbd;
            }
            td{
                border-collapse: collapse;
                width:200px;
                padding: 10px;
                height: 20px;
            }
            td:nth-child(2){
                width: 10px;
            }
            td:nth-child(1){
                font-weight: bold;
            }
           input[type=submit],button{
             color: black;
             padding: 8px;
             text-align: center;
             background-color: #ffbb00;
             border-radius: 5px;
             border: none;
             margin: 10px;
             font-size: 14px;
             font-family: sans-serif;
             font-weight: bold;
        }
        input[type=submit]:hover,button:hover{
            color: white;
        }
        </style>
    </head>
    <body>
        <h1>Delete Product</h1>
        <h3>Are you sure you want to delete the following Product?</h3>
        <table>
            <tr>
                <td>Product ID</td>
                <td>:</td>
                <td><%=prod.getProductID()%></td>
            </tr>
            <tr>
                <td>Product Name</td>
                <td>:</td>
                <td><%=prod.getProductName()%></td>
            </tr>
            <tr>
                <td>Price</td>
                <td>:</td>
                <td>RM <%= String.format("%.2f",prod.getProductPrice())%></td>
            </tr>
            <tr>
                <td>Product Category</td>
                <td>:</td>
                <td><% ProductCategoryController pcon=new ProductCategoryController();
                    ProductCategory ca=pcon.getProductCategoryByID(prod.getProductCategory().getCategoryID());%>
                    <%=ca.getCategoryName()%></td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2">
                
                    <form method="post" action="delProduct" style="float: left;">
                    <input type="hidden" name="id" value="<%=prod.getProductID()%>"/>
                    <input type="submit" name="submit" value="Delete"/>
                    </form><button onclick="window.location.href='AdminMenu.jsp'">Back</button>
                </td>
            </tr>
        </table>
        
          <script type="text/javascript">
        function closeWindow() {
            let new_window =open(location, '_self');
            new_window.close();
            return false;
        }
    </script>
    </body>
</html>

