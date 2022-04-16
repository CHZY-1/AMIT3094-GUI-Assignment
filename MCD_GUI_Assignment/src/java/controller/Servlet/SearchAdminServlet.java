// Author:Lim Sheng Yang
// Description:use to get the data of the staff when a manager use the search bar to search the staff record  
package controller.Servlet;

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
@WebServlet(name = "searchAdmin", urlPatterns = {"/searchAdmin"})
public class SearchAdminServlet extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String order=request.getParameter("order");
            request.setAttribute("order", order);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin_list.jsp");
            dispatcher.forward(request, response);  
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String value=request.getParameter("search");
       String place=request.getParameter("place");
       request.setAttribute("seVa", value);
       if(place.equals("admin")){
           if(value.equals("")){
               request.setAttribute("seVa", "!@#$");
           }
           RequestDispatcher dispatcher = request.getRequestDispatcher("admin_list.jsp");
            dispatcher.forward(request, response);
       }else if(place.equals("menu")){
           if(value.equals("All")){
               request.setAttribute("seVa", "!@#$");
           }
           RequestDispatcher dispatcher = request.getRequestDispatcher("AdminMenu.jsp");
            dispatcher.forward(request, response);
       }
       
    }


}
