package org.bs.ssh.service.impl;

import java.util.List;
import javax.annotation.Resource
;import org.springframework.stereotype.Service;
import org.bs.ssh.dao.OrdersDao;
import org.bs.ssh.model.Orders;
import org.bs.ssh.model.Search;
import org.bs.ssh.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl extends BaseServiceImpl implements OrdersService {
	@Resource
	OrdersDao ordersDao ;
	public void add(Orders orders) {
		ordersDao.save(orders);
	}

	public void delete(Orders orders) {
		ordersDao.delete(orders);
	}

	public void update(Orders orders) {
		ordersDao.update(orders);
	}

	public Orders findById(int id) {
		return ordersDao.getById(id);
	}

	public Orders findByUserId(int id) {
		return ordersDao.getByUserId(id);
	}

	public List<Orders> search(Search search) {
		return ordersDao.query(search);
	}

}
