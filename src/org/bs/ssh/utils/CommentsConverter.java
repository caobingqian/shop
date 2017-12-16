package org.bs.ssh.utils;

import org.bs.ssh.model.Comments;import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

public class CommentsConverter extends StrutsTypeConverter{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		Comments comments =null;
		if (toClass == Comments.class){
			 comments = new Comments();
			 comments.setId(Integer.parseInt((String)dateString));
		}
		return comments;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((Comments)o).toString();
	}

}
