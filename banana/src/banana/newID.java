package banana;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createNew")
public class newID extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String USERS="C:/Users/lianx/Desktop";//储存地址
    
    public newID() {
        super();

    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String code=request.getParameter("try");
		
		String resultpage1="success.view";
		String resultpage2="fail.view";
		String resultpage3="wrongps.view";
		 
		
		if(!code.equals("7364")){
			//error catch
			request.getRequestDispatcher(resultpage2).forward(request, response);
		}
		else{
			//createUserData(phone,password);
			if(!password.equals("123456"))
				request.getRequestDispatcher(resultpage3).forward(request, response);
			else{
				 createUserData(password,phone);
			     request.getRequestDispatcher(resultpage1).forward(request, response);
		}
			}
		
		//doGet(request, response);
	}

	private void createUserData(String password,String phone) throws IOException{
		// TODO Auto-generated method stub
		File userhome=new File(USERS+"/"+"client_info");
		userhome.mkdir();
		BufferedWriter writer=new BufferedWriter(new FileWriter(userhome+"profile"));
		writer.write("用户："+phone+"\t"+"密码："+password);
		writer.close();
	}
	
	//private void createUserData(String phone,String pass)throws IOException{
		
		
	}


