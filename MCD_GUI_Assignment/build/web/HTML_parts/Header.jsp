<!DOCTYPE html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $('a').click(function (e) {
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
<% if(session.getAttribute("customer") == null) { %>
<div id="primary-nav">
    <!-- Navigation / header -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <ul class="navbar-nav nav-tabs nav-fill w-100">
                <!---Before Login -->
                <li class="nav-item">
                    <a href="Home.jsp" class="navbar-brand"><img src="image/MCD-logo.png" height="40" width="50" /></a>
                </li>

                <li class="nav-item">
                    <a href="Home.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/Home.jsp') ? 'active' : ''}">Home</a>
                    
                </li>

                <li class="nav-item">
                    <a href="Menu.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/Menu.jsp') ? 'active' : ''}">Menu</a>
                </li>

                <li class="nav-item">
                    <a href="Login.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/Login.jsp') ? 'active' : ''}">Login</a>
                </li>

                <li class="nav-item">
                    <a href="Register.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/Register.jsp') ? 'active' : ''}">Register</a>
                </li>
            </ul>
        </div>
    </nav>
</div>

                <% }else{ %>

<div id="primary-nav">
    <!-- Navigation / header -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <ul class="navbar-nav nav-tabs nav-fill w-100">
                <!---Before Login -->
                <li class="nav-item">
                    <a href="Home.jsp" class="navbar-brand"><img src="image/MCD-logo.png" height="40" width="50" /></a>
                </li>

                <li class="nav-item">
                    <a href="Home.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/Home.jsp') ? 'active' : ''}">Home</a>
                </li>

                <li class="nav-item">
                    <a href="Menu.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/Menu.jsp') ? 'active' : ''}">Menu</a>
                </li>

                <li class="nav-item">
                    <a href="CustomerProfile.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/CustomerProfile.jsp') ? 'active' : ''}">Profile</a>
                </li>

                <li class="nav-item">
                    <a href="Cart.jsp" class="nav-link ${pageContext.request.requestURI.endsWith('/Cart.jsp') ? 'active' : ''}">Cart</a>
                </li>

                <li class="nav-item">
                    <a href="LogoutServlet" class="nav-link ${pageContext.request.requestURI.endsWith('/LogoutServlet') ? 'active' : ''}">Log out</a>
                </li>
            </ul>
        </div>
    </nav>
</div>   

<% } %>