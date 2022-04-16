// Author:Lim Wei Zhe
// Description:use to validate the admin login ID from the database to make sure 
//             that the staff is able to log in using the staff ID and the password 
package controller.Servlet;

import model.da.StaffDA;
import model.da.RoleDA;
import model.domain.Role;
import model.domain.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/AdminLoginServlet"})
public class AdminLoginServlet extends HttpServlet {

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
            
            String staffID = "";
            String password = "";
            String errMsg = "";
            String successMsg = "";

            //Obtain data from AdminLoginServlet.jsp
            staffID = request.getParameter("staffID");
            password = request.getParameter("password");

            //sample 
            //write in servlet 
            StaffDA staffDA = new StaffDA();  //object
            Staff staff = new Staff();
            
            boolean exist = false;
            boolean success = false;
            //check whether the id is in database or not. 
            List<Staff> staffList=new ArrayList<Staff>();
                        staffList=staffDA.listStaff();
            for(Staff s: staffList){
                if(staffID.equals(s.getStaffID())&& s.getStatus().equals("Active")){
                    exist = true;
                    
                    if(password .equals(s.getPassword())){
                        successMsg += "The password is the same with the staff ID";
                        success = true;
                        staff.setStaffID(s.getStaffID());
                        staff.setGender(s.getGender());
                        staff.setIc(s.getIc());
                        staff.setAddress(s.getAddress());
                        staff.setPassword(s.getPassword());
                        staff.setRoleID(s.getRoleID());
                        staff.setStatus(s.getStatus());
                        staff.setPhoneNo(s.getPhoneNo());
                        staff.setSalary(s.getSalary());
                        staff.setName(s.getName());
                    }
                }
            }
            
            if(success == true){
                
                RoleDA roleda=new RoleDA(); 
                
                Role myrole=roleda.getRole(staff.getRoleID().getRoleID());
                staff.setRoleID(myrole);
//                 create httpSession one if it does not exist
                HttpSession httpSession = request.getSession(); 

                // Store Customer object to the session
                httpSession.setAttribute("staff", staff);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminHome.jsp");
                dispatcher.forward(request, response);
            }else{
                errMsg += "The data that is being entered is not in the database"+"\n"+"Or you have been banned by manager";
                request.setAttribute("errMsg", errMsg);
                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
                dispatcher.forward(request, response);
            }
          
        }catch(Exception ex){
            out.println(ex.getMessage());
            out.println("Error Occured");
        }
 
    }

}
