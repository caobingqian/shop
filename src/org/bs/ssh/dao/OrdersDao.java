package org.bs.ssh.dao;
import java.util.List;
import org.bs.ssh.model.Orders;
import org.bs.ssh.model.Search;
public interface OrdersDao {
public void save(Orders orders);
public void delete(Orders orders);
public void update(Orders orders);
public Orders getById(int id);
public List<Orders> query(Search search);
public Orders getByUserId(int id);
}

