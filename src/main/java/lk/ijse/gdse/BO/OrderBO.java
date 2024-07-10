package lk.ijse.gdse.BO;

import lk.ijse.gdse.DTO.OrderDTO;
import lk.ijse.gdse.Entity.Order;

import java.sql.SQLException;

public interface OrderBO extends SuperBO{
    public String getCurrentId() throws SQLException;

    public boolean saveOrder(OrderDTO order) throws SQLException;
}
