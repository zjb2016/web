package web3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import entity.purchase;

@WebServlet("/Order")
public class purchaseOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			handle(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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

	private void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ServletException {
		
		//获取当前时间
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
			 	
	    String userSno=null;
	    
	    ArrayList<String>ID=new ArrayList<String>();
		//获取买家cookie及商品id
		 Cookie[] cookies=request.getCookies();
		   int size=cookies.length;
		   if( size>0){		      
			   for (int i = 0; i < size; i++){
				   Cookie tCookie=  cookies[i];
		       if(tCookie.getName().equals("JSESSIONID"))
		               continue;
		       if(tCookie.getName().equals("userSno"))
	                   userSno=tCookie.getValue();                                   
		       else
		    	       ID.add(tCookie.getValue());

		          }
			 }
		   else{
			   System.out.println("error no cookie here");
		   }
		
		//连接数据库
			    Connection conn=dbconnect.getConnect();
				Statement stmt=null;
				ResultSet rs=null;	
				

		//查找买家电话
				String buyerPhone=null;
			    String buyer="select phone from table_user where userSno="+userSno;
			    stmt = (Statement) conn.createStatement();
		        rs = stmt.executeQuery(buyer);
		        
		        while(rs.next()){
		        	 buyerPhone=rs.getString("phone");
		        }
		//查找卖家
		        String ownerPhone=null;
		        purchase deal=new purchase(); 
		        for(int j=0;j<ID.size();j++){
				   String Sql="select * from bycycle where bycycleId="+ID.get(j);
				   stmt = (Statement) conn.createStatement();
			       rs = stmt.executeQuery(Sql);
			        while(rs.next()){
			    	   ownerPhone=rs.getString("ownerPhone");
 
			        }
	    //生成订单

		        deal.setBuyer(buyerPhone);
		        deal.setOwner(ownerPhone);
		        deal.setDate(time);
		        deal.setBycycleID(ID.get(j));
		        }
		//关闭数据库
		        dbconnect.clean(conn,stmt,rs);      
		
		
		//订单持久化保存到数据库
		        String insertPurchase = "insert into purchase(userSno,bycycleId,num,date,buyerPhone,ownerPhone)values('"
						+ userSno
						+ "','"
						+ deal.getBycycleID()
						+ "','"
						+ "1"
						+ "','"
						+ time
						+ "','"
						+ deal.getBuyer()
						+ "','"
						+deal.getOwner()+"')";
		        boolean result=false;
		        result=dbconnect.update(insertPurchase);
          if(result)
        	  { System.out.println("succeess generate purchase to db");}
          else
              { System.out.println("error generate purchase to db");}
		
		//跳转到订单管理界面
              response.setContentType("text/html;charset=UTF-8");	
              request.setAttribute("deal", deal);
		      request.getRequestDispatcher("purchaseMgr.jsp").forward(request, response);
	}
	

}
