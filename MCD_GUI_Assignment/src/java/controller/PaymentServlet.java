package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.da.PaymentDA;
import model.domain.*;

@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        
        try{
        
        //Customer in session
        Customer customer = (Customer) session.getAttribute("customer");
        
        
        //Card
        String cardNum = request.getParameter("cardNum");
        String cardHolderName = request.getParameter("cardHolderName");
        String cardType = request.getParameter("cards");
        String expiredMonth = request.getParameter("months");
        int expiredYear = Integer.parseInt(request.getParameter("years"));
        
        Card card = new Card(cardNum, cardHolderName, cardType, expiredMonth, expiredYear);
        
        // insert card
        CardController cardControl = new CardController();
        boolean cardInsertSuccess = cardControl.insertRecord(card);
        
        out.println("Card Insert Success: " + cardInsertSuccess);
        
        // Payment
        Payment payment = new Payment();
        
        String paymentID = request.getParameter("paymentID");
        String paymentMethod = request.getParameter("payment-method-radios");
        double totalPaymentAmount = (Double) session.getAttribute("totalPrice");
        String orderStatus = "Order Placed";
        Timestamp paymentTime = payment.getPaymentTimestamp();
        
        
        
        
        PaymentDA paymentDA = new PaymentDA();
        payment = new Payment(paymentDA.newPaymentID(), paymentMethod, totalPaymentAmount, orderStatus, paymentTime, customer, card);
        
        int affectedRows = paymentDA.insertPayment(payment);
        
        out.println("Payment Insert Success: " + cardInsertSuccess);
        
        // Orders
        
        Orders order= new Orders();
        OrderController orderControl = new OrderController();
        
        ArrayList<Product> cartProductList =(ArrayList<Product>) session.getAttribute("cart");
         ArrayList<Orders> orderList = new ArrayList<Orders>();
        
        String comment = "";
        String rating = "";
        int ordersinsertSuccess = 0;
        
        String orderID = orderControl.generateNewOrderID();
        
        // Loop every product in the cart List
        for (Product product : cartProductList){
            
            orderList.add(new Orders(orderID, comment, rating, product.getOrderQuantity(), product, payment));
            
            orderID = orderIdIncrement(orderID);
                    
        }
        
        
        ordersinsertSuccess = orderControl.insertMultipleOrders(orderList);
        
        out.println("Orders Insert Success: " + ordersinsertSuccess);
        
        if(ordersinsertSuccess > 0){
            session.removeAttribute("cart");
            session.removeAttribute("totalPrice");
            
            response.sendRedirect("Home.jsp");
        }
        
        String deliveryTimeOption = request.getParameter("delivery-time-radios");
        String deliveryLaterDate = request.getParameter("delivery-later-date");
        String deliveryLaterTime = request.getParameter("delivery-later-time");
        
        
        
           
        }catch(SQLException | NullPointerException ex){
            out.println(ex.getMessage());
        }
        
    }
    
    protected String orderIdIncrement(String orderID) {
        String[] id = orderID.split("-");
        int no = Integer.parseInt(id[1]);
        no +=1 ;
        String seq = String.format("%03d", no);
        String PID = id[0] + "-" + seq;
        return PID;
    }

}
