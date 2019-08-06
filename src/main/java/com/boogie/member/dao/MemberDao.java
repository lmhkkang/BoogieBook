package com.boogie.member.dao;

import com.boogie.member.dto.MemberDto;

public interface MemberDao {
	public int memberInsert(MemberDto memberDto);
	public int memberCheckId(String id);
	public int memberLoginOk(String id, String password);
	public String memberFindId(String name, String email);
	public int memberFindPassword(String id, String email, String  temporaryPw);
	public int memberMakePassword(String id, String newPassword);
}
