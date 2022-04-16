// Author:Sew Min Yan
// Description:To make the connection to the Card table and able to save card details into database 
package model.da;

import model.domain.Card;
import java.sql.*;

public class CardDA {

    private String host = "jdbc:derby://localhost:1527/MCD";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "CARD";
    private Connection conn;
    private PreparedStatement stmt;

    public CardDA() {
        createConnection();
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
        }
    }

    //create
    public boolean addRecord(Card card) {
        boolean success = true;

        String sqlStr = "INSERT INTO " + tableName + " VALUES (?,?,?,?,?) ";
        try {
            if (success = true) {
                stmt = conn.prepareStatement(sqlStr);

                stmt.setString(1, card.getCardNo());
                stmt.setString(2, card.getCardHolderName());
                stmt.setString(3, card.getCardType());
                stmt.setString(4, card.getExpiredMonth());
                stmt.setInt(5, card.getExpiredYear());
                stmt.executeUpdate();

                stmt.close();
            } else {
                success = false;
            }
        } catch (SQLException ex) {
        }
        return success;
    }

    public Card getRecord(String CardNo) {

        String queryStr = "SELECT * FROM " + tableName + " WHERE CARD_No = ?";

        Card card = null;

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, CardNo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                card = new Card(CardNo, rs.getString("Card_Holder_Name"), rs.getString("Card_Type"), rs.getString("Expired_Month"), rs.getInt("Expired_Year"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return card;
    }

    //change 
    public void updateRecord(Card p) {
        String queryStr = "UPDATE " + tableName + " SET Card_No = ?, Card_Holder_Name =? getCard_Type =?, Expired_Month, WHERE Expired_Year =?";
        try {
            stmt.setString(1, p.getCardNo());
            stmt.setString(2, p.getCardHolderName());
            stmt.setString(3, p.getCardType());
            stmt.setString(4, p.getExpiredMonth());
            stmt.setFloat(5, p.getExpiredYear());
            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException ex) {
        }
    }

    public void deleteRecord(String CardNo) {
        String queryStr = "DELETE FROM " + tableName + " WHERE Code = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, CardNo);
            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException ex) {
        }
    }

    public static void main(String[] args) {
        CardDA da = new CardDA();
        Card card = da.getRecord("IA");
        System.out.println(card);
    }

}
