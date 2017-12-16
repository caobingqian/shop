package org.bs.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.bs.ssh.dao.CommentsDao;
import org.bs.ssh.model.Comments;
import org.bs.ssh.model.Search;
import org.bs.ssh.utils.PageContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository("commentsDao")
public class CommentsDaoImpl implements CommentsDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(Comments comments) {
		getSession().save(comments);
	}

	public void update(Comments comments) {
		getSession().update(comments);
	}
	
	public void delete(Comments comments) {
		getSession().delete(comments);
	}

	public Comments getById(int id) {
		return (Comments)getSession().load(Comments.class, id);
	}
	
	public Comments getByUserId(int id) {
		Comments comments=null;
		String sql = "select * from t_comments where users = ?";
		try {
			comments = (Comments)getSession().createSQLQuery(sql).addEntity(Comments.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comments;
	}
	public List<Comments> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_comments  where 1=1 ";
		if(search.getType().equals("string")){
			sql+=" and name like '%"+search.getString()+"%' ";
		}
		if(!search.getAuthorityName().equals("")){
			sql+=" and "+search.getAuthorityName()+" = "+search.getAuthorityValue()+" ";
		}
		String sqlRecordsCount = "select count(*) "
				+ sql.substring(sql.indexOf("from"));
		sql += " limit ?,?";
		try {
			Integer recordsCount = Integer.valueOf(getSession().createSQLQuery(sqlRecordsCount).uniqueResult().toString());
			PageContext.getPage().setRecordsCount(recordsCount.intValue());
			list =	getSession().createSQLQuery(sql)
					.addEntity(Comments.class)
					.setParameter(0, PageContext.getPage().getPageIndex())
					.setParameter(1, PageContext.getPage().getPageSize())
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	private Session getSession(){
		return  sessionFactory.getCurrentSession();
	}



}
