package org.bs.ssh.ztest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

public class zTest extends TestCase {
	public void test() {
		// private UserService userService;
		// private MemberService memberService;
		//
		// public void approval(HttpServletRequest request,
		// HttpServletResponse response) throws ServletException, IOException {
		//
		// int id = Integer.parseInt(request.getParameter("id"));
		// String id2 = request.getParameter("id2");
		//
		// User user = (User) request.getSession().getAttribute("login_user");
		// Member member = memberService.findByUserId(user.getId());
		//
		// int pagesize = PageContext.getPage().getPageSize();
		// int pageno = PageContext.getPage().getPageNo();
		// PageContext.getPage().setPageSize(10000);
		//
		// PageContext.getPage().setPageSize(pagesize);
		// PageContext.getPage().setPageNo(pageno);
		// request.setAttribute("page", PageContext.getPage());
		//
		// // List<ShoppingCart> shoppingCarts = (List<ShoppingCart>) request
		// // .getSession().getAttribute("shoppingCarts");
		// // request.getSession().setAttribute("prices", "");
		// // request.getSession().setAttribute("count", "");
		//
		// response.sendRedirect("");
		//
		// }
		//
		// public void approvalusername(HttpServletRequest request,
		// HttpServletResponse response) throws ServletException, IOException {
		// response.setContentType("application/json;charset=UTF-8");
		// response.setHeader("Cache-Control", "no-cache");
		// String truestr = "{\"success\":\"true\"}";
		// String falsestr = "{\"success\":\"false\"}";
		// String username = request.getParameter("username");
		// User user = userService.findByUserName(username);
		// PrintWriter out = response.getWriter();
		// if (user != null)
		// out.write(truestr);
		// else
		// out.write(falsestr);
		// out.flush();
		// out.close();
		// }
		//
		//
		// public void view(HttpServletRequest request, HttpServletResponse
		// response)
		// throws ServletException, IOException {
		// int id = ((User) request.getSession().getAttribute("login_user"))
		// .getId();
		// User user = userService.findById(id);
		// request.setAttribute("user", user);
		// request.getRequestDispatcher("/backend/user/view_user.jsp").forward(
		// request, response);
		// }
		//
		// public void validate(HttpServletRequest request,
		// HttpServletResponse response) throws ServletException, IOException {
		// response.setContentType("text/plain");
		// response.setHeader("Cache-Control", "no-cache");
		// String username = request.getParameter("username");
		// User user = userService.findByUserName(username);
		// PrintWriter out = response.getWriter();
		// if (user != null)
		// out.write("1");
		// else
		// out.write("0");
		// out.flush();
		// out.close();
		// }
		//
		// public void getId(HttpServletRequest request, HttpServletResponse
		// response)
		// throws ServletException, IOException {
		// response.setContentType("text/html");
		// response.setHeader("Cache-Control", "no-cache");
		// User user = (User) request.getSession().getAttribute("login_user");
		// PrintWriter out = response.getWriter();
		// if (user != null)
		// out.write("" + user.getId());
		// else
		// out.write("请重新登录");
		// out.flush();
		// out.close();
		// }
		//
		// // public void getName(HttpServletRequest request, HttpServletResponse
		// // response)
		// // throws ServletException, IOException {
		// // response.setContentType("text/plain");
		// // response.setHeader("Cache-Control", "no-cache");
		// // User user = (User) request.getSession().getAttribute("login_user");
		// // PrintWriter out = response.getWriter();
		// // if (user.getName() != null)
		// // out.write(user.getName());
		// // else
		// // out.write("当前用户未输入真实姓名");
		// // out.flush();
		// // out.close();
		// // }
		//
		// public void addInput(HttpServletRequest request,
		// HttpServletResponse response) throws ServletException, IOException {
		// request.getRequestDispatcher("/backend/user/add_user.jsp").forward(
		// request, response);
		// }
		//
		// @Override
		// public void add(HttpServletRequest request, HttpServletResponse response)
		// throws ServletException, IOException {
		// String password = request.getParameter("password");
		// User user = ResultUtils.copyParams(User.class, request);
		// user.setPassword(password);
		// userService.add(user);
		// if (user.getRole().getId() == 2)
		// request.getRequestDispatcher("/backend/user/add_user_success1.jsp")
		// .forward(request, response);
		// if (user.getRole().getId() == 3)
		// request.getRequestDispatcher("/backend/user/add_user_success.jsp")
		// .forward(request, response);
		// }
		//
		// @Override
		// public void delete(HttpServletRequest request, HttpServletResponse
		// response)
		// throws ServletException, IOException {
		// int id = Integer.parseInt(request.getParameter("id"));
		// userService.delete(id);
		// request.getRequestDispatcher("/backend/UserServlet?method=list")
		// .forward(request, response);
		// }
		//
		// @Override
		// public void modify(HttpServletRequest request, HttpServletResponse
		// response)
		// throws ServletException, IOException {
		// int id = Integer.parseInt(request.getParameter("id"));
		// request.setAttribute("user", userService.findById(id));
		// request.getRequestDispatcher("/backend/user/user_update_input.jsp")
		// .forward(request, response);
		// }
		//
		// @Override
		// public void update(HttpServletRequest request, HttpServletResponse
		// response)
		// throws ServletException, IOException {
		// User user = ResultUtils.copyParams(User.class, request);
		// userService.update(user);
		// request.getRequestDispatcher("/backend/UserServlet?method=list")
		// .forward(request, response);
		// }
		//
		// public void present(HttpServletRequest request, HttpServletResponse
		// response)
		// throws ServletException, IOException {
		// User user = (User) request.getSession().getAttribute("login_user");
		// ;
		// // user.setPresent(user.getPresent()+1);
		// userService.present(user);
		// }
		//
		// @Override
		// public void list(HttpServletRequest request, HttpServletResponse
		// response)
		// throws ServletException, IOException {
		// String key = request.getParameter("key");
		// if (key == null) {
		// key = "";
		// }
		// request.setAttribute("userList", userService.search(key));
		// request.setAttribute("page", PageContext.getPage());
		// request.getRequestDispatcher("/backend/user/user_list.jsp").forward(
		// request, response);
		// }
		//
		// public void presentList(HttpServletRequest request,
		// HttpServletResponse response) throws ServletException, IOException {
		// String key = request.getParameter("key");
		// if (key == null) {
		// key = "";
		// }
		// request.setAttribute("userList", userService.searchPresent(key));
		// request.setAttribute("page", PageContext.getPage());
		// request.getRequestDispatcher("/backend/DC/present/present_list.jsp")
		// .forward(request, response);
		// }
		//
		// public void deleteBetch(HttpServletRequest request,
		// HttpServletResponse response) throws ServletException, IOException {
		// String[] userIds = request.getParameterValues("userCheckbox");
		// if (userIds != null) {
		// for (int i = 0; i < userIds.length; i++) {
		// userService.delete(Integer.parseInt(userIds[i]));
		// }
		// }
		// request.getRequestDispatcher("/backend/UserServlet?method=list")
		// .forward(request, response);
		// }
		//
		// public void setUserService(UserService userService) {
		// this.userService = new JDBCHandler<UserService>()
		// .createProxy(userService);
		// }
	}
}
