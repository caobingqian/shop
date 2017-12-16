package org.bs.ssh.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_news")
public class News {
	private int id;
	private String name;
	private String img;
	private String settime;
	private String descp;
	private String content;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",columnDefinition="int(11) comment '新闻公告id,主键'")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name",columnDefinition="varchar(200) DEFAULT NULL COMMENT '标题'")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="img",columnDefinition="varchar(200) DEFAULT NULL COMMENT '展示图片'")
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Column(name="settime",columnDefinition="varchar(200) DEFAULT NULL COMMENT '发布时间'")
	public String getSettime() {
		return settime;
	}
	public void setSettime(String settime) {
		this.settime = settime;
	}
	
	@Column(name="descp",columnDefinition="varchar(200) DEFAULT NULL COMMENT '摘要'")
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	
	@Column(name="content",columnDefinition="text DEFAULT NULL COMMENT '内容'")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString() {
		return "News [id=" + id + ", name=" + name + ", img=" + img + ", settime=" + settime + ", descp=" + descp + ", content=" + content+ "]";
	}

}

