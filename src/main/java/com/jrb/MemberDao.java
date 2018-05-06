package com.jrb;

import java.util.List;

public interface MemberDao {
	public List<Member> getMembers();
	public void update(Member m);
	public void save(Member m);
}
