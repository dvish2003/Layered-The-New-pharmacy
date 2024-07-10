package lk.ijse.gdse.BO.Impl;

import lk.ijse.gdse.BO.*;
import lk.ijse.gdse.DAO.*;
import lk.ijse.gdse.DAO.Impl.ItemDAOImpl;
import lk.ijse.gdse.DAO.Impl.OrderDAOImpl;
import lk.ijse.gdse.DAO.Impl.OrderDetailDAOImpl;
import lk.ijse.gdse.DAO.Impl.PaymentDAOImpl;
import lk.ijse.gdse.DB.DbConnection;
import lk.ijse.gdse.DTO.PlaceOrderDTO;
import lk.ijse.gdse.Entity.OrderDetails;
import lk.ijse.gdse.Entity.PlaceOrder;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    @Override
    public boolean placeOrder(PlaceOrderDTO po) throws SQLException {
            Connection connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

        PaymentBO paymentBO =  new PaymentBOImpl();
        OrderBO orderBO =  new OrderBOImpl();
        ItemBO itemBO =  new ItemBOImpl();
        OrderDetailsBO orderDetailsBO = new OrderDetailsBOImpl();


            try {
                boolean isPayUpdated = paymentBO.savePayment(po.getPayment());
                if (isPayUpdated) {
                    boolean isOrderSaved = orderBO.saveOrder(po.getOrder());
                    if (isOrderSaved) {
                        boolean isQtyUpdated = itemBO.update1(po.getOdList());
                        if (isQtyUpdated) {
                            boolean isOrderDetailSaved = orderDetailsBO.save(po.getOdList());
                            if (isOrderDetailSaved) {
                                connection.commit();
                                return true;
                            }
                        }
                    }
                }
                connection.rollback();
                return false;
            } catch (Exception e) {
                connection.rollback();
                return false;
            } finally {
                connection.setAutoCommit(true);
            }
    }
}
