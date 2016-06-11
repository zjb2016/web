

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.bycycle;
import entity.productMgr;


@WebServlet("/productEdit")
public class productEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public productEdit() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		bycycle oldbike=(bycycle) request.getSession().getAttribute("bike") ;
		
		String brand=request.getParameter("pinpai");
		String xinghao=request.getParameter("xinghao");
		String chengse=request.getParameter("chengse");
		String price=request.getParameter("price");
		String id=request.getParameter("id");
		
		bycycle newbike=new bycycle();
			
		newbike.setBrand(brand);
		newbike.setChengse(chengse);
		newbike.setId(id);
		newbike.setPrice(price);
		newbike.setType(xinghao);
		productMgr edit=new productMgr ();
		
		int result=edit.editProduct(newbike, oldbike); 
		if(result==2)
		    {System.out.println("success edit product!");}
		else
		     {System.out.println("error:"+result);}//返馈信息
		
	
	}

}
