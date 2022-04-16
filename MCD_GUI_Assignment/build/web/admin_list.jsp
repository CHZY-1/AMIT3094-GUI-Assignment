<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Staff" %>
<%@page import="model.domain.Role"%>
<%@page import="model.da.StaffDA"%>
<%@page import="model.da.RoleDA"%>
<%
StaffDA staffDA=new StaffDA();
RoleDA roleDA=new RoleDA();
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin-List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            html{
                 background-color: #fff7ed;
            }
            h1{
                text-align: center;
                border-style: outset;
                font-family: Arial;
                border: 5px solid #ffbb00;
                width: 220px;
                margin: auto;
                justify-content: center;
                margin-top: 60px;
                background-color:#ffda75;
            }
            
            table.record{
                border:4px solid black;
                margin:auto;
                font-size:20px;
                overflow: hidden;
                border-spacing: 0;
            }
            
            table.record tr, table.record td, table.record th{
                border: 1pt solid black;
                width: 150px;
                padding:0px 10px;
                height: 40px;
            }
            
            table.record tr:nth-child(odd){
                background-color: #fafafa;
            }
            table.record tr:nth-child(even){
                background-color: #ffedbd;
            }
            .actionButton{
                width: 230px;
            }
            .actionButton input{
                background-color: transparent;
                border:1pt solid transparent;
                padding: 10px;
            }
            .actionButton form{
                float: left;
                margin-right: 10px;
            }
            .all{
                margin: 50px 0px 30px 230px;
                width: 1100px;
            }
            .add{
                text-align: center;
                width: 130px;
                height: 25px;
                margin-right: 15px;
                text-decoration: none;
                background-color: #ffbb00;
                color: black;
                font-weight: bold;
                padding: 6px;
                border: 3px solid black;
                border-radius: 10px;
            }
            button,.button{
                background-color: #ffbb00;
                border-radius: 5px;
            }
        </style>
    </head>
    
    <body>
            <jsp:include page="HTML_parts/AdminHeader.jsp" />
        
            <h1>Staff List</h1>
                <div class="all">
                    <form action="searchAdmin" method="post" style="float:left; margin:0px 500px 0px 20px;height: 20px;">
                        <b style="font-size: 20px;padding-bottom: -5px;">Name: </b>
                        <input type="text" placeholder="Search.." name="search" style="height: 22px;">
                                <input type="hidden" name="place" value="admin"/>
                                <button type="submit" style="padding: 4px;"><i class="fa fa-search"></i></button>
                                <!--<input type="image" src="image/search.png" name="search" class="button" style="width: 20px;height: 20px;padding: 5px;margin-bottom: -10px;"/>-->
                        </form>
                    <a href="JavaScript:createPopupWin('addRole.jsp','Admin-Add Role', 500, 400)" class="add"><b>Add Role</b></a>
                    <a href="AddAdmin.jsp" class="add"><b>Add New Admin</b></a>
                </div>  
            <br/>
                <table class="record">
                <tr style="background-color: #ffda75">
                    <th>Staff ID</th>
                    <th><!--<a href="searchAdmin?order=ASC" style="color: black;text-decoration: none;font: Arial;">Name</a>-->Name</th>
                    <th>Gender</th>
                    <th>Role</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                
                <% 
                        String val="";
                        val=(String)request.getAttribute("seVa");
                        /*String order="";
                        order=(String)request.getAttribute("order");*/
                        List<Staff> staffList=new ArrayList<Staff>();
                        staffList=staffDA.listStaff();
                       
                        
                        if(val!=null && val!=""){
                            staffList=staffDA.getStaffDe(val);
                        }
                        
                        if(val=="!@#$"){
                            staffList=staffDA.listStaff();
                        }
                      
                        
                        for(Staff s: staffList){
                    %>
                    <tr>
                        <td><%= s.getStaffID()%></td>
                        <td><%= s.getName()%></td>
                        <td><%= s.getGender()%></td>
                        <% Role role=roleDA.getRole(s.getRoleID().getRoleID());
                        %>
                        <td><%= role.getRoleName()%></td>
                        <td><%= s.getStatus()%></td>
                        <td>
                            <div class="actionButton"> 
                            <form action="getAdminServlet"  method="post">
                                <input type="hidden" name="id" value="<%= s.getStaffID()%>"/>
                                <input type="hidden" name="location" value="view"/>
                                <input type="image" src="image/view-eye.png" alt="submit" name="submit" style="width:35px; height:23px;margin-top:5px;"/>
                            </form>
                            <form action="getAdminServlet" method="post">
                                <input type="hidden" name="id" value="<%=s.getStaffID()%>"/>
                                <input type="hidden" name="location" value="edit"/>
                                <input type="image" src="image/edit-pen.png" alt="submit" name="submit" style="width:36px; height:28px;"/>
                            </form>
                            <form action="getAdminServlet" method="post">
                                <input type="hidden" name="id" value="<%= s.getStaffID()%>"/>
                                <input type="hidden" name="location" value="delete"/>
                                <input type="image" src="image/delete-bin.png" alt="submit" name="submit" style="width:35px; height:28px;"/>
                            </form>
                            </div>
                        </td>
                    </tr>
                    <%}request.getSession().removeAttribute("seVa");%>
                
            </table>
            
        <script type="text/javascript">
        function createPopupWin(pageURL, pageTitle,popupWinWidth, popupWinHeight) {
            var left = (screen.width - popupWinWidth) / 2;
            var top = (screen.height - popupWinHeight) / 4;
              
            var myWindow = window.open(pageURL, pageTitle, 
                    'resizable=yes, width=' + popupWinWidth
                    + ', height=' + popupWinHeight + ', top='
                    + top + ', left=' + left);
        }
        </script>
        
        
    </body>
</html>
