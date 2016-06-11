package web3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbconnect {

	public static Connection getConnect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://localhost/test?user=root&useUnicode=true&characterEncoding=utf-8";
		Connection conn= DriverManager.getConnection(url);
	        if(conn==null)
		       System.out.println("incorrect Connection!");
	           return conn;
	   }
	
	public static void clean(Connection conn,Statement stmt, ResultSet rset) {
		try{
			if(rset != null)
				rset.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新数据库记录
	 * @param sql
	 * @return
	 */
	public static boolean update(String sql) {
		boolean result = false;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			result = true;
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			clean(conn,stmt,rset);
		}
		return result;
	}
	
}
