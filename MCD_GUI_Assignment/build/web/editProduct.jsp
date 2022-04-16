

<%@page import="model.da.ProductCategoryDA"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Product"%>
<%@page import="model.domain.ProductCategory"%>
<%@page import="model.da.ProductDA"%>
<%@page import="controller.Control.ProductCategoryController"%>
<%
Product prod=(Product)request.getAttribute("prodObj");
ProductCategoryDA progCaDA=new ProductCategoryDA();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-Edit Product</title>
        <style>
             html{
                margin: auto;
                background-color: #fff7ed;
            }
            
            h1{
                margin: auto;
                justify-content: center;
                background-color: #ffda75;
                border-radius: 20px;
                width: 300px;
                text-align: center;
            }
            td{
                width: 150px;
                height: 10px;
                padding: 10px;
            }
            td:nth-child(2){
                width: 10px;
            }
            table{
                margin: auto;
                border-collapse: collapse;
                background-color: #ffedbd;
                border-radius: 15px;
                box-shadow: 5px 10px 18px #888888;
            }
            .content{
                margin: 50px;
            }
            td{
                padding: 15px;
            }
            input[type=text]{
                border-radius: 5px;
                border:1px solid black;
            }
            input[type=submit],input[type=button],button,a{
                background-color: #ffbb00;
                border-radius: 5px;
                border: none;
                padding: 8px;
                margin-right: 15px;
                font-weight: bold;
                text-decoration: none;
                color: black;
                font-family: Arial;
                font-size: 15px;
            }
              input[type=submit]:hover,input[type=button]:hover,a:hover{
                  color: white;
              }
        </style>
    </head>
    <body>
        <br/><br/>
        <h1>Edit Product</h1>
        <br/><br/>
        <form action="editProductServlet" method="post" enctype="multipart/form-data">
            <table>
                    <tr>
                        <td colspan="3" style="text-align: center;font-weight: bold;height: 20px;font-size: 25px;"><b>Product Detail</b></td>
                    </tr>
                    <tr>
                        <td>Product ID</td>
                        <td>:</td>
                        <td><%=prod.getProductID()%><input type="hidden" name="id" value="<%=prod.getProductID()%>"/></td>
                    </tr>
                    <tr>
                        <td>Product Name</td>
                        <td>:</td>
                        <td><input type="text" name="name" value="<%=prod.getProductName()%>" required=""/></td>
                    </tr>
                    <tr>
                        <td>Price (RM)</td>
                        <td>:</td>
                        <td><input type="text" name="price" value="<%= String.format("%.2f",prod.getProductPrice())%>" required=""/></td>
                    </tr>
                    <tr>
                        <td>Product Image</td>
                        <td>:</td>
                        <td><input type="file" name="image"/></td>
                    </tr>
                    <tr>
                        <td><label for="Category">Product Category</label></td>
                        <td>:</td>
                        <td><select name="category" id="category">
                        <% List<ProductCategory> progCaList=progCaDA.getAllProductCategory();
                        for(ProductCategory c: progCaList){%>
                        <option value="<%= c.getCategoryID()%>" <%= prod.getProductCategory().getCategoryID().equals(c.getCategoryID())?"selected":"" %>><%= c.getCategoryName()%></option>
                        <%}%>
                      </select>
                         </td>
                    </tr>
                    <tr>
                        <td style="color: red;padding-bottom: 15px;">*Note that Product ID cannot be changed.</td>
                        <td style="text-align: center;" colspan="2"><input type="submit" name="submit" value="Edit"/>
                            <a href="AdminMenu.jsp">Back</a>
                        <!---<button onclick="window.location.href='AdminMenu.jsp'">Back</button> -->
                        </td>
                    </tr>
            </table>
        </form>
                     
    </body>
</html>

