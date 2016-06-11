

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.bycycle;
import entity.productMgr;

/**
 * Servlet implementation class productAdd
 */
@WebServlet("/productDelete")
public class productDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public productDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//获取网页的提交信息
		String brand=request.getParameter("brand");
		String xinghao=request.getParameter("type");
		
   
		
		productMgr mgr=new productMgr ();
		boolean result=mgr.deleteProduct(brand,xinghao);//调用产品经理的添加函数
		
		if(result){System.out.println("success delete product!");}
	 	else{System.out.println("error delete!");}//返馈信息
		
		
	}

}
