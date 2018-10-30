package kr.or.ddit.comment.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.comment.model.CommentVo;

public interface CommentServiceInf {

	/**
	* Method : commentInsert
	* 작성자 : pc24
	* 변경이력 :
	* @param param
	* @return
	* Method 설명 : 댓글 등록
	*/
	public int commentInsert(Map<String, Object> param);

	/**
	* Method : noticeCommentList
	* 작성자 : pc24
	* 변경이력 :
	* @param notice_no
	* @return
	* Method 설명 : 게시글당 댓글 리스트 조회
	*/
	public List<CommentVo> noticeCommentList(String notice_no);

	/**
	* Method : commentDelete
	* 작성자 : pc24
	* 변경이력 :
	* @param ct_id
	* @return
	* Method 설명 : 댓글 삭제
	*/
	public int commentDelete(String ct_id);
	
	
}
