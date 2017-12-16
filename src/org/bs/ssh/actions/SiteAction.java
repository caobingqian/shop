package org.bs.ssh.actions;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.bs.ssh.model.Goods;
import org.bs.ssh.model.GoodsClassify;
import org.bs.ssh.model.Member;
import org.bs.ssh.model.Search;
import org.bs.ssh.model.User;
import org.bs.ssh.service.CommentsService;
import org.bs.ssh.service.GoodsClassifyService;
import org.bs.ssh.service.GoodsService;
import org.bs.ssh.service.MemberService;
import org.bs.ssh.service.NewsService;
import org.bs.ssh.service.OrdersService;
import org.bs.ssh.utils.PageContext;
import org.bs.ssh.utils.ResultUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller("siteAction")
@Scope("prototype")
public class SiteAction extends BaseAction {

	@Resource
	private OrdersService ordersService ;
	@Resource
	private GoodsService goodsService ;
	@Resource
	private GoodsClassifyService goodsClassifyService ;
	@Resource
	private NewsService newsService ;
	@Resource
	private MemberService memberService ;
	@Resource
	private CommentsService commentsService ;
	
	
	
	
	
	public String orders(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("orders", ordersService.findById(search.getId()));
	return "orders";
	}
	
	public String orderss(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		String strid = request.getParameter("searchid");
		String name = request.getParameter("str");
		int id = 0;
		if (!"".equals(strid) && strid != null)
			id = Integer.parseInt(strid);
		
		
//		User user = (User) request.getSession().getAttribute("login_user");
//		
//		Member member = null;
//		if (user != null) {
//			member = memberService.findByUserId(user.getId());
//		}
//		
//		
//		
//		List<Classify> classifies = classifyService.search(search);
//		List<Classify> classifies2 = new ArrayList<Classify>();
//		List<Datasheet> datasheets = datasheetService.search(search);
//		
//		for (Datasheet g : datasheets) {
//			for (Classify gc : classifies) {
//				if (g.getClassify().getId() == gc.getId()) {
//					if ("".equals(name) || name == null) {
//						gc.getDatasheets().add(g);
//					} else {
//						if (g.getName().contains(name)) {
//							gc.getDatasheets().add(g);
//						}
//					}
//				}
//			}
//		}
//		for (Classify gc : classifies) {
//			if (gc.getId() == id) {
//				classifies2.add(gc);
//			}
//		}
//		request.setAttribute("classifies", classifies);
//		request.setAttribute("classifies2", classifies2);
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
	return "orderss";
	}
	
	public String goods(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		Goods goods = goodsService.findById(search.getId());
		goods.setNums(goods.getNums()+1);
		goodsService.update(goods);
		request.setAttribute("goods", goods);
	return "goods";
	}
	
	public String goodss(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		String strid = request.getParameter("searchid");
		String name = request.getParameter("str");
		int id = 0;
		if (!"".equals(strid) && strid != null)
			id = Integer.parseInt(strid);
		
		
//		User user = (User) request.getSession().getAttribute("login_user");
//		
//		Member member = null;
//		if (user != null) {
//			member = memberService.findByUserId(user.getId());
//		}
//		
//		
//		
//		List<Classify> classifies = classifyService.search(search);
//		List<Classify> classifies2 = new ArrayList<Classify>();
//		List<Datasheet> datasheets = datasheetService.search(search);
//		
//		for (Datasheet g : datasheets) {
//			for (Classify gc : classifies) {
//				if (g.getClassify().getId() == gc.getId()) {
//					if ("".equals(name) || name == null) {
//						gc.getDatasheets().add(g);
//					} else {
//						if (g.getName().contains(name)) {
//							gc.getDatasheets().add(g);
//						}
//					}
//				}
//			}
//		}
//		for (Classify gc : classifies) {
//			if (gc.getId() == id) {
//				classifies2.add(gc);
//			}
//		}
//		request.setAttribute("classifies", classifies);
//		request.setAttribute("classifies2", classifies2);
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
	return "goodss";
	}
	
