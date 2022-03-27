package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\"\n");
      out.write("            integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- jQuery and Bootstrap Bundle (includes Popper) -->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"\n");
      out.write("            integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("            integrity=\"sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <title>MCD Home Page</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            .carousel-inner > .item > img {\n");
      out.write("                position: absolute;\n");
      out.write("                top: 0;\n");
      out.write("                left: 0;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            /* Fixed image height in bootstraps carousel */\n");
      out.write("            .home-carousel-Img img {\n");
      out.write("                height: 550px;\n");
      out.write("                max-height: 550px;\n");
      out.write("              }\n");
      out.write("              \n");
      out.write("              /*Change Arrow Colors in bootstraps carousel */\n");
      out.write("              .carousel-control-prev-icon {\n");
      out.write("                background-image: url(\"data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23fff' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E\") !important;\n");
      out.write("               }\n");
      out.write("\n");
      out.write("               .carousel-control-next-icon {\n");
      out.write("                 background-image: url(\"data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23fff' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E\") !important;\n");
      out.write("               }\n");
      out.write("               \n");
      out.write("               /*Customize container*/\n");
      out.write("               .custom-container{\n");
      out.write("                   margin-top: 50px;\n");
      out.write("                   margin-bottom: 10px;\n");
      out.write("               }\n");
      out.write("               \n");
      out.write("               .product{\n");
      out.write("                    margin-top:10px;\n");
      out.write("                    margin-bottom:10px;\n");
      out.write("                    border: #cdcdcd medium solid;\n");
      out.write("                    border-radius: 10px;\n");
      out.write("                    -moz-border-radius: 10px;\n");
      out.write("                    -webkit-border-radius: 10px;\n");
      out.write("                }\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"d-flex flex-column min-vh-100\">\n");
      out.write("            ");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function(){\n");
      out.write("        $('a').click(function(e){\n");
      out.write("            $('a').removeClass(\"active\");\n");
      out.write("            $(this).addClass(\"active\");\n");
      out.write("        });\n");
      out.write("  });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    .navbar-nav .nav-item.active .nav-link,\n");
      out.write("    .navbar-nav .nav-item:hover .nav-link {\n");
      out.write("        color: black !important;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .navbar a{\n");
      out.write("        font-size: larger;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<div id=\"primary-nav\">\n");
      out.write("<!-- Navigation / header -->\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("         <ul class=\"navbar-nav nav-tabs nav-fill w-100\">\n");
      out.write("             <!---Before Login -->\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"#\" class=\"navbar-brand\">Logo</a>\n");
      out.write("             </li>\n");
      out.write("\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"Home.jsp\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Home.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Home</a>\n");
      out.write("             </li>\n");
      out.write("\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"#\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Menu.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Menu</a>\n");
      out.write("             </li>\n");
      out.write("\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"#\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Login.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Login</a>\n");
      out.write("             </li>\n");
      out.write("\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"#\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.requestURI.endsWith('/Register.jsp') ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Register</a>\n");
      out.write("             </li>\n");
      out.write("         </ul>\n");
      out.write("     </div>\n");
      out.write("</nav>\n");
      out.write("</div>\n");
      out.write("       \n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div id=\"home-slideshow\" class=\"container\" style=\"margin-top: 5px;\">\n");
      out.write("                <div id=\"home-carousel\" class=\"carousel slide carousel-fade\" data-ride=\"carousel\">\n");
      out.write("                    <ol class=\"carousel-indicators\">\n");
      out.write("                      <li data-target=\"#home-carousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                      <li data-target=\"#home-carousel\" data-slide-to=\"1\"></li>\n");
      out.write("                      <li data-target=\"#home-carousel\" data-slide-to=\"2\"></li>\n");
      out.write("                      <li data-target=\"#home-carousel\" data-slide-to=\"3\"></li>\n");
      out.write("                    </ol>\n");
      out.write("                    <div class=\"carousel-inner\">\n");
      out.write("                      <div class=\"carousel-item home-carousel-Img active\" data-interval=\"3000\">\n");
      out.write("                        <img class=\"rounded img-fluid mx-auto d-block\" src=\"Pictures/MCD-Home1.jpg\" alt=\"First slide\">\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"carousel-item home-carousel-Img\" data-interval=\"3000\">\n");
      out.write("                        <img class=\"rounded img-fluid mx-auto d-block\" src=\"Pictures/MCD-Home2.png\" alt=\"Second slide\">\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"carousel-item home-carousel-Img\" data-interval=\"3000\">\n");
      out.write("                        <img class=\"rounded img-fluid mx-auto d-block\" src=\"Pictures/MCD-Home3.png\" alt=\"Third slide\">\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"carousel-item home-carousel-Img\" data-interval=\"3000\">\n");
      out.write("                        <img class=\"rounded img-fluid mx-auto d-block\" src=\"Pictures/MCD-Home5.png\" alt=\"Fourth slide\">\n");
      out.write("                      </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <a class=\"carousel-control-prev\" href=\"#home-carousel\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                      <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                      <span class=\"sr-only\">Previous</span>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"carousel-control-next\" href=\"#home-carousel\" role=\"button\" data-slide=\"next\">\n");
      out.write("                      <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                      <span class=\"sr-only\">Next</span>\n");
      out.write("                    </a>\n");
      out.write("                 </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div id=\"home-recommend\" class=\"container custom-container bg-light\">\n");
      out.write("                \n");
      out.write("                <div class=\"row mb-3\"><div class=\"col bg-warning rounded d-flex align-items-center justify-content-center\"><h1>Recommended</h1></div></div>\n");
      out.write("                \n");
      out.write("                <div class=\"row text-center mb-3\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <div class=\"product\">\n");
      out.write("                            <h1> Product 1 </h1>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <div class=\"product\">\n");
      out.write("                            <h1> Product 2 </h1>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <div class=\"product\">\n");
      out.write("                            <h1> Product 3 </h1>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div id=\"home-about-us\" class=\"container custom-container bg-light\">\n");
      out.write("                <div class=\"row\"><div class=\"col bg-warning rounded d-flex align-items-center justify-content-center\"><h1>About Us</h1><br/></div></div>\n");
      out.write("                \n");
      out.write("                <div class=\"row\" style=\"margin-bottom: 30px; margin-top: 30px;\">\n");
      out.write("                    <img class=\"img-fluid mx-auto d-block\" src=\"Pictures/MCD-About-us.jpg\" alt=\"\"/>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"row-text-center\">\n");
      out.write("                    <p>McDonald’s is the world’s leading quick service restaurant chain with more than 36,000 \n");
      out.write("                        restaurants worldwide, serving more than 69 million customers daily in over 100 countries. \n");
      out.write("                        In Malaysia, McDonald’s serves over 13.5 million customers a month in 300 restaurants nationwide. \n");
      out.write("                        McDonald’s employs more than 14,000 Malaysians in its restaurants across the nation, providing career, training and development opportunities.\n");
      out.write("                    </p>\n");
      out.write("                </div>            \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"container custom-container\">\n");
      out.write("                <div class=\"row\" style=\"margin-bottom: 40px;\">\n");
      out.write("                    <img class=\"img-fluid mx-auto d-block\" src=\"Pictures/MCD-Home4.png\" alt=\"\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            ");
      out.write("<!DOCTYPE html>\n");
      out.write("<div class=\"container-fluid px-0\">\n");
      out.write("    <div class=\"row no-gutters\">\n");
      out.write("        <div class=\"col-12\">\n");
      out.write("            \n");
      out.write("            <!--  use <body class=\"d-flex flex-column min-vh-100\"></body> to Make Footer Stay at Bottom of Page  -->\n");
      out.write("            <!-- else use .fixed-bottom in footer class (not recommended) -->\n");
      out.write("            <footer class=\"card-footer text-center bg-light mt-auto\">\n");
      out.write("                <p>Footer</p>\n");
      out.write("            </footer>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        \n");
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
