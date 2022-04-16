// Author:Chan Zhi Yang
// Description:A servlet for the customer side user to logout from their account. 
//             In this servlet all the attributes stored in the session will be clear. 
package controller.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            if (session.getAttribute("customer") != null) {
                session.removeAttribute("customer");
               
            }
            
            if (session.getAttribute("cart") != null) {
                session.removeAttribute("cart");
               
            }
            if (session.getAttribute("totalPrice") != null) {
                session.removeAttribute("totalPrice");
               
            }
            
             response.sendRedirect("Login.jsp");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}