<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.ProductCategory"%>
<jsp:useBean id="pca" class="model.domain.ProductCategory" scope="session"/>
<jsp:setProperty name="pca" property="*"/>
<jsp:useBean id="pcaDA" class="model.da.ProductCategoryDA" scope="application"/>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save Product Category</title>
        <style>
            html{
             background-color: #fff7ed;
            text-align: center;
        }
            input[type=submit]:hover,button:hover{
            color: white;
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
             font-size: 15px;
             font-family: sans-serif;
             margin-left: 130px;
        }
         div{
            border: 5px solid #ffbb00;
            border-radius: 10px;
            background-color: #ffedbd;
            text-align: left;
            padding: 15px;
            width: 300px;
            margin: auto;
        }
        </style>
    </head>
    
    <body>
        <div>
         <%
             boolean match=false;
             int success=0;
             ArrayList<ProductCategory> Pca=pcaDA.getAllProductCategory();
             for(ProductCategory s: Pca){
                 if(s.getCategoryName().toUpperCase().equals(pca.getCategoryName().toUpperCase())){
                     match=true;
                 }
             }
             if(match==false){
                 success=pcaDA.insertNewProductCategory(pca);
             }else{%>
                 <b style="color: red;">The Product Category already exists in the database.</b>
             <%}
              
              
        %>
        <br/><br/>
        
        <% if(success==1){%>
        <b>The new Product Category : <%=pca.getCategoryName()%> has been created successfully.</b>
        <%}else{%>
        <b style="color: red;">An error occur while adding new Product Category.Try again later!</b>
        <%}%>
        <br/><br/>
        <button onclick="return closeWindow();">Close</button>
           <script type="text/javascript">
        function closeWindow() {
            let new_window =open(location, '_self');
            new_window.close();
            return false;
        }
    </script>
    </body>
</html>
