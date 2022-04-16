// Author:Lim Sheng Yang
// Description:use to delete the record of the product in the database PRODUCT table 
package controller.Servlet;

import model.da.ProductDA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "delProduct", urlPatterns = {"/delProduct"})
public class DelProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String id=request.getParameter("id");
            ProductDA prodDA=new ProductDA();
            int seccess=prodDA.hideProduct(id);
            if(seccess==1){
                request.setAttribute("pMsg", "The product has been successfully deleted");
                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminMenu.jsp");
                dispatcher.forward(request, response);
            }else{
                request.setAttribute("pMsg", "There's error occur while delete the product! Try again later!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminMenu.jsp");
                dispatcher.forward(request, response);
            }

        }catch(Exception ex){
            
        }
    }

}
