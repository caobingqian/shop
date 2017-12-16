package org.bs.ssh.service;

import java.util.List;

import org.bs.ssh.model.GoodsClassify;
import org.bs.ssh.model.Search;

public interface GoodsClassifyService extends BaseService{
	public void add(GoodsClassify goodsClassify);
	public void delete(GoodsClassify goodsClassify);
	public void update(GoodsClassify goodsClassify);
	public GoodsClassify findById(int id);
	public GoodsClassify findByUserId(int id);
	public List<GoodsClassify> search(Search search);
}

