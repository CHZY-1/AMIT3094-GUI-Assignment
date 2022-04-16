<%@page import="model.domain.Customer"%>
<%@page import="model.da.CustomerDA"%>
<%@page import="model.domain.Staff"%>
<%@page import="model.da.StaffDA"%>
<%@page import="model.da.RoleDA"%>
<%@page import="model.domain.Role"%>
<%@page import="model.domain.Product"%>
<%@page import="model.domain.ProductCategory"%>
<%@page import="model.da.ProductCategoryDA"%>
<%@page import="model.da.ProductDA"%>
<%@page import="java.text.SimpleDateFormat,java.text.DateFormat,java.io.*,java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>Admin-Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
              html{
                background-color: #fff9e8;
              }
            .header{
                margin: -8px -8px 0px -8px;
                padding: 2px;
                background-color: #ebebeb;
                display: flex;
                flex-direction: row;
                flex-wrap: wrap;
            }
            
            .third img{
                border-radius: 50%;
                width: 50px;
                height: 50px;
            }
            .first{
                flex:7 1;
                display: flex;
                align-items: center;
            }
            .second{
                display: flex;
                align-items: center;
                flex:4 1;
                font-size: 18px;
            }
            .third{ 
                flex:2 1;
                font-size: 20px;
                display: flex;
                align-items: center;
                font-weight: bold;
            }
            
            .content,.secondRow{
                display: flex;
                margin: 30px;
            }
            .order-table,.sale-table,.customer-table,.admin-table,.menu-table{
                padding: 10px;
                background-color: #ffedbd;
                border-radius: 15px;
                box-shadow: 5px 10px 18px #888888;
                flex-direction: row;
                flex-wrap: wrap;
                overflow: hidden;
                border-collapse: collapse;
                margin: 40px;
                margin-left: 70px;
            }
            
            .order b,.sale b,.customer b,.admin b,.menu b{
                margin: 25px;
                line-height: 40px;
                font-size: 20px;
            }
            
            .order b,.sale b,.cusR,.admin b,.menu b{
                line-height: 46px;
            }
            .head{
                font-size: 25px;
                background-color: #ffda75;
            }
            a.direct{
                background-color: #ffbb00;
                text-decoration: none;
                color: black;
                text-align: center;
                padding: 6px;
                border-radius: 10px;
                font-size: 15px;
                margin:0px 20px 0px 40px;
            }
            .center{
                text-align: center;
                padding-left: 45px;
            }
            a{
                text-decoration: none;
                color:black;
            }
        </style>
    </head>
    <body>
         <%Staff me=(Staff)session.getAttribute("staff");
                StaffDA staffDA=new StaffDA();
                RoleDA roleda=new RoleDA(); 
                me=staffDA.getStaff(me.getStaffID());
                Role myrole=roleda.getRole(me.getRoleID().getRoleID());%>
                
        <div class="header">
            <div class="first">
                <jsp:include page="HTML_parts/AdminHeader.jsp" />
                <img src="image/logo.png" style="width: 90px; height: 65px;margin:0px 20px 0px 20px;"/>
                <h2>Admin Dashboard</h2>
            </div>
            <div class="second">
                <%
                    Date date = new Date( );
                    SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a EEEEE',' dd MMMMM yyyy");
                %>
                <b><%=ft.format(date)%></b>
            </div>
            <div class="third">
                <img src=<%= me.getGender().equals("Male")?"image/man.png":"image/lady1.jpg" %> alt="avatar"/>
                <span style="margin-left: 12px;"><a href="getAdminServlet?ID=<%=me.getStaffID()%>&location=viewSelf"><%=me.getName()%></a></span>
            </div>
        </div>
            
            <div class="content">
               
                <%if(myrole.getCustomer().equals("True")){ %>
                <div class="customer">
                    <table class="customer-table">
                        <tr class="head">
                            <td  class="cusR"><b>New Customer</b></td>
                            <td><a href="CustomerListing.jsp" class="direct">View All Customer</a></td>
                        </tr>
                        <%CustomerDA custDA=new CustomerDA();
                        List<Customer> cust=custDA.listNewCustomer();
                        int i=1;
                        for(Customer c: cust){
                        %>
                        
                            <%if(i==1){%>
                            <tr>
                                <td><b>1<sup>st</sup></b></td>
                                <td><b>:<span style="padding-left: 25px;"><%=c.getCustomerName()%></span> </b></td>
                            </tr>
                            <%}%>

                            <%if(i==2){%>
                            <tr>
                                <td><b>2<sup>nd</sup></b></td>
                                <td><b>:<span style="padding-left: 25px;"><%=c.getCustomerName()%></span> </b></td>
                            </tr>
                            <%}%>

                            <%if(i==3){%>
                            <tr>
                                <td><b>3<sup>rd</sup></b></td>
                                <td><b>:<span style="padding-left: 25px;"><%=c.getCustomerName()%></span> </b></td>
                            </tr>
                            <%}%>

                        <%i=i+1;}%>
                    </table>
                </div>
                <%}%>
                <%if(myrole.getMenu().equals("True")){ %>
                <div class="menu">
                    <table class="menu-table">
                        <tr class="head">
                            <td><b>Menu</b></td>
                            <td><a href="AdminMenu.jsp" class="direct">View All Product</a></td>
                        </tr>
                        <%ProductDA prodDA=new ProductDA();
                        ProductCategoryDA prodCADa=new ProductCategoryDA();
                        List <ProductCategory> prodCa=new ArrayList<ProductCategory>();
                        prodCa=prodCADa.getAllProductCategory();
                        
                        for(ProductCategory pc:prodCa){%>
                         <tr>
                            <td><b><%=pc.getCategoryName()%></b></td>
                            <td><b>:<span class="center"><%List<Product> prod=prodDA.getAllProductByCategory(pc.getCategoryID());%><%=prod.size()%></span> </b></td>
                        </tr>
                        <%}%>
                      
                    </table>
                </div>
                <%}%>
                 <%if(myrole.getAdmin().equals("True")){ %>
                <div class="admin">
                    <table class="admin-table">
                        <tr class="head">
                            <td><b>Staff</b></td>
                            <td><a href="admin_list.jsp" class="direct">View All Admin</a></td>
                        </tr>
                        <%
                        List<Role> role=roleda.listRole();
                        for(Role r:role){
                        %>
                        <tr>
                            <td><b><%=r.getRoleName()%></b></td>
                            <td><b>:<span class="center"><%List<Staff> stf=staffDA.listStaffByRole(r.getRoleID());%><%=stf.size()%></span> </b></td>
                        </tr>
                        <%}%>
                   
                    </table>
                </div>
                <%}%>
              
              
            </div>
            <div class="secondRow">
                
               
            </div>
    </body>
</html>
