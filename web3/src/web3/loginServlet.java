package web3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			handle(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			handle(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void handle(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ServletException, IOException {
		//处理登录
		   String username=request.getParameter("username");
		   String password=request.getParameter("password");
		   
		    Connection conn = null;
			Statement stmt = null;
			ResultSet rset = null;
			int result = -1;// 初始为-1
			try {
				conn = dbconnect.getConnect();
				String sql = "select * from table_user where username='" + username
						+ "' and password='" + password + "'";
				stmt = conn.createStatement();
				rset = stmt.executeQuery(sql);
				
				//登录成功 生成用户cookie
				if (rset.next()) {
					result = rset.getInt("userSno");
					String id= String.valueOf(result);
					System.out.println("user-id: " + id);
					
					Cookie user= new Cookie("userSno", id);
					user.setMaxAge(60*2);
					response.addCookie(user);
					 
				
					//跳转购物界面	
					  response.setContentType("text/html;charset=UTF-8");
					  request.getRequestDispatcher("purchase.html").forward(request, response);
					  System.out.println("返回");
					  return ;
					
					  
				}
				//登录失败
				else{
					System.out.println("登录失败，请注册！");
					request.getRequestDispatcher("/erroe.jsp").include(request, response);	
				}
				
				   
			} catch (SQLException e) {
				System.out.println("SQLException inside verify user");
				e.printStackTrace();

			} finally {
				try {
					rset.close();
					stmt.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			 return;	
	}

}
