package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;

@WebServlet(urlPatterns={"/boardCreate", "/boardUpdate", "/boardInsert"})
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		
		// 게시판 생성 버튼 클릭 시 
		BoardServiceInf service = new BoardService();
		
		String userId = request.getParameter("userId");
		
		System.out.println("userId : " + userId);
		
		List<BoardVo> boardList = service.selectBoardAllList();
		List<BoardVo> selectList = service.selectBoard(userId);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("selectList", selectList);
		
		request.getRequestDispatcher("/board/boardCreate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		
		if(uri.equals("/boardCreate")){
			boardCreate(request, response);
		} else if (uri.equals("/boardUpdate")){
			boardUpdate(request, response);
		} else if (uri.equals("/boardInsert")){
			boardInsert(request, response);
		}
	}

	private void boardInsert(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String board_id = request.getParameter("board_id");
		request.setAttribute("board_id", board_id);
		
		request.getRequestDispatcher("/board/boardInsert.jsp").forward(request, response);
		
	}

	private void boardUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String board_name = request.getParameter("boardName");
		int board_chk = Integer.parseInt(request.getParameter("check"));
		UserVo userVo = (UserVo) request.getSession().getAttribute("S_USER");
		String board_id = request.getParameter("boardId");
		
		String board_user = userVo.getUserId();
		
		System.out.println("boardUpdate board_name : " + board_name);
		System.out.println("boardUpdate board_chk : " + board_chk);
		System.out.println("boardUpdate board_user : "+ board_user);
		
		Map<String, Object> board = new HashMap<String, Object>();
		board.put("board_name", board_name);
		board.put("board_chk", board_chk);
		board.put("board_user", board_user);
		board.put("board_id", board_id);
		
		BoardServiceInf service = new BoardService();
		
		int updateCnt = service.updateBoard(board);
		
		if(updateCnt != 0 ){
			List<BoardVo> boardList = service.selectBoardAllList();
			getServletContext().setAttribute("boardList", boardList);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/board/boardCreate.jsp");
		}
		
	}

	private void boardCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		
		String board_name = request.getParameter("boardName");
		int board_chk = Integer.parseInt(request.getParameter("check"));
		UserVo userVo = (UserVo) request.getSession().getAttribute("S_USER");
		
		String board_user = userVo.getUserId();
		
		System.out.println("boardCreate board_name : " + board_name);
		System.out.println("boardCreate board_chk : " + board_chk);
		System.out.println("boardCreate board_user : "+ board_user);
		
		BoardServiceInf service = new BoardService();
		
		Map<String, Object> board = new HashMap<String, Object>();
		board.put("board_name", board_name);
		board.put("board_chk", board_chk);
		board.put("board_user", board_user);
		
		int insertCnt = service.insertBoard(board);
		
		if(insertCnt != 0){
			List<BoardVo> boardList = service.selectBoardAllList();
			getServletContext().setAttribute("boardList", boardList);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/board/boardCreate.jsp");
		}
		
	}

}
