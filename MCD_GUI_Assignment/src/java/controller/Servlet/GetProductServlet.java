// Author:Lim Sheng Yang
// Description:use to retrieve the detail of the product from the database 
package controller.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Control.ProductController;
import model.domain.Product;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Asus
 */
@WebServlet(name = "getProductServlet", urlPatterns = {"/getProductServlet"})
public class GetProductServlet extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String prodID=request.getParameter("productID");
            String location=request.getParameter("location");
            
            ProductController prodCon=new ProductController();
            Product prod=prodCon.getProductByID(prodID);
            request.setAttribute("prodObj", prod);
            if(location.equals("delete")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteProduct.jsp");
                dispatcher.forward(request, response);
            }else if(location.equals("view")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("viewProduct.jsp");
                dispatcher.forward(request, response);
            }else if(location.equals("edit")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("editProduct.jsp");
                dispatcher.forward(request, response);
            }else{
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<b>An error Occur</b>");
            }
            
       
        }catch(Exception ex){
            
        }
    }

}
