package controller;

import model.domain.Card;
import model.da.CardDA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddCard", urlPatterns = {"/AddCard"})
public class AddCard extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();

        String holderName = request.getParameter("holderName");
        String cardType = request.getParameter("cards");
        String cardNum = request.getParameter("cardnum");
        String months = request.getParameter("months");
        int years = Integer.parseInt(request.getParameter("years"));

        CardController cardControl = new CardController();
        Card card = new Card(cardNum, holderName,  cardType, months, years);

        boolean success = cardControl.insertRecord(card);
        if (success) {
                response.sendRedirect("PaymentReport.jsp");
                  
        }
    }
}
