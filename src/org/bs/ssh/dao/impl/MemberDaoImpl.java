package org.bs.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.bs.ssh.dao.MemberDao;
import org.bs.ssh.model.Member;
import org.bs.ssh.model.Search;
import org.bs.ssh.utils.PageContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(Member member) {
		getSession().save(member);
	}

	public void update(Member member) {
		getSession().update(member);
	}
	
	public void delete(Member member) {
		getSession().delete(member.getUsers());
		getSession().delete(member);
	}

	public Member getById(int id) {
		return (Member)getSession().load(Member.class, id);
	}
	
	public Member getByUserId(int id) {
		Member member=null;
		String sql = "select * from t_member where users = ?";
		try {
			member = (Member)getSession().createSQLQuery(sql).addEntity(Member.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	public List<Member> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_member  where 1=1 ";
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
					.addEntity(Member.class)
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
