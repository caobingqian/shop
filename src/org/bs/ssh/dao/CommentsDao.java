package org.bs.ssh.dao;
import java.util.List;
import org.bs.ssh.model.Comments;
import org.bs.ssh.model.Search;
public interface CommentsDao {
public void save(Comments comments);
public void delete(Comments comments);
public void update(Comments comments);
public Comments getById(int id);
public List<Comments> query(Search search);
public Comments getByUserId(int id);
}

