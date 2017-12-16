package org.bs.ssh.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.bs.ssh.utils.PageContext;

import com.opensymphony.xwork2.ModelDriven;

public class BaseAction implements ModelDriven{
	
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected HttpServletResponse response = ServletActionContext.getResponse();
	protected HttpSession session = request.getSession();
	protected ServletContext application = session.getServletContext();
	protected String currentURL = request.getRequestURI();
	{
		PageContext.getPage().setPageNo(
				Integer.parseInt(request.getParameter("pageNo") == null
						|| "".equals(request.getParameter("pageNo")) ? "1"
						: request.getParameter("pageNo")));
		PageContext.getPage().setPageSize(
				Integer.parseInt(request.getParameter("pageSize") == null
						|| "".equals(request.getParameter("pageSize")) ? "10"
						: request.getParameter("pageSize")));
		
	}
	public String addInput(){
		return "";
	}
	
	public String add(){
		return "add_success";
	}
	public String delete(){
		return "delete_success";
	}
	public String deleteBetch(){
		return "delete_success";
	}
	public String modify(){
		return "update_role_input";
	}
	public String update(){
		return "update_success";
	}
	
	public String get(){
		return "get";
	}
	public String list(){
		return "list";
	}
	public String execute(){
		return "showlist";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
