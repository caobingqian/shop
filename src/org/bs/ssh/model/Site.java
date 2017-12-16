package org.bs.ssh.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_site")
public class Site {
	private int id;
	private Orders orders;
	private Goods goods;
	private GoodsClassify goodsClassify;
	private News news;
	private Member member;
	private Comments comments;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",columnDefinition="int(11) comment '前台id,主键'")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="orders",columnDefinition="int(11) DEFAULT NULL COMMENT '订单id,外键'")
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	@ManyToOne
	@JoinColumn(name="goods",columnDefinition="int(11) DEFAULT NULL COMMENT '商品id,外键'")
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	@ManyToOne
	@JoinColumn(name="goodsClassify",columnDefinition="int(11) DEFAULT NULL COMMENT '商品分类id,外键'")
	public GoodsClassify getGoodsClassify() {
		return goodsClassify;
	}
	public void setGoodsClassify(GoodsClassify goodsClassify) {
		this.goodsClassify = goodsClassify;
	}
	
	@ManyToOne
	@JoinColumn(name="news",columnDefinition="int(11) DEFAULT NULL COMMENT '新闻公告id,外键'")
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	
	@ManyToOne
	@JoinColumn(name="member",columnDefinition="int(11) DEFAULT NULL COMMENT '会员id,外键'")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@ManyToOne
	@JoinColumn(name="comments",columnDefinition="int(11) DEFAULT NULL COMMENT '评论id,外键'")
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	
	public String toString() {
		return "Site [id=" + id + ", orders=" + orders + ", goods=" + goods + ", goodsClassify=" + goodsClassify + ", news=" + news + ", member=" + member + ", comments=" + comments+ "]";
	}

}

