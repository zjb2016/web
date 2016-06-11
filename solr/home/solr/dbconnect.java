package solr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconnect {
	/**
	 * 创建数据库连接
	 * @return
	 */
	public static Connection getConnection() { 
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/test?user=root&useUnicode=true&characterEncoding=utf-8";
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(false);
		}
		catch (ClassNotFoundException ex1) {
			ex1.printStackTrace();
			return null;
		}
		catch (Exception ex2) {
			ex2.printStackTrace();
			return null;
		}
		
		return conn;
	}
	
	/**
	 * 关闭数据库的连接、语句以及结果集等资源
	 * @param conn
	 * @param stmt
	 * @param rset
	 */

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
	 * 查执行询语句，返回结果集
	 * @param SqlString
	 * @return
	 */ 
	public static ResultSet query(String SqlString) {
		Connection conn = null;
    	Statement stmt = null;
    	ResultSet rset = null;
    	
    	try {
    		conn = getConnection();
			stmt = conn.createStatement();			
		    rset = stmt.executeQuery(SqlString);	
		    conn.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();			
		} finally{
			
			clean(conn,stmt,rset);
		}
    	 return rset;
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
			conn = getConnection();
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
	
	/**
	 * 删除数据库记录
	 * @param sql
	 * @return
	 */
	public static boolean delete(String sql) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.execute(sql);
			result = true;
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			clean(conn,stmt,rset);
		}
		return result;
	}

}
