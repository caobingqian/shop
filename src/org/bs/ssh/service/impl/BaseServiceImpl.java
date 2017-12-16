package org.bs.ssh.service.impl;

import javax.annotation.Resource;

import org.bs.ssh.service.BaseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service("baseService")
public class BaseServiceImpl implements BaseService {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public void sessionClear() {
		getSession().clear();
	}
	@Override
	public void sessionFlush() {
		getSession().flush();
	}
	@Override
	public void sessionRefresh(Object object) {
		getSession().refresh(object);
	}
	private Session getSession(){
		return  sessionFactory.getCurrentSession();
	}
}
