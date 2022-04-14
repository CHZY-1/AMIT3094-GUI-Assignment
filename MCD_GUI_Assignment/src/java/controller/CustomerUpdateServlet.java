package controller;

import model.domain.Customer;
import model.domain.Address;
import model.da.CustomerDA;
import model.da.AddressDA;

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

@WebServlet(name = "CustomerUpdateServlet", urlPatterns = {"/CustomerUpdateServlet"})
public class CustomerUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            //get parameter value from form
            String customerId = request.getParameter("customerID");
            String customername = request.getParameter("customerName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phoneNumber");
            String password = request.getParameter("password");

            String addressId = request.getParameter("addressID");
            String street = request.getParameter("street");
            String state = request.getParameter("state");
            String postcode = request.getParameter("postcode");

            Customer customerToInsert = new Customer(customerId, customername, email, phone, password,
                    new Address(addressId, street, state, postcode));

            CustomerDA customerDA = new CustomerDA();
            AddressDA addressDA = new AddressDA();

            try {
                int successCustomer = customerDA.updateRecord(customerToInsert);
                addressDA.modAddress(customerToInsert.getAddress());

                if (successCustomer > 0) {
                    HttpSession session = request.getSession();

                    String msg = "Successfully updated account information";

                    Customer customer = customerDA.getRecordById(customerToInsert.getCustomerID());

                    session.setAttribute("customer", customer);
                    
                    response.sendRedirect("CustomerProfile.jsp");
                    
                } else {
                    
                    String msg = "Update account information failed";
                    response.sendRedirect("CustomerEdit.jsp");
                }

            } catch (IOException | SQLException ex) {
                StackTraceElement[] elements = ex.getStackTrace();
                out.println("ERROR: " + ex.toString() + "<br/>");
            }
        }

    }

}
