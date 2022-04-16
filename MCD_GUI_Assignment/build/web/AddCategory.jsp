
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.da.ProductCategoryDA"%>
<%ProductCategoryDA pca=new ProductCategoryDA();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-Add Product Category</title>
    </head>
    <style>
        html{
             background-color: #fff7ed;
            text-align: center;
        }
        form{
            border: 5px solid #ffbb00;
            border-radius: 10px;
            background-color: #ffedbd;
            text-align: center;
            padding: 15px;
            width: 300px;
            margin: auto;
        }
        input[type=submit],button{
             color: black;
             font-weight: bold;
             padding: 5px;
             text-align: center;
             background-color: #ffbb00;
             border-radius: 5px;
             border: none;
             margin: 10px;
             font-size: 20px;
             font-family: sans-serif;
        }
        input[type=submit]:hover,button:hover{
            color: white;
        }
    </style>
    <body>
        <br/><br/>
        <h1>Add Product Category</h1>
        <form action="savePCategory.jsp">
            <%
            String newid=pca.newPCaID();
            %>
            <input type="hidden" name="categoryID" value="<%=newid%>"/>
            Category Name: <input type="text" name="categoryName"/><br/><br/>
            <input type="submit" name="submit" value="Add" style="margin-left: 60px;"/>
            <button onclick="return closeWindow();">Back</button>
            </form>
        
        <script type="text/javascript">
        function closeWindow() {
            let new_window =open(location, '_self');
            new_window.close();
            return false;
        }
    </script>
    </body>
</html>
