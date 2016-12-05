package com.gmail.whwan09.service;

import java.util.ArrayList;

import com.gmail.whwan09.entities.Member;

public interface MemberDao {
	public int insertRow(Member member);
	public int selectCount( String id );
	public Member selectOne( String id );
	public ArrayList<Member> selectAll();
	public int updateRow(Member member);
	public int deleteRow( String id );
	public Member selectLogin(Member member);
}
