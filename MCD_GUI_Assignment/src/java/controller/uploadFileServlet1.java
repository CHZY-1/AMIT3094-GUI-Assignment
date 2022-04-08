package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.domain.Product;
import model.domain.ProductCategory;
import controller.ProductController;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "uploadFileServlet1", urlPatterns = {"/uploadFileServlet1"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class uploadFileServlet1 extends HttpServlet {
    
    public static final String UPLOAD_DIR = "images";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String servletDirectory = getServletContext().getRealPath("/"); //Absolute Path (servlet dir)
        String uploadDirPath = servletDirectory + UPLOAD_DIR; // concat servlet dir path and the name of upload folder
        String uploadImagePath = "";
        
        //Create new directory for uploading product image
        File directory = new File(uploadDirPath);
            if (! directory.exists()){
                directory.mkdir();
            }
            
        try {
            
            //Upload Image file to upload dir
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> imageFile = servletFileUpload.parseRequest(request);
            
            for(FileItem file: imageFile){
                
                //Absolute Path (image file)
                uploadImagePath = uploadDirPath + "/" + file.getName();
                
                File image = new File(uploadImagePath);
                
                //check if image file exists in the upload dir
                if(!image.exists()){
                    file.write(image);
                }
                
            }
            
            int success = 0;
            //Test db
            Product product = new Product("Prod-1a", "Banana", 8.50, 10, new ProductCategory("C1", "Burger"));
            product.setImageFile(uploadImagePath);
            
//            ProductController prodController = new ProductController();
//            success = prodController.insertProduct(product);
            
            String base64Image = product.imageFileToBase64String(uploadImagePath);
            request.setAttribute("imageByte", product.getProductImage());
            request.setAttribute("base64Image", base64Image);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("testImage.jsp");
            requestDispatcher.forward(request, response);
            
//            out.println("<html><body>"+uploadImagePath+"<body></html>");
            
        } catch (FileUploadException ex) {
            ex.getMessage();
            out.println("<html><body>File Upload Exception :"+uploadImagePath+" <body></html>");
        } catch (SQLException ex) {
            out.println("<html><body>SQL Exception :"+ex.getMessage()+"<body></html>");
        }catch (IOException ex) {
            out.println("<html><body>IO Exception :"+ ex.getMessage() +"<body></html>");
        }catch (Exception ex) {
            out.println("<html><body>Exception :"+ex.getMessage()+"<body></html>");
        }
    }

}
