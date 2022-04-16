// Author:Chan Zhi Yang
// Description:A Servlet that will retrieve all products from the database, randomly select three products and add them into an arraylist, 
//             after that return an arraylist with three products to the Home page, so the Home page can randomly recommend three items. 
package controller.Servlet;

import controller.Control.ProductController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.domain.Product;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher requestDispatcher;
            HttpSession session = request.getSession();

            ProductController prodController = new ProductController();

            // Retreive all Product and Product Category from database
            ArrayList<Product> productList = prodController.getAllProduct();

            ArrayList<Product> newProductList = getRandomElement(productList, 3);

            request.setAttribute("randomProductList", newProductList);
            request.getRequestDispatcher("Home.jsp").forward(request, response);

        } catch (SQLException ex) {
            final PrintWriter out = response.getWriter();
            out.println("SQL Exception");
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Product> getRandomElement(ArrayList<Product> productList, int size) {

        //Randomly get 3(size) different product from productList
        ArrayList<Product> newProductList = new ArrayList<Product>();

        if (size <= productList.size()) {

            for (int i = 0; i <= productList.size(); i++) {

                if (i < size) {
                    int randomIndex = ThreadLocalRandom.current().nextInt(0, productList.size());

                    //remove duplicated item
                    if (!newProductList.contains(productList.get(randomIndex))) {
                        newProductList.add(productList.get(randomIndex));
                    } else {
                        i--;
                    }

                }

            }

        }

        return newProductList;
    }

}
