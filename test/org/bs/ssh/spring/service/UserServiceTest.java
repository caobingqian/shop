package org.bs.ssh.spring.service;

import junit.framework.TestCase;

import org.bs.ssh.model.User;
import org.bs.ssh.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserServiceTest extends TestCase {

	public void testAddUser() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = factory.getBean(UserService.class);
		User u = new User();
		u.setUsername("����11");
		u.setPassword("zjhangsan");
		userService.add(u);
	}

	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	public void testDel() {
		fail("Not yet implemented");
	}

	public void testFindUser() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = factory.getBean(UserService.class);
		User user = userService.findById(1);
		System.out.println(user.getUsername());
	}

	public void testFindAllUsers() {
		fail("Not yet implemented");
	}

}
