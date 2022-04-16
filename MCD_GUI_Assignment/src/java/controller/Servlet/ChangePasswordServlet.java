/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Servlet;

import model.da.CustomerDA;
import model.domain.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julian Lim
 */
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try{
            String password = "";
            String errMsg = "";
            String successMsg = "";
            String cfmPassword = "";
           
            password = request.getParameter("password");
            cfmPassword = request.getParameter("cfmpassword");
            
            //specifc for password only
            HttpSession httpSession = request.getSession();
            
            //convert
            Customer cust = (Customer)httpSession.getAttribute("customer");
            cust.setPassword(password);
            CustomerDA customerDA = new CustomerDA();
            
            errMsg += cust.validatePassword(password);
            
            if(!password.equals(cfmPassword)){
                errMsg += "Update Password Has fail";
                request.setAttribute("errMsg", errMsg);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ChangePassword.jsp");
                dispatcher.forward(request, response);
                
            }
            
            if(password.equals(cfmPassword)){
                customerDA.updatePassword(cust);
                successMsg += "Password have been updated successfully";
                request.setAttribute("successMsg", successMsg);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
            }
                      
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
        
        
    }

}