package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Order_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("       ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"/>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
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
      out.write("    <title>Order</title>\n");
      out.write("    \n");
      out.write("    <!-- Latest compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("    <!-- jQuery library -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Latest compiled JavaScript -->\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("    \n");
      out.write("   \n");
      out.write("    \n");
      out.write("    <style></style>\n");
      out.write("    \n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body class=\"d-flex flex-column min-vh-100\">\n");
      out.write("      \n");
      out.write("     ");
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
      out.write("    \n");
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
      out.write("\n");
      out.write("    <div class=\"container bg-light mx-auto border\">\n");
      out.write("      <div class=\"py-5 text-center\">\n");
      out.write("        <h1>Order Details</h1>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"row\">\n");
      out.write("          \n");
      out.write("          <div class=\"col-md-4 order-md-2 mb-4\">\n");
      out.write("            \n");
      out.write("              <div class=\"p-2 border\">\n");
      out.write("                    <h4 class=\"d-flex justify-content-between align-items-center mb-3\">\n");
      out.write("                        <span class=\"text-muted pl-3\">Products</span>\n");
      out.write("                      <span class=\"badge badge-secondary badge-pill\">3</span>\n");
      out.write("                    </h4>\n");
      out.write("\n");
      out.write("                      <ul class=\"list-group mb-3\">\n");
      out.write("\n");
      out.write("                      <li class=\"list-group-item d-flex justify-content-between lh-condensed\">\n");
      out.write("                        <div>\n");
      out.write("                          <h4 class=\"my-0\">Product name</h4>\n");
      out.write("                          <small class=\"text-muted\">Brief description</small>\n");
      out.write("                        </div>\n");
      out.write("                        <span class=\"text-muted\">$12</span>\n");
      out.write("                      </li>\n");
      out.write("\n");
      out.write("                      <li class=\"list-group-item d-flex justify-content-between bg-light\">\n");
      out.write("                        <div class=\"text-success\">\n");
      out.write("                          <small class=\"my-0\">Taxes and Delivery Fees</small>\n");
      out.write("                        </div>\n");
      out.write("                        <span class=\"text-success\">+ $5</span>\n");
      out.write("                      </li>\n");
      out.write("\n");
      out.write("                      <li class=\"list-group-item d-flex justify-content-between\">\n");
      out.write("                        <span>Total (MYR)</span>\n");
      out.write("                        <strong>$20</strong>\n");
      out.write("                      </li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <form class=\"card p-2\">\n");
      out.write("                      <div class=\"input-group\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Promo code\">\n");
      out.write("                        <div class=\"input-group-append\">\n");
      out.write("                          <button type=\"submit\" class=\"btn btn-secondary rounded mt-2 ml-1\">Redeem</button>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                    </form>\n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("              <div class=\"\" style=\"margin-top: 40px;\">\n");
      out.write("                  \n");
      out.write("                  <h4 class=\"d-flex justify-content-between align-items-center mb-3\">\n");
      out.write("                      <span class=\"text-muted\" style=\"padding-left:5px;\">Address</span>\n");
      out.write("                  </h4>\n");
      out.write("\n");
      out.write("                      <ul class=\"list-group mb-3\">\n");
      out.write("\n");
      out.write("                      <li class=\"list-group-item d-flex justify-content-between lh-condensed\">\n");
      out.write("                        <div>\n");
      out.write("                          <h4 class=\"my-0\">Product name</h4>\n");
      out.write("                          <small class=\"text-muted\">Brief description</small>\n");
      out.write("                        </div>\n");
      out.write("                        <span class=\"text-muted\">$12</span>\n");
      out.write("                      </li>\n");
      out.write("\n");
      out.write("                      <li class=\"list-group-item d-flex justify-content-between bg-light\">\n");
      out.write("                        <div class=\"text-success\">\n");
      out.write("                          <small class=\"my-0\">Delivery Fee</small>\n");
      out.write("                        </div>\n");
      out.write("                        <span class=\"text-success\">+ $5</span>\n");
      out.write("                      </li>\n");
      out.write("\n");
      out.write("                      <li class=\"list-group-item d-flex justify-content-between\">\n");
      out.write("                        <span>Total (MYR)</span>\n");
      out.write("                        <strong>$20</strong>\n");
      out.write("                      </li>\n");
      out.write("                    </ul>\n");
      out.write("                  \n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("        </div>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          <!-- Product -->\n");
      out.write("          \n");
      out.write("        <div class=\"col-md-8 order-md-1 border\">\n");
      out.write("            \n");
      out.write("            <div class=\"col\">\n");
      out.write("            <h4 class=\"mb-3\">My Products</h4>\n");
      out.write("                <form class=\"needs-validation\" novalidate>\n");
      out.write("                  <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6 mb-3\">\n");
      out.write("                      <label for=\"firstName\">First name</label>\n");
      out.write("                      <input type=\"text\" class=\"form-control\" id=\"firstName\" placeholder=\"\" value=\"\" required>\n");
      out.write("                      <div class=\"invalid-feedback\">\n");
      out.write("                        Valid first name is required.\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6 mb-3\">\n");
      out.write("                      <label for=\"lastName\">Last name</label>\n");
      out.write("                      <input type=\"text\" class=\"form-control\" id=\"lastName\" placeholder=\"\" value=\"\" required>\n");
      out.write("                      <div class=\"invalid-feedback\">\n");
      out.write("                        Valid last name is required.\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"col\">\n");
      out.write("            <h4 class=\"mb-3\">Shipping Options</h4>\n");
      out.write("                <form class=\"needs-validation\" novalidate>\n");
      out.write("                  <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6 mb-3\">\n");
      out.write("                      <label for=\"firstName\">First name</label>\n");
      out.write("                      <input type=\"text\" class=\"form-control\" id=\"firstName\" placeholder=\"\" value=\"\" required>\n");
      out.write("                      <div class=\"invalid-feedback\">\n");
      out.write("                        Valid first name is required.\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6 mb-3\">\n");
      out.write("                      <label for=\"lastName\">Last name</label>\n");
      out.write("                      <input type=\"text\" class=\"form-control\" id=\"lastName\" placeholder=\"\" value=\"\" required>\n");
      out.write("                      <div class=\"invalid-feedback\">\n");
      out.write("                        Valid last name is required.\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("          <h4 class=\"mb-3\">Billing address</h4>\n");
      out.write("          <form class=\"needs-validation\" novalidate>\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-md-6 mb-3\">\n");
      out.write("                <label for=\"firstName\">First name</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"firstName\" placeholder=\"\" value=\"\" required>\n");
      out.write("                <div class=\"invalid-feedback\">\n");
      out.write("                  Valid first name is required.\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-6 mb-3\">\n");
      out.write("                <label for=\"lastName\">Last name</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"lastName\" placeholder=\"\" value=\"\" required>\n");
      out.write("                <div class=\"invalid-feedback\">\n");
      out.write("                  Valid last name is required.\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("              <label for=\"username\">Username</label>\n");
      out.write("              <div class=\"input-group\">\n");
      out.write("                <div class=\"input-group-prepend\">\n");
      out.write("                  <span class=\"input-group-text\">@</span>\n");
      out.write("                </div>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"username\" placeholder=\"Username\" required>\n");
      out.write("                <div class=\"invalid-feedback\" style=\"width: 100%;\">\n");
      out.write("                  Your username is required.\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("              <label for=\"email\">Email <span class=\"text-muted\">(Optional)</span></label>\n");
      out.write("              <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"you@example.com\">\n");
      out.write("              <div class=\"invalid-feedback\">\n");
      out.write("                Please enter a valid email address for shipping updates.\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("              <label for=\"address\">Address</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"address\" placeholder=\"1234 Main St\" required>\n");
      out.write("              <div class=\"invalid-feedback\">\n");
      out.write("                Please enter your shipping address.\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("              <label for=\"address2\">Address 2 <span class=\"text-muted\">(Optional)</span></label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"address2\" placeholder=\"Apartment or suite\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-md-5 mb-3\">\n");
      out.write("                <label for=\"country\">Country</label>\n");
      out.write("                <select class=\"custom-select d-block w-100\" id=\"country\" required>\n");
      out.write("                  <option value=\"\">Choose...</option>\n");
      out.write("                  <option>United States</option>\n");
      out.write("                </select>\n");
      out.write("                <div class=\"invalid-feedback\">\n");
      out.write("                  Please select a valid country.\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-4 mb-3\">\n");
      out.write("                <label for=\"state\">State</label>\n");
      out.write("                <select class=\"custom-select d-block w-100\" id=\"state\" required>\n");
      out.write("                  <option value=\"\">Choose...</option>\n");
      out.write("                  <option>California</option>\n");
      out.write("                </select>\n");
      out.write("                <div class=\"invalid-feedback\">\n");
      out.write("                  Please provide a valid state.\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-3 mb-3\">\n");
      out.write("                <label for=\"zip\">Zip</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"zip\" placeholder=\"\" required>\n");
      out.write("                <div class=\"invalid-feedback\">\n");
      out.write("                  Zip code required.\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <hr class=\"mb-4\">\n");
      out.write("            <div class=\"custom-control custom-checkbox\">\n");
      out.write("              <input type=\"checkbox\" class=\"custom-control-input\" id=\"same-address\">\n");
      out.write("              <label class=\"custom-control-label\" for=\"same-address\">Shipping address is the same as my billing address</label>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"custom-control custom-checkbox\">\n");
      out.write("              <input type=\"checkbox\" class=\"custom-control-input\" id=\"save-info\">\n");
      out.write("              <label class=\"custom-control-label\" for=\"save-info\">Save this information for next time</label>\n");
      out.write("            </div>\n");
      out.write("            <hr class=\"mb-4\">\n");
      out.write("\n");
      out.write("            <h4 class=\"mb-3\">Payment</h4>\n");
      out.write("\n");
      out.write("            <div class=\"d-block my-3\">\n");
      out.write("              <div class=\"custom-control custom-radio\">\n");
      out.write("                <input id=\"credit\" name=\"paymentMethod\" type=\"radio\" class=\"custom-control-input\" checked required>\n");
      out.write("                <label class=\"custom-control-label\" for=\"credit\">Credit card</label>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"custom-control custom-radio\">\n");
      out.write("                <input id=\"debit\" name=\"paymentMethod\" type=\"radio\" class=\"custom-control-input\" required>\n");
      out.write("                <label class=\"custom-control-label\" for=\"debit\">Debit card</label>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"custom-control custom-radio\">\n");
      out.write("                <input id=\"paypal\" name=\"paymentMethod\" type=\"radio\" class=\"custom-control-input\" required>\n");
      out.write("                <label class=\"custom-control-label\" for=\"paypal\">Paypal</label>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-md-6 mb-3\">\n");
      out.write("                <label for=\"cc-name\">Name on card</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"cc-name\" placeholder=\"\" required>\n");
      out.write("                <small class=\"text-muted\">Full name as displayed on card</small>\n");
      out.write("                <div class=\"invalid-feedback\">\n");
      out.write("                  Name on card is required\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-6 mb-3\">\n");
      out.write("                <label for=\"cc-number\">Credit card number</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"cc-number\" placeholder=\"\" required>\n");
      out.write("                <div class=\"invalid-feedback\">\n");
      out.write("                  Credit card number is required\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-md-3 mb-3\">\n");
      out.write("                <label for=\"cc-expiration\">Expiration</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"cc-expiration\" placeholder=\"\" required>\n");
      out.write("                <div class=\"invalid-feedback\">\n");
      out.write("                  Expiration date required\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-3 mb-3\">\n");
      out.write("                <label for=\"cc-expiration\">CVV</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"cc-cvv\" placeholder=\"\" required>\n");
      out.write("                <div class=\"invalid-feedback\">\n");
      out.write("                  Security code required\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <hr class=\"mb-4\">\n");
      out.write("            <button class=\"btn btn-primary btn-lg btn-block\" type=\"submit\">Continue to checkout</button>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("       \n");
      out.write("    </div>\n");
      out.write("     \n");
      out.write("     ");
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
      out.write("  </body>\n");
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