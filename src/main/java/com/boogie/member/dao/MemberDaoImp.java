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
	public int memberMakePassword(String member_id, String newPassword) {
		Map<String, String> hMap=new HashMap<String, String>();
		hMap.put("member_id", member_id);
		hMap.put("newPassword", newPassword);
		
		return sqlSession.update("dao.MemberMapper.memberMakePassword", hMap);
	}
	
}
