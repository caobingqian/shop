package org.bs.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.bs.ssh.dao.UserDao;
import org.bs.ssh.model.Role;
import org.bs.ssh.model.Search;
import org.bs.ssh.model.User;
import org.bs.ssh.service.UserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public void add(User user) {
		userDao.save(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}
	
	public void update(User user) {
		userDao.update(user);
	}

	public User findById(int id) {
		return userDao.getById(id);
	}

	public User findByUsername(String username) {
		return userDao.getByUsername(username);
	}
	
	public List<User> search(String str) {
		return userDao.query(str);
	}
	public List<User> search(Search search) {
		return userDao.query(search);
	}

}
