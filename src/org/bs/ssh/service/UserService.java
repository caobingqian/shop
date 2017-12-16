package org.bs.ssh.service;

import java.util.List;

import org.bs.ssh.model.Search;
import org.bs.ssh.model.User;


public interface UserService {
	public void add(User user) ;
	public void update(User user);
	public void delete(User user);
	public User findById(int id);
	public User findByUsername(String username);
	public List<User> search(String str);
	public List<User> search(Search search);
}
