package org.apache.jsp.HTML_005fparts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function(){\n");
      out.write("        $('.nav a').click(function(){\n");
      out.write("            $('.nav a').removeClass(\"active\");\n");
      out.write("            $(this).addClass(\"active\");\n");
      out.write("        });\n");
      out.write("  });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<!-- Navigation / header -->\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light fixed-top\">\n");
      out.write("    <div class=\"collapse navbar-collapse justify-content-md-center navbarNavDropdown\">\n");
      out.write("         <ul class=\"navbar-nav nav-fill w-100\">\n");
      out.write("             <!---Before Login -->\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                 <a href=\"#\" class=\"navbar-brand\">Logo</a>\n");
      out.write("             </li>\n");
      out.write("\n");
      out.write("             <li class=\"nav-item current\">\n");
      out.write("                 <a href=\"Home.jsp\" class=\"nav-link\">Home</a>\n");
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
