// Author:Lim Wei Zhe
// Description: A servlet for the customer side that lets the customer to change their password by inserting the customer ID 
//              that have been given during register and also the email that they use to register with  

package controller.Servlet;

import controller.Control.CustomerControl;
import model.da.CustomerDA;
import model.da.AddressDA;
import model.domain.Customer;
import model.domain.Address;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

@WebServlet(name = "ForgetPasswordServlet", urlPatterns = {"/ForgetPasswordServlet"})
public class ForgetPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try{
            String customerID = "";
            String email = "";
            String errMsg = "";
            String successMsg = "";
            
            //obtain the data from the JSP page
            customerID = request.getParameter("customerID");
            email = request.getParameter("email");

            CustomerDA customerDA = new CustomerDA();  //object
//            AddressDA addressDA = new AddressDA();
            Customer cust = new Customer();
            cust.setEmail(email);
            cust.setCustomerId(customerID);
//            Address address = new Address();
            
            errMsg += cust.validateCustomerID(customerID);
            
            if(email.equals(cust.getEmail())){
                errMsg += "Email is not same with the database" + "\n\n";
            }
            
            boolean exists = customerDA.ForgetPasswordUsage(customerID, email);
            if (!exists) {
                errMsg += "Customer ID / Email does not match with database" + "\n\n";
                request.setAttribute("errMsg", errMsg);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ForgetPassword.jsp");
                dispatcher.forward(request, response);
            } 
            
            if (exists == true) {
                cust = customerDA.retrieveCustomer(customerID);
                //create httpSession one if it does not exist 
                HttpSession httpSession = request.getSession();

                // Store Customer object to the session
                httpSession.setAttribute("customer", cust);
                successMsg += "The details that you have entered is correct and you," + "\n" 
                        + "been directed to this page";
                request.setAttribute("successMsg", successMsg);
                //redirect to homepage 
                response.sendRedirect("ChangePassword.jsp");
            }
            
        }catch(NullPointerException ex){
            out.println("Null Pointer Exception Happened");
            
        }catch(Exception ex){
            out.println(ex.getMessage());
            out.println("Error Occurred");
        }
    }
}