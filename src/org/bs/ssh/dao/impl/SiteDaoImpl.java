package org.bs.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.bs.ssh.dao.SiteDao;
import org.bs.ssh.model.Site;
import org.bs.ssh.model.Search;
import org.bs.ssh.utils.PageContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository("siteDao")
public class SiteDaoImpl implements SiteDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(Site site) {
		getSession().save(site);
	}

	public void update(Site site) {
		getSession().update(site);
	}
	
	public void delete(Site site) {
		getSession().delete(site);
	}

	public Site getById(int id) {
		return (Site)getSession().load(Site.class, id);
	}
	
	public Site getByUserId(int id) {
		Site site=null;
		String sql = "select * from t_site where users = ?";
		try {
			site = (Site)getSession().createSQLQuery(sql).addEntity(Site.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return site;
	}
	public List<Site> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_site  where 1=1 ";
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
					.addEntity(Site.class)
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
