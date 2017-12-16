package org.bs.ssh.actions;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.bs.ssh.model.Member;
import org.bs.ssh.model.Orders;
import org.bs.ssh.model.Search;
import org.bs.ssh.model.ShoppingCart;
import org.bs.ssh.model.User;
import org.bs.ssh.service.GoodsService;
import org.bs.ssh.service.MemberService;
import org.bs.ssh.service.OrdersService;
import org.bs.ssh.utils.PageContext;
import org.bs.ssh.utils.ResultUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller("ordersAction")
@Scope("prototype")
public class OrdersAction extends BaseAction {

	@Resource
	private OrdersService ordersService;
	@Resource
	private MemberService memberService ;
	@Resource
	private GoodsService goodsService ;
	private Orders orders;

	
	public String addInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "add_input";
	}
	public String add(){
		ordersService.add(orders);
		return "add_success";
	}
	

	public String delete(){
		ordersService.delete(ordersService.findById(orders.getId()));
		return "showlist";
	}
	public String deleteBetch(){
		String[] ordersIds = request.getParameterValues("ordersCheckbox");
		for (int i = 0; i < ordersIds.length; i++) {
			ordersService.delete(ordersService.findById(Integer.parseInt(ordersIds[i])));
		}
		return "showlist";
	}

	public String modify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("orders", ordersService.findById(orders.getId()));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		return "update_orders_input";
	}
	public String show(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("orders", ordersService.findById(orders.getId()));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "show";
	}

	public String update(){
		ordersService.update(orders);
		ordersService.sessionFlush();
		ordersService.sessionRefresh(orders);
		return "showlist";
	}
	
	public String get(){
		return "get";
	}

	public String list(){
		Search search = ResultUtils.copyParams(Search.class, request);
		User user = (User) request.getSession().getAttribute("login_user");
		Member member = (Member) request.getSession().getAttribute("member");
		if("2".equals(user.getRole().getId()+"")&&search.getType().equals("backend")){
			search.setAuthorityName("member");
			search.setAuthorityValue(member.getId()+"");
		}
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("search", search);
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		return "list";
	}
	
	public String add1(){
		User user = (User) request.getSession().getAttribute("login_user");
		Member member = memberService.findByUserId(user.getId());
		
		
		List<ShoppingCart> shoppingCarts = (List<ShoppingCart>) request.getSession().getAttribute("shoppingCarts");
		for (ShoppingCart s : shoppingCarts) {
			Orders orders = new Orders();
			orders.setMember(member);
			orders.setGoods(s.getGoods());
			orders.setSettime(new Date());
			ordersService.add(orders);
		}
		
		request.getSession().removeAttribute("shoppingCarts");
		return "buysuccess";
	}
	
	
	

	public Object getModel() {
		if(orders == null){
			orders = new Orders();
		}
		return orders;
	}

	
}

