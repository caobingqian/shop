package org.bs.ssh.actions;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import javax.annotation.Resource;
import java.io.IOException;
import org.apache.commons.beanutils.BeanUtils;
import org.bs.ssh.model.Member;
import org.bs.ssh.service.MemberService;
import org.bs.ssh.model.Search;import org.bs.ssh.model.User;import org.bs.ssh.utils.PageContext;
import org.bs.ssh.utils.ResultUtils;
import org.bs.ssh.model.Search;
import org.bs.ssh.model.User;
import org.bs.ssh.service.UserService;
import  java.io.File;
import  jxl.Workbook;
import  jxl.write.Label;
import java.util.List;
import jxl.format.VerticalAlignment;
import jxl.format.Alignment;
import jxl.write.WritableCellFormat;
import jxl.CellView;
import jxl.write.WritableFont;
import jxl.format.UnderlineStyle;
import org.bs.ssh.utils.SystemFunction;
import  jxl.write.WritableSheet;
import  jxl.write.WritableWorkbook;


@Controller("memberAction")
@Scope("prototype")
public class MemberAction extends BaseAction {

	@Resource
	private MemberService memberService;
	@Resource
	private UserService userService ;
	private Member member;

	
	public String addInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("usersList", userService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "add_input";
	}
	public String add(){
		memberService.add(member);
		return "add_success";
	}

	public String delete(){
		memberService.delete(memberService.findById(member.getId()));
		return "showlist";
	}
	public String deleteBetch(){
		String[] memberIds = request.getParameterValues("memberCheckbox");
		for (int i = 0; i < memberIds.length; i++) {
			memberService.delete(memberService.findById(Integer.parseInt(memberIds[i])));
		}
		return "showlist";
	}

