

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
@WebServlet("/productAdd")
public class productAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//获取网页的提交信息
		String brand=request.getParameter("pinpai");
		String xinghao=request.getParameter("xinghao");
		String chengse=request.getParameter("chengse");
		String price=request.getParameter("price");
		String id=request.getParameter("id");
   
		bycycle bike=new bycycle();
		bike.setBrand(brand);
		bike.setChengse(chengse);
		bike.setId(id);
		bike.setPrice(price);
		bike.setType(xinghao);
		
		productMgr add=new productMgr ();
		int result=add.addProduct(bike);//调用产品经理的添加函数
		
		if(result==2){System.out.println("success add product!");}
		else{System.out.println("error:"+result);}//返馈信息
		
		
	}

}
