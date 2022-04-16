// Author:Lim Wei Zhe
// Description:For this servlet, it is a servlet that lets the customer to 
//             register for their account if they have not yet created an account 
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

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    
        try{               
            String customerID = request.getParameter("customerID");
            String customerName = request.getParameter("customerName");
            String email = request.getParameter("email");
            String phoneNum = request.getParameter("phoneNo");
            String password = request.getParameter("password");
            String cfmPassword = request.getParameter("cfmpassword");

            String addressStreet = request.getParameter("addressStreet");
            String addressState = request.getParameter("addressState");
            String postcode = request.getParameter("postcode");
            
            Customer customer = new Customer(customerID, customerName, email, phoneNum, password);
            Address address = new Address(addressStreet, addressState, postcode);

            //take addressDA stuff
            AddressDA addressDA = new AddressDA();
            Address addr = addressDA.addAddress(address); //assign address stff
            //want to print out the address
            customer.setAddress(addr);
            
            //get email
            CustomerDA customerDA = new CustomerDA();
            Customer compareEmail = customerDA.retrieveEmail(email);

            String errMsg = "";
            errMsg += customer.validateUsername(customerName); 
            errMsg += customer.validatePassword(password);
            errMsg += customer.validatePhoneNum(phoneNum);
            
            //compare email with the database
            if(compareEmail != null){
                errMsg += "Email is already in database";
            }

            //validate with the password that user input. 
            if(!password.equals(cfmPassword)){
                errMsg += "Password not match with confirm password\n\n";
            }
            
            //err, display back to the JSP page 
            if (!errMsg.equals("")){
                request.setAttribute("errMsg", errMsg);
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }

            //let user to see the data that the user have enter
            //connection to the database
            if(errMsg.equals("")){
                //CustomerDA customerDA = new CustomerDA();
                customerDA.addCustomer(customer);
                out.println("Hi");
                //forward to another page 
                request.setAttribute("successMsg", "Data has been successfully added to the database. "
                            +"\n" + "You have been redirected to Login Page");
                
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        
        }catch(Exception ex){
            ex.getMessage();
          
            //request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
        
}
