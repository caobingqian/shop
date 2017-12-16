package org.bs.ssh.hibernate.dao;

import junit.framework.TestCase;

import org.bs.ssh.dao.UserDao;
import org.bs.ssh.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserDaoTest extends TestCase {

	public void testSave() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = factory.getBean(UserDao.class);
		User u = new User();
		u.setUsername("����");
		u.setPassword("zjhangsan");
		userDao.save(u);
	}

}
