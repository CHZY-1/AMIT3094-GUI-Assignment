// Author:Lim Sheng Yang
// Description:use to delete the account of the admin in the database STAFF table 
package controller.Servlet;

import model.da.AddressDA;
import model.da.StaffDA;
import model.domain.Address;
import model.domain.Role;
import model.domain.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "delAdminServlet", urlPatterns = {"/delAdminServlet"})
public class DelAdminServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StaffDA stfDA=new StaffDA();
        AddressDA addrDA=new AddressDA();
        
        String stfID=request.getParameter("id");
        
        Staff stf=stfDA.getStaff(stfID);
        String addrID=stf.getAddress().getAddressId();
        stfDA.delStaff(stfID);
        addrDA.delAddress(addrID);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_list.jsp");
        dispatcher.forward(request, response);
    }



}
