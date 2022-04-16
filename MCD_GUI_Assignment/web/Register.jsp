
<%--<%@page import="java.sql.PreparedStatement"%>--%>
<%@page import="model.domain.Customer"%>
<%@page import="model.da.CustomerDA"%>
<%@page import="controller.Control.CustomerControl"%>
<jsp:useBean id="cust" class="model.domain.Customer" scope="session" />
<jsp:useBean id="custControl" class="controller.Control.CustomerControl" scope="session" />
<%--<jsp:useBean id="custDA" class="da.CustomerDA" scope="application" />--%>
<%--<jsp:setProperty name= "cust" property = "customerID" value=""/>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CustomerDA customerDA = new CustomerDA();
    String newID = customerDA.generateLatestID();
%>
<!DOCTYPE html>

<html>
    <head>
        <%@ include file="HTML_parts/Meta.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
        crossorigin="anonymous">
        <title>Registration</title>
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
            .registration{
                border:1px solid white;
                width:700px;
                padding:50px;
                margin:250px auto;
                border-radius:10px;
                background-image:linear-gradient(#ffb399, #ffff99);
            }
            
            input::-webkit-outer-spin-button,
            input::-webkit-inner-spin-button{
                -webkit-appearance: none;
                margin: 0;
            }
        </style>
        
    </head>
    <body class="d-flex flex-column min-vh-100">
        <%@ include file="HTML_parts/Header.jsp" %>
        <section id="home" class="about-us">
            <div class="registration">
                <div class="login-form">
                    <h2>Register</h2>
                    <h6>Welcome to registration</h6>
                    <br/>  

                    <%
                        if(request.getParameter("errMsg") != ""){
                    %>
                        <br/><p><pre class="error">${errMsg}</pre></p><br/>
                    <%
                        }
                    %>
   
                    <form action="RegisterServlet" method="POST">
                        <!-- Customer ID. Need to inform the customer that this one need to remember 
                        no need to let user key in. This is auto generated-->
                        <div class = "col-sm-12">
                            <label for="name" class="register">Customer ID:</label><span class="text-danger">*</span>
                            <input style="border:none; background-color: transparent; resize: none; outline: none;" 
                                   type="text" name="customerID" readonly="" value="<%=newID%>"/>
                            <p class = "info">This Customer ID is important and thus 
                                need to remember your customer ID as it is needed 
                                when you want to log into you page</p>
                        </div>
                        <br/>
                        <div class="col-sm-12">
                            <label for="name" class="register">Customer Name:</label><span class="text-danger">*</span>
                            <input type="text" id="firstname" name="customerName" class="form-control register" 
                            placeholder="eg : SIleNcE" size="16" value="" required>
                        </div>

                        <div class="col-sm-12">
                            <label for="e-mail" class="register">E-mail : </label><span class="text-danger">*</span>
                            <input type="email" id="email" name="email" class="form-control register" 
                                   placeholder="eg : barren@gmail.com" 
                                   value="" required>
                        </div>
                        
                        <div class="col-sm-12">
                            <label> Mobile Number :</label><br/>
                            <input type="tel" name="phoneNo" class="form-control register" 
                            placeholder="eg : 011-12345678" size="13" value="" required>
                        </div>
                        
                        <div class="col-sm-12">
                            <label>Address Street :</label><br/>
                            <input type="text" name="addressStreet" class="form-control register"
                                   placeholder="eg : 30, Jalan Rozhan 1, Taman Rozhan" value="" required>
                        </div>
                        
                        <div class="col-sm-12">
                            <label>Postcode :</label><br/>
                            <input type="number" name="postcode" class="form-control register"
                                   placeholder="eg : 14000" value="" min="0" max="999999"  required >
                        </div>
                        
                        <div class="col-sm-12">
                            <label>Address State :</label><br/>
                            <select name="addressState" id="State" class="form-control register">
                                <option value="Johor">Johor</option>
                                <option value="Kedah">Kedah</option>
                                <option value="Kelantan">Kelantan</option>
                                <option value="Melaka">Melaka</option>
                                <option value="Negeri Sembilan">Negeri Sembilan</option>
                                <option value="Pahang">Pahang</option>
                                <option value="Penang">Penang</option>
                                <option value="Perak">Perak</option>
                                <option value="Perlis">Perlis</option>
                                <option value="Sabah">Sabah</option>
                                <option value="Sarawak">Sarawak</option>
                                <option value="Selangor">Selangor</option>
                                <option value="Terengganu">Terengganu</option>
                            </select>
                        </div>

                        <div class="col-sm-12">
                            <label for="password" class="register"> Password : </label><span class="text-danger">*</span>
                            <input id="loginPwdChage" type="password" name="password" 
                                   class="form-control register" placeholder="Eg : abc1234" size="13" required>
                        </div>

                        <div class="col-sm-12">
                            <label for="cfmpassword" class="register"> Confirm Password : </label><span class="text-danger">*</span>
                            <input id="loginPwdChage" type="password" name="cfmpassword" 
                                   class="form-control register" placeholder="Eg : abc1234" size="13" required>
                        </div>

                        <br/>

                        <div class="col-sm-12">
                            <button class="btn" name="submit" type="submit">Register</button>
                        </div>

                        <br/>

                        <div class="col-sm-12">
                            <button class="btn" name="refresh" type="button" id="refresh"
                            onclick="location = 'Register.jsp'">Reset</button>
                        </div>

                        <input type="hidden" name="submit" value="true">
                    </form>

                    <div>
                        <br>
                        Already have an account? <a href="Login.jsp">Login Here</a>
                    </div>
                </div>
            </div>
        </section>
        <%@ include file="HTML_parts/Footer.jsp" %>
    </body>
</html>      

