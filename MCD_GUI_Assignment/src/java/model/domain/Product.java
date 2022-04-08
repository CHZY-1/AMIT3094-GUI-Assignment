package model.domain;

import java.io.Serializable;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    
    
    //Setter

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
    
    public void setBase64Image(String imgStringBase64){
        this.base64Image = imgStringBase64;
    }
    
    public void setBase64ImageFromBytes(byte[] imageBytes){
        try {
            String imgBase64String = Product.convertByteToBase64(imageBytes);
            setBase64Image(imgBase64String);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public String getProductImageBase64() throws UnsupportedEncodingException {
        return Product.convertByteToBase64(productImage);
    }
    
    public String getFileExtension(String filePath){
        String extension = "";
        int i = filePath.lastIndexOf('.');
           if (i > 0) {
               extension = filePath.substring(i+1);
           }
           
         return extension;
    }
    
    public void setImageFile(String imageFilePath) throws FileNotFoundException,IOException {
//        BufferedImage bImage = null;
//        File imageFile = new File(imageFilePath);
//        bImage = ImageIO.read(imageFile);
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        ImageIO.write(bImage, "png", output);
//
//        imgByte = output.toByteArray();

        byte[] imgByte = null;
        imgByte = Product.convertImageToBytes(imageFilePath);
        setProductImage(imgByte);
    }
    
    public String imageFileToBase64String(String imageFilePath){
        
        String base64Image = "";
        byte[] imageBytes = null;
        BufferedImage bImage = null;
        
        try{
//            File imageFile = new File(imageFilePath);
//            bImage = ImageIO.read(imageFile); //renderred Image
//            ByteArrayOutputStream output = new ByteArrayOutputStream();
//            ImageIO.write(bImage, "png", output);
            imageBytes = Product.convertImageToBytes(imageFilePath);
            base64Image = Product.convertByteToBase64(imageBytes);
//            base64Image = Base64.getEncoder().encodeToString(output.toByteArray());
//            System.out.println(base64Image);
//            
//            bImage.flush();
//            output.close();
            
            
        }catch(IOException ex){
            ex.getMessage();
        }
        
        return base64Image;
    }
    
    public static byte[] convertImageToBytes(String imagePath) throws IOException{
        //ImageIO Class Documentation
        //https://docs.oracle.com/javase/7/docs/api/javax/imageio/ImageIO.html#read(java.io.InputStream)
        
        //ImageIO - supported format 
        //GIF, PNG, JPEG, BMP, and WBMP
        
        File imgFile = new File(imagePath);
        
        //ImageIO.read() is for reading images in a defined file format, not reading pixels
        BufferedImage bImage = ImageIO.read(imgFile); //create buffered image object with the File(imagePath)
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        //ImageIO.write is a must to correctly save buffered image into bytes array else the image is null
        ImageIO.write(bImage, "png", baos); //write buffered image into byteArrayOutput Stream
        byte [] data = baos.toByteArray();  //convert content of output stream to byte array
        
        bImage.flush();
        baos.close();
        
        return data;
    }
    
    public static String convertByteToBase64(byte[] bytes) throws UnsupportedEncodingException{
        
//        byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
//        String base64Encoded = new String(encodeBase64, "UTF-8");
        
        String base64Encoded = new String(Base64.getEncoder().encode(bytes), "UTF-8");
        return base64Encoded;
    }
    
    public static BufferedImage byteArrayToBufferedImage(byte[] array) throws IOException {
        InputStream in = new ByteArrayInputStream(array);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        in.close();
        return bImageFromConvert;
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
        Product product = new Product();

        product.setImageFile("C:\\Users\\zyang\\Desktop\\AMIT3094  GUI AND WEB APPLICATION PROGRAMMING\\Projects\\MCD_GUI_Assignment\\web\\Pictures\\apple.jpg");
        System.out.println(Arrays.toString(product.getProductImage()));
    }
}
