package org.bs.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.bs.ssh.dao.RoleDao;
import org.bs.ssh.model.Role;
import org.bs.ssh.service.RoleService;
import org.springframework.stereotype.Service;


@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	public void add(Role role) {
		roleDao.save(role);
	}

	public void delete(Role role) {
		roleDao.delete(role);
	}

	public void update(Role role) {
		roleDao.update(role);
	}

	public Role findById(int id) {
		return roleDao.getById(id);
	}
	

	public List<Role> search(String str) {
		return roleDao.query(str);
	}



}
