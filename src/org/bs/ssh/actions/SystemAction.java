package org.bs.ssh.actions;

import java.io.PrintWriter;

import javax.annotation.Resource;

import org.bs.ssh.model.User;
import org.bs.ssh.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("sysAction")
@Scope("prototype")
public class SystemAction extends BaseAction{
	
	@Resource
	private UserService userService;
	
	public String checkOld() throws Exception{
		response.setContentType("text/plain");
  		response.setHeader("Cache-Control", "no-cache");
		User user = (User) request.getSession().getAttribute("login_user");
		String s = request.getParameter("password");
        PrintWriter out=response.getWriter();
        if(user.getPassword().equals(s))
        	out.write("1");
        else 
        	out.write("0");
        out.flush();
        out.close();
		return null;
	}
	public String updatePassword(){
		User user = (User) request.getSession().getAttribute("login_user");
		String password = request.getParameter("new");
		user.setPassword(password);
		userService.update(user);
		return "update_password_success";
	}
	public String updatePassword1(){
		User user = (User) request.getSession().getAttribute("login_user");
		String password = request.getParameter("new");
		user.setPassword(password);
		userService.update(user);
		return "update_member_password_success";
	}
	
	


	
	
}
