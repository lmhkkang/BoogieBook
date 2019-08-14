package com.boogie.member.dao;

import com.boogie.member.dto.MemberDto;

public interface MemberDao {
	public int memberInsert(MemberDto memberDto);
	public int memberCheckId(String id);
	public int memberLoginOk(String id, String password);
	public String memberFindId(String name, String email);
	public int memberFindPassword(String id, String email, String  temporaryPw);
	public MemberDto memberSearch(String id);
	public int memberUpdate(MemberDto memberDto);
	public int memberKaKaoInsert(MemberDto memberDto);
	public int memberKaKaoUpdate(MemberDto memberDto);
	public int memberDelete(String id, String password);
	public int memberKaKaoDelete(String id);
	public int NonMemberAdd(MemberDto memberDto);
}