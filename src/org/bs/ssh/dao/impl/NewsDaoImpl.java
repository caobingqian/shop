package org.bs.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.bs.ssh.dao.NewsDao;
import org.bs.ssh.model.News;
import org.bs.ssh.model.Search;
import org.bs.ssh.utils.PageContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository("newsDao")
public class NewsDaoImpl implements NewsDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(News news) {
		getSession().save(news);
	}

	public void update(News news) {
		getSession().update(news);
	}
	
	public void delete(News news) {
		getSession().delete(news);
	}

	public News getById(int id) {
		return (News)getSession().load(News.class, id);
	}
	
	public News getByUserId(int id) {
		News news=null;
		String sql = "select * from t_news where users = ?";
		try {
			news = (News)getSession().createSQLQuery(sql).addEntity(News.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return news;
	}
	public List<News> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_news  where 1=1 ";
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
					.addEntity(News.class)
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
