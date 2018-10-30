package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;

public interface BoardServiceInf {

	/**
	* Method : selectBoard
	* 작성자 : pc24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 아이디를 받아 해당 게시판 조회
	*/
	List<BoardVo> selectBoard(String userId);
	

	/**
	* Method : selectBoardAllList
	* 작성자 : pc24
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 리스트 조회
	*/
	public List<BoardVo> selectBoardAllList();
	
	/**
	* Method : insertBoard
	* 작성자 : pc24
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 추가 메서드
	*/
	public int insertBoard(Map<String, Object> param);
	
	/**
	* Method : updateBoard
	* 작성자 : pc24
	* 변경이력 :
	* @param param
	* @return
	* Method 설명 : 게시판 수정 메서드
	*/
	public int updateBoard(Map<String, Object> param);

}
