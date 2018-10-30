package kr.or.ddit.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.comment.model.CommentVo;
import kr.or.ddit.comment.service.CommentService;
import kr.or.ddit.comment.service.CommentServiceInf;
import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.NoticeServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.StringUtil;
import kr.or.ddit.util.model.PageVo;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet(urlPatterns={"/noticeFree", "/noticeInsert", "/noticeDetail", "/noticeUpdate", "/noticeDelete", "/noticeReply"})
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		
		if(uri.equals("/noticeFree")){
			noticeFree(request, response);
		} else if(uri.equals("/noticeDetail")){
			noticeDetail(request, response);
		} else if(uri.equals("/noticeUpdate")){
			noticeUpdateCt(request, response);
		} else if(uri.equals("/noticeReply")){
			noticeReplyCt(request, response);
		}
		
	}

	
	private void noticeReplyCt(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String notice_no = request.getParameter("notice_no");
		String notice_board = request.getParameter("notice_board");
		String notice_name = request.getParameter("notice_name");
		
		request.setAttribute("notice_no", notice_no);
		request.setAttribute("notice_board", notice_board);
		request.setAttribute("notice_name", notice_name);
		
		request.getRequestDispatcher("/reply/reply.jsp").forward(request, response);
		
	}


	private void noticeUpdateCt(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String notice_no = request.getParameter("notice_no");
		String notice_name = request.getParameter("notice_name");
		String notice_content = request.getParameter("notice_content");
		
		AttachmentServiceInf service = new AttachmentService();
		
		List<AttachmentVo> attachmentList = service.getAttachmemt(notice_no);
					
		request.setAttribute("notice_no", notice_no);
		request.setAttribute("notice_name", notice_name);
		request.setAttribute("notice_content", notice_content);
		request.setAttribute("attachmentList", attachmentList);
		
		request.getRequestDispatcher("/notice/noticeUpdate.jsp").forward(request, response);
	}


	private void noticeDetail(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("noticeDetail");
		String notice_no = request.getParameter("notice_no");
		
		NoticeServiceInf service = new NoticeService();
		NoticeVo noticeVo = service.getNoticeDetail(notice_no);
		
		AttachmentServiceInf at_service = new AttachmentService();
		List<AttachmentVo> attachmentList = at_service.getAttachmemt(notice_no);
		
		for(AttachmentVo av : attachmentList){
			System.out.println("noticeDetail file_name : "+av.getFile_name());
		}
		
		CommentServiceInf ct_service = new CommentService();
		List<CommentVo> ctList = ct_service.noticeCommentList(notice_no);
		
		request.setAttribute("noticeVo", noticeVo);
		request.setAttribute("ctList", ctList);
		request.setAttribute("attachmentList", attachmentList);
		
		request.getRequestDispatcher("/notice/noticeDetail.jsp").forward(request, response);
		
	}


	private void noticeFree(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		PageVo pageVo = new PageVo();
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		String notice_board = request.getParameter("board_id");
		
		NoticeServiceInf service = new NoticeService();
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pageVo", pageVo);
		param.put("notice_board", notice_board);
		
		Map<String, Object> resultMap = service.boardFreePagingList(param);
		
		List<BoardVo> boardFreeList = (List<BoardVo>) resultMap.get("boardFreeList");
		int pageCnt = (int) resultMap.get("pageCnt");
		
		request.setAttribute("boardFreeList", boardFreeList);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("notice_board", notice_board);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/board/boardFree.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		
		if(uri.equals("/noticeInsert")){
			noticeInsert(request, response);
		} else if(uri.equals("/noticeDelete")){
			noticeDelete(request, response);
		} else if(uri.equals("/noticeUpdate")){
			noticeUpdate(request, response);
		} else if(uri.equals("/noticeReply")){
			noticeReply(request, response);
		} 
	}



	private void noticeReply(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String notice_pno = request.getParameter("notice_no");
		String notice_board = request.getParameter("notice_board");
		UserVo userVo = (UserVo) request.getSession().getAttribute("S_USER");
		String notice_user = userVo.getUserId();
		String reply_name = request.getParameter("reply_name");
		String notice_content = request.getParameter("smarteditor");
		
		String[] notice_file = new String[]{"","","","",""};
		
		String[] fileName = new String[]{"","","","",""};
		
		Part[] noticeFile = new Part[5]; 
		int cnt = 0;
		for(int i=0;i<noticeFile.length;i++){
			noticeFile[i] = request.getPart("noticeFile"+i);
			System.out.println("noticeFile"+i+" : "+noticeFile[i]);
			if(noticeFile[i] == null){
				cnt = i;
				break;
			}
			String[] contentDisposition = new String[noticeFile.length]; 
			contentDisposition[i] = noticeFile[i].getHeader("Content-disposition");
			
			String path = getServletContext().getRealPath("/noticefile");
			
			fileName[i] = StringUtil.getFileNAmeFromHeader(contentDisposition[i]);
			
			if(fileName[i].equals("")){
				
			} else{
				noticeFile[i].write(path+File.separator+fileName[i]); // File.separator OS에 알맞은 중간자를 생성해서 넣어줌
				noticeFile[i].delete();
				
				notice_file[i] = "/noticefile/"+fileName[i];
			}
		}
		
		NoticeServiceInf service = new NoticeService();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("notice_pno", notice_pno);
		param.put("notice_board", notice_board);
		param.put("notice_user", notice_user);
		param.put("notice_name", reply_name);
		param.put("notice_content", notice_content);
		
		int insertReply = service.insertReply(param);
		
		AttachmentServiceInf at_service = new AttachmentService();
		
		if(insertReply != 0){
			String notice_no = service.getMaxNotice();
			
			for(int i=0;i<cnt;i++){
				Map<String, Object> param2 = new HashMap<String, Object>();
				param2.put("file_name", fileName[i]);
				param2.put("file_path", notice_file[i]);
				param2.put("file_notice", notice_no);
				
				int atInsert = at_service.attachmentInsert(param2);
			}
			response.sendRedirect("/noticeDetail?notice_no="+notice_no);
		} else {
			response.sendRedirect("/noticeReply?notice_no="+notice_pno+"&notice_board="+notice_board);
		}
		
	}


	private void noticeUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String notice_name =request.getParameter("notice_name");
		String notice_content =request.getParameter("smarteditor");
		String notice_no =request.getParameter("notice_no");
		
		System.out.println("noticeUpdate/Post notice_no = " + notice_no);
		System.out.println("noticeUpdate/Post notice_name = " + notice_name);
		System.out.println("noticeUpdate/Post notice_content = " + notice_content);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("notice_name", notice_name);
		param.put("notice_content", notice_content);
		param.put("notice_no", notice_no);
		
		NoticeServiceInf service = new NoticeService();
		
		request.setAttribute("notice_name", notice_name);
		request.setAttribute("notice_content", notice_content);
		request.setAttribute("notice_no", notice_no);
		
		int noticeUpdate = service.updateNotice(param);
		
		if(noticeUpdate != 0){
			response.sendRedirect("/noticeDetail?notice_no="+notice_no);
		} else{
			response.sendRedirect("/noticeUpdate?notice_no="+notice_no+"&notice_name="+notice_name+"&notice_content="+notice_content);
		}
		 
	}


	private void noticeDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String notice_board = request.getParameter("notice_board");
		String notice_no = request.getParameter("notice_no");
		
		System.out.println("noticeDelete notice_no : " + notice_no );
		System.out.println("noticeDelete notice_board : " + notice_board);
		
		NoticeServiceInf service = new NoticeService();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("notice_no", notice_no);
		
		int noticeDelete = service.deleteNotice(param);
		
		if(noticeDelete != 0){
			response.sendRedirect("/noticeFree?page=1&pageSize=10&board_id="+notice_board);
		} else{
			response.sendRedirect("/noticeDetail?notice_no="+notice_no);
		}
		
	}


	private void noticeInsert(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String notice_name = request.getParameter("noticeName"); // 게시글 제목
		String notice_content = request.getParameter("smarteditor"); // 게시글 내용		
		String notice_board = request.getParameter("boardId"); // 게시판 번호
		UserVo userVo = (UserVo) request.getSession().getAttribute("S_USER"); // 게시글 등록자
		String notice_user = userVo.getUserId();
		
		String[] notice_file = new String[]{"","","","",""};
		
		String[] fileName = new String[]{"","","","",""};
		
		Part[] noticeFile = new Part[5]; 
		int cnt = 0;
		for(int i=0;i<noticeFile.length;i++){
			noticeFile[i] = request.getPart("noticeFile"+i);
			System.out.println("noticeFile"+i+" : "+noticeFile[i]);
			if(noticeFile[i] == null){
				cnt = i;
				break;
			}
			String[] contentDisposition = new String[noticeFile.length]; 
			contentDisposition[i] = noticeFile[i].getHeader("Content-disposition");
			
			String path = getServletContext().getRealPath("/noticefile");
			
			fileName[i] = StringUtil.getFileNAmeFromHeader(contentDisposition[i]);
			
			if(fileName[i].equals("")){
				
			} else{
				noticeFile[i].write(path+File.separator+fileName[i]); // File.separator OS에 알맞은 중간자를 생성해서 넣어줌
				noticeFile[i].delete();
				
				notice_file[i] = "/noticefile/"+fileName[i];
			}
		}
		
		
		System.out.println("noticeInsert notice_name : "+notice_name);
		System.out.println("noticeInsert notice_content : "+notice_content);
		System.out.println("noticeInsert notice_board : "+notice_board);
		System.out.println("noticeInsert notice_user : "+notice_user);
		for(int i=0;i<notice_file.length;i++){
			System.out.println("noticeInsert notice_file"+i+" : "+fileName[i]);
			System.out.println("noticeInsert notice_filePath"+i+" : "+notice_file[i]);
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("notice_name", notice_name);
		param.put("notice_content", notice_content);
		param.put("notice_board", notice_board);
		param.put("notice_user", notice_user);
		
		NoticeServiceInf service = new NoticeService();
		
		AttachmentServiceInf at_service = new AttachmentService();
		
		int insert = service.noticeInsert(param);
		
		if(insert != 0){
			String notice_no = service.getMaxNotice();
			
			for(int i=0;i<cnt;i++){
				Map<String, Object> param2 = new HashMap<String, Object>();
				param2.put("file_name", fileName[i]);
				param2.put("file_path", notice_file[i]);
				param2.put("file_notice", notice_no);
				
				int atInsert = at_service.attachmentInsert(param2);
			}
			
			response.sendRedirect("/noticeDetail?notice_no="+notice_no);
		} else{
			response.sendRedirect("/boardInsert");
		}
	}

}
