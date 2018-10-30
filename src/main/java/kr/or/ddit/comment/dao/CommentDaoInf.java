package kr.or.ddit.comment.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.comment.model.CommentVo;

public interface CommentDaoInf {

	public int commentInsert(Map<String, Object> param);

	public List<CommentVo> noticeCommentList(String notice_no);

	public int commentDelete(String ct_id);

}
