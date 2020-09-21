package com.bjts.board.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjts.board.dao.board.BoardDao;
import com.bjts.board.domain.board.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public void insertBoard(BoardVO boardVo) {
		boardDao.insertBoard(boardVo);
	}

	@Override
	public BoardVO getBoardInfo(int boardNum) {
		return boardDao.getBoardInfo(boardNum);
	}

	@Override
	public void updateBoard(BoardVO boardVo) {
		boardDao.updateBoard(boardVo);
	}

}
