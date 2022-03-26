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
      out.write("        ");
      out.write("<!DOCTYPE html>\n");
      out.write("<!-- Navigation / header -->\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light fixed-top\">\n");
      out.write("    <div class=\"collapse navbar-collapse justify-content-md-center navbarNavDropdown\">\n");
      out.write("         <ul class=\"navbar-nav nav-fill w-100\">\n");
      out.write("             <!---Before Login -->\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"#\" class=\"navbar-brand\">Logo</a>\n");
      out.write("             </li>\n");
      out.write("\n");
      out.write("             <li class=\"nav-item active\">\n");
      out.write("                 <a href=\"#\" class=\"nav-link\">Home</a>\n");
      out.write("             </li>\n");
      out.write("\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"#\" class=\"nav-link\">Menu</a>\n");
      out.write("             </li>\n");
      out.write("\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"#\" class=\"nav-link\">Login</a>\n");
      out.write("             </li>\n");
      out.write("\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"#\" class=\"nav-link\">Register</a>\n");
      out.write("             </li>\n");
      out.write("         </ul>\n");
      out.write("     </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>MCD</h1>\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <body>\n");
      out.write("        <footer class=\"card-footer text-center fixed-bottom\">\n");
      out.write("        <p>MCD</p>\n");
      out.write("         </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