	public String modify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("member", memberService.findById(member.getId()));
		request.setAttribute("usersList", userService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		return "update_member_input";
	}
	public String show(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("member", memberService.findById(member.getId()));
		request.setAttribute("usersList", userService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "show";
	}

	public String update(){
		memberService.update(member);
		memberService.sessionFlush();
		memberService.sessionRefresh(member);
		return "showlist";
	}
	
	public String get(){
		return "get";
	}

	public String list(){
		Search search = ResultUtils.copyParams(Search.class, request);
		User user = (User) request.getSession().getAttribute("login_user");
		if("2".equals(user.getRole().getId()+"")){
				search.setAuthorityName("users");
				search.setAuthorityValue(user.getId()+"");
		}
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("search", search);
		request.setAttribute("usersList", userService.search(search));
		request.setAttribute("memberList", memberService.search(search));
		return "list";
	}
	public String add1() throws Exception{
		User user = new User();
		BeanUtils.copyProperties(user, member);
		user.setRole(member.getRoles());
		String password = request.getParameter("password");
		user.setPassword(password);
		userService.add(user);
		member.setUsers(user);
		memberService.add(member);
		return "add_success";
	}
	public String modify1(){
		User user = (User)request.getSession().getAttribute("login_user");
		request.setAttribute("member", memberService.findByUserId(user.getId()));
		request.setAttribute("userList", userService.search(""));
		return "update_member_input";
	}
	public String dayin(){
		Search search = ResultUtils.copyParams(Search.class, request);
		User user = (User) request.getSession().getAttribute("login_user");
		if("2".equals(user.getRole().getId()+"")){
				search.setAuthorityName("users");
				search.setAuthorityValue(user.getId()+"");
		}
		List<Member> members = memberService.search(search);
		
		String realPath = application.getRealPath("/upload_file");
		String realPathImage = application.getRealPath("/upload_image");
		 try   { 
             //  打开文件  
            WritableWorkbook book  =  Workbook.createWorkbook( new  File( realPath+"/"+"会员信息表.xls" )); 
             //  生成名为“第一页”的工作表，参数 0 表示这是第一页  
            WritableSheet sheet  =  book.createSheet( " 第一页 " ,  0 ); 
			 jxl.write.WritableFont wfcNav =new jxl.write.WritableFont(WritableFont.ARIAL,10, WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
            WritableCellFormat wcfN=new WritableCellFormat(wfcNav);
            wcfN.setAlignment(Alignment.CENTRE); //设置水平对齐
            wcfN.setWrap(true); //设置自动换行
            wcfN.setVerticalAlignment(VerticalAlignment.CENTRE); 
            //设置垂直对齐
             CellView cellView = new CellView();  
			  cellView.setSize(5000); 
			  //设置列宽自动大小
			  //cellView.setAutosize(true);
             //  在 Label 对象的构造子中指名单元格位置是第一列第一行(0,0) 
             //  以及单元格内容为 test  
             //  将定义好的单元格添加到工作表中  
            sheet.setColumnView(0, cellView);
            Label label0  =   new  Label( 0 ,  0 ,  " 主键 " ,wcfN); sheet.addCell(label0); 
            sheet.setColumnView(1, cellView);
            Label label1  =   new  Label( 1 ,  0 ,  " 姓名 " ,wcfN); sheet.addCell(label1); 
            sheet.setColumnView(2, cellView);
            Label label2  =   new  Label( 2 ,  0 ,  " 性别 " ,wcfN); sheet.addCell(label2); 
            sheet.setColumnView(3, cellView);
            Label label3  =   new  Label( 3 ,  0 ,  " 联系电话 " ,wcfN); sheet.addCell(label3); 
            sheet.setColumnView(4, cellView);
            Label label4  =   new  Label( 4 ,  0 ,  " 住址 " ,wcfN); sheet.addCell(label4); 
            sheet.setColumnView(5, cellView);
            Label label5  =   new  Label( 5 ,  0 ,  " 邮箱 " ,wcfN); sheet.addCell(label5); 
            sheet.setColumnView(6, cellView);
            Label label6  =   new  Label( 6 ,  0 ,  " 登录账号 " ,wcfN); sheet.addCell(label6); 
            sheet.setColumnView(7, cellView);
            Label label7  =   new  Label( 7 ,  0 ,  " 商品列表 " ,wcfN); sheet.addCell(label7); 
            sheet.setColumnView(8, cellView);
            Label label8  =   new  Label( 8 ,  0 ,  " 订单列表 " ,wcfN); sheet.addCell(label8); 
            sheet.setColumnView(9, cellView);
            Label label9  =   new  Label( 9 ,  0 ,  " 评论列表 " ,wcfN); sheet.addCell(label9); 
            
            int i = 0;
            for(Member e:members){
            	i+=1;
            	jxl.write.Number llabel0  =   new  jxl.write.Number( 0 ,  i ,  e.getId() ,wcfN); sheet.addCell(llabel0); 
            	Label llabel1  =   new  Label( 1 ,  i ,  e.getName() ,wcfN); sheet.addCell(llabel1); 
            	Label llabel2  =   new  Label( 2 ,  i ,  e.getSex() ,wcfN); sheet.addCell(llabel2); 
            	Label llabel3  =   new  Label( 3 ,  i ,  e.getTel() ,wcfN); sheet.addCell(llabel3); 
            	Label llabel4  =   new  Label( 4 ,  i ,  e.getAddress() ,wcfN); sheet.addCell(llabel4); 
            	Label llabel5  =   new  Label( 5 ,  i ,  e.getEmail() ,wcfN); sheet.addCell(llabel5); 
            	Label llabel6  =   new  Label( 6 ,  i ,  e.getUsers().getUsername() ,wcfN); sheet.addCell(llabel6); 
            }
 
             //  写入数据并关闭文件  
            book.write(); 
            book.close(); 
 
        }   catch  (Exception e)  { 
            System.out.println(e); 
        }  
		
		
		
		request.setAttribute("usersList", userService.search(search));
		request.setAttribute("search", search);
		request.setAttribute("page", PageContext.getPage());
		return "member_dayin_success";
	}
	public String content(){
		int id = Integer.parseInt(request.getParameter("id"));
		Member member = memberService.findById(id);
		request.setAttribute("member", member);

		User user = (User) request.getSession().getAttribute("login_user");

		return "membershow";
	}

	public String add3() throws Exception{
		User user = new User();
		BeanUtils.copyProperties(user, member);
		user.setRole(member.getRoles());
		String password = request.getParameter("password");
		user.setPassword(password);
		userService.add(user);
		member.setUsers(user);
		memberService.add(member);
		return "registsuccess";
	}

	public String modify2(){
		User user = (User) request.getSession().getAttribute("login_user");
		request.setAttribute("member", memberService.findByUserId(user.getId()));
		request.setAttribute("userList", userService.search(""));
		return "member_modify";
	}

	public String info(){
		User user = (User) request.getSession().getAttribute("login_user");
		request.setAttribute("member", memberService.findByUserId(user.getId()));
		request.setAttribute("userList", userService.search(""));
		return "member";
	}

	public String update2(){
		memberService.update(member);
		memberService.sessionFlush();
		memberService.sessionRefresh(member);
		request.setAttribute("member", member);
		return "member";
	}

	public Object getModel() {
		if(member == null){
			member = new Member();
		}
		return member;
	}

	
}

