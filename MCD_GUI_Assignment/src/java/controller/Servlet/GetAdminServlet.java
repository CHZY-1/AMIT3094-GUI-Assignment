// Author:Lim Sheng Yang
// Description: use to retrieve the detail of the requested admin detail and set it to the session
package controller.Servlet;

import model.da.StaffDA;
import model.da.AddressDA;
import model.domain.Address;
import model.domain.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
@WebServlet(name = "getAdminServlet", urlPatterns = {"/getAdminServlet"})
public class GetAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             //will be use by view and edit nad delete
             try{
                String ID=request.getParameter("id");
                String location=request.getParameter("location");
        
                StaffDA SDA=new StaffDA();
                Staff stf=SDA.getStaff(ID);
                request.setAttribute("StaffObj", stf);
                if(location.equals("edit")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("editAdmin.jsp");
                    dispatcher.forward(request, response);
                }else if(location.equals("view")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("viewAdmin.jsp");
                    dispatcher.forward(request, response);
                }else if(location.equals("delete")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteAdmin.jsp");
                    dispatcher.forward(request, response);
                }else if(location.equals("editSelf")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("editAdminSelf.jsp");
                    dispatcher.forward(request, response);
                }else if(location.equals("viewSelf")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("AdminProfile.jsp");
                    dispatcher.forward(request, response);
                }else{
                    response.setContentType("text/html");
                    PrintWriter out=response.getWriter();
                    out.println("<b>An error Occur</b>");
                }
        
             }catch(Exception ex){
                 
             } 
    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ID=request.getParameter("ID");
        String location=request.getParameter("location");
        
        StaffDA SDA=new StaffDA();
        Staff stf=SDA.getStaff(ID);
        request.setAttribute("StaffObj", stf);
         if(location.equals("viewSelf")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminProfile.jsp");
                dispatcher.forward(request, response);
         }
        
        
        
        
        
        
        
    }

}
