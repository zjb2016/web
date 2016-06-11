

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.bycycle;
import entity.productMgr;


@WebServlet("/productSearch")
public class productSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public productSearch() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());		
		 //doPost(request, response);
		
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html");
		
		 String condition=request.getParameter("condition");
		 productMgr search=new productMgr();
		 bycycle bike=search.searchProduct(condition);//调用产品经理的搜索函数
		// System.out.println("your result:"+bike.getBrand());
		
		 request.setAttribute("bike",bike);
		 request.getRequestDispatcher("/buyer/searchResult.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 
		
		doGet(request, response);
		
		
	
	}

}
