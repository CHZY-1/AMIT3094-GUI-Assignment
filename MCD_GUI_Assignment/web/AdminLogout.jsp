

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Logout</title>
        <style>
            html{
                background-color: #fff9e8;
            }
            div.out{
                margin: auto;
                width: 800px;
                border-radius: 10px;
                background-color: #ffe399;
                position: relative;
            }
            a{
                text-decoration: none;
                color: black;
            }
             input[type=submit],button,a{
                background-color: #ffbb00;
                border-radius: 5px;
                border: none;
                padding: 10px;
                margin-right: 25px;
                font-weight: bold;
                font-size: 15px;
            }
            form{
                margin-left: 300px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <br/><br><br/>
        <div class="out">
            <h1 style="text-align: center;padding: 20px;">Are You sure you want to logout?</h1>
            
                <form method="get" action="editAdminSelf" style="float: left;">
                <input type="submit" name="submit" value="Logout"/>
                </form>
            <button onclick="window.location.href='AdminHome.jsp'" >Back</button>
                <!--<a href="AdminHome.jsp" style="margin-bottom: -50px;">Back</a>-->
            <br><br><br>
        </div>
        
    </body>
</html>
