package web3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

@WebServlet("/shoppingCart")
public class shoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingCart() {
        super();}
   	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		//从商品列表获得所选商品的id，生成cookie
		  String id=request.getParameter("id");
		  String cookieName="Cart"+id; 
		  
		  Cookie cookie = new Cookie(cookieName, id); 
		
		//cookie的生存期设为 2 mins 
		  cookie.setMaxAge(60*2);
		// 设置路径（默认）  
		  cookie.setPath("/"); 
		  response.addCookie(cookie);
		  
		  String[] ID = new String[6]; 
		
		 // 获取与该域相关的 Cookies 的数组
		   Cookie[] cookies=request.getCookies();
		   if(cookies==null){
			   request.getRequestDispatcher("/erroe.jsp").forward(request, response);
		   }
		   int size=cookies.length;
		   if( size>0){
		      
			   for (int i = 0; i < size; i++){
				   Cookie tCookie=  cookies[i];
				
		            if(tCookie.getName().equals("JSESSIONID"))
		               continue;   
		            
		            else{
		               
		    	       ID[i]=tCookie.getValue();
		               
		      }
		            }
	      
		//连接数据库
		  try {
			List<Map<String,Object>>mycart = new ArrayList<Map<String,Object>>();
			Connection conn=dbconnect.getConnect();
			Statement stmt=null;
			ResultSet rs=null;
			 
			for(int j=0;j<cookies.length;j++){
			
				String SqlString="select * from bycycle where bycycleId="+ID[j];
			     stmt = (Statement) conn.createStatement();
			     rs = stmt.executeQuery(SqlString);
			
			    while(rs.next()){
				      String brand=rs.getString(1);
				      String price=rs.getString(2);
				      String type=rs.getString(3);
				
				      Map<String,Object> temp = new HashMap<String,Object>();   
				
				      temp.put("brand",brand);
				      temp.put("price",price);
				      temp.put("type",type);
				      temp.put("num","1");
				      
				      mycart.add(temp);
			         }
			  }
			
			//关闭数据库
			    dbconnect.clean(conn,stmt,rs);
	            request.setAttribute("mycart", mycart);
	            
	    // 设置响应内容类型
	    response.setContentType("text/html;charset=UTF-8");	
	    request.getRequestDispatcher("/cartResult.jsp").forward(request, response);
		
		  } catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			   }
			}
	}
		
		
			
			  
			  
		 
	

