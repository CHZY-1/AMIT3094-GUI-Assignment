// Author:Lim Sheng Yang
// Description:use to edit the detail of the logging-in staff personal detail and save into the database
package controller.Servlet;
import model.da.StaffDA;
import model.da.AddressDA;
import model.domain.Address;
import model.domain.Staff;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "editAdminSelf", urlPatterns = {"/editAdminSelf"})
public class EditAdminSelfServlet extends HttpServlet {
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String staffID=request.getParameter("ID");
            String name=request.getParameter("name");
            name=toCapital(name);
            String ic=request.getParameter("ic");
            String phoneNo=request.getParameter("phone");
            String gender=request.getParameter("gender");
            String pass=request.getParameter("password");
            String conpass=request.getParameter("conPass");
        
            String addressId=request.getParameter("addID");
            String street=request.getParameter("street");
            street=toCapital(street);
            String state=request.getParameter("state");
            String postcode=request.getParameter("postcode");


            Address address=new Address(addressId,street,state,postcode);

            Staff staff=new Staff(staffID,name,ic,pass,phoneNo,gender,address);
            
            List<String> err=staff.validateStaff(staff,conpass);
            
            StaffDA stfDA=new StaffDA();
            AddressDA addrDA=new AddressDA();
            
            if(err.isEmpty()){
                 //database
                stfDA.modSelf(staff);
                addrDA.modAddress(address);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("AdminHome.jsp");
                dispatcher.forward(request, response);
            }

            if(!err.equals("")){
                request.setAttribute("errM",err);
                Staff stf=stfDA.getStaff(staffID);
                request.setAttribute("StaffObj", stf);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editAdminSelf.jsp");
                dispatcher.forward(request, response);
            }
        
        }catch(Exception ex){
            ex.getMessage();
        }
     
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getSession().removeAttribute("staff");
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
        dispatcher.forward(request, response);

    }
     public String toCapital(String message) {

                // stores each characters to a char array
                char[] charArray = message.toCharArray();
                boolean foundSpace = true;

                for(int i = 0; i < charArray.length; i++) {

                  // if the array element is a letter
                  if(Character.isLetter(charArray[i])) {

                    // check space is present before the letter
                    if(foundSpace) {

                      // change the letter into uppercase
                      charArray[i] = Character.toUpperCase(charArray[i]);
                      foundSpace = false;
                    }
                  }

                  else {
                    // if the new character is not character
                    foundSpace = true;
                  }
                }

                // convert the char array to the string
                message = String.valueOf(charArray);
                return message;
     }
}
