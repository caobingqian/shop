package org.bs.ssh.service.impl;

import java.util.List;
import javax.annotation.Resource
;import org.springframework.stereotype.Service;
import org.bs.ssh.dao.SiteDao;
import org.bs.ssh.model.Site;
import org.bs.ssh.model.Search;
import org.bs.ssh.service.SiteService;

@Service("siteService")
public class SiteServiceImpl extends BaseServiceImpl implements SiteService {
	@Resource
	SiteDao siteDao ;
	public void add(Site site) {
		siteDao.save(site);
	}

	public void delete(Site site) {
		siteDao.delete(site);
	}

	public void update(Site site) {
		siteDao.update(site);
	}

	public Site findById(int id) {
		return siteDao.getById(id);
	}

	public Site findByUserId(int id) {
		return siteDao.getByUserId(id);
	}

	public List<Site> search(Search search) {
		return siteDao.query(search);
	}

}
