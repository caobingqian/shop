package org.bs.ssh.utils;

import org.bs.ssh.model.News;import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

public class NewsConverter extends StrutsTypeConverter{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		News news =null;
		if (toClass == News.class){
			 news = new News();
			 news.setId(Integer.parseInt((String)dateString));
		}
		return news;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((News)o).toString();
	}

}
