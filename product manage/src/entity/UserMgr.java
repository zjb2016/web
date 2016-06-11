package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import db.DBBean;

public class UserMgr { 

	private HashMap<String, User> userList;

	public UserMgr() {
		super();
	}


	public HashMap getUserList() {
		HashMap userList = new HashMap();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		User user = null;
		try {
			conn = DBBean.getConnection();
			String sql = "select * from user_list";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				user = new User(rset.getString("username"), rset.getString("password"),
						rset.getString("realname"), rset.getInt("userType"),
						rset.getInt("sex"));

				userList.put(rset.getString("username"), user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	public int addUser(User newUser) {
		int result = 0; //
		if (findUser(newUser)) {
			result = 1; //
		} else {
			String sql = "insert into user_list(username,password,realname,userType,sex)values('"
					+ newUser.getUsername()
					+ "','"
					+ newUser.getPassword()
					+ "','"
					+ newUser.getRealname()
					+ "','"
					+ newUser.getUserType() + "','" + newUser.getSex() + "')";

			if (DBBean.update(sql)) {
				result = 2; //
			}
		}
		return result;
	}

	public boolean findUser(User user) {
		boolean result = false;
		String sql = "select * from user_list where username=('"
				+ user.getUsername() + "')";
		result = DBBean.hasRecord(sql);
		return result;
	}

	public boolean deleteUser(String username) {
		boolean result = false;
		String sql = "delete from user_list where username=('" + username
				+ "')";
		result = DBBean.delete(sql);
		System.out.println("delete user:" + sql);
		return result;
	}

	public User getUser(String username) {
		String sql = "select * from user_list where username=('" + username
				+ "')";
		User user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DBBean.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while (rset.next()) {
				user = new User(rset.getString("username"),
						rset.getString("password"), rset.getString("realname"),
						rset.getInt("userType"), rset.getInt("sex"));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBBean.clean(conn, stmt, rset);
		}
		return user;
	}

	public int editUser(User user) {
		int result = 1;
		String sql = "update user_list set username ='" + user.getUsername()
				+ "',realname='" + user.getRealname() + "',userType='"
				+ user.getUserType() + "' " + "where username=('"+ user.getUsername() + "')";
		//System.out.println("edit user:" + sql);
		if (DBBean.update(sql)) {
			result = 2; 
		}

		return result;
	}

	public int verifyUser(String username, String password) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		int result = -1;// 初始为-1
		try {
			conn = DBBean.getConnection();
			String sql = "select * from user_list where username='" + username
					+ "' and password='" + password + "'";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if (rset.next()) {
				result = rset.getInt("userType");//result=用户类型
				System.out.println("user type: " + result);
			}
		} catch (SQLException e) {
			System.out.println("SQLException inside verify user");
			e.printStackTrace();

		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
