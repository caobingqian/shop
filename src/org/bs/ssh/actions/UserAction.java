package org.bs.ssh.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.bs.ssh.model.User;
import org.bs.ssh.service.UserService;
import org.bs.ssh.utils.PageContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction{
	
	@Resource
	private UserService userService;
	private User user;
	
	public String approval()throws Exception{
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		String username = request.getParameter("username");
		User user = userService.findByUsername(username);
		PrintWriter out = response.getWriter();
		if (user != null)
			out.write("1");
		else
			out.write("0");
		out.flush();
		out.close();
		return null;
	}
	public String approvalusername()throws Exception{
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		String truestr = "{\"success\":\"true\"}";
		String falsestr = "{\"success\":\"false\"}";
		String username = request.getParameter("username");
		User user = userService.findByUsername(username);
		PrintWriter out = response.getWriter();
		if (user != null)
			out.write(truestr);
		else
			out.write(falsestr);
		out.flush();
		out.close();
		return null;
	}
	public String validate()throws Exception{
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		String username = request.getParameter("username");
		User user = userService.findByUsername(username);
		PrintWriter out = response.getWriter();
		if (user != null)
			out.write("1");
		else
			out.write("0");
		out.flush();
		out.close();
		return null;
	}
	public String getId()throws Exception{
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		User user = (User) request.getSession().getAttribute("login_user");
		PrintWriter out = response.getWriter();
		if (user != null)
			out.write("" + user.getId());
		else
			out.write("请重新登录");
		out.flush();
		out.close();
		return null;
	}
	public String view(){
		int id = ((User) request.getSession().getAttribute("login_user")).getId();
		User user = userService.findById(id);
		request.setAttribute("user", user);
		return "view_user";
	}
	public String users(){
		ServletContext application = request.getSession().getServletContext();
		List<User> users = new ArrayList<User>();
		for (HttpSession s : (List<HttpSession>) application
				.getAttribute("sessionList")) {
			try {
				users.add((User) s.getAttribute("login_user"));
			} catch (Exception e) {
			}
		}
		request.setAttribute("users", users);
		request.setAttribute("page", PageContext.getPage());
		return "user_list";
	}
	
	
	public Object getModel() {
		if(user == null){
			user = new User();
		}
		return user;
	}
}
