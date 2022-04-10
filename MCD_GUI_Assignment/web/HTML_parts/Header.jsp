<!DOCTYPE html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $('a').click(function(e){
            $('a').removeClass("active");
            $(this).addClass("active");
        });
  });
</script>

<style>
    .navbar-nav .nav-item.active .nav-link,
    .navbar-nav .nav-item:hover .nav-link {
        color: black !important;
    }
    
    .navbar a{
        font-size: larger;
    }
    
</style>

<div id="primary-nav">
<!-- Navigation / header -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
         <ul class="navbar-nav nav-tabs nav-fill w-100">
             <!---Before Login -->
             <li class="nav-item">
                 <a href="#" class="navbar-brand">Logo</a>
             </li>

             <li class="nav-item">
                 <a href="Home.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/Home.jsp') ? 'active' : ''}">Home</a>
             </li>

             <li class="nav-item">
                 <a href="Menu.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/Menu.jsp') ? 'active' : ''}">Menu</a>
             </li>

             <li class="nav-item">
                 <a href="#" class="nav-link ${pageContext.request.requestURI.endsWith('/Login.jsp') ? 'active' : ''}">Login</a>
             </li>

             <li class="nav-item">
                 <a href="#" class="nav-link ${pageContext.request.requestURI.endsWith('/Register.jsp') ? 'active' : ''}">Register</a>
             </li>
         </ul>
     </div>
</nav>
</div>
       
