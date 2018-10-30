package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 무효화
		
		// 1. session 객체 확보
		// servlet 
		// page        :   존재하지 않음
		// request     :   메서드 인자로 제공
		// session     :   request객체에서 제공
		// application :   getServletContext();
		
		// jsp
		// page        :   pageContext
		// request     :   request
		// session     :   session
		// application :   application
		HttpSession session = request.getSession();

		// 2. session invalidate 메서드를 통해 무효화
		session.invalidate();
		
		response.sendRedirect("/login/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
