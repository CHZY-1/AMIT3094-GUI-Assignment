// Author:Lim Sheng Yang
// Description:use to edit the detail of the staff that is use by the manager
package controller.Servlet;
import model.da.StaffDA;
import model.da.AddressDA;
import model.domain.Address;
import model.domain.Staff;
import java.util.ArrayList;
import java.util.List;
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

/**
 *
 * @author Asus
 */
@WebServlet(name = "editAdminServlet", urlPatterns = {"/editAdminServlet"})
public class EditAdminServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String staffID=request.getParameter("ID");
            String name=request.getParameter("name");
            name=toCapital(name);
            String ic=request.getParameter("ic");
            String status=request.getParameter("status");
            String phoneNo=request.getParameter("phone");
            String gender=request.getParameter("gender");
            double salary=Double.parseDouble(request.getParameter("salary"));

            String addressId=request.getParameter("addID");
            String street=request.getParameter("street");
            street=toCapital(street);
            String state=request.getParameter("state");
            String postcode=request.getParameter("postcode");

            String roleID=request.getParameter("roles"); 

            Address address=new Address(addressId,street,state,postcode);

            Staff staff=new Staff(staffID,name,ic,status,phoneNo,gender,salary,address);
            List<String> err=staff.validateStaffe(staff);
            
            StaffDA stfDA=new StaffDA();
            AddressDA addrDA=new AddressDA();
            
            if(err.isEmpty()){
                 //database
                stfDA.modStaff(staff,roleID);
                addrDA.modAddress(address);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("admin_list.jsp");
                dispatcher.forward(request, response);
            }

            if(!err.equals("")){
                request.setAttribute("errM",err);
                 Staff stf=stfDA.getStaff(staffID);
                request.setAttribute("StaffObj", stf);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editAdmin.jsp");
                dispatcher.forward(request, response);
            }
        
        }catch(Exception ex){
            ex.getMessage();
        }
     
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

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
