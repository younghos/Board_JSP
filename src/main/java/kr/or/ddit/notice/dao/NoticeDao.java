package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.notice.model.NoticeVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class NoticeDao implements NoticeDaoInf{

	public List<BoardVo> boardFreePagingList(Map<String, Object> param){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BoardVo> pageList = session.selectList("notice.boardFreePagingList", param);
		session.close();
		
		return pageList;
	}

	@Override
	public int getNoticeCnt(String notice_board) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int noticeCnt = session.selectOne("notice.getNoticeCnt", notice_board);
		
		return noticeCnt;
	}

	@Override
	public int noticeInsert(Map<String, Object> param) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int noticeInert = session.insert("notice.noticeInsert", param);
		session.commit();
		session.close();
		
		return noticeInert;
	}

	@Override
	public NoticeVo getNoticeDetail(String notice_no) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		NoticeVo noticeVo = session.selectOne("notice.getNoticeDetail", notice_no);
		session.close();
		
		return noticeVo;
	}

	@Override
	public int updateNotice(Map<String, Object> param) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int noticeUpdate = session.update("notice.noticeUpdate", param);
		session.commit();
		session.close();
		
		return noticeUpdate;
	}

	@Override
	public int deleteNotice(Map<String, Object> param) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int noticeDelete = session.update("notice.noticeDelete", param);
		session.commit();
		session.close();
		
		return noticeDelete;
	}

	@Override
	public int insertReply(Map<String, Object> param) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int noticeInert = session.insert("notice.replyInsert", param);
		session.commit();
		session.close();
		
		return noticeInert;
	}

	@Override
	public String getMaxNotice() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		String notice_no = session.selectOne("notice.maxNotice");
		session.close();
		
		return notice_no;
	}

}
