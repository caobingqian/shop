package org.bs.ssh.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.bs.ssh.model.Goods;
import org.bs.ssh.model.Member;
import org.bs.ssh.model.Page;
import org.bs.ssh.model.Search;
import org.bs.ssh.model.ShoppingCart;
import org.bs.ssh.model.User;
import org.bs.ssh.service.GoodsClassifyService;
import org.bs.ssh.service.GoodsService;
import org.bs.ssh.service.MemberService;
import org.bs.ssh.utils.PageContext;
import org.bs.ssh.utils.ResultUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller("goodsAction")
@Scope("prototype")
public class GoodsAction extends BaseAction {

	@Resource
	private GoodsService goodsService;
	@Resource
	private GoodsClassifyService goodsClassifyService ;
	@Resource
	private MemberService memberService ;
	private Goods goods;

	
	public String addInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "add_input";
	}
	public String add(){
		goodsService.add(goods);
		return "add_success";
	}

	public String delete(){
		goodsService.delete(goodsService.findById(goods.getId()));
		return "showlist";
	}
	public String deleteBetch(){
		String[] goodsIds = request.getParameterValues("goodsCheckbox");
		for (int i = 0; i < goodsIds.length; i++) {
			goodsService.delete(goodsService.findById(Integer.parseInt(goodsIds[i])));
		}
		return "showlist";
	}

	public String modify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("goods", goodsService.findById(goods.getId()));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		return "update_goods_input";
	}
	public String show(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("goods", goodsService.findById(goods.getId()));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "show";
	}

	public String update(){
		goodsService.update(goods);
		goodsService.sessionFlush();
		goodsService.sessionRefresh(goods);
		return "showlist";
	}
	
	public String get(){
		return "get";
	}

	public String list(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int pageNo = PageContext.getPage().getPageNo();
		int pageSize = PageContext.getPage().getPageSize();
		User user = (User) request.getSession().getAttribute("login_user");
		Member member = (Member) request.getSession().getAttribute("member");
		if("2".equals(user.getRole().getId()+"")&&search.getType().equals("backend")){
			search.setAuthorityName("member");
			search.setAuthorityValue(member.getId()+"");
		}
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("search", search);
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		PageContext.getPage().setPageNo(pageNo);
		PageContext.getPage().setPageSize(pageSize);
		request.setAttribute("goodsList", goodsService.search(search));
		return "list";
	}
	
	
	public String shoppingCart()throws Exception{
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");

		User user = (User) request.getSession().getAttribute("login_user");
		int id = Integer.parseInt(request.getParameter("id"));
		int num = Integer.parseInt(request.getParameter("num"));
		int kind = Integer.parseInt(request.getParameter("kind"));
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setGoods(goodsService.findById(id));
		shoppingCart.setNum(num);
		shoppingCart.setKind(kind);
		List<ShoppingCart> shoppingCarts = (List<ShoppingCart>) request.getSession().getAttribute("shoppingCarts");
		if (shoppingCarts == null) {
			shoppingCarts = new ArrayList<ShoppingCart>();
		}
		
		shoppingCarts.add(shoppingCart);
		
		int price = 0;
		int count = 0;
		for (ShoppingCart s : shoppingCarts) {
			count += s.getNum();
			price += s.getNum() * s.getGoods().getPrice();
		}
		// 排除重复
		List<ShoppingCart> shoppingCartNew = new ArrayList<ShoppingCart>();
		for (ShoppingCart s : shoppingCarts) {
			int f = 0;
			for (ShoppingCart sn : shoppingCartNew) {
				if (sn.getGoods().getId() == s.getGoods().getId() ) {
					f = 1;
					sn.setNum(sn.getNum() + s.getNum());
				}
			}
			if (f == 0) {
				shoppingCartNew.add(s);
			}
		} 

		request.getSession().setAttribute("shoppingCarts", shoppingCartNew);
		request.getSession().setAttribute("prices", price);
		request.getSession().setAttribute("count", count);

		PrintWriter out = response.getWriter();
		out.write("{\"back\":\"success\",\"prices\":\"" + price
				+ "\",\"count\":\"" + count + "\"}");
		out.flush();
		out.close();
		return null;
	}
	public String shoppingdelete()throws Exception{
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		User user = (User) request.getSession().getAttribute("login_user");
		int id = Integer.parseInt(request.getParameter("id"));
		List<ShoppingCart> shoppingCarts = null;
		 shoppingCarts = (List<ShoppingCart>) request.getSession().getAttribute("shoppingCarts");
		ShoppingCart shoppingCart = new ShoppingCart();
		for (ShoppingCart s : shoppingCarts) {
			if (s.getGoods().getId() == id) {
				shoppingCart = s;
			}
		}
		shoppingCarts.remove(shoppingCart);

		int price = 0;
		int count = 0;
		for(ShoppingCart s:shoppingCarts){
			if(s.getKind()==0)price += s.getNum() * s.getGoods().getPrice();
			count+=s.getNum();
		}
		request.getSession().setAttribute("prices", price);
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("shoppingCarts", shoppingCarts);

		PrintWriter out = response.getWriter();
		out.write("{\"back\":\"success\"}");
		out.flush();
		out.close();
		return null;
	}
	
	
	

	public Object getModel() {
		if(goods == null){
			goods = new Goods();
		}
		return goods;
	}

	
}

