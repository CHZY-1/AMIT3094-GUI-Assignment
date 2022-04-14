package model.da;

import model.domain.Orders;
import model.domain.Payment;
import model.domain.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class OrderDA {

    private String host = "jdbc:derby://localhost:1527/MCD";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ORDERS";
    private Connection conn;
    private PreparedStatement stmt;

    public OrderDA() throws SQLException {
        try {
            createConnection();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public OrderDA(String user, String password, String tableName) throws SQLException {
        this.user = user;
        this.password = password;
        this.tableName = tableName;

        try {
            createConnection();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public Orders getOrder(String orderID) throws SQLException {
        String queryStr = "SELECT * FROM " + tableName + " WHERE ORDER_ID = ?";
        Orders orders = null;

        try {
            //bind query and parameter
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, orderID);
            //execute query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                orders = new Orders(orderID,
                        rs.getString("COMMENT"),
                        rs.getString("RATING"),
                        rs.getInt("ORDER_QUANTITY"),
                        new Product(rs.getString("PRODUCT_ID")),
                        new Payment(rs.getString("PAYMENT_ID")));
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return orders;
    }

    public ArrayList<Orders> getAllOrder() throws SQLException {
        String queryStr = "SELECT * FROM " + tableName;
        Orders orders = null;
        ArrayList<Orders> orderList = new ArrayList<>();

        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                orders = new Orders( rs.getString("ORDER_ID"),
                        rs.getString("COMMENT"),
                        rs.getString("RATING"),
                        rs.getInt("ORDER_QUANTITY"),
                        new Product(rs.getString("PRODUCT_ID")),
                        new Payment(rs.getString("PAYMENT_ID")));

                orderList.add(orders);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            throw ex;
        }
        return orderList;
    }

    public int insertNewOrder(Orders orders) throws SQLException {
        String sqlStr = "INSERT INTO ORDERS VALUES(?,?,?,?,?,?)";
        int rows = 0;

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, orders.getOrderId());
            stmt.setInt(2, orders.getOrderQuantity());

            rows = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return rows;
    }

    public int updateOrder(Orders orders) throws SQLException {
        String sqlStr = "UPDATE ORDERS SET ORDERS_ID=?, "
                + "ORDERS_ID=?, "
                + "ORDERS_QUANTITY=?, "
                + "COMMENT=?, "
                + "RATING=?, "
                + "PAYMENT_ID=?, "
                + "PRODUCT_ID=? "
                + "WHERE PRODUCT_ID=?";
        int rows = 0;

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, orders.getOrderId());
            stmt.setInt(2, orders.getOrderQuantity());
            stmt.setString(3, orders.getComment());
            stmt.setString(4, orders.getRating());
            stmt.setString(5, orders.getPayment().getPaymentID());
            stmt.setString(6, orders.getProduct().getProductID());

            rows = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return rows;
    }

    public int deleteOrder(String orderID) throws SQLException {
        String sqlStr = "DELETE FROM ORDERS WHERE ORDER_ID = ?";
        int rows = 0;

        try {
            stmt = conn.prepareStatement(sqlStr);

            stmt.setString(1, orderID);

            rows = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            throw ex;
        }

        return rows;
    }

    //create connection object
    private void createConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            throw ex;
        }
    }

    //close connection object
    private void shutDown() throws SQLException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
}
