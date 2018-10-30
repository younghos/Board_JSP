package kr.or.ddit.notice.service;

import java.util.Map;

import kr.or.ddit.notice.model.NoticeVo;

public interface NoticeServiceInf {

	/**
	* Method : boardFreePagingList
	* 작성자 : pc24
	* 변경이력 :
	* @param param
	* @return
	* Method 설명 : 페이징 처리된 게시판리스트 조회
	*/
	public Map<String, Object> boardFreePagingList(Map<String, Object> param);
	
	/**
	* Method : getNoticeCnt
	* 작성자 : pc24
	* 변경이력 :
	* @param notice_board
	* @return
	* Method 설명 : 게시글 총 개수
	*/
	public int getNoticeCnt(String notice_board);
	
	/**
	* Method : noticeInsert
	* 작성자 : pc24
	* 변경이력 :
	* @param param
	* @return
	* Method 설명 : 게시글 등록
	*/
	public int noticeInsert(Map<String, Object> param);
	
	/**
	* Method : getNoticeDetail
	* 작성자 : pc24
	* 변경이력 :
	* @param notice_no
	* @return
	* Method 설명 : 게시글 상세 조회
	*/
	public NoticeVo getNoticeDetail(String notice_no);

	/**
	* Method : updateNotice
	* 작성자 : pc24
	* 변경이력 :
	* @param param
	* @return
	* Method 설명 : 게시글 수정
	*/
	public int updateNotice(Map<String, Object> param);

	/**
	* Method : deleteNotice
	* 작성자 : pc24
	* 변경이력 :
	* @param param
	* @return
	* Method 설명 : 게시글 삭제
	*/
	public int deleteNotice(Map<String, Object> param);

	/**
	* Method : insertReply
	* 작성자 : pc24
	* 변경이력 :
	* @param param
	* @return
	* Method 설명 : 답글 등록
	*/
	public int insertReply(Map<String, Object> param);
	
	/**
	* Method : getMaxNotice
	* 작성자 : pc24
	* 변경이력 :
	* @return
	* Method 설명 : 최상단 게시글 번호 조회
	*/
	public String getMaxNotice();
	
}
