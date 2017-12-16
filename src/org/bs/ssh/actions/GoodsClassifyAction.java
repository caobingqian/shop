package org.bs.ssh.actions;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import javax.annotation.Resource;
import java.io.IOException;
import org.apache.commons.beanutils.BeanUtils;
import org.bs.ssh.model.GoodsClassify;
import org.bs.ssh.service.GoodsClassifyService;
import org.bs.ssh.model.Search;import org.bs.ssh.model.User;import org.bs.ssh.utils.PageContext;
import org.bs.ssh.utils.ResultUtils;


@Controller("goodsClassifyAction")
@Scope("prototype")
public class GoodsClassifyAction extends BaseAction {

	@Resource
	private GoodsClassifyService goodsClassifyService;
	private GoodsClassify goodsClassify;

	
	public String addInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "add_input";
	}
	public String add(){
		goodsClassifyService.add(goodsClassify);
		return "add_success";
	}

	public String delete(){
		goodsClassifyService.delete(goodsClassifyService.findById(goodsClassify.getId()));
		return "showlist";
	}
	public String deleteBetch(){
		String[] goodsClassifyIds = request.getParameterValues("goodsClassifyCheckbox");
		for (int i = 0; i < goodsClassifyIds.length; i++) {
			goodsClassifyService.delete(goodsClassifyService.findById(Integer.parseInt(goodsClassifyIds[i])));
		}
		return "showlist";
	}

	public String modify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("goodsClassify", goodsClassifyService.findById(goodsClassify.getId()));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		return "update_goodsClassify_input";
	}
	public String show(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("goodsClassify", goodsClassifyService.findById(goodsClassify.getId()));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "show";
	}

	public String update(){
		goodsClassifyService.update(goodsClassify);
		goodsClassifyService.sessionFlush();
		goodsClassifyService.sessionRefresh(goodsClassify);
		return "showlist";
	}
	
	public String get(){
		return "get";
	}

	public String list(){
		Search search = ResultUtils.copyParams(Search.class, request);
		User user = (User) request.getSession().getAttribute("login_user");
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("search", search);
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		return "list";
	}

	public Object getModel() {
		if(goodsClassify == null){
			goodsClassify = new GoodsClassify();
		}
		return goodsClassify;
	}

	
}

