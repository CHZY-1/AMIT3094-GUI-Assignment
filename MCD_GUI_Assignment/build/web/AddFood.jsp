

<%@page import="model.domain.ProductCategory"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.da.ProductDA"%>
<%@page import="model.da.ProductCategoryDA"%>
<%
ProductDA progDA=new ProductDA();
ProductCategoryDA progCaDA=new ProductCategoryDA();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-Add Food</title>
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
            td:nth-child(1){
                padding-left: 40px;
            }
            tr:nth-child(1){
                padding-top: 40px;
            }
            td:nth-child(2){
                width: 10px;
            }
            table{
                margin: auto;
                border-collapse: collapse;
                background-color: #ffedbd;
                border-radius: 15px;
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
            input[type=submit],input[type=button]{
                background-color: #ffbb00;
                border-radius: 5px;
                border: none;
                padding: 8px;
                margin-right: 15px;
                font-weight: bold;
            }
            input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
          -webkit-appearance: none;
          margin: 0;
        }
        </style>
    </head>
    <body>
        <div class="content">
            <form action="addFoodServlet" method="post" enctype="multipart/form-data">
                <table>
                    <br/> <h1>Add Food</h1><br/><br/>
                    <tr>
                        <td>Product ID</td>
                        <td>:</td>
                        <td><b><%= progDA.newProductID()%></b>
                            <input type="hidden" name="id" value="<%= progDA.newProductID()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Product Name</td>
                        <td>:</td>
                        <td><input type="text" name="name" required/></td>
                    </tr>
                    <tr>
                        <td>Price (RM)</td>
                        <td>:</td>
                        <td><input type="number" step=0.01 name="price" required/></td>
                    </tr>
                    <tr>
                        <td>Product Image</td>
                        <td>:</td>
                        <td><input type="file" name="image" accept=".jpg, .jpeg, .png" required/></td>
                    </tr>
                    <tr>
                        <td><label for="Category">Product Category</label></td>
                        <td>:</td>
                        <td><select name="category" id="category">
                        <% List<ProductCategory> progCaList=progCaDA.getAllProductCategory();
                        for(ProductCategory c: progCaList){%>
                        <option value="<%= c.getCategoryID()%>"><%= c.getCategoryName()%></option>
                        <%}%>
                      </select>
                    </tr>
                    <tr>
                        <td style="color: red;"colspan="2">*Note that Product ID is automatically generated.</td>
                        <td style=""><input type="submit" name="submit"/>
                            <form>
                                <input type="button" value="Back" onclick="history.back()">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
