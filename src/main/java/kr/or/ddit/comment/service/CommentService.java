package kr.or.ddit.comment.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.comment.dao.CommentDao;
import kr.or.ddit.comment.dao.CommentDaoInf;
import kr.or.ddit.comment.model.CommentVo;

public class CommentService implements CommentServiceInf{

	CommentDaoInf commentDao = new CommentDao();
	
	@Override
	public int commentInsert(Map<String, Object> param) {
		return commentDao.commentInsert(param);
	}

	@Override
	public List<CommentVo> noticeCommentList(String notice_no) {
		return commentDao.noticeCommentList(notice_no);
	}

	@Override
	public int commentDelete(String ct_id) {
		return commentDao.commentDelete(ct_id);
	}

}
