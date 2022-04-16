// Author:Chan Zhi Yang
// Description:A java class that is part of the MVC pattern. This class is a controller class for the PaymentDA class and Payment class. 
package controller.Control;
 
import java.sql.SQLException;
import model.da.PaymentDA;
import model.domain.Payment;

public class PaymentController {

    private PaymentDA paymentDA;

    public void PaymentController() throws SQLException {
        paymentDA = new PaymentDA();
    }

    public int insertPayment(Payment payment) throws SQLException{
        return paymentDA.insertPayment(payment); 
    }
    
    public int updatePayment(Payment payment) throws SQLException {
        return paymentDA.updatePayment(payment); 
    }
    
    public int deletePayment(String paymentID) throws SQLException{
        return paymentDA.deletePayment(paymentID);
    }
    
    public String generateNewPaymentID(){
        return paymentDA.newPaymentID();
    }
    
}