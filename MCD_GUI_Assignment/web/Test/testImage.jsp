<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <img src="data:image/jpg;base64,${productImage2}" width="300" height="300"/>
        <img src="data:image/jpg;base64,${productImage1}" width="300" height="300"/>
        <p>${imageByte}</p>
    </body>
</html>
