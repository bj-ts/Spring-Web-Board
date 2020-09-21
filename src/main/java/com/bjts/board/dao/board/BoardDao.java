package com.bjts.board.dao.board;

import java.util.List;

import com.bjts.board.domain.board.BoardVO;

public interface BoardDao {

	List<BoardVO> getBoardInfo();

	BoardVO getBoardView(int boardNum);

	void deleteBoard(int boardNum);

}
