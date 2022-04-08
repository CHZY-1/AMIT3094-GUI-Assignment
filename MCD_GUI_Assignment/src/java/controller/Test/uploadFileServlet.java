
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "uploadFileServlet", urlPatterns = {"/uploadFileServlet"})
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class uploadFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String servletDirectory = getServletContext().getRealPath("/") + "Images/";
        
        File directory = new File(servletDirectory);
            if (! directory.exists()){
                directory.mkdir();
            }
        
        Part filePart = request.getPart("image");
        String fileName = filePart.getSubmittedFileName();
        
        for (Part part : request.getParts()) {
          part.write(servletDirectory + fileName);
        }
        
        request.setAttribute("fileName", fileName);
        request.setAttribute("servletDirectory", servletDirectory);
//        request.setAttribute("filePath", selectedFile);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("image.jsp");
        requestDispatcher.forward(request, response);
        
        
    }


}
