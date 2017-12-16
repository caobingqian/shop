package org.bs.ssh.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.bs.ssh.dao.UserDao;
import org.bs.ssh.model.User;
import org.bs.ssh.dao.MemberDao;
import org.bs.ssh.dao.impl.MemberDaoImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction{
	
	@Resource
	private UserDao userDao;
	@Resource
	private MemberDao memberDao = new MemberDaoImpl();
	private boolean isSupportCheckCode = ServletActionContext.getServletContext().getInitParameter("isSupportCheckCode").equals("1") ? true: false;;
//	private static Logger logger = Logger.getLogger(LoginAction.class);
	private static Log logger = LogFactory.getLog("login");
	private HttpSession session = request.getSession();
	private ServletContext application = session.getServletContext();
	
	
	public String login() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String key = request.getParameter("key");
		String code = request.getParameter("code");
		String check_code = (String) session.getAttribute("check_code");
		User user = null;
		if (isSupportCheckCode) {
			if (!code.equalsIgnoreCase(check_code)) {
				session.setAttribute("login_error", "验证码输入有误");
				return "login_jsp";
			}
		}
		try {
			user = userDao.login(username, password);
		} catch (RuntimeException e) {
			session.setAttribute("login_error", e.getMessage());
		}
		if (user != null) {
			logger.info(user.getRole().getName() + user.getUsername() + "成功登陆.");
			session.removeAttribute("login_error");
			session.setAttribute("login_user", user);
			if(user.getRole().getId()==2)session.setAttribute("member", memberDao.getByUserId(user.getId()));
			List<HttpSession> sessions = (List<HttpSession>) application.getAttribute("sessionList");
			if (sessions == null || sessions.size() == 0) {
				sessions = new ArrayList<HttpSession>();
			}
			sessions.add(request.getSession(true));
			application.setAttribute("sessionList", sessions);

			return "main_jsp";

		} else {
			return "login_jsp";
		}
		
	}
	public String loginOut() {
		session.invalidate();
		return "login_jsp";
	}
	public String loginf() throws Exception{
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;
		String error = "";
		PrintWriter out = response.getWriter();
		try {
			user = userDao.login(username, password);
		} catch (RuntimeException e) {
			error += e.getMessage();
		}
		if (user != null) {
			logger.info(user.getRole().getName() + user.getUsername() + "成功登陆.");
			session.setAttribute("login_user", user);
			if(user.getRole().getId()==2)session.setAttribute("member", memberDao.getByUserId(user.getId()));
			List<HttpSession> sessions = (List<HttpSession>) application.getAttribute("sessionList");
			if (sessions == null || sessions.size() == 0) {
				sessions = new ArrayList<HttpSession>();
			}
			sessions.add(request.getSession(true));
			application.setAttribute("sessionList", sessions);

			out.write("true");
		} else {
			out.write(error);
		}
		out.flush();
		out.close();
		return "noRedirect";
	}
	public String loginOutf() {
		session.invalidate();
		return "index";
	}
	public String execute(){
		return "login";
	}
	


	
	
}
