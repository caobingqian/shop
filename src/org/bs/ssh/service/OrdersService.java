package org.bs.ssh.service;

import java.util.List;

import org.bs.ssh.model.Orders;
import org.bs.ssh.model.Search;

public interface OrdersService extends BaseService{
	public void add(Orders orders);
	public void delete(Orders orders);
	public void update(Orders orders);
	public Orders findById(int id);
	public Orders findByUserId(int id);
	public List<Orders> search(Search search);
}

