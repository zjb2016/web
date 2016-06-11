package web3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public controller() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String ask=	request.getParameter("ask");
        /*	//直接登陆进来，跳转到购物界面
		if(ask==null)
        	{  response.setContentType("utf-8");
        	   request.getRequestDispatcher("purchase.html").include(request, response);	
        	   return ;
        	}
		*/
		
		//选择直接购买 判断是否登录
	    if(ask.equals("2")){
			
	    	//从商品列表获得所选商品的id，生成cookie  
			  String ID=request.getParameter("id");
			  String cookieName="buy"+ID;  
			  Cookie cookie = new Cookie(cookieName, ID); 
			// 设置路径（默认）  
			  cookie.setPath("/"); 
			//cookie的生存期设为 2 mins 
			  cookie.setMaxAge(60*2);
			  response.addCookie(cookie);
			  
	    	 Cookie[] cookies=request.getCookies();
	    	 int size=cookies.length;
			   if( size>0)
			   {
				   
			      for (int i = 0; i < size; i++){
				       Cookie tCookie= cookies[i];
				      //已经登录
				       if(tCookie.getName().equals("userSno"))
				          {
				    	   request.getRequestDispatcher("/Order").forward(request, response);
				    	   return ;
				          }

			         } 
			    //循环一遍，如果找不到userSno，没有登录
	      	       System.out.println("您还没有登录，正在为您跳转登录界面。。。");
	      	       request.getRequestDispatcher("/loginServlet").include(request,response);
	      	      
	              }
    }      
	    //选择购物车，转发给购物车管理
	    if(ask.equals("1")){
	    	request.getRequestDispatcher("/shoppingCart").forward(request, response);	    
	        }
			   
	}

	

}
