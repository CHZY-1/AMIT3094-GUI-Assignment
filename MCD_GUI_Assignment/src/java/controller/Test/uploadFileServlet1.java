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
        //Sample Path - NetbeanProjectAbsolutePath\\web\\images(UPLOAD_DIR)
        
        String uploadImagePath = "";
        
        //Create a new directory for uploading product image
        File directory = new File(uploadDirPath);
            if (! directory.exists()){ //Create a new directory if not exists
                directory.mkdir();
            }
            
        try {
            
            //org.apache.commons.fileupload Library
            
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
            
           
            
            //Test db
            int success = 0;
            ProductCategory fruits = new ProductCategory("F1","Fruits");
//            Product product1 = new Product("Prod-1a", "Apple", 8.50, false, new ProductCategory("C1", "Burger"));
//            product1.setImageFile(uploadImagePath);
            
//            Product product2 = new Product("Prod-1b", "Banana", 7.50, false, new ProductCategory("C1", "Burger"));
//            product2.setImageFile(uploadImagePath);
            
            ProductController prodController = new ProductController();
//            success = prodController.insertProduct(product1);
//            success = prodController.insertProduct(product2);
            
            //Product1
            Product productReturned1 = prodController.getProductByID("Prod-1a");
            String productImage1 =  productReturned1.getProductImageBase64();
            request.setAttribute("imageByte", productReturned1.getProductImage());
            request.setAttribute("productImage1", productImage1);
            
            //Product2
            Product productReturned2 = prodController.getProductByID("Prod-1b");
            String productImage2 =  productReturned2.getProductImageBase64();
            request.setAttribute("imageByte", productReturned2.getProductImage());
            request.setAttribute("productImage2", productImage2);
            
//            String base64Image = product.imageFileToBase64String(uploadImagePath);
//            request.setAttribute("base64Image", base64Image);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("testImage.jsp");
            requestDispatcher.forward(request, response);
            
//            out.println("<html><body>"+uploadImagePath+"<body></html>");
            
        } catch (FileUploadException ex) {
            out.println("<html><body>File Upload Exception :"+ex.getMessage() +"<br/>File Path: "
                    +uploadImagePath+" <body></html>");
        } catch (SQLException ex) {
            out.println("<html><body>SQL Exception :"+ex.getMessage()+"<body></html>");
        }catch (IOException ex) {
            out.println("<html><body>IO Exception :"+ ex.getMessage() +"<body></html>");
        }catch (Exception ex) {
            out.println("<html><body>Exception :"+ex.getMessage()+"<body></html>");
        }
    }

}
