package org.bs.ssh.service;

import java.util.List;

import org.bs.ssh.model.Member;
import org.bs.ssh.model.Search;

public interface MemberService extends BaseService{
	public void add(Member member);
	public void delete(Member member);
	public void update(Member member);
	public Member findById(int id);
	public Member findByUserId(int id);
	public List<Member> search(Search search);
}

