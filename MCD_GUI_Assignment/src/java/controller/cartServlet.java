package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import model.domain.Product;
import model.domain.ProductCategory;

@WebServlet(name = "cartServlet", urlPatterns = {"/cartServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class cartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession session = request.getSession();

            String action = request.getParameter("action");
            if (action == null) {

                doPost_RedirectToCart(request, response);

            } else {

                String productID = request.getParameter("productID");
                String productName = request.getParameter("productName");
                String productImage = request.getParameter("productImage");
                double productPrice = Double.valueOf(request.getParameter("productPrice"));
                String productCategoryID = request.getParameter("productCategoryID");
                String productCategoryName = request.getParameter("productCategoryName");
                Product product = new Product(productID, productName, productImage, productPrice, new ProductCategory(productCategoryID, productCategoryName));

                if (action.equalsIgnoreCase("addToCart")) {
                    doPost_AddItemToCart(request, response, product);
                } else if (action.equalsIgnoreCase("removeFromCart")) {
                    doPost_RemoveCartItem(request, response, product);
                }
            }
            
            
        } catch (IOException | NumberFormatException | ServletException ex) {
            doPost_RedirectToCart(request, response);
            ex.getMessage();
        } catch(ConcurrentModificationException ex){
            doPost_RedirectToCart(request, response);
        }

    }

    protected void doPost_RedirectToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }

    protected void doPost_AddItemToCart(HttpServletRequest request, HttpServletResponse response, Product product)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("cart") == null) {

            ArrayList<Product> cart = new ArrayList<>();
            cart.add(product);
            session.setAttribute("cart", cart);

        } else {

            ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
            boolean isExists = isExisting(product.getProductID(), cart);

            //if product is not exists in the cart
            if (isExists == false) {
                cart.add(product);

            } else {
                String message = "The Product - Name: " + product.getProductName() + "Is already exists in the cart.";
                request.setAttribute("isItemExist", message);

            }
            session.setAttribute("cart", cart);
        }

        response.sendRedirect("Cart.jsp");
    }

    protected void doPost_RemoveCartItem(HttpServletRequest request, HttpServletResponse response, Product product)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
        Product productToRemove = new Product();
        
        for (Product productInCart : cart) {
            if (productInCart.getProductID().equalsIgnoreCase(product.getProductID())) {
                productToRemove = productInCart;
            }
        }
        
        cart.remove(productToRemove);
        
        session.setAttribute("cart", cart);

        response.sendRedirect("Cart.jsp");
    }

    private boolean isExisting(String productID, ArrayList<Product> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProductID().equalsIgnoreCase(productID)) {
                return true;
            }
        }
        return false;
    }
    
    
}
