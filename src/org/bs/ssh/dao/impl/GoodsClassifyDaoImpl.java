package org.bs.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.bs.ssh.dao.GoodsClassifyDao;
import org.bs.ssh.model.GoodsClassify;
import org.bs.ssh.model.Search;
import org.bs.ssh.utils.PageContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository("goodsClassifyDao")
public class GoodsClassifyDaoImpl implements GoodsClassifyDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(GoodsClassify goodsClassify) {
		getSession().save(goodsClassify);
	}

	public void update(GoodsClassify goodsClassify) {
		getSession().update(goodsClassify);
	}
	
	public void delete(GoodsClassify goodsClassify) {
		getSession().delete(goodsClassify);
	}

	public GoodsClassify getById(int id) {
		return (GoodsClassify)getSession().load(GoodsClassify.class, id);
	}
	
	public GoodsClassify getByUserId(int id) {
		GoodsClassify goodsClassify=null;
		String sql = "select * from t_goodsClassify where users = ?";
		try {
			goodsClassify = (GoodsClassify)getSession().createSQLQuery(sql).addEntity(GoodsClassify.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsClassify;
	}
	public List<GoodsClassify> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_goodsClassify  where 1=1 ";
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
					.addEntity(GoodsClassify.class)
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
