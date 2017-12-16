package org.bs.ssh.actions;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import javax.annotation.Resource;
import java.io.IOException;
import org.apache.commons.beanutils.BeanUtils;
import org.bs.ssh.model.News;
import org.bs.ssh.service.NewsService;
import org.bs.ssh.model.Search;import org.bs.ssh.model.User;import org.bs.ssh.utils.PageContext;
import org.bs.ssh.utils.ResultUtils;


@Controller("newsAction")
@Scope("prototype")
public class NewsAction extends BaseAction {

	@Resource
	private NewsService newsService;
	private News news;

	
	public String addInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "add_input";
	}
	public String add(){
		newsService.add(news);
		return "add_success";
	}

	public String delete(){
		newsService.delete(newsService.findById(news.getId()));
		return "showlist";
	}
	public String deleteBetch(){
		String[] newsIds = request.getParameterValues("newsCheckbox");
		for (int i = 0; i < newsIds.length; i++) {
			newsService.delete(newsService.findById(Integer.parseInt(newsIds[i])));
		}
		return "showlist";
	}

	public String modify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("news", newsService.findById(news.getId()));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		return "update_news_input";
	}
	public String show(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("news", newsService.findById(news.getId()));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "show";
	}

	public String update(){
		newsService.update(news);
		newsService.sessionFlush();
		newsService.sessionRefresh(news);
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
		request.setAttribute("newsList", newsService.search(search));
		return "list";
	}

	public Object getModel() {
		if(news == null){
			news = new News();
		}
		return news;
	}

	
}

