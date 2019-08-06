package com.boogie.member.dao;

import com.boogie.member.dto.MemberDto;

public interface MemberDao {
	public int memberInsert(MemberDto memberDto);
	public int memberCheckId(String id);
}
