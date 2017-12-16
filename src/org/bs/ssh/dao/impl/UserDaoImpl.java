package org.bs.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.bs.ssh.dao.UserDao;
import org.bs.ssh.model.Search;
import org.bs.ssh.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public User login(String username, String password) {
		User user = getByUsername(username);
		if (user == null) {
			throw new RuntimeException("用户名不存在");
		} else {
			if (!password.equals(user.getPassword())) {
				throw new RuntimeException("密码错误");
			}
		}
		return user;
	}
	
	public User getByUsername(String username) {
		User user=null;
		String sql = "select * from t_user where username = ?";
		try {
			user = (User)getSession().createSQLQuery(sql).addEntity(User.class).setParameter(0, username).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void save(User user) {
		getSession().save(user);
	}
	
	public void update(User user) {
		getSession().update(user);
	}
	
	public void delete(User user) {
		getSession().delete(user);
	}
	
	public User getById(int id) {
		return (User)getSession().load(User.class, id);
	}
	
	public List<User> query(String str) {
		return getSession().createQuery("from User").list();
	}


	public List<User> query(Search search) {
		return getSession().createQuery("from User").list();
	}


	
	private Session getSession(){
		return  sessionFactory.getCurrentSession();
	}

}
