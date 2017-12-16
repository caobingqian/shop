package org.bs.ssh.service;

import java.util.List;

import org.bs.ssh.model.Comments;
import org.bs.ssh.model.Search;

public interface CommentsService extends BaseService{
	public void add(Comments comments);
	public void delete(Comments comments);
	public void update(Comments comments);
	public Comments findById(int id);
	public Comments findByUserId(int id);
	public List<Comments> search(Search search);
}

