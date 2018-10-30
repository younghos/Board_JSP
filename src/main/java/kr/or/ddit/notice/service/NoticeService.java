package kr.or.ddit.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.notice.dao.NoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoInf;
import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.util.model.PageVo;

public class NoticeService implements NoticeServiceInf{

	NoticeDaoInf noticeDao = new NoticeDao();
	
	@Override
	public Map<String, Object> boardFreePagingList(Map<String, Object> param) {
		
		List<BoardVo> boardFreeList = noticeDao.boardFreePagingList(param);

		String notice_board = (String)param.get("notice_board");
		int totalBoardCnt = noticeDao.getNoticeCnt(notice_board);
		System.out.println("totalBoardCnt : "+totalBoardCnt);
		
		PageVo pageVo = (PageVo) param.get("pageVo");
		int pageCnt = (int) Math.ceil(((double)totalBoardCnt / pageVo.getPageSize()));
		System.out.println("pageCnt : "+pageCnt);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("boardFreeList", boardFreeList);
		resultMap.put("pageCnt", pageCnt);
		
		return resultMap;
	}

	@Override
	public int getNoticeCnt(String notice_board) {
		return noticeDao.getNoticeCnt(notice_board);
	}

	@Override
	public int noticeInsert(Map<String, Object> param) {
		return noticeDao.noticeInsert(param);
	}

	@Override
	public NoticeVo getNoticeDetail(String notice_no) {
		return noticeDao.getNoticeDetail(notice_no);
	}

	@Override
	public int updateNotice(Map<String, Object> param) {
		return noticeDao.updateNotice(param);
		
	}

	@Override
	public int deleteNotice(Map<String, Object> param) {
		return noticeDao.deleteNotice(param);
	}

	@Override
	public int insertReply(Map<String, Object> param) {
		return noticeDao.insertReply(param);
	}

	@Override
	public String getMaxNotice() {
		return noticeDao.getMaxNotice();
	}

}
