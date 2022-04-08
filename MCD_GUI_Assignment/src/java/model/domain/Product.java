package model.domain;

import java.io.Serializable;
import java.sql.Blob;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import javax.imageio.ImageIO;

public class Product implements Serializable {
 
    private String productID;
    private String productName;
    private byte[] productImage;
    private String base64Image;
    private double productPrice;
    private int orderQuantity;
    private ProductCategory productCategory;

    public Product(){}
    
    public Product(String productID, String productName, double productPrice, int orderQuantity, ProductCategory productCategory) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.orderQuantity = orderQuantity;
        this.productCategory = productCategory;
    }

    public Product(String productID, String productName, byte[] productImage, double productPrice, int orderQuantity, ProductCategory productCategory) {
        this.productID = productID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.orderQuantity = orderQuantity;
        this.productCategory = productCategory;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
    
    

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    
    public String getFileExtension(String filePath){
        String extension = "";
        int i = filePath.lastIndexOf('.');
           if (i > 0) {
               extension = filePath.substring(i+1);
           }
           
         return extension;
    }
    
//    public void setImageFile(String filePath){
//        try{
//            
//            File file = new File(filePath);
//            
//            BufferedImage Image = ImageIO.read(file);
//
//            String fileExtension = getFileExtension(filePath);
//            
//            byte[] imageInByte;
//            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//                baos.flush();
//                imageInByte = baos.toByteArray();
//            }
//            
//            setProductImage(imageInByte);
//            
//        }catch(FileNotFoundException ex){
//            ex.getMessage();
//        }catch(IOException ex){
//            ex.getMessage();
//        }
//        
//    }
    
    public void setImageFile(String imageFilePath) throws FileNotFoundException,IOException {
        
        BufferedImage bImage = null;
        byte[] imgByte = null;
        
        File imageFile = new File(imageFilePath);
        bImage = ImageIO.read(imageFile);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
//            ImageIO.write(bImage, "jpg", output);

        imgByte = output.toByteArray(); //convert stream to byte array format
        setProductImage(imgByte);
        
    }
    
    public String imageFileToBase64String(String imageFilePath){
        
        String base64Image = "";
        BufferedImage bImage = null;
        
        try{
            File imageFile = new File(imageFilePath);
//            System.out.println(getClass().getResource("../image/apple.jpg").getFile());
//            bImage = ImageIO.read(getClass().getResource("../image/apple.jpg")); //renderred Image
            bImage = ImageIO.read(imageFile); //renderred Image
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", output);
            
            base64Image = Base64.getEncoder().encodeToString(output.toByteArray());
//            System.out.println(base64Image);
        }catch(IOException ex){
            ex.getMessage();
        }
        
        return base64Image;
    }
    
    public static byte[] convertImageToBytes(String imagePath) throws IOException{
        
//        BufferedImage Image = ImageIO.read(file);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        byte [] data = baos.toByteArray();
//        
//        return data;
        File imgFile = new File(imagePath);
        BufferedImage bufferedImage = ImageIO.read(imgFile);
        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage .getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

        return ( data.getData() );
    }
    
    public static String convertByteToBase64(byte[] bytes) throws UnsupportedEncodingException{
//        byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
//        String base64Encoded = new String(encodeBase64, "UTF-8");
        String base64Encoded = new String(Base64.getEncoder().encode(bytes), "UTF-8");
        return base64Encoded;
    }
    
    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", "
                + "productName=" + productName + ", "
                + "productImage=" + productImage + ", "
                + "productPrice=" + productPrice + ", "
                + "orderQuantity=" + orderQuantity + ", "
                + "productCategory=" + productCategory + '}';
    }
    
    public static void main(String args[]) throws IOException{
//        File file = new File("C:\\Users\\zyang\\Desktop\\AMIT3094  GUI AND WEB APPLICATION PROGRAMMING\\Projects\\MCD_GUI_Assignment\\web\\Pictures\\apple.jpg");
        Product product = new Product();
//        byte[] imageByte = Product.convertImageToBytes("C:\\Users\\zyang\\Desktop\\AMIT3094  GUI AND WEB APPLICATION PROGRAMMING\\Projects\\MCD_GUI_Assignment\\web\\Pictures\\apple.jpg");
//        System.out.println(imageByte.length);
//        for(int i=0; i< imageByte.length ; i++) {
//         System.out.println(imageByte[i] +" ");
//         }

        product.imageFileToBase64String("C:\\Users\\zyang\\Desktop\\AMIT3094  GUI AND WEB APPLICATION PROGRAMMING\\Projects\\MCD_GUI_Assignment\\web\\Pictures\\apple.jpg");
    }
}
