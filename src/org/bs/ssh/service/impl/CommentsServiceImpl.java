package org.bs.ssh.service.impl;

import java.util.List;
import javax.annotation.Resource
;import org.springframework.stereotype.Service;
import org.bs.ssh.dao.CommentsDao;
import org.bs.ssh.model.Comments;
import org.bs.ssh.model.Search;
import org.bs.ssh.service.CommentsService;

@Service("commentsService")
public class CommentsServiceImpl extends BaseServiceImpl implements CommentsService {
	@Resource
	CommentsDao commentsDao ;
	public void add(Comments comments) {
		commentsDao.save(comments);
	}

	public void delete(Comments comments) {
		commentsDao.delete(comments);
	}

	public void update(Comments comments) {
		commentsDao.update(comments);
	}

	public Comments findById(int id) {
		return commentsDao.getById(id);
	}

	public Comments findByUserId(int id) {
		return commentsDao.getByUserId(id);
	}

	public List<Comments> search(Search search) {
		return commentsDao.query(search);
	}

}
