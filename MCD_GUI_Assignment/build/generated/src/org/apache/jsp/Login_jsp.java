package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/HTML_parts/Meta.jsp");
    _jspx_dependants.add("/HTML_parts/Header.jsp");
    _jspx_dependants.add("/HTML_parts/Footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"/>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        \n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n");
      out.write("        \n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Font Awesome icons -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- jQuery and Bootstrap Bundle (includes Popper) -->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"\n");
      out.write("                integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("                integrity=\"sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" \n");
      out.write("        integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <style>\n");
      out.write("            /*Reset margin and padding for all */\n");
      out.write("            *{\n");
      out.write("                    margin: 0;\n");
      out.write("                    padding: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*beginning of login and registration*/\n");
      out.write("            .info\n");
      out.write("            {\n");
      out.write("                border: 2px solid #92CAE4;\n");
      out.write("                background-color: #D5EDF8;\n");
      out.write("                color: #205791;\n");
      out.write("                padding:5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .error\n");
      out.write("            {\n");
      out.write("                border: 2px solid #FBC2C4;\n");
      out.write("                background-color: #FBE3E4;\n");
      out.write("                color: #8A1F11;\n");
      out.write("                padding:5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body{\n");
      out.write("                background-image:url('html_background.jpg');\n");
      out.write("                background-repeat:repeat;\n");
      out.write("                width:100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .invalid{\n");
      out.write("                color:red;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login{\n");
      out.write("                border:1px solid black;\n");
      out.write("                width:600px;\n");
      out.write("                padding:50px;\n");
      out.write("                margin: 100px auto;\n");
      out.write("                border-radius: 10px;   \n");
      out.write("                background-image:linear-gradient(#ffb399, #ffff99);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login-form label{\n");
      out.write("                font-size: 22px;\n");
      out.write("                font-weight: 400;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login-form h2{\n");
      out.write("                text-align:center;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login-form h6{\n");
      out.write("                text-align:center;\n");
      out.write("                margin-top:10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-control {\n");
      out.write("                position: relative; \n");
      out.write("                height: 48px;\n");
      out.write("                width: 100%;\n");
      out.write("                font-size: 14px;\n");
      out.write("                margin-bottom: 15px;\n");
      out.write("                padding: 10px 30px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn{\n");
      out.write("                color:black;\n");
      out.write("                background-color:#ccccff;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 40px;\n");
      out.write("                font-size: 16px;\n");
      out.write("                border: 1px solid black;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                -webkit-transition: .5s; \n");
      out.write("                -moz-transition:.5s; \n");
      out.write("                -ms-transition:.5s; \n");
      out.write("                -o-transition:.5s;\n");
      out.write("                transition: .5s;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn:hover{\n");
      out.write("                background-color:#ffcccc;\n");
      out.write("                box-shadow: 0 5px 20px rgba(14,15,18,.3);\n");
      out.write("                color:#003399;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .textarea {\n");
      out.write("                border: none;\n");
      out.write("                background-color: transparent;\n");
      out.write("                resize: none;\n");
      out.write("                outline: none;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body class=\"d-flex flex-column min-vh-100\">\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $('a').click(function (e) {\n");
      out.write("            $('a').removeClass(\"active\");\n");
      out.write("            $(this).addClass(\"active\");\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    .navbar-nav .nav-item.active .nav-link,\n");
      out.write("    .navbar-nav .nav-item:hover .nav-link {\n");
      out.write("        color: black !important;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navbar a{\n");
      out.write("        font-size: larger;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</style>\n");
 if(session.getAttribute("customer") == null) { 
      out.write("\n");
      out.write("<div id=\"primary-nav\">\n");
      out.write("    <!-- Navigation / header -->\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <ul class=\"navbar-nav nav-tabs nav-fill w-100\">\n");
      out.write("                <!---Before Login -->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"Home.jsp\" class=\"navbar-brand\"><img src=\"image/MCD-logo.png\" height=\"40\" width=\"50\" /></a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"Home.jsp\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Home.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Home</a>\n");
      out.write("                    \n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"Menu.jsp\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Menu.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Menu</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"Login.jsp\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Login.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Login</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"Register.jsp\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Register.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Register</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("                ");
 }else{ 
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"primary-nav\">\n");
      out.write("    <!-- Navigation / header -->\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <ul class=\"navbar-nav nav-tabs nav-fill w-100\">\n");
      out.write("                <!---Before Login -->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"Home.jsp\" class=\"navbar-brand\"><img src=\"image/MCD-logo.png\" height=\"40\" width=\"50\" /></a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"Home.jsp\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Home.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Home</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"Menu.jsp\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Menu.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Menu</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"CustomerProfile.jsp\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/CustomerProfile.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Profile</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"Cart.jsp\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Cart.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Cart</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"LogoutServlet\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/LogoutServlet') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Log out</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("</div>   \n");
      out.write("\n");
 } 
      out.write("\n");
      out.write("        <section id=\"home\" class=\"about-us\">\n");
      out.write("            <div class=\"login\">\n");
      out.write("                <div class=\"col-sm-12\">\n");
      out.write("                    <div class=\"login-form\">\n");
      out.write("                        <h2>LOGIN</h2>\n");
      out.write("                        <h6>Welcome Back !</h6>\n");
      out.write("                        <br/><br/>\n");
      out.write("                        <!-- JAVA CODE HERE -->\n");
      out.write("                            ");

                            if(request.getParameter("errMsg") != ""  || request.getParameter("errMsg") != null){ 
                            
      out.write("  \n");
      out.write("                                <pre class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errMsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</pre>\n");
      out.write("                            ");

                              }
                            
      out.write("\n");
      out.write("                            \n");
      out.write("                            ");

                            if(request.getParameter("successMsg") != "" || request.getParameter("successMsg") != null){
                                
                            
      out.write("  \n");
      out.write("                                <pre class=\"info\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${successMsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</pre>\n");
      out.write("                            ");

                              }
                            
      out.write("\n");
      out.write("                        <form action=\"LoginServlet\" method=\"POST\">\n");
      out.write("                            <div>\n");
      out.write("                                <div class=\"email\">\n");
      out.write("                                    <label for=\"username\">Customer ID<span style=\"color:red\">*</span>:</label>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-12\">\n");
      out.write("                                    <input type=\"text\" name=\"customerID\" class=\"form-control\" placeholder=\"Eg: CUST-001\" size=\"16\" value=\"\" />\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div>\n");
      out.write("                                <div class=\"password\">\n");
      out.write("                                    <label for=\"password\">Password<span style=\"color:red\">*</span>:</label>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-12\">\n");
      out.write("                                    <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Eg : abc1234\" size=\"16\" required> \n");
      out.write("                                </div><br/>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"col-sm-12\">\n");
      out.write("                                <button class=\"btn\" type=\"submit\" name=\"submit\" id=\"submit\" value=\"Submit\">Login</button>\n");
      out.write("                            </div><br/>\n");
      out.write("                            \n");
      out.write("                            <div class=\"col-sm-12\">\n");
      out.write("                                <button class=\"btn\" name=\"refresh\" type=\"button\" id=\"refresh\" onclick=\"location = 'Login.jsp'\">Reset</button>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                        <br/>\n");
      out.write("                        \n");
      out.write("                        <div>\n");
      out.write("                            <p>Have yet to sign up ? <a href=\"Register.jsp\"> Create Account</a></p>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div>\n");
      out.write("                            <p>Forget Your Password ? <a href=\"ForgetPassword.jsp\" >Forget Password</a></p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("    \n");
      out.write("            ");
      out.write("<!DOCTYPE html>\n");
      out.write("<div class=\"container-fluid px-0\">\n");
      out.write("    <div class=\"row no-gutters\">\n");
      out.write("        <div class=\"col-12\">\n");
      out.write("            \n");
      out.write("            <!--  use <body class=\"d-flex flex-column min-vh-100\"></body> to Make Footer Stay at Bottom of Page  -->\n");
      out.write("            <!-- else use .fixed-bottom in footer class (not recommended) -->\n");
      out.write("            <footer class=\"card-footer text-center bg-light mt-auto\">\n");
      out.write("                <div class=\"text-center text-ucase\">COPYRIGHT RESERVED © 2014 BY MCDONALD'S &trade;</div>\n");
      out.write("            </footer>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
