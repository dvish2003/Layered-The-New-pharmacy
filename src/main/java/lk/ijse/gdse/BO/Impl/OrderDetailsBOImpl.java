package lk.ijse.gdse.BO.Impl;

import lk.ijse.gdse.BO.OrderDetailsBO;
import lk.ijse.gdse.DAO.DAOFactory;
import lk.ijse.gdse.DAO.OrderDetailDAO;
import lk.ijse.gdse.DTO.OrderDetailsDTO;
import lk.ijse.gdse.Entity.OrderDetails;

import java.sql.SQLException;
import java.util.List;

import static lk.ijse.gdse.DAO.Impl.OrderDetailDAOImpl.saveOrderDetails;

public class OrderDetailsBOImpl implements OrderDetailsBO {
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);

    @Override
    public boolean save(List<OrderDetailsDTO> odList) throws SQLException {
        for (OrderDetailsDTO od : odList) {
            boolean isSaved = saveOrderDetails((List<OrderDetails>) od);
            if(!isSaved) {
                return false;
            }
        }
        return true;    }

    @Override
    public boolean saveOrderDetail(OrderDetailsDTO od) throws SQLException {
        return orderDetailDAO.save(new OrderDetails(od.getItemId(),od.getOrderId(),od.getQty(),od.getUnitPrice()));
    }
}
