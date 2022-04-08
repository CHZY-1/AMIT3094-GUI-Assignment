
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirect</title>
    </head>
    <body>
        <form action="uploadFileServlet1" method="POST" enctype="multipart/form-data">
            Image<input type = "file" name = "file" accept=".jpg, .jpeg, .png"/><br/>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
