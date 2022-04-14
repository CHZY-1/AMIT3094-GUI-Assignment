package controller;
 
import java.sql.SQLException;
import model.da.PaymentDA;
import model.domain.Payment;

public class PaymentController {

    private PaymentDA paymentDA;

    public void PaymentController() throws SQLException {
        paymentDA = new PaymentDA();
    }
    
    public Payment retievePayment(String paymentID) throws SQLException {
        return paymentDA.retievePaymentRecord(paymentID); 
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