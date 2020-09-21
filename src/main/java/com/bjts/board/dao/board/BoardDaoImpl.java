package com.bjts.board.dao.board;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bjts.board.domain.board.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace="com.bjts.board.dao.board.BoardDao";
	
	@Override
	public List<BoardVO> getBoardInfo() {
	
		return sqlSession.selectList(namespace + ".getBoardInfo");
	}

	@Override
	public BoardVO getBoardView(int boardNum) {
		
		return sqlSession.selectOne(namespace + ".getBoardView", boardNum);
	}

	@Override
	public void deleteBoard(int boardNum) {
		
		sqlSession.delete(namespace + ".deleteBoard", boardNum);
	}

}