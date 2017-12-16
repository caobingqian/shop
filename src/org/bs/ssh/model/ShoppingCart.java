package org.bs.ssh.model;

public class ShoppingCart {
	private int id;
	private int num;
	private int kind;
	private Goods goods;
	private User user;

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", num=" + num + ", kind=" + kind
				+ ", goods=" + goods + ", user=" + user + "]";
	}
}