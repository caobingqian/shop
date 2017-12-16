package org.bs.ssh.spring.service;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageServiceTest02 extends TestCase {

	public void testSendMessage() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MessageService messageService = factory.getBean(MessageService.class);
//		messageService.sendMessage("xxx", "xxxxx", 1, 2);
	}

}
