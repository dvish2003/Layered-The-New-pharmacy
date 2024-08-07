package lk.ijse.gdse.DAO;

import lk.ijse.gdse.DTO.OrderDetailsDTO;
import lk.ijse.gdse.Entity.Item;
import lk.ijse.gdse.Entity.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item>{
    boolean updateQty(String id, int qty) throws SQLException ;

    boolean update1(List<OrderDetails> odList) throws SQLException;
}