	public String goodsClassify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		GoodsClassify goodsClassifies = goodsClassifyService.findById(search.getId());
		if(search.getString().equals("price")){
			Collections.sort(goodsClassifies.getGoods(), new Price());
		}
		if(search.getString().equals("nums")){
			Collections.sort(goodsClassifies.getGoods(), new Nums());
		}
		request.setAttribute("goodsClassify", goodsClassifies);
	return "goodsClassify";
	}
	
	public String goodsClassifys(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		String strid = request.getParameter("searchid");
		String name = request.getParameter("str");
		int id = 0;
		if (!"".equals(strid) && strid != null)
			id = Integer.parseInt(strid);
		
		
//		User user = (User) request.getSession().getAttribute("login_user");
//		
//		Member member = null;
//		if (user != null) {
//			member = memberService.findByUserId(user.getId());
//		}
//		
//		
//		
//		List<Classify> classifies = classifyService.search(search);
//		List<Classify> classifies2 = new ArrayList<Classify>();
//		List<Datasheet> datasheets = datasheetService.search(search);
//		
//		for (Datasheet g : datasheets) {
//			for (Classify gc : classifies) {
//				if (g.getClassify().getId() == gc.getId()) {
//					if ("".equals(name) || name == null) {
//						gc.getDatasheets().add(g);
//					} else {
//						if (g.getName().contains(name)) {
//							gc.getDatasheets().add(g);
//						}
//					}
//				}
//			}
//		}
//		for (Classify gc : classifies) {
//			if (gc.getId() == id) {
//				classifies2.add(gc);
//			}
//		}
//		request.setAttribute("classifies", classifies);
//		request.setAttribute("classifies2", classifies2);
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
	return "goodsClassifys";
	}
	
	public String news(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("news", newsService.findById(search.getId()));
	return "news";
	}
	
	public String newss(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		String strid = request.getParameter("searchid");
		String name = request.getParameter("str");
		int id = 0;
		if (!"".equals(strid) && strid != null)
			id = Integer.parseInt(strid);
		
		
//		User user = (User) request.getSession().getAttribute("login_user");
//		
//		Member member = null;
//		if (user != null) {
//			member = memberService.findByUserId(user.getId());
//		}
//		
//		
//		
//		List<Classify> classifies = classifyService.search(search);
//		List<Classify> classifies2 = new ArrayList<Classify>();
//		List<Datasheet> datasheets = datasheetService.search(search);
//		
//		for (Datasheet g : datasheets) {
//			for (Classify gc : classifies) {
//				if (g.getClassify().getId() == gc.getId()) {
//					if ("".equals(name) || name == null) {
//						gc.getDatasheets().add(g);
//					} else {
//						if (g.getName().contains(name)) {
//							gc.getDatasheets().add(g);
//						}
//					}
//				}
//			}
//		}
//		for (Classify gc : classifies) {
//			if (gc.getId() == id) {
//				classifies2.add(gc);
//			}
//		}
//		request.setAttribute("classifies", classifies);
//		request.setAttribute("classifies2", classifies2);
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
	return "newss";
	}
	
	public String member(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("member", memberService.findById(search.getId()));
	return "member";
	}
	
	public String members(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		String strid = request.getParameter("searchid");
		String name = request.getParameter("str");
		int id = 0;
		if (!"".equals(strid) && strid != null)
			id = Integer.parseInt(strid);
		
		
//		User user = (User) request.getSession().getAttribute("login_user");
//		
//		Member member = null;
//		if (user != null) {
//			member = memberService.findByUserId(user.getId());
//		}
//		
//		
//		
//		List<Classify> classifies = classifyService.search(search);
//		List<Classify> classifies2 = new ArrayList<Classify>();
//		List<Datasheet> datasheets = datasheetService.search(search);
//		
//		for (Datasheet g : datasheets) {
//			for (Classify gc : classifies) {
//				if (g.getClassify().getId() == gc.getId()) {
//					if ("".equals(name) || name == null) {
//						gc.getDatasheets().add(g);
//					} else {
//						if (g.getName().contains(name)) {
//							gc.getDatasheets().add(g);
//						}
//					}
//				}
//			}
//		}
//		for (Classify gc : classifies) {
//			if (gc.getId() == id) {
//				classifies2.add(gc);
//			}
//		}
//		request.setAttribute("classifies", classifies);
//		request.setAttribute("classifies2", classifies2);
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
	return "members";
	}
	
	public String comments(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("comments", commentsService.findById(search.getId()));
	return "comments";
	}
	
	public String commentss(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		String strid = request.getParameter("searchid");
		String name = request.getParameter("str");
		int id = 0;
		if (!"".equals(strid) && strid != null)
			id = Integer.parseInt(strid);
		
		
//		User user = (User) request.getSession().getAttribute("login_user");
//		
//		Member member = null;
//		if (user != null) {
//			member = memberService.findByUserId(user.getId());
//		}
//		
//		
//		
//		List<Classify> classifies = classifyService.search(search);
//		List<Classify> classifies2 = new ArrayList<Classify>();
//		List<Datasheet> datasheets = datasheetService.search(search);
//		
//		for (Datasheet g : datasheets) {
//			for (Classify gc : classifies) {
//				if (g.getClassify().getId() == gc.getId()) {
//					if ("".equals(name) || name == null) {
//						gc.getDatasheets().add(g);
//					} else {
//						if (g.getName().contains(name)) {
//							gc.getDatasheets().add(g);
//						}
//					}
//				}
//			}
//		}
//		for (Classify gc : classifies) {
//			if (gc.getId() == id) {
//				classifies2.add(gc);
//			}
//		}
//		request.setAttribute("classifies", classifies);
//		request.setAttribute("classifies2", classifies2);
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
	return "commentss";
	}
	
	public String list(){
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		String strid = request.getParameter("searchid");
		String name = request.getParameter("str");
		Search search = ResultUtils.copyParams(Search.class, request);
		int id = 0;
		if (!"".equals(strid) && strid != null)
			id = Integer.parseInt(strid);

		
		
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		request.setAttribute("search", search);
		request.setAttribute("page", PageContext.getPage());

		PageContext.getPage().setPageSize(ps);
		if(!"".equals(name) && name != null){
				return "search";
		}else{
			if ("".equals(strid) || strid == null)
				return "index";
			else
				return "classify";
		}
	}
	public String search(){
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		String strid = request.getParameter("searchid");
		String name = request.getParameter("str");
		Search search = ResultUtils.copyParams(Search.class, request);
		int id = 0;
		if (!"".equals(strid) && strid != null)
			id = Integer.parseInt(strid);
		
		
		
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("commentsList", commentsService.search(search));
		request.setAttribute("search", search);
		request.setAttribute("page", PageContext.getPage());
		search.setNamesearch(name);
		request.setAttribute("goodsList", goodsService.search(search));
		PageContext.getPage().setPageSize(ps);
		return "search";
	}

}
class Price implements Comparator<Goods>{

	public int compare(Goods g1, Goods g2) {
		// TODO Auto-generated method stub
		return g1.getPrice()-g2.getPrice();
	}
	
}
class Nums implements Comparator<Goods>{

	public int compare(Goods g1, Goods g2) {
		// TODO Auto-generated method stub
		return g2.getNums()-g1.getNums();
	}
	
}

