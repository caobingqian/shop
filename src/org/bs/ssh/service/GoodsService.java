package org.bs.ssh.service;

import java.util.List;

import org.bs.ssh.model.Goods;
import org.bs.ssh.model.Search;

public interface GoodsService extends BaseService{
	public void add(Goods goods);
	public void delete(Goods goods);
	public void update(Goods goods);
	public Goods findById(int id);
	public Goods findByUserId(int id);
	public List<Goods> search(Search search);
}

