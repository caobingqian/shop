package org.bs.ssh.spring.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class MessageServiceTest extends AbstractTransactionalJUnit38SpringContextTests {

//	@Resource
//	private MessageService messageService;
//	
//	public void testSendMessage(){
//		messageService.sendMessage("xxx", "xxxxx", 1, 2);
//	}
}
