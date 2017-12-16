package org.bs.ssh.service.impl;

import java.util.List;
import javax.annotation.Resource
;import org.springframework.stereotype.Service;
import org.bs.ssh.dao.NewsDao;
import org.bs.ssh.model.News;
import org.bs.ssh.model.Search;
import org.bs.ssh.service.NewsService;

@Service("newsService")
public class NewsServiceImpl extends BaseServiceImpl implements NewsService {
	@Resource
	NewsDao newsDao ;
	public void add(News news) {
		newsDao.save(news);
	}

	public void delete(News news) {
		newsDao.delete(news);
	}

	public void update(News news) {
		newsDao.update(news);
	}

	public News findById(int id) {
		return newsDao.getById(id);
	}

	public News findByUserId(int id) {
		return newsDao.getByUserId(id);
	}

	public List<News> search(Search search) {
		return newsDao.query(search);
	}

}
