package org.bs.ssh.utils;

import org.bs.ssh.model.Goods;import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

public class GoodsConverter extends StrutsTypeConverter{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		Goods goods =null;
		if (toClass == Goods.class){
			 goods = new Goods();
			 goods.setId(Integer.parseInt((String)dateString));
		}
		return goods;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((Goods)o).toString();
	}

}
