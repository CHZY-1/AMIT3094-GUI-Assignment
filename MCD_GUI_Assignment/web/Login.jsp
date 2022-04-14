<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Login</title>
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
                background-image:url('html_background.jpg');
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
    
    <body>
        <section id="home" class="about-us">
            <div class="login">
                <div class="col-sm-12">
                    <div class="login-form">
                        <h2>LOGIN</h2>
                        <h6>Welcome Back !</h6>
                        <br/><br/>
                        <!-- JAVA CODE HERE -->
                            <%
                            if(request.getParameter("errMsg") != ""  || request.getParameter("errMsg") != null){ 
                            %>  
                            <pre class="error">${errMsg}</pre>
                            <%
                              }
                            %>
                            
                            <%
                            if(request.getParameter("successMsg") != "" || request.getParameter("successMsg") != null){
                                
                            %>  
                            <pre class="info">${successMsg}</pre>
                            <%
                              }
                            %>
                        <form action="LoginServlet" method="POST">
                            <div>
                                <div class="email">
                                    <label for="username">Customer ID<span style="color:red">*</span>:</label>
                                </div>

                                <div class="col-sm-12">
                                    <input type="text" name="customerID" class="form-control" 
                                           placeholder="Eg: CU-001" size="16" value="">
                                </div>
                            </div>
                            
                            <div>
                                <div class="password">
                                    <label for="password">Password<span style="color:red">*</span>:</label>
                                </div>

                                <div class="col-sm-12">
                                    <input type="password" name="password" class="form-control" placeholder="Eg : abc1234" size="16" required> 
                                </div><br/>
                            </div>
                            
                            <div class="col-sm-12">
                                <button class="btn" type="submit" name="submit" id="submit" value="Submit">Login</button>
                            </div><br/>
                            
                            <div class="col-sm-12">
                                <button class="btn" name="refresh" type="button" id="refresh" onclick="location = 'Login.jsp'">Reset</button>
                            </div>
                        </form>
                        <br/>
                        
                        <div>
                            <p>Have yet to sign up ? <a href="Register.jsp"> Create Account</a></p>
                        </div>
                        
                        <div>
                            <p>Forget Your Password ? <a href="ForgetPassword.jsp" >Forget Password</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
