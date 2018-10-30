package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Before;
import org.junit.Test;

public class BoardServiceTest {

	private BoardServiceInf boardService;
	
	@Before
	public void before(){
		boardService = new BoardService();
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
		List<BoardVo> boardList = boardService.selectBoard("brown");
		/***Then***/
		assertEquals(1, boardList.size());
	}
	
	/**
	* Method : selectBoardAllList
	* 작성자 : pc24
	* 변경이력 :
	* Method 설명 : 전체 게시판 조회 테스트
	*/
	@Test
	public void selectBoardAllList(){
		/***Given***/

		/***When***/
		List<BoardVo> boardAllList = boardService.selectBoardAllList();
		/***Then***/
		assertEquals(6, boardAllList.size());
	}
	
	@Test
	public void updateBoardTest(){
		/***Given***/
		/***When***/
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("board_name", "준영게시판");
		param.put("board_chk", "0");  
		param.put("board_user", "brown");
		param.put("board_id", "b026"); 
		
		int updateCnt = boardService.updateBoard(param);
		/***Then***/
		assertEquals(1, updateCnt);
	}

}
