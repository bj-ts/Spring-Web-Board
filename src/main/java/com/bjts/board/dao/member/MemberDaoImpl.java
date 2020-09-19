package com.bjts.board.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.bjts.board.domain.member.MemberVO;

public class MemberDaoImpl implements MemberDao {

	DataSource dataSource;

	JdbcTemplate template = null;

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace= "com.bjts.board.dao.member.MemberDao";
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public MemberDaoImpl() {
	}
	
	
	
	@Override
	public void join(String userId, String userPassword, String userName, String userNickname,
			String userEmail, String userAddress, String userGender){
		
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String SQL = "INSERT INTO member VALUES(MEMBER_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?,sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				
				pstmt.setString(1, userId);
				pstmt.setString(2, userPassword);
				pstmt.setString(3, userName);
				pstmt.setString(4, userNickname);
				pstmt.setString(5, userEmail);
				pstmt.setString(6, userAddress);
				pstmt.setString(7, userGender);
				
				return pstmt;
			}
		});
		
	}


	@Override
	public String CheckPasswordMatch(String id) {
		
		
		return sqlSession.selectOne(namespace + ".CheckPasswordMatch", id);
	}


	@Override
	public void update_password(String id, String newpassword) {
		
		MemberVO memberVO = new MemberVO();
		memberVO.setUserId(id);
		memberVO.setUserPassword(newpassword);
		
		sqlSession.update(namespace + ".update_password", memberVO);
	}


	@Override
	public void delete(String id) {
		
		sqlSession.delete(namespace + ".delete", id);
		
	}
	
	
	
	
	
	
	
	
}