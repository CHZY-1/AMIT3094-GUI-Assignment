// Author:Lim Sheng Yang
// Description:use to validate and save the admin detail into the database 
package controller.Servlet;
//to be use in add and delete admin
import model.da.AddressDA;
import model.da.StaffDA;
import model.domain.Address;
import model.domain.Role;
import model.domain.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "addAdminServlet", urlPatterns = {"/addAdminServlet"})
public class AddAdminServlet extends HttpServlet {
    StaffDA stfDA=new StaffDA();
    AddressDA addrDA=new AddressDA();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        String staffID=request.getParameter("ID");
        String name=request.getParameter("name");
        name=toCapital(name);
        String ic=request.getParameter("ic");
        String gender=request.getParameter("gender");
        String status="Active";
        String phoneNo=request.getParameter("phone");
        String pass=request.getParameter("password");
        String conpass=request.getParameter("conPass");
        double salary=Double.parseDouble(request.getParameter("salary"));
        String roleID=request.getParameter("roles"); 
        
        String addressId=addrDA.generateLatestAddressID();
        String street=request.getParameter("street");
        street=toCapital(street);
        String state=request.getParameter("state");
        String postcode=request.getParameter("postcode");
        
        Address address=new Address(addressId,street,state,postcode);
        
        Staff staff=new Staff(staffID,name,ic,pass,status,phoneNo,gender,salary,address,new Role(roleID));
        List<String> err=staff.validateStaff(staff,conpass);
        
        if(err.isEmpty()){
             //database
             System.out.println("Hello"+addressId);
            addrDA.addAddress(address);
            stfDA.addStaff(staff);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin_list.jsp");
            dispatcher.forward(request, response);
        }
        
        if(!err.equals("")){
            request.setAttribute("errM",err);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddAdmin.jsp");
            dispatcher.forward(request, response);
        }
        
        }catch(Exception ex){
            ex.getMessage();
        }
        
        
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
