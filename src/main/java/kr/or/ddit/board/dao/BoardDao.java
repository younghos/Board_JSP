package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.SqlFactoryBuilder;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao implements BoardDaoInf{

	@Override
	public List<BoardVo> selectBoard(String userId) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BoardVo> boardList = session.selectList("board.selectBoard", userId); 
		session.close();
		
		return boardList;
	}

//	@Override
//	public int getBoardCnt(Map<String, Object> param) {
//		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
//		SqlSession session = factory.openSession();
//		
//		int totalBoardCnt = session.selectOne("board.getUserCnt", param);
//		session.close();
//		
//		return totalBoardCnt;
//	}

	@Override
	public List<BoardVo> selectBoardAllList() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BoardVo> boardList = session.selectList("board.selectBoardAllList"); 
		session.close();
		
		return boardList;
	}

	@Override
	public int insertBoard(Map<String, Object> param) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("board.insertBoard", param);
		session.commit();
		session.close();
		
		return insertCnt;
	}
	
	@Override
	public int updateBoard(Map<String, Object> param) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("board.updateBoard", param);
		session.commit();
		session.close();
		
		return updateCnt;
	}


}
