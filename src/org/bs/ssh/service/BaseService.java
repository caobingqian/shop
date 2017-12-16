package org.bs.ssh.service;


public interface BaseService{
	public void sessionClear();
	public void sessionFlush();
	public void sessionRefresh(Object object);
}

