package org.bs.ssh.dao;
import java.util.List;
import org.bs.ssh.model.GoodsClassify;
import org.bs.ssh.model.Search;
public interface GoodsClassifyDao {
public void save(GoodsClassify goodsClassify);
public void delete(GoodsClassify goodsClassify);
public void update(GoodsClassify goodsClassify);
public GoodsClassify getById(int id);
public List<GoodsClassify> query(Search search);
public GoodsClassify getByUserId(int id);
}

