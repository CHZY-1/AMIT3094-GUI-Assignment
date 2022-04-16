
<%@page import="model.domain.Role"%>
<%@page import="model.da.RoleDA"%>
<%@page import="model.da.StaffDA"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Staff"%>
<!DOCTYPE html>

<style>
.sidemenu{
  position: fixed;
  top: 0px;
  left: 0px;
  height: 100%;
  width: 0px;
  background-color: #ebebeb;
  opacity:0.9;
  z-index: 1;
  padding-top: 50px;
  overflow-x: hidden;
  transition: all .5s;
}

.sidemenu a{
  padding: 8px 8px 8px 30px;
  text-decoration: none;
  font-size: 27px;
  color: #616161;
  display: block; 
  font-family:'Enriqueta', arial, serif; 
  
}
.sidemenu p{
background-color: #b0b0b0;
  padding: 8px 8px 0px 30px;
  text-decoration: none;
  font-size: 27px;
  color: black;
  display: block; 
  font-family:'algerian'; 
  width: auto;
  margin: 0;
  border: 2px solid black;
  border-left: none;
  border-right: none;
}
.sidemenu a.personal{
    background-color: #b0b0b0;
    color: #242424;
}

.sidemenu a:hover{
  color: black;
  font-family:'Enriqueta', arial, serif; 
  background-color: white;
  border-radius: 15px;
}

.sidemenu c{
  position: absolute;
  top: 0px;
  right: 25px;
  font-size: 36px;
  margin-left: 32px;
}
a.c:hover{
    background-color: transparent;
}
</style>
<header>
    <%Staff me=(Staff)session.getAttribute("staff");
                StaffDA staffDA=new StaffDA();
                RoleDA roleda=new RoleDA(); 
                me=staffDA.getStaff(me.getStaffID());
                Role myrole=roleda.getRole(me.getRoleID().getRoleID());%>
  <div id="main" onclick="openFunction()" style="font-size: 20px;"><b style="margin-left: 15px;">&#9776; Menu </b></div>
  <div id="menu" class="sidemenu">
      <br/>
      
    <a href="AdminHome.jsp">Dashboard</a>
    <%if(myrole.getSale().equals("True")){%><a href="salesRecord.jsp" >View Sales</a><%}%>
    <%if(myrole.getCustomer().equals("True")){%><a href="CustomerListing.jsp">View Customer</a><%}%>
    <%if(myrole.getMenu().equals("True")){%><a href="AdminMenu.jsp">Maintain Product</a><%}%>
    <%if(myrole.getAdmin().equals("True")){%><a href="admin_list.jsp">Maintain Staff</a><%}%>
    <%if(myrole.getSale().equals("True")){%><a href="report.jsp" >Report</a><%}%>
  
    <a href="#" class="c"onclick="closeFunction()">&times;</a>
</div>

<script>
    function openFunction(){
        document.getElementById("menu").style.width="260px";
        document.getElementById("main").style.marginLeft="88px";
        document.getElementById("main").innerHTML="";
    }
    function closeFunction(){
        document.getElementById("menu").style.width="0px";
        document.getElementById("main").style.marginLeft="15px";
        document.getElementById("main").innerHTML="<b>&#9776; Menu </b>";
    }
</script>
</header> 

