package org.bs.ssh.spring.service;

import javax.annotation.Resource;

import org.bs.ssh.model.User;
import org.bs.ssh.service.UserService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;


@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class UserServiceTest02 extends AbstractTransactionalJUnit38SpringContextTests {

	@Resource
	private UserService userService;

	//@Rollback(false)
	public void testAddUser() {
//		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserService userService = factory.getBean(UserService.class);
		User u = new User();
		u.setUsername("����");
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
//		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserService userService = factory.getBean(UserService.class);
		User user = userService.findById(1);
		System.out.println(user.getUsername());
	}

	public void testFindAllUsers() {
		fail("Not yet implemented");
	}

}
