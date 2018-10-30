package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Test;

public class BoardDaoTest {
	
	private BoardDaoInf boardDao;
	
	@org.junit.Before
	public void Before(){
		boardDao = new BoardDao();
	}
	
	/**
	* Method : selectBoardTest
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 회원별 게시판 조회 테스트
	*/
	@Test
	public void selectBoardTest() {
		/***Given***/

		/***When***/
		List<BoardVo> boardList = boardDao.selectBoard("brown");
		
		/***Then***/
		assertEquals(4, boardList.size());
		
	}
	
	/**
	* Method : selectBoardAllListTest
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 전체 게시판 조회 테스트
	*/
	@Test
	public void selectBoardAllListTest(){
		/***Given***/

		/***When***/
		List<BoardVo> boardAllList = boardDao.selectBoardAllList();
		/***Then***/
		assertEquals(6, boardAllList.size());
	}
		
	/**
	* Method : updateBoard
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 게시판 이름 및 사용여부 수정메서드 테스트
	*/
	@Test
	public void updateBoardTest(){
		/***Given***/

		/***When***/
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("board_name", "준영게시판");
		param.put("board_chk", "0");  
		param.put("board_user", "brown");
		param.put("board_id", "b026");    
		
		int updateCnt = boardDao.updateBoard(param);
		/***Then***/
		assertEquals(1, updateCnt);
	}

}
