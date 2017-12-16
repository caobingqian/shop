package org.bs.ssh.model;

public class Search {
	private int id=0;
	private String type="backend";
	private String string="";
	private String authorityName="";
	private String authorityValue="";
	private String namesearch="";
	private String goodsClassifysearch="";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getAuthorityValue() {
		return authorityValue;
	}
	public void setAuthorityValue(String authorityValue) {
		this.authorityValue = authorityValue;
	}
	public String getNamesearch() {
		return namesearch;
	}
	public void setNamesearch(String namesearch) {
		this.namesearch = namesearch;
	}
	public String getGoodsClassifysearch() {
		return goodsClassifysearch;
	}
	public void setGoodsClassifysearch(String goodsClassifysearch) {
		this.goodsClassifysearch = goodsClassifysearch;
	}
	@Override
	public String toString() {
		return "Search [ id=" + id + ",type=" + type + ", string=" + string
				+ ", authorityName=" + authorityName + ", authorityValue="
				+ authorityValue + ", namesearch=" + namesearch + ", goodsClassifysearch=" + goodsClassifysearch + "]";
	}
	
} 
