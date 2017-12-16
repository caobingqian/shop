package org.bs.ssh.dao;

import java.util.List;

import org.bs.ssh.model.Role;

public interface RoleDao {
	public void save(Role role);

	public void delete(Role role);

	public void update(Role role);

	public Role getById(int id);

	public List<Role> query(String str) ;
}