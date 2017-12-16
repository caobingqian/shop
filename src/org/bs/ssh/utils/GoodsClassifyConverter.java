package org.bs.ssh.utils;

import org.bs.ssh.model.GoodsClassify;import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

public class GoodsClassifyConverter extends StrutsTypeConverter{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		GoodsClassify goodsClassify =null;
		if (toClass == GoodsClassify.class){
			 goodsClassify = new GoodsClassify();
			 goodsClassify.setId(Integer.parseInt((String)dateString));
		}
		return goodsClassify;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((GoodsClassify)o).toString();
	}

}
