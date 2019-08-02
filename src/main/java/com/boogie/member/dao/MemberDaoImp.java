package com.boogie.member.dao;

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
	
}
