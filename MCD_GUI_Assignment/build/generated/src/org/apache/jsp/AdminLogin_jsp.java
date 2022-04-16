package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
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
      out.write("    <body>\n");
      out.write("        <section id=\"home\" class=\"about-us\">\n");
      out.write("            <div class=\"login\">\n");
      out.write("                <div class=\"col-sm-12\">\n");
      out.write("                    <div class=\"login-form\">\n");
      out.write("                        <h2>Admin Login</h2>\n");
      out.write("                        <h6>Welcome Back !</h6>\n");
      out.write("                        ");

                            if(request.getParameter("errMsg") != ""  || request.getParameter("errMsg") != null){ 
                            
      out.write("  \n");
      out.write("                                <p><pre class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errMsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</pre></p>\n");
      out.write("                            ");

                              }
                        
      out.write("\n");
      out.write("                        <br/>\n");
      out.write("                        <!-- JAVA CODE HERE -->\n");
      out.write("                        <form action=\"AdminLoginServlet\" method=\"POST\">\n");
      out.write("                            <div>\n");
      out.write("                                <div class=\"email\">\n");
      out.write("                                    <label for=\"username\">Staff ID<span style=\"color:red\">*</span>:</label>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-12\">\n");
      out.write("                                    <input type=\"text\" name=\"staffID\" class=\"form-control\" \n");
      out.write("                                           placeholder=\"Eg: SF-001\" size=\"16\" value=\"\"\n");
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
      out.write("                                <button class=\"btn\" type=\"submit\" name=\"submit\" id=\"submit\" value=\"Submit\" required>Login</button>\n");
      out.write("                            </div><br/>\n");
      out.write("                            \n");
      out.write("                            <div class=\"col-sm-12\">\n");
      out.write("                                <button class=\"btn\" name=\"refresh\" type=\"button\" id=\"refresh\" onclick=\"\">Reset</button>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                        <br/>\n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
