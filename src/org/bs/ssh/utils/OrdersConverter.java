package org.bs.ssh.utils;

import org.bs.ssh.model.Orders;import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

public class OrdersConverter extends StrutsTypeConverter{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		Orders orders =null;
		if (toClass == Orders.class){
			 orders = new Orders();
			 orders.setId(Integer.parseInt((String)dateString));
		}
		return orders;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((Orders)o).toString();
	}

}
