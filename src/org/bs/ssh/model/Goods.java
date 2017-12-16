package org.bs.ssh.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;
import javax.persistence.CascadeType;
import org.hibernate.annotations.BatchSize;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.CascadeType;
import org.hibernate.annotations.BatchSize;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_goods")
public class Goods {
	private int id;
	private String name;
	private GoodsClassify goodsClassify;
	private String img;
	private int price;
	private Date settime;
	private String descp;
	private String content;
	private Member member;
	private int nums;
	private List<Comments> comments;
	private List<Orders> orders;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",columnDefinition="int(11) comment '商品id,主键'")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name",columnDefinition="varchar(200) DEFAULT NULL COMMENT '商品名称'")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name="goodsClassify",columnDefinition="int(11) DEFAULT NULL COMMENT '商品分类id,外键'")
	public GoodsClassify getGoodsClassify() {
		return goodsClassify;
	}
	public void setGoodsClassify(GoodsClassify goodsClassify) {
		this.goodsClassify = goodsClassify;
	}
	
	@Column(name="img",columnDefinition="varchar(200) DEFAULT NULL COMMENT '展示图片'")
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Column(name="price",columnDefinition="int(11) DEFAULT NULL COMMENT '价格'")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Column(name="settime",columnDefinition="datetime DEFAULT NULL COMMENT '上架时间'")
	public Date getSettime() {
		return settime;
	}
	public void setSettime(Date settime) {
		this.settime = settime;
	}
	
	@Column(name="descp",columnDefinition="varchar(200) DEFAULT NULL COMMENT '简介'")
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	
	@Column(name="content",columnDefinition="text DEFAULT NULL COMMENT '商品详情'")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@ManyToOne
	@JoinColumn(name="member",columnDefinition="int(11) DEFAULT NULL COMMENT '上传人id,外键'")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@Column(name="nums",columnDefinition="int(11) DEFAULT NULL COMMENT '销量'")
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	
	@BatchSize(size=10)
	@OneToMany(fetch=FetchType.LAZY,mappedBy="goods",cascade={CascadeType.REMOVE})
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
	@BatchSize(size=10)
	@OneToMany(fetch=FetchType.LAZY,mappedBy="goods",cascade={CascadeType.REMOVE})
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", goodsClassify=" + goodsClassify + ", img=" + img + ", price=" + price + ", settime=" + settime + ", descp=" + descp + ", content=" + content + ", member=" + member + ", nums=" + nums+ "]";
	}

}

