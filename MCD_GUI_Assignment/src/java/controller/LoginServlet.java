/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.da.*;
import model.domain.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            String customerID = "";
            String password = "";
            String errMsg = "";
            String successMsg = "";

            //Obtain data from Login.jsp
            customerID = request.getParameter("customerID");
            password = request.getParameter("password");

            //write in servlet 
            CustomerDA customerDA = new CustomerDA();  //object
            AddressDA addressDA = new AddressDA();  //object
            Customer cust = new Customer();
            Address address = new Address();

            //errMsg += customer.validateUsername(); 
            errMsg += cust.validateCustomerID(customerID);
            errMsg += cust.validatePassword(password);

            boolean exists = customerDA.Confirmlogin(customerID, password);
            if (!exists) {
                errMsg += "Customer ID / Password does not match with database";
                request.setAttribute("errMsg", errMsg);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
                
            } else {

                cust = customerDA.retrieveCustomer(customerID);
                address = addressDA.retrieveAddress(cust.getAddress().getAddressId());
                
                cust.setAddress(address);

                //create httpSession one if it does not exist 
                HttpSession httpSession = request.getSession();

                // Store Customer object to the session
                httpSession.setAttribute("customer", cust);

                //redirect to homepage 
                RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
                dispatcher.forward(request, response);

            }
            
        } catch (Exception ex) {
            out.println(ex.getMessage());
            out.println("Error Occured");
        }

    }

}
