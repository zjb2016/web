
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserMgr;

@WebServlet("/hello")
  public class LoginServlet extends HttpServlet { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		processRequest(request,response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request,response);
		
	}

	public void init() throws ServletException {
		System.out.println("error init!");
	}	
	
	private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		UserMgr userMgr = new UserMgr();
		
		int result = -2;
		result = userMgr.verifyUser(username, password);//用户类型
		String priv = "" + result;
		switch (result) {
		case -2://错误就刷新
			request.getRequestDispatcher("login.html").forward(request, response);
			break;
		case -1://错误就刷新
			request.getRequestDispatcher("login.html").forward(request, response);
			break;
		case 0://买家界面
			session.setAttribute("priv", priv);
			session.setAttribute("user", username);
			request.getRequestDispatcher("/buyer/main.jsp").forward(request, response);
			break;
		case 1://卖家界面
			session.setAttribute("priv", priv);
			session.setAttribute("user", username);
			request.getRequestDispatcher("/seller/main.jsp").forward(request, response);
			break;
		case 2://管理员界面
			session.setAttribute("priv", priv);
			session.setAttribute("user", username);
			request.getRequestDispatcher("/admin/main.jsp").forward(request, response);
		}
			
	}



}
