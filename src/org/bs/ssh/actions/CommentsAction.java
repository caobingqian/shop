package org.bs.ssh.actions;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.bs.ssh.model.Comments;
import org.bs.ssh.service.CommentsService;
import org.bs.ssh.model.Search;import org.bs.ssh.model.User;import org.bs.ssh.utils.PageContext;
import org.bs.ssh.utils.ResultUtils;
import org.bs.ssh.model.Search;
import org.bs.ssh.model.Member;
import org.bs.ssh.service.MemberService;
import org.bs.ssh.model.Search;
import org.bs.ssh.model.Goods;
import org.bs.ssh.service.GoodsService;


@Controller("commentsAction")
@Scope("prototype")
public class CommentsAction extends BaseAction {

	@Resource
	private CommentsService commentsService;
	@Resource
	private MemberService memberService ;
	@Resource
	private GoodsService goodsService ;
	private Comments comments;
	private String url="";
	
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
		commentsService.add(comments);
		return "add_success";
	}

	public String delete(){
		commentsService.delete(commentsService.findById(comments.getId()));
		return "showlist";
	}
	public String deleteBetch(){
		String[] commentsIds = request.getParameterValues("commentsCheckbox");
		for (int i = 0; i < commentsIds.length; i++) {
			commentsService.delete(commentsService.findById(Integer.parseInt(commentsIds[i])));
		}
		return "showlist";
	}

	public String modify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("comments", commentsService.findById(comments.getId()));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		return "update_comments_input";
	}
	public String show(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("comments", commentsService.findById(comments.getId()));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "show";
	}

	public String update(){
		commentsService.update(comments);
		commentsService.sessionFlush();
		commentsService.sessionRefresh(comments);
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
		request.setAttribute("commentsList", commentsService.search(search));
		return "list";
	}

	public String add1(){
		User user = (User) request.getSession().getAttribute("login_user");
		Member member = null;
		if (user != null) {
			member = memberService.findByUserId(user.getId());
		}
		
		comments.setMember(member);
		comments.setSettime(new Date());
		commentsService.add(comments);
		return "url";
	}
	
	
	
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	
	public Object getModel() {
		if(comments == null){
			comments = new Comments();
		}
		return comments;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
}

