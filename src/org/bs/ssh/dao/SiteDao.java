package org.bs.ssh.dao;
import java.util.List;
import org.bs.ssh.model.Site;
import org.bs.ssh.model.Search;
public interface SiteDao {
public void save(Site site);
public void delete(Site site);
public void update(Site site);
public Site getById(int id);
public List<Site> query(Search search);
public Site getByUserId(int id);
}

