package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

@WebServlet("/dditLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServiceInf service = new UserService();
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		String rememberChk = request.getParameter("remember-me");
		
		if(rememberChk == null){
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("remember") || cookie.getName().equals("userId")){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		} else{
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userId_cookie = new Cookie("userId", userId);
			
			response.addCookie(cookie);
			response.addCookie(userId_cookie);
		}
		UserVo userVo = service.selectUser(userId);
		
		boolean check = false;
		check = userVo.authPass(userPw);
		
		
//		String encryptPass = KISA_SHA256.encrypt(userPw); // 비밀번호 암호화 적용
//		check = userVo.authPass(encryptPass);
		
		if(userVo != null && check != false){
			HttpSession session = request.getSession();
			session.setAttribute("S_USER", userVo);
			
			BoardServiceInf b_service = new BoardService();
			List<BoardVo> boardList = b_service.selectBoardAllList();
			
			for(BoardVo bv : boardList){
				System.out.println("boardList : "+bv.getBoard_id());
			}
			
			getServletContext().setAttribute("boardList", boardList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
		} else{
			response.sendRedirect("login/login.jsp");
		}
	}

}
