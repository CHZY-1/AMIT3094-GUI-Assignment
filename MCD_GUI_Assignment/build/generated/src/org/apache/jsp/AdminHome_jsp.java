package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.domain.Customer;
import model.da.CustomerDA;
import model.domain.Staff;
import model.da.StaffDA;
import model.da.RoleDA;
import model.domain.Role;
import model.domain.Product;
import model.domain.ProductCategory;
import model.da.ProductCategoryDA;
import model.da.ProductDA;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.*;
import java.util.*;

public final class AdminHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Admin-Home</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("              html{\n");
      out.write("                background-color: #fff9e8;\n");
      out.write("              }\n");
      out.write("            .header{\n");
      out.write("                margin: -8px -8px 0px -8px;\n");
      out.write("                padding: 2px;\n");
      out.write("                background-color: #ebebeb;\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: row;\n");
      out.write("                flex-wrap: wrap;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .third img{\n");
      out.write("                border-radius: 50%;\n");
      out.write("                width: 50px;\n");
      out.write("                height: 50px;\n");
      out.write("            }\n");
      out.write("            .first{\n");
      out.write("                flex:7 1;\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("            .second{\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                flex:4 1;\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("            .third{ \n");
      out.write("                flex:2 1;\n");
      out.write("                font-size: 20px;\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .content,.secondRow{\n");
      out.write("                display: flex;\n");
      out.write("                margin: 30px;\n");
      out.write("            }\n");
      out.write("            .order-table,.sale-table,.customer-table,.admin-table,.menu-table{\n");
      out.write("                padding: 10px;\n");
      out.write("                background-color: #ffedbd;\n");
      out.write("                border-radius: 15px;\n");
      out.write("                box-shadow: 5px 10px 18px #888888;\n");
      out.write("                flex-direction: row;\n");
      out.write("                flex-wrap: wrap;\n");
      out.write("                overflow: hidden;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                margin: 40px;\n");
      out.write("                margin-left: 70px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .order b,.sale b,.customer b,.admin b,.menu b{\n");
      out.write("                margin: 25px;\n");
      out.write("                line-height: 40px;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .order b,.sale b,.cusR,.admin b,.menu b{\n");
      out.write("                line-height: 46px;\n");
      out.write("            }\n");
      out.write("            .head{\n");
      out.write("                font-size: 25px;\n");
      out.write("                background-color: #ffda75;\n");
      out.write("            }\n");
      out.write("            a.direct{\n");
      out.write("                background-color: #ffbb00;\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: black;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 6px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                font-size: 15px;\n");
      out.write("                margin:0px 20px 0px 40px;\n");
      out.write("            }\n");
      out.write("            .center{\n");
      out.write("                text-align: center;\n");
      out.write("                padding-left: 45px;\n");
      out.write("            }\n");
      out.write("            a{\n");
      out.write("                text-decoration: none;\n");
      out.write("                color:black;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
Staff me=(Staff)session.getAttribute("staff");
                StaffDA staffDA=new StaffDA();
                RoleDA roleda=new RoleDA(); 
                me=staffDA.getStaff(me.getStaffID());
                Role myrole=roleda.getRole(me.getRoleID().getRoleID());
      out.write("\n");
      out.write("                \n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"first\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "HTML_parts/AdminHeader.jsp", out, false);
      out.write("\n");
      out.write("                <img src=\"image/logo.png\" style=\"width: 90px; height: 65px;margin:0px 20px 0px 20px;\"/>\n");
      out.write("                <h2>Admin Dashboard</h2>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"second\">\n");
      out.write("                ");

                    Date date = new Date( );
                    SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a EEEEE',' dd MMMMM yyyy");
                
      out.write("\n");
      out.write("                <b>");
      out.print(ft.format(date));
      out.write("</b>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"third\">\n");
      out.write("                <img src=");
      out.print( me.getGender().equals("Male")?"image/man.png":"image/lady1.jpg" );
      out.write(" alt=\"avatar\"/>\n");
      out.write("                <span style=\"margin-left: 12px;\"><a href=\"getAdminServlet?ID=");
      out.print(me.getStaffID());
      out.write("&location=viewSelf\">");
      out.print(me.getName());
      out.write("</a></span>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("            <div class=\"content\">\n");
      out.write("               \n");
      out.write("                ");
if(myrole.getCustomer().equals("True")){ 
      out.write("\n");
      out.write("                <div class=\"customer\">\n");
      out.write("                    <table class=\"customer-table\">\n");
      out.write("                        <tr class=\"head\">\n");
      out.write("                            <td  class=\"cusR\"><b>New Customer</b></td>\n");
      out.write("                            <td><a href=\"CustomerListing.jsp\" class=\"direct\">View All Customer</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
CustomerDA custDA=new CustomerDA();
                        List<Customer> cust=custDA.listNewCustomer();
                        int i=1;
                        for(Customer c: cust){
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                            ");
if(i==1){
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><b>1<sup>st</sup></b></td>\n");
      out.write("                                <td><b>:<span style=\"padding-left: 25px;\">");
      out.print(c.getCustomerName());
      out.write("</span> </b></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("                            ");
if(i==2){
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><b>2<sup>nd</sup></b></td>\n");
      out.write("                                <td><b>:<span style=\"padding-left: 25px;\">");
      out.print(c.getCustomerName());
      out.write("</span> </b></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("                            ");
if(i==3){
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><b>3<sup>rd</sup></b></td>\n");
      out.write("                                <td><b>:<span style=\"padding-left: 25px;\">");
      out.print(c.getCustomerName());
      out.write("</span> </b></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        ");
i=i+1;}
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
if(myrole.getMenu().equals("True")){ 
      out.write("\n");
      out.write("                <div class=\"menu\">\n");
      out.write("                    <table class=\"menu-table\">\n");
      out.write("                        <tr class=\"head\">\n");
      out.write("                            <td><b>Menu</b></td>\n");
      out.write("                            <td><a href=\"AdminMenu.jsp\" class=\"direct\">View All Product</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
ProductDA prodDA=new ProductDA();
                        ProductCategoryDA prodCADa=new ProductCategoryDA();
                        List <ProductCategory> prodCa=new ArrayList<ProductCategory>();
                        prodCa=prodCADa.getAllProductCategory();
                        
                        for(ProductCategory pc:prodCa){
      out.write("\n");
      out.write("                         <tr>\n");
      out.write("                            <td><b>");
      out.print(pc.getCategoryName());
      out.write("</b></td>\n");
      out.write("                            <td><b>:<span class=\"center\">");
List<Product> prod=prodDA.getAllProductByCategory(pc.getCategoryID());
      out.print(prod.size());
      out.write("</span> </b></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                      \n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                 ");
if(myrole.getAdmin().equals("True")){ 
      out.write("\n");
      out.write("                <div class=\"admin\">\n");
      out.write("                    <table class=\"admin-table\">\n");
      out.write("                        <tr class=\"head\">\n");
      out.write("                            <td><b>Staff</b></td>\n");
      out.write("                            <td><a href=\"admin_list.jsp\" class=\"direct\">View All Admin</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                        List<Role> role=roleda.listRole();
                        for(Role r:role){
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>");
      out.print(r.getRoleName());
      out.write("</b></td>\n");
      out.write("                            <td><b>:<span class=\"center\">");
List<Staff> stf=staffDA.listStaffByRole(r.getRoleID());
      out.print(stf.size());
      out.write("</span> </b></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                   \n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("              \n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("            <div class=\"secondRow\">\n");
      out.write("                \n");
      out.write("               \n");
      out.write("            </div>\n");
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
