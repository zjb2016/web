package entity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import db.DBBean;

public class productMgr {
	private HashMap<String, bycycle> productList;
	
//得到产品信息
public HashMap getProductList() {
		
		HashMap productList = new HashMap();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		bycycle bycycle = null;
		
		try {
			conn = DBBean.getConnection();
			String sql = "select * from bycycle";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while (rset.next()) {
				bycycle = new bycycle();
				
				String brand=rset.getString("pinpai"); 
				String price=rset.getString("price");
				String type=rset.getString("xinghao");
				String chengse=	rset.getString("chengse");
				String id=rset.getString("id");
					
				bycycle.setBrand(brand);
				bycycle.setChengse(chengse);
				bycycle.setId(id);
				bycycle.setPrice(price);
				bycycle.setType(type);
				

				productList.put(rset.getString("pinpai"),bycycle);
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
		return productList;
	}
//寻找产品
public boolean findProduct(bycycle bike) {
			boolean result = false;
			String sql = "select * from bycycle where pinpai=('"
					+ bike.getBrand() + "')";
			result = DBBean.hasRecord(sql);
			return result;
		}
	
//添加产品
public int addProduct(bycycle bike) {
		int result = 0; //
		
		if (findProduct(bike)) 
		{ result = 1; }
		
			String sql = "insert into bycycle(pinpai,price,xinghao,chengse)values('"
					+ bike.getBrand()
					+ "','"
					+ bike.getPrice()
					+ "','"
					+ bike.getType()
					+ "','"
					+ bike.getChengse()+ "')";

			if (DBBean.update(sql)) {
				result = 2; 
			}
		
		return result;
	}
//搜索产品,返回一个bycycle对象
public bycycle searchProduct(String  brand) {
		
	String sql = "select * from bycycle where pinpai=('" + brand
			+ "')";
	bycycle bycycle = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;

	try {
		conn = DBBean.getConnection();
		stmt = conn.createStatement();
		rset = stmt.executeQuery(sql);
	
		while (rset.next()) {
			bycycle = new bycycle();
			      				
					String brand1=rset.getString("pinpai"); 
					String price=rset.getString("price");
					String type=rset.getString("xinghao");
					String chengse=	rset.getString("chengse");
					String id=rset.getString("id");
						
					bycycle.setBrand(brand1);
					bycycle.setChengse(chengse);
					bycycle.setId(id);
					bycycle.setPrice(price);
					bycycle.setType(type);
					

		}

	} catch (SQLException e) {
		e.printStackTrace();

	} finally {
		DBBean.clean(conn, stmt, rset);
	}
	return bycycle;
}
//删除产品
public boolean deleteProduct(String brand,String type) {
	boolean result = false;
	String sql = "delete from  bycycle where pinpai='" +brand +"'AND xinghao='" +type+"'";
	result = DBBean.delete(sql);
	if(result){
	System.out.println("delete user:" + sql);}
	else{
		System.out.println("error delete in productMgr 123 hang");	
	}
	return result;
}

public bycycle getproduct(String brand,String type) {
	String sql = "select * from bycycle where pinpai='" +brand +"'AND xinghao='" +type+"'";
	bycycle bycycle = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;

	try {
		conn = DBBean.getConnection();
		stmt = conn.createStatement();
		rset = stmt.executeQuery(sql);
	
		while (rset.next()) {
			bycycle = new bycycle();
				
			String brand1=rset.getString("pinpai"); 
			String price=rset.getString("price");
			String type1=rset.getString("xinghao");
			String chengse=	rset.getString("chengse");
			String id=rset.getString("id");
				
			bycycle.setBrand(brand1);
			bycycle.setChengse(chengse);
			bycycle.setId(id);
			bycycle.setPrice(price);
			bycycle.setType(type1);

	}} catch (SQLException e) {
		e.printStackTrace();

	} finally {
		DBBean.clean(conn, stmt, rset);
	}
	return bycycle;
}

public int editProduct(bycycle bike,bycycle old) {
	int result = 1;
	String sql = "update bycycle set pinpai ='" +bike.getBrand()
			+ "',price='" + bike.getPrice() + "',xinghao='"
			+ bike.getType() + "' " 
			+ "where pinpai='" +old.getBrand() +"'AND xinghao='" +old.getType()+"'";
	
	System.out.println("edit user:" + sql);
	if (DBBean.update(sql)) {
		result = 2; 
	}

	return result;
}

}
