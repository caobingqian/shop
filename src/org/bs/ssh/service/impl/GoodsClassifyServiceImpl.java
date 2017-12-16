package org.bs.ssh.service.impl;

import java.util.List;
import javax.annotation.Resource
;import org.springframework.stereotype.Service;
import org.bs.ssh.dao.GoodsClassifyDao;
import org.bs.ssh.model.GoodsClassify;
import org.bs.ssh.model.Search;
import org.bs.ssh.service.GoodsClassifyService;

@Service("goodsClassifyService")
public class GoodsClassifyServiceImpl extends BaseServiceImpl implements GoodsClassifyService {
	@Resource
	GoodsClassifyDao goodsClassifyDao ;
	public void add(GoodsClassify goodsClassify) {
		goodsClassifyDao.save(goodsClassify);
	}

	public void delete(GoodsClassify goodsClassify) {
		goodsClassifyDao.delete(goodsClassify);
	}

	public void update(GoodsClassify goodsClassify) {
		goodsClassifyDao.update(goodsClassify);
	}

	public GoodsClassify findById(int id) {
		return goodsClassifyDao.getById(id);
	}

	public GoodsClassify findByUserId(int id) {
		return goodsClassifyDao.getByUserId(id);
	}

	public List<GoodsClassify> search(Search search) {
		return goodsClassifyDao.query(search);
	}

}
