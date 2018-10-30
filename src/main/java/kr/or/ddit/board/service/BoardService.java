package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf{

	BoardDaoInf boardDao = new BoardDao();
	
	@Override
	public List<BoardVo> selectBoard(String userId) {
		
		List<BoardVo> boardList = boardDao.selectBoard(userId);
		
		if(boardList == null){
			return null;
		}
		
		return boardList;
	}
	

	@Override
	public List<BoardVo> selectBoardAllList() {
		return boardDao.selectBoardAllList();
	}

	@Override
	public int insertBoard(Map<String, Object> param) {
		return boardDao.insertBoard(param);
	}

	@Override
	public int updateBoard(Map<String, Object> param) {
		return boardDao.updateBoard(param);
	}

}
