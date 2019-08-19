package com.boogie.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.member.dto.MemberDto;

@Component
public class MemberDaoImp implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int memberInsert(MemberDto memberDto) {
		return sqlSession.insert("dao.MemberMapper.memberInsert", memberDto);
	}

	@Override
	public int memberCheckId(String id) {
		return sqlSession.selectOne("dao.MemberMapper.memberCheckId", id);
	}

	@Override
	public int memberLoginOk(String id, String password) {
		Map<String, String> hMap=new HashMap<String, String>();
		hMap.put("id", id);
		hMap.put("password", password);
		
		return sqlSession.selectOne("dao.MemberMapper.memberLogin", hMap);
	}

	@Override
	public String memberFindId(String name, String email) {
		Map<String, String> hMap=new HashMap<String, String>();
		hMap.put("name", name);
		hMap.put("email", email);
		
		return sqlSession.selectOne("dao.MemberMapper.memberFindId", hMap);
	}

	@Override
	public int memberFindPassword(String member_id, String email, String temporaryPw) {
		
		Map<String, String> hMap=new HashMap<String, String>();
		hMap.put("member_id", member_id);
		hMap.put("email", email);
		hMap.put("temporaryPw", temporaryPw);
		
		return sqlSession.update("dao.MemberMapper.memberFindPassword", hMap);
	}

	@Override
	public MemberDto memberSearch(String id) {
		return sqlSession.selectOne("dao.MemberMapper.memberSearch", id);
	}

	@Override
	public int memberUpdate(MemberDto memberDto) {
		return sqlSession.update("dao.MemberMapper.memberUpdate", memberDto);
	}

	@Override
	public int memberKaKaoInsert(MemberDto memberDto) {
		return sqlSession.insert("dao.MemberMapper.memberKaKaoInsert", memberDto);
	}

	@Override
	public int memberKaKaoUpdate(MemberDto memberDto) {
		return sqlSession.update("dao.MemberMapper.memberKaKaoUpdate", memberDto);
	}

	@Override
	public int memberDelete(String id, String password) {
		Map<String, String> hMap=new HashMap<String, String>();
		hMap.put("id", id);
		hMap.put("password", password);
		
		return sqlSession.delete("dao.MemberMapper.memberDelete", hMap);
	}

	@Override
	public int memberKaKaoDelete(String id) {
		return sqlSession.delete("dao.MemberMapper.memberKaKaoDelete", id);
	}

	@Override
	public int NonMemberAdd(MemberDto memberDto) {
		return sqlSession.insert("dao.MemberMapper.NonMemberAdd",memberDto);
	}

	@Override
	public MemberDto nonMemberOrderDetailSearch(String name, String email) {
		Map<String, String> hMap=new HashMap<String, String>();
		hMap.put("name", name);
		hMap.put("email", email);
		return sqlSession.selectOne("dao.MemberMapper.nonMemberOrder",hMap);
	}
	
}
