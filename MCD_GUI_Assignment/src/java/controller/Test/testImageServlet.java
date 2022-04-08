
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Part;
import model.da.ProductDA;
import model.domain.Product;


@WebServlet(name = "testImageServlet", urlPatterns = {"/testImageServlet"})
public class testImageServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Product product = new Product();
        byte[] imageByte = Product.convertImageToBytes("C:\\Users\\zyang\\Desktop\\AMIT3094  GUI AND WEB APPLICATION PROGRAMMING\\Projects\\MCD_GUI_Assignment\\web\\Pictures\\apple.jpg");
        
//        String base64Image = Product.convertByteToBase64(imageByte);
//        String imagePath ="C:\\Users\\zyang\\Desktop\\AMIT3094  GUI AND WEB APPLICATION PROGRAMMING\\Projects\\MCD_GUI_Assignment\\web\\Pictures\\apple.jpg";
        
        
        String servletPath = getServletContext().getRealPath("/");
        String imagePath = servletPath + "Pictures/apple.jpg";
        //======================== Works
//        BufferedImage bImage = null;
//        File initialImage = new File(imagePath);
//        bImage = ImageIO.read(initialImage); //renderred Image
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        ImageIO.write(bImage, "png", output);
//        String base64Image = Base64.getEncoder().encodeToString(output.toByteArray());

        //=================================
        String selectedFile = request.getParameter("image");
//        String base64Image = product.imageFileToBase64String(selectedFile);
        
        String base64Image = product.imageFileToBase64String(imagePath);
        request.setAttribute("base64Image", base64Image);
        request.setAttribute("servletPath", servletPath);
        request.setAttribute("image", selectedFile);
//        request.setAttribute("filePath", selectedFile);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("testImage.jsp");
        requestDispatcher.forward(request, response);
         
    }
    

}
