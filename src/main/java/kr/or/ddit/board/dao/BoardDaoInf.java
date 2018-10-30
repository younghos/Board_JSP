package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;

public interface BoardDaoInf {

	List<BoardVo> selectBoard(String userId);

//	int getBoardCnt(Map<String, Object> param);

	List<BoardVo> selectBoardAllList();
	
	int insertBoard(Map<String, Object> param);
	
	int updateBoard(Map<String, Object> param);
}
