package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.notice.model.NoticeVo;

public interface NoticeDaoInf {

	public List<BoardVo> boardFreePagingList(Map<String, Object> param);

	public int getNoticeCnt(String notice_board);
	
	public int noticeInsert(Map<String, Object> param);
	
	public NoticeVo getNoticeDetail(String notice_no);

	public int updateNotice(Map<String, Object> param);

	public int deleteNotice(Map<String, Object> param);

	public int insertReply(Map<String, Object> param);
	
	public String getMaxNotice();
}
