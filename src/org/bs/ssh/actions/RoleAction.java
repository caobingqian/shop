package org.bs.ssh.actions;

import javax.annotation.Resource;

import org.bs.ssh.model.Role;
import org.bs.ssh.service.RoleService;
import org.bs.ssh.utils.PageContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction{
	
	@Resource
	private RoleService roleService;
	private Role role;
	
	public String addInput() {
		return "add_input";
	}
	
	public String add(){
		roleService.add(role);
		return "add_success";
	}
	public String delete(){
		roleService.delete(role);
		return "showlist";
	}
	public String deleteBetch(){
		String[] roleIds = request.getParameterValues("roleCheckbox");
		if(roleIds!=null){
			for (int i = 0; i < roleIds.length; i++) {
				roleService.delete(roleService.findById(Integer
						.parseInt(roleIds[i])));
			}
		}
		return "showlist";
	}
	public String modify(){
		request.setAttribute("role", roleService.findById(role.getId()));
		return "update_role_input";
	}
	public String update(){
		Role roles =role;
		roleService.update(role);
		return "showlist";
	}
	
	public String get(){
		return "get";
	}
	public String list(){
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("roleList", roleService.search(""));
		return "list";
	}
	
	
	public Object getModel() {
		if(role == null){
			role = new Role();
		}
		return role;
	}


	
	
}
