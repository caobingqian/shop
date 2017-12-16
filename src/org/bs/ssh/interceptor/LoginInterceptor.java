package org.bs.ssh.interceptor;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class LoginInterceptor extends AbstractInterceptor {
	
	private String[] urlPatterns = null;
	private String[] escapeUrls = null;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);  
		HttpSession session = request.getSession();
		
//		ServletContext application = (ServletContext) invocation.getInvocationContext().get(ServletActionContext.SERVLET_CONTEXT);  
//		String urlPattern = application.getInitParameter("urlPattern");
//		String escape = application.getInitParameter("escape");
//		urlPattern.replace('，', ',');
//		escape.replace('，', ',');
//		urlPatterns = urlPattern.split(",");
//		escapeUrls = escape.split(",");
		
		
		String url = request.getRequestURI();
		if (isIntercept(url)) {
			if (session.getAttribute("login_user") == null) {
				 return "login_jsp"; //global result
			}
		}
		
		String result = invocation.invoke();//继续执行
		
		//所有拦截器及对应的Action执行完毕返回后的后续处理工作	
		
		return result;

	}
	
	public boolean isIntercept(String url) {
		boolean urlPatternFlag = false;
		boolean escapeFlag = false;

		for (String s : urlPatterns) {
			if (url.indexOf(s) > -1) {
				urlPatternFlag = true;
				break;
			}
		}
		for (String s : escapeUrls) {
			if (url.indexOf(s) > -1) {
				escapeFlag = false;
				break;
			} else {
				escapeFlag = true;
			}
		}
		return urlPatternFlag && escapeFlag;
	}
	
	public String[] getUrlPattern() {
		return urlPatterns;
	}

	public void setUrlPattern(String urlPattern) {
		urlPattern.replace('，', ',');
		this.urlPatterns =  urlPattern.split(",");
	}

	public String[] getEscape() {
		return escapeUrls;
	}

	public void setEscape(String escape) {
		escape.replace('，', ',');
		this.escapeUrls = escape.split(",");
	}

}
