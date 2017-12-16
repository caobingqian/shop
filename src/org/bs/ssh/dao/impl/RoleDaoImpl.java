package org.bs.ssh.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.bs.ssh.dao.RoleDao;
import org.bs.ssh.model.Role;
import org.bs.ssh.utils.PageContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(Role role) {
		getSession().save(role);
	}

	public void update(Role role) {
		getSession().update(role);
	}
	
	public void delete(Role role) {
		getSession().delete(role);
	}

	public Role getById(int id) {
		return (Role)getSession().load(Role.class, id);
	}
	
	public List<Role> query(String str) {
		List list=null;
		String sql = "select * from t_role";
		String sqlRecordsCount = "select count(*) "
				+ sql.substring(sql.indexOf("from"));
		sql += " limit ?,?";
		try {
			Integer recordsCount = Integer.valueOf(getSession().createSQLQuery(sqlRecordsCount).uniqueResult().toString());
			PageContext.getPage().setRecordsCount(recordsCount.intValue());
			list =	getSession().createSQLQuery(sql)
					.addEntity(Role.class)
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
