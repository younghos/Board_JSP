package kr.or.ddit.comment.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.comment.model.CommentVo;
import kr.or.ddit.db.SqlFactoryBuilder;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CommentDao implements CommentDaoInf{

	@Override
	public int commentInsert(Map<String, Object> param) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int commentInsert = session.insert("comment.commentInsert", param);
		session.commit();
		session.close();
		
		return commentInsert;
	}

	@Override
	public List<CommentVo> noticeCommentList(String notice_no) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<CommentVo> ctList = session.selectList("comment.noticeComment", notice_no);
		session.close();
		
		return ctList;
	}

	@Override
	public int commentDelete(String ct_id) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int commentDelete = session.update("comment.commentDelete", ct_id);
		session.commit();
		session.close();
		
		return commentDelete;
	}

}
