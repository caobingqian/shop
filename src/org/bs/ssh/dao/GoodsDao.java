package org.bs.ssh.dao;
import java.util.List;
import org.bs.ssh.model.Goods;
import org.bs.ssh.model.Search;
public interface GoodsDao {
public void save(Goods goods);
public void delete(Goods goods);
public void update(Goods goods);
public Goods getById(int id);
public List<Goods> query(Search search);
public Goods getByUserId(int id);
}

