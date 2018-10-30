package kr.or.ddit.comment.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comment.service.CommentService;
import kr.or.ddit.comment.service.CommentServiceInf;
import kr.or.ddit.user.model.UserVo;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet(urlPatterns={"/commentInsert", "/commentDelete"})
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		if(uri.equals("/commentInsert")){
			commentInsert(request, response);
		} else if(uri.equals("/commentDelete")){
			commentDelete(request, response);
		}
		
	}

	private void commentDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ct_id = request.getParameter("ct_id");
		String ct_notice = request.getParameter("ct_notice");
		
		CommentServiceInf service = new CommentService();
		
		int commentDelete = service.commentDelete(ct_id);
		
		request.setAttribute("ct_id", ct_id);
		request.setAttribute("ct_notice", ct_notice);
		
		if(commentDelete != 0){
			response.sendRedirect("/noticeDetail?notice_no="+ct_notice);
		} 
		
	}

	private void commentInsert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String ct_notice = request.getParameter("ct_notice");
		UserVo userVo = (UserVo) request.getSession().getAttribute("S_USER");
		String ct_user = userVo.getUserId();
		String ct_content = request.getParameter("ct_content");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ct_notice", ct_notice);
		param.put("ct_user", ct_user);
		param.put("ct_content", ct_content);
		
		CommentServiceInf service = new CommentService();
		
		int commentCnt = service.commentInsert(param);
		
		if(commentCnt != 0){
			response.sendRedirect("/noticeDetail?notice_no="+ct_notice);
		} 
		
	}

}
