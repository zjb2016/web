package solr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import solr.dbconnect;

public class indexbuilder {
	public static void buildIndex() throws SQLException, SolrServerException, IOException{
		
		//连接solr				
		String url = "http://localhost:8983/solr/jane";
		SolrServer  HttpSolrServer=new HttpSolrServer(url);
		
		ArrayList<SolrInputDocument> list=new ArrayList<SolrInputDocument>();
		//查询数据库
		String str="select pinpai,xinghao,chengse,id from bycycle";
			
		 Connection conn=dbconnect.getConnection();
		 Statement stmt = null;
	     ResultSet rset = null;
	     try {
			 stmt = conn.createStatement();
			 rset = stmt.executeQuery(str);
			 conn.commit();
		} catch (SQLException e) {
			System.out.println("there is a fault of sql.");
			e.printStackTrace();
		}
	     

		while(rset.next()){
			
			SolrInputDocument doc = new SolrInputDocument();
			
			doc.addField("pinpai", rset.getString("pinpai"));
			doc.addField("xinghao",rset.getString("xinghao"));
			doc.addField("chengse",rset.getInt("chengse"));
			doc.addField("id", rset.getString("id"));
			
			list.add(doc);
			
		}
		dbconnect.clean(conn, stmt, rset);
		HttpSolrServer.add(list);
		HttpSolrServer.commit();
		HttpSolrServer.commit(true,true);
		}



	}

