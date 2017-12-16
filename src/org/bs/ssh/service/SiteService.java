package org.bs.ssh.service;

import java.util.List;

import org.bs.ssh.model.Site;
import org.bs.ssh.model.Search;

public interface SiteService extends BaseService{
	public void add(Site site);
	public void delete(Site site);
	public void update(Site site);
	public Site findById(int id);
	public Site findByUserId(int id);
	public List<Site> search(Search search);
}

