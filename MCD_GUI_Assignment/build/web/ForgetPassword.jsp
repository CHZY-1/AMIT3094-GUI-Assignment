

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@ include file="HTML_parts/Meta.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Forget Password</title>
        <style>
            /*Reset margin and padding for all */
            *{
                    margin: 0;
                    padding: 0;
            }

            /*beginning of login and registration*/
            .info
            {
                border: 2px solid #92CAE4;
                background-color: #D5EDF8;
                color: #205791;
                padding:5px;
            }

            .error
            {
                border: 2px solid #FBC2C4;
                background-color: #FBE3E4;
                color: #8A1F11;
                padding:5px;
            }

            body{
              
                background-repeat:repeat;
                width:100%;
            }

            .invalid{
                color:red;
            }

            .login{
                border:1px solid black;
                width:600px;
                padding:50px;
                margin: 100px auto;
                border-radius: 10px;   
                background-image:linear-gradient(#ffb399, #ffff99);
            }

            .login-form label{
                font-size: 22px;
                font-weight: 400;
            }

            .login-form h2{
                text-align:center;

            }

            .login-form h6{
                text-align:center;
                margin-top:10px;
            }

            .form-control {
                position: relative; 
                height: 48px;
                width: 100%;
                font-size: 14px;
                margin-bottom: 15px;
                padding: 10px 30px;
            }

            .btn{
                color:black;
                background-color:#ccccff;
                width: 100%;
                height: 40px;
                font-size: 16px;
                border: 1px solid black;
                border-radius: 5px;
                -webkit-transition: .5s; 
                -moz-transition:.5s; 
                -ms-transition:.5s; 
                -o-transition:.5s;
                transition: .5s;
            }

            .btn:hover{
                background-color:#ffcccc;
                box-shadow: 0 5px 20px rgba(14,15,18,.3);
                color:#003399;
            }
            
            .textarea {
                border: none;
                background-color: transparent;
                resize: none;
                outline: none;
            }
        </style>
    </head>
    <body class="d-flex flex-column min-vh-100"> 
         <%@ include file="HTML_parts/Header.jsp" %>
        <section id="home" class="about-us">
            <div class="login">
                <div class="col-sm-12">
                    <div class="login-form">
                        <h2>Forget Password</h2>
                        <h6>Enter Your Customer ID And Email To Proceed</h6>
                        <br/>
                           
                        <form action="ForgetPasswordServlet" method="POST">
                            <div class="username">
                                <label for="customerID">Customer ID <span style="color:red">*</span>:</label>
                            </div>

                            <div class="col-sm-12">
                                <input type="text" name="customerID" class="form-control" placeholder="Enter your Customer ID">   
                            </div>

                            <div class="email">
                                <label for="email">Email<span style="color:red">*</span>:</label>
                            </div>

                            <div class="col-sm-12">
                                <input type="email" name="email" class="form-control" placeholder="Enter your email address">   
                            </div>


                            <div class="col-sm-12">
                                <button class="btn" type="submit" name="reset-request-submit">Change Your Password</button>
                            </div>
                        </form>

                        <br/>
                        <div>
                            <p>Back <a href="Login.jsp">[Login Page]</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
         <%@ include file="HTML_parts/Footer.jsp" %>
    </body>
</html>
