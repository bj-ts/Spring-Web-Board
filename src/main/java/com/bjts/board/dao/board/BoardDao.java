package com.bjts.board.dao.board;

import com.bjts.board.domain.board.BoardVO;

public interface BoardDao {

	void insertBoard(BoardVO boardVo);

	BoardVO getBoardInfo(int boardNum);

	void updateBoard(BoardVO boardVo);

}
